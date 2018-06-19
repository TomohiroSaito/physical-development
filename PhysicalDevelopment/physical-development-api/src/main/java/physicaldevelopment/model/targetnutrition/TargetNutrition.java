package physicaldevelopment.model.targetnutrition;

public class TargetNutrition {
	private TargetNutrientAmount energyTargetNutrientAmount;
	private TargetNutrientAmount proteinTargetNutrientAmount;
	private TargetNutrientAmount lipidTargetNutrientAmount;
	private TargetNutrientAmount carbohydrateTargetNutrientAmount;

	public TargetNutrition() {}
	public TargetNutrition(TargetNutrientAmount energyTargetNutrientAmount,
			TargetNutrientAmount proteinTargetNutrientAmount, TargetNutrientAmount lipidTargetNutrientAmount,
			TargetNutrientAmount carbohydrateTargetNutrientAmount) {
			this.energyTargetNutrientAmount = energyTargetNutrientAmount;
			this.proteinTargetNutrientAmount = proteinTargetNutrientAmount;
			this.lipidTargetNutrientAmount = lipidTargetNutrientAmount;
			this.carbohydrateTargetNutrientAmount = carbohydrateTargetNutrientAmount;
	}
	public TargetNutrientAmount getEnergyTargetNutrientAmount() {
		return energyTargetNutrientAmount;
	}
	public void setEnergyTargetNutrientAmount(TargetNutrientAmount energyTargetNutrientAmount) {
		this.energyTargetNutrientAmount = energyTargetNutrientAmount;
	}
	public TargetNutrientAmount getProteinTargetNutrientAmount() {
		return proteinTargetNutrientAmount;
	}
	public void setProteinTargetNutrientAmount(TargetNutrientAmount proteinTargetNutrientAmount) {
		this.proteinTargetNutrientAmount = proteinTargetNutrientAmount;
	}
	public TargetNutrientAmount getLipidTargetNutrientAmount() {
		return lipidTargetNutrientAmount;
	}
	public void setLipidTargetNutrientAmount(TargetNutrientAmount lipidTargetNutrientAmount) {
		this.lipidTargetNutrientAmount = lipidTargetNutrientAmount;
	}
	public TargetNutrientAmount getCarbohydrateTargetNutrientAmount() {
		return carbohydrateTargetNutrientAmount;
	}
	public void setCarbohydrateTargetNutrientAmount(TargetNutrientAmount carbohydrateTargetNutrientAmount) {
		this.carbohydrateTargetNutrientAmount = carbohydrateTargetNutrientAmount;
	}
}
