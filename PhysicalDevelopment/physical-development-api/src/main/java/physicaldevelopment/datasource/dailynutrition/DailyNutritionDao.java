package physicaldevelopment.datasource.dailynutrition;

import java.util.Date;

import physicaldevelopment.model.account.AccountId;
import physicaldevelopment.model.dailynutrition.DailyNutrientAmountId;
import physicaldevelopment.model.nutrition.NutrientAmount;
import physicaldevelopment.model.primitive.YearMonthDay;

public interface DailyNutritionDao {
	DailyNutrientAmountId selectNextDailyNutrientAmountId();

	void insertDailyNutrition(DailyNutrientAmountId nextDailyNutrientAmountId, AccountId accountId,
			YearMonthDay yearMothDay);

	void insertEvaluation(DailyNutrientAmountId dailyNutrientAmountId);

	DailyNutrientAmountId selectDailyNutrientAmountId(Date date, AccountId accountId);

	NutrientAmount selectEnergyTotalNutrientAmountPerDay(DailyNutrientAmountId dailyNutrientAmountId);

	NutrientAmount selectProteinTotalNutrientAmountPerDay(DailyNutrientAmountId dailyNutrientAmountId);

	NutrientAmount selectLipidTotalNutrientAmountPerDay(DailyNutrientAmountId dailyNutrientAmountId);

	NutrientAmount selectCarbohydrateTotalNutrientAmountPerDay(DailyNutrientAmountId dailyNutrientAmountId);
}
