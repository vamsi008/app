package com.satisfaction.web;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.File;
import java.io.FileInputStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.satisfaction.MaxSatisfaction;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = { MaxSatisfaction.class })
@ComponentScan
public class MaxSatisfactionControllerTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ResourceLoader resourceLoader;

	/**
	 * 
	 * Basic testing block to test the api call.
	 * Has uploaded the given data.txt as the input for the test case.
	 * 
	 * @throws Exception
	 */
	@Test
	public void getMaxCaloriesCount() throws Exception {
		Resource resource = resourceLoader.getResource("classpath:data.txt");
		File file = resource.getFile();
		FileInputStream input = new FileInputStream(file);
		MockMultipartFile multiPartFile = new MockMultipartFile("file", "data.txt", "text/plain", input);
		mvc.perform(MockMvcRequestBuilders.fileUpload("/maxSatisfaction").file(multiPartFile))
				.andExpect(status().is(200)).andExpect(content().string("2493893"));

		// Testing if the parameter is missing.
		mvc.perform(MockMvcRequestBuilders.fileUpload("/maxCalories")).andExpect(status().is(404));
	}
}