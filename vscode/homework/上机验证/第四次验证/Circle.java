public class Circle {
     Point point;
     double raduis;
     double area;
     double length;
     Circle()
     {
         
     }
     Circle(double x,double y,double raduis)
     {
         point=new Point(x,y);
         this.raduis=raduis;
     }
     void  getarea()
     {
         area=raduis*raduis*3.14;
     }
     void getlength()
     {
         length=raduis*2*3.14;
     }
     void Display()
     {
         System.out.println("圆的横纵坐标为:"+point.x+" "+ point.y);
         System.out.println("圆的面积为:"+area);
         System.out.println("圆的周长为:"+length);
     }
}
class Point{
     double x,y;
     Point(double x,double y)
     {
         this.x=x;
         this.y=y;
     }
}
