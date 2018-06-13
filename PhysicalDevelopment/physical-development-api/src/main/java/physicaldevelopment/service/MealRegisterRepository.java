package physicaldevelopment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import physicaldevelopment.datasource.MealRegisterDao;
import physicaldevelopment.model.meal.Meal;

@Repository
public class MealRegisterRepository {
	@Autowired
	MealRegisterDao mealRegisterDao;

	public void registerMealManual(Meal meal) {

	}
}
