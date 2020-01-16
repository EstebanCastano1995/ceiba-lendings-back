package com.ceiba.lendings.integracion;

import com.ceiba.lendings.LendingsApplication;
import com.ceiba.lendings.aplicacion.command.ClientCommand;
import com.ceiba.lendings.aplicacion.command.LendingCommand;
import com.ceiba.lendings.databuilder.ClientCommandTestDataBuilder;
import com.ceiba.lendings.databuilder.LendingCommandTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
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
public class LendingControllerTest {

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

    @After
    public void clear(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(null).build();
    }

    @Test
    public void createLending() throws Exception {
        ClientCommand comandoCliente = new ClientCommandTestDataBuilder().build();
        mockMvc.perform(post("/service/client").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoCliente)))
                .andExpect(status().isOk());

        LendingCommand lendingCommand = new LendingCommandTestDataBuilder().build();
        mockMvc.perform(post("/service/lending").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(lendingCommand)))
                .andExpect(status().isOk());
    }

    @Test
    public void updateLending() throws Exception {
        ClientCommand comandoCliente = new ClientCommandTestDataBuilder().build();
        mockMvc.perform(post("/service/client").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoCliente)))
                .andExpect(status().isOk());

        LendingCommand lendingCommand = new LendingCommandTestDataBuilder().build();
        mockMvc.perform(post("/service/lending").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(lendingCommand)))
                .andExpect(status().isOk());

        lendingCommand.setId((long)2);
        lendingCommand.setLendingvalue(478000.0);
        mockMvc.perform(post("/service/lending/update").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(lendingCommand)))
                .andExpect(status().isOk()).andReturn();
    }

    @Test
    public void listLendings() throws Exception {
        this.createLending();
        MvcResult resultmockMvc=mockMvc.perform(get("/service/lending").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].lendingvalue", is(470000.0)))
                .andReturn();
    }

}
