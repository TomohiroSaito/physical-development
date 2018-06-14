package physicaldevelopment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import physicaldevelopment.datasource.MealRegisterDao;
import physicaldevelopment.model.meal.Meal;
import physicaldevelopment.model.meal.MealId;

@Repository
public class MealRegisterRepository {
	@Autowired
	MealRegisterDao mealRegisterDao;

	public void registerMealManual(Meal meal) {
		int mealId = mealRegisterDao.selectNextMealId();
		int manualEntryOfNutrientsId = mealRegisterDao.selectNextManualEntryOfNutrients();
		int dailyNutrientAmountId = mealRegisterDao.selectDailyNutrientAmountId(meal.getYearMonthDay(), 1);
		meal.setMealId(new MealId(mealId));
		mealRegisterDao.registerMealManual(meal, dailyNutrientAmountId, manualEntryOfNutrientsId);
	}
}
