import java.security.Key;
import java.io.*;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;



public class DocumentEncryptionDecryptionAlgo {
private static final String str = "AES";
private static final String trans = "AES";
byte[] key;


     public static void encrypt(String key , File inputFile, File outputFile) throws Exception
         {
             doCrypto(Cipher.ENCRYPT_MODE , key , inputFile , outputFile);
         } 
     
     public static void decrypt(String key , File inputfile ,File outputfile) throws Exception
     {
         doCrypto(Cipher.DECRYPT_MODE , key , inputfile , outputfile);
     }
    private static void doCrypto(int cipherMode, String key, File inputFile, File outputFile) throws Exception
    {
       Key secretKey = new SecretKeySpec(key.getBytes(),str);
       Cipher cipher = Cipher.getInstance(trans);
       cipher.init(cipherMode, secretKey);
       
       FileInputStream fis = new FileInputStream(inputFile);
       byte[] inputBytes = new byte[(int) inputFile.length()];
       fis.read(inputBytes);
       
       byte[] outputBytes = cipher.doFinal(inputBytes);
       
       FileOutputStream fos = new FileOutputStream(outputFile);
       fos.write(outputBytes);
       
       fis.close();
       fos.close();
       
    }

         
        
}

