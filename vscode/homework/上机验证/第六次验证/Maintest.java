abstract class K{
    abstract double total();
}
class H extends K{
    double area;
    double price;
    H(double area,double price)
    {
        super();
        this.area=area;
        this.price=price;
    }
    double total()
    {
        return area*price;
    }
}
class G extends K{
    double maths;
    double chinese;
    int sno;
    G(double maths,double chinese,int sno)
    {
        super();
        this.maths=maths;
        this.chinese=chinese;
        this.sno=sno;
    }
    double total()
    {
        return (maths+chinese)/2;
    }
}
public class Maintest{
     public static void main(String args[])
     {
        K house =new H(100,20000);
        System.out.println("房屋的价格为:"+house.total());
        K student =new G(100,100,12);
        System.out.println("学生的平均分数为:"+student.total());

     }
}