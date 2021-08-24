import java.util.*;

public class Maintest {
    public static void main(String args[]) {
        Scanner reader = new Scanner(System.in);
        RentBook rentbook;
        SaleMagazine salemagazine;
        String command;
        String name;
        int num;
        while (true) {
            System.out.println("1.借阅图书 " + "2.图书丢失 " + "3.归还图书 " + "4.销售杂志 " + "5.设置折扣 " + "6.获取报告");
            command = reader.next();
            if (command.equals("1")) {
                System.out.println("请输入图书名字，编号");
                name = reader.next();
                num = reader.nextInt();
                rentbook = new RentBook(name, num, "rent");
            } else if (command.equals("2")) {
                System.out.println("请输入图书名字，编号");
                name = reader.next();
                num = reader.nextInt();
                rentbook = new RentBook(name, num, "lost");
                rentbook.Booklost();
            } else if (command.equals("3")) {
                System.out.println("请输入图书名字，编号");
                name = reader.next();
                num = reader.nextInt();
                rentbook = new RentBook(name, num, "return");
                rentbook.Bookreturn();
            } else if (command.equals("4")) {
                System.out.println("请输入杂志名字，编号");
                name = reader.next();
                num = reader.nextInt();
                salemagazine = new SaleMagazine(name, num, "sale");
            } else if (command.equals("5")) {
                System.out.println("请输入杂志名字，编号");
                name = reader.next();
                num = reader.nextInt();
                salemagazine = new SaleMagazine(name, num, "set");
                System.out.println("请输入折扣");
                salemagazine.SetSaleRule(reader.nextDouble());
            } else if (command.equals("6")) {
                System.out.println("请输入\"Magazine\"或\"Book\"");
                name = reader.next();
                rentbook = new RentBook();
                salemagazine = new SaleMagazine();
                if (name.equals("Book")) {
                    Account.getReport(rentbook);
                } else {
                    Account.getReport(salemagazine);
                }
            }
        }
    }
}
