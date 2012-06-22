/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import AST.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author sancho
 */
public final class CodeGenerator implements Visitor {

    AST code;
    Reporter reporter;
    ClassFileGenerator gen;
    int stack = 0, locals = 1;
    IdentifierTable table;
    private int NumEt = 0;
    private int NumVar = 0;
    private int NumParam = 0;
    private List<String> GeneratedClasses = new LinkedList<String>();
    private String MainClass;

    public CodeGenerator(AST Goal, IdentifierTable Table, Reporter Reporter) {
        code = Goal;
        table = Table;
        reporter = Reporter;
        gen = new ClassFileGenerator(reporter);
        visitAGoal((AGoal) Goal, null);
        
    }

    @Override
    public Object visitAGoal(AGoal c, Object arg) {
        if (c.td != null) {
            c.td.visit(this, arg);
        }
        c.mc.visit(this, arg);
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

        String className = c.id1.value.toString();
        getGeneratedClasses().add(className);
        this.MainClass = className;

        // Crear un archivo para la clase principal
        gen.createClassFile(className);

        gen.writeCodeLine(className, ".method public static main([Ljava/lang/String;)V");
        gen.writeCodeLine(className, ".limit stack {0}");
        gen.writeCodeLine(className, ".limit locals {1}");

        locals = 1;
        stack = 0;

        if (c.ps0 != null) {
            HashMap<String, String> args = new HashMap<String, String>();
            args.put("class", className);
            c.ps0.visit(this, args);
        }

        gen.replaceValues(className, "{0}", String.valueOf(stack));
        gen.replaceValues(className, "{1}", String.valueOf(locals));

        gen.writeCodeLine(className, "    return");
        gen.writeCodeLine(className, ".end method");
        gen.writeCodeLine(className);

        gen.writeFile(className);

        return null;
    }

    @Override
    public Object visitATypeClassDeclaration(ATypeClassDeclaration c, Object arg) {
        if (c.cd0 != null) {
            c.cd0.visit(this, arg);
        }
        return null;
    }

    @Override
    public Object visitATypeClassExtendsDeclaration(ATypeClassExtendsDeclaration c, Object arg) {
        if (c.ced0 != null) {
            c.ced0.visit(this, arg);
        }
        return null;
    }

    @Override
    public Object visitAClassDeclaration(AClassDeclaration c, Object arg) {

        String className = c.id1.value.toString();
        getGeneratedClasses().add(className);

        // Crear un archivo para la clase
        gen.createClassFile(className);

        HashMap<String, String> args = new HashMap<String, String>();
        args.put("class", className);

        if (c.vd0 != null) {
            c.vd0.visit(this, args);
        }
        if (c.md1 != null) {
            c.md1.visit(this, args);
        }


        gen.writeFile(className);

        return null;
    }

    @Override
    public Object visitAClassExtendsDeclaration(AClassExtendsDeclaration c, Object arg) {
        HashMap<String, String> args = new HashMap<String, String>();
        args.put("class", c.id1.value.toString());
        if (c.md1 != null) {
            c.md1.visit(this, args);
        }
        if (c.vd0 != null) {
            c.vd0.visit(this, args);
        }
        return null;
    }

    @Override
    public Object visitAVarDeclaration(AVarDeclaration c, Object arg) {

        HashMap<String, String> args = (HashMap<String, String>) arg;
        String className = args.get("class");
        
        gen.writeCodeLine(className, "    ldc 0");
        gen.writeCodeLine(className, "    istore " + locals++);
        c.pos = NumVar++;

        return null;
    }

    @Override
    public Object visitAMethodDeclaration(AMethodDeclaration c, Object arg) {

        HashMap<String, String> args = (HashMap<String, String>) arg;
        String className = args.get("class");

        String methodName = c.id1.value.toString();
        // Por defecto recibe un entero y devuelve entero
        gen.writeCodeLine(className, ".method public static " + methodName + "(I)I");
        gen.writeCodeLine(className, ".limit stack {0}");
        gen.writeCodeLine(className, ".limit locals {1}");

        locals = 1;
        stack = 0;

        NumParam = 0;
        c.fpb1.visit(this, arg);
        
        // Por el momento no se visita
        // c.fpb1.visit(this, arg);
        NumVar = NumParam;
        if (c.vd2 != null) {
            c.vd2.visit(this, arg);
        }

        if (c.sl3 != null) {
            c.sl3.visit(this, arg);
        }

        // Poner en la pila el retorno
        c.e4.visit(this, arg);

        gen.replaceValues(className, "{0}", String.valueOf(stack));
        gen.replaceValues(className, "{1}", String.valueOf(locals));

        gen.writeCodeLine(className, "    ireturn");
        gen.writeCodeLine(className, ".end method");
        gen.writeCodeLine(className);

        return null;
    }

