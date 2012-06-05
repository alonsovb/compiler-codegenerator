/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import AST.*;

/**
 *
 * @author Alonso
 */
public class TypeUtilities {

    /**
     * @param Item
     * @return String que representa la clase
     */
    public static String getClass(AST Item) {
        // Items vacíos
        if (Item == null) {
            return null;
        }
        Object itemClass = Item.getClass();
        // Tipo padre TypeArray
        if (Item.getClass() == ATypeArray.class) {
            ATypeArray atype = (ATypeArray) Item;
            return getClass(atype.at0);
        } // Identificadores
        else if (Item.getClass() == ATypeIdentifier.class) {
            ATypeIdentifier itype = (ATypeIdentifier) Item;
            return itype.id1.value.toString();
        } // Tipos simples
        else if (Item.getClass() == ATypeSimple.class) {
            ATypeSimple stype = (ATypeSimple) Item;
            // Tipo entero
            if (stype.st0.getClass() == ASimpleTypeInt.class) {
                return "int";
            } // Tipo char
            else if (stype.st0.getClass() == ASimpleTypeChar.class) {
                return "char";
            } // Tipo boolean
            else if (stype.st0.getClass() == ASimpleTypeBool.class) {
                return "bool";
            } else {
                return "Unknown simple type";
            }
        } // Tipos de arreglos
        else if (Item.getClass() == AnArrayType.class) {
            AnArrayType atype = (AnArrayType) Item;
            // Arreglo entero
            if (atype.st0.getClass() == ASimpleTypeInt.class) {
                return "int[]";
            } // Arreglo de caracteres
            else if (atype.st0.getClass() == ASimpleTypeChar.class) {
                return "char[]";
            } // Arreglo de booleans
            else if (atype.st0.getClass() == ASimpleTypeBool.class) {
                return "bool[]";
            } else {
                return "array";
            }
        } // Declaraciones de variables
        else if (Item.getClass() == AVarDeclaration.class) {
            AVarDeclaration vtype = (AVarDeclaration) Item;
            // Buscar el tipo simple
            Type type = (Type) vtype.t0;
            return getClass(type);
        } // Parámetros
        else if (Item.getClass() == AFormalParameter.class) {
            AFormalParameter ftype = (AFormalParameter) Item;
            Type type = (Type) ftype.t0;
            return getClass(type);
        } // Declaración de clase
        else if (Item.getClass() == AClassDeclaration.class) {
            AClassDeclaration ctype = (AClassDeclaration) Item;
            // Devolver su identificador
            return ctype.id1.value.toString();
        } // Clase extendida
        else if (Item.getClass() == AClassExtendsDeclaration.class) {
            AClassExtendsDeclaration ctype = (AClassExtendsDeclaration) Item;
            // Devolver su identificador
            return ctype.id1.value.toString();
        } // Declaración de clase principal
        else if (Item.getClass() == AMainClass.class) {
            AMainClass mtype = (AMainClass) Item;
            return mtype.id1.value.toString();
        } // Declaración de método
        else if (Item.getClass() == AMethodDeclaration.class) {
            AMethodDeclaration mtype = (AMethodDeclaration) Item;
            // Buscar su tipo
            Type type = (Type) mtype.t0;
            return getClass(type);
        }
        return Item.getClass().getName();
    }

    public static String getClass(Object Class) {
        // Items vacíos
        if (Class == null) {
            return null;
        }
        // Clases simples
        if (Class == ASimpleTypeInt.class) {
            return "int";
        } // Tipo char
        else if (Class == ASimpleTypeChar.class) {
            return "char";
        } // Tipo boolean
        else if (Class == ASimpleTypeBool.class) {
            return "bool";
        } else {
            return Class.getClass().getName();
        }
    }
}
