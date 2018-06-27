package physicaldevelopment.model.evaluation;

public class Evaluation {
	private Score score;
	private EnergyHighAndLow energyHighAndLow;
	private NotSubjectToEvaluation notSubjectToEvaluation;
	public Evaluation() {}
	public Evaluation(Evaluation evaluation, NotSubjectToEvaluation notSubjectToEvaluation) {
		this.score = evaluation.getScore();
		this.energyHighAndLow = evaluation.getEnergyHighAndLow();
		this.notSubjectToEvaluation = evaluation.getNotSubjectToEvaluation();
	}
	public Evaluation(Score score, EnergyHighAndLow energyHighAndLow,
			NotSubjectToEvaluation notSubjectToEvaluation) {
		this.score = score;
		this.energyHighAndLow = energyHighAndLow;
		this.notSubjectToEvaluation = notSubjectToEvaluation;
	}
	public Evaluation(NotSubjectToEvaluation notSubjectToEvaluation) {
		this.notSubjectToEvaluation = notSubjectToEvaluation;
	}
	public Score getScore() {
		return score;
	}
	public void setScore(Score score) {
		this.score = score;
	}
	public EnergyHighAndLow getEnergyHighAndLow() {
		return energyHighAndLow;
	}
	public void setEnergyHighAndLow(EnergyHighAndLow energyHighAndLow) {
		this.energyHighAndLow = energyHighAndLow;
	}
	public NotSubjectToEvaluation getNotSubjectToEvaluation() {
		return notSubjectToEvaluation;
	}
	public void setNotSubjectToEvaluation(NotSubjectToEvaluation notSubjectToEvaluation) {
		this.notSubjectToEvaluation = notSubjectToEvaluation;
	}
}
