/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import AST.*;
import java.io.*;

/**
 *
 * @author sancho
 */
public final class generarCodigo implements Visitor {

    AST code;
    public String mainClass;
    ClassFileGenerator gen = new ClassFileGenerator();

    public generarCodigo(AGoal c) {
        code = c;
        visitAGoal(c, null);
    }
    int num_et = 0;
    int num_var = 0;

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
        if (c.ps0 != null) {
            c.ps0.visit(this, arg);
        }
        // Crear un archivo para la clase principal
        gen.createClassFile(c.id1.value.toString());
        mainClass = c.id1.value.toString();
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
        gen.createClassFile(c.id1.value.toString());
        if (c.vd0 != null) {
            c.vd0.visit(this, arg);
        }
        if (c.md1 != null) {
            c.md1.visit(this, arg);
        }
        return null;
    }

    @Override
    public Object visitAClassExtendsDeclaration(AClassExtendsDeclaration c, Object arg) {
        if (c.md1 != null) {
            c.md1.visit(this, arg);
        }
        if (c.vd0 != null) {
            c.vd0.visit(this, arg);
        }
        return null;
    }

    @Override
    public Object visitAVarDeclaration(AVarDeclaration c, Object arg) {
        //"  istore "+num_var + "/n"
        //Modificar el puntero del arbol con la pos

        return null;
    }

    @Override
    public Object visitAMethodDeclaration(AMethodDeclaration c, Object arg) {
        c.e4.visit(this, arg);
        c.fpb1.visit(this, arg);
        c.sl3.visit(this, arg);
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
        //"  getstatic java/lang/System/out Ljava/io/PrintStream; /n" 
        //"  aload 1 /n"
        //"  invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V /n"
        return null;
    }

    @Override
    public Object visitABlock(ABlock c, Object arg) {
        c.sl0.visit(this, arg);
        return null;
    }

    @Override
    public Object visitAnAssignmentStatement(AnAssignmentStatement c, Object arg) {
        c.e0.visit(this, arg);
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
        c.e0.visit(this, arg);

        c.s1.visit(this, arg);
        c.s2.visit(this, arg);
        return null;
    }

    @Override
    public Object visitAWhileStatement(AWhileStatement c, Object arg) {
        c.e0.visit(this, arg);
        c.s1.visit(this, arg);
        return null;
    }

    @Override
    public Object visitAPrintStatement(APrintStatement c, Object arg) {

        c.e0.visit(this, arg);
        //"  getstatic java/lang/System/out Ljava/io/PrintStream; /n" 
        //"  aload 0 /n"
        //"  invokestatic java/lang/String/valueOf(I)Ljava/lang/String;"
        //"  invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V /n"
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
        c.pe0.visit(this, arg);
        c.pe1.visit(this, arg);

        //"  if_icmplt " + true+num_et + "/n"
        //"    goto " false+num_et + "/n"
        //"true"+num_et + ": /n"
        //"    ldc 1 /n"
        //"    goto salida"+num_et +" /n"
        //"false"+num_et + ": /n"
        //"     ldc 0 /n"
        //"     goto salida"+num_et + " /n"
        //"salida"+num_et + ": /n"
        return null;
    }

    @Override
    public Object visitAMayorQueExpression(AMayorQueExpression c, Object arg) {
        c.pe0.visit(this, arg);
        c.pe1.visit(this, arg);
        //"  if_icmpgt " + true+num_et + "/n"
        //"  goto " false+num_et + "/n"
        //"true"+num_et + ": /n"
        //"  ldc 1 /n"
        //"  goto salida"+num_et +" /n"
        //"false"+num_et + ": /n"
        //"  ldc 0 /n"
        //"  goto salida"+num_et + " /n"
        //"salida"+num_et + ": /n"
        return null;
    }

    @Override
    public Object visitAPlusExpression(APlusExpression c, Object arg) {
        c.pe0.visit(this, arg);
        c.pe1.visit(this, arg);
        //"  iadd /n"
        return null;
    }

    @Override
    public Object visitAMinusExpression(AMinusExpression c, Object arg) {
        c.pe0.visit(this, arg);
        c.pe1.visit(this, arg);
        //"  isub /n"
        return null;
    }

    @Override
    public Object visitATimesExpression(ATimesExpression c, Object arg) {
        c.pe0.visit(this, arg);
        c.pe1.visit(this, arg);
        //"  imul /n"
        return null;
    }

    @Override
    public Object visitADivExpression(ADivExpression c, Object arg) {
        c.pe0.visit(this, arg);
        c.pe1.visit(this, arg);
        //"  idiv"
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
        c.elb1.visit(this, arg);
        c.pe0.visit(this, arg);
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
        //"iload " 
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
        ///
        return null;
    }

    @Override
    public Object visitAPrimaryThis(APrimaryThis c, Object arg) {
        return null;
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
        c.vd0.visit(this, arg);
        c.vd0.visit(this, arg);
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
        if (c.s1 != null) {
            c.s1.visit(this, arg);
        }
        if (c.sl0 != null) {
            c.sl0.visit(this, arg);
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
}
