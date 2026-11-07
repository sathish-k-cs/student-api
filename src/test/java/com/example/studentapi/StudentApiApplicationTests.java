package com.example.studentapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class StudentApiApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void healthCheck() throws Exception {
        mockMvc.perform(get("/health"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("UP"));
    }

    @Test
    void getStudents() throws Exception {
        mockMvc.perform(get("/students"))
                .andExpect(status().isOk());
    }

    @Test
    void addStudent() throws Exception {
        mockMvc.perform(post("/students")
                .contentType("application/json")
                .content("""
                    {
                        "name": "Rahul",
                        "email": "rahul@example.com"
                    }
                    """))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Rahul"));
    }
}
