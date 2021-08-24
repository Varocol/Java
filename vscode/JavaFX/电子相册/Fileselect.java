import java.io.*;

public class Fileselect {
    String [] pathlists;
    String [] getpathlist(String path,String...extend)
    {
        File dir = new File(path);
        FileAccept fileAccept = new FileAccept(extend);
        pathlists = getAbsolutepath(path,dir.list(fileAccept));
        return pathlists;
    }
    String [] getAbsolutepath(String parentpath,String [] lists)
    {
        String [] newlists = new String [lists.length];
        for(int i=0;i<lists.length;i++)
        {
            newlists[i] = parentpath + "\\" + lists[i];
        }
        return newlists;
    }
}
class FileAccept implements FilenameFilter{
    private String extendname[];
    public FileAccept(String ...extend)
    {
        for(String str:extend)
        {
            str = "."+str;
        }
        extendname = extend;
    }
    @Override
    public boolean accept(File dir, String name) {
        for(String str:extendname)
        {
            if(name.endsWith(str))
            {
                return true;
            }
        }
        return false;
    }
}