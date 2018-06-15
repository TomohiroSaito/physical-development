package physicaldevelopment.datasource.mapper.meal.register;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import physicaldevelopment.datasource.mapper.MyMapper;
import physicaldevelopment.model.meal.Meal;
import physicaldevelopment.model.primitive.YearMonthDay;

@Repository
@MyMapper
public interface MealRegisterMapper {
	void insertMeal(@Param("meal") Meal meal, @Param("dailyNutrientAmountId") Integer dailyNutrientAmountId);

	void insertMealManual(@Param("meal") Meal meal, @Param("manualEntryOfNutrientsId") Integer manualEntryOfNutrientsId);

	Integer selectNextMealId();

	Integer selectNextManualEntryOfNutrientsId();

	Integer selectDailyNutrientAmountId(@Param("yearMonthDay") YearMonthDay yearMonthDay, @Param("accountId") Integer accountId);

	Integer selectNextOrderOfMeals();

}
