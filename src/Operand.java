public class Operand {

    private String operand;
    private int indexOfNegative;

    Operand(Formula formula, int startIndex, int endIndex){
        operand = formula.getStr().substring(startIndex, endIndex);
        indexOfNegative = operand.indexOf('-');
    }

    public boolean isCell(){
        return (operand.charAt(indexOfNegative + 1) >= 'A' & operand.charAt(indexOfNegative + 1) <= 'Z');
    }

    public int getColumn(){
        return operand.charAt(indexOfNegative + 1) - 'A';
    }

    public int getLine(){
        int number = 0;
        for (int i = operand.length() - 1; i > indexOfNegative + 1;  i--)
            number += (operand.charAt(i) - '0') * Math.pow(10, operand.length() - 1 - i);
        return number - 1;
    }

    public double toDouble(){
        return Double.parseDouble(operand);
    }

}
