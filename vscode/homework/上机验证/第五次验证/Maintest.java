public class Maintest {
     public static void main(String args[])
     {
         Teacher teacher =new Teacher(20,"张淑英","1","计算机教授");
         teacher.show();
     }
}
class Person{
    int Age;
    String Name;
    Person(String Name,int Age)
    {
        this.Age=Age;
        this.Name=Name;
    }
}
class Teacher extends Person{
    String Tno,Office;
    Teacher(int Age,String Name,String Tno,String Office)
    {
        super(Name,Age);
        this.Tno=Tno;
        this.Office=Office;
    }
    void show()
    {
        System.out.println("教师号:"+Tno);
        System.out.println("姓名:"+Name);
        System.out.println("年龄:"+Age);
        System.out.println("职称"+Office);
    }
}
