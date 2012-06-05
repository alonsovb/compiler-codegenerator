package Imprimir;

import AST.*;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author sancho
 */
public class imprimir_arbol implements Visitor {

    public Object visitAGoal(AGoal aThis, Object arg) {

        DefaultMutableTreeNode raiz = (DefaultMutableTreeNode) arg;
        if (aThis.mc != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(aThis.mc.getClass().getName());
            raiz.add(h0);
            aThis.mc.visit(this, h0);
        }
        //--------------------------------------------------//
        if (aThis.td != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(aThis.td.getClass().getName());
            raiz.add(h0);
            aThis.td.visit(this, h0);
        }
        //--------------------------------------------------//
        return null;
    }

    //-------------------------------------------------------------------------------------------
    public Object visitATypeDecl(ATypeDecl aThis, Object arg) {

        DefaultMutableTreeNode raiz = (DefaultMutableTreeNode) arg;
        if (aThis.td1 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(aThis.td1.getClass().getName());
            raiz.add(h0);
            aThis.td1.visit(this, h0);
        }
        //--------------------------------------------------//
        if (aThis.td2 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(aThis.td2.getClass().getName());
            raiz.add(h0);
            aThis.td2.visit(this, h0);
        }
        return null;
    }

    //-------------------------------------------------------------------------------------------
    public Object visitAMainClass(AMainClass c, Object arg) {

        DefaultMutableTreeNode raiz = (DefaultMutableTreeNode) arg;
        if (c.id1 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.id1.value);
            raiz.add(h0);
        }
        //--------------------------------------------------//
        if (c.id2 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.id2.value);
            raiz.add(h0);
        }
        //--------------------------------------------------//
        if (c.ps0 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.ps0.getClass().getName());
            raiz.add(h0);
            c.ps0.visit(this, h0);
        }


        return null;
    }

    //-------------------------------------------------------------------------------------------
    public Object visitATypeClassDeclaration(ATypeClassDeclaration c, Object arg) {

        DefaultMutableTreeNode raiz = (DefaultMutableTreeNode) arg;
        if (c.cd0 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.cd0.getClass().getName());
            raiz.add(h0);
            c.cd0.visit(this, h0);
        }
        return null;
    }

    //-------------------------------------------------------------------------------------------    
    public Object visitATypeClassExtendsDeclaration(ATypeClassExtendsDeclaration c, Object arg) {

        DefaultMutableTreeNode raiz = (DefaultMutableTreeNode) arg;
        if (c.ced0 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.ced0.getClass().getName());
            raiz.add(h0);
            c.ced0.visit(this, h0);
        }
        return null;
    }

    //------------------------------------------------------------------------------------------- 
    public Object visitAClassDeclaration(AClassDeclaration c, Object arg) {

        DefaultMutableTreeNode raiz = (DefaultMutableTreeNode) arg;
        if (c.id1 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.id1.value);
            raiz.add(h0);
        }
        //--------------------------------------------------//
        if (c.vd0 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.vd0.getClass().getName());
            raiz.add(h0);
            c.vd0.visit(this, h0);
        }
        //--------------------------------------------------//
        if (c.md1 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.md1.getClass().getName());
            raiz.add(h0);
            c.md1.visit(this, h0);
        }

        return null;
    }

    //------------------------------------------------------------------------------------------- 
    public Object visitAClassExtendsDeclaration(AClassExtendsDeclaration c, Object arg) {

        DefaultMutableTreeNode raiz = (DefaultMutableTreeNode) arg;
        if (c.vd0 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.vd0.getClass().getName());
            raiz.add(h0);
            c.vd0.visit(this, h0);
        } else {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode("null");
            raiz.add(h0);
        }
        if (c.md1 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.md1.getClass().getName());
            raiz.add(h0);
            c.md1.visit(this, h0);
        }
        //--------------------------------------------------//
        if (c.id1 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.id1.value);
            raiz.add(h0);
        }
        //--------------------------------------------------//
        if (c.id2 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.id2.value);
            raiz.add(h0);
        }
        return null;
    }

    //------------------------------------------------------------------------------------------- 
    public Object visitAVarDeclaration(AVarDeclaration c, Object arg) {

        DefaultMutableTreeNode raiz = (DefaultMutableTreeNode) arg;
        if (c.t0 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.t0.getClass().getName());
            raiz.add(h0);
            c.t0.visit(this, h0);
        }
        //--------------------------------------------------//
        if (c.id1 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.id1.value);
            raiz.add(h0);
        }
        return null;
    }

    //------------------------------------------------------------------------------------------- 
    public Object visitAMethodDeclaration(AMethodDeclaration c, Object arg) {

        DefaultMutableTreeNode raiz = (DefaultMutableTreeNode) arg;
        if (c.t0 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.t0.getClass().getName());
            raiz.add(h0);
            c.t0.visit(this, h0);
        }
        //--------------------------------------------------//
        if (c.fpb1 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.fpb1.getClass().getName());
            raiz.add(h0);
            c.fpb1.visit(this, h0);
        }
        //--------------------------------------------------//
        if (c.vd2 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.vd2.getClass().getName());
            raiz.add(h0);
            c.vd2.visit(this, h0);
        }
        //--------------------------------------------------//
        if (c.sl3 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.sl3.getClass().getName());
            raiz.add(h0);
            c.sl3.visit(this, h0);
        }
        //--------------------------------------------------//
        if (c.e4 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.e4.getClass().getName());
            raiz.add(h0);
            c.e4.visit(this, h0);
        }
        //--------------------------------------------------//
        if (c.id1 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.id1.value);
            raiz.add(h0);
        }
        return null;
    }

    //------------------------------------------------------------------------------------------- 
    public Object visitAFormalParameterList(AFormalParameterList c, Object arg) {

        DefaultMutableTreeNode raiz = (DefaultMutableTreeNode) arg;
        if (c.fpl0 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.fpl0.getClass().getName());
            raiz.add(h0);
            c.fpl0.visit(this, h0);
        }
        return null;
    }

    //------------------------------------------------------------------------------------------- 
    public Object visitAFormalParameterListRest(AFormalParameterListRest c, Object arg) {

        DefaultMutableTreeNode raiz = (DefaultMutableTreeNode) arg;
        if (c.fpl0 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.fpl0.getClass().getName());
            raiz.add(h0);
            c.fpl0.visit(this, h0);
        }
