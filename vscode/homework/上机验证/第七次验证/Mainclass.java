interface Geometry{
    public abstract double getArea();
    public abstract void   show();
}
class  Circle implements Geometry{
       double  radius;
       Circle(double radius)
       {
           this.radius = radius;
       }
       public double getArea()
       {
           return radius*radius*3.14;
       }
       public void  show()
       {
           System.out.println("圆的面积为:"+getArea());
       }
}
class  Rectangle implements Geometry{
    double  length;
    double  width;
    Rectangle(double length,double width)
    {
        this.length = length;
        this.width  = width;
    }
    public double getArea()
    {
        return length*width;
    }
    public void  show()
    {
        System.out.println("矩形面积为:"+getArea());
    }
}
public class Mainclass{
    public static void main(String args[])
    {
        Geometry area =new Circle(1.0);
        area.show();
        area =new Rectangle(1.0,2.0);
        area.show();
    }
}