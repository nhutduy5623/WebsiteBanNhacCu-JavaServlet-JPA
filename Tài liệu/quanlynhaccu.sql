-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th10 17, 2023 lúc 12:03 PM
-- Phiên bản máy phục vụ: 10.4.27-MariaDB
-- Phiên bản PHP: 8.0.25
use quanlynhaccu

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `quanlynhaccu`
--

DELIMITER $$
--
-- Thủ tục
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_CapNhatSoLuongDaBan` (IN `productID ` INT, IN `soLuongBanThem` INT)   begin
	update SoLuongDaBan set soLuongDaBan=soLuongDaBan + soLuongBanThem where productID=productID;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_CapNhatTongBanHang` (IN `sell_ID` INT, IN `banHangThem` FLOAT)   BEGIN
    UPDATE tongchitieubanhang SET TongBanHang = TongBanHang + banHangThem WHERE userID = sell_ID;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_CapNhatTongChiTieu` (IN `userID` INT, IN `chiTieuThem` FLOAT)   begin
	update TongChiTieuBanHang set TongChiTieu= TongChiTieu + chiTieuThem where userID=userID;
end$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `account`
--

CREATE TABLE `account` (
  `uID` int(10) NOT NULL,
  `user` char(10) DEFAULT NULL,
  `pass` char(10) DEFAULT NULL,
  `isSell` varchar(100) DEFAULT NULL,
  `isAdmin` varchar(100) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `account`
--

INSERT INTO `account` (`uID`, `user`, `pass`, `isSell`, `isAdmin`, `email`) VALUES
(1, 'chibao', '0000', '1', '1', 'chibao00@gmail.com'),
(2, 'thanhtruc', '1111', '0', '0', 'thanhtruc11@gmail.com'),
(3, 'quocnam', '2222', '1', '0', 'quocnam22@gmail.com'),
(6, 'tienanh', '3333', '0', '0', 'tienanh33@gmail.com'),
(14, 'nhutduy', '4444', '1', '1', 'nhutduy44@gmail.com'),
(15, 'tokuda', '5555', '1', '1', 'tokuda55@gmail.com'),
(16, 'kimjongun', '1234', '1', '1', 'kimjongun12@gmail.com'),
(17, 'joebiden', '4321', '0', '0', 'joebiden43@gmail.com');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `cart`
--

CREATE TABLE `cart` (
  `accountID` int(10) NOT NULL,
  `productID` int(10) NOT NULL,
  `amount` int(10) DEFAULT NULL,
  `maCart` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `category`
--

CREATE TABLE `category` (
  `cid` int(10) NOT NULL,
  `cname` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `category`
--

INSERT INTO `category` (`cid`, `cname`) VALUES
(1, 'Trống'),
(2, 'Đàn Guitar'),
(3, 'Đàn Piano'),
(4, 'Đàn Organ');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `invoice`
--

--
-- Đang đổ dữ liệu cho bảng `invoice`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `product`
--

CREATE TABLE `product` (
  `id` int(10) NOT NULL,
  `name` varchar(200) DEFAULT NULL,
  `image` varchar(500) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `title` varchar(500) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `cateID` int(10) NOT NULL,
  `sell_ID` int(10) NOT NULL,
  `model` varchar(50) DEFAULT NULL,
  `color` varchar(50) DEFAULT NULL,
  `delivery` varchar(50) DEFAULT NULL,
  `image2` varchar(500) DEFAULT NULL,
  `image3` varchar(500) DEFAULT NULL,
  `image4` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `product`
--

INSERT INTO `product` (`id`, `name`, `image`, `price`, `title`, `description`, `cateID`, `sell_ID`, `model`, `color`, `delivery`, `image2`, `image3`, `image4`) VALUES
(1, 'Trống Điện Tử Medeli DD638DX', 'https://thegioinhaccu.com.vn/uploads/dd638dx_%281%29_1624687773.jpg', 697, 'Trống Điện Tử Medeli DD638DX', 'Thiết kế mạnh mẽ của dàn trống điện tử Medeli DD638DX\r\nTrống Điện Tử Medeli DD638DX với 8 pads có chế độ cảm biến lực và 2 bàn đạp chân, DD638DX có khả năng như một bộ trống đầy đủ với kích thước vô cùng nhỏ gọn dễ lắp ráp và sử dụng.\r\n\r\nNó cung cấp 650 âm thanh trống khác nhau và 100 bài hát cài sẵn. Hệ thống âm thanh được tinh chỉnh tỉ mỉ để tạo ra âm trầm sâu, mạnh mẽ.', 1, 1, 'DD638DX', 'Black', 'Sài Gòn', 'https://thegioinhaccu.com.vn/uploads/dd638dx_%282%29_1624687773.jpg', 'https://thegioinhaccu.com.vn/uploads/dd638dx_%283%29_1624687773.jpg', 'https://thegioinhaccu.com.vn/uploads/dd638dx_%284%29_1624687773.jpg'),
(2, 'Trống Điện Tử Medeli DD610S', 'https://thegioinhaccu.com.vn/uploads/dd610s_1591784454.1.jpg', 410, 'Trống Điện Tử Medeli DD610S', 'Thiết kế độc đáo của dàn trống điện tử Medeli DD610S\r\nTrống Điện Tử Medeli DD610S với 8 pads có chế độ cảm biến lực và 2 bàn đạp chân, DD610S có khả năng như một bộ trống đầy đủ với kích thước vô cùng nhỏ gọn dễ lắp ráp và sử dụng.\r\n\r\nCung cấp 226 âm thanh trống khác nhau và 60 bài hát cài sẵn. Hệ thống âm thanh được tinh chỉnh tỉ mỉ để tạo ra âm trầm sâu, mạnh mẽ.', 1, 1, 'DD610S', 'Black', 'Sài Gòn', 'https://thegioinhaccu.com.vn/uploads/dd610s_full_1591784454.jpg', 'https://thegioinhaccu.com.vn/uploads/dd610s_1591784454.2.jpg', 'https://thegioinhaccu.com.vn/uploads/dd610s_1591784454.3.jpg'),
(3, 'Trống Điện Tử Medeli DD309', 'https://thegioinhaccu.com.vn/uploads/dd309_%281%29_1624688993.jpg', 160, 'Trống Điện Tử Medeli DD638DX', 'Bộ trống điện tử medeli dd309\r\nTrống Điện Tử Medeli DD309 với 7 pads có chế độ cảm biến lực và 2 bàn đạp chân, DD309 có khả năng như một bộ trống đầy đủ với kích thước của một chiếc trống di động.\r\n\r\nNó cung cấp 310 âm thanh trống khác nhau, 120 bộ trống các loại và 100 bài hát cài sẵn. Hệ thống âm thanh được tinh chỉnh tỉ mỉ để tạo ra âm trầm sâu, mạnh mẽ.', 1, 1, 'DD309', 'Black', 'Sài Gòn', 'https://thegioinhaccu.com.vn/uploads/dd309_%283%29_1624688993.jpg', 'https://thegioinhaccu.com.vn/uploads/dd309_%281%29_1624688993.jpg', 'https://thegioinhaccu.com.vn/uploads/dd309_%282%29_1624688993.jpg'),
(4, 'Trống Điện Tử Medeli DD315', 'https://thegioinhaccu.com.vn/uploads/dd315_%281%29_1621569950.jpg', 140, 'Trống Điện Tử Medeli DD638DX', 'Bộ trống di dộng DD315\r\nTrống Điện Tử Medeli DD315 với 7 pads có chế độ cảm biến lực và 2 bàn đạp chân, DD315 có khả năng như một bộ trống đầy đủ với kích thước của một chiếc trống di động.\r\n\r\nNó cung cấp 265 âm thanh trống khác nhau, 45 bộ trống các loại và 100 bài hát cài sẵn. Hệ thống âm thanh được tinh chỉnh tỉ mỉ để tạo ra âm trầm sâu, mạnh mẽ.', 1, 1, 'DD315', 'Black', 'Sài Gòn', 'https://thegioinhaccu.com.vn/uploads/dd315_%283%29_1621569950.jpg', 'https://thegioinhaccu.com.vn/uploads/dd315_%284%29_1621569950.jpg', 'https://thegioinhaccu.com.vn/uploads/dd315_%282%29_1621569950.jpg'),
(5, 'Trống Điện Tử Medeli DD61', 'https://thegioinhaccu.com.vn/uploads/dd61_(1)_1621567471.jpg', 62, 'Trống Điện Tử Medeli DD61', 'Điều kì diệu của bộ trống di dộng DD61\r\nTrống Điện Tử Medeli DD61 với 4 chế độ cảm biến lực, DD61 có khả năng như một bộ trống thực tế với kích thước của một chiếc trống di động. Nó cung cấp 84 âm thanh trống khác nhau, 60 bộ trống các loại và 28 bài hát cài sẵn. Hệ thống âm thanh được tinh chỉnh tỉ mỉ để tạo ra âm trầm sâu, mạnh mẽ.', 1, 1, 'DD61', 'Black', 'Sài Gòn', 'https://thegioinhaccu.com.vn/uploads/dd61_%284%29_1621567471.jpg', 'https://thegioinhaccu.com.vn/uploads/dd61_%285%29_1621567471.jpg', 'https://thegioinhaccu.com.vn/uploads/dd61_%283%29_1621567471.jpg'),
(6, 'Đàn Guitar Classic Alhambra 8P', 'https://thegioinhaccu.com.vn/uploads/guitarras-clasicas-alhambrasl-8p-2-mat_1589511479.jpg', 1517, 'Đàn Guitar Classic Alhambra 8P', 'Đàn Guitar Classic Alhambra 8P một nhạc cụ có chất lượng đặc biệt. Mang đến trải nghiệm tuyệt vời cho các nghệ sĩ Guitar và khả năng trình diễn vô hạn.', 2, 1, '8P', 'Yellow', 'Sài Gòn', 'https://thegioinhaccu.com.vn/uploads/guitarras-clasicas-alhambrasl-8p_1589511474.jpg', 'https://thegioinhaccu.com.vn/uploads/guitarras-clasicas-alhambrasl-8p-mat-sau_1589511483.jpg', 'https://thegioinhaccu.com.vn/uploads/guitarras-clasicas-alhambrasl-8p-mat-sau-1_1589511487.jpg'),
(7, 'Đàn Guitar Classic Alhambra 5P E8', 'https://thegioinhaccu.com.vn/uploads/5_p_e8-1-1_1589613238.jpg', 1103, 'Đàn Guitar Classic Alhambra 5P E8', 'Đàn Guitar Classic Alhambra 5P E8 là một trong những cây đàn Guitar nhập khẩu trực tiếp từ Tây Ban Nha. Phù hợp để chơi nhiều phong cách âm nhạc. Thoải mái với âm thanh tốt và đáp ứng với nhiều đối tượng người chơi.', 2, 1, 'E8', 'Yellow', 'Sài Gòn', 'https://thegioinhaccu.com.vn/uploads/5_p_e8-1-1_1589613238.jpg', 'https://thegioinhaccu.com.vn/uploads/5_p_e8_1589613246.jpg', 'https://thegioinhaccu.com.vn/uploads/5_p_e8-1_1589613243.jpg'),
(8, 'Đàn Guitar Classic Alhambra 5P E1', 'https://thegioinhaccu.com.vn/uploads/5_p_e1-2_1589604806.jpg', 984, 'Đàn Guitar Classic Alhambra 5P E1', 'Đàn Guitar Classic Alhambra 5P E1 một cây đàn Guitar thích hợp để chơi nhiều phong cách âm nhạc. Thoải mái với âm thanh tốt và đáp ứng mọi nhu cầu của khách hàng.', 2, 1, 'E1', 'Yellow', 'Sài Gòn', 'https://thegioinhaccu.com.vn/uploads/5_p_e1-2_1589604806.jpg', 'https://thegioinhaccu.com.vn/uploads/5_p_e1_1589604814.jpg', 'https://thegioinhaccu.com.vn/uploads/5_p_e1-1_1589604810.jpg'),
(9, 'Đàn Guitar Classic Alhambra 4P E1', 'https://thegioinhaccu.com.vn/uploads/4_p_e1-1-1_1589612938.jpg', 820, 'Đàn Guitar Classic Alhambra 8P', 'Đàn Guitar Classic Alhambra 4 P E1 là một nhạc cụ Guitar được bao gồm trong Dòng nhạc Nhạc viện. Với các màn trình diễn rất thú vị. Đã đáp ứng tất cả các kỳ vọng có được trên toàn thế giới trong những năm qua mà cây đàn Alhambra 4P E1 này mang lại', 2, 1, 'E1', 'Yellow', 'Sài Gòn', 'https://thegioinhaccu.com.vn/uploads/4_p_e1_1589612949.jpg', 'https://thegioinhaccu.com.vn/uploads/4_p_e1-1_1589612945.jpg', 'https://thegioinhaccu.com.vn/uploads/4_p_e1-1-1-1_1589612942.jpg'),
(10, 'Đàn Guitar Classic Alhambra 5P', 'https://thegioinhaccu.com.vn/uploads/5p-2_1589448474.jpg', 816, 'Đàn Guitar Classic Alhambra 5P', 'Đàn Guitar Classic Alhambra 8P một nhạc cụ có chất lượng đặc biệt. Mang đến trải nghiệm tuyệt vời cho các nghệ sĩ Guitar và khả năng trình diễn vô hạn.', 2, 1, '5P', 'Yellow', 'Sài Gòn', 'https://thegioinhaccu.com.vn/uploads/5p_1589448465.jpg', 'https://thegioinhaccu.com.vn/uploads/5p-1_1589448470.jpg', 'https://thegioinhaccu.com.vn/uploads/5p-3_1589448477.jpg'),
(11, 'Đàn Piano cơ Yamaha Yu3', 'https://thegioinhaccu.com.vn/uploads/dan-piano-co-yamaha-yu3_1664963089.jpg', 5250, 'Đàn Piano cơ Yamaha Yu3', 'Đàn piano cơ Yamaha YU3 là mẫu đàn piano thuộc dòng YU Series cao cấp nhất của Yamaha. Mới được sản xuất từ năm 1998 nên cho đến thời điểm này nhìn chung chất lượng YU3 còn khá mới. Đàn có hệ thống Silent giúp người tập có thể đeo tai nghe khi tập tránh làm phiền xung quanh. YU3 có thiết kế tương đối gọn, sang trọng có thể phù với nhiều không gian trong ngôi nhà của bạn.', 3, 1, 'YU3', 'Black', 'Sài Gòn', 'https://thegioinhaccu.com.vn/uploads/dan-piano-co-yamaha-yu-3-chinh-hang_1664963089.jpg', 'https://thegioinhaccu.com.vn/uploads/z3762948970317_aef021fb890652e834fb79107eeaa946_1664963090.jpg', 'https://thegioinhaccu.com.vn/uploads/z3762949073691_7a4e5bb9b3742cdbc9db1ad345a6b8ba_1664963089.jpg'),
(12, 'Đàn piano cơ Yamaha U3E', 'https://thegioinhaccu.com.vn/uploads/yamaha_-u3e_1664965120.jpg', 1517, 'Đàn Piano cơ Yamaha U3E', 'Đàn piano cơ Yamaha U3E với màu đen sáng bóng làm tôn thêm sự sang trọng va quý phái cho căn nhà của bạn. Phù hợp với mọi chất liệu trang tri nội thất của ngôi nhà bạn.', 3, 1, 'U3E', 'Black', 'Sài Gòn', 'https://thegioinhaccu.com.vn/uploads/u3e_1664965131.jpg', 'https://thegioinhaccu.com.vn/uploads/img_9558_1664965130.jpg', 'https://thegioinhaccu.com.vn/uploads/img_9530_1664965133.jpg'),
(13, 'ĐÀN PIANO CƠ YAMAHA U2C', 'https://thegioinhaccu.com.vn/uploads/yamaha_u2c_1664964338.jpg', 5250, 'Đàn Piano cơ Yamaha U2C', 'Piano Yamaha U2C là một số ít cây Piano có màu gỗ nâu. Cây đàn này rất được ưa chuộng bởi những khách hàng có thiết kế phòng mang thiên hướng cổ điển hoặc tân cổ điển. Piano Yamaha U2C màu gỗ nâu mang vẻ đẹp sang trọng mà không hề đắt. Với giá trị nó mang lại to lớn hơn số tiền phải bỏ ra.', 3, 1, 'U2C', 'Brown', 'Sài Gòn', 'https://thegioinhaccu.com.vn/uploads/img_9872_1_1664964340.jpg', 'https://thegioinhaccu.com.vn/uploads/img_9913_1664964339.jpg', 'https://thegioinhaccu.com.vn/uploads/img_9882_1_1664964339.jpg'),
(14, 'Đàn piano điện yamaha YDP164', 'https://thegioinhaccu.com.vn/uploads/ydp164r_%281%29_1621691445.jpg', 1065, 'Đàn piano điện yamaha YDP164', 'Đàn piano điện Yamaha YDP 164 được lấy mẫu âm thanh từ hai cây đại dương cầm hòa nhạc CFX của Yamaha hàng đầu, cung cấp âm cao lấp lánh và âm trầm cộng hưởng mạnh mẽ kết hợp trong âm thanh phát ra tới tầm xa nhất của bất kỳ phòng hòa nhạc nào.', 3, 1, 'YDP164', 'Black', 'Sài Gòn', 'https://thegioinhaccu.com.vn/uploads/ydp164r_%284%29_1621691445.jpg', 'https://thegioinhaccu.com.vn/uploads/ydp164r_%283%29_1621691445.jpg', 'https://img.youtube.com/vi/z3zyjuL0ZLU/default.jpg'),
(15, 'Piano Cơ Yamaha JU109 PM', 'https://thegioinhaccu.com.vn/uploads/ju109_pm_1563453955.jpg', 2702, 'Piano Cơ Yamaha JU109 PM', 'Cây đàn piano cơ Yamaha JU109 PM với thiết kế màu gỗ gụ mang nét cổ điển có độ bóng cao và chân thật sẽ làm cho căn nhà bạn thêm hấp dẫn và lôi cuốn. Nếu bạn thực sự yêu thích vẻ đẹp lãng mạng, cổ xưa thì JU109 PM là sự lựa chọn tốt ưu nhất cho bạn.', 3, 1, 'JU109PM', 'Brown', 'Sài Gòn', 'https://thegioinhaccu.com.vn/uploads/ju109_pm_1563453955.jpg', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTDZlDRhTb-NMNWbspPLwGrviPaf3eiN-sdtw&usqp=CAU', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSdMvs86YkTBuG-ubYvRQhc6xaWvayS-tEDKwUAWOd0ZpVsCu-AIZ1N3XdNAiSU0sE5Qgc&usqp=CAU'),
(16, 'Đàn Piano Điện Yamaha Clavinova CSP150', 'https://thegioinhaccu.com.vn/uploads/csp150_b_top_1562919426.jpg', 2091, 'Đàn Piano Điện Yamaha Clavinova CSP150', 'Đàn Piano điện Yamaha CSP 150 sẽ biến ước mơ biết chơi piano của bạn thông qua các bài hát bạn yêu thích ở thư viện âm nhạc. Phần mềm SmartPianist phân tích bất kì bài hát nào trong vòng vài giây.', 3, 1, 'CSP150', 'Black', 'Sài Gòn', 'https://thegioinhaccu.com.vn/uploads/csp150_b_side1_1562919426.jpg', 'https://thegioinhaccu.com.vn/uploads/csp150_pe_top_1562919511.jpg', 'https://thegioinhaccu.com.vn/uploads/csp150_b_top_1562919426.jpg'),
(17, 'ĐÀN PIANO ĐIỆN YAMAHA ARIUS YDP-165', 'https://thegioinhaccu.com.vn/uploads/dan-piano-dien-yamaha-arius-ydp-165-6_1650439087.jpg', 1189, 'ĐÀN PIANO ĐIỆN YAMAHA ARIUS YDP-165', 'Dòng đàn piano điện Yamaha Arius YDP-165 được cải tiến có cấu trúc thoát âm mới ở mặt sau của thùng đàn. Điều này cho phép người đánh có cảm giác được chơi một cây đàn cơ thực thụ. Người dùng được trải nghiệm cộng hưởng ba chiều.\r\nNhờ công nghệ mới cân bằng âm thanh, những nốt nhạc phát ra được hài hòa, tự nhiên hơn.', 3, 1, 'YDP-165', 'White', 'Sài Gòn', 'https://thegioinhaccu.com.vn/uploads/dan-piano-dien-yamaha-arius-ydp-165-6_1650439087.jpg', 'https://thegioinhaccu.com.vn/uploads/dan-piano-dien-yamaha-arius-ydp-165-7_1650439087.jpg', 'https://thegioinhaccu.com.vn/uploads/dan-piano-dien-yamaha-arius-ydp-165-5_1650439086.jpg'),
(18, 'Đàn Organ Kurtzman SV800', 'https://thegioinhaccu.com.vn/uploads/dan-organ-kurtzman-sv800_1675500385.jpg', 738, 'Đàn Organ Kurtzman SV800', 'Vừa qua, Thương hiệu Kurtzman đã cho ra mắt mẫu đàn Organ Kurtzman SV800. Đây là một trong những mẫu sản phẩm mới và hiện đại nhất của kurtzman với những cải tiến và nâng cấp từ các dòng sản phẩm cũ. Đây được xem như là đối thủ nặng ký với các thương hiệu Roland, Casio, Yamaha... Với thiết kế sang trọng, tích hợp các chức năng đầy dủ cùng chất lượng âm thanh cao cấp hứa hẹn đây sẽ là một dòng siêu phẩm mới của thương hiệu Kurtzman. Hãy cùng Nhạc cụ Minh Phụng tìm hiểu những điểm nổi bật có trên ', 4, 1, 'SV800', 'Black', 'Sài Gòn', 'https://thegioinhaccu.com.vn/uploads/banner-sv800-8_1675759892.jpg', 'https://thegioinhaccu.com.vn/uploads/img_1398_1675760001.jpg', 'https://thegioinhaccu.com.vn/uploads/sv800_1675760142.jpg'),
(19, 'ĐÀN ORGAN KURTZMAN K350', 'https://thegioinhaccu.com.vn/uploads/k350_%281%29_1621234087.jpg', 738, 'ĐÀN ORGAN KURTZMAN K350', 'Tiếp nối sự thành công của đàn Kurtzman K250. Đồng thời là việc nắm bắt xu hướng âm nhạc và thấu hiểu nhu cầu khách hàng. Tháng 1 vừa qua, Kurtzman vừa cho ra mắt mẫu đàn Organ Kurtzman K350.\r\n\r\nĐây là một trong những sản phẩm được cải tiến và nâng cấp từ đàn Organ Kurtzman K250 - một trong những đối thủ nặng ký của nhiều thương hiệu lớn, tên tuổi như Yamaha, Korg, Roland, Casio…\r\n\r\nKế thừa và phát huy những điểm mạnh nhất của đàn Organ Kurtzman K250. Organ Kurtzman K350 nay còn được bổ sung và ', 4, 1, 'K350', 'Black', 'Sài Gòn', 'https://thegioinhaccu.com.vn/uploads/k350_%284%29_1621234087.jpg', 'https://thegioinhaccu.com.vn/uploads/k350_%287%29_1621234087.jpg', 'https://thegioinhaccu.com.vn/uploads/k350_%286%29_1621234087.jpg'),
(20, 'Đàn Organ Kurtzman K250', 'https://thegioinhaccu.com.vn/uploads/k250_%281%29_1621238675.jpg', 216, 'Đàn Organ Kurtzman K250', 'Trên thị trường đàn Organ hiện nay có rất nhiều thương hiệu như Yamaha, Casio, Roland... Với những người mới bắt đầu học đàn, thương hiệu được lựa chọn nhiều nhất là Casio. Còn với người đã tập lâu năm thì thương hiệu Yamaha và Roland được lựa chọn nhiều hơn cả. Tuy nhiên, có một thương hiệu đàn Organ mới được người sử dụng đánh giá rất cao: Kurtzman.\r\n\r\nThương hiệu này chưa phổ biến trên thị trường đàn Organ điện tử, do đó những ai thật sự yêu thích Organ, chịu khó tìm hiểu, nghiên cứu, so sánh', 4, 1, 'K250', 'Black', 'Sài Gòn', 'https://thegioinhaccu.com.vn/uploads/k250_%282%29_1621238675.jpg', 'https://thegioinhaccu.com.vn/uploads/k250_%285%29_1621238675.jpg', 'https://thegioinhaccu.com.vn/uploads/k250_%283%29_1621238675.jpg'),
(21, 'Đàn Organ Kurtzman K200', 'https://thegioinhaccu.com.vn/uploads/k200_%281%29_1621910526.jpg', 165, 'Đàn Organ Kurtzman K200', 'Đàn organ Kurtzman K200 có 100 điệu cài sẵn, 110 bài hát, 8 bài demo cho bạn tận hưởng âm nhạc sâu sắc hơn. Kết hợp cùng với chức năng tự động đệm, bạn có thể tự do lựa chọn điệu nào bạn mong muốn để chơi Solo hay đệm hát một cách phong phú và linh hoạt hơn. Cùng xem qua chi tiết nhé!', 4, 1, 'K200', 'Black', 'Sài Gòn', 'https://thegioinhaccu.com.vn/uploads/k200_%283%29_1621910526.jpg', 'https://thegioinhaccu.com.vn/uploads/k200_%284%29_1621910526.jpg', 'https://thegioinhaccu.com.vn/uploads/k200_%282%29_1621910526.jpg'),
(22, 'Đàn Organ Kurtzman K150', 'https://thegioinhaccu.com.vn/uploads/k150_wh_%281%29_1621233770.jpg', 96, 'Đàn Organ Kurtzman K150', 'Đàn organ Kurtzman K150 là dòng đàn organ dành cho người mới bắt đầu muốn tìm hiểu về organ với nhiều chức năng đi kèm như : Cảm ứng lực đánh phím (Touch), máy đếm nhịp (Metronome), Trộn tiếng (Double voice), Tăng giảm tone (Transpose), ...Chắc chắn rằng việc học của bạn sẽ trở nên dễ dàng hơn. Bên cạnh đó đàn organ kurtzman K150 còn hỗ trợ tiếng của 300 loại nhạc cụ khác nhau giúp bạn chơi các bản nhạc phong phú hơn.', 4, 1, 'K150', 'White', 'Sài Gòn', 'https://thegioinhaccu.com.vn/uploads/k150_wh_%283%29_1621233771.jpg', 'https://thegioinhaccu.com.vn/uploads/k150_wh_%284%29_1621233771.jpg', 'https://thegioinhaccu.com.vn/uploads/k150_wh_%282%29_1621233771.jpg'),
(23, 'Đàn Piano Điện Yamaha CVP 709GP PWH', 'https://thegioinhaccu.com.vn/uploads/cvp709gp_wh_side1_1562848951.jpg', 7996, 'Đàn Piano Điện Yamaha CVP 709GP PWH', 'Đàn piano điện CVP 709 GP PWH mang trong mình lớp vỏ ngoài lớn, với những đường cong  tuyệt đẹp cùng với các điểm nhấn kiểu dáng khác. CVP 709 GP PWH mang vẻ đẹp khiến bạn phải ngưỡng mộ. Bàn phím NWX (Natural Wood X) với sự thoát âm lúc kết thúc, bàn phím ngà tổng hợp cho bạn cảm giác chân thật nhất khi chơi. Âm thanh ấn tượng nhờ vào thiết kế âm thanh độc quyền và đạt được sự cộng hưởng âm sắc giống như piano cơ thực sự.', 3, 1, '709GP', 'White', 'Sài Gòn', 'https://thegioinhaccu.com.vn/uploads/cvp709gp_wh_side1_1562848951.jpg', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR72ESRXHWf2Iw4TqNIH-j2NuzJRnsq1YVqdg&usqp=CAU', 'https://www.epianos.co.uk/wp-content/uploads/2021/09/IMG_1595-scaled.jpg'),
(24, 'Đàn Piano điện Yamaha DGX-660', 'https://thegioinhaccu.com.vn/uploads/dan_piano_dien_yamaha_gdx660_1606385236.png', 533, 'Đàn Piano Điện Yamaha CVP 709GP PWH', 'Đây là dòng piano với thiết kể nhỏ gọn, đơn giản, giúp mang lại sự tinh tế cho không gian của bạn. Nhưng vẫn đảm bảo đầy đủ các tính năng đặc trưng của dòng Piano điện.\r\nĐối với những người mới tập chơi đàn, và diện tích không gian nhỏ thì đây là một dòng Piano đáng để đầu tư.', 3, 1, 'DGX-660', 'White', 'Sài Gòn', 'https://thegioinhaccu.com.vn/uploads/dan_piano_dien_gdx660_yamaha_1606385150.png', 'https://thegioinhaccu.com.vn/uploads/dan_piano_dien_yamaha_gdx660_1606385236.png', 'https://images.tokopedia.net/img/cache/700/product-1/2020/9/21/16575601/16575601_611c0013-a4e1-4c27-a0b8-be3299d7b88b_700_700.webp'),
(25, 'Đàn Piano Cơ YAMAHA U2G', 'https://thegioinhaccu.com.vn/uploads/yamaha_u2g_1587541586.png', 2009, 'Đàn Piano Điện Yamaha CVP 709GP PWH', 'Đàn Piano Yamaha U2G được nhập khẩu từ Nhật Bản. Đây là  là một trong những Model cũ đàn cũ bán chạy số 1 hiện nay. Piano cơ Yamaha U2G được thiết kế theo phong cách hiện đại, sang trọng. Thể hiện sự đẳng cấp quý phải khi trưng bày. Đồng thời là một vũ khí đặc biệt tô điểm cho ngôi nhà của bạn thêm phần sang trọng hơn.', 3, 1, 'U2G', 'Black', 'Sài Gòn', 'https://thegioinhaccu.com.vn/uploads/img_9871_1664963913.jpg', 'https://thegioinhaccu.com.vn/uploads/img_9889_1_1664963910.jpg', 'https://thegioinhaccu.com.vn/uploads/img_9905_1664963909.jpg'),
(26, 'Đàn Piano Cơ YAMAHA U3H', 'https://thegioinhaccu.com.vn/uploads/yamaha_u3h_mau_go_%281%29_1623934287.jpg', 2132, 'Đàn Piano Cơ YAMAHA U3H', 'Đàn Piano cơ Yamaha U3H dành cho những nghệ sỹ dương cầm chuyên nghiệp. Những nghệ sỹ ấy trước khi được lên sân khấu lớn để biểu diễn trước hàng nghìn khán giả thì họ đã trải qua những năm tháng luyện tập không ngừng nghỉ.\r\n\r\nNhững ngón tay vụng về ngày xưa khi mới tập chơi đàn đã trở thành những ngón tay điêu luyện lướt từng phím đàn, vang lên giai điệu sâu lắng chạm đên trái tim người nghe.', 3, 1, 'U3H', 'Brown', 'Sài Gòn', 'https://thegioinhaccu.com.vn/uploads/yamaha_u3h_mau_go_%281%29_1623934287.jpg', 'https://thegioinhaccu.com.vn/uploads/yamaha_u3h_mau_go_%282%29_1623934287.jpg', 'https://thegioinhaccu.com.vn/uploads/yamaha_u3h_mau_go_%283%29_1623934287.jpg'),
(27, 'Đàn Piano Điện Yamaha CLP 625', 'https://thegioinhaccu.com.vn/uploads/clp625_pe_top_1562851959.jpg', 1384, 'Đàn Piano Điện Yamaha CLP 625', 'Đàn piano điện Yamaha CLP 625R thật sự phù hợp với người bắt đầu học đàn cũng như những người chơi chuyên nghiệp. Âm thanh được lấy mẫu từ Yamaha CFX và Bösendorfer Imperial, bàn phím 88 phím ngà Graded Hammer 3X làm bằng gỗ mun tổng hợp mang lại cảm giác chân thật khi chơi. Ngoài ra bạn có thể kết nối với thiết bị iOS hoặc máy tính thông qua cổng USB để trải nghiệm các ứng dụng giải trí và giáo dục cùng với đàn piano điện Yamaha CLP 625R.', 3, 1, 'CLP 625', 'Black', 'Sài Gòn', 'https://thegioinhaccu.com.vn/uploads/clp625_r_top_1562851921.jpg', 'https://thegioinhaccu.com.vn/uploads/clp625_r_side1_1562851920.jpg', 'https://img.youtube.com/vi/G7IPYvKJO48/default.jpg');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `review`
--

CREATE TABLE `review` (
  `accountID` int(10) DEFAULT NULL,
  `productID` int(10) DEFAULT NULL,
  `contentReview` varchar(500) DEFAULT NULL,
  `dateReview` date DEFAULT NULL,
  `maReview` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `soluongdaban`
--

CREATE TABLE `soluongdaban` (
  `productID` int(10) NOT NULL,
  `soLuongDaBan` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;



--
-- Đang đổ dữ liệu cho bảng `soluongdaban`
--

INSERT INTO `soluongdaban` (`productID`, `soLuongDaBan`) VALUES
(1, 3),
(3, 2),
(20, 2),
(9, 3),
(24, 5),
(13, 8),
(2, 5),
(18, 4),
(15, 1),
(26, 2),
(23, 1),
(5, 3);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `supplier`
--

CREATE TABLE `supplier` (
  `idSupplier` int(10) NOT NULL,
  `nameSupplier` varchar(100) DEFAULT NULL,
  `phoneSupplier` varchar(50) DEFAULT NULL,
  `emailSupplier` varchar(200) DEFAULT NULL,
  `addressSupplier` varchar(200) DEFAULT NULL,
  `cateID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `supplier`
