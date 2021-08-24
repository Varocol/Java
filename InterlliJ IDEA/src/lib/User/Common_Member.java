package lib.User;

import lib.Mysql.Mysql_sheet_info;

public class Common_Member extends User{
    public Common_Member(){
        initUserSheet(
                Mysql_sheet_info.Mysql_Common_Member_info_sheet,
                Mysql_sheet_info.MySql_Common_Member_info_list,
                Mysql_sheet_info.MySql_Common_Member_word_lim
        );
        setUser_type(User_Type.common_member);
    }
}
