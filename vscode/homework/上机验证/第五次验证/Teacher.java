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
        System.out.println("��ʦ��:"+Tno);
        System.out.println("����:"+Name);
        System.out.println("����:"+Age);
        System.out.println("ְ��"+Office);
    }
}
