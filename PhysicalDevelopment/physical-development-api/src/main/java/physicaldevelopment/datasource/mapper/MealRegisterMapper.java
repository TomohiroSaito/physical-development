package physicaldevelopment.datasource.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import physicaldevelopment.model.meal.Meal;
import physicaldevelopment.model.primitive.YearMonthDay;

@Repository
@MyMapper
public interface MealRegisterMapper {
	void insertMeal(@Param("meal") Meal meal, @Param("dailyNutrientAmountId") int dailyNutrientAmountId);

	void insertMealManual(@Param("meal") Meal meal, @Param("manualEntryOfNutrientsId") int manualEntryOfNutrientsId);

	int selectNextMealId();

	int selectNextManualEntryOfNutrientsId();

	int selectDailyNutrientAmountId(@Param("yearMonthDay") YearMonthDay yearMonthDay, @Param("accountId") int accountId);

	int selectNextOrderOfMeals();

}
