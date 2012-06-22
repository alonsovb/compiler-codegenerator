package proyecto;

import ast.AFormalParameterListRest;
import ast.AMessageSend;
import ast.ATimesExpression;
import ast.APrintStatement;
import ast.AnIntegerSimpleType;
import ast.ATypeDecl;
import ast.Visitor;
import ast.AnArrayAssignmentStatement;
import ast.APrimaryNotExpression;
import ast.AnAndExpression;
import ast.AnExpressionMessage;
import ast.ATypeClassExtendsDeclaration;
import ast.AnExpressionMenor;
import ast.AnArrayType;
import ast.AVarDeclaration;
import ast.AMenorQueExpression;
import ast.AStatementPrint;
import ast.AFormalParameterRest;
import ast.ACaseBlockList;
import ast.AStatementArrayAssignment;
import ast.AnIfStatement;
import ast.ASwitchStatement;
import ast.ABooleanSimpleType;
import ast.AFormalParameter;
import ast.AnExpressionTimes;
import ast.ASimpleTypeChar;
import ast.AnExpressionAnd;
import ast.ACaseBlock;
import ast.AnExpressionList;
import ast.AMethodDecl;
import ast.AMayorQueExpression;
import ast.AStatementBlock;
import ast.AGoal;
import ast.APrimaryIdentifier;
import ast.ATypeSimple;
import ast.APlusExpression;
import ast.AnAllocationExpression;
import ast.AWhileStatement;
import ast.APrimaryTrue;
import ast.APrimaryString;
import ast.AST;
import ast.APrimaryFalse;
import ast.AnArrayLookup;
import ast.AMethodDeclaration;
import ast.AMinusExpression;
import ast.ATypeIdentifier;
import ast.ABreakStatement;
import ast.ATypeClassDeclaration;
import ast.APrimaryChar;
import ast.AnExpressionRest;
import ast.AVarDecl;
import ast.AStatementIf;
import ast.AStatementWhile;
import ast.AConstantString;
import ast.ANotExpression;
import ast.AConstantFalse;
import ast.APrimaryArray;
import ast.ADivExpression;
import ast.AnExpressionDiv;
import ast.ADefaultBlock;
import ast.AnExpressionArrayLenght;
import ast.AClassExtendsDeclaration;
import ast.APrimaryAllocationExpression;
import ast.AnExpressionPrimary;
import ast.ASimpleTypeInt;
import ast.AFormalParameterBlock;
import ast.AStatementSwitch;
import ast.APrimaryThis;
import ast.AnExpressionListBlock;
import ast.AMainClass;
import ast.AnExpressionListRest;
import ast.AnExpressionMinus;
import ast.AConstantTrue;
import ast.AnExpressionPlus;
import ast.AStatementAssignment;
import ast.APrimaryInteger;
import ast.AStatementList;
import ast.AnExpressionArrayLookup;
import ast.AnArrayLength;
import ast.AFormalParameterList;
import ast.AnAssignmentStatement;
import ast.AConstantInteger;
import ast.AnArrayAllocationExpression;
import ast.AClassDeclaration;
import ast.ACharSimpleType;
import ast.ATypeArray;
import ast.AnExpressionMayor;
import ast.ABlock;
import ast.ASwitchBlock;
import ast.ABracketExpression;
import ast.APrimaryBracket;
import ast.AConstantChar;
import ast.ASimpleTypeBool;
import java.util.HashMap;

/**
 *
 * @author sancho
 */
public class ContextAnalizer implements Visitor {

    private IdentifierTable it;
    private Reporter reporter;

    public ContextAnalizer(IdentifierTable table, Reporter er) {
        this.it = table;
        this.reporter = er;
    }

    public void visit(AST Inicio) {
        java.util.HashMap<String, Object> h = new HashMap<String, Object>();
        this.visitAGoal((AGoal) Inicio, h);
    }

    @Override
    public Object visitAGoal(AGoal c, Object arg) {
        if (c.td != null) {
            c.td.visit(this, arg);
        }
        if (c.mc != null) {
            c.mc.visit(this, arg);
        }
        return null;
    }

    @Override
    public Object visitATypeDecl(ATypeDecl c, Object arg) {
        if (c.td1 != null) {
            c.td1.visit(this, arg);
        }
        if (c.td2 != null) {
            c.td2.visit(this, arg);
        }
        return null;
    }

