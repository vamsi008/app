package app.service;

import org.springframework.stereotype.Service;

@Service
public class AppServiceImpl implements AppService {

	@Override
	public int knapSack(int totalTime, int[] time, int[] cal, int itemsCount) {

		int i, w;
		int result[][] = new int[itemsCount + 1][totalTime + 1];

		// Build table K[][] in bottom up manner
		for (i = 0; i <= itemsCount; i++) {
			for (w = 0; w <= totalTime; w++) {
				if (i == 0 || w == 0)
					result[i][w] = 0;
				else if (time[i - 1] <= w)
					result[i][w] = max(cal[i - 1] + result[i - 1][w - time[i - 1]], result[i - 1][w]);
				else
					result[i][w] = result[i - 1][w];
			}
		}

		return result[itemsCount][totalTime];

	}

	int max(int a, int b) {
		return (a > b) ? a : b;
	}
}