    @Override
    public Object visitAFormalParameterList(AFormalParameterList c, Object arg) {
        c.fpl0.visit(this, arg);
        return null;
    }

    @Override
    public Object visitAFormalParameterListRest(AFormalParameterListRest c, Object arg) {
        c.fpl0.visit(this, arg);
        c.fpr1.visit(this, arg);
        return null;
    }

    @Override
    public Object visitAFormalParameter(AFormalParameter c, Object arg) {
        NumParam++;
        return null;
    }

    @Override
    public Object visitAFormalParameterRest(AFormalParameterRest c, Object arg) {
        c.fpl0.visit(this, arg);
        return null;
    }

    @Override
    public Object visitATypeSimple(ATypeSimple c, Object arg) {
        c.st0.visit(this, arg);
        return null;
    }

    @Override
    public Object visitATypeArray(ATypeArray c, Object arg) {
        c.at0.visit(this, arg);
        return null;
    }

    @Override
    public Object visitATypeIdentifier(ATypeIdentifier c, Object arg) {
        return null;
    }

    @Override
    public Object visitACharSimpleType(ACharSimpleType c, Object arg) {
        return null;
    }

    @Override
    public Object visitABooleanSimpleType(ABooleanSimpleType c, Object arg) {
        return null;
    }

    @Override
    public Object visitAnIntegerSimpleType(AnIntegerSimpleType c, Object arg) {
        return null;
    }

    @Override
    public Object visitAnArrayType(AnArrayType c, Object arg) {
        c.st0.visit(this, arg);
        return null;
    }

    @Override
    public Object visitAStatementBlock(AStatementBlock c, Object arg) {
        c.b0.visit(this, arg);
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
        c.sl0.visit(this, arg);
        return null;
    }

    @Override
    public Object visitAnAssignmentStatement(AnAssignmentStatement c, Object arg) {

        HashMap<String, String> args = (HashMap<String, String>) arg;
        String className = args.get("class");

        // Cargar el resultado de evaluar la expresión
        c.e0.visit(this, arg);

        String id = c.id1.value.toString();
        String dtype = TypeUtilities.getDeclaration(table.retrieveAll(id));
        if (dtype.equals("var")) {
            AVarDeclaration declaration = (AVarDeclaration) table.retrieveAll(id);
            gen.writeCodeLine(className, "    istore " + declaration.pos);
        }

        return null;
    }

    @Override
    public Object visitAnArrayAssignmentStatement(AnArrayAssignmentStatement c, Object arg) {
        c.e0.visit(this, arg);
        c.e1.visit(this, arg);
        return null;
    }

    @Override
    public Object visitAnIfStatement(AnIfStatement c, Object arg) {

        HashMap<String, String> args = (HashMap<String, String>) arg;
        String className = args.get("class");

        int et = NumEt;
        if (1 < 2) {
        } else {
        }
        c.e0.visit(this, arg);
        gen.writeCodeLine(className, "    ifne then" + et);
        gen.writeCodeLine(className, "    goto else" + et);

        // Si se cumple la condición generar código
        gen.writeCodeLine(className, "  then" + et + ":");
        c.s1.visit(this, arg);
        gen.writeCodeLine(className, "    goto ifend" + et);
        gen.writeCodeLine(className, "  else" + et + ":");
        c.s2.visit(this, arg);
        gen.writeCodeLine(className, "  ifend" + et + ":");

        NumEt++;

        return null;
    }

    @Override
    public Object visitAWhileStatement(AWhileStatement c, Object arg) {

        HashMap<String, String> args = (HashMap<String, String>) arg;
        String className = args.get("class");

        int et = NumEt;

        // Revisar condición
        gen.writeCodeLine(className, "  check" + et + ":");
        c.e0.visit(this, arg);
        gen.writeCodeLine(className, "    ifne do" + et);
        gen.writeCodeLine(className, "    goto endwhile" + et);

        // Si se cumple la condición generar código
        gen.writeCodeLine(className, "  do" + et + ":");
        c.s1.visit(this, arg);
        gen.writeCodeLine(className, "    goto check" + et);
        gen.writeCodeLine(className, "  endwhile" + et + ":");

        NumEt++;

        return null;
    }