    @Override
    public Object visitAMainClass(AMainClass c, Object arg) {
        if (it.exists(c.id1.value.toString())) {
            reporter.ReportError("Ya se ha declarado el identificador " + c.id1.value.toString());
        } else {
            it.enter(c.id1.value.toString(), c);
        }
        it.openScope();
        if (it.exists(c.id2.value.toString())) {
            reporter.ReportError("Ya se ha declarado el identificador " + c.id2.value.toString());
        } else {
            it.enter(c.id2.value.toString(), new AnArrayType(new ASimpleTypeChar()));
        }

        HashMap args = (HashMap) arg;
        args.put("Clase", c);
        c.ps0.visit(this, args);
        it.closeScope();
        return null;
    }

    @Override
    public Object visitATypeClassDeclaration(ATypeClassDeclaration c, Object arg) {
        c.cd0.visit(this, arg);
        return null;
    }

    @Override
    public Object visitATypeClassExtendsDeclaration(ATypeClassExtendsDeclaration c, Object arg) {
        c.ced0.visit(this, arg);
        return null;
    }

    @Override
    public Object visitAClassDeclaration(AClassDeclaration c, Object arg) {
        if (it.exists(c.id1.value.toString())) {
            reporter.ReportError("Ya se ha declarado el identificador " + c.id1.value.toString());
        } else {
            it.enter(c.id1.value.toString(), c);
        }
        it.openScope();
        HashMap args = (HashMap) arg;
        args.put("Clase", c);
        if (c.vd0 != null) {
            c.vd0.visit(this, args);
        }
        if (c.md1 != null) {
            c.md1.visit(this, args);
        }
        it.closeScope();
        return null;
    }

    @Override
    public Object visitAClassExtendsDeclaration(AClassExtendsDeclaration c, Object arg) {
        if (it.exists(c.id1.value.toString())) {
            reporter.ReportError("Ya se ha declarado el identificador " + c.id1.value.toString());
        } else {
            it.enter(c.id1.value.toString(), c);
        }
        // Revisar que la clase que extiende esté declarada
        if (!it.exists(c.id2.value.toString())) {
            reporter.ReportError("No se puede extender de una clase la declarada: " + c.id2.value.toString());
        }
        HashMap args = (HashMap) arg;
        args.put("Clase", c);
        if (c.vd0 != null) {
            c.vd0.visit(this, args);
        }
        if (c.md1 != null) {
            c.md1.visit(this, args);
        }
        return null;
    }

    @Override
    public Object visitAVarDeclaration(AVarDeclaration c, Object arg) {
        if (it.exists(c.id1.value.toString())) {
            reporter.ReportError("Ya se ha declarado la variable " + c.id1.value.toString());
        } else {
            if (c.t0.getClass() == ATypeArray.class) {
                String type = TypeUtilities.getClass(c.t0);
                if (!"int[]".equals(type) && !"char[]".equals(type) && !"bool[]".equals(type)) {
                    reporter.ReportError(c.id1.value.toString() + ": No se puede declarar un arreglo de tipo complejo");
                    return null;
                }
            }
            it.enter(c.id1.value.toString(), c);
        }
        return null;
    }

    @Override
    public Object visitAMethodDeclaration(AMethodDeclaration c, Object arg) {
        if (it.exists(c.id1.value.toString())) {
            reporter.ReportError("Ya se ha declarado el identificador " + c.id1.value.toString());
        } else {
            it.enter(c.id1.value.toString(), c);
        }
        it.openScope();
        if (c.fpb1 != null) {
            c.fpb1.visit(this, arg);
        }
        if (c.vd2 != null) {
            c.vd2.visit(this, arg);
        }
        if (c.sl3 != null) {
            c.sl3.visit(this, arg);
        }
        Object result = c.e4.visit(this, arg);

        // Comprobar que la clase declarada y la retornada sean iguales
        Object declaredType = TypeUtilities.getClass(c.t0);

        // Buscar clases 
        if (result != declaredType) {
            reporter.ReportError(c.id1.value.toString() + ": Se esperaba retornar " + declaredType + ". Se retorna " + result);
        }
        it.closeScope();
        return null;
    }

    @Override
    public Object visitAFormalParameterList(AFormalParameterList c, Object arg) {
        if (c.fpl0 != null) {
            c.fpl0.visit(this, arg);
        }
        return null;
    }

