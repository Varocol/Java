class Point{
    double x,y;
    static int countp=0;
    Point(double x,double y)
    {
        this.x=x;
        this.y=y;
        countp++;
    }
    void output1()
    {
         System.out.println(x+" "+y);
    }
    static void output2()
    {
        System.out.println("点的个数为："+countp);
    }
}