    @Override
    public Object visitAPrintStatement(APrintStatement c, Object arg) {

        HashMap<String, String> args = (HashMap<String, String>) arg;
        String className = args.get("class");

        c.e0.visit(this, arg);
        locals++;
        gen.writeCodeLine(className, "    istore 1");
        stack++;
        gen.writeCodeLine(className, "    getstatic java/lang/System/out Ljava/io/PrintStream;");
        gen.writeCodeLine(className, "    iload 1");
        gen.writeCodeLine(className, "    invokestatic java/lang/String/valueOf(I)Ljava/lang/String;");
        gen.writeCodeLine(className, "    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V");
        return null;
    }

    @Override
    public Object visitAnExpressionAnd(AnExpressionAnd c, Object arg) {
        c.ae0.visit(this, arg);
        return null;
    }

    @Override
    public Object visitAnExpressionPlus(AnExpressionPlus c, Object arg) {
        c.pe0.visit(this, arg);
        return null;
    }

    @Override
    public Object visitAnExpressionMinus(AnExpressionMinus c, Object arg) {
        c.me0.visit(this, arg);
        return null;
    }

    @Override
    public Object visitAnExpressionTimes(AnExpressionTimes c, Object arg) {
        c.te0.visit(this, arg);
        return null;
    }

    @Override
    public Object visitAnExpressionArrayLookup(AnExpressionArrayLookup c, Object arg) {
        c.al0.visit(this, arg);
        return null;
    }

    @Override
    public Object visitAnExpressionArrayLenght(AnExpressionArrayLenght c, Object arg) {
        c.al0.visit(this, arg);
        return null;
    }

    @Override
    public Object visitAnExpressionMessage(AnExpressionMessage c, Object arg) {
        c.ms0.visit(this, arg);
        return null;
    }

    @Override
    public Object visitAnExpressionPrimary(AnExpressionPrimary c, Object arg) {
        c.pe0.visit(this, arg);
        return null;
    }

    @Override
    public Object visitAnAndExpression(AnAndExpression c, Object arg) {
        c.pe0.visit(this, arg);
        c.pe1.visit(this, arg);
        //"  iand"
        return null;
    }

    @Override
    public Object visitAMenorQueExpression(AMenorQueExpression c, Object arg) {

        HashMap<String, String> args = (HashMap<String, String>) arg;
        String className = args.get("class");

        int et = NumEt;

        // Obtener ambos parámetros
        c.pe0.visit(this, arg);
        c.pe1.visit(this, arg);

        // Escribir código para generar verdadero o falso
        gen.writeCodeLine(className, "    if_icmplt true" + et);
        gen.writeCodeLine(className, "    goto false" + et);
        gen.writeCodeLine(className, "  true" + et + ":");
        gen.writeCodeLine(className, "    ldc 1");
        gen.writeCodeLine(className, "    goto exit" + et);
        gen.writeCodeLine(className, "  false" + et + ":");
        gen.writeCodeLine(className, "    ldc 0");
        gen.writeCodeLine(className, "  exit" + et + ":");
        NumEt++;

        return null;
    }

    @Override
    public Object visitAMayorQueExpression(AMayorQueExpression c, Object arg) {

        HashMap<String, String> args = (HashMap<String, String>) arg;
        String className = args.get("class");

        int et = NumEt;

        // Obtener ambos parámetros
        c.pe0.visit(this, arg);
        c.pe1.visit(this, arg);

        // Escribir código para generar verdadero o falso
        gen.writeCodeLine(className, "    if_icmpgt true" + et);
        gen.writeCodeLine(className, "    goto false" + et);
        gen.writeCodeLine(className, "  true" + et + ":");
        gen.writeCodeLine(className, "    ldc 1");
        gen.writeCodeLine(className, "    goto exit" + et);
        gen.writeCodeLine(className, "  false" + et + ":");
        gen.writeCodeLine(className, "    ldc 0");
        gen.writeCodeLine(className, "  exit" + et + ":");
        NumEt++;

        return null;
    }

    @Override
    public Object visitAPlusExpression(APlusExpression c, Object arg) {

        HashMap<String, String> args = (HashMap<String, String>) arg;
        String className = args.get("class");

        // Cargar las dos expresiones
        c.pe0.visit(this, arg);
        c.pe1.visit(this, arg);

        gen.writeCodeLine(className, "    iadd");
        return null;
    }

