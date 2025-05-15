package com.xyzcompany.rewards;

import com.xyzcompany.rewards.controller.RewardController;
import com.xyzcompany.rewards.mock.MockTransactionData;
import com.xyzcompany.rewards.services.TransactionServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RewardController.class)
class RewardsApiApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private TransactionServices transactionServices;

	@Test
	public void testGetAllRewards() throws Exception {
		when(transactionServices.calculateMonthlyRewards(MockTransactionData.getTransactions()))
				.thenReturn(Collections.emptyList());

		mockMvc.perform(get("/api/rewards"))
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json"));
	}

	@Test
	public void testGetRewardsByCustomerId_NotFound() throws Exception {
		when(transactionServices.calculateMonthlyRewards(MockTransactionData.getTransactions()))
				.thenReturn(Collections.emptyList());

		mockMvc.perform(get("/api/rewards/99"))
				.andExpect(status().isNotFound());
	}
}
