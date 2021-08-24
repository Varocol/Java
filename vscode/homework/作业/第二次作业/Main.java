public class Main {
    public static void main(String args[])
    {
        Circle circle=new Circle(2);
        circle.calculateArea();
        circle.calculateLength();
        System.out.println("圆的周长为："+circle.length+" "+"圆的面积为："+circle.area);
    }
}
