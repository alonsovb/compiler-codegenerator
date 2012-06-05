package AST;

public interface Visitor {
    
    public Object visitAGoal(AGoal aThis, Object arg);

    public Object visitATypeDecl(ATypeDecl aThis, Object arg);

    public Object visitAMainClass(AMainClass c, Object arg);

    public Object visitATypeClassDeclaration(ATypeClassDeclaration c, Object arg);

    public Object visitATypeClassExtendsDeclaration(ATypeClassExtendsDeclaration c, Object arg);

    public Object visitAClassDeclaration(AClassDeclaration c, Object arg);

    public Object visitAClassExtendsDeclaration(AClassExtendsDeclaration c, Object arg);

    public Object visitAVarDeclaration(AVarDeclaration c, Object arg);

    public Object visitAMethodDeclaration(AMethodDeclaration c, Object arg);

    public Object visitAFormalParameterList(AFormalParameterList c, Object arg);

    public Object visitAFormalParameterListRest(AFormalParameterListRest c, Object arg);

    public Object visitAFormalParameter(AFormalParameter c, Object arg);

    public Object visitAFormalParameterRest(AFormalParameterRest c, Object arg);

    public Object visitATypeSimple(ATypeSimple c, Object arg);

    public Object visitATypeArray(ATypeArray c, Object arg);

    public Object visitATypeIdentifier(ATypeIdentifier c, Object arg);

    public Object visitACharSimpleType(ACharSimpleType c, Object arg);

    public Object visitABooleanSimpleType(ABooleanSimpleType c, Object arg);

    public Object visitAnIntegerSimpleType(AnIntegerSimpleType c, Object arg);

    public Object visitAnArrayType(AnArrayType c, Object arg);

    public Object visitAStatementBlock(AStatementBlock c, Object arg);

    public Object visitAStatementAssignment(AStatementAssignment c, Object arg);

    public Object visitAStatementArrayAssignment(AStatementArrayAssignment c, Object arg);

    public Object visitAStatementIf(AStatementIf c, Object arg);

    public Object visitAStatementWhile(AStatementWhile c, Object arg);

    public Object visitAStatementSwitch(AStatementSwitch c, Object arg);

    public Object visitAStatementPrint(AStatementPrint c, Object arg);

    public Object visitABlock(ABlock c, Object arg);

    public Object visitAnAssignmentStatement(AnAssignmentStatement c, Object arg);

    public Object visitAnArrayAssignmentStatement(AnArrayAssignmentStatement c, Object arg);

    public Object visitAnIfStatement(AnIfStatement c, Object arg);

    public Object visitAWhileStatement(AWhileStatement c, Object arg);

    public Object visitAPrintStatement(APrintStatement c, Object arg);

    public Object visitAnExpressionAnd(AnExpressionAnd c, Object arg);

    public Object visitAnExpressionPlus(AnExpressionPlus c, Object arg);

    public Object visitAnExpressionMinus(AnExpressionMinus c, Object arg);

    public Object visitAnExpressionTimes(AnExpressionTimes c, Object arg);

    public Object visitAnExpressionArrayLookup(AnExpressionArrayLookup c, Object arg);

    public Object visitAnExpressionArrayLenght(AnExpressionArrayLenght c, Object arg);

    public Object visitAnExpressionMessage(AnExpressionMessage c, Object arg);

    public Object visitAnExpressionPrimary(AnExpressionPrimary c, Object arg);

    public Object visitAnAndExpression(AnAndExpression c, Object arg);

    public Object visitAMenorQueExpression(AMenorQueExpression c, Object arg);

    public Object visitAMayorQueExpression(AMayorQueExpression c, Object arg);

    public Object visitAPlusExpression(APlusExpression c, Object arg);

    public Object visitAMinusExpression(AMinusExpression c, Object arg);

    public Object visitATimesExpression(ATimesExpression c, Object arg);

    public Object visitADivExpression(ADivExpression c, Object arg);

    public Object visitAnArrayLookup(AnArrayLookup c, Object arg);

    public Object visitAnArrayLength(AnArrayLength c, Object arg);

    public Object visitAMessageSend(AMessageSend c, Object arg);

    public Object visitAnExpressionList(AnExpressionList c, Object arg);

    public Object visitAnExpressionListRest(AnExpressionListRest c, Object arg);

    public Object visitAnExpressionRest(AnExpressionRest c, Object arg);

    public Object visitAPrimaryInteger(APrimaryInteger c, Object arg);

    public Object visitAPrimaryChar(APrimaryChar c, Object arg);

    public Object visitAPrimaryString(APrimaryString c, Object arg);

    public Object visitAPrimaryTrue(APrimaryTrue c, Object arg);

    public Object visitAPrimaryFalse(APrimaryFalse c, Object arg);

    public Object visitAPrimaryIdentifier(APrimaryIdentifier c, Object arg);

    public Object visitAPrimaryThis(APrimaryThis c, Object arg);

    public Object visitAPrimaryAllocationExpression(APrimaryAllocationExpression c, Object arg);

    public Object visitAPrimaryNotExpression(APrimaryNotExpression c, Object arg);

    public Object visitAConstantInteger(AConstantInteger c, Object arg);

    public Object visitAConstantChar(AConstantChar c, Object arg);

    public Object visitAConstantString(AConstantString c, Object arg);

    public Object visitAConstantTrue(AConstantTrue c, Object arg);

    public Object visitAConstantFalse(AConstantFalse c, Object arg);

    public Object visitAnArrayAllocationExpression(AnArrayAllocationExpression c, Object arg);

    public Object visitAnAllocationExpression(AnAllocationExpression c, Object arg);

    public Object visitANotExpression(ANotExpression c, Object arg);

    public Object visitABracketExpression(ABracketExpression c, Object arg);

    public Object visitAVarDecl(AVarDecl c, Object arg);

    public Object visitAMethodDecl(AMethodDecl c, Object arg);

    public Object visitAStatementList(AStatementList c, Object arg);

    public Object visitAnExpressionListBlock(AnExpressionListBlock c, Object arg);

    public Object visitASwitchStatement(ASwitchStatement c, Object arg);

    public Object visitACaseBlock(ACaseBlock c, Object arg);

    public Object visitADefaultBlock(ADefaultBlock c, Object arg);

    public Object visitACaseBlockList(ACaseBlockList c, Object arg);

    public Object visitASwitchBlock(ASwitchBlock c, Object arg);

    public Object visitABreakStatement(ABreakStatement c, Object arg);

    public Object visitAPrimaryArray(APrimaryArray c, Object arg);

    public Object visitASimpleTypeInt(ASimpleTypeInt c, Object arg);

    public Object visitASimpleTypeChar(ASimpleTypeChar c, Object arg);

    public Object visitASimpleTypeBool(ASimpleTypeBool c, Object arg);

    public Object visitAFormalParameterBlock(AFormalParameterBlock c, Object arg);

    public Object visitAnExpressionDiv(AnExpressionDiv c, Object arg);

    public Object visitAnExpressionMayor(AnExpressionMayor c, Object arg);

    public Object visitAnExpressionMenor(AnExpressionMenor c, Object arg);

    public Object visitAPrimaryBracket(APrimaryBracket c, Object arg);

}


