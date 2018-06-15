package physicaldevelopment.service.meal.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import physicaldevelopment.datasource.meal.register.MealRegisterDao;
import physicaldevelopment.datasource.targetnutrition.TargetNutritionDao;
import physicaldevelopment.model.account.AccountId;
import physicaldevelopment.model.account.authentication.LoginId;
import physicaldevelopment.model.meal.Meal;
import physicaldevelopment.model.meal.MealId;
import physicaldevelopment.model.primitive.YearMonthDay;
import physicaldevelopment.service.dailynutrition.DailyNutritionService;

@Service
public class MealRegisterService {
	@Autowired
	MealRegisterDao mealRegisterDao;

	@Autowired
	DailyNutritionService dailyNutritionService;

	@Autowired
	TargetNutritionDao targetNutritionDao;

	public void registerMealManual(Meal meal) {
		Integer mealId = mealRegisterDao.selectNextMealId();
		Integer manualEntryOfNutrientsId = mealRegisterDao.selectNextManualEntryOfNutrients();
		Integer dailyNutrientAmountId = mealRegisterDao.selectDailyNutrientAmountId(meal.getYearMonthDay(), 1);
		meal.setMealId(new MealId(mealId));
		mealRegisterDao.registerMealManual(meal, dailyNutrientAmountId, manualEntryOfNutrientsId);
	}

	public int selectNextOrderOfMeals(YearMonthDay yearMonthDay, LoginId loginId) {
		Integer maxOrderOfMeals = mealRegisterDao.selectMaxOrderOfMeals();
		if(null == maxOrderOfMeals) {
			AccountId accountId = new AccountId(targetNutritionDao.selectAccountId(loginId));
			dailyNutritionService.newDailyNutrition(yearMonthDay, accountId);
			maxOrderOfMeals = 0;
		}
		return 	maxOrderOfMeals + 1;

	}
}
