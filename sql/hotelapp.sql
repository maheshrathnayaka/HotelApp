-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Sep 04, 2016 at 10:23 AM
-- Server version: 5.7.9
-- PHP Version: 5.6.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hotelapp`
--

-- --------------------------------------------------------

--
-- Table structure for table `hotel`
--

DROP TABLE IF EXISTS `hotel`;
CREATE TABLE IF NOT EXISTS `hotel` (
  `HOTEL_ID` varchar(255) NOT NULL,
  `ADDRESS` varchar(255) DEFAULT NULL,
  `NAME` varchar(255) NOT NULL,
  `PHONE_NUMBER` int(11) DEFAULT NULL,
  `STATUS` int(11) DEFAULT NULL,
  `location_LOCATION_ID` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`HOTEL_ID`),
  KEY `FK_8cxnl3nfjdnjk0p56yr05a6w8` (`location_LOCATION_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hotel`
--

INSERT INTO `hotel` (`HOTEL_ID`, `ADDRESS`, `NAME`, `PHONE_NUMBER`, `STATUS`, `location_LOCATION_ID`) VALUES
('H0001', 'Colombo 2', 'Hotel Galadari', 112544567, 1, 'L0002');

-- --------------------------------------------------------

--
-- Table structure for table `location`
--

DROP TABLE IF EXISTS `location`;
CREATE TABLE IF NOT EXISTS `location` (
  `LOCATION_ID` varchar(255) NOT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  `STATUS` int(11) DEFAULT NULL,
  PRIMARY KEY (`LOCATION_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `location`
--

INSERT INTO `location` (`LOCATION_ID`, `NAME`, `STATUS`) VALUES
('L0002', 'Colombo', 1),
('L0001', 'Kurunegala', 1);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
