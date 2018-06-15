package physicaldevelopment.service.dailynutrition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import physicaldevelopment.datasource.dailynutrition.DailyNutritionDao;
import physicaldevelopment.model.account.AccountId;
import physicaldevelopment.model.dailynutrition.DailyNutrientAmountId;
import physicaldevelopment.model.primitive.YearMonthDay;

@Service
public class DailyNutritionService {
	@Autowired
	DailyNutritionDao dailyNutritionDao;

	public void newDailyNutrition(YearMonthDay yearMothDay, AccountId accountId) {
		DailyNutrientAmountId dailyNutrientAmountId = dailyNutritionDao.selectNextDailyNutrientAmountId();
		dailyNutritionDao.insertDailyNutrition(dailyNutrientAmountId, accountId, yearMothDay);
		dailyNutritionDao.insertEvaluation(dailyNutrientAmountId);
	}
}
