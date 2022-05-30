package Datas;

import Tools.Connect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Operation {
    public static final String sql_default = "SELECT * FROM operation WHERE " +
            "(id = ? OR ? IS NULL) AND " +
            "(date = ? OR ? IS NULL) AND " +
            "(bookname = ? OR ? IS NULL) AND " +
            "(username = ? OR ? IS NULL) AND " +
            "(operation = ? OR ? IS NULL) AND " +
            "(returntime = ? OR ? IS NULL) AND " +
            "(fine = ? OR ? IS NULL) AND " +
            "(quantity = ? OR ? IS NULL) AND " +
            "(status = ? OR ? IS NULL) AND " +
            "(bookid = ? OR ? IS NULL)";
    public static final String operationinfo_admin_sql_default = "SELECT * FROM operationinfo_admin WHERE " +
            "(id = ? OR ? IS NULL) AND " +
            "(date = ? OR ? IS NULL) AND " +
            "(bookname = ? OR ? IS NULL) AND " +
            "(username = ? OR ? IS NULL) AND " +
            "(operation = ? OR ? IS NULL) AND " +
            "(returntime = ? OR ? IS NULL) AND " +
            "(fine = ? OR ? IS NULL) AND " +
            "(quantity = ? OR ? IS NULL) AND " +
            "(status = ? OR ? IS NULL)";
    public static final String operationinfo_user_sql_default = "SELECT * FROM operationinfo_user WHERE " +
            "(date = ? OR ? IS NULL) AND " +
            "(bookname = ? OR ? IS NULL) AND " +
            "(username = ? OR ? IS NULL) AND " +
            "(operation = ? OR ? IS NULL) AND " +
            "(returntime = ? OR ? IS NULL) AND " +
            "(fine = ? OR ? IS NULL) AND " +
            "(quantity = ? OR ? IS NULL) AND " +
            "(status = ? OR ? IS NULL)";
    public static String BORROWED = "借出";
    public static String RETURNED = "归还";
    public static String ACCEPTED = "同意";
    public static String REJECTED = "拒绝";
    private Integer id = null;
    private Date date = null;
    private String userName = null;
    private String bookName = null;
    private String operation = null;
    private Integer quantity = null;
    private java.sql.Date dateReturn = null;
    private Double fine = null;
    private String status = null;
    private Integer bookId = null;

    public Operation() {

    }

    //获取operation原表,拥有更高的灵活性
    public static List<Operation> getOperations(Operation operation_filter,
                                                String sql) throws SQLException {
        PreparedStatement stmt = Connect.conn.prepareStatement(sql);
        int data_index = 1;
        if (operation_filter.id == null) {
            stmt.setNull(data_index++, Types.INTEGER);
            stmt.setNull(data_index++, Types.INTEGER);
        } else {
            stmt.setInt(data_index++, operation_filter.id);
            stmt.setInt(data_index++, operation_filter.id);
        }
        if (operation_filter.date == null) {
            stmt.setNull(data_index++, Types.DATE);
            stmt.setNull(data_index++, Types.DATE);
        } else {
            stmt.setDate(data_index++, new java.sql.Date(operation_filter.date.getTime()));
            stmt.setDate(data_index++, new java.sql.Date(operation_filter.date.getTime()));
        }
        if (operation_filter.bookName == null) {
            stmt.setNull(data_index++, Types.VARCHAR);
            stmt.setNull(data_index++, Types.VARCHAR);
        } else {
            stmt.setString(data_index++, operation_filter.bookName);
            stmt.setString(data_index++, operation_filter.bookName);
        }
        if (operation_filter.userName == null) {
            stmt.setNull(data_index++, Types.VARCHAR);
            stmt.setNull(data_index++, Types.VARCHAR);
        } else {
            stmt.setString(data_index++, operation_filter.userName);
            stmt.setString(data_index++, operation_filter.userName);
        }
        if (operation_filter.operation == null) {
            stmt.setNull(data_index++, Types.BOOLEAN);
            stmt.setNull(data_index++, Types.BOOLEAN);
        } else {
            stmt.setString(data_index++, operation_filter.operation);
            stmt.setString(data_index++, operation_filter.operation);
        }
        if (operation_filter.dateReturn == null) {
            stmt.setNull(data_index++, Types.DATE);
            stmt.setNull(data_index++, Types.DATE);
        } else {
            stmt.setDate(data_index++, operation_filter.dateReturn);
            stmt.setDate(data_index++, operation_filter.dateReturn);
        }
        if (operation_filter.fine == null) {
            stmt.setNull(data_index++, Types.INTEGER);
            stmt.setNull(data_index++, Types.INTEGER);
        } else {
            stmt.setDouble(data_index++, operation_filter.fine);
            stmt.setDouble(data_index++, operation_filter.fine);
        }
        if (operation_filter.quantity == null) {
            stmt.setNull(data_index++, Types.INTEGER);
            stmt.setNull(data_index++, Types.INTEGER);
        } else {
            stmt.setInt(data_index++, operation_filter.quantity);
            stmt.setInt(data_index++, operation_filter.quantity);
        }
        if (operation_filter.status == null) {
            stmt.setNull(data_index++, Types.VARCHAR);
            stmt.setNull(data_index++, Types.VARCHAR);
        } else {
            stmt.setString(data_index++, operation_filter.status);
            stmt.setString(data_index++, operation_filter.status);
        }
        if (operation_filter.bookId == null) {
            stmt.setNull(data_index++, Types.INTEGER);
            stmt.setNull(data_index, Types.INTEGER);
        } else {
            stmt.setInt(data_index++, operation_filter.bookId);
            stmt.setInt(data_index, operation_filter.bookId);
        }
        ResultSet rs = stmt.executeQuery();
        List<Operation> operations = new ArrayList<>();
        while (rs.next()) {
            Operation operation = new Operation();
            operation.setId(rs.getInt("id"));
            operation.setDate(rs.getTimestamp("date"));
            operation.setBookName(rs.getString("bookname"));
            operation.setUserName(rs.getString("username"));
            operation.setOperation(rs.getString("operation"));
            operation.setDateReturn(rs.getDate("returntime"));
            operation.setFine(rs.getDouble("fine"));
            operation.setQuantity(rs.getInt("quantity"));
            operation.setStatus(rs.getString("status"));
            operation.setBookId(rs.getInt("bookid"));
            operations.add(operation);
        }
        return operations;
    }

    //获取operation原表
    public static List<Operation> getOperations(Operation operation_filter) throws SQLException {
        return getOperations(operation_filter, sql_default);
    }

    //获取operationinfo_admin视图
    public static List<Operation> getOperationinfo_Admin(Operation operation_filter,
                                                         String sql) throws SQLException {
        PreparedStatement stmt = Connect.conn.prepareStatement(sql);
        int data_index = 1;
        if (operation_filter.id == null) {
            stmt.setNull(data_index++, Types.INTEGER);
            stmt.setNull(data_index++, Types.INTEGER);
        } else {
            stmt.setInt(data_index++, operation_filter.id);
            stmt.setInt(data_index++, operation_filter.id);
        }
        if (operation_filter.date == null) {
            stmt.setNull(data_index++, Types.DATE);
            stmt.setNull(data_index++, Types.DATE);
        } else {
            stmt.setDate(data_index++, new java.sql.Date(operation_filter.date.getTime()));
            stmt.setDate(data_index++, new java.sql.Date(operation_filter.date.getTime()));
        }
        if (operation_filter.bookName == null) {
            stmt.setNull(data_index++, Types.VARCHAR);
            stmt.setNull(data_index++, Types.VARCHAR);
        } else {
            stmt.setString(data_index++, operation_filter.bookName);
            stmt.setString(data_index++, operation_filter.bookName);
        }
        if (operation_filter.userName == null) {
            stmt.setNull(data_index++, Types.VARCHAR);
            stmt.setNull(data_index++, Types.VARCHAR);
        } else {
            stmt.setString(data_index++, operation_filter.userName);
            stmt.setString(data_index++, operation_filter.userName);
        }
        if (operation_filter.operation == null) {
            stmt.setNull(data_index++, Types.BOOLEAN);
            stmt.setNull(data_index++, Types.BOOLEAN);
        } else {
            stmt.setString(data_index++, operation_filter.operation);
            stmt.setString(data_index++, operation_filter.operation);
        }
        if (operation_filter.dateReturn == null) {
            stmt.setNull(data_index++, Types.DATE);
            stmt.setNull(data_index++, Types.DATE);
        } else {
            stmt.setDate(data_index++, operation_filter.dateReturn);
            stmt.setDate(data_index++, operation_filter.dateReturn);
        }
        if (operation_filter.fine == null) {
            stmt.setNull(data_index++, Types.INTEGER);
            stmt.setNull(data_index++, Types.INTEGER);
        } else {
            stmt.setDouble(data_index++, operation_filter.fine);
            stmt.setDouble(data_index++, operation_filter.fine);
        }
        if (operation_filter.quantity == null) {
            stmt.setNull(data_index++, Types.INTEGER);
            stmt.setNull(data_index++, Types.INTEGER);
        } else {
            stmt.setInt(data_index++, operation_filter.quantity);
            stmt.setInt(data_index++, operation_filter.quantity);
        }
        if (operation_filter.status == null) {
            stmt.setNull(data_index++, Types.VARCHAR);
            stmt.setNull(data_index, Types.VARCHAR);
        } else {
            stmt.setString(data_index++, operation_filter.status);
            stmt.setString(data_index, operation_filter.status);
        }
        ResultSet rs = stmt.executeQuery();
        List<Operation> operations = new ArrayList<>();
        while (rs.next()) {
            Operation operation = new Operation();
            operation.setId(rs.getInt("id"));
            operation.setDate(rs.getTimestamp("date"));
            operation.setBookName(rs.getString("bookname"));
            operation.setUserName(rs.getString("username"));
            operation.setOperation(rs.getString("operation"));
            operation.setDateReturn(rs.getDate("returntime"));
            operation.setFine(rs.getDouble("fine"));
            operation.setQuantity(rs.getInt("quantity"));
            operation.setStatus(rs.getString("status"));
            operations.add(operation);
        }
        return operations;
    }

    //获取operationinfo_user视图
    public static List<Operation> getOperationinfo_User(Operation operation_filter,
                                                        String sql) throws SQLException {
        PreparedStatement stmt = Connect.conn.prepareStatement(sql);
        int data_index = 1;
        if (operation_filter.date == null) {
            stmt.setNull(data_index++, Types.DATE);
            stmt.setNull(data_index++, Types.DATE);
        } else {
            stmt.setDate(data_index++, new java.sql.Date(operation_filter.date.getTime()));
            stmt.setDate(data_index++, new java.sql.Date(operation_filter.date.getTime()));
        }
        if (operation_filter.bookName == null) {
            stmt.setNull(data_index++, Types.VARCHAR);
            stmt.setNull(data_index++, Types.VARCHAR);
        } else {
            stmt.setString(data_index++, operation_filter.bookName);
            stmt.setString(data_index++, operation_filter.bookName);
        }
        if (operation_filter.userName == null) {
            stmt.setNull(data_index++, Types.VARCHAR);
            stmt.setNull(data_index++, Types.VARCHAR);
        } else {
            stmt.setString(data_index++, operation_filter.userName);
            stmt.setString(data_index++, operation_filter.userName);
        }
        if (operation_filter.operation == null) {
            stmt.setNull(data_index++, Types.BOOLEAN);
            stmt.setNull(data_index++, Types.BOOLEAN);
        } else {
            stmt.setString(data_index++, operation_filter.operation);
            stmt.setString(data_index++, operation_filter.operation);
        }
        if (operation_filter.dateReturn == null) {
            stmt.setNull(data_index++, Types.DATE);
            stmt.setNull(data_index++, Types.DATE);
        } else {
            stmt.setDate(data_index++, operation_filter.dateReturn);
            stmt.setDate(data_index++, operation_filter.dateReturn);
        }
        if (operation_filter.fine == null) {
            stmt.setNull(data_index++, Types.INTEGER);
            stmt.setNull(data_index++, Types.INTEGER);
        } else {
            stmt.setDouble(data_index++, operation_filter.fine);
            stmt.setDouble(data_index++, operation_filter.fine);
        }
        if (operation_filter.quantity == null) {
            stmt.setNull(data_index++, Types.INTEGER);
            stmt.setNull(data_index++, Types.INTEGER);
        } else {
            stmt.setInt(data_index++, operation_filter.quantity);
            stmt.setInt(data_index++, operation_filter.quantity);
        }
        if (operation_filter.status == null) {
            stmt.setNull(data_index++, Types.VARCHAR);
            stmt.setNull(data_index, Types.VARCHAR);
        } else {
            stmt.setString(data_index++, operation_filter.status);
            stmt.setString(data_index, operation_filter.status);
        }
        ResultSet rs = stmt.executeQuery();
        List<Operation> operations = new ArrayList<>();
        while (rs.next()) {
            Operation operation = new Operation();
            operation.setDate(rs.getTimestamp("date"));
            operation.setBookName(rs.getString("bookname"));
            operation.setUserName(rs.getString("username"));
            operation.setOperation(rs.getString("operation"));
            operation.setDateReturn(rs.getDate("returntime"));
            operation.setFine(rs.getDouble("fine"));
            operation.setQuantity(rs.getInt("quantity"));
            operation.setStatus(rs.getString("status"));
            operations.add(operation);
        }
        return operations;
    }

    public static void addOperation(Operation operation) throws SQLException {
        PreparedStatement stmt;
        String sql_statement = "INSERT INTO operation (bookname, username, " +
                "operation, quantity, returntime, bookid) VALUES ( ?, " +
                "?, ?, ?, ?,?)";
        int index = 1;
        stmt = Connect.conn.prepareStatement(sql_statement);
        stmt.setString(index++, operation.bookName);
        stmt.setString(index++, operation.userName);
        stmt.setString(index++, operation.operation);
        stmt.setInt(index++, operation.quantity);
        stmt.setDate(index++, new java.sql.Date(operation.dateReturn.getTime()));
        stmt.setInt(index, operation.bookId);
        stmt.executeUpdate();
    }

    public static void updateOperation(Operation operation_filter) throws SQLException {
        String sql_statement = "UPDATE operation SET " +
                "date = IFNULL(?,date)," +
                "bookname = IFNULL(?,bookname)," +
                "username = IFNULL(?,username)," +
                "operation = IFNULL(?,operation)," +
                "returntime = IFNULL(?,returntime)," +
                "fine = IFNULL(?,fine)," +
                "quantity = IFNULL(?,quantity)," +
                "status = IFNULL(?,status)," +
                "bookid = IFNULL(?,bookid) " +
                "WHERE id = ?";
        PreparedStatement stmt = Connect.conn.prepareStatement(sql_statement);
        int data_index = 1;
        if (operation_filter.date == null) {
            stmt.setNull(data_index++, Types.DATE);
        } else {
            stmt.setDate(data_index++, new java.sql.Date(operation_filter.date.getTime()));
        }
        if (operation_filter.userName == null) {
            stmt.setNull(data_index++, Types.VARCHAR);
        } else {
            stmt.setString(data_index++, operation_filter.userName);
        }
        if (operation_filter.bookName == null) {
            stmt.setNull(data_index++, Types.VARCHAR);
        } else {
            stmt.setString(data_index++, operation_filter.bookName);
        }
        if (operation_filter.operation == null) {
            stmt.setNull(data_index++, Types.VARCHAR);
        } else {
            stmt.setString(data_index++, operation_filter.operation);
        }
        if (operation_filter.dateReturn == null) {
            stmt.setNull(data_index++, Types.DATE);
        } else {
            stmt.setDate(data_index++, operation_filter.dateReturn);
        }
        if (operation_filter.fine == null) {
            stmt.setNull(data_index++, Types.DOUBLE);
        } else {
            stmt.setDouble(data_index++, operation_filter.fine);
        }
        if (operation_filter.quantity == null) {
            stmt.setNull(data_index++, Types.INTEGER);
        } else {
            stmt.setInt(data_index++, operation_filter.quantity);
        }
        if (operation_filter.status == null) {
            stmt.setNull(data_index++, Types.VARCHAR);
        } else {
            stmt.setString(data_index++, operation_filter.status);
        }
        if (operation_filter.bookId == null) {
            stmt.setNull(data_index++, Types.INTEGER);
        }
        stmt.setInt(data_index, operation_filter.id);
        stmt.executeUpdate();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Date getDateReturn() {
        return dateReturn;
    }

    public void setDateReturn(Date dateReturn) {
        if (dateReturn != null) {
            this.dateReturn = new java.sql.Date(dateReturn.getTime());
        }
    }

    public Double getFine() {
        return fine;
    }

    public void setFine(Double fine) {
        this.fine = fine;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }
}
