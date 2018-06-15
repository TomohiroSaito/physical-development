package physicaldevelopment.datasource.dailynutrition;

import physicaldevelopment.model.account.AccountId;
import physicaldevelopment.model.dailynutrition.DailyNutrientAmountId;
import physicaldevelopment.model.primitive.YearMonthDay;

public interface DailyNutritionDao {
	DailyNutrientAmountId selectNextDailyNutrientAmountId();

	void insertDailyNutrition(DailyNutrientAmountId nextDailyNutrientAmountId, AccountId accountId,
			YearMonthDay yearMothDay);

	void insertEvaluation(DailyNutrientAmountId dailyNutrientAmountId);

}
