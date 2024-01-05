-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th1 05, 2024 lúc 12:47 PM
-- Phiên bản máy phục vụ: 10.4.28-MariaDB
-- Phiên bản PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `user`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `user`
--

INSERT INTO `user` (`id`, `password`, `username`) VALUES
(1, 'P@ssw0rd1', 'johnsmith'),
(2, 'Secure&Safe#2', 'alicejohnson'),
(3, 'SecretP@ssword3!', 'bobbrown'),
(4, 'StrongP@ss4', 'emilydavis'),
(5, 'W1lson#P@ss', 'michaelwilson'),
(6, 'M@rtin4Ever', 'samanthamartin'),
(7, 'W1ll!@mL3e', 'williamlee'),
(8, '0l1v!@#P@ss', 'oliviajohnson'),
(9, 'J@m3sP@ssw0rd', 'jamesbrown'),
(10, 'S0ph!@#P@ss', 'sophialee'),
(11, 'B3nJ@m!n#P@ss', 'benjamindavis'),
(12, 'M!@#W!ls0nP@ss', 'miawilson'),
(13, '3th@nG@rc!@P@ss', 'ethangarcia'),
(14, 'Ch@rl0t#P@ssw0rd', 'charlotteharris'),
(15, 'L!@m&P@ssw0rd', 'liamanderson'),
(16, 'T@yl0rP@ss!@#', 'avataylor'),
(17, 'L#c@sP@ss123', 'lucashernandez'),
(18, 'Y0ung&P@ss!', 'ameliayoung'),
(19, 'M00r3#P@ss', 'henrymoore'),
(20, '3ll@C!@rk#P@ss', 'ellaclark'),
(21, 'P@ssw0rd21', 'gracewilson'),
(22, 'Secure&Safe#22', 'jacobtaylor'),
(23, 'SecretP@ssword23!', 'olivialopez'),
(24, 'StrongP@ss24', 'samuelmartin'),
(25, 'W1lson#P@ss25', 'victoranderson');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `user`
--
ALTER TABLE `user`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=47;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
