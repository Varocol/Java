public class Cylinder {
    Circle circle;
    double volume;
    Cylinder(double radius,double height)
    {
            circle=new Circle(radius);
            circle.getarea();
            volume=circle.area*height;
    }
}
