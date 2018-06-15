package physicaldevelopment.service.targetnutrition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import physicaldevelopment.datasource.targetnutrition.TargetNutritionDao;
import physicaldevelopment.model.account.AccountId;
import physicaldevelopment.model.account.authentication.LoginId;
import physicaldevelopment.model.targetnutrition.TargetNutrientAmountId;
import physicaldevelopment.model.targetnutrition.TargetNutrition;

@Service
public class TargetNutritionService {
	@Autowired
	TargetNutritionDao targetNutritionDao;

	public void setTargetNutrition(TargetNutrition targetNutrition, LoginId loginId) {
		AccountId accountId = new AccountId();
		accountId.setAccountId(targetNutritionDao.selectAccountId(loginId));
		targetNutrition.setAccountId(accountId);
		TargetNutrientAmountId targetNutrientAmountId = new TargetNutrientAmountId();
		targetNutrientAmountId.setTargetNutrientAmountId(targetNutritionDao.selectNextTargetNutrientAmountId());
		targetNutrition.getEnergyTargetNutrientAmount().setTargetNutrientAmountId(targetNutrientAmountId);
		targetNutritionDao.insertEnergyTargetNutrition(targetNutrition);
		targetNutrientAmountId.setTargetNutrientAmountId(targetNutritionDao.selectNextTargetNutrientAmountId());
		targetNutrition.getProteinTargetNutrientAmount().setTargetNutrientAmountId(targetNutrientAmountId);
		targetNutritionDao.insertProteinTargetNutrition(targetNutrition);
		targetNutrientAmountId.setTargetNutrientAmountId(targetNutritionDao.selectNextTargetNutrientAmountId());
		targetNutrition.getLipidTargetNutrientAmount().setTargetNutrientAmountId(targetNutrientAmountId);
		targetNutritionDao.insertLipidTargetNutrition(targetNutrition);
		targetNutrientAmountId.setTargetNutrientAmountId(targetNutritionDao.selectNextTargetNutrientAmountId());
		targetNutrition.getCarbohydrateTargetNutrientAmount().setTargetNutrientAmountId(targetNutrientAmountId);
		targetNutritionDao.insertCarbohydrateTargetNutrition(targetNutrition);

	}
}
