import java.io.*;
import java.util.*;
public class Maintest{
    public static void main(String args[])
    {
        try{
            File f1=new File("f1.txt");
            File f2=new File("f2.txt");
            if(!f1.exists())
            {
                f1.createNewFile();
            }
            if(!f2.exists())
            {
                f2.createNewFile();
            }
            FileWriter f1writer=new FileWriter(f1,false);
            FileWriter f2writer=new FileWriter(f2,true);
            StringBuffer str1 =new StringBuffer(); 
            StringBuffer str2 =new StringBuffer(); 
            FileReader in;
            Scanner reader=new Scanner(System.in);        
            for(int i=0;i<10;i++)
            {
                str1.append(String.valueOf(reader.nextInt())+" ");     
            }
            
            for(int i=0;i<10;i++)
            {
                str2.append(String.valueOf(reader.nextInt())+" ");     
            }
            f1writer.write(new String(str1));
            f2writer.write(new String(str2));
            f1writer.close();
            reader.close();
            char tom[]=new char[10];
            int n=-1;
            in = new FileReader(f1);
            while((n=in.read(tom,0,10))!=-1)
            {
                f2writer.write(tom,0,n);
            }
            in.close();
            f2writer.close();
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
    }
}