--

INSERT INTO `supplier` (`idSupplier`, `nameSupplier`, `phoneSupplier`, `emailSupplier`, `addressSupplier`, `cateID`) VALUES
(1, 'Medeli', '0919768606', 'nhaccudinhcao@gmail.com', '273 An Dương Vương', 1),
(2, 'Alhambra', '0919768606', 'nhaccudinhcao@gmail.com', '273 An Dương Vương', 2),
(3, 'Yamaha', '0919768606', 'nhaccudinhcao@gmail.com', '273 An Dương Vương', 3),
(4, 'Kurtzman', '0919768606', 'nhaccudinhcao@gmail.com', '273 An Dương Vương', 4);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tongchitieubanhang`
--

CREATE TABLE `tongchitieubanhang` (
  `userID` int(10) DEFAULT NULL,
  `TongChiTieu` float DEFAULT NULL,
  `TongBanHang` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `tongchitieubanhang`
--

INSERT INTO `tongchitieubanhang` (`userID`, `TongChiTieu`, `TongBanHang`) VALUES
(1, 0, 2091),
(14, 11816.2, 0),
(2, 0, 1221),
(3, 0, 692),
(15, 1289, 0),
(16, 2351, 0),
(6, 1152, 0),
(17, 8795.6, 0);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`uID`);

--
-- Chỉ mục cho bảng `cart`
--
ALTER TABLE `cart`
  ADD PRIMARY KEY (`maCart`),
  ADD KEY `FK_Cart_Account` (`accountID`),
  ADD KEY `FK_Cart_Product` (`productID`);

--
-- Chỉ mục cho bảng `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`cid`);


