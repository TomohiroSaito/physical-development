package physicaldevelopment.datasource.meal.register;

import physicaldevelopment.model.meal.Meal;
import physicaldevelopment.model.primitive.YearMonthDay;

public interface MealRegisterDao {
	void registerMealManual(Meal meal, Integer dailyNutrientAmount, Integer manualEntryOfNutrientsId);

	Integer selectNextMealId();

	Integer selectNextManualEntryOfNutrients();

	Integer selectDailyNutrientAmountId(YearMonthDay yearMonthDay, Integer accountId);

	Integer selectMaxOrderOfMeals();

}
