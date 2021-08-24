package lib.User;

import lib.Mysql.Mysql_sheet;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Master extends User {
    //被管理人员信息表
    private Mysql_sheet sheet_managed;

    private User_Type manage_user_type;

    //空构造方法
    public Master() {

    }

    //设置被管理人员信息表
    public Master(Mysql_sheet sheet_managed) {
        this.sheet_managed = sheet_managed;
    }

    //返回被管理人员类型
    public User_Type getManage_user_type() {
        return manage_user_type;
    }

    //设置被管理人员类型
    public void setManage_user_type(User_Type manage_user_type) {
        this.manage_user_type = manage_user_type;
    }

    //设置被管理人员信息表
    public void initManagedSheet(String sheet_name, String[] sheet_words, int[] sheet_words_lim) {
        sheet_managed = new Mysql_sheet();
        sheet_managed.setMySql_sheet_name(sheet_name);
        sheet_managed.setMysql_sheet_word(sheet_words, sheet_words_lim);
    }

    //获取被管理人员数据集
    public ResultSet getManagedInfo() {
        return sheet_managed.getFullSheet();
    }

    //修改被管理成员信息
    public void setManagedInfo(String managed_num, String managed_num_value,
                               String managed_word, String managed_word_value) {
        String Operation = "设置 " + managed_num + " = " + managed_num_value + " 的 " + managed_word + " = " + managed_word_value;
        updateOperations(Operation);
        sheet_managed.update(managed_num, managed_num_value, managed_word, managed_word_value);
    }

    //添加成员
    public boolean addManagedMember(String Member_num) {
        try {
            ResultSet resultSet = sheet_managed.search("工号", Member_num);
            while (resultSet.next()) {
                if (resultSet.getString("id") != null) {
                    return false;
                }
            }
            String Operation = "添加 工号 = " + Member_num;
            updateOperations(Operation);
            sheet_managed.add(new String[]{"工号"}, new String[]{Member_num});
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    //删除成员
    public void deleteManagedMember(String Member_num) {
        sheet_managed.delete("工号", Member_num);
        String Operation = "删除 工号 = " + Member_num;
        updateOperations(Operation);
    }

    //更新操作记录
    private void updateOperations(String Operation) {
        String str = super.getUserInfo("操作记录");
        if (str == null) {
            str = "";
        }
        String operations = str + Operation + "\n";
        super.updatePrivateInfo("操作记录", operations);
    }

    //获得被管理人员表类
    public Mysql_sheet getSheet_managed(){
        return sheet_managed;
    }
}