    @Override
    public Object visitAFormalParameterListRest(AFormalParameterListRest c, Object arg) {
        if (c.fpl0 != null) {
            c.fpl0.visit(this, arg);
        }
        if (c.fpr1 != null) {
            c.fpr1.visit(this, arg);
        }
        return null;
    }

    @Override
    public Object visitAFormalParameter(AFormalParameter c, Object arg) {
        if (it.exists(c.id1.value.toString())) {
            reporter.ReportError("Ya se ha declarado el identificador " + c.id1.value.toString());
        } else {
            it.enter(c.id1.value.toString(), c);
        }
        return null;
    }

    @Override
    public Object visitAFormalParameterRest(AFormalParameterRest c, Object arg) {
        if (c.fpl0 != null) {
            c.fpl0.visit(this, arg);
        }
        return null;
    }

    @Override
    public Object visitATypeSimple(ATypeSimple c, Object arg) {
        return c.st0.visit(this, arg);
    }

    @Override
    public Object visitATypeArray(ATypeArray c, Object arg) {
        return c.at0.visit(this, arg);
    }

    @Override
    public Object visitATypeIdentifier(ATypeIdentifier c, Object arg) {
        return null;
    }

    @Override
    public Object visitACharSimpleType(ACharSimpleType c, Object arg) {
        return "char";
    }

    @Override
    public Object visitABooleanSimpleType(ABooleanSimpleType c, Object arg) {
        return "bool";
    }

    @Override
    public Object visitAnIntegerSimpleType(AnIntegerSimpleType c, Object arg) {
        return "int";
    }

    @Override
    public Object visitAnArrayType(AnArrayType c, Object arg) {
        return AnArrayType.class;
    }

    @Override
    public Object visitAStatementBlock(AStatementBlock c, Object arg) {
        if (c.b0 != null) {
            c.b0.visit(this, arg);
        }
        return null;
    }

    @Override
    public Object visitAStatementAssignment(AStatementAssignment c, Object arg) {
        c.as0.visit(this, arg);
        return null;
    }

    @Override
    public Object visitAStatementArrayAssignment(AStatementArrayAssignment c, Object arg) {
        c.aas0.visit(this, arg);
        return null;
    }

    @Override
    public Object visitAStatementIf(AStatementIf c, Object arg) {
        c.is0.visit(this, arg);
        return null;
    }

    @Override
    public Object visitAStatementWhile(AStatementWhile c, Object arg) {
        c.ws0.visit(this, arg);
        return null;
    }

    @Override
    public Object visitAStatementSwitch(AStatementSwitch c, Object arg) {
        c.ss0.visit(this, arg);
        return null;
    }

    @Override
    public Object visitAStatementPrint(AStatementPrint c, Object arg) {
        c.ps0.visit(this, arg);
        return null;
    }

    @Override
    public Object visitABlock(ABlock c, Object arg) {
        if (c.sl0 != null) {
            c.sl0.visit(this, arg);
        }
        return null;
    }

    @Override
    public Object visitAnAssignmentStatement(AnAssignmentStatement c, Object arg) {
        if (it.exists(c.id1.value.toString())) {
            // Clase del identificador
            String idClass = TypeUtilities.getClass(it.retrieve(c.id1.value.toString()));
            // Clase del valor asignado
            String expressionClass = c.e0.visit(this, arg).toString();
//            Object expClass = TypeUtilities.getClass(expressionClass);
            // Comprobar si las clases son distintas
            if (!idClass.equals(expressionClass)) {
                reporter.ReportError("Error al asignar la variable " + c.id1.value.toString() + ". Se esperaba "
                        + idClass.toString() + ". Se recibió " + expressionClass.toString());
            }

        } else {
            reporter.ReportError("No se ha declarado el identificador " + c.id1.value.toString());
        }
        return null;
    }

    @Override
    public Object visitAnArrayAssignmentStatement(AnArrayAssignmentStatement c, Object arg) {
        if (it.exists(c.id1.value.toString())) {
            // Comprobar que el índice es entero
            if (c.e0.visit(this, arg) != "int") {
                reporter.ReportError("Se esperaba un entero como índice");
            }
            // Clase del identificador
            String idClass = TypeUtilities.getClass(it.retrieve(c.id1.value.toString()));
            // Clase del valor asignado
            String expClass = c.e1.visit(this, arg).toString();
            // Comprobar si las clases son distintas
            if (!idClass.contains("[]")) {
                reporter.ReportError("Se esperaba un tipo arreglo");
            }
            if (!idClass.substring(0, idClass.length() - 2).equals(expClass)) {
                reporter.ReportError("Error al asignar la variable " + c.id1.value.toString());
            }
        } else {
            reporter.ReportError("No se ha declarado el identificador " + c.id1.value.toString());
        }
        return null;
    }

