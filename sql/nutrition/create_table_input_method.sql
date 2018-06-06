DROP TABLE IF EXISTS nutrition.input_method;

--入力方法
CREATE TABLE nutrition.input_method (
  input_type VARCHAR(20),
  input_method_name VARCHAR(10) NOT NULL,
  created_at DATE NOT NULL,
  updated_at DATE NOT NULL,
  PRIMARY KEY (input_type),
  UNIQUE (input_method_name)
);