//--------------------------------------------------//
        if (c.fpr1 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.fpr1.getClass().getName());
            raiz.add(h0);
            c.fpr1.visit(this, h0);
        }
        return null;
    }

    //------------------------------------------------------------------------------------------- 
    public Object visitAFormalParameter(AFormalParameter c, Object arg) {

        DefaultMutableTreeNode raiz = (DefaultMutableTreeNode) arg;
        if (c.t0 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.t0.getClass().getName());
            raiz.add(h0);
            c.t0.visit(this, h0);
        }
//--------------------------------------------------//
        if (c.id1 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.id1.value);
            raiz.add(h0);
        }
        return null;
    }

    //------------------------------------------------------------------------------------------- 
    public Object visitAFormalParameterRest(AFormalParameterRest c, Object arg) {

        DefaultMutableTreeNode raiz = (DefaultMutableTreeNode) arg;
        if (c.fpl0 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.fpl0.getClass().getName());
            raiz.add(h0);
            c.fpl0.visit(this, h0);
        }
        return null;
    }

    //------------------------------------------------------------------------------------------- 
    public Object visitATypeSimple(ATypeSimple c, Object arg) {

        DefaultMutableTreeNode raiz = (DefaultMutableTreeNode) arg;
        if (c.st0 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.st0.getClass().getName());
            raiz.add(h0);
            c.st0.visit(this, h0);
        }
        return null;
    }

    //------------------------------------------------------------------------------------------- 
    public Object visitATypeArray(ATypeArray c, Object arg) {

        DefaultMutableTreeNode raiz = (DefaultMutableTreeNode) arg;
        if (c.at0 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.at0.getClass().getName());
            raiz.add(h0);
            c.at0.visit(this, h0);
        }
        return null;
    }

    //------------------------------------------------------------------------------------------- 
    public Object visitATypeIdentifier(ATypeIdentifier c, Object arg) {

        return null;
    }

    //------------------------------------------------------------------------------------------- 
    public Object visitACharSimpleType(ACharSimpleType c, Object arg) {

        return null;
    }

    //------------------------------------------------------------------------------------------- 
    public Object visitABooleanSimpleType(ABooleanSimpleType c, Object arg) {

        return null;
    }

    //------------------------------------------------------------------------------------------- 
    public Object visitAnIntegerSimpleType(AnIntegerSimpleType c, Object arg) {

        return null;
    }

    //-------------------------------------------------------------------------------------------
    public Object visitAnArrayType(AnArrayType c, Object arg) {

        DefaultMutableTreeNode raiz = (DefaultMutableTreeNode) arg;
        if (c.st0 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.st0.getClass().getName());
            raiz.add(h0);
            c.st0.visit(this, h0);
        }
        return null;
    }

    //-------------------------------------------------------------------------------------------
    public Object visitAStatementBlock(AStatementBlock c, Object arg) {

        DefaultMutableTreeNode raiz = (DefaultMutableTreeNode) arg;
        if (c.b0 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.b0.getClass().getName());
            raiz.add(h0);
            c.b0.visit(this, h0);
        }
        return null;
    }

    //-------------------------------------------------------------------------------------------
    public Object visitAStatementAssignment(AStatementAssignment c, Object arg) {

        DefaultMutableTreeNode raiz = (DefaultMutableTreeNode) arg;
        if (c.as0 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.as0.getClass().getName());
            raiz.add(h0);
            c.as0.visit(this, h0);
        }
        return null;
    }

    //-------------------------------------------------------------------------------------------
    public Object visitAStatementArrayAssignment(AStatementArrayAssignment c, Object arg) {

        DefaultMutableTreeNode raiz = (DefaultMutableTreeNode) arg;
        if (c.aas0 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.aas0.getClass().getName());
            raiz.add(h0);
            c.aas0.visit(this, h0);
        }
        return null;
    }

    //-------------------------------------------------------------------------------------------
    public Object visitAStatementIf(AStatementIf c, Object arg) {

        DefaultMutableTreeNode raiz = (DefaultMutableTreeNode) arg;
        if (c.is0 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.is0.getClass().getName());
            raiz.add(h0);
            c.is0.visit(this, h0);
        }
        return null;
    }

    //-------------------------------------------------------------------------------------------
    public Object visitAStatementWhile(AStatementWhile c, Object arg) {

        DefaultMutableTreeNode raiz = (DefaultMutableTreeNode) arg;
        if (c.ws0 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.ws0.getClass().getName());
            raiz.add(h0);
            c.ws0.visit(this, h0);
        }
        return null;
    }

    //-------------------------------------------------------------------------------------------
    public Object visitAStatementSwitch(AStatementSwitch c, Object arg) {

        DefaultMutableTreeNode raiz = (DefaultMutableTreeNode) arg;
        if (c.ss0 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.ss0.getClass().getName());
            raiz.add(h0);
            c.ss0.visit(this, h0);
        }
        return null;
    }

    //-------------------------------------------------------------------------------------------
    public Object visitAStatementPrint(AStatementPrint c, Object arg) {

        DefaultMutableTreeNode raiz = (DefaultMutableTreeNode) arg;
        if (c.ps0 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.ps0.getClass().getName());
            raiz.add(h0);
            c.ps0.visit(this, h0);
        }
        return null;
    }

    //-------------------------------------------------------------------------------------------
    public Object visitABlock(ABlock c, Object arg) {

        DefaultMutableTreeNode raiz = (DefaultMutableTreeNode) arg;
        if (c.sl0 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.sl0.getClass().getName());
            raiz.add(h0);
            c.sl0.visit(this, h0);
        }
        return null;
    }

    //-------------------------------------------------------------------------------------------
    public Object visitAnAssignmentStatement(AnAssignmentStatement c, Object arg) {

        DefaultMutableTreeNode raiz = (DefaultMutableTreeNode) arg;
        if (c.e0 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.e0.getClass().getName());
            raiz.add(h0);
            c.e0.visit(this, h0);
        }