    @Override
    public Object visitAnIfStatement(AnIfStatement c, Object arg) {
        if (c.e0.visit(this, arg) != "bool") {
            reporter.ReportError("Se esperaba un expresión booleana");
        }
        c.s1.visit(this, arg);
        if (c.s2 != null) {
            c.s2.visit(this, arg);
        }
        return null;
    }

    @Override
    public Object visitAWhileStatement(AWhileStatement c, Object arg) {
        if (c.e0.visit(this, arg) != "bool") {
            reporter.ReportError("Se esperaba un expresión booleana");
        }
        if (c.s1 != null) {
            c.s1.visit(this, arg);
        }
        return null;
    }

    @Override
    public Object visitAPrintStatement(APrintStatement c, Object arg) {
        if (c.e0 != null) {
            c.e0.visit(this, arg);
        }
        return null;
    }

    @Override
    public Object visitAnExpressionAnd(AnExpressionAnd c, Object arg) {
        c.ae0.visit(this, arg);
        c.type = "bool";
        return c.type;
    }

    @Override
    public Object visitAnExpressionPlus(AnExpressionPlus c, Object arg) {
        c.type = c.pe0.visit(this, arg).toString();
        return c.type;
    }

    @Override
    public Object visitAnExpressionMinus(AnExpressionMinus c, Object arg) {
        c.me0.visit(this, arg);
        c.type = "int";
        return c.type;
    }

    @Override
    public Object visitAnExpressionTimes(AnExpressionTimes c, Object arg) {
        c.te0.visit(this, arg);
        c.type = "int";
        return c.type;
    }

    @Override
    public Object visitAnExpressionArrayLookup(AnExpressionArrayLookup c, Object arg) {
        c.type = c.al0.visit(this, arg).toString();
        return c.type;
    }

    @Override
    public Object visitAnExpressionArrayLenght(AnExpressionArrayLenght c, Object arg) {
        c.al0.visit(this, arg);
        return "int";
    }

    @Override
    public Object visitAnExpressionMessage(AnExpressionMessage c, Object arg) {
        c.type = c.ms0.visit(this, arg).toString();
        return c.type;
    }

    @Override
    public Object visitAnExpressionPrimary(AnExpressionPrimary c, Object arg) {
        c.type = c.pe0.visit(this, arg).toString();
        return c.type;
    }

    @Override
    public Object visitAnAndExpression(AnAndExpression c, Object arg) {
        // Clase de la primera expresión
        Object exp1Class = c.pe0.visit(this, arg);
        // Clase de la segunda expresión
        Object exp2Class = c.pe1.visit(this, arg);
        // Comprobar que las clases sean booleanas
        if (exp1Class != "bool" || exp2Class != "bool") {
            reporter.ReportError("Se esperaban tipos booleanos para la expresión And");
        }
        c.type = "bool";
        return c.type;
    }

    @Override
    public Object visitAMenorQueExpression(AMenorQueExpression c, Object arg) {
        // Clase de la primera expresión
        Object exp1Class = c.pe0.visit(this, arg);
        // Clase de la segunda expresión
        Object exp2Class = c.pe1.visit(this, arg);
        // Comprobar que las clases sean booleanas
        if (exp1Class != "int" || exp2Class != "int") {
            reporter.ReportError("Se esperaban tipos entero para la comparación (<)");
        }
        c.type = "bool";
        return c.type;
    }

    @Override
    public Object visitAMayorQueExpression(AMayorQueExpression c, Object arg) {
        // Clase de la primera expresión
        Object exp1Class = c.pe0.visit(this, arg);
        // Clase de la segunda expresión
        Object exp2Class = c.pe1.visit(this, arg);
        // Comprobar que las clases sean booleanas
        if (exp1Class != "int" || exp2Class != "int") {
            reporter.ReportError("Se esperaban tipos entero para la comparación (>)");
        }
        c.type = "bool";
        return c.type;
    }

