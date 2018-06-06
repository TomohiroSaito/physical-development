DROP TABLE nutrition.input_method;

--入力方法
CREATE TABLE nutrition.input_method (
  input_type VARCHAR(20),
  input_method_name VARCHAR(10),
  created_at DATE,
  updated_at DATE,
  PRIMARY KEY (input_type),
  UNIQUE (input_method_name)
);