//--------------------------------------------------//
        if (c.id1 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.id1.value);
            raiz.add(h0);
        }
        return null;
    }

    //-------------------------------------------------------------------------------------------
    public Object visitAnArrayAssignmentStatement(AnArrayAssignmentStatement c, Object arg) {

        DefaultMutableTreeNode raiz = (DefaultMutableTreeNode) arg;
        if (c.e0 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.e0.getClass().getName());
            raiz.add(h0);
            c.e0.visit(this, h0);
        }
//--------------------------------------------------//
        if (c.e1 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.e1.getClass().getName());
            raiz.add(h0);
            c.e1.visit(this, h0);
        }
//--------------------------------------------------//
        if (c.id1 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.id1.value);
            raiz.add(h0);
        }
        return null;
    }

    //-------------------------------------------------------------------------------------------
    public Object visitAnIfStatement(AnIfStatement c, Object arg) {

        DefaultMutableTreeNode raiz = (DefaultMutableTreeNode) arg;
        if (c.e0 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.e0.getClass().getName());
            raiz.add(h0);
            c.e0.visit(this, h0);
        }

//--------------------------------------------------//
        if (c.s1 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.s1.getClass().getName());
            raiz.add(h0);
            c.s1.visit(this, h0);
        }

//--------------------------------------------------//
        if (c.s2 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.s2.getClass().getName());
            raiz.add(h0);
            c.s2.visit(this, h0);
        }
        return null;
    }

    //-------------------------------------------------------------------------------------------
    public Object visitAWhileStatement(AWhileStatement c, Object arg) {

        DefaultMutableTreeNode raiz = (DefaultMutableTreeNode) arg;
        if (c.e0 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.e0.getClass().getName());
            raiz.add(h0);
            c.e0.visit(this, h0);
        }

