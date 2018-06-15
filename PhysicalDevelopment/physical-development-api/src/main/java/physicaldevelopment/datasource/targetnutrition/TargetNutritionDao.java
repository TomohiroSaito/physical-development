package physicaldevelopment.datasource.targetnutrition;

import physicaldevelopment.model.account.authentication.LoginId;
import physicaldevelopment.model.targetnutrition.TargetNutrition;

public interface TargetNutritionDao {

	int selectNextTargetNutrientAmountId();

	int selectAccountId(LoginId loginId);

	void insertEnergyTargetNutrition(TargetNutrition targetNutrition);

	void insertProteinTargetNutrition(TargetNutrition targetNutrition);

	void insertLipidTargetNutrition(TargetNutrition targetNutrition);

	void insertCarbohydrateTargetNutrition(TargetNutrition targetNutrition);

}
