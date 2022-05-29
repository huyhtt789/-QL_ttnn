-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 29, 2022 lúc 05:09 AM
-- Phiên bản máy phục vụ: 10.4.22-MariaDB
-- Phiên bản PHP: 8.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `ql_ttnn`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chiaphongthi`
--

CREATE TABLE `chiaphongthi` (
  `MATS` varchar(10) COLLATE utf8_vietnamese_ci NOT NULL,
  `MAPT` varchar(10) COLLATE utf8_vietnamese_ci NOT NULL,
  `SBD` varchar(10) COLLATE utf8_vietnamese_ci NOT NULL,
  `NGHE` float DEFAULT NULL,
  `NOI` float DEFAULT NULL,
  `DOC` float DEFAULT NULL,
  `VIET` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `chiaphongthi`
--

INSERT INTO `chiaphongthi` (`MATS`, `MAPT`, `SBD`, `NGHE`, `NOI`, `DOC`, `VIET`) VALUES
('TS_01', '1', 'A2001', 10, 2, 1, 4),
('TS_02', '2', 'A2001', 0, 0, 0, 0),
('TS_03', '2', 'A2002', 0, 0, 0, 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `giamthi`
--

CREATE TABLE `giamthi` (
  `MAGT` varchar(10) COLLATE utf8_vietnamese_ci NOT NULL,
  `HOTEN` varchar(20) COLLATE utf8_vietnamese_ci NOT NULL,
  `CMND` varchar(20) COLLATE utf8_vietnamese_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `giamthi`
--

INSERT INTO `giamthi` (`MAGT`, `HOTEN`, `CMND`) VALUES
('1', 'A', '12345'),
('2', 'B', '235'),
('3', 'C', '334'),
('4', 'D', '2345'),
('5', 'E', '456'),
('6', 'F', '5664');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khoathi`
--

CREATE TABLE `khoathi` (
  `MAKT` varchar(10) COLLATE utf8_vietnamese_ci NOT NULL,
  `TENKT` varchar(20) COLLATE utf8_vietnamese_ci NOT NULL,
  `NGAYTHI` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `khoathi`
--

INSERT INTO `khoathi` (`MAKT`, `TENKT`, `NGAYTHI`) VALUES
('KT01', 'A2P01', '0000-00-00'),
('KT02', 'A2P02', '2022-01-02'),
('KT03', 'A2P03', '2022-01-02'),
('KT04', 'K', '2022-02-01'),
('KT05', 's', '2000-02-01'),
('KT06', 'a', '2022-02-02'),
('KT07', 'c', '2022-10-01');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phongthi`
--

CREATE TABLE `phongthi` (
  `MAPT` varchar(10) COLLATE utf8_vietnamese_ci NOT NULL,
  `TENPT` varchar(10) COLLATE utf8_vietnamese_ci NOT NULL,
  `MAKT` varchar(10) COLLATE utf8_vietnamese_ci NOT NULL,
  `MAGT1` varchar(10) COLLATE utf8_vietnamese_ci NOT NULL,
  `MAGT2` varchar(10) COLLATE utf8_vietnamese_ci NOT NULL,
  `SOTHISINH` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `phongthi`
--

INSERT INTO `phongthi` (`MAPT`, `TENPT`, `MAKT`, `MAGT1`, `MAGT2`, `SOTHISINH`) VALUES
('1', 'A2P01', 'KT02', '1', '3', 35),
('2', 'A2P02', 'KT01', '2', '4', 4),
('3', 'A2P02', 'KT02', '5', '6', 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `thisinh`
--

CREATE TABLE `thisinh` (
  `MATS` varchar(10) COLLATE utf8_vietnamese_ci NOT NULL,
  `HOTEN` varchar(30) COLLATE utf8_vietnamese_ci NOT NULL,
  `GIOITINH` varchar(3) COLLATE utf8_vietnamese_ci NOT NULL,
  `NGAYSINH` date NOT NULL,
  `NOISINH` varchar(50) COLLATE utf8_vietnamese_ci NOT NULL,
  `CMND` varchar(20) COLLATE utf8_vietnamese_ci NOT NULL,
  `NGAYCAP` date NOT NULL,
  `NOICAP` varchar(50) COLLATE utf8_vietnamese_ci NOT NULL,
  `SDT` varchar(15) COLLATE utf8_vietnamese_ci NOT NULL,
  `EMAIL` varchar(30) COLLATE utf8_vietnamese_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `thisinh`
--

INSERT INTO `thisinh` (`MATS`, `HOTEN`, `GIOITINH`, `NGAYSINH`, `NOISINH`, `CMND`, `NGAYCAP`, `NOICAP`, `SDT`, `EMAIL`) VALUES
('TS_01', 'Le Thanh Huy', 'Nam', '2000-02-02', 'Bình Định', '214923847', '2015-02-02', 'Bình Định', '012334567', 'huy@gmail.com'),
('TS_02', 'sdf', 'sdf', '2000-02-02', 'sdf', 'sf', '2015-01-01', 'df', 'asf', 'sdf'),
('TS_03', 'h', 'nam', '2022-02-01', 'a', '123', '2000-02-01', 'a', '123', 'huy@');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `chiaphongthi`
--
ALTER TABLE `chiaphongthi`
  ADD KEY `MATS` (`MATS`),
  ADD KEY `MAPT` (`MAPT`);

--
-- Chỉ mục cho bảng `giamthi`
--
ALTER TABLE `giamthi`
  ADD PRIMARY KEY (`MAGT`);

--
-- Chỉ mục cho bảng `khoathi`
--
ALTER TABLE `khoathi`
  ADD PRIMARY KEY (`MAKT`);

--
-- Chỉ mục cho bảng `phongthi`
--
ALTER TABLE `phongthi`
  ADD PRIMARY KEY (`MAPT`),
  ADD KEY `MAKT` (`MAKT`),
  ADD KEY `MAGT1` (`MAGT1`),
  ADD KEY `MAGT2` (`MAGT2`);

--
-- Chỉ mục cho bảng `thisinh`
--
ALTER TABLE `thisinh`
  ADD PRIMARY KEY (`MATS`);

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `chiaphongthi`
--
ALTER TABLE `chiaphongthi`
  ADD CONSTRAINT `chiaphongthi_ibfk_1` FOREIGN KEY (`MAPT`) REFERENCES `phongthi` (`MAPT`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
