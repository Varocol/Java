public class SaleMagazine implements Report,Money{
    String name;
    int num;
    SaleMagazine()
    {
        
    }
    SaleMagazine(String name,int num,String command)
    {
        this.name =name;
        this.num = num;
        
        if(command.equals("sale"))
        {
            Account.getmoney(this);
        }
        else if(command.equals("set"))
        {
            System.out.println("���������ۿ�");
        }
    }
    public String getReport()
    {
        return "������־����";
    }
    Discount GetSaleRule(String name,int num)
    {
        System.out.println("�����ۿ�Ϊ��"+Discount.GetSaleRule());

    }
    void SetSaleRule(double discount)
    {
        Discount.SetSaleRule(name,num,discount);
    }
    public void getmoney()
    {
        System.out.println("������ȡ��־��"+ name +"�ķ���");
    }
}
