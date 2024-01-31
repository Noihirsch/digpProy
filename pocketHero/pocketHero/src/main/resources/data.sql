
INSERT INTO campaign (name, description, dm_id) VALUES
  ('Adventure A', 'A thrilling quest through unknown lands', 1),
  ('Mystery Quest', 'Solve the mysteries of an ancient civilization', 2),
  ('Epic Journey', 'Embark on a grand adventure to save the world', 3);

INSERT INTO player (username, email, password, signup_date, is_dm) VALUES
  ('dm_john', 'dm.john@example.com', 'dm_password', '2022-01-01', true),
  ('dm_alice', 'dm.alice@example.com', 'dm_pass456', '2022-02-15', true),
  ('dm_bob', 'dm.bob@example.com', 'dm_qwerty789', '2022-03-30', true);
