-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th1 29, 2024 lúc 12:32 PM
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
-- Cơ sở dữ liệu: `fashion-shop`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `product`
--

CREATE TABLE `product` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `imagedata_id` bigint(20) DEFAULT NULL,
  `type` enum('SHIRTS','PANTS','DRESSES','SHOES','JACKETS','ACCESSORIES','SWEATERS','JEANS','SHORTS','SKIRTS','BLOUSES','T_SHIRTS','ACTIVEWEAR','SOCKS','SCARVES','SUNGLASSES','WATCHES','HATS_CAPS','BELTS','GLOVES','WALLETS','PERFUMES','MAKEUP_COSMETICS','HAIR_ACCESSORIES','BACKPACKS','FORMAL_WEAR','JEWELRY','OTHER') DEFAULT NULL,
  `material` enum('COTTON','CANVAS','FABRIC','LEATHER','SILK','DENIM','WOOL','POLYESTER','NYLON','LINEN','VELVET','CHIFFON','SPANDEX','LACE','SYNTHETIC','OTHER','GOLD','SILVER','COPPER') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `product`
--

INSERT INTO `product` (`id`, `name`, `price`, `imagedata_id`, `type`, `material`) VALUES
(2, 'Adidas Running Shoes', 1500000.00, NULL, 'SHOES', 'SYNTHETIC'),
(3, 'Nike Dri-FIT T-Shirt', 500000.00, NULL, 'T_SHIRTS', 'SYNTHETIC'),
(4, 'Calvin Klein Leather Wallet', 800000.00, NULL, 'WALLETS', 'LEATHER'),
(5, 'Gucci Velvet Scarf', 1200000.00, NULL, 'SCARVES', 'VELVET'),
(6, 'Tommy Hilfiger Denim Jeans', 1200000.00, NULL, 'JEANS', 'DENIM'),
(7, 'Louis Vuitton Leather Backpack', 3000000.00, NULL, 'BACKPACKS', 'LEATHER'),
(8, 'Chanel Lace Blouse', 1800000.00, NULL, 'BLOUSES', 'LACE'),
(9, 'Versace Gold Jewelry Set', 2500000.00, NULL, 'JEWELRY', 'OTHER'),
(10, 'Prada Silk Scarf', 1500000.00, NULL, 'SCARVES', 'SILK'),
(11, 'Fendi Velvet Hat', 800000.00, NULL, 'HATS_CAPS', 'VELVET'),
(12, 'Burberry Wool Sweater', 2000000.00, NULL, 'SWEATERS', 'WOOL'),
(13, 'Puma Active Leggings', 600000.00, NULL, 'ACTIVEWEAR', 'SPANDEX'),
(14, 'Rolex Gold Watch', 8000000.00, NULL, 'WATCHES', 'GOLD'),
(15, 'Dior Chiffon Dress', 3500000.00, NULL, 'DRESSES', 'CHIFFON'),
(16, 'Givenchy Velvet Gloves', 1200000.00, NULL, 'GLOVES', 'VELVET'),
(17, 'Yves Saint Laurent Leather Belt', 900000.00, NULL, 'BELTS', 'LEATHER'),
(18, 'Hermès Linen Blouse', 1600000.00, NULL, 'BLOUSES', 'LINEN'),
(19, 'Chloe Denim Skirt', 1200000.00, NULL, 'SKIRTS', 'DENIM'),
(20, 'Jimmy Choo Silk Heels', 3000000.00, NULL, 'SHOES', 'SILK'),
(21, 'Balenciaga Nylon Backpack', 1800000.00, NULL, 'BACKPACKS', 'NYLON'),
(22, 'Marc Jacobs Perfume Set', 2500000.00, NULL, 'PERFUMES', 'OTHER'),
(23, 'Giorgio Armani Makeup Kit', 1800000.00, NULL, 'MAKEUP_COSMETICS', 'OTHER'),
(24, 'Alexander McQueen Velvet Scarf', 900000.00, NULL, 'SCARVES', 'VELVET'),
(25, 'Dolce & Gabbana Leather Formal Shoes', 3500000.00, NULL, 'SHOES', 'LEATHER'),
(26, 'Christian Louboutin Red Bottom Heels', 3000000.00, NULL, 'SHOES', 'LEATHER'),
(27, 'Vans Canvas Belt', 700000.00, NULL, 'BELTS', 'CANVAS'),
(28, 'Ralph Lauren Lace Dress', 2000000.00, NULL, 'DRESSES', 'LACE'),
(29, 'Ferragamo Leather Formal Shoes', 3500000.00, NULL, 'SHOES', 'LEATHER'),
(30, 'Burberry Wool Hat', 800000.00, NULL, 'HATS_CAPS', 'WOOL'),
(31, 'Prada Velvet Gloves', 1200000.00, NULL, 'GLOVES', 'VELVET'),
(32, 'Chanel Linen Blouse', 1600000.00, NULL, 'BLOUSES', 'LINEN'),
(33, 'Yves Saint Laurent Denim Skirt', 1200000.00, NULL, 'SKIRTS', 'DENIM'),
(34, 'Louis Vuitton Velvet Scarf', 900000.00, NULL, 'SCARVES', 'VELVET');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK6d8deakb8jl5h2ola2043itpe` (`imagedata_id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `product`
--
ALTER TABLE `product`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `FK6d8deakb8jl5h2ola2043itpe` FOREIGN KEY (`imagedata_id`) REFERENCES `image_data` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
