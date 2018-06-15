package physicaldevelopment.datasource.mapper.targetnutrition;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import physicaldevelopment.datasource.mapper.MyMapper;
import physicaldevelopment.model.account.authentication.LoginId;
import physicaldevelopment.model.nutrition.NutrientAmount;
import physicaldevelopment.model.targetnutrition.TargetNutrientAmountId;
import physicaldevelopment.model.targetnutrition.TargetNutrition;

@Repository
@MyMapper
public interface TargetNutritionMapper {

	Integer selectNextTargetNutrientAmountId();

	Integer selectAccountId(@Param("loginId") LoginId loginId);

	void insertTargetNutrition(@Param("targetNutrition") TargetNutrition targetNutrition, @Param("nutrientAmount") NutrientAmount nutrientAmount, @Param("targetNutrientAmountId") TargetNutrientAmountId targetNutrientAmountId);

	void insertLatestTargetNutrientAmount(@Param("targetNutrition") TargetNutrition targetNutrition);

}
