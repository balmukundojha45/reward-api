package com.chartered.rewards;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Full integration tests for the Rewards API.
 * Verifies actual Spring Boot request-response flow.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class RewardsApiIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    /**
     * Tests that a valid customer returns reward data successfully.
     */
    @Test
    void testGetRewards_ValidCustomer_ReturnsOk() throws Exception {
        mockMvc.perform(get("/rewards/1")).andExpect(status().isOk()).andExpect(jsonPath("$.total").exists());
    }

    /**
     * Tests that an invalid customer returns error response.
     */
    @Test
    void testGetRewards_InvalidCustomer_Returns500() throws Exception {
        mockMvc.perform(get("/rewards/InvalisId")).andExpect(status().isInternalServerError());
    }
}
