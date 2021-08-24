import java.io.*;
public class inputtest{
    public static void main(String args[])
    {
        byte tmp []=new byte[100];
        int n;
        try{
        FileInputStream in = new FileInputStream("inputtest.java");
        while((n=in.read(tmp,0,100))!=-1)
        {
            String s= new String(tmp,0,n);
            System.out.print(s);
        }
        in.close();
        }
        catch(IOException e)
        {
            
        }
    }
}