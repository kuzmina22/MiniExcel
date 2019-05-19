public class Cell {

    private Formula formula;
    private double value;
    private Cell operand1;
    private Cell operand2;
    private int line;
    private int column;

    Cell(int i, int j){
        line = i;
        column = j;
        formula = new Formula("");
    }

    public void setFormula (Formula formula){
        this.formula = formula;
    }

    public void getValue(){
        if (formula.isNull()){
            System.out.println(value);
            return;
        }
        formulaResult();
        System.out.println(value);
    }

    public void setValue(double value){
        this.value = value;
    }

    public void setValue(double a, double b){
        value = operation(a, b);
    }

    public void setOperand(Cell operand1, Cell operand2){
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    private void formulaResult(){
        if (this.line != operand1.line | this.column != operand1.column){
            if (!operand1.formula.isNull()) operand1.formulaResult();
        }
        if (this.line != operand2.line | this.column != operand2.column){
            if (!operand2.formula.isNull()) operand2.formulaResult();
        }
        this.value = operation(operand1.value, operand2.value);
    }

    private double operation(double a, double b) {
        switch (formula.getOperator()) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) {
                    System.out.println("Error in formula for " + (char)(column + 'A') + (line + 1) + "! Operand2 must be != 0");
                    return value;
                }
        }
        return a / b;
    }

}
