package physicaldevelopment.datasource.mapper.targetnutrition;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import physicaldevelopment.datasource.mapper.MyMapper;
import physicaldevelopment.model.account.authentication.LoginId;
import physicaldevelopment.model.nutrition.NutrientAmount;
import physicaldevelopment.model.targetnutrition.TargetNutrition;

@Repository
@MyMapper
public interface TargetNutritionMapper {

	int selectNextTargetNutrientAmountId();

	int selectAccountId(@Param("loginId") LoginId loginId);

	void insertTargetNutrition(@Param("targetNutrition") TargetNutrition targetNutrition, @Param("nutrientAmount") NutrientAmount nutrientAmount);

	void insertLatestTargetNutrientAmount(@Param("targetNutrition") TargetNutrition targetNutrition);

}
