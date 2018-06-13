package physicaldevelopment.datasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import physicaldevelopment.datasource.mapper.MealRegisterMapper;
import physicaldevelopment.model.meal.Meal;

@Repository
public class MealRegisterDaoImpl implements MealRegisterDao {
	@Autowired
	MealRegisterMapper mealRegisterMapper;

	public void registerMealManual(Meal meal) {
		mealRegisterMapper.insertMeal(meal);
		mealRegisterMapper.insertMealManual(meal);
	}

}