//--------------------------------------------------//
        if (c.s1 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.s1.getClass().getName());
            raiz.add(h0);
            c.s1.visit(this, h0);
        }
        return null;
    }

    //-------------------------------------------------------------------------------------------
    public Object visitAPrintStatement(APrintStatement c, Object arg) {

        DefaultMutableTreeNode raiz = (DefaultMutableTreeNode) arg;
        if (c.e0 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.e0.getClass().getName());
            raiz.add(h0);
            c.e0.visit(this, h0);
        }
        return null;
    }

    //-------------------------------------------------------------------------------------------
    public Object visitAnExpressionAnd(AnExpressionAnd c, Object arg) {

        DefaultMutableTreeNode raiz = (DefaultMutableTreeNode) arg;
        if (c.ae0 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.ae0.getClass().getName());
            raiz.add(h0);
            c.ae0.visit(this, h0);
        }
        return null;
    }

    //-------------------------------------------------------------------------------------------
    public Object visitAnExpressionPlus(AnExpressionPlus c, Object arg) {

        DefaultMutableTreeNode raiz = (DefaultMutableTreeNode) arg;
        if (c.pe0 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.pe0.getClass().getName());
            raiz.add(h0);
            c.pe0.visit(this, h0);
        }
        return null;
    }

    //-------------------------------------------------------------------------------------------
    public Object visitAnExpressionMinus(AnExpressionMinus c, Object arg) {

        DefaultMutableTreeNode raiz = (DefaultMutableTreeNode) arg;
        if (c.me0 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.me0.getClass().getName());
            raiz.add(h0);
            c.me0.visit(this, h0);
        }
        return null;
    }

    //-------------------------------------------------------------------------------------------
    public Object visitAnExpressionTimes(AnExpressionTimes c, Object arg) {

        DefaultMutableTreeNode raiz = (DefaultMutableTreeNode) arg;
        if (c.te0 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.te0.getClass().getName());
            raiz.add(h0);
            c.te0.visit(this, h0);
        }
        return null;
    }

    //-------------------------------------------------------------------------------------------
    public Object visitAnExpressionArrayLookup(AnExpressionArrayLookup c, Object arg) {

        DefaultMutableTreeNode raiz = (DefaultMutableTreeNode) arg;
        if (c.al0 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.al0.getClass().getName());
            raiz.add(h0);
            c.al0.visit(this, h0);
        }
        return null;
    }

    //-------------------------------------------------------------------------------------------
    public Object visitAnExpressionArrayLenght(AnExpressionArrayLenght c, Object arg) {

        DefaultMutableTreeNode raiz = (DefaultMutableTreeNode) arg;
        if (c.al0 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.al0.getClass().getName());
            raiz.add(h0);
            c.al0.visit(this, h0);
        }
        return null;
    }

    //-------------------------------------------------------------------------------------------
    public Object visitAnExpressionMessage(AnExpressionMessage c, Object arg) {

        DefaultMutableTreeNode raiz = (DefaultMutableTreeNode) arg;
        if (c.ms0 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.ms0.getClass().getName());
            raiz.add(h0);
            c.ms0.visit(this, h0);
        }
        return null;
    }

    //-------------------------------------------------------------------------------------------
    public Object visitAnExpressionPrimary(AnExpressionPrimary c, Object arg) {

        DefaultMutableTreeNode raiz = (DefaultMutableTreeNode) arg;
        if (c.pe0 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.pe0.getClass().getName());
            raiz.add(h0);
            c.pe0.visit(this, h0);
        }
        return null;
    }

    //-------------------------------------------------------------------------------------------
    public Object visitAnAndExpression(AnAndExpression c, Object arg) {

        DefaultMutableTreeNode raiz = (DefaultMutableTreeNode) arg;
        if (c.pe0 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.pe0.getClass().getName());
            raiz.add(h0);
            c.pe0.visit(this, h0);
        }
//--------------------------------------------------//
        if (c.pe1 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.pe1.getClass().getName());
            raiz.add(h0);
            c.pe1.visit(this, h0);
        }
        return null;
    }

    //------------------------------------------------------------------------------------------- 
    public Object visitAMenorQueExpression(AMenorQueExpression c, Object arg) {

        DefaultMutableTreeNode raiz = (DefaultMutableTreeNode) arg;
        if (c.pe0 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.pe0.getClass().getName());
            raiz.add(h0);
            c.pe0.visit(this, h0);
        }
