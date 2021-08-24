package lib.Mysql;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

//对Mysql进行一次连接,静态连接(没有用实例化的方式,因为只有一个数据库)
class MysqlConnect {
    //JDBC链接器
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL =
            "jdbc:mysql://localhost:3306/" +
                    Mysql_launch_info.Mysql_Name +
                    "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    public Connection conn = null;
    public Statement state = null;  //万能的执行语句
    public PreparedStatement preparedStatement = null;

    //初始化数据库链接
    public void MysqlConnect_open() throws MysqlConnectException {
        //尝试连接
        try {
            //注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);
            //打开链接
            try {
                conn = DriverManager.getConnection(DB_URL,
                        Mysql_launch_info.MySql_User,
                        Mysql_launch_info.MySql_Pass);
                //创建查询实例对象
                try {
                    state = conn.createStatement();
                } catch (SQLException e) {
                    //无法创建对象
                    e.printStackTrace();
                    System.out.println("无法创建查询对象");
                    throw new MysqlConnectException();
                }
            } catch (SQLException e) {
                //SQL无法连接
                e.printStackTrace();
                System.out.println("无法链接数据库");
                throw new MysqlConnectException();
            }
        } catch (ClassNotFoundException e) {
            //Class无法找到错误
            e.printStackTrace();
            System.out.println("Class错误");
            throw new MysqlConnectException();
        } finally {
            //如果链接失败则关闭连接
            if (conn == null || state == null) {
                System.out.println("关闭查询链接,关闭数据数据库链接");
                MysqlConnect_close();
            }
        }
    }

