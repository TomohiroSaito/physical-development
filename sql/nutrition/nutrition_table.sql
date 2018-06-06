--栄養素
CREATE TABLE nutrition.nutrition (
  nutrition_type VARCHAR(12),
  nutrition_name VARCHAR(5),
  created_at DATE,
  updated_at DATE,
  PRIMARY KEY (nutrition_type),
  UNIQUE (nutrition_name)
);
