-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 01, 2024 at 08:18 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `fashion-shop`
--

-- --------------------------------------------------------

--
-- Table structure for table `image_data`
--

CREATE TABLE `image_data` (
  `id` bigint(20) NOT NULL,
  `base64string` text DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `image_data`
--

INSERT INTO `image_data` (`id`, `base64string`, `type`) VALUES
(1, 'https://media.coolmate.me/cdn-cgi/image/width=672,height=990,quality=85,format=auto/uploads/January2024/photic3d.4.jpg', 'PRODUCT'),
(2, 'https://media.coolmate.me/cdn-cgi/image/width=672,height=990,quality=85,format=auto/uploads/January2024/23CMAW.TT004.3D.1.jpg', 'PRODUCT'),
(3, 'https://media.coolmate.me/cdn-cgi/image/width=672,height=990,quality=85,format=auto/uploads/January2024/23CMAW.AT003.3D.4.jpg', 'PRODUCT'),
(4, 'https://media.coolmate.me/cdn-cgi/image/width=672,height=990,quality=85,format=auto/uploads/January2024/photic3d.1.jpg', 'PRODUCT'),
(5, 'https://media.coolmate.me/cdn-cgi/image/width=672,height=990,quality=85,format=auto/uploads/October2023/sCM006.thumb1.2.jpg', 'PRODUCT'),
(6, 'https://media.coolmate.me/cdn-cgi/image/width=672,height=990,quality=85,format=auto/uploads/October2023/th2_CMM0218.jpg', 'PRODUCT'),
(7, 'https://media.coolmate.me/cdn-cgi/image/width=672,height=990,quality=85/uploads/February2024/polopromax-s1.26.jpg', 'PRODUCT');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `image_data`
--
ALTER TABLE `image_data`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `image_data`
--
ALTER TABLE `image_data`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
