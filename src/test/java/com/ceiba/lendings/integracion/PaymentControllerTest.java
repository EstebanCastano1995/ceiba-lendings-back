package com.ceiba.lendings.integracion;

import com.ceiba.lendings.LendingsApplication;
import com.ceiba.lendings.aplicacion.command.ClientCommand;
import com.ceiba.lendings.aplicacion.command.LendingCommand;
import com.ceiba.lendings.aplicacion.command.PaymentCommand;
import com.ceiba.lendings.databuilder.ClientCommandTestDataBuilder;
import com.ceiba.lendings.databuilder.LendingCommandTestDataBuilder;
import com.ceiba.lendings.databuilder.PaymentCommandDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LendingsApplication.class)
@AutoConfigureMockMvc
@Transactional
public class PaymentControllerTest {

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
    }

    @Test
    public void createPayment() throws Exception {

        /*ClientCommand clientCommand = new ClientCommandTestDataBuilder().build();
        mockMvc.perform(post("/client").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(clientCommand)))
                .andExpect(status().isOk());

        LendingCommand lendingCommand = new LendingCommandTestDataBuilder().build();
        mockMvc.perform(post("/lending").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(lendingCommand)))
                .andExpect(status().isOk());

        PaymentCommand paymentCommand = new PaymentCommandDataBuilder().build();
        mockMvc.perform(post("/payment").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(paymentCommand)))
                .andExpect(status().isOk());*/
    }
}
