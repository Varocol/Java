import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Cylinder cylinder;
        Scanner reader=new Scanner(System.in);
        System.out.println("����Բ���ĵ�Բ�뾶:");
        double height=reader.nextDouble();
        System.out.println("����Բ���ĸ�:");
        double radius=reader.nextDouble();
        cylinder=new Cylinder(radius,height);
        System.out.printf("Բ�������Ϊ:"+cylinder.volume);
    }
}
