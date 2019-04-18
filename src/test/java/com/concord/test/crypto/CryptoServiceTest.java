package com.concord.test.crypto;

import com.concord.test.crypto.CryptoService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class CryptoServiceTest {

    @InjectMocks
    CryptoService cryptoService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

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