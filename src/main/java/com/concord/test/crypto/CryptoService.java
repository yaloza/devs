package com.concord.test.crypto;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

@Service
public class CryptoService {

    @Value("${json.secret.key}")
    String secretKey;

    private static final String ALGORITHM = "AES";
    private static final String UTF = "UTF-8";


    public String encrypt(String str) {
        try {
            SecretKeySpec skeySpec = new SecretKeySpec(secretKey.getBytes(UTF), ALGORITHM);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec);

            byte[] encrypted = cipher.doFinal(str.getBytes());
            return Base64.encodeBase64String(encrypted);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;

    }

    public String decrypt(String str) {
        try {
            SecretKeySpec skeySpec = new SecretKeySpec(secretKey.getBytes(UTF), ALGORITHM);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec);
            byte[] cipherResult = cipher.doFinal(Base64.decodeBase64(str));
            return new String(cipherResult);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
