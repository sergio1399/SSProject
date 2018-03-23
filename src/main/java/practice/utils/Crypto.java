package practice.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * Created by sergi on 18.03.2018.
 */
public class Crypto {
    public static String generateHash(String source) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String target = "";
        MessageDigest encoder = MessageDigest.getInstance("SHA-256");
        byte[] digest = encoder.digest(source.getBytes("UTF-8"));
        return new String(Base64.getEncoder().encode(digest));
    }

    public static String genRandonStr()
    {
        String symbols = "qwertyuiopasdfghjklzxcvbnm1234567890";
        StringBuilder randString = new StringBuilder();
        int count = (int)(Math.random()*30);
        for(int i=0;i<count;i++)
            randString.append(symbols.charAt((int)(Math.random()*symbols.length())));
        return randString.toString();
    }
}
