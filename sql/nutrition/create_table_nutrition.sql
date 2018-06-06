DROP TABLE IF EXISTS nutrition.nutrition;

--栄養素
CREATE TABLE nutrition.nutrition (
  nutrition_type VARCHAR(20),
  nutrition_name VARCHAR(20) NOT NULL,
  created_at DATE NOT NULL,
  updated_at DATE NOT NULL,
  PRIMARY KEY (nutrition_type),
  UNIQUE (nutrition_name)
);
