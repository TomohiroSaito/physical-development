package physicaldevelopment.model.dailynutrition;

import physicaldevelopment.model.nutrition.NutrientAmount;

public class TotalNutrientAmountPerDay extends Product {
	private NutrientAmount energyNutrientAmount;
	private NutrientAmount proteinNutrientAmount;
	private NutrientAmount lipidNutrientAmount;
	private NutrientAmount carbohydrateNutrientAmount;
	public TotalNutrientAmountPerDay(NutrientAmount energyNutrientAmount, NutrientAmount proteinNutrientAmount,
			NutrientAmount lipidNutrientAmount, NutrientAmount carbohydrateNutrientAmount) {
		this.energyNutrientAmount = energyNutrientAmount;
		this.proteinNutrientAmount = proteinNutrientAmount;
		this.lipidNutrientAmount = lipidNutrientAmount;
		this.carbohydrateNutrientAmount = carbohydrateNutrientAmount;
	}
	public TotalNutrientAmountPerDay() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	public NutrientAmount getEnergyNutrientAmount() {
		return energyNutrientAmount;
	}
	public void setEnergyNutrientAmount(NutrientAmount energyNutrientAmount) {
		this.energyNutrientAmount = energyNutrientAmount;
	}
	public NutrientAmount getProteinNutrientAmount() {
		return proteinNutrientAmount;
	}
	public void setProteinNutrientAmount(NutrientAmount proteinNutrientAmount) {
		this.proteinNutrientAmount = proteinNutrientAmount;
	}
	public NutrientAmount getLipidNutrientAmount() {
		return lipidNutrientAmount;
	}
	public void setLipidNutrientAmount(NutrientAmount lipidNutrientAmount) {
		this.lipidNutrientAmount = lipidNutrientAmount;
	}
	public NutrientAmount getCarbohydrateNutrientAmount() {
		return carbohydrateNutrientAmount;
	}
	public void setCarbohydrateNutrientAmount(NutrientAmount carbohydrateNutrientAmount) {
		this.carbohydrateNutrientAmount = carbohydrateNutrientAmount;
	}
}
