package physicaldevelopment.datasource.mapper.targetnutrition;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import physicaldevelopment.datasource.mapper.MyMapper;
import physicaldevelopment.model.account.AccountId;
import physicaldevelopment.model.account.authentication.LoginId;
import physicaldevelopment.model.nutrition.NutrientAmount;
import physicaldevelopment.model.targetnutrition.TargetNutrientAmount;
import physicaldevelopment.model.targetnutrition.TargetNutrientAmountId;
import physicaldevelopment.model.targetnutrition.TargetNutrition;

@Repository
@MyMapper
public interface TargetNutritionMapper {

	Integer selectNextTargetNutrientAmountId();

	Integer selectAccountId(@Param("loginId") LoginId loginId);

	void insertTargetNutrition(
			@Param("accountId") AccountId accountId,
			@Param("targetNutrition") TargetNutrition targetNutrition,
			@Param("nutrientAmount") NutrientAmount nutrientAmount,
			@Param("targetNutrientAmountId") TargetNutrientAmountId targetNutrientAmountId);

	void insertLatestTargetNutrientAmount(
			@Param("targetNutrientAmountId") TargetNutrientAmountId targetNutrientAmountId);

	TargetNutrientAmount selectEnergyTargetNutrition(
			@Param("accountId") AccountId accountId);

	TargetNutrientAmount selectProteinTargetNutrition(
			@Param("accountId") AccountId accountId);

	TargetNutrientAmount selectLipidTargetNutrition(
			@Param("accountId") AccountId accountId);

	TargetNutrientAmount selectCarbohydrateTargetNutrition(
			@Param("accountId") AccountId accountId);

	TargetNutrientAmountId selectEnergyTargetNutritionId(
			@Param("accountId") AccountId accountId);

	TargetNutrientAmountId selectProteinTargetNutritionId(
			@Param("accountId") AccountId accountId);

	TargetNutrientAmountId selectLipidTargetNutritionId(
			@Param("accountId") AccountId accountId);

	TargetNutrientAmountId selectCarbohydrateTargetNutritionId(
			@Param("accountId") AccountId accountId);

	void updateLatestTargetNutrientAmount(
			@Param("targetNutrientAmountId") TargetNutrientAmountId targetNutrientAmountId,
			@Param("existTargetNutrientAmountId") TargetNutrientAmountId existTargetNutrientAmountId);

}
