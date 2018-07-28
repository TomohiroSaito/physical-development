package physicaldevelopment.datasource.mapper.meal.register;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import physicaldevelopment.datasource.mapper.MyMapper;
import physicaldevelopment.model.account.AccountId;
import physicaldevelopment.model.dailynutrition.DailyNutrientAmountId;
import physicaldevelopment.model.meal.Meal;
import physicaldevelopment.model.nutrition.NutrientAmount;
import physicaldevelopment.model.primitive.YearMonthDay;

@Repository
@MyMapper
public interface MealRegisterMapper {
	void insertMeal(@Param("meal") Meal meal,
			@Param("dailyNutrientAmountId") Integer dailyNutrientAmountId);

	void insertEnergyMealManual(
			@Param("meal") Meal meal,
			@Param("manualEntryOfNutrientsId") Integer manualEntryOfNutrientsId,
			@Param("energyNutrientAmount") NutrientAmount energyNutrientAmount);

	void insertProteinMealManual(
			@Param("meal") Meal meal,
			@Param("manualEntryOfNutrientsId") Integer manualEntryOfNutrientsId,
			@Param("proteinNutrientAmount") NutrientAmount energyNutrientAmount);

	void insertLipidMealManual(
			@Param("meal") Meal meal,
			@Param("manualEntryOfNutrientsId") Integer manualEntryOfNutrientsId,
			@Param("lipidNutrientAmount") NutrientAmount energyNutrientAmount);

	void insertCarbohydrateMealManual(
			@Param("meal") Meal meal,
			@Param("manualEntryOfNutrientsId") Integer manualEntryOfNutrientsId,
			@Param("carbohydrateNutrientAmount") NutrientAmount energyNutrientAmount);

	Integer selectNextMealId();

	Integer selectNextManualEntryOfNutrientsId();

	Integer selectDailyNutrientAmountId(
			@Param("yearMonthDay") YearMonthDay yearMonthDay,
			@Param("accountId") AccountId accountId);

	Integer selectMaxOrderOfMeals(
			@Param("dailyNutrientAmountId") DailyNutrientAmountId dailyNutrientAmountId);
}
