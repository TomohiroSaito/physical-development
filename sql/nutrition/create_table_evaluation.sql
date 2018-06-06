DROP TABLE nutrition.evaluation;

--評価
CREATE TABLE nutrition.evaluation (
  daily_nutrient_amount_id INT,
  score INT,
  energy_high_and_low INT,
  not_subject_to_evaluation BOOLEAN,
  created_at DATE,
  updated_at DATE,
  PRIMARY KEY (daily_nutrient_amount_id),
  FOREIGN KEY (daily_nutrient_amount_id) REFERENCES nutrition.daily_nutrient_amount (daily_nutrient_amount_id)
);
