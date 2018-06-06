DROP TABLE nutrition.daily_nutrient_amount;

--1日の栄養素量
CREATE TABLE nutrition.daily_nutrient_amount (
  daily_nutrient_amount_id INT,
  account_id INT,
  year_month_day DATE,
  target_nutrient_amount_id INT,
  created_at DATE,
  updated_at DATE,
  PRIMARY KEY (daily_nutrient_amount_id),
  FOREIGN KEY (account_id) REFERENCES account.account (account_id),
  FOREIGN KEY (target_nutrient_amount_id) REFERENCES nutrition.target_nutrient_amount (target_nutrient_amount_id),
  UNIQUE (account_id, year_month_day)
);
