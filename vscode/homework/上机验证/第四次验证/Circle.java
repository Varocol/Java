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
         System.out.println("Բ�ĺ�������Ϊ:"+point.x+" "+ point.y);
         System.out.println("Բ�����Ϊ:"+area);
         System.out.println("Բ���ܳ�Ϊ:"+length);
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
