import java.util.*;
public class Main {
    public static void main(String args[])
    {
        Point point;
        Scanner r=new Scanner(System.in);
        System.out.println("������������:");
        while(r.hasNextDouble())
        {
            point=new Point(r.nextDouble(),r.nextDouble());
            point.output1();
            Point.output2();
            System.out.println("������������:");
        }
    }
}
