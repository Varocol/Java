public class Maintest {
     public static void main(String args[])
     {
         Teacher teacher =new Teacher(20,"����Ӣ","1","���������");
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
        System.out.println("��ʦ��:"+Tno);
        System.out.println("����:"+Name);
        System.out.println("����:"+Age);
        System.out.println("ְ��"+Office);
    }
}
