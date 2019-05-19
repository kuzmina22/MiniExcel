public class Formula {

    private String formula;
    private int indexOfEquality;
    private int indexOfOperator;
    private char operator;

    Formula(String formula){
        this.formula = formula;
        indexOfEquality = this.formula.indexOf('=');
        indexOfOperator = this.setIndexOfOperator();
        if (indexOfOperator != -1) operator = formula.charAt(indexOfOperator);
    }

    public boolean isNull(){
        return (formula.equals(""));
    }

    public String getStr(){
        return formula;
    }

    public int getLength(){
        return formula.length();
    }

    public int getIndexOfEquality(){
        return indexOfEquality;
    }

    public int getIndexOfOperator(){
        return indexOfOperator;
    }

    public char getOperator(){
        return operator;
    }

    private int setIndexOfOperator(){
        for (int i = indexOfEquality + 2; i < formula.length(); i++)
            if (formula.charAt(i) == '+' | formula.charAt(i) == '-' | formula.charAt(i) == '*' | formula.charAt(i) == '/')
                return i;
        return -1;
    }

}
