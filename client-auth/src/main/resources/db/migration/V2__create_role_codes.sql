CREATE TABLE role_codes (
  id          INTEGER PRIMARY KEY,
  description VARCHAR(1024),
  enabled_at  TIMESTAMP,
  disabled_at TIMESTAMP
);