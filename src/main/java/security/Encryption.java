package security;

import java.security.AlgorithmParameters;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.tomcat.util.codec.binary.Base64;


public class Encryption {
  public String encrypt(String word) throws Exception {
    byte[] ivBytes;
    
    String password="RxEVYHp`DX%8.eHZu+WDW9RktFU@}]+Q.F\"5G,BWGz<^3b/48vK7g3\"uUguDdM&<F!b#*PT+U9fq,(w6tZg>7}}{U_a}Km9N~/.SD\"V7`=R<D/NX=\"*=%fG4Y#DQ@9LzZa^c.F\\uQuhPdcGX*wsVJE$b\\7.$\"UD?3=N?yg$q{Etdgt'aX(H!BR8eF:*mG5GYsZ[@EYh2?5D}'Y4]^H,@9[*H7fzF\"=w}96'bGjkN+bHdzm[8`ukYZ>}a6.hR\"U=s"; 
    

    
    SecureRandom random = new SecureRandom();
    byte bytes[] = new byte[20];
    random.nextBytes(bytes);
    byte[] saltBytes = bytes;
    // Derive the key
   SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
    PBEKeySpec spec = new PBEKeySpec(password.toCharArray(),saltBytes,65556,256);
     SecretKey secretKey = factory.generateSecret(spec);
    SecretKeySpec secret = new SecretKeySpec(secretKey.getEncoded(), "AES");
     //encrypting the word
     Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
     cipher.init(Cipher.ENCRYPT_MODE, secret);
     AlgorithmParameters params = cipher.getParameters();
     ivBytes =   params.getParameterSpec(IvParameterSpec.class).getIV();
     byte[] encryptedTextBytes =                          cipher.doFinal(word.getBytes("UTF-8"));
     //prepend salt and vi
      byte[] buffer = new byte[saltBytes.length + ivBytes.length + encryptedTextBytes.length];
      System.arraycopy(saltBytes, 0, buffer, 0, saltBytes.length);
      System.arraycopy(ivBytes, 0, buffer, saltBytes.length, ivBytes.length);
       System.arraycopy(encryptedTextBytes, 0, buffer, saltBytes.length + ivBytes.length, encryptedTextBytes.length);
       return new Base64().encodeToString(buffer);
    }
}
