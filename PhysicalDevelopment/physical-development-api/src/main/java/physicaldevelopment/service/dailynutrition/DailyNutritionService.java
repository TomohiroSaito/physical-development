package physicaldevelopment.service.dailynutrition;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import physicaldevelopment.datasource.dailynutrition.DailyNutritionDao;
import physicaldevelopment.datasource.targetnutrition.TargetNutritionDao;
import physicaldevelopment.model.account.AccountId;
import physicaldevelopment.model.account.authentication.LoginId;
import physicaldevelopment.model.dailynutrition.DailyNutrientAmountId;
import physicaldevelopment.model.dailynutrition.TotalNutrientAmountPerDay;
import physicaldevelopment.model.nutrition.NutrientAmount;
import physicaldevelopment.model.primitive.YearMonthDay;

@Service
public class DailyNutritionService {
	@Autowired
	DailyNutritionDao dailyNutritionDao;

	@Autowired
	TargetNutritionDao targetNutritionDao;

	public DailyNutrientAmountId newDailyNutrition(YearMonthDay yearMothDay, AccountId accountId) {
		DailyNutrientAmountId dailyNutrientAmountId = dailyNutritionDao.selectNextDailyNutrientAmountId();
		dailyNutritionDao.insertDailyNutrition(dailyNutrientAmountId, accountId, yearMothDay);
		dailyNutritionDao.insertEvaluation(dailyNutrientAmountId);
		return dailyNutrientAmountId;
	}

	public TotalNutrientAmountPerDay createTotalNutrientAmountPerDay(DailyNutrientAmountId dailyNutrientAmountId) {
		NutrientAmount energyNutrientAmount = dailyNutritionDao.selectEnergyTotalNutrientAmountPerDay(dailyNutrientAmountId);
		if(null == energyNutrientAmount) {
			energyNutrientAmount = new NutrientAmount(0);
		}
		NutrientAmount proteinNutrientAmount = dailyNutritionDao.selectProteinTotalNutrientAmountPerDay(dailyNutrientAmountId);
		if(null == proteinNutrientAmount) {
			proteinNutrientAmount = new NutrientAmount(0);
		}
		NutrientAmount lipidNutrientAmount = dailyNutritionDao.selectLipidTotalNutrientAmountPerDay(dailyNutrientAmountId);
		if(null == lipidNutrientAmount) {
			lipidNutrientAmount = new NutrientAmount(0);
		}
		NutrientAmount carbohydrateNutrientAmount = dailyNutritionDao.selectCarbohydrateTotalNutrientAmountPerDay(dailyNutrientAmountId);
		if(null == carbohydrateNutrientAmount) {
			carbohydrateNutrientAmount = new NutrientAmount(0);
		}
		TotalNutrientAmountPerDay totalNutrientAmountPerDay = new TotalNutrientAmountPerDay(energyNutrientAmount, proteinNutrientAmount, lipidNutrientAmount, carbohydrateNutrientAmount);
		return totalNutrientAmountPerDay;
	}

	public DailyNutrientAmountId selectDailyNutritionId(Date date, AccountId accountId) {
		DailyNutrientAmountId dailyNutrientAmountId = dailyNutritionDao.selectDailyNutrientAmountId(date, accountId);
		return dailyNutrientAmountId;
	}

	public DailyNutrientAmountId selectDailyNutrientAmountId(YearMonthDay yearMonthDay, LoginId loginId) {
		AccountId accountId = new AccountId(targetNutritionDao.selectAccountId(loginId));
		DailyNutrientAmountId dailyNutrientAmountId = dailyNutritionDao.selectDailyNutrientAmountId(yearMonthDay.getYearMonthDay(), accountId);
		if(null == dailyNutrientAmountId) {
			dailyNutrientAmountId = newDailyNutrition(yearMonthDay, accountId);
		}
		return dailyNutrientAmountId;
	}


}
