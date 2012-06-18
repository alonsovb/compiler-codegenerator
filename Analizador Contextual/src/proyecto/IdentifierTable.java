/*
 * IdentifierTable
 * Creado por Alonso Vega
 * 16 de Mayo, 2012
 */
package proyecto;

import AST.*;
import java_cup.runtime.Symbol;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Alonso
 */
public final class IdentifierTable {

    // Inicio de la lista de identificadores
    Identifier i;
    // Nivel actual para insertar los tokens
    int currentLevel;

    public IdentifierTable() {
        //<editor-fold defaultstate="collapsed" desc=" AST necesarios para construir las funciones ">
        Type chrType = new ATypeSimple(new ASimpleTypeChar());
        Type intType = new ATypeSimple(new ASimpleTypeInt());
        Type arrType = new ATypeArray(new AnArrayType(null));
        AFormalParameterBlock pIntList = new AFormalParameterBlock(new AFormalParameterList(new AFormalParameter(intType, null)));
        AFormalParameterBlock pChrList = new AFormalParameterBlock(new AFormalParameterList(new AFormalParameter(chrType, null)));
        AFormalParameterBlock pArrList = new AFormalParameterBlock(new AFormalParameterList(new AFormalParameter(arrType, null)));
        Expression chrExp = new AnExpressionPrimary(new APrimaryChar(null));
        Expression intExp = new AnExpressionPrimary(new APrimaryInteger(null));
        //</editor-fold>

        // Insertar los métodos predefinidos
        this.enter("chr", new AMethodDeclaration(chrType, null, pIntList, null, null, chrExp));
        this.enter("ord", new AMethodDeclaration(intType, null, pChrList, null, null, intExp));
        this.enter("len", new AMethodDeclaration(intType, null, pArrList, null, null, intExp));
    }

    /**
     * Insertar un identificador en la tabla
     *
     * @param name Nombre del identificador
     * @param attribute Puntero al árbol
     */
    public void enter(String name, AST attribute) {
        Identifier nuevo = new Identifier(name, attribute, currentLevel);
        nuevo._next = i;
        i = nuevo;
    }

    /**
     * Buscar un identificador en la tabla por nombre
     *
     * @param name
     * @return Su atributo si existe, null si no
     */
    public AST retrieve(String name) {
        // Indica hasta cual nivel se ha subido
        int nivelArriba = currentLevel;

        // Primer posición
        Identifier temp = i;
        while (temp != null) {
            // Saltar si el nivel es mayor al subido
            if (temp.level > nivelArriba) {
                temp = temp._next;
                continue;
            }

            // Si el nivel sube (se hace menor), activar la variable y saltar ese identificador
            if (temp.level < nivelArriba) {
                nivelArriba = temp.level;
            }
            // Devolver el que sea igual
            if (temp.name.equals(name)) {
                return temp.attr;
            }
            temp = temp._next;
        }
        // Devolver nulo si se llegó al final y no se encontró
        return null;
    }

    // Busca en la tabla, opcionalmente en toda o por niveles
    public AST retrieve(String name, boolean all) {
        if (all) {
            return retrieveAll(name);
        } else {
            return retrieve(name);
        }
    }

    // Buscar en toda la tabla sin restricciones de nivel
    public AST retrieveAll(String name) {
        // Primer posición
        Identifier temp = i;
        while (temp != null) {
            // Devolver el que sea igual
            if (temp.name.equals(name)) {
                return temp.attr;
            }
            temp = temp._next;
        }
        // Devolver nulo si se llegó al final y no se encontró
        return null;
    }

    // Indica si un elemento está definido en la tabla
    public Boolean exists(String name) {
        AST t = retrieve(name);
        return t != null;
    }

    // Indica si un id existe, opcionalmente buscando en toda la tabla
    public Boolean exists(String name, boolean all) {
        if (all) {
            AST t = retrieve(name, true);
            return t != null;
        } else {
            return exists(name);
        }
    }

    public void openScope() {
        currentLevel++;
    }

    public void closeScope() {
        currentLevel--;
    }

