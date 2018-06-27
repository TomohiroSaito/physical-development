package physicaldevelopment.datasource.evaluation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import physicaldevelopment.datasource.mapper.evaluation.EvaluationMapper;
import physicaldevelopment.model.dailynutrition.DailyNutrientAmountId;
import physicaldevelopment.model.evaluation.EnergyHighAndLow;
import physicaldevelopment.model.evaluation.Evaluation;
import physicaldevelopment.model.evaluation.NotSubjectToEvaluation;
import physicaldevelopment.model.evaluation.Score;

@Repository
public class EvaluationDaoImpl implements EvaluationDao {
	@Autowired
	EvaluationMapper evaluationMapper;

	@Override
	public void insertEvaluation(DailyNutrientAmountId dailyNutrientAmountId, Evaluation evaluation) {
		evaluationMapper.insertEvaluation(dailyNutrientAmountId, evaluation);
	}

	@Override
	public void updateNotSubjectToEvaluation(DailyNutrientAmountId dailyNutrientAmountId,
			NotSubjectToEvaluation notSubjectToEvaluation) {
		evaluationMapper.updateNotSubjectToEvaluation(dailyNutrientAmountId, notSubjectToEvaluation);
	}

	@Override
	public Boolean existEvaluation(DailyNutrientAmountId dailyNutrientAmountId) {
		if(evaluationMapper.existEvaluation(dailyNutrientAmountId) == null) {
			return false;
		}
		return true;
	}

	@Override
	public Evaluation selectEvaluation(DailyNutrientAmountId dailyNutrientAmountId) {
		return evaluationMapper.selectEvaluation(dailyNutrientAmountId);
	}

	@Override
	public void updateEvaluation(DailyNutrientAmountId dailyNutrientAmountId, Score score,
			EnergyHighAndLow energyHighAndLow) {
		evaluationMapper.updateEvaluation(dailyNutrientAmountId, score, energyHighAndLow);
	}

	@Override
	public void upsertNotSubjectToEvaluation(DailyNutrientAmountId dailyNutrientAmountId,
			Evaluation evaluation) {
		evaluationMapper.upsertNotSubjectToEvaluation(dailyNutrientAmountId, evaluation);
	}

}
