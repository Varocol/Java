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
            System.out.println("正在设置折扣");
        }
    }
    public String getReport()
    {
        return "销售杂志报告";
    }
    Discount GetSaleRule(String name,int num)
    {
        System.out.println("销售折扣为："+Discount.GetSaleRule());

    }
    void SetSaleRule(double discount)
    {
        Discount.SetSaleRule(name,num,discount);
    }
    public void getmoney()
    {
        System.out.println("正在收取杂志："+ name +"的费用");
    }
}
