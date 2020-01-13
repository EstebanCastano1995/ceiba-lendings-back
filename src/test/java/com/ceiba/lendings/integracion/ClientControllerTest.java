package com.ceiba.lendings.integracion;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.ceiba.lendings.LendingsApplication;
import com.ceiba.lendings.aplicacion.command.ClientCommand;
import com.ceiba.lendings.databuilder.ClientCommandTestDataBuilder;
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
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LendingsApplication.class)
@AutoConfigureMockMvc
@Transactional
public class ClientControllerTest {
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
    public void createClient() throws Exception {
        ClientCommand comandoCliente = new ClientCommandTestDataBuilder().build();
        mockMvc.perform(post("/client").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoCliente))).andExpect(status().isOk());
    }

    @Test
    public void deleteClient() throws Exception {
        ClientCommand comandoCliente = new ClientCommandTestDataBuilder().build();
        mockMvc.perform(post("/client/delete").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoCliente))).andExpect(status().isOk());
    }
}