//--------------------------------------------------//
        if (c.pe1 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.pe1.getClass().getName());
            raiz.add(h0);
            c.pe1.visit(this, h0);
        }
        return null;
    }

    //------------------------------------------------------------------------------------------- 
    public Object visitAMayorQueExpression(AMayorQueExpression c, Object arg) {

        DefaultMutableTreeNode raiz = (DefaultMutableTreeNode) arg;
        if (c.pe0 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.pe0.getClass().getName());
            raiz.add(h0);
            c.pe0.visit(this, h0);
        }
//--------------------------------------------------//
        if (c.pe1 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.pe1.getClass().getName());
            raiz.add(h0);
            c.pe1.visit(this, h0);
        }
        return null;
    }

    //------------------------------------------------------------------------------------------- 
    public Object visitAPlusExpression(APlusExpression c, Object arg) {

        DefaultMutableTreeNode raiz = (DefaultMutableTreeNode) arg;
        if (c.pe0 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.pe0.getClass().getName());
            raiz.add(h0);
            c.pe0.visit(this, h0);
        }
//--------------------------------------------------//
        if (c.pe1 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.pe1.getClass().getName());
            raiz.add(h0);
            c.pe1.visit(this, h0);
        }
        return null;
    }

    //------------------------------------------------------------------------------------------- 
    public Object visitAMinusExpression(AMinusExpression c, Object arg) {

        DefaultMutableTreeNode raiz = (DefaultMutableTreeNode) arg;
        if (c.pe0 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.pe0.getClass().getName());
            raiz.add(h0);
            c.pe0.visit(this, h0);
        }
//--------------------------------------------------//
        if (c.pe1 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.pe1.getClass().getName());
            raiz.add(h0);
            c.pe1.visit(this, h0);
        }
        return null;
    }

    //------------------------------------------------------------------------------------------- 
    public Object visitATimesExpression(ATimesExpression c, Object arg) {

        DefaultMutableTreeNode raiz = (DefaultMutableTreeNode) arg;
        if (c.pe0 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.pe0.getClass().getName());
            raiz.add(h0);
            c.pe0.visit(this, h0);
        }
//--------------------------------------------------//
        if (c.pe1 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.pe1.getClass().getName());
            raiz.add(h0);
            c.pe1.visit(this, h0);
        }
        return null;
    }

    //------------------------------------------------------------------------------------------- 
    public Object visitADivExpression(ADivExpression c, Object arg) {

        DefaultMutableTreeNode raiz = (DefaultMutableTreeNode) arg;
        if (c.pe0 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.pe0.getClass().getName());
            raiz.add(h0);
            c.pe0.visit(this, h0);
        }
//--------------------------------------------------//
        if (c.pe1 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.pe1.getClass().getName());
            raiz.add(h0);
            c.pe1.visit(this, h0);
        }
        return null;
    }

    //------------------------------------------------------------------------------------------- 
    public Object visitAnArrayLookup(AnArrayLookup c, Object arg) {

        DefaultMutableTreeNode raiz = (DefaultMutableTreeNode) arg;
        if (c.pe0 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.pe0.getClass().getName());
            raiz.add(h0);
            c.pe0.visit(this, h0);
        }
//--------------------------------------------------//
        if (c.pe1 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.pe1.getClass().getName());
            raiz.add(h0);
            c.pe1.visit(this, h0);
        }
        return null;
    }

    //------------------------------------------------------------------------------------------- 
    public Object visitAnArrayLength(AnArrayLength c, Object arg) {

        DefaultMutableTreeNode raiz = (DefaultMutableTreeNode) arg;
        if (c.pe0 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.pe0.getClass().getName());
            raiz.add(h0);
            c.pe0.visit(this, h0);
        }
        return null;
    }

    //------------------------------------------------------------------------------------------- 
    public Object visitAMessageSend(AMessageSend c, Object arg) {

        DefaultMutableTreeNode raiz = (DefaultMutableTreeNode) arg;
        if (c.pe0 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.pe0.getClass().getName());
            raiz.add(h0);
            c.pe0.visit(this, h0);
        }
//--------------------------------------------------//
        if (c.elb1 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.elb1.getClass().getName());
            raiz.add(h0);
            c.elb1.visit(this, h0);
        }
