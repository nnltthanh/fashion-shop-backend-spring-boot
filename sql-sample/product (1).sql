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
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `imagedata_id` bigint(20) DEFAULT NULL,
  `material` enum('COTTON','CANVAS','FABRIC','GOLD','SILVER','COPPER','LEATHER','SILK','DENIM','WOOL','POLYESTER','NYLON','LINEN','VELVET','CHIFFON','SPANDEX','LACE','SYNTHETIC','OTHER') DEFAULT NULL,
  `type` enum('SHIRTS','PANTS','DRESSES','SHOES','JACKETS','JEWELRY','ACCESSORIES','SWEATERS','JEANS','SHORTS','SKIRTS','BLOUSES','T_SHIRTS','ACTIVEWEAR','SOCKS','SCARVES','SUNGLASSES','WATCHES','HATS_CAPS','BELTS','GLOVES','WALLETS','PERFUMES','MAKEUP_COSMETICS','HAIR_ACCESSORIES','BACKPACKS','FORMAL_WEAR','OTHER') DEFAULT NULL,
  `sale_percent` int(11) DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`id`, `name`, `price`, `imagedata_id`, `material`, `type`, `sale_percent`, `created_at`, `updated_at`) VALUES
(1, 'Áo Thun Nam Chạy Bộ Graphic Photic Zone', 199000.00, 1, 'COTTON', 'T_SHIRTS', 10, '2024-02-24 14:00:02.000000', '2024-02-24 14:00:02.000000'),
(2, 'Áo Singlet Nam Chạy Bộ in Graphic Special', 189000.00, 2, 'COTTON', 'T_SHIRTS', 0, '2024-02-26 21:47:46.000000', '2024-02-26 21:47:46.000000'),
(3, 'Áo Thun Nam Chạy Bộ Graphic Heartbeat', 189000.00, 3, 'COTTON', 'T_SHIRTS', 5, '2024-02-26 21:49:31.000000', '2024-02-26 21:49:31.000000'),
(4, 'Áo Singlet Nam Chạy Bộ Graphic Photic Zone', 189000.00, 4, 'COTTON', 'T_SHIRTS', 0, '2024-02-26 21:51:08.000000', '2024-02-26 21:51:08.000000'),
(5, 'Áo Khoác Nam có mũ Daily Wear', 399000.00, 5, 'COTTON', 'T_SHIRTS', 20, '2024-02-26 21:52:36.000000', '2024-02-26 21:52:36.000000'),
(6, 'Áo Khoác Nam Thể Thao Pro Active', 499000.00, 6, 'COTTON', 'T_SHIRTS', 34, '2024-02-26 21:53:11.000000', '2024-02-26 21:53:11.000000');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK6d8deakb8jl5h2ola2043itpe` (`imagedata_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `FK6d8deakb8jl5h2ola2043itpe` FOREIGN KEY (`imagedata_id`) REFERENCES `image_data` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
