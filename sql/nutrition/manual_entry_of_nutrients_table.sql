--栄養素の手動入力
CREATE TABLE nutrition.manual_entry_of_nutrients (
  manual_entry_of_nutrients_id INT,
  meal_id INT,
  nutrition_type VARCHAR(12),
  created_at DATE,
  updated_at DATE,
  PRIMARY KEY (manual_entry_of_nutrients_id),
  FOREIGN KEY (meal_id) REFERENCES nutrition.meal (meal_id),
  FOREIGN KEY (nutrition_type) REFERENCES nutrition.nutrition (nutrition_type)
);