    @Override
    public Object visitAMinusExpression(AMinusExpression c, Object arg) {
        HashMap<String, String> args = (HashMap<String, String>) arg;
        String className = args.get("class");

        // Cargar las dos expresiones
        c.pe0.visit(this, arg);
        c.pe1.visit(this, arg);

        gen.writeCodeLine(className, "    isub");
        return null;
    }

    @Override
    public Object visitATimesExpression(ATimesExpression c, Object arg) {
        HashMap<String, String> args = (HashMap<String, String>) arg;
        String className = args.get("class");

        // Cargar las dos expresiones
        c.pe0.visit(this, arg);
        c.pe1.visit(this, arg);

        gen.writeCodeLine(className, "    imul");
        return null;
    }

    @Override
    public Object visitADivExpression(ADivExpression c, Object arg) {
        HashMap<String, String> args = (HashMap<String, String>) arg;
        String className = args.get("class");

        // Cargar las dos expresiones
        c.pe0.visit(this, arg);
        c.pe1.visit(this, arg);

        gen.writeCodeLine(className, "    idiv");
        return null;
    }

    @Override
    public Object visitAnArrayLookup(AnArrayLookup c, Object arg) {
        c.pe0.visit(this, arg);
        c.pe1.visit(this, arg);
        return null;
    }

    @Override
    public Object visitAnArrayLength(AnArrayLength c, Object arg) {
        c.pe0.visit(this, arg);
        return null;
    }

    @Override
    public Object visitAMessageSend(AMessageSend c, Object arg) {

        HashMap<String, String> args = (HashMap<String, String>) arg;
        String className = args.get("class");

        // Visitar las expresiones enviadas y dejarlas en la pila
        if (c.elb1 != null) {
            c.elb1.visit(this, arg);
        }

        if (c.pe0 != null) {

            String MethodName = c.id1.value.toString();

            if (c.pe0.getClass() == APrimaryAllocationExpression.class) {
                APrimaryAllocationExpression PId = (APrimaryAllocationExpression) c.pe0;
                String PClass = PId.ae0.id1.value.toString();

                // Escribir el nombre del método que se visitará
                gen.writeCodeLine(className, "    invokestatic " + PClass + "/" + MethodName + "(I)I");
            } else if (c.pe0.getClass() == APrimaryThis.class) {
                String PClass = c.pe0.visit(this, arg).toString();

                // Escribir el nombre del método que se visitará
                gen.writeCodeLine(className, "    invokestatic " + PClass + "/" + MethodName + "(I)I");
            }
            // c.pe0.visit(this, arg);
        }

        return null;
    }

    @Override
    public Object visitAnExpressionList(AnExpressionList c, Object arg) {
        c.e0.visit(this, arg);
        return null;
    }

    @Override
    public Object visitAnExpressionListRest(AnExpressionListRest c, Object arg) {
        c.el0.visit(this, arg);
        c.er1.visit(this, arg);
        return null;
    }

    @Override
    public Object visitAnExpressionRest(AnExpressionRest c, Object arg) {
        c.el.visit(this, arg);
        return null;
    }

    @Override
    public Object visitAPrimaryInteger(APrimaryInteger c, Object arg) {
        HashMap<String, String> args = (HashMap<String, String>) arg;
        String className = args.get("class");
        stack++;
        gen.writeCodeLine(className, "    ldc " + c.int1.value.toString());

        return null;
    }

    @Override
    public Object visitAPrimaryChar(APrimaryChar c, Object arg) {
        return null;
    }

    @Override
    public Object visitAPrimaryString(APrimaryString c, Object arg) {
        return null;
    }

    @Override
    public Object visitAPrimaryTrue(APrimaryTrue c, Object arg) {
        return null;
    }

    @Override
    public Object visitAPrimaryFalse(APrimaryFalse c, Object arg) {
        return null;
    }

    @Override
    public Object visitAPrimaryIdentifier(APrimaryIdentifier c, Object arg) {
        HashMap<String, String> args = (HashMap<String, String>) arg;
        String className = args.get("class");

        String id = c.id1.value.toString();
        String declType = TypeUtilities.getDeclaration(table.retrieveAll(id));
        if (declType.equals("param")) {
            // Cargar por defecto parámetro 1
            gen.writeCodeLine(className, "    iload 0");
        } else if (declType.equals("var")) {
            AVarDeclaration declaration = (AVarDeclaration) table.retrieveAll(id);
            // Cargar por defecto variable 1
            gen.writeCodeLine(className, "    iload " + declaration.pos);
        }
        return null;
    }

