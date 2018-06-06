--会員
CREATE TABLE user.user (
  user_id INT,
  login_id VARCHAR(10),
  password VARCHAR(10),
  created_at DATE,
  updated_at DATE,
  PRIMARY KEY (user_id),
  UNIQUE (login_id)
);