    @Override
    public Object visitAPlusExpression(APlusExpression c, Object arg) {
        // Clase de la primera expresión
        Object exp1Class = c.pe0.visit(this, arg);
        // Clase de la segunda expresión
        Object exp2Class = c.pe1.visit(this, arg);

        if (exp1Class == null || exp2Class == null) {
            reporter.ReportError("No se puede aplicar la operación de suma, uno de los valores es inválido");
            c.type = "int";
            return c.type;
        }

        // Comprobar que las clases sean enteras o strings
        if (exp1Class == "int" && exp2Class == "int") {
            c.type = "int";
            return c.type;
        } else if (exp1Class == "string" && exp2Class == "string") {
            c.type = "string";
            return c.type;
        } else {
            reporter.ReportError("No se puede aplicar la operación de suma " + exp1Class.toString() + " + " + exp2Class.toString());
            c.type = "unset";
            return c.type;
        }
    }

    @Override
    public Object visitAMinusExpression(AMinusExpression c, Object arg) {
        // Clase de la primera expresión
        Object exp1Class = c.pe0.visit(this, arg);
        // Clase de la segunda expresión
        Object exp2Class = c.pe1.visit(this, arg);
        // Comprobar que las clases sean booleanas
        if (exp1Class != "int" || exp2Class != "int") {
            reporter.ReportError("Se esperaban tipos entero en la resta");
        }
        c.type = "int";
        return c.type;
    }

    @Override
    public Object visitATimesExpression(ATimesExpression c, Object arg) {
        // Clase de la primera expresión
        Object exp1Class = c.pe0.visit(this, arg);
        // Clase de la segunda expresión
        Object exp2Class = c.pe1.visit(this, arg);
        // Comprobar que las clases sean booleanas
        if (exp1Class != "int" || exp2Class != "int") {
            reporter.ReportError("Se esperaban tipos entero en la multiplicación");
        }
        c.type = "int";
        return c.type;
    }

    @Override
    public Object visitADivExpression(ADivExpression c, Object arg) {
        // Clase de la primera expresión
        Object exp1Class = c.pe0.visit(this, arg);
        // Clase de la segunda expresión
        Object exp2Class = c.pe1.visit(this, arg);
        // Comprobar que las clases sean booleanas
        if (exp1Class != "int" || exp2Class != "int") {
            reporter.ReportError("Se esperaban tipos entero en la división");
        }
        c.type = "int";
        return c.type;
    }

    @Override
    public Object visitAnArrayLookup(AnArrayLookup c, Object arg) {
        // Arreglar esto
        if ((c.pe1.visit(this, arg) == "int")
                && (c.pe0.visit(this, arg) == ATypeArray.class)) {
            c.type = "bool";
            return c.type;
        } else if (c.pe1.visit(this, arg) == "int") {
            reporter.ReportError("Se espera un valor de tipo entero como índice de arreglo");
        } else {
            reporter.ReportError("Se espera un valor de tipo arreglo para el Lookup");
        }
        return null;
    }

    @Override
    public Object visitAnArrayLength(AnArrayLength c, Object arg) {
        if (c.pe0.visit(this, arg) == AnArrayType.class) {
            c.type = "int";
            return c.type;
        }
        reporter.ReportError("Se espera un tipo de arreglo para obtener su tamaño");
        return "int";
    }

    @Override
    public Object visitAMessageSend(AMessageSend c, Object arg) {
        // Obtener la clase de la primera expresión, a la cual se le envía el mensaje
        Object tipoClase = c.pe0.visit(this, arg);
        // Buscar que exista el método llamado en la tabla
        String nombreMétodo = c.id1.value.toString();
        String claseDevuelta = "indefinido";
        if (!it.exists(nombreMétodo, true)) {
            reporter.ReportError("No se ha declarado el identificador " + nombreMétodo);
        } else {
            // Buscar la declaración de clase de la expresión
            AMethodDeclaration metodoDeclarado = it.existMethod(nombreMétodo, tipoClase.toString());
            // Si no existe, se reporta el error
            if (metodoDeclarado == null) {
                reporter.ReportError("No existe el método " + nombreMétodo + "en la clase " + tipoClase.toString());
            } // Si existe, se obtiene la clase que devuelve
            else {
                claseDevuelta = TypeUtilities.getClass(metodoDeclarado.t0);
            }
            // Comprobar parámetros enviados
            AMethodDeclaration metodo = (AMethodDeclaration) it.retrieve(nombreMétodo, true);
            if (c.elb1 != null && metodo.fpb1 != null) {
                try {
                    it.compareParameters(nombreMétodo, metodo.fpb1.fpl0, c.elb1.el0, 1, this, arg);
                } catch (Exception ex) {
                    reporter.ReportError(ex.getMessage());
                }
            }
        }
        c.type = claseDevuelta;
        return c.type;
    }

