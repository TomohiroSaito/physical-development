package physicaldevelopment.model.meal;

import physicaldevelopment.model.meal.foodstuff.FoodstuffList;
import physicaldevelopment.model.primitive.YearMonthDay;

public class Meal {
	private MealId mealId;
	private MealName mealName;
	private OrderOfMeals orderOfMeals;
	private InputType inputType;
	private FoodstuffList foodstuffList;
	private OneMealOfNutrients oneMealOfNutrients;
	private YearMonthDay yearMonthDay;

	public MealId getMealId() {
		return mealId;
	}

	public void setMealId(MealId mealId) {
		this.mealId = mealId;
	}

	public MealName getMealName() {
		return mealName;
	}

	public void setMealName(MealName mealName) {
		this.mealName = mealName;
	}

	public OrderOfMeals getOrderOfMeals() {
		return orderOfMeals;
	}

	public void setOrderOfMeals(OrderOfMeals orderOfMeals) {
		this.orderOfMeals = orderOfMeals;
	}

	public InputType getInputType() {
		return inputType;
	}

	public void setInputType(InputType inputType) {
		this.inputType = inputType;
	}

	public FoodstuffList getFoodstuffList() {
		return foodstuffList;
	}

	public void setFoodstuffList(FoodstuffList foodstuffList) {
		this.foodstuffList = foodstuffList;
	}

	public OneMealOfNutrients getOneMealOfNutrients() {
		return oneMealOfNutrients;
	}

	public void setOneMealOfNutrients(OneMealOfNutrients oneMealOfNutrients) {
		this.oneMealOfNutrients = oneMealOfNutrients;
	}

	public YearMonthDay getYearMonthDay() {
		return yearMonthDay;
	}

	public void setYearMonthDay(YearMonthDay yearMonthDay) {
		this.yearMonthDay = yearMonthDay;
	}
}
