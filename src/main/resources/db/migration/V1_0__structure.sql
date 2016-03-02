CREATE TABLE iot (
  mac varchar(100) PRIMARY KEY,
  type varchar(100)
);
CREATE TABLE beacon (
  id varchar(100) PRIMARY KEY
);
CREATE TABLE uid (
  id_instance VARCHAR(40) PRIMARY KEY,
  id_namespace VARCHAR(40) ,
  minor VARCHAR(40),
  major VARCHAR(40),
  uuid VARCHAR(40) ,
  power VARCHAR(40),
  mfg_id VARCHAR(40) ,
  service_uuid VARCHAR(40) ,
  rssi VARCHAR(40),
  beacon_id VARCHAR(40)
);
CREATE TABLE url (
  ids VARCHAR(40) PRIMARY KEY,
  uri VARCHAR(40),
  power VARCHAR(40),
  mfg_id VARCHAR(40) ,
  service_uuid VARCHAR(40) ,
  rssi VARCHAR(40),
  beacon_id VARCHAR(40)
);
CREATE TABLE tlm (
  seconds VARCHAR(40) PRIMARY KEY,
  voltage VARCHAR(40),
  temp VARCHAR(40),
  pdus VARCHAR(40),
  beacon_id VARCHAR(40)
);

