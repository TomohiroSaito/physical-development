--入力方法
CREATE TABLE nutrition.input_method (
  input_type VARCHAR(6),
  input_method_name VARCHAR(4),
  created_at DATE,
  updated_at DATE,
  PRIMARY KEY (input_type),
  UNIQUE (input_method_name)
);