    @Override
    public Object visitAnExpressionList(AnExpressionList c, Object arg) {
        if (c.e0 != null) {
            c.e0.visit(this, arg);
        }
        return null;
    }

    @Override
    public Object visitAnExpressionListRest(AnExpressionListRest c, Object arg) {
        if (c.el0 != null) {
            c.el0.visit(this, arg);
        }
        if (c.er1 != null) {
            c.er1.visit(this, arg);
        }
        return null;
    }

    @Override
    public Object visitAnExpressionRest(AnExpressionRest c, Object arg) {
        if (c.el != null) {
            c.el.visit(this, arg);
        }
        return null;
    }

    @Override
    public Object visitAPrimaryInteger(APrimaryInteger c, Object arg) {
        c.type = "int";
        return c.type;
    }

    @Override
    public Object visitAPrimaryChar(APrimaryChar c, Object arg) {
        c.type = "char";
        return c.type;
    }

    @Override
    public Object visitAPrimaryString(APrimaryString c, Object arg) {
        c.type = "string";
        return c.type;
    }

    @Override
    public Object visitAPrimaryTrue(APrimaryTrue c, Object arg) {
        c.type = "bool";
        return c.type;
    }

    @Override
    public Object visitAPrimaryFalse(APrimaryFalse c, Object arg) {
        c.type = "bool";
        return c.type;
    }

    @Override
    public Object visitAPrimaryIdentifier(APrimaryIdentifier c, Object arg) {
        String id = c.id1.value.toString();
        if (it.exists(id)) {
            c.declaration = it.retrieve(id);
            c.type = TypeUtilities.getClass(c.declaration);
            return c.type;
        } else {
            reporter.ReportError("No se encuentra el identificador " + c.id1.value.toString());
            return null;
        }
    }

    @Override
    public Object visitAPrimaryThis(APrimaryThis c, Object arg) {
        HashMap args = (HashMap) arg;
        AST clase = (AST) args.get("Clase");
        c.type = TypeUtilities.getClass(clase);
        return c.type;
    }

    @Override
    public Object visitAPrimaryAllocationExpression(APrimaryAllocationExpression c, Object arg) {
        c.type = c.ae0.visit(this, arg).toString();
        return c.type;
    }

    @Override
    public Object visitAPrimaryNotExpression(APrimaryNotExpression c, Object arg) {
        c.ne0.visit(this, arg);
        c.type = "bool";
        return c.type;
    }

    @Override
    public Object visitAConstantInteger(AConstantInteger c, Object arg) {
        return "int";
    }

    @Override
    public Object visitAConstantChar(AConstantChar c, Object arg) {
        return "char";
    }

    @Override
    public Object visitAConstantString(AConstantString c, Object arg) {
        return "string";
    }

    @Override
    public Object visitAConstantTrue(AConstantTrue c, Object arg) {
        return "bool";
    }

    @Override
    public Object visitAConstantFalse(AConstantFalse c, Object arg) {
        return "bool";
    }

    @Override
    public Object visitAnArrayAllocationExpression(AnArrayAllocationExpression c, Object arg) {
        if (c.e1.visit(this, arg) != "int") {
            reporter.ReportError("Se esperaba un entero en el tamaño de alocación");
        }
        String tipoSimple = (String) c.st0.visit(this, arg);
        c.type = tipoSimple + "[]";
        return c.type;
    }

    @Override
    public Object visitAnAllocationExpression(AnAllocationExpression c, Object arg) {
        return TypeUtilities.getClass(it.retrieve(c.id1.value.toString()));
    }

    @Override
    public Object visitANotExpression(ANotExpression c, Object arg) {
        if (c.e0.visit(this, arg) != "bool") {
            reporter.ReportError("Se esperaba un valor booleano para la expresión de negación");
        }
        c.type = "bool";
        return c.type;
    }

    @Override
    public Object visitABracketExpression(ABracketExpression c, Object arg) {
        c.type = c.e0.visit(this, arg).toString();
        return c.type;
    }

