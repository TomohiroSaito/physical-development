package physicaldevelopment.model.nutrition;

public class NutrientAmount {
	private Integer nutrientAmount;
	private Nutrition nutrition;
	public NutrientAmount() {}
	public NutrientAmount(Integer nutrientAmount) {
		this.nutrientAmount = nutrientAmount;
	}
	public int getNutrientAmount() {
		return nutrientAmount;
	}
	public void setNutrientAmount(int nutrientAmount) {
		this.nutrientAmount = nutrientAmount;
	}
	public Nutrition getNutrition() {
		return nutrition;
	}
	public void setNutrition(Nutrition nutrition) {
		this.nutrition = nutrition;
	}
}
