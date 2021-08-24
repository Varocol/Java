package lib.User;

import lib.Mysql.Mysql_sheet;
import lib.Mysql.Mysql_sheet_info;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Common_Master extends Master{

    public Common_Master(){
        initUserSheet(
                Mysql_sheet_info.Mysql_Common_Master_info_sheet,
                Mysql_sheet_info.MySql_Common_Master_info_list,
                Mysql_sheet_info.MySql_Common_Master_word_lim
        );
        initManagedSheet(
                Mysql_sheet_info.Mysql_Common_Member_info_sheet,
                Mysql_sheet_info.MySql_Common_Member_info_list,
                Mysql_sheet_info.MySql_Common_Member_word_lim
        );
        setUser_type(User_Type.common_master);
        setManage_user_type(User_Type.common_member);
    }
    //管理工资
    public void setMemberMoney(String managed_num,String managed_num_value,String Member_money){
        setManagedInfo(managed_num,managed_num_value,"工资",Member_money);
        setMemberMoneyChanges(managed_num,managed_num_value,Member_money);
    }
    //设置工资变化情况
    private void setMemberMoneyChanges(String managed_num,String managed_num_value,String Member_money){
        Mysql_sheet mysql_sheet = getSheet_managed();
        ResultSet resultSet = mysql_sheet.search(managed_num,managed_num_value);
        String temp =null;
        try {
            while(resultSet.next()){
                temp = resultSet.getString("工资变化情况");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        if(temp == null){
            temp ="";
        }
        temp = temp + Time.getTime() + " 本月工资 = " + Member_money + "\n";
        mysql_sheet.update(managed_num,managed_num_value,"工资变化情况",temp);

    }

}

