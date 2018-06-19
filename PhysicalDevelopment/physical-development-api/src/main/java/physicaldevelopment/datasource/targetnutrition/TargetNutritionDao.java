package physicaldevelopment.datasource.targetnutrition;

import physicaldevelopment.model.account.AccountId;
import physicaldevelopment.model.account.authentication.LoginId;
import physicaldevelopment.model.targetnutrition.TargetNutrientAmount;
import physicaldevelopment.model.targetnutrition.TargetNutrientAmountId;
import physicaldevelopment.model.targetnutrition.TargetNutrition;

public interface TargetNutritionDao {

	int selectNextTargetNutrientAmountId();

	int selectAccountId(LoginId loginId);

	void insertEnergyTargetNutrition(AccountId accountId, TargetNutrition targetNutrition);

	void insertProteinTargetNutrition(AccountId accountId, TargetNutrition targetNutrition);

	void insertLipidTargetNutrition(AccountId accountId, TargetNutrition targetNutrition);

	void insertCarbohydrateTargetNutrition(AccountId accountId, TargetNutrition targetNutrition);

	void insertLatestTargetNutrientAmount(TargetNutrientAmountId targetNutrientAmountId);

	TargetNutrientAmount selectEnergyTargetNutrition(AccountId accountId);

	TargetNutrientAmount selectProteinTargetNutrition(AccountId accountId);

	TargetNutrientAmount selectLipidTargetNutrition(AccountId accountId);

	TargetNutrientAmount selectCarbohydrateTargetNutrition(AccountId accountId);

	TargetNutrientAmountId selectEnergyTargetNutritionId(AccountId accountId);

	TargetNutrientAmountId selectProteinTargetNutritionId(AccountId accountId);

	TargetNutrientAmountId selectLipidTargetNutritionId(AccountId accountId);

	TargetNutrientAmountId selectCarbohydrateTargetNutritionId(AccountId accountId);

	void updateLatestTargetNutrientAmount(TargetNutrientAmountId existTargetNutrientAmountId, TargetNutrientAmountId existTargetNutrientAmountId2);

}
