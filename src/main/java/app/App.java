package app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import app.service.AppService;

@RestController
@EnableAutoConfiguration
@ComponentScan
public class App {

	@Autowired
	AppService appService;

	@RequestMapping("/")
	String home() {
		return "Max Calorie Code.";
	}

	/**
	 * @param file
	 * @return Max
	 */
	@PostMapping("/maxCalories")
	public String calMaxCalorie(@RequestParam("file") MultipartFile file) {

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

				maxCalories = appService.knapSack(totalTime, time, cal, itemsCount);

			} catch (Exception e) {

				System.out.println("Exception occured while parsing the file ::" + e);

			}
		}
		return maxCalories.toString();
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(App.class, args);
	}

}