//--------------------------------------------------//
        if (c.id1 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.id1.value);
            raiz.add(h0);
        }
        return null;
    }

    //-------------------------------------------------------------------------------------------  
    public Object visitAnExpressionList(AnExpressionList c, Object arg) {

        DefaultMutableTreeNode raiz = (DefaultMutableTreeNode) arg;
        if (c.e0 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.e0.getClass().getName());
            raiz.add(h0);
            c.e0.visit(this, h0);
        }
        return null;
    }

    //-------------------------------------------------------------------------------------------   
    public Object visitAnExpressionListRest(AnExpressionListRest c, Object arg) {

        DefaultMutableTreeNode raiz = (DefaultMutableTreeNode) arg;
        if (c.el0 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.el0.getClass().getName());
            raiz.add(h0);
            c.el0.visit(this, h0);
        }
//--------------------------------------------------//
        if (c.er1 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.er1.getClass().getName());
            raiz.add(h0);
            c.er1.visit(this, h0);
        }
        return null;
    }

    //-------------------------------------------------------------------------------------------   
    public Object visitAnExpressionRest(AnExpressionRest c, Object arg) {

        DefaultMutableTreeNode raiz = (DefaultMutableTreeNode) arg;
        if (c.el != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.el.getClass().getName());
            raiz.add(h0);
            c.el.visit(this, h0);
        }
        return null;
    }

    //-------------------------------------------------------------------------------------------   
    public Object visitAPrimaryInteger(APrimaryInteger c, Object arg) {

        DefaultMutableTreeNode raiz = (DefaultMutableTreeNode) arg;
        if (c.int1 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.int1.value);
            raiz.add(h0);
        }
        return null;
    }

    //-------------------------------------------------------------------------------------------   
    public Object visitAPrimaryChar(APrimaryChar c, Object arg) {

        DefaultMutableTreeNode raiz = (DefaultMutableTreeNode) arg;
        if (c.ch1 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.ch1.value);
            raiz.add(h0);
        }
        return null;
    }

    //------------------------------------------------------------------------------------------- 
    public Object visitAPrimaryString(APrimaryString c, Object arg) {

        DefaultMutableTreeNode raiz = (DefaultMutableTreeNode) arg;
        if (c.str1 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.str1.value);
            raiz.add(h0);
        }
        return null;
    }

    //-------------------------------------------------------------------------------------------   
    public Object visitAPrimaryTrue(APrimaryTrue c, Object arg) {
        return null;
    }

    //-------------------------------------------------------------------------------------------  
    public Object visitAPrimaryFalse(APrimaryFalse c, Object arg) {
        return null;
    }

    //-------------------------------------------------------------------------------------------  
    public Object visitAPrimaryIdentifier(APrimaryIdentifier c, Object arg) {

        DefaultMutableTreeNode raiz = (DefaultMutableTreeNode) arg;
        if (c.id1 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.id1.value);
            raiz.add(h0);
        }
        return null;
    }

    //-------------------------------------------------------------------------------------------   
    public Object visitAPrimaryThis(APrimaryThis c, Object arg) {
        return null;
    }

    //-------------------------------------------------------------------------------------------  
    public Object visitAPrimaryAllocationExpression(APrimaryAllocationExpression c, Object arg) {

        DefaultMutableTreeNode raiz = (DefaultMutableTreeNode) arg;
        if (c.ae0 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.ae0.getClass().getName());
            raiz.add(h0);
            c.ae0.visit(this, h0);
        }
        return null;
    }

//-------------------------------------------------------------------------------------------  
    public Object visitAPrimaryNotExpression(APrimaryNotExpression c, Object arg) {

        DefaultMutableTreeNode raiz = (DefaultMutableTreeNode) arg;
        if (c.ne0 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.ne0.getClass().getName());
            raiz.add(h0);
            c.ne0.visit(this, h0);
        }
        return null;
    }

//------------------------------------------------------------------------------------------- 
    public Object visitAConstantInteger(AConstantInteger c, Object arg) {

        DefaultMutableTreeNode raiz = (DefaultMutableTreeNode) arg;
        if (c.int1 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.int1.value);
            raiz.add(h0);
        }
        return null;
    }

//------------------------------------------------------------------------------------------- 
    public Object visitAConstantChar(AConstantChar c, Object arg) {

        DefaultMutableTreeNode raiz = (DefaultMutableTreeNode) arg;
        if (c.c1 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.c1.value);
            raiz.add(h0);
        }
        return null;
    }

//------------------------------------------------------------------------------------------- 
    public Object visitAConstantString(AConstantString c, Object arg) {

        DefaultMutableTreeNode raiz = (DefaultMutableTreeNode) arg;
        if (c.str1 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.str1.value);
            raiz.add(h0);
        }
        return null;
    }

//------------------------------------------------------------------------------------------- 
    public Object visitAConstantTrue(AConstantTrue c, Object arg) {
        return null;
    }

//------------------------------------------------------------------------------------------- 
    public Object visitAConstantFalse(AConstantFalse c, Object arg) {
        return null;
    }

