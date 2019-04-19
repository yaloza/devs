package com.concord.test.crypto;

import org.junit.Assert;
import org.junit.Test;

public class CryptoServiceTest {

    CryptoService cryptoService = new CryptoService();

    @Test
    public void encode() {
        cryptoService.secretKey = "ConcordTestDevel";
        String str = cryptoService.encrypt("Good job, Andrew! Well done.");
        System.out.println("encrypts str: " + str);
        Assert.assertTrue("NjWABimPl5mgCEOsoIb0qSCigl4Jg0oNlBcaUczq1ww=".equals(str));
    }

    @Test
    public void decode() {
        cryptoService.secretKey = "ConcordTestDevel";
        String decode = cryptoService.decrypt("NjWABimPl5mgCEOsoIb0qSCigl4Jg0oNlBcaUczq1ww=");
        System.out.println("decrypts str: " + decode);
        Assert.assertTrue("Good job, Andrew! Well done.".equals(decode));
    }
}