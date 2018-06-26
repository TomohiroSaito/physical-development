package physicaldevelopment.service.evaluation;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	//評価計算
	public Evaluation calcEvaluation(Date date, AccountId accountId) {
		//目標栄養素の取得
		 TargetNutrition targetNutrition = targetNutritionService.selectTargetNutrientAmount(accountId);
		 //目標を入力していなかったらnullを返す？
		 if(null == targetNutrition) {
			 return null;
		 }
		 //1日の栄養素IDを取得
		DailyNutrientAmountId dailyNutrientAmountId = dailyNutritionService.selectDailyNutritionId(date, accountId);
		//指定した日の食事登録がなければ0で作成した評価を返す
		if(null == dailyNutrientAmountId) {
			return new Evaluation(new Score(0), new EnergyHighAndLow(0), new NotSubjectToEvaluation());
		}
		//1日の栄養素量の合計を取得
		TotalNutrientAmountPerDay totalNutrientAmountPerDay = dailyNutritionService.createTotalNutrientAmountPerDay(dailyNutrientAmountId);


		//1日の栄養素をそれぞれint型に取得
		int dayEnergy = totalNutrientAmountPerDay.getEnergyNutrientAmount().getNutrientAmount();
		int dayProtein = totalNutrientAmountPerDay.getProteinNutrientAmount().getNutrientAmount();
		int dayLipid = totalNutrientAmountPerDay.getLipidNutrientAmount().getNutrientAmount();
		int dayCarbohydrate = totalNutrientAmountPerDay.getCarbohydrateNutrientAmount().getNutrientAmount();

		//目標栄養素をそれぞれint型に取得
		int targetEnergy = targetNutrition.getEnergyTargetNutrientAmount().getNutrientAmount().getNutrientAmount();
		int targetProtein = targetNutrition.getProteinTargetNutrientAmount().getNutrientAmount().getNutrientAmount();
		int targetLipid = targetNutrition.getLipidTargetNutrientAmount().getNutrientAmount().getNutrientAmount();
		int targetCarbohydrate = targetNutrition.getCarbohydrateTargetNutrientAmount().getNutrientAmount().getNutrientAmount();

		//1日の栄養素量-目標栄養素量を計算
		int energyHighAndLow = highAndLowDayFromTarget(dayEnergy, targetEnergy);
		int proteinHighAndLow = highAndLowDayFromTarget(dayProtein, targetProtein);
		int lipidHighAndLow = highAndLowDayFromTarget(dayLipid, targetLipid);
		int carbohydrateHighAndLow = highAndLowDayFromTarget(dayCarbohydrate, targetCarbohydrate);

		//評価を計算
		int scoreEvaluation = calcScoreEvaluation(energyHighAndLow, proteinHighAndLow, lipidHighAndLow, carbohydrateHighAndLow);

		//評価を作成して返す
		return new Evaluation(new Score(scoreEvaluation), new EnergyHighAndLow(energyHighAndLow), dailyNutritionService.selectNotSubjectToEvaluation(dailyNutrientAmountId));

	}

	//1日の栄養素量と目標栄養素量を受け取り、パーセンテージを計算
	private int highAndLowDayFromTarget(int dayNutrition, int targetNutrition) {
		double persent = (double)dayNutrition / targetNutrition * 100;
		return (int)Math.ceil(persent - 100);
	}

	//パーセンテージの範囲を受け取り、評価値を計算
	private int calcScoreEvaluation(int energyHighAndLow, int proteinHighAndLow, int lipidHighAndLow, int carbohydrateHighAndLow) {
		int scoreEnergy = calcScoreNutrition(energyHighAndLow);
		int scoreProtein = calcScoreNutrition(proteinHighAndLow);
		int scoreLipid = calcScoreNutrition(lipidHighAndLow);
		int scoreCarbohydrate = calcScoreNutrition(carbohydrateHighAndLow);
		int scoreEvaluation = scoreEnergy * 2 + scoreProtein + scoreLipid + scoreCarbohydrate;
		return scoreEvaluation;
	}

	//パーセンテージの範囲から評価値を計算
	private int calcScoreNutrition(int highAndLow) {
		int score = 0;
		if(highAndLow < 10) {
			score = 2;
		} else if(highAndLow < 20) {
			score = 1;
		} else {
			score = 0;
		}

		return score;
	}
}
