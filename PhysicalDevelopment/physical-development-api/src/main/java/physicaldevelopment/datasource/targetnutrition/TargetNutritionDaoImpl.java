package physicaldevelopment.datasource.targetnutrition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import physicaldevelopment.datasource.mapper.targetnutrition.TargetNutritionMapper;
import physicaldevelopment.model.account.authentication.LoginId;
import physicaldevelopment.model.targetnutrition.TargetNutrientAmount;
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
		TargetNutrientAmount energyTargetNutrientAmount = targetNutrition.getEnergyTargetNutrientAmount();
		targetNutritionMapper.insertTargetNutrition(targetNutrition, energyTargetNutrientAmount.getNutrientAmount(), targetNutrition.getEnergyTargetNutrientAmount().getTargetNutrientAmountId());
	}

	@Override
	public void insertProteinTargetNutrition(TargetNutrition targetNutrition) {
		TargetNutrientAmount proteinTargetNutrientAmount = targetNutrition.getProteinTargetNutrientAmount();
		targetNutritionMapper.insertTargetNutrition(targetNutrition, proteinTargetNutrientAmount.getNutrientAmount(), targetNutrition.getProteinTargetNutrientAmount().getTargetNutrientAmountId());
	}

	@Override
	public void insertLipidTargetNutrition(TargetNutrition targetNutrition) {
		TargetNutrientAmount lipidTargetNutrientAmount = targetNutrition.getLipidTargetNutrientAmount();
		targetNutritionMapper.insertTargetNutrition(targetNutrition, lipidTargetNutrientAmount.getNutrientAmount(), targetNutrition.getLipidTargetNutrientAmount().getTargetNutrientAmountId());
	}

	@Override
	public void insertCarbohydrateTargetNutrition(TargetNutrition targetNutrition) {
		TargetNutrientAmount carbohydrateTargetNutrientAmount = targetNutrition.getCarbohydrateTargetNutrientAmount();
		targetNutritionMapper.insertTargetNutrition(targetNutrition, carbohydrateTargetNutrientAmount.getNutrientAmount(), targetNutrition.getCarbohydrateTargetNutrientAmount().getTargetNutrientAmountId());
	}

}
