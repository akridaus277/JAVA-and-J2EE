-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 18, 2022 at 06:54 PM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `trs`
--

-- --------------------------------------------------------

--
-- Table structure for table `agency`
--

CREATE TABLE `agency` (
  `agency_id` bigint(20) UNSIGNED NOT NULL,
  `code` varchar(500) DEFAULT NULL,
  `details` varchar(500) DEFAULT NULL,
  `name` varchar(500) DEFAULT NULL,
  `owner_user_id` bigint(20) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `agency`
--

INSERT INTO `agency` (`agency_id`, `code`, `details`, `name`, `owner_user_id`) VALUES
(1, 'AGENCY-A', 'Reaching desitnations with ease', 'Green Mile Agency', 1);

-- --------------------------------------------------------

--
-- Table structure for table `bus`
--

CREATE TABLE `bus` (
  `bus_id` bigint(20) UNSIGNED NOT NULL,
  `capacity` int(20) NOT NULL,
  `code` varchar(500) DEFAULT NULL,
  `make` varchar(500) DEFAULT NULL,
  `agency_id` bigint(20) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bus`
--

INSERT INTO `bus` (`bus_id`, `capacity`, `code`, `make`, `agency_id`) VALUES
(1, 60, 'AGENCY-A-1', NULL, 1);

-- --------------------------------------------------------

--
-- Table structure for table `flyway_schema_history`
--

CREATE TABLE `flyway_schema_history` (
  `installed_rank` int(11) NOT NULL,
  `version` varchar(50) DEFAULT NULL,
  `description` varchar(200) NOT NULL,
  `type` varchar(20) NOT NULL,
  `script` varchar(1000) NOT NULL,
  `checksum` int(11) DEFAULT NULL,
  `installed_by` varchar(100) NOT NULL,
  `installed_on` timestamp NOT NULL DEFAULT current_timestamp(),
  `execution_time` int(11) NOT NULL,
  `success` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `flyway_schema_history`
--

INSERT INTO `flyway_schema_history` (`installed_rank`, `version`, `description`, `type`, `script`, `checksum`, `installed_by`, `installed_on`, `execution_time`, `success`) VALUES
(1, '1.0', '20221012-create-table', 'SQL', 'V1.0__20221012-create-table.sql', 194906324, 'admin', '2022-10-18 10:06:37', 45, 1),
(2, '1.1', '20221012-populate-table', 'SQL', 'V1.1__20221012-populate-table.sql', 210364670, 'admin', '2022-10-18 10:06:37', 22, 1);

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `role_id` bigint(20) UNSIGNED NOT NULL,
  `role` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`role_id`, `role`) VALUES
(1, 'ADMIN'),
(2, 'PASSENGER');

-- --------------------------------------------------------

--
-- Table structure for table `stop`
--

CREATE TABLE `stop` (
  `stop_id` bigint(20) UNSIGNED NOT NULL,
  `code` varchar(500) DEFAULT NULL,
  `detail` varchar(500) DEFAULT NULL,
  `name` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `stop`
--

INSERT INTO `stop` (`stop_id`, `code`, `detail`, `name`) VALUES
(1, 'STPA', 'Near hills', 'Stop A'),
(2, 'STPB', 'Near rivers', 'Stop B'),
(3, 'STPC', 'Near desert', 'Stop C'),
(4, 'STPD', 'Near lake', 'Stop D');

-- --------------------------------------------------------

--
-- Table structure for table `ticket`
--

CREATE TABLE `ticket` (
  `ticket_id` bigint(20) UNSIGNED NOT NULL,
  `cancellable` bit(1) DEFAULT NULL,
  `journey_date` varchar(500) DEFAULT NULL,
  `seat_number` int(20) DEFAULT NULL,
  `user_id` bigint(20) UNSIGNED DEFAULT NULL,
  `trip_schedule_id` bigint(20) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ticket`
--

INSERT INTO `ticket` (`ticket_id`, `cancellable`, `journey_date`, `seat_number`, `user_id`, `trip_schedule_id`) VALUES
(1, b'0', '2022-10-16', 1, 1, 1),
(2, b'0', '2022-10-16', 2, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `trip`
--

CREATE TABLE `trip` (
  `trip_id` bigint(20) UNSIGNED NOT NULL,
  `fare` int(20) NOT NULL,
  `journey_time` int(20) DEFAULT NULL,
  `agency_id` bigint(20) UNSIGNED DEFAULT NULL,
  `bus_id` bigint(20) UNSIGNED DEFAULT NULL,
  `dest_stop_id` bigint(20) UNSIGNED DEFAULT NULL,
  `source_stop_id` bigint(20) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `trip`
--

INSERT INTO `trip` (`trip_id`, `fare`, `journey_time`, `agency_id`, `bus_id`, `dest_stop_id`, `source_stop_id`) VALUES
(1, 100, 60, 1, 1, 2, 1),
(2, 2, 40, 1, 1, 1, 2);

-- --------------------------------------------------------

--
-- Table structure for table `trip_schedule`
--

CREATE TABLE `trip_schedule` (
  `trip_schedule_id` bigint(20) UNSIGNED NOT NULL,
  `available_seats` int(20) DEFAULT NULL,
  `trip_date` varchar(500) DEFAULT NULL,
  `trip_id` bigint(20) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `trip_schedule`
--

INSERT INTO `trip_schedule` (`trip_schedule_id`, `available_seats`, `trip_date`, `trip_id`) VALUES
(1, 58, '2022-10-16', 1);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` bigint(20) UNSIGNED NOT NULL,
  `email` varchar(500) DEFAULT NULL,
  `first_name` varchar(500) DEFAULT NULL,
  `last_name` varchar(500) DEFAULT NULL,
  `mobile_number` varchar(500) DEFAULT NULL,
  `password` varchar(500) DEFAULT NULL,
  `role_id` bigint(20) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `email`, `first_name`, `last_name`, `mobile_number`, `password`, `role_id`) VALUES
(1, 'admin@gmail.com', 'John', 'Doe', '9425094250', '$2a$10$7PtcjEnWb/ZkgyXyxY1/Iei2dGgGQUbqIIll/dt.qJ8l8nQBWMbYO', 1),
(2, 'passenger@gmail.com', 'Akri', 'Daus', '0124432', '$2a$10$7PtcjEnWb/ZkgyXyxY1/Iei2dGgGQUbqIIll/dt.qJ8l8nQBWMbYO', 2),
(3, 'admin', 'admin', '', '82022', '$2a$12$af4SnLhLIBlgS3sBAkTcUO7dlqnWXJpvZliiifXOh5DE5ky9v8UbC', 1),
(4, 'fachry@gmail.com', 'Fachry', 'Firdaus', '09283674', '$2a$10$l401/7.vBvgQX2ZbeRxma.yUurIHMbnkRpLmPVw0ME/tXglXFAwUK', 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `agency`
--
ALTER TABLE `agency`
  ADD PRIMARY KEY (`agency_id`),
  ADD KEY `owner_user_id` (`owner_user_id`),
  ADD KEY `idx_agency_code` (`code`);

--
-- Indexes for table `bus`
--
ALTER TABLE `bus`
  ADD PRIMARY KEY (`bus_id`),
  ADD KEY `agency_id` (`agency_id`),
  ADD KEY `idx_bus_code` (`code`);

--
-- Indexes for table `flyway_schema_history`
--
ALTER TABLE `flyway_schema_history`
  ADD PRIMARY KEY (`installed_rank`),
  ADD KEY `flyway_schema_history_s_idx` (`success`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`role_id`);

--
-- Indexes for table `stop`
--
ALTER TABLE `stop`
  ADD PRIMARY KEY (`stop_id`),
  ADD KEY `idx_stop_code` (`code`);

--
-- Indexes for table `ticket`
--
ALTER TABLE `ticket`
  ADD PRIMARY KEY (`ticket_id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `trip_schedule_id` (`trip_schedule_id`);

--
-- Indexes for table `trip`
--
ALTER TABLE `trip`
  ADD PRIMARY KEY (`trip_id`),
  ADD KEY `agency_id` (`agency_id`),
  ADD KEY `bus_id` (`bus_id`),
  ADD KEY `dest_stop_id` (`dest_stop_id`),
  ADD KEY `source_stop_id` (`source_stop_id`);

--
-- Indexes for table `trip_schedule`
--
ALTER TABLE `trip_schedule`
  ADD PRIMARY KEY (`trip_schedule_id`),
  ADD KEY `trip_id` (`trip_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`),
  ADD KEY `role_id` (`role_id`),
  ADD KEY `idx_user_email` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `agency`
--
ALTER TABLE `agency`
  MODIFY `agency_id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `bus`
--
ALTER TABLE `bus`
  MODIFY `bus_id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `role_id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `stop`
--
ALTER TABLE `stop`
  MODIFY `stop_id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `ticket`
--
ALTER TABLE `ticket`
  MODIFY `ticket_id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `trip`
--
ALTER TABLE `trip`
  MODIFY `trip_id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `trip_schedule`
--
ALTER TABLE `trip_schedule`
  MODIFY `trip_schedule_id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `agency`
--
ALTER TABLE `agency`
  ADD CONSTRAINT `agency_ibfk_1` FOREIGN KEY (`owner_user_id`) REFERENCES `user` (`user_id`);

--
-- Constraints for table `bus`
--
ALTER TABLE `bus`
  ADD CONSTRAINT `bus_ibfk_1` FOREIGN KEY (`agency_id`) REFERENCES `agency` (`agency_id`);

--
-- Constraints for table `ticket`
--
ALTER TABLE `ticket`
  ADD CONSTRAINT `ticket_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  ADD CONSTRAINT `ticket_ibfk_2` FOREIGN KEY (`trip_schedule_id`) REFERENCES `trip_schedule` (`trip_schedule_id`);

--
-- Constraints for table `trip`
--
ALTER TABLE `trip`
  ADD CONSTRAINT `trip_ibfk_1` FOREIGN KEY (`agency_id`) REFERENCES `agency` (`agency_id`),
  ADD CONSTRAINT `trip_ibfk_2` FOREIGN KEY (`bus_id`) REFERENCES `bus` (`bus_id`),
  ADD CONSTRAINT `trip_ibfk_3` FOREIGN KEY (`dest_stop_id`) REFERENCES `stop` (`stop_id`),
  ADD CONSTRAINT `trip_ibfk_4` FOREIGN KEY (`source_stop_id`) REFERENCES `stop` (`stop_id`);

--
-- Constraints for table `trip_schedule`
--
ALTER TABLE `trip_schedule`
  ADD CONSTRAINT `trip_schedule_ibfk_1` FOREIGN KEY (`trip_id`) REFERENCES `trip` (`trip_id`);

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `user_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
