--1日の栄養素量
CREATE TABLE nutrition.daily_nutrient_amount (
  daily_nutrient_amount_id INT,
  user_id INT,
  year_month_day DATE,
  target_nutrient_amount_id INT,
  created_at DATE,
  updated_at DATE,
  PRIMARY KEY (daily_nutrient_amount_id),
  FOREIGN KEY (user_id) REFERENCES user.user (user_id),
  FOREIGN KEY (target_nutrient_amount_id) REFERENCES nutrition.target_nutrient_amount (target_nutrient_amount_id),
  UNIQUE (user_id, year_month_day)
);
