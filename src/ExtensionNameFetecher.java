import java.io.File;
public class ExtensionNameFetecher {
     public static String getFileExtension(File file)
    {
        String fname = file.getName();
        if(fname.lastIndexOf(".") != -1 && fname.lastIndexOf(".") != 0)
        
            return fname.substring(fname.lastIndexOf(".")+1);
        else
         return "wrong";   
    }
}
