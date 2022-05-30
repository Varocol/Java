package Datas;

import Tools.Connect;
import Tools.EncoderByMd5;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {
    //原表默认语句
    public static final String sql_default = "SELECT * FROM user WHERE " +
            "(id = ? OR ? IS NULL )AND " +
            "(name = ? OR ? IS NULL )AND " +
            "(password = ? OR ? IS NULL )AND " +
            "(sex = ? OR ? IS NULL )AND " +
            "(birthday = ? OR ? IS NULL )AND " +
            "(phone = ? OR ? IS NULL )AND " +
            "(registertime = ? OR ? IS NULL )AND " +
            "(state = ? OR ? IS NULL ) ";
    //视图默认语句
    public static final String user_view_sql_default = "SELECT * FROM user_view WHERE " +
            "(id = ? OR ? IS NULL )AND " +
            "(name = ? OR ? IS NULL )AND " +
            "(sex = ? OR ? IS NULL )AND " +
            "(birthday = ? OR ? IS NULL )AND " +
            "(phone = ? OR ? IS NULL )AND " +
            "(registertime = ? OR ? IS NULL )AND " +
            "(state = ? OR ? IS NULL ) ";
    public static final String UNACTIVATED = "未激活";
    public static final String COMMONUSER = "普通用户";
    public static final String ADMINISTRATOR = "管理员";
    public static final String MALE = "男";
    public static final String FEMALE = "女";
    public static User CurrentUser = null;
    private Integer id = null;
    private String name = null;
    private String password = null;
    private String sex = null;
    private java.sql.Date birthday = null;
    private String phoneNumber = null;
    private Date registerDate = null;
    private String state = null;
    private Image headicon = null;
    private String headiconPath = null;

    public User() {

    }

    //获取user原表,拥有更灵活的查询功能
    public static List<User> getUsers(User user_filter, String sql) throws SQLException,
            IOException, NoSuchAlgorithmException {
        PreparedStatement stmt = Connect.conn.prepareStatement(sql);
        int index = 1;
        if (user_filter.id == null) {
            stmt.setNull(index++, Types.INTEGER);
            stmt.setNull(index++, Types.INTEGER);
        } else {
            stmt.setInt(index++, user_filter.id);
            stmt.setInt(index++, user_filter.id);
        }
        if (user_filter.name == null) {
            stmt.setNull(index++, Types.VARCHAR);
            stmt.setNull(index++, Types.VARCHAR);
        } else {
            stmt.setString(index++, user_filter.name);
            stmt.setString(index++, user_filter.name);
        }
        if (user_filter.password == null) {
            stmt.setNull(index++, Types.VARCHAR);
            stmt.setNull(index++, Types.VARCHAR);
        } else {
            stmt.setString(index++, user_filter.password);
            stmt.setString(index++, user_filter.password);
        }
        if (user_filter.sex == null) {
            stmt.setNull(index++, Types.VARCHAR);
            stmt.setNull(index++, Types.VARCHAR);
        } else {
            stmt.setString(index++, user_filter.sex);
            stmt.setString(index++, user_filter.sex);
        }
        if (user_filter.birthday == null) {
            stmt.setNull(index++, Types.DATE);
            stmt.setNull(index++, Types.DATE);
        } else {
            stmt.setDate(index++, user_filter.birthday);
            stmt.setDate(index++, user_filter.birthday);
        }
        if (user_filter.phoneNumber == null) {
            stmt.setNull(index++, Types.VARCHAR);
            stmt.setNull(index++, Types.VARCHAR);
        } else {
            stmt.setString(index++, user_filter.phoneNumber);
            stmt.setString(index++, user_filter.phoneNumber);
        }
        if (user_filter.registerDate == null) {
            stmt.setNull(index++, Types.DATE);
            stmt.setNull(index++, Types.DATE);
        } else {
            stmt.setDate(index++, new java.sql.Date(user_filter.registerDate.getTime()));
            stmt.setDate(index++, new java.sql.Date(user_filter.registerDate.getTime()));
        }
        if (user_filter.state == null) {
            stmt.setNull(index++, Types.VARCHAR);
            stmt.setNull(index, Types.VARCHAR);
        } else {
            stmt.setString(index++, user_filter.state);
            stmt.setString(index, user_filter.state);
        }
        ResultSet rs = stmt.executeQuery();
        List<User> users = new ArrayList<>();
        while (rs.next()) {
            //获取图片
            Blob blob = rs.getBlob("img");
            //获取图片二进制流
            InputStream in = blob.getBinaryStream();
            //把程序当中的文件写到磁盘
            BufferedImage image = ImageIO.read(in);
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.password = rs.getString("password");
            user.setSex(rs.getString("sex"));
            user.setBirthday(rs.getDate("birthday"));
            user.setPhoneNumber(rs.getString("phone"));
            user.setRegisterDate(rs.getTimestamp("registertime"));
            user.setState(rs.getString("state"));
            user.setHeadicon(image);
            users.add(user);
        }
        return users;
    }

    //获取user原表
    public static List<User> getUsers(User user_filter) throws SQLException,
            IOException, NoSuchAlgorithmException {
        return getUsers(user_filter, sql_default);
    }

    //获取user_view视图
    public static List<User> getUser_View(User user_filter, String sql) throws SQLException {
        PreparedStatement stmt = Connect.conn.prepareStatement(sql);
        int index = 1;
        if (user_filter.id == null) {
            stmt.setNull(index++, Types.INTEGER);
            stmt.setNull(index++, Types.INTEGER);
        } else {
            stmt.setInt(index++, user_filter.id);
            stmt.setInt(index++, user_filter.id);
        }
        if (user_filter.name == null) {
            stmt.setNull(index++, Types.VARCHAR);
            stmt.setNull(index++, Types.VARCHAR);
        } else {
            stmt.setString(index++, user_filter.name);
            stmt.setString(index++, user_filter.name);
        }
        if (user_filter.sex == null) {
            stmt.setNull(index++, Types.VARCHAR);
            stmt.setNull(index++, Types.VARCHAR);
        } else {
            stmt.setString(index++, user_filter.sex);
            stmt.setString(index++, user_filter.sex);
        }
        if (user_filter.birthday == null) {
            stmt.setNull(index++, Types.DATE);
            stmt.setNull(index++, Types.DATE);
        } else {
            stmt.setDate(index++, user_filter.birthday);
            stmt.setDate(index++, user_filter.birthday);
        }
        if (user_filter.phoneNumber == null) {
            stmt.setNull(index++, Types.VARCHAR);
            stmt.setNull(index++, Types.VARCHAR);
        } else {
            stmt.setString(index++, user_filter.phoneNumber);
            stmt.setString(index++, user_filter.phoneNumber);
        }
        if (user_filter.registerDate == null) {
            stmt.setNull(index++, Types.DATE);
            stmt.setNull(index++, Types.DATE);
        } else {
            stmt.setDate(index++, new java.sql.Date(user_filter.registerDate.getTime()));
            stmt.setDate(index++, new java.sql.Date(user_filter.registerDate.getTime()));
        }
        if (user_filter.state == null) {
            stmt.setNull(index++, Types.VARCHAR);
            stmt.setNull(index, Types.VARCHAR);
        } else {
            stmt.setString(index++, user_filter.state);
            stmt.setString(index, user_filter.state);
        }
        ResultSet rs = stmt.executeQuery();
        List<User> users = new ArrayList<>();
        while (rs.next()) {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setSex(rs.getString("sex"));
            user.setBirthday(rs.getDate("birthday"));
            user.setPhoneNumber(rs.getString("phone"));
            user.setRegisterDate(rs.getTimestamp("registertime"));
            user.setState(rs.getString("state"));
            users.add(user);
        }
        return users;
    }

    public static void updateUser(User user_filter) throws SQLException, FileNotFoundException, ClassNotFoundException {
        String sql = "UPDATE user SET " +
                "name = IFNULL(?,name)," +
                "password = IFNULL(?,password)," +
                "sex = IFNULL(?,sex)," +
                "birthday = IFNULL(?,birthday)," +
                "phone = IFNULL(?,phone)," +
                "registertime = IFNULL(?,registertime)," +
                "state = IFNULL(?,state)," +
                "img = IFNULL(?,img) " +
                "WHERE id = ?";
        PreparedStatement stmt = Connect.conn.prepareStatement(sql);
        int index = 1;
        if (user_filter.name == null) {
            stmt.setNull(index++, Types.VARCHAR);
        } else {
            stmt.setString(index++, user_filter.name);
        }
        if (user_filter.password == null) {
            stmt.setNull(index++, Types.VARCHAR);
        } else {
            stmt.setString(index++, user_filter.password);
        }
        if (user_filter.sex == null) {
            stmt.setNull(index++, Types.VARCHAR);
        } else {
            stmt.setString(index++, user_filter.sex);
        }
        if (user_filter.birthday == null) {
            stmt.setNull(index++, Types.DATE);
        } else {
            stmt.setDate(index++, user_filter.birthday);
        }
        if (user_filter.phoneNumber == null) {
            stmt.setNull(index++, Types.VARCHAR);
        } else {
            stmt.setString(index++, user_filter.phoneNumber);
        }
        if (user_filter.registerDate == null) {
            stmt.setNull(index++, Types.DATE);
        } else {
            stmt.setDate(index++, new java.sql.Date(user_filter.registerDate.getTime()));
        }
        if (user_filter.state == null) {
            stmt.setNull(index++, Types.VARCHAR);
        } else {
            stmt.setString(index++, user_filter.state);
        }
        if (user_filter.headiconPath == null) {
            stmt.setNull(index++, Types.BLOB);
        } else {
            File file = new File(user_filter.headiconPath);
            InputStream in = new FileInputStream(file);
            stmt.setBlob(index++, in);
        }
        stmt.setInt(index, user_filter.id);
        stmt.executeUpdate();
    }

    public static void addUser(User user) throws SQLException, FileNotFoundException, ClassNotFoundException {
        String sql_statement = "INSERT INTO user (name,password,state,img)" +
                " VALUES (?,?,?,?);";
        PreparedStatement stmt = Connect.conn.prepareStatement(sql_statement);
        stmt.setString(1, user.getName());
        stmt.setString(2, user.getPassword());
        stmt.setString(3, user.getState());
        FileInputStream in = new FileInputStream(user.getHeadiconPath());
        stmt.setBlob(4, in);
        stmt.executeUpdate();
    }


    public static void deleteUser(User user_filter) throws SQLException{
        String sql_statement = "DELETE FROM user WHERE id = ?";
        PreparedStatement stmt = Connect.conn.prepareStatement(sql_statement);
        stmt.setInt(1, user_filter.getId());
        stmt.executeUpdate();
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        this.password = EncoderByMd5.EncoderByMd5(password);
    }

    public String getSex() {
        return this.sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return this.birthday;
    }

    public void setBirthday(Date birthday) {
        if (birthday != null) {
            this.birthday = new java.sql.Date(birthday.getTime());
        }
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Image getHeadicon() {
        return this.headicon;
    }

    public void setHeadicon(Image headicon) {
        this.headicon = headicon;
    }

    public String getHeadiconPath() {
        return this.headiconPath;
    }

    public void setHeadiconPath(String headiconPath) {
        this.headiconPath = headiconPath;
    }
}
