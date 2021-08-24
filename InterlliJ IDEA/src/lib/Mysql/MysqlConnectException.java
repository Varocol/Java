package lib.Mysql;

//丢出数据库连接错误
public class MysqlConnectException extends Exception {
    MysqlConnectException() {
    }

    public void printerror(String taskId) {
        System.out.println("在执行" + taskId + "发生了无法连接数据库的错误");
    }
}