    //关闭数据库连接
    public void MysqlConnect_close() {
        try {
            assert conn != null;
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            state.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

//数据表类
public class Mysql_sheet {
    //数据表名
    private String MySql_sheet_name = null;
    //字段名和长度限制
    private Map<String, Integer> Mysql_sheet_word = new HashMap<String, Integer>();
    //添加操作的Id
    String addId = "添加操作";
    //删除操作的Id
    String deleteId = "删除操作";
    //修改操作的Id
    String updateId = "修改操作";
    //查询操作的Id
    String searchId = "查询操作";

    //默认构造方法
    public Mysql_sheet() {

    }

    //初始化表名和字段名
    public Mysql_sheet(String MySql_sheet_name, Map<String, Integer> Mysql_sheet_word) {
        this.MySql_sheet_name = MySql_sheet_name;
        this.Mysql_sheet_word = Mysql_sheet_word;
    }

    //设置字段名和长度限制
    public void setMysql_sheet_word(String[] mysql_sheet_word, int[] mysql_word_value_lim) {
        //检查字段名和长度限制
        try {
            check(mysql_sheet_word, mysql_word_value_lim);
        } catch (MysqlDataErrorException e) {
            e.printerror();
            return;
        }
        for (int i = 0; i < mysql_sheet_word.length; i++) {
            Mysql_sheet_word.put(mysql_sheet_word[i], mysql_word_value_lim[i]);
        }
    }

    //设置表名
    public void setMySql_sheet_name(String MySql_sheet_name) {
        this.MySql_sheet_name = MySql_sheet_name;
    }

    //得到字段名和长度限制
    public Map<String, Integer> getMysql_sheet_word() {
        return Mysql_sheet_word;
    }

    //增加数据操作
    public void add(String[] sheet_words, String[] words_value) {
        //检查数据是否合理
        try {
            check(sheet_words, words_value);
        } catch (MysqlDataErrorException e) {
            e.printerror();
            return;
        }
        //创建一个数据库连接对象
        MysqlConnect mysqlConnect = new MysqlConnect();
        //尝试连接数据库
        try {
            mysqlConnect.MysqlConnect_open();
            StringBuffer Sql_Cmd = new StringBuffer("INSERT INTO " + MySql_sheet_name + "(");
            for (int i = 0; i < sheet_words.length; i++) {
                if (i != 0) Sql_Cmd.append(",");
                Sql_Cmd.append(sheet_words[i]);
            }
            Sql_Cmd.append(") values (");
            for (int i = 0; i < words_value.length; i++) {
                if (i != 0) Sql_Cmd.append(",");
                Sql_Cmd.append("?");
            }
            Sql_Cmd.append(")");
            try {
                mysqlConnect.preparedStatement = mysqlConnect.conn.prepareStatement(Sql_Cmd.toString());
                for (int i = 0; i < words_value.length; i++) {
                    mysqlConnect.preparedStatement.setString(i + 1, words_value[i]);
                }
                mysqlConnect.preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("数据库语句或数据错误");
            }
        } catch (MysqlConnectException e) {
            e.printerror(addId);
            mysqlConnect.MysqlConnect_close();
        }
    }

    //删除数据操作,一次只能删除一行
    public void delete(String sheet_words, String words_value) {
        //检查数据是否合理
        try {
            check(sheet_words);
        } catch (MysqlDataErrorException e) {
            e.printerror();
            return;
        }
        //创建一个数据库连接对象
        MysqlConnect mysqlConnect = new MysqlConnect();
        //尝试连接数据库
        try {
            mysqlConnect.MysqlConnect_open();
            StringBuffer Sql_Cmd = new StringBuffer("DELETE FROM " + MySql_sheet_name + " where " + sheet_words + "=?");
            try {
                mysqlConnect.preparedStatement = mysqlConnect.conn.prepareStatement(Sql_Cmd.toString());
                mysqlConnect.preparedStatement.setString(1, words_value);
                mysqlConnect.preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("数据库语句或数据错误");
            }
        } catch (MysqlConnectException e) {
            e.printerror(deleteId);
            mysqlConnect.MysqlConnect_close();
        }
    }

    //改动数据操作(只能改动一个)
    public void update(String sheet_marched_word, String sheet_marched_word_value,
                       String sheet_op_word, String sheet_op_word_value) {
        //检查数据是否合理
        try {
            check(sheet_marched_word);
            check(sheet_op_word);
            check(new String[]{sheet_op_word}, new String[]{sheet_op_word_value});
        } catch (MysqlDataErrorException e) {
            e.printerror();
            return;
        }
        //创建一个数据库连接对象
        MysqlConnect mysqlConnect = new MysqlConnect();
        //尝试连接数据库
        try {
            mysqlConnect.MysqlConnect_open();
            StringBuffer Sql_Cmd = new StringBuffer("UPDATE " + MySql_sheet_name + " SET  "
                    + sheet_op_word + "=?" + " WHERE " + sheet_marched_word + "=?");
            try {
                mysqlConnect.preparedStatement = mysqlConnect.conn.prepareStatement(Sql_Cmd.toString());
                mysqlConnect.preparedStatement.setString(1, sheet_op_word_value);
                mysqlConnect.preparedStatement.setString(2, sheet_marched_word_value);
                mysqlConnect.preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("数据库语句或数据错误");
            }
        } catch (MysqlConnectException e) {
            e.printerror(updateId);
            mysqlConnect.MysqlConnect_close();
        }
    }

    //查找数据操作(只允许查单个信息)
    public ResultSet search(String sheet_march_word, String sheet_march_word_value) {
        //检查数据是否正确
        try {
            check(sheet_march_word);
        } catch (MysqlDataErrorException e) {
            e.printerror();
            return null;
        }
        //创建一个数据库连接对象
        MysqlConnect mysqlConnect = new MysqlConnect();
        //尝试连接数据库
        try {
            mysqlConnect.MysqlConnect_open();
            String Sql_Cmd = "SELECT * FROM " + MySql_sheet_name + " WHERE " + sheet_march_word + "=?";
            try {
                mysqlConnect.preparedStatement = mysqlConnect.conn.prepareStatement(Sql_Cmd);
                mysqlConnect.preparedStatement.setString(1, sheet_march_word_value);
                return mysqlConnect.preparedStatement.executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("数据库语句或数据错误");
            }
        } catch (MysqlConnectException e) {
            e.printerror(searchId);
            mysqlConnect.MysqlConnect_close();
        }
        return null;
    }

    //查找数据操作全表
    public ResultSet getFullSheet() {
        //检查数据是否正确
        try {
            check();
        } catch (MysqlDataErrorException e) {
            e.printerror();
            return null;
        }
        //创建一个数据库连接对象
        MysqlConnect mysqlConnect = new MysqlConnect();
        //尝试连接数据库
        try {
            mysqlConnect.MysqlConnect_open();
            String Sql_Cmd = "SELECT * FROM " + MySql_sheet_name;
            try {
                mysqlConnect.preparedStatement = mysqlConnect.conn.prepareStatement(Sql_Cmd);
                return mysqlConnect.preparedStatement.executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("数据库语句或数据错误");
            }
        } catch (MysqlConnectException e) {
            e.printerror(searchId);
            mysqlConnect.MysqlConnect_close();
        }
        return null;
    }

    //检查字段名和长度限制
    private void check(String[] mysql_sheet_word, int[] mysql_word_value_lim) throws MysqlDataErrorException {
        if (mysql_sheet_word.length != mysql_word_value_lim.length) {
            throw new MysqlDataErrorException("字段个数与限制个数不一致");
        }
    }

    //检查add方法数据是否合理
    private void check(String[] sheet_words, String[] words_value) throws MysqlDataErrorException {
        //检查是否未设置字段和数据表名字
        check();
        //检查长度是否一致
        if (sheet_words.length != words_value.length) {
            throw new MysqlDataErrorException("字段个数与字段值个数不一致");
        }
        //检查是否有该数据字段
        for (String str : sheet_words) {
            if (!Mysql_sheet_word.containsKey(str)) {
                try {
                    check(str);
                } catch (MysqlDataErrorException e) {
                    return;
                }
            }
        }
        //检查数据字段是否在规定长度内
        {
            for (int i = 0; i < words_value.length; i++) {
                if (words_value[i].length() > Mysql_sheet_word.get(sheet_words[i])) {
                    throw new MysqlDataErrorException("数据长度不在范围内");
                }
            }
        }
    }

    //检查字段数据是否合理
    public void check(String sheet_words) throws MysqlDataErrorException {
        check();
        if (!Mysql_sheet_word.containsKey(sheet_words)) {
            throw new MysqlDataErrorException("没有该字段");
        }
    }

    //检查是否未设置字段和数据表名字
    private void check() throws MysqlDataErrorException {
        //检查数据表名是否为空
        if (MySql_sheet_name == null) {
            throw new MysqlDataErrorException("数据表名为空");
        }
        //检查数据字段是否为空
        if (Mysql_sheet_word == null) {
            throw new MysqlDataErrorException("数据表字段为空");
        }
    }
}