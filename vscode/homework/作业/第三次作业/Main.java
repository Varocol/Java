import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Cylinder cylinder;
        Scanner reader=new Scanner(System.in);
        System.out.println("输入圆柱的底圆半径:");
        double height=reader.nextDouble();
        System.out.println("输入圆柱的高:");
        double radius=reader.nextDouble();
        cylinder=new Cylinder(radius,height);
        System.out.printf("圆柱的体积为:"+cylinder.volume);
    }
}
