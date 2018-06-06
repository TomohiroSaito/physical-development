DROP TABLE nutrition.nutrition;

--栄養素
CREATE TABLE nutrition.nutrition (
  nutrition_type VARCHAR(20),
  nutrition_name VARCHAR(20),
  created_at DATE,
  updated_at DATE,
  PRIMARY KEY (nutrition_type),
  UNIQUE (nutrition_name)
);
