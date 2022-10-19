INSERT INTO role (role)
VALUES ('ADMIN');

INSERT INTO role (role)
VALUES ('PASSENGER');

INSERT INTO user (email, first_name, last_name, mobile_number, password,role_id)
VALUES ('admin@gmail.com', 'John', 'Doe', '9425094250', '$2a$10$7PtcjEnWb/ZkgyXyxY1/Iei2dGgGQUbqIIll/dt.qJ8l8nQBWMbYO',1);

INSERT INTO user (email, first_name, last_name, mobile_number, password,role_id)
VALUES ('passenger@gmail.com', 'Mira', 'Jane', '8000110008', '$2a$10$7PtcjEnWb/ZkgyXyxY1/Iei2dGgGQUbqIIll/dt.qJ8l8nQBWMbYO',2);

INSERT INTO user (email, first_name, last_name, mobile_number, password,role_id)
VALUES ('admin', 'admin', '', '82022', '$2a$12$af4SnLhLIBlgS3sBAkTcUO7dlqnWXJpvZliiifXOh5DE5ky9v8UbC',1);


INSERT INTO stop (name, detail, code)
VALUES ('Stop A', 'Near hills', 'STPA');

INSERT INTO stop (name, detail, code)
VALUES ('Stop B', 'Near rivers', 'STPB');

INSERT INTO stop (name, detail, code)
VALUES ('Stop C', 'Near desert', 'STPC');

INSERT INTO stop (name, detail, code)
VALUES ('Stop D', 'Near lake', 'STPD');

INSERT INTO agency (name, details, code,owner_user_id)
VALUES ('Green Mile Agency', 'Reaching desitnations with ease', 'AGENCY-A','1');

INSERT INTO bus (capacity, code,agency_id)
VALUES ('60', 'AGENCY-A-1','1');

INSERT INTO trip (fare, journey_time,agency_id,bus_id,dest_stop_id,source_stop_id)
VALUES ('100','60', '1','1','2','1');

INSERT INTO trip_schedule (available_seats,trip_date,trip_id)
VALUES ('60','2022-10-16','1');