--
-- Chỉ mục cho bảng `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_Product_Category` (`cateID`),
  ADD KEY `FK_Product_Account` (`sell_ID`);

--
-- Chỉ mục cho bảng `review`
--
ALTER TABLE `review`
  ADD PRIMARY KEY (`maReview`),
  ADD KEY `FK_Review_Account` (`accountID`),
  ADD KEY `FK_Review_Product` (`productID`);

--
-- Chỉ mục cho bảng `soluongdaban`
--
ALTER TABLE `soluongdaban`
  ADD KEY `FK_SoLuongDaBan_Product` (`productID`);

--
-- Chỉ mục cho bảng `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`idSupplier`),
  ADD KEY `FK_Supplier_Category` (`cateID`);

--
-- Chỉ mục cho bảng `tongchitieubanhang`
--
ALTER TABLE `tongchitieubanhang`
  ADD KEY `FK_TongChiTieuBanHang_Account` (`userID`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `account`
--
ALTER TABLE `account`
  MODIFY `uID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT cho bảng `cart`
--
ALTER TABLE `cart`
  MODIFY `maCart` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;



--
-- AUTO_INCREMENT cho bảng `product`
--
ALTER TABLE `product`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT cho bảng `review`
--
ALTER TABLE `review`
  MODIFY `maReview` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `supplier`
