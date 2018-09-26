package security;

import java.nio.ByteBuffer;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.tomcat.util.codec.binary.Base64;


public class Decryption {
  @SuppressWarnings("static-access")
  public String decrypt(String encryptedText) throws Exception {
	  
    String password="RxEVYHp`DX%8.eHZu+WDW9RktFU@}]+Q.F\"5G,BWGz<^3b/48vK7g3\"uUguDdM&<F!b#*PT+U9fq,(w6tZg>7}}{U_a}Km9N~/.SD\"V7`=R<D/NX=\"*=%fG4Y#DQ@9LzZa^c.F\\uQuhPdcGX*wsVJE$b\\7.$\"UD?3=N?yg$q{Etdgt'aX(H!BR8eF:*mG5GYsZ[@EYh2?5D}'Y4]^H,@9[*H7fzF\"=w}96'bGjkN+bHdzm[8`ukYZ>}a6.hR\"U=s";
    
    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    //strip off the salt and iv
    ByteBuffer buffer = ByteBuffer.wrap(new Base64().decode(encryptedText));
    byte[] saltBytes = new byte[20];
    buffer.get(saltBytes, 0, saltBytes.length);
    byte[] ivBytes1 = new byte[cipher.getBlockSize()];
    buffer.get(ivBytes1, 0, ivBytes1.length);
    byte[] encryptedTextBytes = new byte[buffer.capacity() - saltBytes.length - ivBytes1.length];
  
    buffer.get(encryptedTextBytes);
    // Deriving the key
    SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
    PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), saltBytes, 65556, 256);
    SecretKey secretKey = factory.generateSecret(spec);
    SecretKeySpec secret = new SecretKeySpec(secretKey.getEncoded(), "AES");
    cipher.init(Cipher.DECRYPT_MODE, secret, new IvParameterSpec(ivBytes1));
    byte[] decryptedTextBytes = null;
    try {
      decryptedTextBytes = cipher.doFinal(encryptedTextBytes);
    } catch (IllegalBlockSizeException e) {
        e.printStackTrace();
    } catch (BadPaddingException e) {
        e.printStackTrace();
    }
   
    return new String(decryptedTextBytes);
  }
}
