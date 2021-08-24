public class Teacher extends Person{
    String Tno,Office;
    Teacher(int Age,String Name,String Tno,String Office)
    {
           this.Age=Age;
           this.Name=Name;
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
