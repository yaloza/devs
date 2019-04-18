package com.concord.test.crypto;

import com.concord.test.crypto.model.CryptoRequestModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CryptoController.class)
public class CryptoControllerTests {
    @Autowired
    private MockMvc mvc;

    @MockBean
    CryptoService cryptoService;

    @Test
    public void cryptoTest() throws Exception {
        CryptoRequestModel requestModel = new CryptoRequestModel("Good job, Andrew! Well done.");
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonRequest = objectMapper.writeValueAsString(requestModel);

        given(cryptoService.encrypt(requestModel.getStr())).willReturn("NjWABimPl5mgCEOsoIb0qSCigl4Jg0oNlBcaUczq1ww=");

        mvc.perform(post("/api/encrypt")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequest))
                .andExpect(status().isOk());
    }

    @Test
    public void decryptoTest() throws Exception {
        CryptoRequestModel requestModel = new CryptoRequestModel("NjWABimPl5mgCEOsoIb0qSCigl4Jg0oNlBcaUczq1ww=");
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonRequest = objectMapper.writeValueAsString(requestModel);

        given(cryptoService.encrypt(requestModel.getStr())).willReturn("Good job, Andrew! Well done.");

        mvc.perform(post("/api/decrypt")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequest))
                .andExpect(status().isOk());
    }

}
