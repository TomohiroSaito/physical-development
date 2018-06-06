DROP TABLE IF EXISTS account.account;

--会員
CREATE TABLE account.account (
  account_id INT,
  login_id VARCHAR(20) NOT NULL,
  password VARCHAR(20) NOT NULL,
  created_at DATE NOT NULL,
  updated_at DATE NOT NULL,
  PRIMARY KEY (account_id),
  UNIQUE (login_id)
);

DROP SEQUENCE account.account_account_id_SEQ;

CREATE SEQUENCE account.account_account_id_SEQ
  INCREMENT BY 1
  MAXVALUE 2147483647
  START WITH 1
  NO CYCLE
;
