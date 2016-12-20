package com.satisfaction.web;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.satisfaction.service.MaxSatisfactionService;

@RestController
public class MaxSatisfactionController {

	@Autowired
	MaxSatisfactionService appService;

	@RequestMapping("/greetings")
	public String listUploadedFiles(Model model) throws IOException {

		//model.addAttribute("files", "sample");

		return "uploadForm";
	}

	/**
	 * @param file
	 * @return Max
	 */
	@PostMapping("/maxSatisfaction")
	public String calMaxSatisfaction(@RequestParam("file") MultipartFile file) {

		Integer maxCalories = new Integer(0);

		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
				String completeData = new String(bytes);
				String rows[] = completeData.split("\\r?\\n");
				String[] head = rows[0].split("\\s");
				int totalTime = Integer.valueOf(head[0]);
				int itemsCount = Integer.valueOf(head[1]);
				int cal[] = new int[itemsCount];
				int time[] = new int[itemsCount];
				for (int i = 0; i < itemsCount; i++) {
					String[] columns = rows[i + 1].split("\\s");
					cal[i] = Integer.valueOf(columns[0]);
					time[i] = Integer.valueOf(columns[1]);
				}

				maxCalories = appService.maxSatisfactionCalculator(totalTime, time, cal, itemsCount);

			} catch (Exception e) {

				System.out.println("Exception occured while parsing the file ::" + e);

			}
		}
		return maxCalories.toString();
	}

}
