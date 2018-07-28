package physicaldevelopment.model.meal;

import physicaldevelopment.model.nutrition.NutrientAmount;

public class OneMealOfNutrients {
	private NutrientAmount energyNutrientAmount;
	private NutrientAmount proteinNutrientAmount;
	private NutrientAmount lipidNutrientAmount;
	private NutrientAmount carbohydrateNutrientAmount;

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

	public void setCarbohydrateNutrientAmount(
			NutrientAmount carbohydrateNutrientAmount) {
		this.carbohydrateNutrientAmount = carbohydrateNutrientAmount;
	}
}