    @Override
    public Object visitAPrimaryThis(APrimaryThis c, Object arg) {
        HashMap<String, String> args = (HashMap<String, String>) arg;
        String className = args.get("class");
        return className;
    }

    @Override
    public Object visitAPrimaryAllocationExpression(APrimaryAllocationExpression c, Object arg) {
        c.ae0.visit(this, arg);
        return null;
    }

    @Override
    public Object visitAPrimaryNotExpression(APrimaryNotExpression c, Object arg) {
        c.ne0.visit(this, arg);
        return null;
    }

    @Override
    public Object visitAConstantInteger(AConstantInteger c, Object arg) {
        return null;
    }

    @Override
    public Object visitAConstantChar(AConstantChar c, Object arg) {
        return null;
    }

    @Override
    public Object visitAConstantString(AConstantString c, Object arg) {
        return null;
    }

    @Override
    public Object visitAConstantTrue(AConstantTrue c, Object arg) {
        return null;
    }

    @Override
    public Object visitAConstantFalse(AConstantFalse c, Object arg) {
        return null;
    }

    @Override
    public Object visitAnArrayAllocationExpression(AnArrayAllocationExpression c, Object arg) {
        c.e1.visit(this, arg);
        c.st0.visit(this, arg);
        return null;
    }

    @Override
    public Object visitAnAllocationExpression(AnAllocationExpression c, Object arg) {
        return null;
    }

    @Override
    public Object visitANotExpression(ANotExpression c, Object arg) {
        c.e0.visit(this, arg);
        return null;
    }

    @Override
    public Object visitABracketExpression(ABracketExpression c, Object arg) {
        c.e0.visit(this, arg);
        return null;
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
        if (c.e0 != null) {
            c.e0.visit(this, arg);
        }
        if (c.sb1 != null) {
            c.sb1.visit(this, arg);
        }
        return null;
    }

    @Override
    public Object visitACaseBlock(ACaseBlock c, Object arg) {
        c.bs2.visit(this, arg);
        c.ce0.visit(this, arg);
        c.sl1.visit(this, arg);
        return null;
    }

    @Override
    public Object visitADefaultBlock(ADefaultBlock c, Object arg) {
        c.bs1.visit(this, arg);
        c.sl0.visit(this, arg);
        return null;
    }

    @Override
    public Object visitACaseBlockList(ACaseBlockList c, Object arg) {
        c.cb1.visit(this, arg);
        c.cbl0.visit(this, arg);
        return null;
    }

    @Override
    public Object visitASwitchBlock(ASwitchBlock c, Object arg) {
        c.cbl0.visit(this, arg);
        c.db1.visit(this, arg);
        return null;
    }

    @Override
    public Object visitABreakStatement(ABreakStatement c, Object arg) {
        return null;
    }

    @Override
    public Object visitAPrimaryArray(APrimaryArray c, Object arg) {
        c.aaae0.visit(this, arg);
        return null;
    }

    @Override
    public Object visitASimpleTypeInt(ASimpleTypeInt c, Object arg) {
        return null;
    }

    @Override
    public Object visitASimpleTypeChar(ASimpleTypeChar c, Object arg) {
        return null;
    }

    @Override
    public Object visitASimpleTypeBool(ASimpleTypeBool c, Object arg) {
        return null;
    }

    @Override
    public Object visitAFormalParameterBlock(AFormalParameterBlock c, Object arg) {
        c.fpl0.visit(this, arg);
        return null;
    }

    @Override
    public Object visitAnExpressionDiv(AnExpressionDiv c, Object arg) {
        c.de0.visit(this, arg);
        return null;
    }

    @Override
    public Object visitAnExpressionMayor(AnExpressionMayor c, Object arg) {
        c.mqe0.visit(this, arg);
        return null;
    }

    @Override
    public Object visitAnExpressionMenor(AnExpressionMenor c, Object arg) {
        c.mqe0.visit(this, arg);
        return null;
    }

    @Override
    public Object visitAPrimaryBracket(APrimaryBracket c, Object arg) {
        c.be0.visit(this, arg);
        return null;
    }

    /**
     * @return the GeneratedClasses
     */
    public List<String> getGeneratedClasses() {
        return GeneratedClasses;
    }

    /**
     * @return the MainClass
     */
    public String getMainClass() {
        return MainClass;
    }
}
