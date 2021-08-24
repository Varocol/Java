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
        System.out.println("学生姓名："+name+"\n"+"英语成绩："+english+"\n"+"数学成绩："+math);
    }
    void total()
    {
        System.out.println("总成绩："+(english+math));
    }
}