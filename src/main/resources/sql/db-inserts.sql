--
-- Additional test entries for unit testing
--

-- clean up from previous test runs
--DELETE FROM users WHERE id = 904711;
--DELETE FROM users WHERE id = 904712;
--DELETE FROM users WHERE id = 904713;
--
-- Single event
SET SCHEMA TEST;
--
INSERT INTO customer (id, firstname, lastname)
  VALUES
    (1, 'firstname1', 'lastname1'),
    (2, 'firstname2', 'lastname2'),
    (3, 'firstname3', 'lastname3'),
    (4, 'firstname4', 'lastname4');
