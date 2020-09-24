import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
public class ImageEncryptionDecryptionAlgorithm {
    private static final String str = "AES";
private static final String trans = "AES";
byte[] key;


   public static void encrypt(String key , File inputfile , File outputfile) throws Exception
         {
             doCrypto(Cipher.ENCRYPT_MODE , key , inputfile , outputfile);
         } 
   public static void Decrypt(String key , File inputfile , File outputfile) throws Exception
         {
             doCrypto(Cipher.ENCRYPT_MODE , key , inputfile , outputfile);
         } 
   
   private static void doCrypto(int cipherMode, String key, File inputfile, File outputfile) 
   {
       try
       {
           SecretKeySpec sks;
           sks = new SecretKeySpec(key.getBytes(),"AES");
           Cipher enc = Cipher.getInstance("AES");
           enc.init(cipherMode , sks);
           
       FileInputStream fis = new FileInputStream(inputfile);
       FileOutputStream fos = new FileOutputStream(outputfile);
       
       CipherOutputStream cos = new CipherOutputStream(fos, enc);
           byte[] buf = new byte[1024];
           int read;
           while((read=fis.read(buf)) != -1)
           {
               cos.write(buf , 0 , read);
           }
           fis.close();
           fos.flush();
           cos.flush();  
       }
       catch(IOException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException e)
       {
       }
   }
   











}