--
ALTER TABLE `supplier`
  MODIFY `idSupplier` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `cart`
--
ALTER TABLE `cart`
  ADD CONSTRAINT `FK_Cart_Account` FOREIGN KEY (`accountID`) REFERENCES `account` (`uID`),
  ADD CONSTRAINT `FK_Cart_Product` FOREIGN KEY (`productID`) REFERENCES `product` (`id`);

--
-- Các ràng buộc cho bảng `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `FK_Product_Account` FOREIGN KEY (`sell_ID`) REFERENCES `account` (`uID`),
  ADD CONSTRAINT `FK_Product_Category` FOREIGN KEY (`cateID`) REFERENCES `category` (`cid`);

--
-- Các ràng buộc cho bảng `review`
--
ALTER TABLE `review`
  ADD CONSTRAINT `FK_Review_Account` FOREIGN KEY (`accountID`) REFERENCES `account` (`uID`),
  ADD CONSTRAINT `FK_Review_Product` FOREIGN KEY (`productID`) REFERENCES `product` (`id`);

--
-- Các ràng buộc cho bảng `soluongdaban`
--
ALTER TABLE `soluongdaban`
  ADD CONSTRAINT `FK_SoLuongDaBan_Product` FOREIGN KEY (`productID`) REFERENCES `product` (`id`);

--
-- Các ràng buộc cho bảng `supplier`
--
ALTER TABLE `supplier`
  ADD CONSTRAINT `FK_Supplier_Category` FOREIGN KEY (`cateID`) REFERENCES `category` (`cid`);

--
-- Các ràng buộc cho bảng `tongchitieubanhang`
--
ALTER TABLE `tongchitieubanhang`
  ADD CONSTRAINT `FK_TongChiTieuBanHang_Account` FOREIGN KEY (`userID`) REFERENCES `account` (`uID`);
COMMIT;


CREATE TABLE `order` (
  `id` int(10) NOT NULL,
  `accountID` int(10) NOT NULL,
  `tongGia` float NOT NULL,
  diachi varchar(500),
  email varchar(255),	
  phoneNumber varchar(11),
  `ngayXuat` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Chỉ mục cho bảng `invoice`
--
ALTER TABLE `order`
  ADD PRIMARY KEY (`id`);

 ALTER TABLE `order`
  ADD CONSTRAINT `FK_order_user` FOREIGN KEY (`accountID`) REFERENCES `account` (uID);

--
-- AUTO_INCREMENT cho bảng `order`
--
ALTER TABLE `order`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;


create table orderdetail (
	productId int(10) NOT NULL,
    orderId int(10) NOT NULL,
    amount int(10) NOT NULL
);

ALTER TABLE `orderdetail`
  ADD PRIMARY KEY (`productId`, orderId);
  
  ALTER TABLE `orderdetail`
  ADD CONSTRAINT `FK_detail_order` FOREIGN KEY (`orderId`) REFERENCES `order` (id);

	  ALTER TABLE `orderdetail`
  ADD CONSTRAINT `FK_detail_order_product` FOREIGN KEY (`productId`) REFERENCES `product` (id);

ALTER TABLE `quanlynhaccu`.`order` 
ADD COLUMN `tinhTrang` INT NOT NULL DEFAULT 0 AFTER `ngayXuat`;
 
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
