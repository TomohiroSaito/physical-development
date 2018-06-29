package physicaldevelopment.datasource.evaluation;

import org.springframework.stereotype.Repository;

import physicaldevelopment.model.dailynutrition.DailyNutrientAmountId;
import physicaldevelopment.model.evaluation.EnergyHighAndLow;
import physicaldevelopment.model.evaluation.Evaluation;
import physicaldevelopment.model.evaluation.NotSubjectToEvaluation;
import physicaldevelopment.model.evaluation.Score;

@Repository
public interface EvaluationDao {

	void insertEvaluation(DailyNutrientAmountId dailyNutrientAmountId, Evaluation evaluation);

	void updateNotSubjectToEvaluation(DailyNutrientAmountId dailyNutrientAmountId,
			NotSubjectToEvaluation notSubjectToEvaluation);

	Boolean existEvaluation(DailyNutrientAmountId dailyNutrientAmountId);

	Evaluation selectEvaluation(DailyNutrientAmountId dailyNutrientAmountId);

	void updateEvaluation(DailyNutrientAmountId dailyNutrientAmountId, Score score, EnergyHighAndLow energyHighAndLow);

	void upsertNotSubjectToEvaluation(DailyNutrientAmountId dailyNutrientAmountId,
			NotSubjectToEvaluation notSubjectToEvaluation);

//	void upsertEvaluation(DailyNutrientAmountId dailyNutrientAmountId, Evaluation evaluation);

}
