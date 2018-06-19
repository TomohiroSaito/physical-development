package physicaldevelopment.datasource.targetnutrition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import physicaldevelopment.datasource.mapper.targetnutrition.TargetNutritionMapper;
import physicaldevelopment.model.account.AccountId;
import physicaldevelopment.model.account.authentication.LoginId;
import physicaldevelopment.model.targetnutrition.TargetNutrientAmount;
import physicaldevelopment.model.targetnutrition.TargetNutrientAmountId;
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
	public void insertEnergyTargetNutrition(AccountId accountId, TargetNutrition targetNutrition) {
		TargetNutrientAmount energyTargetNutrientAmount = targetNutrition.getEnergyTargetNutrientAmount();
		targetNutritionMapper.insertTargetNutrition(accountId, targetNutrition, energyTargetNutrientAmount.getNutrientAmount(), targetNutrition.getEnergyTargetNutrientAmount().getTargetNutrientAmountId());
	}

	@Override
	public void insertProteinTargetNutrition(AccountId accountId, TargetNutrition targetNutrition) {
		TargetNutrientAmount proteinTargetNutrientAmount = targetNutrition.getProteinTargetNutrientAmount();
		targetNutritionMapper.insertTargetNutrition(accountId, targetNutrition, proteinTargetNutrientAmount.getNutrientAmount(), targetNutrition.getProteinTargetNutrientAmount().getTargetNutrientAmountId());
	}

	@Override
	public void insertLipidTargetNutrition(AccountId accountId, TargetNutrition targetNutrition) {
		TargetNutrientAmount lipidTargetNutrientAmount = targetNutrition.getLipidTargetNutrientAmount();
		targetNutritionMapper.insertTargetNutrition(accountId, targetNutrition, lipidTargetNutrientAmount.getNutrientAmount(), targetNutrition.getLipidTargetNutrientAmount().getTargetNutrientAmountId());
	}

	@Override
	public void insertCarbohydrateTargetNutrition(AccountId accountId, TargetNutrition targetNutrition) {
		TargetNutrientAmount carbohydrateTargetNutrientAmount = targetNutrition.getCarbohydrateTargetNutrientAmount();
		targetNutritionMapper.insertTargetNutrition(accountId, targetNutrition, carbohydrateTargetNutrientAmount.getNutrientAmount(), targetNutrition.getCarbohydrateTargetNutrientAmount().getTargetNutrientAmountId());
	}

	@Override
	public void insertLatestTargetNutrientAmount(TargetNutrientAmountId targetNutrientAmountId) {
		targetNutritionMapper.insertLatestTargetNutrientAmount(targetNutrientAmountId);
	}

	@Override
	public TargetNutrientAmount selectEnergyTargetNutrition(AccountId accountId) {
		return targetNutritionMapper.selectEnergyTargetNutrition(accountId);
	}

	@Override
	public TargetNutrientAmount selectProteinTargetNutrition(AccountId accountId) {
		return targetNutritionMapper.selectProteinTargetNutrition(accountId);
	}

	@Override
	public TargetNutrientAmount selectLipidTargetNutrition(AccountId accountId) {
		return targetNutritionMapper.selectLipidTargetNutrition(accountId);
	}

	@Override
	public TargetNutrientAmount selectCarbohydrateTargetNutrition(AccountId accountId) {
		return targetNutritionMapper.selectCarbohydrateTargetNutrition(accountId);
	}

	@Override
	public TargetNutrientAmountId selectEnergyTargetNutritionId(AccountId accountId) {
		return targetNutritionMapper.selectEnergyTargetNutritionId(accountId);
	}

	@Override
	public TargetNutrientAmountId selectProteinTargetNutritionId(AccountId accountId) {
		return targetNutritionMapper.selectProteinTargetNutritionId(accountId);
	}

	@Override
	public TargetNutrientAmountId selectLipidTargetNutritionId(AccountId accountId) {
		return targetNutritionMapper.selectLipidTargetNutritionId(accountId);
	}

	@Override
	public TargetNutrientAmountId selectCarbohydrateTargetNutritionId(AccountId accountId) {
		return targetNutritionMapper.selectCarbohydrateTargetNutritionId(accountId);
	}

	@Override
	public void updateLatestTargetNutrientAmount(TargetNutrientAmountId targetNutrientAmountId, TargetNutrientAmountId existTargetNutrientAmountId) {
		targetNutritionMapper.updateLatestTargetNutrientAmount(targetNutrientAmountId, existTargetNutrientAmountId);
	}

}
