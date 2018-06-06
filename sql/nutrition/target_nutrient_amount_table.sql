--目標栄養素量
CREATE TABLE nutrition.target_nutrient_amount (
  target_nutrient_amount_id INT,
  user_id INT,
  nutrition_type VARCHAR(12),
  target_nutrient_amount INT,
  created_at DATE,
  updated_at DATE,
  PRIMARY KEY (target_nutrient_amount_id),
  FOREIGN KEY (user_id) REFERENCES user.user (user_id),
  FOREIGN KEY (nutrition_type) REFERENCES nutrition.nutrition (nutrition_type)
);
