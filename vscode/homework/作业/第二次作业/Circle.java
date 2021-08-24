class Circle{
    double radius;
    double length;
    double area;
    Circle(double radius)
    {
        this.radius=radius;
    }
    void calculateArea()
    {
        area=3.14*3.14*radius;
    }
    void calculateLength()
    {
        length=3.14*2*radius;
    }
}