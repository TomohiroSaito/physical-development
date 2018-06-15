DROP TABLE IF EXISTS nutrition.daily_nutrient_amount_x_target_nutrient_amount;

--1日の栄養素量x目標栄養素量
CREATE TABLE nutrition.daily_nutrient_amount_x_target_nutrient_amount (

  daily_nutrient_amount_x_target_nutrient_amount_id SERIAL,
  daily_nutrient_amount_id INT NOT NULL,
  target_nutrient_amount_id INT NOT NULL,
  created_at DATE NOT NULL,
  updated_at DATE NOT NULL,
  PRIMARY KEY (daily_nutrient_amount_x_target_nutrient_amount_id),
  FOREIGN KEY (daily_nutrient_amount_id) REFERENCES nutrition.daily_nutrient_amount (daily_nutrient_amount_id),
  FOREIGN KEY (target_nutrient_amount_id) REFERENCES nutrition.target_nutrient_amount (target_nutrient_amount_id),
  UNIQUE (daily_nutrient_amount_id, target_nutrient_amount_id)
);
