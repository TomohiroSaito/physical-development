package physicaldevelopment.service.meal.register;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import physicaldevelopment.datasource.meal.register.MealRegisterDao;
import physicaldevelopment.datasource.targetnutrition.TargetNutritionDao;
import physicaldevelopment.model.account.AccountId;
import physicaldevelopment.model.account.authentication.LoginId;
import physicaldevelopment.model.dailynutrition.DailyNutrientAmountId;
import physicaldevelopment.model.meal.Meal;
import physicaldevelopment.model.meal.MealId;
import physicaldevelopment.model.primitive.YearMonthDay;
import physicaldevelopment.service.dailynutrition.DailyNutritionService;
import physicaldevelopment.service.evaluation.EvaluationService;

@Service
public class MealRegisterService {
	@Autowired
	MealRegisterDao mealRegisterDao;

	@Autowired
	DailyNutritionService dailyNutritionService;

	@Autowired
	TargetNutritionDao targetNutritionDao;

	@Autowired
	EvaluationService evaluationService;

	public void registerMeal(Meal meal, AccountId accountId) {
		Integer mealId = mealRegisterDao.selectNextMealId();
		Integer dailyNutrientAmountId = mealRegisterDao.selectDailyNutrientAmountId(meal.getYearMonthDay(), accountId);
		meal.setMealId(new MealId(mealId));
		Integer manualEntryOfNutrientsId = mealRegisterDao.selectNextManualEntryOfNutrients();
		mealRegisterDao.registerMeal(meal, dailyNutrientAmountId, manualEntryOfNutrientsId);
		mealRegisterDao.insertEnergyMealManual(meal, manualEntryOfNutrientsId, meal.getOneMealOfNutrients().getEnergyNutrientAmount());
		manualEntryOfNutrientsId = mealRegisterDao.selectNextManualEntryOfNutrients();
		mealRegisterDao.insertProteinMealManual(meal, manualEntryOfNutrientsId, meal.getOneMealOfNutrients().getProteinNutrientAmount());
		manualEntryOfNutrientsId = mealRegisterDao.selectNextManualEntryOfNutrients();
		mealRegisterDao.insertLipidMealManual(meal, manualEntryOfNutrientsId, meal.getOneMealOfNutrients().getLipidNutrientAmount());
		manualEntryOfNutrientsId = mealRegisterDao.selectNextManualEntryOfNutrients();
		mealRegisterDao.insertCarbohydrateMealManual(meal, manualEntryOfNutrientsId, meal.getOneMealOfNutrients().getCarbohydrateNutrientAmount());

		//※日付の修正（今日ではなく、渡された日にする）
		//評価の再計算
		evaluationService.calcEvaluation(new Date(), accountId);
	}

	public int selectNextOrderOfMeals(YearMonthDay yearMonthDay, LoginId loginId) {
		AccountId accountId = new AccountId(targetNutritionDao.selectAccountId(loginId));
		DailyNutrientAmountId dailyNutrientAmountId = dailyNutritionService.selectDailyNutritionId(yearMonthDay.getYearMonthDay(), accountId);
		Integer maxOrderOfMeals = mealRegisterDao.selectMaxOrderOfMeals(dailyNutrientAmountId);
		if(null == maxOrderOfMeals) {
			maxOrderOfMeals = 0;
		}
		return 	maxOrderOfMeals + 1;

	}
}
