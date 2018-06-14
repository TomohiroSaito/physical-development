package physicaldevelopment.model.targetnutrition;

import physicaldevelopment.model.account.AccountId;
import physicaldevelopment.model.nutrition.NutrientAmount;

public class TargetNutrition {
	private TargetNutrientAmountId targetNutrientAmountId;
	private AccountId accountId;
	private NutrientAmount energyNutrientAmount;
	private NutrientAmount proteinNutrientAmount;
	private NutrientAmount lipidNutrientAmount;
	private NutrientAmount carbohydrateNutrientAmount;
	public TargetNutrientAmountId getTargetNutrientAmountId() {
		return targetNutrientAmountId;
	}
	public void setTargetNutrientAmountId(TargetNutrientAmountId targetNutrientAmountId) {
		this.targetNutrientAmountId = targetNutrientAmountId;
	}
	public AccountId getAccountId() {
		return accountId;
	}
	public void setAccountId(AccountId accountId) {
		this.accountId = accountId;
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