    @Override
    public Object visitAVarDecl(AVarDecl c, Object arg) {
        if (c.vd0 != null) {
            c.vd0.visit(this, arg);
        }
        if (c.vd1 != null) {
            c.vd1.visit(this, arg);
        }
        return null;
    }

    @Override
    public Object visitAMethodDecl(AMethodDecl c, Object arg) {
        if (c.md0 != null) {
            c.md0.visit(this, arg);
        }
        if (c.md1 != null) {
            c.md1.visit(this, arg);
        }
        return null;
    }

    @Override
    public Object visitAStatementList(AStatementList c, Object arg) {
        if (c.sl0 != null) {
            c.sl0.visit(this, arg);
        }
        if (c.s1 != null) {
            c.s1.visit(this, arg);
        }
        return null;
    }

    @Override
    public Object visitAnExpressionListBlock(AnExpressionListBlock c, Object arg) {
        if (c.el0 != null) {
            c.el0.visit(this, arg);
        }
        return null;
    }

    @Override
    public Object visitASwitchStatement(ASwitchStatement c, Object arg) {
        Object expType = c.e0.visit(this, arg);
        HashMap args = (HashMap) arg;
        args.put("Switch", expType);
        if (c.sb1 != null) {
            c.sb1.visit(this, args);
        }
        return null;
    }

    @Override
    public Object visitACaseBlock(ACaseBlock c, Object arg) {
        if (c.ce0 != null) {
            HashMap args = (HashMap) arg;
            Object caseType = c.ce0.visit(this, arg);
            Object swtcType = args.get("Switch");
            if (swtcType != caseType) {
                reporter.ReportError("Case: Se esperaba " + swtcType.toString() + ", se recibió " + caseType.toString());
            }
        }
        if (c.sl1 != null) {
            c.sl1.visit(this, arg);
        }
        if (c.bs2 != null) {
            c.bs2.visit(this, arg);
        }
        return null;
    }

    @Override
    public Object visitADefaultBlock(ADefaultBlock c, Object arg) {
        if (c.sl0 != null) {
            c.sl0.visit(this, arg);
        }
        if (c.bs1 != null) {
            c.bs1.visit(this, arg);
        }
        return null;
    }

    @Override
    public Object visitACaseBlockList(ACaseBlockList c, Object arg) {
        if (c.cbl0 != null) {
            c.cbl0.visit(this, arg);
        }
        if (c.cb1 != null) {
            c.cb1.visit(this, arg);
        }
        return null;
    }

    @Override
    public Object visitASwitchBlock(ASwitchBlock c, Object arg) {
        if (c.cbl0 != null) {
            c.cbl0.visit(this, arg);
        }
        if (c.db1 != null) {
            c.db1.visit(this, arg);
        }
        return null;
    }

    @Override
    public Object visitABreakStatement(ABreakStatement c, Object arg) {
        return null;
    }

    @Override
    public Object visitAPrimaryArray(APrimaryArray c, Object arg) {
        return c.aaae0.visit(this, arg);
    }

    @Override
    public Object visitASimpleTypeInt(ASimpleTypeInt c, Object arg) {
        return "int";
    }

    @Override
    public Object visitASimpleTypeChar(ASimpleTypeChar c, Object arg) {
        return "char";
    }

    @Override
    public Object visitASimpleTypeBool(ASimpleTypeBool c, Object arg) {
        return "bool";
    }

    @Override
    public Object visitAFormalParameterBlock(AFormalParameterBlock c, Object arg) {
        if (c.fpl0 != null) {
            c.fpl0.visit(this, arg);
        }
        return null;
    }

    @Override
    public Object visitAnExpressionDiv(AnExpressionDiv c, Object arg) {
        c.de0.visit(this, arg);
        c.type = "int";
        return c.type;
    }

    @Override
    public Object visitAnExpressionMayor(AnExpressionMayor c, Object arg) {
        c.mqe0.visit(this, arg);
        c.type = "bool";
        return c.type;
    }

    @Override
    public Object visitAnExpressionMenor(AnExpressionMenor c, Object arg) {
        c.mqe0.visit(this, arg);
        c.type = "bool";
        return c.type;
    }

    @Override
    public Object visitAPrimaryBracket(APrimaryBracket c, Object arg) {
        c.type = c.be0.visit(this, arg).toString();
        return c.type;
    }
}
