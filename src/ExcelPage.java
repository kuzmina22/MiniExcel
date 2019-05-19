public class ExcelPage {

    private Cell[][] cells = new Cell[256][26];

    ExcelPage(){
        for (int i = 0; i < 256; i++)
            for (int j = 0; j < 26; j++)
                cells[i][j] = new Cell(i, j);
    }

    public void newFormula(String s){
        Operand operand1;
        Operand operand2;
        Operand operand3;
        Formula formula = new Formula(s);
        if (formula.getIndexOfEquality() == -1){
            operand1 = new Operand(formula, 0, formula.getLength());
            cells[operand1.getLine()][operand1.getColumn()].getValue();
            return;
        }
        operand1 = new Operand(formula, 0, formula.getIndexOfEquality());
        if (formula.getIndexOfOperator() == -1){
            operand2 = new Operand(formula, formula.getIndexOfEquality() + 1, formula.getLength());
            cells[operand1.getLine()][operand1.getColumn()].setValue(operand2.toDouble());
            return;
        }
        cells[operand1.getLine()][operand1.getColumn()].setFormula(new Formula(formula.getStr().substring(formula.getIndexOfEquality()+1)));
        operand2 = new Operand(formula, formula.getIndexOfEquality() + 1, formula.getIndexOfOperator());
        operand3 = new Operand(formula, formula.getIndexOfOperator() + 1, formula.getLength());
        if (!operand2.isCell() & !operand3.isCell()){
            cells[operand1.getLine()][operand1.getColumn()].setValue(operand2.toDouble(), operand3.toDouble());
            return;
        }
        if (operand2.isCell() & operand3.isCell()){
            cells[operand1.getLine()][operand1.getColumn()].setOperand(cells[operand2.getLine()][operand2.getColumn()],cells[operand3.getLine()][operand3.getColumn()]);
            return;
        }
        Cell buffCell = new Cell(256, 26);
        if (!operand2.isCell()){
            buffCell.setValue(operand2.toDouble());
            cells[operand1.getLine()][operand1.getColumn()].setOperand(buffCell,cells[operand3.getLine()][operand3.getColumn()]);
            return;
        }
        if (!operand3.isCell()){
            buffCell.setValue(operand3.toDouble());
            cells[operand1.getLine()][operand1.getColumn()].setOperand(cells[operand2.getLine()][operand2.getColumn()],buffCell);
        }
    }

}

