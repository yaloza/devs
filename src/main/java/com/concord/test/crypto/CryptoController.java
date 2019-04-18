package com.concord.test.crypto;

import com.concord.test.crypto.model.CryptoRequestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class CryptoController {

    @Autowired
    CryptoService cryptoService;

    @PostMapping("encrypt")
    @ResponseBody
    public String encrypt(@RequestBody CryptoRequestModel request) {
        return cryptoService.encrypt(request.getStr());

    }

    @PostMapping("decrypt")
    @ResponseBody
    public String decrypt(@RequestBody CryptoRequestModel request) {
        return cryptoService.decrypt(request.getStr());

    }


}
