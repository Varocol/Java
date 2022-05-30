package Datas;

import Tools.Connect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Book {
    public static final String sql_default = "SELECT * FROM book WHERE " +
            "(id = ? OR ? IS NULL) AND " +
            "(name = ? OR ? IS NULL) AND " +
            "(author = ? OR ? IS NULL) AND " +
            "(publisher = ? OR ? IS NULL) AND " +
            "(publishdate = ? OR ? IS NULL) AND " +
            "(stock = ? OR ? IS NULL) AND " +
            "(price = ? OR ? IS NULL) ";
    public static final String book_view_sql_default = "SELECT * FROM book_view WHERE " +
            "(id = ? OR ? IS NULL) AND " +
            "(name = ? OR ? IS NULL) AND " +
            "(author = ? OR ? IS NULL) AND " +
            "(publisher = ? OR ? IS NULL) AND " +
            "(publishdate = ? OR ? IS NULL) AND " +
            "(stock = ? OR ? IS NULL) AND " +
            "(price = ? OR ? IS NULL) ";
    private Integer id = null;
    private String name = null;
    private String author = null;
    private String publisher = null;
    private java.sql.Date publishDate = null;
    private Integer stock = null;
    private Double price = null;

    public Book() {
    }

    //获取book原表,拥有更灵活的查询功能
    public static List<Book> getBooks(Book book_filter, String sql) throws SQLException {
        PreparedStatement preparedStatement = Connect.conn.prepareStatement(sql);
        int data_index = 1;
        if (book_filter.id == null) {
            preparedStatement.setNull(data_index++, Types.INTEGER);
            preparedStatement.setNull(data_index++, Types.INTEGER);
        } else {
            preparedStatement.setInt(data_index++, book_filter.id);
            preparedStatement.setInt(data_index++, book_filter.id);
        }
        if (book_filter.name == null) {
            preparedStatement.setNull(data_index++, Types.VARCHAR);
            preparedStatement.setNull(data_index++, Types.VARCHAR);
        } else {
            preparedStatement.setString(data_index++, book_filter.name);
            preparedStatement.setString(data_index++, book_filter.name);
        }
        if (book_filter.author == null) {
            preparedStatement.setNull(data_index++, Types.VARCHAR);
            preparedStatement.setNull(data_index++, Types.VARCHAR);
        } else {
            preparedStatement.setString(data_index++, book_filter.author);
            preparedStatement.setString(data_index++, book_filter.author);
        }
        if (book_filter.publisher == null) {
            preparedStatement.setNull(data_index++, Types.VARCHAR);
            preparedStatement.setNull(data_index++, Types.VARCHAR);
        } else {
            preparedStatement.setString(data_index++, book_filter.publisher);
            preparedStatement.setString(data_index++, book_filter.publisher);
        }
        if (book_filter.publishDate == null) {
            preparedStatement.setNull(data_index++, Types.DATE);
            preparedStatement.setNull(data_index++, Types.DATE);
        } else {
            preparedStatement.setDate(data_index++, book_filter.publishDate);
            preparedStatement.setDate(data_index++, book_filter.publishDate);
        }
        if (book_filter.stock == null) {
            preparedStatement.setNull(data_index++, Types.INTEGER);
            preparedStatement.setNull(data_index++, Types.INTEGER);
        } else {
            preparedStatement.setInt(data_index++, book_filter.stock);
            preparedStatement.setInt(data_index++, book_filter.stock);
        }
        if (book_filter.price == null) {
            preparedStatement.setNull(data_index++, Types.DOUBLE);
            preparedStatement.setNull(data_index, Types.DOUBLE);
        } else {
            preparedStatement.setDouble(data_index++, book_filter.price);
            preparedStatement.setDouble(data_index, book_filter.price);
        }

        ResultSet resultSet = preparedStatement.executeQuery();
        List<Book> books = new ArrayList<>();
        while (resultSet.next()) {
            Book book = new Book();
            book.setId(resultSet.getInt("id"));
            book.setName(resultSet.getString("name"));
            book.setAuthor(resultSet.getString("author"));
            book.setPublisher(resultSet.getString("publisher"));
            book.setPublishDate(resultSet.getDate("publishdate"));
            book.setStock(resultSet.getInt("stock"));
            book.setPrice(resultSet.getDouble("price"));
            books.add(book);
        }
        return books;
    }

    //获取book原表
    public static List<Book> getBooks(Book book_filter) throws SQLException {
        return getBooks(book_filter, sql_default);
    }

    //获取book_view视图
    public static List<Book> getBook_View(Book book_filter, String sql) throws SQLException {
        return getBooks(book_filter, sql);
    }

    public static void addBook(Book book) throws SQLException {
        String sql_statement = "INSERT INTO book (name, author, publisher, " +
                "publishdate, stock, price) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement;
        int index = 1;
        preparedStatement = Connect.conn.prepareStatement(sql_statement);
        preparedStatement.setString(index++, book.name);
        preparedStatement.setString(index++, book.author);
        preparedStatement.setString(index++, book.publisher);
        preparedStatement.setDate(index++, book.publishDate);
        preparedStatement.setInt(index++, book.stock);
        preparedStatement.setDouble(index, book.price);
        preparedStatement.executeUpdate();
    }

    public static void updateBook(Book book_filter) throws SQLException {
        String sql_statement = "UPDATE book SET " +
                "name = IFNULL(?,name)," +
                "author = IFNULL(?,author)," +
                "publisher = IFNULL(?,publisher)," +
                "publishdate = IFNULL(?,publishdate)," +
                "stock = IFNULL(?,stock)," +
                "price = IFNULL(?,price) " +
                "WHERE id = ?";
        PreparedStatement preparedStatement =
                Connect.conn.prepareStatement(sql_statement);
        int data_index = 1;
        if (book_filter.name == null) {
            preparedStatement.setNull(data_index++, Types.VARCHAR);
        } else {
            preparedStatement.setString(data_index++, book_filter.name);
        }
        if (book_filter.author == null) {
            preparedStatement.setNull(data_index++, Types.VARCHAR);
        } else {
            preparedStatement.setString(data_index++, book_filter.author);
        }
        if (book_filter.publisher == null) {
            preparedStatement.setNull(data_index++, Types.VARCHAR);
        } else {
            preparedStatement.setString(data_index++, book_filter.publisher);
        }
        if (book_filter.publishDate == null) {
            preparedStatement.setNull(data_index++, Types.DATE);
        } else {
            preparedStatement.setDate(data_index++, book_filter.publishDate);
        }
        if (book_filter.stock == null) {
            preparedStatement.setNull(data_index++, Types.INTEGER);
        } else {
            preparedStatement.setInt(data_index++, book_filter.stock);
        }
        if (book_filter.price == null) {
            preparedStatement.setNull(data_index++, Types.DOUBLE);
        } else {
            preparedStatement.setDouble(data_index++, book_filter.price);
        }
        preparedStatement.setInt(data_index, book_filter.id);
        preparedStatement.executeUpdate();
    }

    public static void deleteBook(Book book_filter) throws SQLException {
        PreparedStatement preparedStatement;
        String sql_statement = "DELETE FROM book WHERE id = ?";
        preparedStatement = Connect.conn.prepareStatement(sql_statement);
        preparedStatement.setInt(1, book_filter.getId());
        preparedStatement.executeUpdate();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        if (publishDate != null) {
            this.publishDate = new java.sql.Date(publishDate.getTime());
        }
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}
