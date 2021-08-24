public class Discount{
     void SetRule()
     {
         System.out.println("设置打折规则");
     }
     static double  GetSaleRule(String name,int num)
     {
         return 0.5;
     }
     static void SetSaleRule(String name,int num,double discount)
     {
        System.out.println("设置折扣为："+discount);
     }
}