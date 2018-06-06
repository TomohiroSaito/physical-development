--プロフィール
CREATE TABLE user.profile (
  user_id INT,
  sex_type VARCHAR(5),
  birthday DATE,
  created_at DATE,
  updated_at DATE,
  PRIMARY KEY (user_id),
  FOREIGN KEY (user_id) REFERENCES user.user (user_id),
  FOREIGN KEY (sex_type) REFERENCES user.sex (sex_type)
);
