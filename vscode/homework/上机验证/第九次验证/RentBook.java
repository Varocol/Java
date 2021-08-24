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
         System.out.println("借阅图书"+name+num);
         else if (command.equals("return") )
         System.out.println("归还图书"+name+num);
         else if (command.equals("lost") )
         System.out.println("图书丢失"+name+num);
      }
      public String getReport()
      {
          return "借阅图书报告";
      }
      void Booklost()
      {
          Account.getmoney(this);
      }
      public void getmoney()
      {
          System.out.println("正在收取图书："+ name +"的费用");
      }
      void Bookreturn()
      {
        System.out.println("正在归还图书："+ name);
      }
}