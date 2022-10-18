 CREATE TABLE role (
  role_id BIGINT(20) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  role VARCHAR(500)
  
);
CREATE TABLE user (
  user_id BIGINT(20) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  email VARCHAR(500),
  first_name VARCHAR(500),
  last_name VARCHAR(500),
  mobile_number VARCHAR(500),
  password VARCHAR(500),
  role_id BIGINT(20) UNSIGNED,
  FOREIGN KEY (role_id) REFERENCES role(role_id),
  INDEX idx_user_email (email)
 );

CREATE TABLE stop (
  stop_id BIGINT(20) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  code VARCHAR(500),
  detail VARCHAR(500),
  name VARCHAR(500),
  INDEX idx_stop_code(code)
);


CREATE TABLE agency (
  agency_id BIGINT(20) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  code VARCHAR(500),
  details VARCHAR(500),
  name VARCHAR(500),
  owner_user_id BIGINT(20) UNSIGNED,
  FOREIGN KEY (owner_user_id) REFERENCES user(user_id),
  INDEX idx_agency_code(code)
);
CREATE TABLE bus (
  bus_id BIGINT(20) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  capacity INT(20) NOT NULL,
  code VARCHAR(500),
  make VARCHAR(500),
  agency_id BIGINT(20) UNSIGNED,
  FOREIGN KEY (agency_id) REFERENCES agency(agency_id),
  INDEX idx_bus_code(code)
);
CREATE TABLE trip (
  trip_id BIGINT(20) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  fare INT(20) NOT NULL,
  journey_time INT(20),
  agency_id BIGINT(20) UNSIGNED,
  bus_id BIGINT(20) UNSIGNED,
  dest_stop_id BIGINT(20) UNSIGNED,
  source_stop_id BIGINT(20) UNSIGNED,
  FOREIGN KEY (agency_id) REFERENCES agency(agency_id),
  FOREIGN KEY (bus_id) REFERENCES bus(bus_id),
  FOREIGN KEY (dest_stop_id) REFERENCES stop(stop_id),
  FOREIGN KEY (source_stop_id) REFERENCES stop(stop_id)
  
);
CREATE TABLE trip_schedule (
  trip_schedule_id BIGINT(20) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  available_seats INT(20),
  trip_date VARCHAR(500),
  trip_id BIGINT(20) UNSIGNED,
  FOREIGN KEY (trip_id) REFERENCES trip(trip_id)
 );
CREATE TABLE ticket (
  ticket_id BIGINT(20) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  cancellable BIT(1),
  journey_date VARCHAR(500),
  seat_number INT(20),
  user_id BIGINT(20) UNSIGNED,
  trip_schedule_id BIGINT(20) UNSIGNED,
  FOREIGN KEY (user_id) REFERENCES user(user_id),
  FOREIGN KEY (trip_schedule_id) REFERENCES trip_schedule(trip_schedule_id)
);

 

  
