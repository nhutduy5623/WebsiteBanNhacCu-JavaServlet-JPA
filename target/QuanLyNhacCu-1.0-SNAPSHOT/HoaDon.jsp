<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="icon" href="http://ttcntt.sgu.edu.vn/wp-content/uploads/2018/11/SGU-LOGO.png">
        <meta charset="ISO-8859-1">
        <title>Hóa đơn</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

        <!------ Include the above in your HEAD tag ------>
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link href="css/style.css" rel="stylesheet" type="text/css"/> 

        <!-- Font Awesome -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css">
        <!-- Bootstrap core CSS -->
        <link rel="stylesheet" href="https://mdbootstrap.com/previews/ecommerce-demo/css/bootstrap.min.css">
        <!-- Material Design Bootstrap -->
        <link rel="stylesheet" href="https://mdbootstrap.com/previews/ecommerce-demo/css/mdb-pro.min.css">
        <!-- Material Design Bootstrap Ecommerce -->
        <link rel="stylesheet" href="https://mdbootstrap.com/previews/ecommerce-demo/css/mdb.ecommerce.min.css">
        <!-- Your custom styles (optional) -->
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!------ Include the above in your HEAD tag ------>
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link href="css/style.css" rel="stylesheet" type="text/css"/> 
        <style>
            body {
                margin: 0;
                padding: 0;
            }
        </style>
        <link rel="stylesheet" type="text/css" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css"><link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&amp;display=swap"><link rel="stylesheet" type="text/css" href="https://mdbootstrap.com/wp-content/themes/mdbootstrap4/css/mdb5/3.8.1/compiled.min.css"><link rel="stylesheet" type="text/css" href="https://mdbootstrap.com/wp-content/themes/mdbootstrap4/css/mdb-plugins-gathered.min.css"><style>body {
                background-color: #fbfbfb;
            }
            @media (min-width: 991.98px) {
                main {
                    padding-left: 240px;
                }
            }
            /* Sidebar */
            .sidebar {
                position: fixed;
                top: 0;
                bottom: 0;
                left: 0;
                padding: 58px 0 0; /* Height of navbar */
                box-shadow: 0 2px 5px 0 rgb(0 0 0 / 5%), 0 2px 10px 0 rgb(0 0 0 / 5%);
                width: 240px;
                z-index: 600;
            }
            @media (max-width: 991.98px) {
                .sidebar {
                    width: 100%;
                }
            }
            .sidebar .active {
                border-radius: 5px;
                box-shadow: 0 2px 5px 0 rgb(0 0 0 / 16%), 0 2px 10px 0 rgb(0 0 0 / 12%);
            }
            .sidebar-sticky {
                position: relative;
                top: 0;
                height: calc(100vh - 48px);
                padding-top: 0.5rem;
                overflow-x: hidden;
                overflow-y: auto; /* Scrollable contents if viewport is shorter than content. */
            }</style>
    </head>
    <body>
        <div class="orderDetail" style="height: 100%; width: 100%; position: fixed; left: 8%; display: none; justify-content: center; z-index: 3; ">

            <section class="h-100 gradient-custom" style="z-index: 3">
                <div class="container py-5 h-100">
                    <div class="row d-flex justify-content-center align-items-center h-100">
                        <div class="col-lg-20 col-xl-10">
                            <div class="card" style="border-radius: 10px;">
                                <!--                        <div class="card-header px-4 py-3">
                                                          <h5 class="text-muted mb-0">Your Order, <span style="color: #a8729a;">Anna</span>!</h5>
                                                        </div>
                                                        <div class="card-body px-4 py-2 ">
                                                          <div class="d-flex justify-content-between align-items-center mb-4">
                                                            <p class="lead fw-normal mb-0" style="color: #a8729a;">Receipt</p>
                                                            <p class="small text-muted mb-0">Receipt Voucher : 1KAU9-84UIL</p>
                                                          </div>
                                                                
                                                            
                                                             SanPham
                                                            <div class ="ListCard" style="width: 100%; max-height: 290px; overflow: auto">-->




                                <!--                            </div>
                                
                                                          <div class="d-flex justify-content-between pt-2">
                                                            <p class="fw-bold mb-0">Order Details</p>
                                                            <p class="text-muted mb-0"><span class="fw-bold me-4">Total</span> $898.00</p>
                                                          </div>
                                
                                                          <div class="d-flex justify-content-between pt-2">
                                                            <p class="text-muted mb-0">Invoice Number : 788152</p>
                                                            <p class="text-muted mb-0"><span class="fw-bold me-4">Discount</span> $19.00</p>
                                                          </div>
                                
                                                          <div class="d-flex justify-content-between">
                                                            <p class="text-muted mb-0">Invoice Date : 22 Dec,2019</p>
                                                            <p class="text-muted mb-0"><span class="fw-bold me-4">GST 18%</span> 123</p>
                                                          </div>
                                
                                                          <div class="d-flex justify-content-between">
                                                            <p class="text-muted mb-0">Recepits Voucher : 18KU-62IIK</p>
                                                            <p class="text-muted mb-0"><span class="fw-bold me-4">Delivery Charges</span> Free</p>
                                                          </div>
                                                        </div>
                                                        <div class="card-footer border-0 px-4 py-3"
                                                          style="background-color: #a8729a; border-bottom-left-radius: 10px; border-bottom-right-radius: 10px;">
                                                          <h5 class="d-flex align-items-center justify-content-end text-white text-uppercase mb-0">Total
                                                            paid: <span class="h2 mb-0 ms-2">$1040</span></h5>
                                                        </div>-->
                            </div>
                        </div>
                    </div>
                </div>

                <style>
                    #closeDetail:hover{
                        cursor: pointer;
                    }

                </style>
            </section> 
            <div id="closeDetail" style="height: 100%; width: 100%; position: fixed; background-color: #005121; opacity: 0.2; z-index: 2"></div>
        </div>


        <!--Main Navigation-->
        <header>
            <jsp:include page="LeftAdmin.jsp"></jsp:include>

            </header>
            <!--Main Navigation-->

            <!--Main layout-->
            <main>

                <div class="container pt-4">
                    <!--Section: Sales Performance KPIs-->
                    <section class="mb-4">
                    <c:if test="${error!=null }">
                        <div class="alert alert-danger" role="alert">
                            ${error}
                        </div>
                    </c:if>
                    <c:if test="${mess!=null }">
                        <div class="alert alert-success" role="alert">
                            ${mess}
                        </div>
                    </c:if>

                    <div class="card-order">
                        <div class="card-header py-3 row">
                            <div class="col-sm-6">
                                <h5 class="mb-0 text-left" id="">
                                    <strong>Hóa Đơn</strong>
                                </h5>
                                <form id="OrderFilter" action="hoaDon" method="get"> 
                                    <select id="tinhtrangFilter" name="tinhtrangFilter">
                                        <option value="2">Tất cả</option>
                                        <option value="1">Đã xử lý</option>
                                        <option value="0">Chưa xử lý</option>
                                    </select>    
                                    <input type="hidden" name="ngayXuat" id="valueOrderDate" value="">

                                </form> 
                            </div>
                            <div class="col-sm-6">
                                <h5 class="mb-0 text-right" id="">
                                    <form action="xuatExcelControl" method="get"> 
                                        <input type="date" id="dateHoaDon" name="dateHoaDon" class="form-control mb-0" style="width:30%">
                                        <button type="submit" class="mb-0 text-center btn btn-primary">Xuất file Excel</button> 
                                        <input id="tinhTrangXuatfile" type="hidden" name="tinhTrangXuatfile" value="">

                                    </form> 
                                </h5>
                            </div>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-hover text-nowrap">
                                    <thead>
                                        <tr>
                                            <th scope="col">Ngày Đặt Hàng</th>
                                            <th scope="col">Mã Đơn Hàng</th>
                                            <th scope="col">Số Điện Thoại</th>
                                            <th scope="col">Địa Chỉ Giao Hàng</th>
                                            <th scope="col">Tồng Tiền</th>
                                            <th scope="col">Tình Trạng</th>
                                            <th scope="col">Xem Chi Tiết Đơn Hàng</th>
                                        </tr>
                                    </thead>

                                    <tbody id="content">
                                        <c:forEach items="${listOrders}" var="o">
                                            <tr>
                                                <td><strong>${o.ngayXuat}</strong></td>
                                                <td><strong>${o.id}</strong></td>
                                                <td><strong>${o.phoneNumber}</strong></td>
                                                <td><strong>${o.diachi}</strong></td>
                                                <td><strong>${o.tongGia}</strong></td>
                                                <td><strong id="tinhtrang${o.id}">
                                                        <c:if test="${o.tinhTrang == 1}">
                                                            Đã xử lý
                                                        </c:if>    
                                                        <c:if test="${o.tinhTrang != 1}">
                                                            <input id="btn_XuLy_id=${o.id}" class="btnXuLy" type="button" value="Xử lý đơn">
                                                        </c:if>
                                                    </strong></td>
                                                <td><strong><input id="btn_OpenDetail_id=${o.id}" class="btnOpenDetail" type="button" value="Xem Chi Tiết"></strong></td>

                                            </tr>

                                        </c:forEach>
                                    </tbody>
                                </table> 
                            </div>
                        </div>

                    </div>
                </section>
                <!--Section: Sales Performance KPIs-->
                <style>
                    #tinhtrangFilter:hover {
                        cursor: pointer;
                    }
                    option:hover {
                        cursor: pointer;
                    }
                </style>
            </div>
        </main>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

        <!--Main layout-->
        <!-- SCRIPTS -->
        <!-- JQuery -->
        <script src="https://mdbootstrap.com/previews/ecommerce-demo/js/jquery-3.4.1.min.js"></script>
        <!-- Bootstrap tooltips -->
        <script type="text/javascript" src="https://mdbootstrap.com/previews/ecommerce-demo/js/popper.min.js"></script>
        <!-- Bootstrap core JavaScript -->
        <script type="text/javascript" src="https://mdbootstrap.com/previews/ecommerce-demo/js/bootstrap.js"></script>
        <!-- MDB core JavaScript -->
        <script type="text/javascript" src="https://mdbootstrap.com/previews/ecommerce-demo/js/mdb.min.js"></script>
        <!-- MDB Ecommerce JavaScript -->
        <script type="text/javascript" src="https://mdbootstrap.com/previews/ecommerce-demo/js/mdb.ecommerce.min.js"></script>
        <!-- MDB -->
        <script type="text/javascript" src="js/mdb.min.js"></script>
        <!-- Custom scripts -->
        <script type="text/javascript" src="js/script.js"></script>
        <script src="https://mdbootstrap.com/api/snippets/static/download/MDB5-Free_3.8.1/js/mdb.min.js"></script><script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js"></script>


        <script type="text/javascript" src="https://mdbootstrap.com/wp-content/themes/mdbootstrap4/js/plugins/mdb-plugins-gathered.min.js"></script>
        <!-- MDB -->
        <script type="text/javascript" src="js/mdb.min.js"></script>
        <!-- Custom scripts -->
        <script type="text/javascript" src="js/script.js"></script>
        <script>

            <c:url var="ServletUrl" value="/hoaDon" />

            $("#dateHoaDon").change(function () {
                var txtSearchDate = $("#dateHoaDon").val();
                var tinhTrang = $("#tinhtrangFilter").val();
                var dataString = "ngayXuat=" + txtSearchDate + "&tinhtrangFilter=" + tinhTrang + "";
                $("#valueOrderDate").val(txtSearchDate);
                $('#OrderFilter').submit();
            });

            $(".btnOpenDetail").click(function () {
                $(".orderDetail").css({display: 'flex'});
                var cardId = $(this).attr("id");
                var orderId = cardId.split('=')[1];
                var dataString = "orderId=" + orderId + "";
                $.ajax({
                    url: '${ServletUrl}',
                    type: 'GET',
                    data: dataString,
                    success: function (result) {
                        $(".card").html(result);
                    },
                    error: function (error) {
                        console.log(error);
                    }
                });


            });

            $("#closeDetail").click(function () {
                $(".orderDetail").css({display: 'none'});
            });


            $(".btnXuLy").click(function () {
                var cardId = $(this).attr("id");
                var orderId = cardId.split('=')[1];
                var orderIdData = "orderId=" + orderId + "";
                $.ajax({
                    url: '${ServletUrl}',
                    type: 'POST',
                    data: orderIdData,
                    success: function (result) {
                        $("#tinhtrang" + orderId).html("Đã xử lý");
                    },
                    error: function (error) {
                        console.log(error);
                    }
                });


            });

            $('#tinhtrangFilter').val(${tinhtrang}).change();
            $('#tinhTrangXuatfile').val($('#tinhtrangFilter').val());
            $("#valueOrderDate").val('${ngayXuat}');
            $("#dateHoaDon").val('${ngayXuat}');
            $('#tinhtrangFilter').on('change', function () {
                $('#OrderFilter').submit();
            });
        </script>
    </body>
</html>