package lib.Mysql;

//数据库表字段
public class Mysql_sheet_info {
    //数据库表名字
    public static final String Mysql_Super_Master_info_sheet = "超级管理员信息";
    public static final String Mysql_Common_Master_info_sheet = "普通管理员信息";
    public static final String Mysql_Common_Member_info_sheet = "普通员工信息";
    //超级管理员信息表字段
    public static final String[] MySql_Super_Master_info_list =
            {"id", "账号", "密码", "姓名", "性别", "年龄", "电话", "工号", "银行卡号", "入职时间", "工作时间", "部门", "邮箱", "操作记录", "是否注册"};
    //普通管理员信息表字段
    public static final String[] MySql_Common_Master_info_list =
            {"id", "账号", "密码", "姓名", "性别", "年龄", "电话", "工号", "银行卡号", "入职时间", "工作时间", "部门", "邮箱", "操作记录", "是否注册"};
    //普通员工信息表字段
    public static final String[] MySql_Common_Member_info_list =
            {"id", "账号", "密码", "姓名", "性别", "年龄", "电话", "工号", "工资", "银行卡号", "入职时间", "工作时间", "部门", "邮箱", "工资变化情况", "是否注册"};
    //超级管理员信息表字段限制长度
    public static final int[] MySql_Super_Master_word_lim =
            {11, 11, 11, 20, 1, 3, 11, 20, 20, 10, 10, 20, 30, Integer.MAX_VALUE, 1};
    //普通管理员信息表字段限制长度
    public static final int[] MySql_Common_Master_word_lim =
            {11, 11, 11, 20, 1, 3, 11, 20, 20, 10, 10, 20, 30, Integer.MAX_VALUE, 1};
    //普通员工信息表字段限制长度
    public static final int[] MySql_Common_Member_word_lim =
            {11, 11, 11, 20, 1, 3, 11, 20, Integer.MAX_VALUE, 20, 10, 10, 20, 30, Integer.MAX_VALUE, 1};
}