//------------------------------------------------------------------------------------------- 
    public Object visitAnArrayAllocationExpression(AnArrayAllocationExpression c, Object arg) {

        DefaultMutableTreeNode raiz = (DefaultMutableTreeNode) arg;
        if (c.e1 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.e1.getClass().getName());
            raiz.add(h0);
            c.e1.visit(this, h0);
        }
//--------------------------------------------------//
        if (c.st0 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.st0.getClass().getName());
            raiz.add(h0);
            c.st0.visit(this, h0);
        }
        return null;
    }

//------------------------------------------------------------------------------------------- 
    public Object visitAnAllocationExpression(AnAllocationExpression c, Object arg) {

        DefaultMutableTreeNode raiz = (DefaultMutableTreeNode) arg;
        if (c.id1 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.id1.value);
            raiz.add(h0);
        }
        return null;
    }

//------------------------------------------------------------------------------------------- 
    public Object visitANotExpression(ANotExpression c, Object arg) {

        DefaultMutableTreeNode raiz = (DefaultMutableTreeNode) arg;
        if (c.e0 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.e0.getClass().getName());
            raiz.add(h0);
            c.e0.visit(this, h0);
        }
        return null;
    }

//------------------------------------------------------------------------------------------- 
    public Object visitABracketExpression(ABracketExpression c, Object arg) {

        DefaultMutableTreeNode raiz = (DefaultMutableTreeNode) arg;
        if (c.e0 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.e0.getClass().getName());
            raiz.add(h0);
            c.e0.visit(this, h0);
        }
        return null;
    }

//------------------------------------------------------------------------------------------- 
    public Object visitAVarDecl(AVarDecl c, Object arg) {

        DefaultMutableTreeNode raiz = (DefaultMutableTreeNode) arg;
        if (c.vd0 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.vd0.getClass().getName());
            raiz.add(h0);
            c.vd0.visit(this, h0);
        }
//--------------------------------------------------//
        if (c.vd1 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.vd1.getClass().getName());
            raiz.add(h0);
            c.vd1.visit(this, h0);
        }
        return null;
    }

//------------------------------------------------------------------------------------------- 
    public Object visitAMethodDecl(AMethodDecl c, Object arg) {

        DefaultMutableTreeNode raiz = (DefaultMutableTreeNode) arg;
        if (c.md0 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.md0.getClass().getName());
            raiz.add(h0);
            c.md0.visit(this, h0);
        }
//--------------------------------------------------//
        if (c.md1 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.md1.getClass().getName());
            raiz.add(h0);
            c.md1.visit(this, h0);
        }
        return null;
    }

//------------------------------------------------------------------------------------------- 
    public Object visitAStatementList(AStatementList c, Object arg) {

        DefaultMutableTreeNode raiz = (DefaultMutableTreeNode) arg;
        if (c.sl0 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.sl0.getClass().getName());
            raiz.add(h0);
            c.sl0.visit(this, h0);
        }
//--------------------------------------------------//
        if (c.s1 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.s1.getClass().getName());
            raiz.add(h0);
            c.s1.visit(this, h0);
        }
        return null;
    }

//------------------------------------------------------------------------------------------- 
    public Object visitAnExpressionListBlock(AnExpressionListBlock c, Object arg) {

        DefaultMutableTreeNode raiz = (DefaultMutableTreeNode) arg;
        if (c.el0 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.el0.getClass().getName());
            raiz.add(h0);
            c.el0.visit(this, h0);
        }
        return null;
    }

//------------------------------------------------------------------------------------------- 
    public Object visitASwitchStatement(ASwitchStatement c, Object arg) {

        DefaultMutableTreeNode raiz = (DefaultMutableTreeNode) arg;
        if (c.e0 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.e0.getClass().getName());
            raiz.add(h0);
            c.e0.visit(this, h0);
        }
//--------------------------------------------------//
        if (c.sb1 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.sb1.getClass().getName());
            raiz.add(h0);
            c.sb1.visit(this, h0);
        }
        return null;
    }

//------------------------------------------------------------------------------------------- 
    public Object visitACaseBlock(ACaseBlock c, Object arg) {

        DefaultMutableTreeNode raiz = (DefaultMutableTreeNode) arg;
        if (c.ce0 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.ce0.getClass().getName());
            raiz.add(h0);
            c.ce0.visit(this, h0);
        }
//--------------------------------------------------//
        if (c.sl1 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.sl1.getClass().getName());
            raiz.add(h0);
            c.sl1.visit(this, h0);
        }
//--------------------------------------------------//
        if (c.bs2 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.bs2.getClass().getName());
            raiz.add(h0);
            c.bs2.visit(this, h0);
        }
        return null;
    }

