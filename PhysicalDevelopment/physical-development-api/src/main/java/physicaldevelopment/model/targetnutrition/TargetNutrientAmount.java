package physicaldevelopment.model.targetnutrition;

import physicaldevelopment.model.nutrition.NutrientAmount;

public class TargetNutrientAmount {
	private TargetNutrientAmountId targetNutrientAmountId;
	private NutrientAmount nutrientAmount;

	public TargetNutrientAmountId getTargetNutrientAmountId() {
		return targetNutrientAmountId;
	}

	public void setTargetNutrientAmountId(
			TargetNutrientAmountId targetNutrientAmountId) {
		this.targetNutrientAmountId = targetNutrientAmountId;
	}

	public NutrientAmount getNutrientAmount() {
		return nutrientAmount;
	}

	public void setNutrientAmount(NutrientAmount nutrientAmount) {
		this.nutrientAmount = nutrientAmount;
	}

}
