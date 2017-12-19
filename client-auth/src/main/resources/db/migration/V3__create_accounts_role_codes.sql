CREATE TABLE accounts_role_codes (
  accounts_id INTEGER NOT NULL,
  role_codes_id    INTEGER NOT NULL,
  PRIMARY KEY (accounts_id, role_codes_id),
  FOREIGN KEY (accounts_id) REFERENCES accounts(id),
  FOREIGN KEY (role_codes_id) REFERENCES role_codes(id)
);