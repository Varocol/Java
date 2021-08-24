import lib.User.Common_Master;
import lib.User.Super_Master;

public class Test {
    public static void main(String[] args) {
        Super_Master super_master = new Super_Master();//创建
        super_master.setUserLaunchInfo("202015010112","jj6721456");//设置账户信息
        if(super_master.launch()){
            System.out.println("登录成功！");
        }//登录
        else{
            System.out.println("登录失败！");
        }
        System.out.println(super_master.getUserInfo("电话"));//获取账号本身信息
        super_master.updatePrivateInfo("姓名","欧阳嘉俊");//更改个人信息
        super_master.setManagedInfo("工号","202015010112","账号","1234");
        super_master.addManagedMember("202015010112");//添加账号
        super_master.deleteManagedMember("1");//删除账号
        Common_Master common_master = new Common_Master();
        common_master.setUserLaunchInfo("1234","111");
        if(common_master.launch()){
            System.out.println("登录成功！");
        }
        else {
            System.out.println("登录失败！");
        }
//        common_master.addManagedMember("1234");
        common_master.setMemberMoney("工号","1234","100000");
        System.out.println(common_master.getUserInfo("工号"));
    }
}
