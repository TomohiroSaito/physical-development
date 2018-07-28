package physicaldevelopment.service.evaluation;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import physicaldevelopment.datasource.evaluation.EvaluationDao;
import physicaldevelopment.model.account.AccountId;
import physicaldevelopment.model.dailynutrition.DailyNutrientAmountId;
import physicaldevelopment.model.dailynutrition.TotalNutrientAmountPerDay;
import physicaldevelopment.model.evaluation.EnergyHighAndLow;
import physicaldevelopment.model.evaluation.Evaluation;
import physicaldevelopment.model.evaluation.NotSubjectToEvaluation;
import physicaldevelopment.model.evaluation.Score;
import physicaldevelopment.model.targetnutrition.TargetNutrition;
import physicaldevelopment.service.dailynutrition.DailyNutritionService;
import physicaldevelopment.service.targetnutrition.TargetNutritionService;

@Service
public class EvaluationService {
	@Autowired
	DailyNutritionService dailyNutritionService;

	@Autowired
	TargetNutritionService targetNutritionService;

	@Autowired
	EvaluationDao evaluationDao;

	// 評価計算
	public Evaluation calcEvaluation(Date date, AccountId accountId) {
		// 目標栄養素の取得
		TargetNutrition targetNutrition = targetNutritionService
				.selectTargetNutrientAmount(accountId);

		// 目標を入力していなかったらnullを返す？
		if (null == targetNutrition) {
			return null;
		}

		// 1日の栄養素IDを取得
		DailyNutrientAmountId dailyNutrientAmountId = dailyNutritionService
				.selectDailyNutritionId(date, accountId);

		// 指定した日の食事登録がなければ0で作成した評価を返す
		if (null == dailyNutrientAmountId) {
			return new Evaluation(new Score(0), new EnergyHighAndLow(0),
					new NotSubjectToEvaluation(false));
		}

		// 1日の栄養素量の合計を取得
		TotalNutrientAmountPerDay totalNutrientAmountPerDay = dailyNutritionService
				.createTotalNutrientAmountPerDay(dailyNutrientAmountId);

		// 評価を計算
		Integer scoreEvaluation = calcScoreEvaluation(
				totalNutrientAmountPerDay, targetNutrition);

		// 評価モデルに格納するエネルギーの＋－値を計算
		Integer energyHighAndLow = energyHighAndLowDayFromTarget(
				totalNutrientAmountPerDay, targetNutrition);

		// 評価を作成して登録
		// 後で修正
		Evaluation evaluation = null;
		if (evaluationDao.existEvaluation(dailyNutrientAmountId)) {

			// 評価が存在すれば更新
			evaluationDao.updateEvaluation(dailyNutrientAmountId, new Score(
					scoreEvaluation), new EnergyHighAndLow(energyHighAndLow));
			evaluation = evaluationDao.selectEvaluation(dailyNutrientAmountId);
		} else {

			// 評価が存在しなければ新たに作成
			evaluation = new Evaluation(new Score(scoreEvaluation),
					new EnergyHighAndLow(energyHighAndLow),
					new NotSubjectToEvaluation(false));
			evaluationDao.insertEvaluation(dailyNutrientAmountId, evaluation);
		}

		return evaluation;

	}

	// 1日の栄養素量と目標栄養素量を受け取り、パーセンテージを計算
	private int highAndLowDayFromTarget(Integer dayNutrition,
			Integer targetNutrition) {
		double persent = (double) dayNutrition / targetNutrition * 100;
		return (int) Math.ceil(persent - 100);
	}

	// 評価モデルに格納するエネルギーの＋－値を計算
	private int energyHighAndLowDayFromTarget(
			TotalNutrientAmountPerDay totalNutrientAmountPerDay,
			TargetNutrition targetNutrition) {
		int dayNutrition = totalNutrientAmountPerDay.getEnergyNutrientAmount()
				.getNutrientAmount();
		int integerTargetNutrition = targetNutrition
				.getEnergyTargetNutrientAmount().getNutrientAmount()
				.getNutrientAmount();
		double persent = (double) dayNutrition / integerTargetNutrition * 100;
		return (int) Math.ceil(persent - 100);
	}

	// パーセンテージの範囲を受け取り、評価値を計算
	private Integer calcScoreEvaluation(
			TotalNutrientAmountPerDay totalNutrientAmountPerDay,
			TargetNutrition targetNutrition) {
		// 1日の栄養素をそれぞれint型に取得
		int dayEnergy = totalNutrientAmountPerDay.getEnergyNutrientAmount()
				.getNutrientAmount();
		int dayProtein = totalNutrientAmountPerDay.getProteinNutrientAmount()
				.getNutrientAmount();
		int dayLipid = totalNutrientAmountPerDay.getLipidNutrientAmount()
				.getNutrientAmount();
		int dayCarbohydrate = totalNutrientAmountPerDay
				.getCarbohydrateNutrientAmount().getNutrientAmount();

		// 目標栄養素をそれぞれint型に取得
		int targetEnergy = targetNutrition.getEnergyTargetNutrientAmount()
				.getNutrientAmount().getNutrientAmount();
		int targetProtein = targetNutrition.getProteinTargetNutrientAmount()
				.getNutrientAmount().getNutrientAmount();
		int targetLipid = targetNutrition.getLipidTargetNutrientAmount()
				.getNutrientAmount().getNutrientAmount();
		int targetCarbohydrate = targetNutrition
				.getCarbohydrateTargetNutrientAmount().getNutrientAmount()
				.getNutrientAmount();

		// 1日の栄養素量-目標栄養素量を計算
		int energyHighAndLow = highAndLowDayFromTarget(dayEnergy, targetEnergy);
		int proteinHighAndLow = highAndLowDayFromTarget(dayProtein,
				targetProtein);
		int lipidHighAndLow = highAndLowDayFromTarget(dayLipid, targetLipid);
		int carbohydrateHighAndLow = highAndLowDayFromTarget(dayCarbohydrate,
				targetCarbohydrate);

		int scoreEnergy = calcScoreNutrition(energyHighAndLow);
		int scoreProtein = calcScoreNutrition(proteinHighAndLow);
		int scoreLipid = calcScoreNutrition(lipidHighAndLow);
		int scoreCarbohydrate = calcScoreNutrition(carbohydrateHighAndLow);
		int scoreEvaluation = scoreEnergy * 2 + scoreProtein + scoreLipid
				+ scoreCarbohydrate;
		return scoreEvaluation;
	}

	// パーセンテージの範囲から評価値を計算
	private int calcScoreNutrition(int highAndLow) {
		int score = 0;
		if (-10 <= highAndLow && highAndLow <= 10) {
			score = 2;
		} else if (-20 <= highAndLow && highAndLow <= 20) {
			score = 1;
		} else {
			score = 0;
		}

		return score;
	}

	public void updateNotSubjectToEvaluation(
			DailyNutrientAmountId dailyNutrientAmountId,
			NotSubjectToEvaluation notSubjectToEvaluation) {
		evaluationDao.updateNotSubjectToEvaluation(dailyNutrientAmountId,
				notSubjectToEvaluation);
	}

	public void upsertNotSubjectToEvaluation(
			DailyNutrientAmountId dailyNutrientAmountId,
			NotSubjectToEvaluation notSubjectToEvaluation) {
		evaluationDao.upsertNotSubjectToEvaluation(dailyNutrientAmountId,
				notSubjectToEvaluation);
	}
}
