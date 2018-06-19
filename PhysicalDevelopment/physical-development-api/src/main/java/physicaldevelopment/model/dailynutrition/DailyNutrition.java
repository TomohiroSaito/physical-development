package physicaldevelopment.model.dailynutrition;

import physicaldevelopment.model.primitive.YearMonthDay;
import physicaldevelopment.model.targetnutrition.TargetNutrition;

public class DailyNutrition {
	private TotalNutrientAmountPerDay totalNutrientAmountPerDay;
	private TargetNutrition targetNutrition;
	private YearMonthDay yearMonthDay;
	public DailyNutrition() {
	}
	public DailyNutrition(TotalNutrientAmountPerDay totalNutrientAmountPerDay, TargetNutrition targetNutrition,
			YearMonthDay yearMonthDay) {
		this.totalNutrientAmountPerDay = totalNutrientAmountPerDay;
		this.targetNutrition = targetNutrition;
		this.yearMonthDay = yearMonthDay;
	}
	public TotalNutrientAmountPerDay getTotalNutrientAmountPerDay() {
		return totalNutrientAmountPerDay;
	}
	public void setTotalNutrientAmountPerDay(TotalNutrientAmountPerDay totalNutrientAmountPerDay) {
		this.totalNutrientAmountPerDay = totalNutrientAmountPerDay;
	}
	public TargetNutrition getTargetNutrition() {
		return targetNutrition;
	}
	public void setTargetNutrition(TargetNutrition targetNutrition) {
		this.targetNutrition = targetNutrition;
	}
	public YearMonthDay getYearMonthDay() {
		return yearMonthDay;
	}
	public void setYearMonthDay(YearMonthDay yearMonthDay) {
		this.yearMonthDay = yearMonthDay;
	}
}
