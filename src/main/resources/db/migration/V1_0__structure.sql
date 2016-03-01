CREATE TABLE iot (
  id INTEGER PRIMARY KEY AUTO_INCREMENT,
  mac varchar(100),
  type varchar(100)
);
CREATE TABLE beacon (
  id INTEGER PRIMARY KEY AUTO_INCREMENT,
  iot_id INTEGER
);
CREATE TABLE uid (
  id INTEGER PRIMARY KEY AUTO_INCREMENT,
  id_namespace VARCHAR(40),
  id_instance VARCHAR(40),
  uids VARCHAR(40) ,
  power VARCHAR(40),
  mfg_id VARCHAR(40) ,
  service_uuid VARCHAR(40) ,
  rssi VARCHAR(40),
  beacon_id INTEGER
);
CREATE TABLE url (
  id INTEGER PRIMARY KEY AUTO_INCREMENT,
  url VARCHAR(40) NOT NULL,
  uids VARCHAR(40) ,
  power VARCHAR(40) NOT NULL,
  mfg_id VARCHAR(40) ,
  service_uuid VARCHAR(40) ,
  rssi VARCHAR(40) NOT NULL,
  beacon_id INTEGER
);
CREATE TABLE tlm (
  id INTEGER PRIMARY KEY AUTO_INCREMENT,
  seconds VARCHAR(40),
  voltage VARCHAR(40),
  temperature VARCHAR(40),
  pdus VARCHAR(40),
  beacon_id INTEGER
);

