ĐỒ ÁN GIỮA KÌ CHUYÊN ĐỀ J2EE CHỦ ĐỀ: 
WEBSITE BÁN NHẠC CỤ SGUMusic - THEO MÔ HÌNH 3 LỚP

BAO GỒM SOURCE, PPT, DOCX, LƯỢC ĐỒ DRAW.IO

YÊU CẦU MÁY TÍNH PHẢI CÀI ĐẶT:

+ XAMPP (Tích hợp sẵn MYSQL, TOMCAT) hoặc MYSQL
+ NETBEAN IDE 
+ JDK 1.8 (bản mới sẽ không tương thích maven)


HƯỚNG DẪN CHẠY CHƯƠNG TRÌNH:

+ Import file quanlynhaccu.sql vào PHPMYADMIN trên XAMPP
+ Thêm JDK 1.8 vào biến môi trường trên Windows
+ Thiết lập Project chạy bằng JDK1.8 VÀ JAVA EE 7 Web
+ Thêm server TOMCAT từ thư mục XAMPP (tài khoản: admin, mật khẩu: admin)
+ Chạy chương trình và thêm /home vào trang index đầu tiên


TỔNG QUAN USER:

+ Đăng nhập, đăng ký, phân quyền
+ Xem sản phẩm, chi tiết sản phẩm
+ Cho sản phẩm vào giỏ hàng, thanh toán
+ Gửi mail xác nhận đặt hàng thành công
+ Gửi mail chứa mật khẩu khi người dùng quên mật khẩu
+ Xử lý bất đồng bộ khi tìm kiếm theo màu sắc
+ Tích hợp API ChatGPT 3.5 làm trang liên hệ CSKH
+ Đọc báo trực tuyến RSS từ VN Express


TỔNG QUAN ADMIN:

+ Trang tổng quan
+ CRUD tài khoản, sản phẩm, hóa đơn,...
+ Thống kê theo biểu đồ cột, tròn
+ Xuất file dữ liệu ra Excel


LƯU Ý:

+ Chương trình vẫn còn tồn tại một số Bug như nhập SL = 0
+ Cách tổ chức các tệp chưa được tối ưu (theo packet, folder)
+ Project có thể không tương thích Eclipse hoặc IntelliJ IDEA
