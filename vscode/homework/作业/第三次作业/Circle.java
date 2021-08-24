class Circle{
    double radius;
    double area;
    double length;
    Circle(double radius)
    {
        this.radius=radius;
    }
    void getarea()
    {
         area=radius*radius*3.14;
    }
    void getlength()
    {
        length=radius*2*3.14;
    }
}