package physicaldevelopment.datasource.meal.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import physicaldevelopment.datasource.mapper.meal.register.MealRegisterMapper;
import physicaldevelopment.model.meal.Meal;
import physicaldevelopment.model.primitive.YearMonthDay;

@Repository
public class MealRegisterDaoImpl implements MealRegisterDao {
	@Autowired
	MealRegisterMapper mealRegisterMapper;

	public void registerMealManual(Meal meal, Integer dailyNutrientAmountId, Integer manualEntryOfNutrientsId) {
		mealRegisterMapper.insertMeal(meal, dailyNutrientAmountId);
		mealRegisterMapper.insertMealManual(meal, manualEntryOfNutrientsId);
	}

	@Override
	public Integer selectNextMealId() {
		return mealRegisterMapper.selectNextMealId();
	}

	@Override
	public Integer selectDailyNutrientAmountId(YearMonthDay yearMonthDay, Integer accountId) {
		return mealRegisterMapper.selectDailyNutrientAmountId(yearMonthDay, accountId);
	}

	@Override
	public Integer selectNextManualEntryOfNutrients() {
		return mealRegisterMapper.selectNextManualEntryOfNutrientsId();
	}

	@Override
	public Integer selectMaxOrderOfMeals() {
		return mealRegisterMapper.selectNextOrderOfMeals();
	}

}
