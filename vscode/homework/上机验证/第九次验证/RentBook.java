public class RentBook implements Report,Money{
      String name;
      int num;
      RentBook()
      {
          
      }
      RentBook(String name,int num,String command)
      {
         this.name = name;
         this.num = num; 
         if(command.equals("rent"))
         System.out.println("����ͼ��"+name+num);
         else if (command.equals("return") )
         System.out.println("�黹ͼ��"+name+num);
         else if (command.equals("lost") )
         System.out.println("ͼ�鶪ʧ"+name+num);
      }
      public String getReport()
      {
          return "����ͼ�鱨��";
      }
      void Booklost()
      {
          Account.getmoney(this);
      }
      public void getmoney()
      {
          System.out.println("������ȡͼ�飺"+ name +"�ķ���");
      }
      void Bookreturn()
      {
        System.out.println("���ڹ黹ͼ�飺"+ name);
      }
}