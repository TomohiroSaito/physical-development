DROP TABLE IF EXISTS nutrition.daily_nutrient_amount;

--1日の栄養素量
CREATE TABLE nutrition.daily_nutrient_amount (
  daily_nutrient_amount_id INT,
  account_id INT NOT NULL,
  year_month_day DATE NOT NULL,
  target_nutrient_amount_id INT NOT NULL,
  created_at DATE NOT NULL,
  updated_at DATE NOT NULL,
  PRIMARY KEY (daily_nutrient_amount_id),
  FOREIGN KEY (account_id) REFERENCES account.account (account_id),
  FOREIGN KEY (target_nutrient_amount_id) REFERENCES nutrition.target_nutrient_amount (target_nutrient_amount_id),
  UNIQUE (account_id, year_month_day)
);

DROP SEQUENCE nutrition.daily_nutrient_amount_daily_nutrient_amount_id_SEQ;

CREATE SEQUENCE nutrition.daily_nutrient_amount_daily_nutrient_amount_id_SEQ
  INCREMENT BY 1
  MAXVALUE 2147483647
  START WITH 1
  NO CYCLE
;
