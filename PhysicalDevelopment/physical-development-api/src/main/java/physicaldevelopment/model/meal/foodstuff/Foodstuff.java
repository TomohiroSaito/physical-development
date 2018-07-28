package physicaldevelopment.model.meal.foodstuff;

public class Foodstuff {
	private FoodstuffName foodstuffName;
	private FoodstuffMasterId foodstuffMasterId;
	private AmmountToUse ammountToUse;

	public FoodstuffName getFoodstuffName() {
		return foodstuffName;
	}

	public void setFoodstuffName(FoodstuffName foodstuffName) {
		this.foodstuffName = foodstuffName;
	}

	public FoodstuffMasterId getFoodstuffMasterId() {
		return foodstuffMasterId;
	}

	public void setFoodstuffMasterId(FoodstuffMasterId foodstuffMasterId) {
		this.foodstuffMasterId = foodstuffMasterId;
	}

	public AmmountToUse getAmmountToUse() {
		return ammountToUse;
	}

	public void setAmmountToUse(AmmountToUse ammountToUse) {
		this.ammountToUse = ammountToUse;
	}
}
