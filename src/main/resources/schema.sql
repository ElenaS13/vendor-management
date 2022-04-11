CREATE SEQUENCE IF NOT EXISTS vendor_seq;

CREATE TABLE IF NOT EXISTS vendor (

vendor_id BIGINT NOT NULL DEFAULT nextval('vendor_seq') PRIMARY KEY,
email VARCHAR(100) NOT NULL,
first_name VARCHAR(100) NOT NULL,
last_name VARCHAR(100) NOT NULL

);

CREATE SEQUENCE IF NOT EXISTS project_seq;

CREATE TABLE IF NOT EXISTS project (

project_id BIGINT NOT NULL DEFAULT nextval('project_seq') PRIMARY KEY,
name VARCHAR(100) NOT NULL,
stage VARCHAR(100) NOT NULL,
description VARCHAR(500) NOT NULL

);


CREATE TABLE IF NOT EXISTS project_vendor (

project_id BIGINT REFERENCES project,
vendor_id BIGINT REFERENCES vendor

);
