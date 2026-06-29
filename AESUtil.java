import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AESUtil {

    private static final String KEY = "1234567890123456";

    private static final SecretKeySpec secretKey =
            new SecretKeySpec(KEY.getBytes(), "AES");

    public static String encrypt(String message) throws Exception {

        Cipher cipher = Cipher.getInstance("AES");

        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        return Base64.getEncoder().encodeToString(
                cipher.doFinal(message.getBytes()));
    }

    public static String decrypt(String encrypted) throws Exception {

        Cipher cipher = Cipher.getInstance("AES");

        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        return new String(
                cipher.doFinal(Base64.getDecoder().decode(encrypted)));
    }
}