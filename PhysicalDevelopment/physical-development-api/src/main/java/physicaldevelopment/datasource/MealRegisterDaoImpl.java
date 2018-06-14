package physicaldevelopment.datasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import physicaldevelopment.datasource.mapper.MealRegisterMapper;
import physicaldevelopment.model.meal.Meal;
import physicaldevelopment.model.primitive.YearMonthDay;

@Repository
public class MealRegisterDaoImpl implements MealRegisterDao {
	@Autowired
	MealRegisterMapper mealRegisterMapper;

	public void registerMealManual(Meal meal, int dailyNutrientAmountId, int manualEntryOfNutrientsId) {
		mealRegisterMapper.insertMeal(meal, dailyNutrientAmountId);
		mealRegisterMapper.insertMealManual(meal, manualEntryOfNutrientsId);
	}

	@Override
	public int selectNextMealId() {
		return mealRegisterMapper.selectNextMealId();
	}

	@Override
	public int selectDailyNutrientAmountId(YearMonthDay yearMonthDay, int accountId) {
		return mealRegisterMapper.selectDailyNutrientAmountId(yearMonthDay, accountId);
	}

	@Override
	public int selectNextManualEntryOfNutrients() {
		return mealRegisterMapper.selectNextManualEntryOfNutrientsId();
	}

	@Override
	public int selectNextOrderOfMeals() {
		return mealRegisterMapper.selectNextOrderOfMeals();
	}

}
