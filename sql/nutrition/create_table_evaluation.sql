DROP TABLE IF EXISTS nutrition.evaluation;

--評価
CREATE TABLE nutrition.evaluation (
  daily_nutrient_amount_id INT,
  score INT NOT NULL,
  energy_high_and_low INT NOT NULL,
  not_subject_to_evaluation BOOLEAN NOT NULL,
  created_at DATE NOT NULL,
  updated_at DATE NOT NULL,
  CONSTRAINT upst_pkey PRIMARY KEY (daily_nutrient_amount_id),
  FOREIGN KEY (daily_nutrient_amount_id) REFERENCES nutrition.daily_nutrient_amount (daily_nutrient_amount_id)
);
