package com.bancodebogota.interview.programmingskills;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.transaction.Transactional;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
class ProgrammingSkillsApplicationTest {

    @Autowired
    private MockMvc mockMvc;



    /**
     * test for Creating an employee
     */
    @Test
    void testCreateAnEmployee() throws Exception {
        mockMvc.perform( MockMvcRequestBuilders
                .post("/employees")
                .content(Constant.CREATE_USER)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(Constant.CREATE_USER));
    }

    /**
     * test for Creating an getting an employee
     */
    @Test
    void testObtainEmployees() throws Exception {

        mockMvc.perform( MockMvcRequestBuilders
                .get("/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(Constant.GET_USERS));
    }

    /**
     * test for setting a boss to an employee
     */
    @Test
    void testSetBossToEmployee() throws Exception {
        mockMvc.perform( MockMvcRequestBuilders
                .post("/employees/1/bosses")
                .content(Constant.CREATE_BOSS)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(Constant.CREATE_BOSS_RESPONSE));
    }


}

