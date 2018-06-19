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

	public Evaluation calcEvaluation(Date date, AccountId accountId) {
		DailyNutrientAmountId dailyNutrientAmountId = dailyNutritionService.selectDailyNutritionId(date, accountId);
		TotalNutrientAmountPerDay totalNutrientAmountPerDay = dailyNutritionService.createTotalNutrientAmountPerDay(dailyNutrientAmountId);
		 TargetNutrition targetNutrition = targetNutritionService.selectTargetNutrientAmount(accountId);


		int dayEnergy = totalNutrientAmountPerDay.getEnergyNutrientAmount().getNutrientAmount();
		int dayProtein = totalNutrientAmountPerDay.getProteinNutrientAmount().getNutrientAmount();
		int dayLipid = totalNutrientAmountPerDay.getLipidNutrientAmount().getNutrientAmount();
		int dayCarbohydrate = totalNutrientAmountPerDay.getCarbohydrateNutrientAmount().getNutrientAmount();

		int targetEnergy = targetNutrition.getEnergyTargetNutrientAmount().getNutrientAmount().getNutrientAmount();
		int targetProtein = targetNutrition.getProteinTargetNutrientAmount().getNutrientAmount().getNutrientAmount();
		int targetLipid = targetNutrition.getLipidTargetNutrientAmount().getNutrientAmount().getNutrientAmount();
		int targetCarbohydrate = targetNutrition.getCarbohydrateTargetNutrientAmount().getNutrientAmount().getNutrientAmount();

		int energyHighAndLow = highAndLowDayFromTarget(dayEnergy, targetEnergy);
		int proteinHighAndLow = highAndLowDayFromTarget(dayProtein, targetProtein);
		int lipidHighAndLow = highAndLowDayFromTarget(dayLipid, targetLipid);
		int carbohydrateHighAndLow = highAndLowDayFromTarget(dayCarbohydrate, targetCarbohydrate);

		int scoreEvaluation = calcScoreEvaluation(energyHighAndLow, proteinHighAndLow, lipidHighAndLow, carbohydrateHighAndLow);

		return new Evaluation(new Score(scoreEvaluation), new EnergyHighAndLow(energyHighAndLow), new NotSubjectToEvaluation());

	}

	private int highAndLowDayFromTarget(int dayNutrition, int targetNutrition) {
		double persent = (double)dayNutrition / targetNutrition * 100;
		return (int)Math.ceil(persent - 100);
	}

	private int calcScoreEvaluation(int energyHighAndLow, int proteinHighAndLow, int lipidHighAndLow, int carbohydrateHighAndLow) {
		int scoreEnergy = calcScoreNutrition(energyHighAndLow);
		int scoreProtein = calcScoreNutrition(proteinHighAndLow);
		int scoreLipid = calcScoreNutrition(lipidHighAndLow);
		int scoreCarbohydrate = calcScoreNutrition(carbohydrateHighAndLow);
		int scoreEvaluation = scoreEnergy * 2 + scoreProtein + scoreLipid + scoreCarbohydrate;
		return scoreEvaluation;
	}

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
