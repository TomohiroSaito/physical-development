DROP TABLE nutrition.latest_target_nutrient_amount;

--最新目標栄養素量
CREATE TABLE nutrition.latest_target_nutrient_amount (
  target_nutrient_amount_id INT,
  created_at DATE,
  updated_at DATE,
  PRIMARY KEY (target_nutrient_amount_id),
  FOREIGN KEY (target_nutrient_amount_id) REFERENCES nutrition.target_nutrient_amount (target_nutrient_amount_id)
);
