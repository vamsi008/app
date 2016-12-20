package com.satisfaction.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.satisfaction.MaxSatisfaction;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = { MaxSatisfaction.class })
@ComponentScan
public class MaxSatisfactionServiceTest {

	@Autowired
	private MaxSatisfactionService maxSatisfactionService;

	/**
	 * 
	 * Test case to check for the dynamic programming solution.
	 * 
	 * @throws Exception
	 */
	@Test
	public void maxSatisfactionServiceTest() throws Exception {

		int time[] = new int[] { 250, 659 };
		int cal[] = new int[] { 16808, 50074 };
		int itemsCount = 2;
		int totalTime = 10000;

		int result = maxSatisfactionService.maxSatisfactionCalculator(totalTime, time, cal, itemsCount);
		assertEquals(result, 66882);

	}

}
