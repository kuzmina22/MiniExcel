import java.util.Scanner;

public class Main {

    public static void main(String []args){
        Scanner in = new Scanner(System.in);
        System.out.println("For exit enter 'exit'");
        ExcelPage page = new ExcelPage();
        String s = in.nextLine();
        while (!s.equals("exit")) {
            page.newFormula(s);
            s = in.nextLine();
        }
    }

}
