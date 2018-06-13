package physicaldevelopment.datasource.mapper;

import org.springframework.stereotype.Repository;

import physicaldevelopment.model.meal.Meal;

@Repository
@MyMapper
public interface MealRegisterMapper {
	void insertMeal(Meal meal);

	void insertMealManual(Meal meal);
}
