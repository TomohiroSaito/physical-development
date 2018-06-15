package physicaldevelopment.datasource.meal.register;

import physicaldevelopment.model.meal.Meal;
import physicaldevelopment.model.primitive.YearMonthDay;

public interface MealRegisterDao {
	void registerMealManual(Meal meal, int dailyNutrientAmount, int manualEntryOfNutrientsId);

	int selectNextMealId();

	int selectNextManualEntryOfNutrients();

	int selectDailyNutrientAmountId(YearMonthDay yearMonthDay, int accountId);

	int selectNextOrderOfMeals();

}
