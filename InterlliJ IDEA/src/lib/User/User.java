package lib.User;

import lib.Mysql.MysqlDataErrorException;
import lib.Mysql.Mysql_sheet;
import lib.Mysql.Mysql_sheet_info;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
    //用户类型枚举
    public enum User_Type {
        super_master("超级管理员"), common_master("普通管理员"), common_member("普通员工");
        private final String user_type;

        public String getUserID() {
            return user_type;
        }

        private User_Type(String user_type) {
            this.user_type = user_type;
        }
    }

    //用户类型
    private User_Type user_type;
    //用户账号
    private String User_num;
    //用户密码
    private String User_pass;
    //用户信息表
    private Mysql_sheet mysql_sheet;

    //空构造方法
    public User() {

    }

    //设置用户账号密码
    public User(String User_num, String User_pass) {
        this.User_num = User_num;
        this.User_pass = User_pass;
    }

    //获取用户类型

    public User_Type getUser_type() {
        return user_type;
    }

    //设置用户账号密码
    public void setUserLaunchInfo(String User_num, String User_pass) {
        this.User_num = User_num;
        this.User_pass = User_pass;
    }

    //设置用户数据表信息,并初始化数据表类
    public void initUserSheet(String sheet_name, String[] sheet_words, int[] sheet_words_lim) {
        mysql_sheet = new Mysql_sheet();
        mysql_sheet.setMySql_sheet_name(sheet_name);
        mysql_sheet.setMysql_sheet_word(sheet_words, sheet_words_lim);
    }

    //用户个人信息同步(修改的话直接类名.属性)
    public void updatePrivateInfo(String sheet_word, String word_value) {
        mysql_sheet.update("账号", User_num, sheet_word, word_value);
    }

    //用户登录验证(账号不能重样),可以用工号或者账号登录
    public boolean launch() {
        boolean islaunched = false;
        if (User_pass == null) return false;
        try {
            ResultSet resultSet1 = mysql_sheet.search("账号", User_num);
            while (resultSet1.next()) {
                String str1 = resultSet1.getString("密码");
                String str2 = resultSet1.getString("是否注册");
                if (User_pass.equals(str1) && str2.equals("是")) {
                    islaunched = true;
                }
                break;
            }
            ResultSet resultSet2 = mysql_sheet.search("工号", User_num);
            while (resultSet2.next()) {
                String str1 = resultSet2.getString("密码");
                String str2 = resultSet2.getString("是否注册");
                if (User_pass.equals(resultSet2.getString("密码")) && str2.equals("是")) {
                    islaunched = true;
                    User_num = resultSet2.getString("账号");
                }
                break;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (!islaunched) {
            clearUserLaunchInfo();
        }
        return islaunched;
    }

    //获得用户字段值(属性)
    public String getUserInfo(String sheet_word) {
        try {
            ResultSet resultSet = mysql_sheet.search("账号", User_num);
            while (resultSet.next()) {
                try {
                    mysql_sheet.check(sheet_word);
                    return resultSet.getString(sheet_word);
                } catch (MysqlDataErrorException e) {
                    e.printerror();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //用户登录信息清空
    public void clearUserLaunchInfo() {
        User_num = null;
        User_pass = null;
    }

    //设置用户类型
    public void setUser_type(User_Type user_type) {
        this.user_type = user_type;
    }

    //用户注册
    public static String register(String user_type, String User_Job_num, String User_num, String User_pass) {
        Mysql_sheet mysql_sheet = new Mysql_sheet();
        if (user_type.equals(User_Type.common_master.getUserID())) {
            mysql_sheet.setMySql_sheet_name(Mysql_sheet_info.Mysql_Common_Master_info_sheet);
            mysql_sheet.setMysql_sheet_word(
                    Mysql_sheet_info.MySql_Common_Master_info_list,
                    Mysql_sheet_info.MySql_Common_Master_word_lim
            );
        } else if (user_type.equals(User_Type.common_member.getUserID())) {
            mysql_sheet.setMySql_sheet_name(Mysql_sheet_info.Mysql_Common_Member_info_sheet);
            mysql_sheet.setMysql_sheet_word(
                    Mysql_sheet_info.MySql_Common_Member_info_list,
                    Mysql_sheet_info.MySql_Common_Member_word_lim
            );
        } else {
            return "没有该身份类型";
        }
        try {
            if (mysql_sheet.search("工号", User_Job_num).next()){
                try {
                    ResultSet rs = mysql_sheet.search("账号", User_num);
                    if (rs.next()) {
                        return "该账号ID已被使用";
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    ResultSet rs = mysql_sheet.search("工号", User_Job_num);
                    rs.next();
                    if(rs.getString("是否注册").equals("是")){
                        return "该工号已被使用";
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                mysql_sheet.update(
                        "工号", User_Job_num,
                        "账号", User_num
                );
                mysql_sheet.update(
                        "工号", User_Job_num,
                        "密码", User_pass
                );
                mysql_sheet.update(
                        "工号", User_Job_num,
                        "是否注册", "是"
                );
                return "注册成功";
            } else{
                return "没有该工号";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "查询出错";
    }
}

