package physicaldevelopment.datasource.targetnutrition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import physicaldevelopment.datasource.mapper.targetnutrition.TargetNutritionMapper;
import physicaldevelopment.model.account.authentication.LoginId;
import physicaldevelopment.model.nutrition.NutrientAmount;
import physicaldevelopment.model.targetnutrition.TargetNutrition;

@Repository
public class TargetNutritionDaoImpl implements TargetNutritionDao {
	@Autowired
	TargetNutritionMapper targetNutritionMapper;

	@Override
	public int selectNextTargetNutrientAmountId() {
		return targetNutritionMapper.selectNextTargetNutrientAmountId();
	}

	@Override
	public int selectAccountId(LoginId loginId) {
		return targetNutritionMapper.selectAccountId(loginId);
	}

	@Override
	public void insertEnergyTargetNutrition(TargetNutrition targetNutrition) {
		NutrientAmount energyNutrientAmount = targetNutrition.getEnergyNutrientAmount();
		targetNutritionMapper.insertTargetNutrition(targetNutrition, energyNutrientAmount);
	}

	@Override
	public void insertProteinTargetNutrition(TargetNutrition targetNutrition) {
		NutrientAmount proteinNutrientAmount = targetNutrition.getProteinNutrientAmount();
		targetNutritionMapper.insertTargetNutrition(targetNutrition, proteinNutrientAmount);
	}

	@Override
	public void insertLipidTargetNutrition(TargetNutrition targetNutrition) {
		NutrientAmount lipidNutrientAmount = targetNutrition.getLipidNutrientAmount();
		targetNutritionMapper.insertTargetNutrition(targetNutrition, lipidNutrientAmount);
	}

	@Override
	public void insertCarbohydrateTargetNutrition(TargetNutrition targetNutrition) {
		NutrientAmount carbohydrateNutrientAmount = targetNutrition.getCarbohydrateNutrientAmount();
		targetNutritionMapper.insertTargetNutrition(targetNutrition, carbohydrateNutrientAmount);
	}

}
