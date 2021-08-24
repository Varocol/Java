public class Circle{
    double radius;
    double length;
    double area;
    Circle()
    {
    }
    Circle(double radius)
    {
        this.radius=radius;
        getlength();
        getarea();
    }
    void getlength()
    {
        length=radius*2*3.14;
    }
    void getarea()
    {
        area=radius*radius*3.14;
    }

}
class circular extends Circle{
    double volume;
    double height;
    circular(double height,double radius)
    {
        super(radius);
        this.height=height;
        getvolume();
    }
    void getvolume()
    {
        volume=area*height;
    }
}