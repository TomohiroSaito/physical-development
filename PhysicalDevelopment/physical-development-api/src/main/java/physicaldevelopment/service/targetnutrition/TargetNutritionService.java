package physicaldevelopment.service.targetnutrition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import physicaldevelopment.datasource.targetnutrition.TargetNutritionDao;
import physicaldevelopment.model.account.AccountId;
import physicaldevelopment.model.account.authentication.LoginId;
import physicaldevelopment.model.targetnutrition.TargetNutrientAmount;
import physicaldevelopment.model.targetnutrition.TargetNutrientAmountId;
import physicaldevelopment.model.targetnutrition.TargetNutrition;

@Service
public class TargetNutritionService {
	@Autowired
	TargetNutritionDao targetNutritionDao;

	public void setTargetNutrition(TargetNutrition targetNutrition, LoginId loginId) {
		AccountId accountId = new AccountId(targetNutritionDao.selectAccountId(loginId));
		TargetNutrientAmountId targetNutrientAmountId = new TargetNutrientAmountId();

		targetNutrientAmountId.setTargetNutrientAmountId(targetNutritionDao.selectNextTargetNutrientAmountId());
		targetNutrition.getEnergyTargetNutrientAmount().setTargetNutrientAmountId(targetNutrientAmountId);
		targetNutritionDao.insertEnergyTargetNutrition(accountId, targetNutrition);
		TargetNutrientAmountId existTargetNutrientAmountId = targetNutritionDao.selectEnergyTargetNutritionId(accountId);
		if(null == existTargetNutrientAmountId) {
			targetNutritionDao.insertLatestTargetNutrientAmount(targetNutrientAmountId);
		}
		if(!(null == existTargetNutrientAmountId)) {
			targetNutritionDao.updateLatestTargetNutrientAmount(targetNutrientAmountId, existTargetNutrientAmountId);
		}

		targetNutrientAmountId.setTargetNutrientAmountId(targetNutritionDao.selectNextTargetNutrientAmountId());
		targetNutrition.getProteinTargetNutrientAmount().setTargetNutrientAmountId(targetNutrientAmountId);
		targetNutritionDao.insertProteinTargetNutrition(accountId, targetNutrition);
		existTargetNutrientAmountId = targetNutritionDao.selectProteinTargetNutritionId(accountId);
		if(null == existTargetNutrientAmountId) {
			targetNutritionDao.insertLatestTargetNutrientAmount(targetNutrientAmountId);
		}
		if(!(null == existTargetNutrientAmountId)) {
			targetNutritionDao.updateLatestTargetNutrientAmount(targetNutrientAmountId, existTargetNutrientAmountId);
		}

		targetNutrientAmountId.setTargetNutrientAmountId(targetNutritionDao.selectNextTargetNutrientAmountId());
		targetNutrition.getLipidTargetNutrientAmount().setTargetNutrientAmountId(targetNutrientAmountId);
		targetNutritionDao.insertLipidTargetNutrition(accountId, targetNutrition);
		existTargetNutrientAmountId = targetNutritionDao.selectLipidTargetNutritionId(accountId);
		if(null == existTargetNutrientAmountId) {
			targetNutritionDao.insertLatestTargetNutrientAmount(targetNutrientAmountId);
		}
		if(!(null == existTargetNutrientAmountId)) {
			targetNutritionDao.updateLatestTargetNutrientAmount(targetNutrientAmountId, existTargetNutrientAmountId);
		}

		targetNutrientAmountId.setTargetNutrientAmountId(targetNutritionDao.selectNextTargetNutrientAmountId());
		targetNutrition.getCarbohydrateTargetNutrientAmount().setTargetNutrientAmountId(targetNutrientAmountId);
		targetNutritionDao.insertCarbohydrateTargetNutrition(accountId, targetNutrition);
		existTargetNutrientAmountId = targetNutritionDao.selectCarbohydrateTargetNutritionId(accountId);
		if(null == existTargetNutrientAmountId) {
			targetNutritionDao.insertLatestTargetNutrientAmount(targetNutrientAmountId);
		}
		if(!(null == existTargetNutrientAmountId)) {
			targetNutritionDao.updateLatestTargetNutrientAmount(targetNutrientAmountId, existTargetNutrientAmountId);
		}

	}

	public TargetNutrition selectTargetNutrientAmount(AccountId accountId) {
		TargetNutrientAmount energyTargetNutrientAmount = targetNutritionDao.selectEnergyTargetNutrition(accountId);
		if(null == energyTargetNutrientAmount) {
			return null;
		}
		TargetNutrientAmount proteinTargetNutrientAmount = targetNutritionDao.selectProteinTargetNutrition(accountId);
		TargetNutrientAmount lipidTargetNutrientAmount = targetNutritionDao.selectLipidTargetNutrition(accountId);
		TargetNutrientAmount carbohydrateTargetNutrientAmount = targetNutritionDao.selectCarbohydrateTargetNutrition(accountId);
		TargetNutrition targetNutrition = new TargetNutrition(energyTargetNutrientAmount, proteinTargetNutrientAmount, lipidTargetNutrientAmount, carbohydrateTargetNutrientAmount);
		return targetNutrition;
	}
}
