-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th3 13, 2024 lúc 06:29 PM
-- Phiên bản máy phục vụ: 10.4.32-MariaDB
-- Phiên bản PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `fashion-shop`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `product_detail`
--

CREATE TABLE `product_detail` (
  `id` bigint(20) NOT NULL,
  `color` varchar(255) DEFAULT NULL,
  `quantity` int(11) NOT NULL,
  `size` varchar(255) DEFAULT NULL,
  `unit` varchar(255) DEFAULT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  `sold` int(11) NOT NULL,
  `image_link` varchar(255) DEFAULT NULL,
  `color_image` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `product_detail`
--

  INSERT INTO `product_detail` (`id`, `color`, `quantity`, `size`, `unit`, `product_id`, `sold`, `image_link`, `color_image`) VALUES
  (1, 'Xám', 100, 'M', NULL, 6, 30, 'https://mcdn2.coolmate.me/cdn-cgi/image/format=auto/uploads/October2023/QD001.20_38.jpg', 'https://media2.coolmate.me/cdn-cgi/image/width=160,height=160,quality=80,format=auto/uploads/October2023/2-5a23_79.jpg'),
  (2, 'Xanh Navy', 50, 'L', NULL, 6, 20, 'https://mcdn2.coolmate.me/cdn-cgi/image/format=auto/uploads/October2023/QD001.9_84.jpg', 'https://media2.coolmate.me/cdn-cgi/image/width=160,height=160,quality=80,format=auto/uploads/October2023/mau-xanh-navy_38.jpg'),
  (4, 'Đen', 20, 'M', NULL, 6, 5, 'https://mcdn2.coolmate.me/cdn-cgi/image/format=auto/uploads/October2023/QD001.15_46.jpg', 'https://media2.coolmate.me/cdn-cgi/image/width=160,height=160,quality=80,format=auto/uploads/October2023/mau-xanh-navy_38.jpg'),
  (5, 'Xám', 75, 'XL', NULL, 6, 34, 'https://mcdn2.coolmate.me/cdn-cgi/image/format=auto/uploads/October2023/QD001.20_38.jpg', 'https://media2.coolmate.me/cdn-cgi/image/width=160,height=160,quality=80,format=auto/uploads/October2023/2-5a23_79.jpg'),
  (6, 'Xám', 60, '2XL', NULL, 6, 23, 'https://mcdn2.coolmate.me/cdn-cgi/image/format=auto/uploads/October2023/QD001.20_38.jpg', 'https://media2.coolmate.me/cdn-cgi/image/width=160,height=160,quality=80,format=auto/uploads/October2023/2-5a23_79.jpg'),
  (7, 'Xanh Navy', 16, '3XL', NULL, 6, 5, 'https://mcdn2.coolmate.me/cdn-cgi/image/format=auto/uploads/October2023/QD001.9_84.jpg', 'https://media2.coolmate.me/cdn-cgi/image/width=160,height=160,quality=80,format=auto/uploads/October2023/mau-xanh-navy_38.jpg');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `product_detail`
--
ALTER TABLE `product_detail`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKilxoi77ctyin6jn9robktb16c` (`product_id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `product_detail`
--
ALTER TABLE `product_detail`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `product_detail`
--
ALTER TABLE `product_detail`
  ADD CONSTRAINT `FKilxoi77ctyin6jn9robktb16c` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
