package physicaldevelopment.model.targetnutrition;

import physicaldevelopment.model.account.AccountId;

public class TargetNutrition {
	private AccountId accountId;
	private TargetNutrientAmount energyTargetNutrientAmount;
	private TargetNutrientAmount proteinTargetNutrientAmount;
	private TargetNutrientAmount lipidTargetNutrientAmount;
	private TargetNutrientAmount carbohydrateTargetNutrientAmount;
	public AccountId getAccountId() {
		return accountId;
	}
	public void setAccountId(AccountId accountId) {
		this.accountId = accountId;
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