//------------------------------------------------------------------------------------------- 
    public Object visitADefaultBlock(ADefaultBlock c, Object arg) {

        DefaultMutableTreeNode raiz = (DefaultMutableTreeNode) arg;
        if (c.sl0 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.sl0.getClass().getName());
            raiz.add(h0);
            c.sl0.visit(this, h0);
        }
//--------------------------------------------------//
        if (c.bs1 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.bs1.getClass().getName());
            raiz.add(h0);
            c.bs1.visit(this, h0);
        }
        return null;
    }

//-------------------------------------------------------------------------------------------   
    public Object visitACaseBlockList(ACaseBlockList c, Object arg) {

        DefaultMutableTreeNode raiz = (DefaultMutableTreeNode) arg;
        if (c.cbl0 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.cbl0.getClass().getName());
            raiz.add(h0);
            c.cbl0.visit(this, h0);
        }
//--------------------------------------------------//
        if (c.cb1 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.cb1.getClass().getName());
            raiz.add(h0);
            c.cb1.visit(this, h0);
        }
        return null;
    }

//-------------------------------------------------------------------------------------------   
    public Object visitASwitchBlock(ASwitchBlock c, Object arg) {

        DefaultMutableTreeNode raiz = (DefaultMutableTreeNode) arg;
        if (c.cbl0 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.cbl0.getClass().getName());
            raiz.add(h0);
            c.cbl0.visit(this, h0);
        }
//--------------------------------------------------//
        if (c.db1 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.db1.getClass().getName());
            raiz.add(h0);
            c.db1.visit(this, h0);
        }
        return null;
    }

//------------------------------------------------------------------------------------------- 
    public Object visitABreakStatement(ABreakStatement c, Object arg) {
        return null;
    }

//------------------------------------------------------------------------------------------- 
    public Object visitAPrimaryArray(APrimaryArray c, Object arg) {

        DefaultMutableTreeNode raiz = (DefaultMutableTreeNode) arg;
        if (c.aaae0 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.aaae0.getClass().getName());
            raiz.add(h0);
            c.aaae0.visit(this, h0);
        }
        return null;
    }

//------------------------------------------------------------------------------------------- 
    public Object visitASimpleTypeInt(ASimpleTypeInt c, Object arg) {
        return null;
    }

//------------------------------------------------------------------------------------------- 
    public Object visitASimpleTypeChar(ASimpleTypeChar c, Object arg) {
        return null;
    }

//------------------------------------------------------------------------------------------- 
    public Object visitASimpleTypeBool(ASimpleTypeBool c, Object arg) {
        return null;
    }

//------------------------------------------------------------------------------------------- 
    public Object visitAFormalParameterBlock(AFormalParameterBlock c, Object arg) {

        DefaultMutableTreeNode raiz = (DefaultMutableTreeNode) arg;
        if (c.fpl0 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.fpl0.getClass().getName());
            raiz.add(h0);
            c.fpl0.visit(this, h0);
        }
        return null;
    }

//------------------------------------------------------------------------------------------- 
    public Object visitAnExpressionDiv(AnExpressionDiv c, Object arg) {

        DefaultMutableTreeNode raiz = (DefaultMutableTreeNode) arg;
        if (c.de0 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.de0.getClass().getName());
            raiz.add(h0);
            c.de0.visit(this, h0);
        }
        return null;
    }

//-------------------------------------------------------------------------------------------  
    public Object visitAnExpressionMayor(AnExpressionMayor c, Object arg) {

        DefaultMutableTreeNode raiz = (DefaultMutableTreeNode) arg;
        if (c.mqe0 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.mqe0.getClass().getName());
            raiz.add(h0);
            c.mqe0.visit(this, h0);
        }
        return null;
    }

//-------------------------------------------------------------------------------------------   
    public Object visitAnExpressionMenor(AnExpressionMenor c, Object arg) {

        DefaultMutableTreeNode raiz = (DefaultMutableTreeNode) arg;
        if (c.mqe0 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.mqe0.getClass().getName());
            raiz.add(h0);
            c.mqe0.visit(this, h0);
        }
        return null;
    }

//-------------------------------------------------------------------------------------------  
    public Object visitAPrimaryBracket(APrimaryBracket c, Object arg) {

        DefaultMutableTreeNode raiz = (DefaultMutableTreeNode) arg;
        if (c.be0 != null) {
            DefaultMutableTreeNode h0 = new DefaultMutableTreeNode(c.be0.getClass().getName());
            raiz.add(h0);
            c.be0.visit(this, h0);
        }
        return null;
    }
//-------------------------------------------------------------------------------------------  
}
