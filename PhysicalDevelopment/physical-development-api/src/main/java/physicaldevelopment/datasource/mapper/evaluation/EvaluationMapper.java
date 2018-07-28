package physicaldevelopment.datasource.mapper.evaluation;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import physicaldevelopment.datasource.mapper.MyMapper;
import physicaldevelopment.model.dailynutrition.DailyNutrientAmountId;
import physicaldevelopment.model.evaluation.EnergyHighAndLow;
import physicaldevelopment.model.evaluation.Evaluation;
import physicaldevelopment.model.evaluation.NotSubjectToEvaluation;
import physicaldevelopment.model.evaluation.Score;

@Repository
@MyMapper
public interface EvaluationMapper {

	public void insertEvaluation(
			@Param("dailyNutrientAmountId") DailyNutrientAmountId dailyNutrientAmountId,
			@Param("evaluation") Evaluation evaluation);

	public void updateNotSubjectToEvaluation(
			@Param("dailyNutrientAmountId") DailyNutrientAmountId dailyNutrientAmountId,
			@Param("notSubjectToEvaluation") NotSubjectToEvaluation notSubjectToEvaluation);

	public Integer existEvaluation(
			@Param("dailyNutrientAmountId") DailyNutrientAmountId dailyNutrientAmountId);

	public Evaluation selectEvaluation(
			@Param("dailyNutrientAmountId") DailyNutrientAmountId dailyNutrientAmountId);

	public void updateEvaluation(
			@Param("dailyNutrientAmountId") DailyNutrientAmountId dailyNutrientAmountId,
			@Param("score") Score score,
			@Param("energyHighAndLow") EnergyHighAndLow energyHighAndLow);

	public void upsertNotSubjectToEvaluation(
			@Param("dailyNutrientAmountId") DailyNutrientAmountId dailyNutrientAmountId,
			@Param("notSubjectToEvaluation") NotSubjectToEvaluation notSubjectToEvaluation);

	// public void upsertEvaluation(@Param("dailyNutrientAmountId")
	// DailyNutrientAmountId dailyNutrientAmountId, @Param("evaluation")
	// Evaluation evaluation);

}
