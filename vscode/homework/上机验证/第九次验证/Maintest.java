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
            System.out.println("1.����ͼ�� " + "2.ͼ�鶪ʧ " + "3.�黹ͼ�� " + "4.������־ " + "5.�����ۿ� " + "6.��ȡ����");
            command = reader.next();
            if (command.equals("1")) {
                System.out.println("������ͼ�����֣����");
                name = reader.next();
                num = reader.nextInt();
                rentbook = new RentBook(name, num, "rent");
            } else if (command.equals("2")) {
                System.out.println("������ͼ�����֣����");
                name = reader.next();
                num = reader.nextInt();
                rentbook = new RentBook(name, num, "lost");
                rentbook.Booklost();
            } else if (command.equals("3")) {
                System.out.println("������ͼ�����֣����");
                name = reader.next();
                num = reader.nextInt();
                rentbook = new RentBook(name, num, "return");
                rentbook.Bookreturn();
            } else if (command.equals("4")) {
                System.out.println("��������־���֣����");
                name = reader.next();
                num = reader.nextInt();
                salemagazine = new SaleMagazine(name, num, "sale");
            } else if (command.equals("5")) {
                System.out.println("��������־���֣����");
                name = reader.next();
                num = reader.nextInt();
                salemagazine = new SaleMagazine(name, num, "set");
                System.out.println("�������ۿ�");
                salemagazine.SetSaleRule(reader.nextDouble());
            } else if (command.equals("6")) {
                System.out.println("������\"Magazine\"��\"Book\"");
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
