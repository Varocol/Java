import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class outputtest {
    public static void main(String args[])
    {
        byte a[] = "123".getBytes();
        try{
            File file =new File("1.txt");
            file.createNewFile();
            FileOutputStream out=new FileOutputStream(file);
            out.write(a);
            out.close();
        }
        catch(IOException e){}
    }
}
