import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;


public class TextEncryptionDecryption {
    
    public static String algo = "AES";
    public byte[] keyValue;


 public TextEncryptionDecryption(String key)
{
    keyValue = key.getBytes();
}
 
 public Key generateKey() throws Exception
 {
     Key key = new SecretKeySpec(keyValue,algo);
        return key;   
 }
 
 public String encrypt(String msg) throws Exception
 {
     
      Key key = generateKey();
      Cipher c = Cipher.getInstance(algo);
      c.init(Cipher.ENCRYPT_MODE, key);
      byte[] encval = c.doFinal(msg.getBytes());
      String encryptedValue = new BASE64Encoder().encode(encval);
      return encryptedValue;   
 }
 
 public String decrypt(String data) throws Exception
 {
     
       Key key = generateKey();
       Cipher c = Cipher.getInstance(algo);
       c.init(Cipher.DECRYPT_MODE, key);
        byte[] decordedValue = new BASE64Decoder().decodeBuffer(data);
        byte[] decval = c.doFinal(decordedValue);
        String decryptedval = new String(decval);
        return decryptedval;
     
 }
}

