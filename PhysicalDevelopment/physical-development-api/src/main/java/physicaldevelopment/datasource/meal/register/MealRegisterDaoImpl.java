package physicaldevelopment.datasource.meal.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import physicaldevelopment.datasource.mapper.meal.register.MealRegisterMapper;
import physicaldevelopment.model.account.AccountId;
import physicaldevelopment.model.dailynutrition.DailyNutrientAmountId;
import physicaldevelopment.model.meal.Meal;
import physicaldevelopment.model.nutrition.NutrientAmount;
import physicaldevelopment.model.primitive.YearMonthDay;

@Repository
public class MealRegisterDaoImpl implements MealRegisterDao {
	@Autowired
	MealRegisterMapper mealRegisterMapper;

	public void registerMeal(Meal meal, Integer dailyNutrientAmountId,
			Integer manualEntryOfNutrientsId) {
		mealRegisterMapper.insertMeal(meal, dailyNutrientAmountId);
	}

	@Override
	public Integer selectNextMealId() {
		return mealRegisterMapper.selectNextMealId();
	}

	@Override
	public Integer selectDailyNutrientAmountId(YearMonthDay yearMonthDay,
			AccountId accountId) {
		return mealRegisterMapper.selectDailyNutrientAmountId(yearMonthDay,
				accountId);
	}

	@Override
	public Integer selectNextManualEntryOfNutrients() {
		return mealRegisterMapper.selectNextManualEntryOfNutrientsId();
	}

	@Override
	public Integer selectMaxOrderOfMeals(
			DailyNutrientAmountId dailyNutrientAmountId) {
		return mealRegisterMapper.selectMaxOrderOfMeals(dailyNutrientAmountId);
	}

	@Override
	public void insertEnergyMealManual(Meal meal,
			Integer manualEntryOfNutrientsId,
			NutrientAmount energyNutrientAmount) {
		mealRegisterMapper.insertEnergyMealManual(meal,
				manualEntryOfNutrientsId, energyNutrientAmount);

	}

	@Override
	public void insertProteinMealManual(Meal meal,
			Integer manualEntryOfNutrientsId,
			NutrientAmount proteinNutrientAmount) {
		mealRegisterMapper.insertProteinMealManual(meal,
				manualEntryOfNutrientsId, proteinNutrientAmount);
	}

	@Override
	public void insertCarbohydrateMealManual(Meal meal,
			Integer manualEntryOfNutrientsId,
			NutrientAmount carbohydrateNutrientAmount) {
		mealRegisterMapper.insertCarbohydrateMealManual(meal,
				manualEntryOfNutrientsId, carbohydrateNutrientAmount);
	}

	@Override
	public void insertLipidMealManual(Meal meal,
			Integer manualEntryOfNutrientsId, NutrientAmount lipidNutrientAmount) {
		mealRegisterMapper.insertLipidMealManual(meal,
				manualEntryOfNutrientsId, lipidNutrientAmount);
	}

}
