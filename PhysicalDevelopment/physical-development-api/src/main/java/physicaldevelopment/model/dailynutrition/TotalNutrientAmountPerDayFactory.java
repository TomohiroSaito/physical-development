package physicaldevelopment.model.dailynutrition;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import physicaldevelopment.model.account.AccountId;
import physicaldevelopment.service.dailynutrition.DailyNutritionService;

public class TotalNutrientAmountPerDayFactory extends Factory {
	@Autowired
	DailyNutritionService dailyNutritionService;

	private List meals = new ArrayList();

	@Override
	protected Product createProduct(Date date, AccountId accountId) {
		DailyNutrientAmountId dailyNutrientAmountId = dailyNutritionService
				.selectDailyNutritionId(date, accountId);
		TotalNutrientAmountPerDay totalNutrientAmountPerDay = dailyNutritionService
				.createTotalNutrientAmountPerDay(dailyNutrientAmountId);
		return new TotalNutrientAmountPerDay();
	}

	@Override
	protected void registerProduct(Product product) {
		// TODO 自動生成されたメソッド・スタブ

	}

}
