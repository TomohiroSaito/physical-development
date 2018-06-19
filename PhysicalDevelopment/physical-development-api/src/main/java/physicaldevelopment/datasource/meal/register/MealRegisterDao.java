package physicaldevelopment.datasource.meal.register;

import physicaldevelopment.model.account.AccountId;
import physicaldevelopment.model.dailynutrition.DailyNutrientAmountId;
import physicaldevelopment.model.meal.Meal;
import physicaldevelopment.model.nutrition.NutrientAmount;
import physicaldevelopment.model.primitive.YearMonthDay;

public interface MealRegisterDao {
	void registerMeal(Meal meal, Integer dailyNutrientAmount, Integer manualEntryOfNutrientsId);

	Integer selectNextMealId();

	Integer selectNextManualEntryOfNutrients();

	Integer selectDailyNutrientAmountId(YearMonthDay yearMonthDay, AccountId accountId);

	Integer selectMaxOrderOfMeals(DailyNutrientAmountId dailyNutrientAmountId);

	void insertEnergyMealManual(Meal meal, Integer manualEntryOfNutrientsId, NutrientAmount energyNutrientAmount);

	void insertProteinMealManual(Meal meal, Integer manualEntryOfNutrientsId, NutrientAmount proteinNutrientAmount);

	void insertCarbohydrateMealManual(Meal meal, Integer manualEntryOfNutrientsId,
			NutrientAmount carbohydrateNutrientAmount);

	void insertLipidMealManual(Meal meal, Integer manualEntryOfNutrientsId, NutrientAmount lipidNutrientAmount);

}
