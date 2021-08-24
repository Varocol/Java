package lib.User;

import lib.Mysql.Mysql_sheet_info;

public class Super_Master extends Master{
    //初始化超级管理员相关信息
    public Super_Master() {
        initUserSheet(
                Mysql_sheet_info.Mysql_Super_Master_info_sheet,
                Mysql_sheet_info.MySql_Super_Master_info_list,
                Mysql_sheet_info.MySql_Super_Master_word_lim
        );
        initManagedSheet(
                Mysql_sheet_info.Mysql_Common_Master_info_sheet,
                Mysql_sheet_info.MySql_Common_Master_info_list,
                Mysql_sheet_info.MySql_Common_Master_word_lim
        );
        setUser_type(User_Type.super_master);
        setManage_user_type(User_Type.common_master);
    }
}
