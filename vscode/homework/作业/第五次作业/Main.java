import java.sql.Struct;

abstract class K{
    abstract double count();
}

class Tax extends K
{
    double s;
    double k;
    double p;
    Tax(double s,double k,double p)
    {
        this.s=s;
        this.k=k;
        this.p=p;
    }
    double count()
    {
      if(k>=2.5)return s+(k-2.5)*p;
      else return s;
    }
}
class J extends K
{
    double m,c,e;
    String num;
    J(double m,double c,double e,String num)
    {
        this.e=e;
        this.m=m;
        this.c=c;
        this.num=num;
    }
    double count()
    {
        return (m+c+e)/3.0;
    }
}
public class Main{
    public static void main(String args[])
    {
        K money=new Tax(1.0,3.0,2.0);
        K student=new J(100,100,100,"202015010112");
        System.out.println("乘车费为:"+money.count());
        System.out.println("学生平均成绩:"+student.count());
    }
}