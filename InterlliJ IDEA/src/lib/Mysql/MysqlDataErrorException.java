package lib.Mysql;

//数据格式错误
public class MysqlDataErrorException extends Exception {
    String Errormessage;

    MysqlDataErrorException(String Errormessage) {
        this.Errormessage = Errormessage;
    }

    public void printerror() {
        System.out.println("数据格式错误: " + Errormessage);
    }
}
