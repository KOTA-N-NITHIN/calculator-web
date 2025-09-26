package com.example.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CalculatorController.class)
public class CalculatorControllerIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testAddition() throws Exception {
        mockMvc.perform(get("/calculator/compute")
                .param("num1", "5")
                .param("num2", "3")
                .param("operation", "add"))
               .andExpect(status().isOk())
               .andExpect(content().string("8.0"));
    }

    @Test
    void testSubtraction() throws Exception {
        mockMvc.perform(get("/calculator/compute")
                .param("num1", "10")
                .param("num2", "4")
                .param("operation", "subtract"))
               .andExpect(status().isOk())
               .andExpect(content().string("6.0"));
    }

    @Test
    void testMultiplication() throws Exception {
        mockMvc.perform(get("/calculator/compute")
                .param("num1", "6")
                .param("num2", "7")
                .param("operation", "multiply"))
               .andExpect(status().isOk())
               .andExpect(content().string("42.0"));
    }

    @Test
    void testDivision() throws Exception {
        mockMvc.perform(get("/calculator/compute")
                .param("num1", "20")
                .param("num2", "4")
                .param("operation", "divide"))
               .andExpect(status().isOk())
               .andExpect(content().string("5.0"));
    }

    @Test
    void testDivideByZero() throws Exception {
        mockMvc.perform(get("/calculator/compute")
                .param("num1", "10")
                .param("num2", "0")
                .param("operation", "divide"))
               .andExpect(status().isOk())
               .andExpect(content().string("0.0"));
    }

    @Test
    void testUnknownOperation() throws Exception {
        mockMvc.perform(get("/calculator/compute")
                .param("num1", "10")
                .param("num2", "5")
                .param("operation", "mod"))
               .andExpect(status().isOk())
               .andExpect(content().string("0.0"));
    }
}
