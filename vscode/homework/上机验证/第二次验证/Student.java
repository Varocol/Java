class Student{ 
    String name;
    int english;
    int math;
    Student (String name,int english,int math)
    {
        this.name=name;
        this.math=math;
        this.english=english;
    }
    void output()
    {
        System.out.println("ѧ��������"+name+"\n"+"Ӣ��ɼ���"+english+"\n"+"��ѧ�ɼ���"+math);
    }
    void total()
    {
        System.out.println("�ܳɼ���"+(english+math));
    }
}