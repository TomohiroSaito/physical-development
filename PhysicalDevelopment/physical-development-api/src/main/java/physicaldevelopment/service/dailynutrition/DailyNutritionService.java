package physicaldevelopment.service.dailynutrition;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import physicaldevelopment.datasource.dailynutrition.DailyNutritionDao;
import physicaldevelopment.datasource.targetnutrition.TargetNutritionDao;
import physicaldevelopment.model.account.AccountId;
import physicaldevelopment.model.dailynutrition.DailyNutrientAmountId;
import physicaldevelopment.model.dailynutrition.TotalNutrientAmountPerDay;
import physicaldevelopment.model.evaluation.NotSubjectToEvaluation;
import physicaldevelopment.model.nutrition.NutrientAmount;

@Service
public class DailyNutritionService {
	@Autowired
	DailyNutritionDao dailyNutritionDao;

	@Autowired
	TargetNutritionDao targetNutritionDao;

	// 1日の栄養素を新規作成する
	public DailyNutrientAmountId newDailyNutrition(Date date,
			AccountId accountId) {
		DailyNutrientAmountId dailyNutrientAmountId = dailyNutritionDao
				.selectNextDailyNutrientAmountId();
		dailyNutritionDao.insertDailyNutrition(dailyNutrientAmountId,
				accountId, date);
		// dailyNutritionDao.insertEvaluation(dailyNutrientAmountId);
		return dailyNutrientAmountId;
	}

	// 1日の栄養素の合計値を計算して返す
	public TotalNutrientAmountPerDay createTotalNutrientAmountPerDay(
			DailyNutrientAmountId dailyNutrientAmountId) {
		NutrientAmount energyNutrientAmount = dailyNutritionDao
				.selectEnergyTotalNutrientAmountPerDay(dailyNutrientAmountId);
		if (null == energyNutrientAmount) {
			energyNutrientAmount = new NutrientAmount(0);
		}
		NutrientAmount proteinNutrientAmount = dailyNutritionDao
				.selectProteinTotalNutrientAmountPerDay(dailyNutrientAmountId);
		if (null == proteinNutrientAmount) {
			proteinNutrientAmount = new NutrientAmount(0);
		}
		NutrientAmount lipidNutrientAmount = dailyNutritionDao
				.selectLipidTotalNutrientAmountPerDay(dailyNutrientAmountId);
		if (null == lipidNutrientAmount) {
			lipidNutrientAmount = new NutrientAmount(0);
		}
		NutrientAmount carbohydrateNutrientAmount = dailyNutritionDao
				.selectCarbohydrateTotalNutrientAmountPerDay(dailyNutrientAmountId);
		if (null == carbohydrateNutrientAmount) {
			carbohydrateNutrientAmount = new NutrientAmount(0);
		}
		TotalNutrientAmountPerDay totalNutrientAmountPerDay = new TotalNutrientAmountPerDay(
				energyNutrientAmount, proteinNutrientAmount,
				lipidNutrientAmount, carbohydrateNutrientAmount);
		return totalNutrientAmountPerDay;
	}

	// 1日の栄養素IDを取得する
	public DailyNutrientAmountId selectDailyNutritionId(Date date,
			AccountId accountId) {
		DailyNutrientAmountId dailyNutrientAmountId = dailyNutritionDao
				.selectDailyNutrientAmountId(date, accountId);
		if (null == dailyNutrientAmountId) {
			dailyNutrientAmountId = newDailyNutrition(date, accountId);
		}
		return dailyNutrientAmountId;
	}

	// selectDailyNutritionIdと同じことをやっていた
	// public DailyNutrientAmountId selectDailyNutrientAmountId(YearMonthDay
	// yearMonthDay, LoginId loginId) {
	// AccountId accountId = new
	// AccountId(targetNutritionDao.selectAccountId(loginId));
	// DailyNutrientAmountId dailyNutrientAmountId =
	// dailyNutritionDao.selectDailyNutrientAmountId(yearMonthDay.getYearMonthDay(),
	// accountId);
	// if(null == dailyNutrientAmountId) {
	// dailyNutrientAmountId = newDailyNutrition(yearMonthDay.getYearMonthDay(),
	// accountId);
	// }
	// return dailyNutrientAmountId;
	// }

	// 評価対象外を取得
	public NotSubjectToEvaluation selectNotSubjectToEvaluation(
			DailyNutrientAmountId dailyNutrientAmountId) {
		return dailyNutritionDao
				.selectNotSubjectToEvaluation(dailyNutrientAmountId);
	}

}