    // Indica si una llamada a un método tiene una lista de expresiones que coincide con los parámetros del método
    public boolean compareParameters(String metodo, FormalParameterList FPL, ExpressionList EL, int nivel, Visitor visitor, Object arg) throws Exception {
        // Revisar si es el ultimo parametro y ultima expresion
        if (FPL.getClass() == AFormalParameterList.class
                && EL.getClass() == AnExpressionList.class) {
            AFormalParameterList param = (AFormalParameterList) FPL;
            AnExpressionList list = (AnExpressionList) EL;
            // Comparar si son del mismo tipo la expresion y el parametro
            String tipoDeclarado = TypeUtilities.getClass(param.fpl0);
            String tipoEnviado = list.e0.visit(visitor, arg).toString();
            if (!tipoDeclarado.equals(tipoEnviado)) {
                throw new Exception(metodo + ": Se esperaba un " + tipoDeclarado + ". Se envió un " + tipoEnviado);
            }
        } // Comparar que 
        else if (FPL.getClass() == AFormalParameterListRest.class
                && EL.getClass() == AnExpressionListRest.class) {
            //Casting para hacer la llamada recursiva
            AFormalParameterListRest AFPR = (AFormalParameterListRest) FPL;
            AnExpressionListRest AELR = (AnExpressionListRest) EL;
            
            nivel++;

            if (AFPR.fpl0.getClass() == AFormalParameterList.class &&
                    AELR.el0.getClass() == AnExpressionList.class) {
                AFormalParameterList param = (AFormalParameterList) AFPR.fpl0;
                AnExpressionList list = (AnExpressionList) AELR.el0;
                // Comparar si son del mismo tipo la expresion y el parametro
                String tipoDeclarado = TypeUtilities.getClass(param.fpl0);
                String tipoEnviado = list.e0.visit(visitor, arg).toString();
                if (!tipoDeclarado.equals(tipoEnviado)) {
                    throw new Exception(metodo + ", parámetro " + nivel + ": Se esperaba un " + tipoDeclarado + ". Se envió un " + tipoEnviado);
                }
            } else if (AFPR.fpl0.getClass() == AFormalParameterListRest.class &&
                    AELR.el0.getClass() == AnExpressionListRest.class) {
                AFormalParameterListRest param = (AFormalParameterListRest) AFPR.fpl0;
                AnExpressionListRest list = (AnExpressionListRest) AELR.el0;
                compareParameters(metodo, param, list, nivel, visitor, arg);
            } else {
                throw new Exception(metodo + ": La cantidad de parámetros no coincide.");
            }
            // Realiza la llamada recursiva 
            compareParameters(metodo, AFPR.fpr1.fpl0, AELR.er1.el, nivel, visitor, arg);
        } else {
            throw new Exception(metodo + ": La cantidad de parámetros no coincide.");
        }
        return true;
    }

    /**
     * Informa si existe el método enviado
     *
     * @param MD
     * @param method
     * @return True si existe, False de otra forma
     */
    AMethodDeclaration existMethod(AMethodDecl MD, String method) {
        if (MD.md1.id1.value.toString().equals(method)) {
            return MD.md1;
        } else if (MD.md0 == null) {
            return null;
        } else {
            return existMethod(MD.md0, method);
        }
    }

    // Indica si un método existe
    AMethodDeclaration existMethod(String Method, String Class) {
        Object tClass = retrieve(Class);

        if ("len".equals(Method) || "ord".equals(Method) || "chr".equals(Method)) {
            AMethodDeclaration result = (AMethodDeclaration) this.retrieve(Method, true);
            return result;
        }
        if (tClass.getClass() == AClassDeclaration.class) {
            AClassDeclaration cType = (AClassDeclaration) tClass;
            return existMethod(cType.md1, Method);
        } else if (tClass.getClass() == AClassExtendsDeclaration.class) {
            AClassExtendsDeclaration eType = (AClassExtendsDeclaration) tClass;
            AMethodDeclaration result = existMethod(eType.md1, Method);
            if (result != null) {
                return result;
            } else {
                result = existMethod(Method, eType.id2.value.toString());
                return result;
            }
        } else {
            return null;
        }
    }

    // Obtiene un modelo de tabla para ser mostrado luego
    public TableModel getTableModel() {
        Object[] Columnas = {"Nombre", "Clase", "Nivel"};
        DefaultTableModel tm = new DefaultTableModel(Columnas, 0);
        Identifier temp = i;
        while (temp != null) {
            if (temp.name == null) {
                temp.name = "Null";
            }
            Object[] datos = {temp.name, "Nulo", temp.level};
            if (temp.attr != null) {
                datos[1] = TypeUtilities.getClass(temp.attr);
            }
            tm.insertRow(tm.getRowCount(), datos);
            temp = temp._next;
        }
        return tm;
    }
}
