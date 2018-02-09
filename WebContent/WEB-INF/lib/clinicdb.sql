-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 08, 2018 at 09:59 PM
-- Server version: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `clinicdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbladmin`
--

CREATE TABLE `tbladmin` (
  `AdminID` int(11) NOT NULL,
  `NameAndSurname` varchar(50) NOT NULL,
  `UserName` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbladmin`
--

INSERT INTO `tbladmin` (`AdminID`, `NameAndSurname`, `UserName`, `Password`) VALUES
(1, 'Zika Zikic', 'Zika', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `tbldateofscheduling`
--

CREATE TABLE `tbldateofscheduling` (
  `DateOfSchedulingID` int(11) NOT NULL,
  `DateOfScheduling` datetime NOT NULL,
  `Scheduled` tinyint(1) NOT NULL,
  `MedicalDepartmentID` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbldateofscheduling`
--

INSERT INTO `tbldateofscheduling` (`DateOfSchedulingID`, `DateOfScheduling`, `Scheduled`, `MedicalDepartmentID`) VALUES
(1, '2018-02-05 08:00:00', 1, 1),
(2, '2018-02-06 08:00:00', 0, 1),
(3, '2018-02-07 08:00:00', 1, 2),
(4, '2018-02-08 08:00:00', 0, 2),
(5, '2018-02-05 09:00:00', 1, 1),
(6, '2018-02-05 10:00:00', 0, 1),
(7, '2018-02-05 11:00:00', 0, 1),
(8, '2018-02-05 12:00:00', 0, 1),
(9, '2018-02-05 13:00:00', 0, 1),
(10, '2018-02-05 14:00:00', 0, 1),
(11, '2018-02-05 15:00:00', 0, 1),
(12, '2018-02-07 09:00:00', 0, 2),
(13, '2018-02-07 10:00:00', 1, 2),
(14, '2018-02-07 11:00:00', 0, 2),
(15, '2018-02-07 12:00:00', 0, 2),
(16, '2018-02-07 13:00:00', 0, 2),
(17, '2018-02-07 14:00:00', 0, 2),
(18, '2018-02-07 15:00:00', 0, 2);

-- --------------------------------------------------------

--
-- Table structure for table `tbldoctorappointments`
--

CREATE TABLE `tbldoctorappointments` (
  `DoctorAppointmentID` int(11) NOT NULL,
  `UserID` int(11) NOT NULL,
  `MedicalStaffID` int(11) NOT NULL,
  `DateOfSchedulingID` int(11) NOT NULL,
  `Examined` tinyint(1) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbldoctorappointments`
--

INSERT INTO `tbldoctorappointments` (`DoctorAppointmentID`, `UserID`, `MedicalStaffID`, `DateOfSchedulingID`, `Examined`) VALUES
(1, 4, 2, 1, 0),
(2, 5, 2, 5, 0),
(3, 6, 4, 3, 0),
(4, 4, 3, 13, 0);

-- --------------------------------------------------------

--
-- Table structure for table `tbllogin`
--

CREATE TABLE `tbllogin` (
  `LoginID` int(11) NOT NULL,
  `LoginDateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `UserID` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbllogin`
--

INSERT INTO `tbllogin` (`LoginID`, `LoginDateTime`, `UserID`) VALUES
(1, '2018-02-01 19:57:26', 4),
(2, '2018-02-01 19:57:36', 5),
(3, '2018-02-01 19:57:44', 6),
(4, '2018-02-01 19:58:56', 1),
(5, '2018-02-01 19:59:05', 2),
(6, '2018-02-01 19:59:12', 3),
(7, '2018-02-03 12:20:54', 4),
(8, '2018-02-03 20:32:30', 4),
(9, '2018-02-03 20:32:56', 1),
(10, '2018-02-04 17:49:42', 11),
(11, '2018-02-04 18:40:41', 12),
(12, '2018-02-04 18:42:58', 11),
(13, '2018-02-04 18:44:35', 13),
(14, '2018-02-04 18:46:27', 1),
(15, '2018-02-04 18:46:44', 5),
(16, '2018-02-04 18:47:31', 12),
(17, '2018-02-04 19:07:49', 4),
(18, '2018-02-04 19:14:24', 4),
(19, '2018-02-04 19:14:51', 4),
(20, '2018-02-04 22:11:17', 4),
(21, '2018-02-04 22:47:38', 4),
(22, '2018-02-05 11:51:50', 4),
(23, '2018-02-05 11:54:15', 4),
(24, '2018-02-05 11:57:58', 5),
(25, '2018-02-05 12:01:35', 5),
(26, '2018-02-05 17:22:09', 4),
(27, '2018-02-05 17:31:57', 4),
(28, '2018-02-05 17:52:53', 4),
(29, '2018-02-05 17:56:47', 5),
(30, '2018-02-05 18:30:26', 4),
(31, '2018-02-05 18:51:22', 4),
(32, '2018-02-05 18:56:38', 5),
(33, '2018-02-05 19:01:41', 4),
(34, '2018-02-05 19:04:13', 4),
(35, '2018-02-06 12:44:46', 6),
(36, '2018-02-06 12:45:51', 6),
(37, '2018-02-06 13:01:32', 5),
(38, '2018-02-06 13:12:39', 6),
(39, '2018-02-06 13:13:00', 4),
(40, '2018-02-06 14:18:57', 4),
(41, '2018-02-06 14:37:33', 4),
(42, '2018-02-06 14:46:57', 4),
(43, '2018-02-06 14:52:12', 4),
(44, '2018-02-06 14:53:46', 4),
(45, '2018-02-06 14:56:56', 4),
(46, '2018-02-06 14:58:51', 4),
(47, '2018-02-06 15:01:00', 4),
(48, '2018-02-06 15:05:08', 4),
(49, '2018-02-06 15:06:49', 4),
(50, '2018-02-06 15:24:03', 4),
(51, '2018-02-06 15:28:43', 4),
(52, '2018-02-06 15:30:00', 4),
(53, '2018-02-06 15:30:39', 4),
(54, '2018-02-06 15:33:18', 4),
(55, '2018-02-06 15:34:43', 4),
(56, '2018-02-06 15:45:14', 4),
(57, '2018-02-06 15:51:15', 4),
(58, '2018-02-06 15:58:04', 4),
(59, '2018-02-06 16:05:41', 4),
(60, '2018-02-06 16:11:05', 4),
(61, '2018-02-06 16:11:50', 4),
(62, '2018-02-06 16:12:27', 4),
(63, '2018-02-06 16:14:48', 4),
(64, '2018-02-06 16:18:10', 4),
(65, '2018-02-06 16:21:12', 4),
(66, '2018-02-06 16:22:31', 4),
(67, '2018-02-06 16:24:53', 4),
(68, '2018-02-06 18:26:49', 4),
(69, '2018-02-06 18:32:12', 4),
(70, '2018-02-06 18:58:37', 4),
(71, '2018-02-06 18:59:11', 4),
(72, '2018-02-06 18:59:54', 4),
(73, '2018-02-06 19:01:12', 4),
(74, '2018-02-06 19:02:03', 4),
(75, '2018-02-06 19:11:23', 4),
(76, '2018-02-06 19:12:06', 4),
(77, '2018-02-06 19:23:38', 4),
(78, '2018-02-06 19:26:11', 4),
(79, '2018-02-06 19:31:47', 4),
(80, '2018-02-06 19:35:38', 4),
(81, '2018-02-06 19:36:54', 4),
(82, '2018-02-06 19:37:42', 4),
(83, '2018-02-06 19:38:20', 4),
(84, '2018-02-06 19:38:50', 4),
(85, '2018-02-06 19:41:52', 4),
(86, '2018-02-06 19:49:15', 4),
(87, '2018-02-06 19:50:24', 4),
(88, '2018-02-06 19:51:22', 4),
(89, '2018-02-06 19:52:09', 4),
(90, '2018-02-06 19:53:26', 4),
(91, '2018-02-06 19:54:14', 4),
(92, '2018-02-06 19:55:49', 4),
(93, '2018-02-06 20:04:49', 4),
(94, '2018-02-06 20:10:06', 4),
(95, '2018-02-06 20:13:28', 4),
(96, '2018-02-06 20:14:46', 4),
(97, '2018-02-06 20:15:52', 4),
(98, '2018-02-06 20:23:50', 4),
(99, '2018-02-06 20:25:08', 4),
(100, '2018-02-06 20:27:38', 4),
(101, '2018-02-06 20:32:51', 4),
(102, '2018-02-06 20:34:13', 4),
(103, '2018-02-06 20:35:58', 4),
(104, '2018-02-06 20:36:30', 4),
(105, '2018-02-06 21:06:37', 4),
(106, '2018-02-06 21:08:09', 5),
(107, '2018-02-06 21:09:25', 5),
(108, '2018-02-07 07:52:51', 6),
(109, '2018-02-07 07:54:36', 5),
(110, '2018-02-07 07:58:31', 4),
(111, '2018-02-07 10:34:27', 4),
(112, '2018-02-07 10:38:04', 5),
(113, '2018-02-07 10:38:48', 6),
(114, '2018-02-07 11:42:12', 4),
(115, '2018-02-07 11:43:38', 5),
(116, '2018-02-07 11:44:14', 6),
(117, '2018-02-07 11:45:37', 4),
(118, '2018-02-07 14:32:44', 14),
(119, '2018-02-07 14:33:22', 1),
(120, '2018-02-07 16:39:48', 2),
(121, '2018-02-07 16:44:22', 2),
(122, '2018-02-07 16:49:06', 2),
(123, '2018-02-07 16:57:47', 11),
(124, '2018-02-07 16:58:37', 1),
(125, '2018-02-07 16:59:15', 11),
(126, '2018-02-07 18:35:48', 11),
(127, '2018-02-07 18:48:46', 11),
(128, '2018-02-07 18:49:34', 11),
(129, '2018-02-07 19:41:49', 11),
(130, '2018-02-07 19:52:33', 11),
(131, '2018-02-07 21:06:59', 11),
(132, '2018-02-07 21:20:14', 11),
(133, '2018-02-07 21:46:18', 11),
(134, '2018-02-07 21:46:54', 11),
(135, '2018-02-07 21:53:16', 11),
(136, '2018-02-07 21:53:43', 11),
(137, '2018-02-07 21:58:03', 11),
(138, '2018-02-07 22:00:15', 11),
(139, '2018-02-07 22:17:22', 11),
(140, '2018-02-07 22:18:22', 11),
(141, '2018-02-07 22:20:48', 11),
(142, '2018-02-08 08:12:42', 11),
(143, '2018-02-08 08:16:05', 11),
(144, '2018-02-08 08:26:08', 11),
(145, '2018-02-08 15:51:39', 11),
(146, '2018-02-08 16:02:09', 11),
(147, '2018-02-08 16:07:41', 11),
(148, '2018-02-08 16:09:07', 11),
(149, '2018-02-08 16:16:07', 11),
(150, '2018-02-08 16:18:21', 11),
(151, '2018-02-08 16:21:25', 11),
(152, '2018-02-08 16:25:48', 11),
(153, '2018-02-08 16:33:14', 11),
(154, '2018-02-08 17:25:12', 11),
(155, '2018-02-08 17:31:05', 11),
(156, '2018-02-08 17:39:14', 11),
(157, '2018-02-08 17:57:23', 11),
(158, '2018-02-08 18:24:24', 11);

-- --------------------------------------------------------

--
-- Table structure for table `tblmanufacturers`
--

CREATE TABLE `tblmanufacturers` (
  `ManufacturerID` int(11) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Address` varchar(50) NOT NULL,
  `ContactPhone` varchar(50) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Note` varchar(50) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tblmanufacturers`
--

INSERT INTO `tblmanufacturers` (`ManufacturerID`, `Name`, `Address`, `ContactPhone`, `Email`, `Note`) VALUES
(1, 'Galenika a.d. Beograd', 'Batajnicki drum bb, Beograd-Zemun', '011/307-1000', 'kabinet@galenika.rs', 'Akcionarsko drustvo'),
(2, 'Hemofarm a.d.', 'Beogradski put bb, 26300 Vrsac', '013/803-100', 'svakodobro@hemofarm.com', 'Akcionarsko drustvo');

-- --------------------------------------------------------

--
-- Table structure for table `tblmedicaldepartments`
--

CREATE TABLE `tblmedicaldepartments` (
  `MedicalDepartmentID` int(11) NOT NULL,
  `NameOfDepartment` varchar(50) NOT NULL,
  `ContactPhone` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tblmedicaldepartments`
--

INSERT INTO `tblmedicaldepartments` (`MedicalDepartmentID`, `NameOfDepartment`, `ContactPhone`) VALUES
(1, 'Clinic for Physical Medicine and Rehabilitation', '011/360-89-23'),
(2, 'Clinic for skin and sexually transmitted diseases', '011/360-85-59'),
(3, 'Clinic for Pulmonology', '011/360-92-49'),
(4, 'Clinic for Infectious and Tropical Diseases', '011/360-92-82'),
(5, 'Clinic for Gastroenterology and Hepatology', '011/360-83-02'),
(6, 'Clinic for Endocrinology', '011/360-86-97'),
(7, 'Clinic for Hematology', '011/360-86-38'),
(8, 'Clinic for Emergency Internal medicine', '011/360-81-35'),
(9, 'Clinic for Nephrology', '011/360-91-89'),
(10, 'Clinic for Rheumatology', '011/360-85-69'),
(11, 'Clinic for Cardiology', '011/360-88-17');

-- --------------------------------------------------------

--
-- Table structure for table `tblmedicalstaffs`
--

CREATE TABLE `tblmedicalstaffs` (
  `MedicalStaffID` int(11) NOT NULL,
  `UserID` int(11) NOT NULL,
  `MedicalDepartmentID` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tblmedicalstaffs`
--

INSERT INTO `tblmedicalstaffs` (`MedicalStaffID`, `UserID`, `MedicalDepartmentID`) VALUES
(2, 11, 1),
(3, 13, 2),
(1, 1, 1),
(4, 2, 2),
(5, 3, 4),
(6, 14, 1);

-- --------------------------------------------------------

--
-- Table structure for table `tblpharmacy`
--

CREATE TABLE `tblpharmacy` (
  `PharmacyID` int(11) NOT NULL,
  `NameOfTheDrug` varchar(50) NOT NULL,
  `ScopeOfApplication` varchar(50) NOT NULL,
  `QuantityOnCondition` int(11) NOT NULL,
  `Note` varchar(50) NOT NULL,
  `ManufacturerID` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tblpharmacy`
--

INSERT INTO `tblpharmacy` (`PharmacyID`, `NameOfTheDrug`, `ScopeOfApplication`, `QuantityOnCondition`, `Note`, `ManufacturerID`) VALUES
(1, 'Daktanol', 'Lekovi za lecenje digestivnog sistema', 99, 'oralni gel 2% 40g', 1),
(2, 'Cornilat', 'Lekovi koji deluju na kardiovaskularni sistem', 100, 'tableta 20x20mg', 1),
(3, 'Alopurinol', 'Bolesti mišicno koštanog i vezivnog tkiva', 95, 'tableta 40x100mg', 2),
(4, 'Altravesa', 'Maligne bolesti i tumori', 100, 'tableta 28x1mg', 2);

-- --------------------------------------------------------

--
-- Table structure for table `tbltakemedications`
--

CREATE TABLE `tbltakemedications` (
  `TakeMedicationID` int(11) NOT NULL,
  `DateOfTaking` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `UserID` int(11) NOT NULL,
  `MedicalStaffID` int(11) NOT NULL,
  `PharmacyID` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbltakemedications`
--

INSERT INTO `tbltakemedications` (`TakeMedicationID`, `DateOfTaking`, `UserID`, `MedicalStaffID`, `PharmacyID`) VALUES
(1, '2018-02-08 16:29:18', 4, 2, 1),
(2, '2018-02-08 16:33:38', 5, 2, 2),
(3, '2018-02-08 17:40:14', 4, 2, 4),
(4, '2018-02-08 17:57:36', 5, 2, 3),
(5, '2018-02-08 18:24:37', 4, 2, 1),
(6, '2018-02-08 18:31:04', 5, 2, 3);

-- --------------------------------------------------------

--
-- Table structure for table `tblusers`
--

CREATE TABLE `tblusers` (
  `UserID` int(11) NOT NULL,
  `UserName` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL,
  `NameAndSurname` varchar(50) NOT NULL,
  `Address` varchar(50) NOT NULL,
  `PhoneNumber` varchar(50) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `NumberOfIdCard` varchar(50) NOT NULL,
  `BloodType` varchar(10) NOT NULL,
  `Sex` varchar(10) NOT NULL,
  `NameOfJob` varchar(20) DEFAULT NULL,
  `TypeOfUsers` varchar(10) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tblusers`
--

INSERT INTO `tblusers` (`UserID`, `UserName`, `Password`, `NameAndSurname`, `Address`, `PhoneNumber`, `Email`, `NumberOfIdCard`, `BloodType`, `Sex`, `NameOfJob`, `TypeOfUsers`) VALUES
(1, 'Medic1', '123', 'Pera Peric', 'Address1', '324345', 'medic1@gmail.com', '12345', 'A+', 'male', 'doctor', 'medic'),
(2, 'Medic2', '123', 'Mika Mikic', 'Address2', '324345', 'medic2@gmail.com', '65834', 'A+', 'male', 'doctor', 'medic'),
(3, 'Medic3', '123', 'Zika', 'Address3', '555555', 'medic3@gmail.com', '83902', 'A-', 'male', 'doctor', 'medic'),
(4, 'Patient1', '123', 'Name1 Surname1', 'Address1', '555555', 'patient1@gmail.com', '59265', 'A+', 'male', NULL, 'patient'),
(5, 'Patient2', '123', 'Name2 Surname2', 'Address2', '123123', 'patient2@gmail.com', '76345', 'A+', 'female', NULL, 'patient'),
(6, 'Patient3', '123', 'Name3 Surname3', 'Address3', '123123', 'patient3@gmail.com', '12345', 'O-', 'female', '', 'patient'),
(11, 'Medic4', '123', 'Doktor Rivijera', 'Address1', '324345', 'drrivijera@gmail.com', '12345', 'A+', 'male', 'doctor', 'medic'),
(12, 'Patient4', '123', 'Name4 Surname4', 'Address4', '555555', 'patient4@gmail.com', '12345', 'A+', 'female', NULL, 'patient'),
(13, 'Medic5', '123', 'Jagodinka Simonovic', 'Varljivo Leto 68', '123123', 'jagodinka@gmail.com', '12345', 'AB+', 'female', 'doctor', 'medic'),
(14, 'Dakota', '123', 'Dakota Johnson', 'Address1', '123-123', 'dakota@gmail.com', '12345', 'B+', 'female', 'nurse', 'medic');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbladmin`
--
ALTER TABLE `tbladmin`
  ADD PRIMARY KEY (`AdminID`);

--
-- Indexes for table `tbldateofscheduling`
--
ALTER TABLE `tbldateofscheduling`
  ADD PRIMARY KEY (`DateOfSchedulingID`),
  ADD KEY `MedicalDepartmentID` (`MedicalDepartmentID`);

--
-- Indexes for table `tbldoctorappointments`
--
ALTER TABLE `tbldoctorappointments`
  ADD PRIMARY KEY (`DoctorAppointmentID`),
  ADD KEY `UserID` (`UserID`),
  ADD KEY `MedicalStaffID` (`MedicalStaffID`),
  ADD KEY `DateOfSchedulingID` (`DateOfSchedulingID`);

--
-- Indexes for table `tbllogin`
--
ALTER TABLE `tbllogin`
  ADD PRIMARY KEY (`LoginID`),
  ADD KEY `UserID` (`UserID`);

--
-- Indexes for table `tblmanufacturers`
--
ALTER TABLE `tblmanufacturers`
  ADD PRIMARY KEY (`ManufacturerID`);

--
-- Indexes for table `tblmedicaldepartments`
--
ALTER TABLE `tblmedicaldepartments`
  ADD PRIMARY KEY (`MedicalDepartmentID`);

--
-- Indexes for table `tblmedicalstaffs`
--
ALTER TABLE `tblmedicalstaffs`
  ADD PRIMARY KEY (`MedicalStaffID`),
  ADD KEY `UserID` (`UserID`),
  ADD KEY `MedicalDeparmentID` (`MedicalDepartmentID`);

--
-- Indexes for table `tblpharmacy`
--
ALTER TABLE `tblpharmacy`
  ADD PRIMARY KEY (`PharmacyID`),
  ADD KEY `ManufacturerID` (`ManufacturerID`);

--
-- Indexes for table `tbltakemedications`
--
ALTER TABLE `tbltakemedications`
  ADD PRIMARY KEY (`TakeMedicationID`),
  ADD KEY `UserID` (`UserID`),
  ADD KEY `MedicalStaffID` (`MedicalStaffID`),
  ADD KEY `PharmacyID` (`PharmacyID`);

--
-- Indexes for table `tblusers`
--
ALTER TABLE `tblusers`
  ADD PRIMARY KEY (`UserID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbladmin`
--
ALTER TABLE `tbladmin`
  MODIFY `AdminID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `tbldateofscheduling`
--
ALTER TABLE `tbldateofscheduling`
  MODIFY `DateOfSchedulingID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
--
-- AUTO_INCREMENT for table `tbldoctorappointments`
--
ALTER TABLE `tbldoctorappointments`
  MODIFY `DoctorAppointmentID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `tbllogin`
--
ALTER TABLE `tbllogin`
  MODIFY `LoginID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=159;
--
-- AUTO_INCREMENT for table `tblmanufacturers`
--
ALTER TABLE `tblmanufacturers`
  MODIFY `ManufacturerID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `tblmedicaldepartments`
--
ALTER TABLE `tblmedicaldepartments`
  MODIFY `MedicalDepartmentID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT for table `tblmedicalstaffs`
--
ALTER TABLE `tblmedicalstaffs`
  MODIFY `MedicalStaffID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `tblpharmacy`
--
ALTER TABLE `tblpharmacy`
  MODIFY `PharmacyID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `tbltakemedications`
--
ALTER TABLE `tbltakemedications`
  MODIFY `TakeMedicationID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `tblusers`
--
ALTER TABLE `tblusers`
  MODIFY `UserID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
