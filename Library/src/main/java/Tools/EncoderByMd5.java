package Tools;


import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class EncoderByMd5 {

    public static String EncoderByMd5(String str) throws NoSuchAlgorithmException,
            UnsupportedEncodingException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        Base64.Encoder base64en = Base64.getEncoder();
        byte[] bytes = md5.digest(str.getBytes(StandardCharsets.UTF_8));
        return new String(base64en.encode(new BigInteger(1, bytes).toString(16).getBytes()));
    }
}