public class Discount{
     void SetRule()
     {
         System.out.println("���ô��۹���");
     }
     static double  GetSaleRule(String name,int num)
     {
         return 0.5;
     }
     static void SetSaleRule(String name,int num,double discount)
     {
        System.out.println("�����ۿ�Ϊ��"+discount);
     }
}