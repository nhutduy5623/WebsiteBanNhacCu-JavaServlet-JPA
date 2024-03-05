<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="icon" href="http://ttcntt.sgu.edu.vn/wp-content/uploads/2018/11/SGU-LOGO.png">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trang chủ</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!------ Include the above in your HEAD tag ------>
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link href="css/style.css" rel="stylesheet" type="text/css"/> 

        <!-- Font Awesome -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css" />
        <!-- Google Fonts Roboto -->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap" /> 
        <!-- MDB -->
        <link rel="stylesheet" href="css/mdb.min.css" />
        <!-- Custom styles -->
        <link rel="stylesheet" href="css/style.css" />

        <!-- Roboto Font -->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,500,700&display=swap"> 
        Font Awesome
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css">
        Bootstrap core CSS
        <link rel="stylesheet" href="https://mdbootstrap.com/previews/ecommerce-demo/css/bootstrap.min.css">
        Material Design Bootstrap
        <link rel="stylesheet" href="https://mdbootstrap.com/previews/ecommerce-demo/css/mdb-pro.min.css">
        Material Design Bootstrap Ecommerce
        <link rel="stylesheet" href="https://mdbootstrap.com/previews/ecommerce-demo/css/mdb.ecommerce.min.css"> 
        <!-- Your custom styles (optional) -->
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"> 

        <style>
            /* Carousel styling */
            #introCarousel,
            .carousel-inner,
            .carousel-item,
            .carousel-item.active {
                height: 100vh;
            }
            .carousel-item:nth-child(1) {
                background-image: url('https://vn.yamaha.com/vi/files/Slider3_66362d5fd9bc76e212b924f0867fbcf8.png');
                background-repeat: no-repeat;
                background-size: 100% 100%;
                background-position: center center;
            }
            .carousel-item:nth-child(2) {
                background-image: url('https://vn.yamaha.com/vi/files/bannerstoreMobile_6b2f3e963a111378386b074e4b028e22.png?impolicy=resize&imwid=1681&imhei=610');
                background-repeat: no-repeat;
                background-size: 100% 100%;
                background-position: center center;
            }
            .carousel-item:nth-child(3) {
                background-image: url('https://nhaccutienmanh.vn/wp-content/uploads/2020/06/mua-piano-tra-gop.jpg');
                background-repeat: no-repeat;
                background-size: 100% 100%;
                background-position: center center;
            }
            /* Height for devices larger than 576px */
            @media (min-width: 992px) {
                #introCarousel {
                    margin-top: -58.59px;
                }
            }
            .navbar .nav-link {
                color: #fff !important;
            }
        </style>

    </head>
    <body class="skin-light" onload="loadAmountCart()">
        <jsp:include page="Menu.jsp"></jsp:include>
            <!-- Carousel wrapper -->
            <div id="introCarousel" class="carousel slide carousel-fade shadow-2-strong" data-mdb-ride="carousel" style="margin-top:35px;">
                <!-- Indicators -->
                <ol class="carousel-indicators">
                    <li data-mdb-target="#introCarousel" data-mdb-slide-to="0" class="active"></li>
                    <li data-mdb-target="#introCarousel" data-mdb-slide-to="1"></li>
                    <li data-mdb-target="#introCarousel" data-mdb-slide-to="2"></li>
                </ol>

                <!-- Inner -->
                <div class="carousel-inner">
                    <!-- Single item -->
                    <div class="carousel-item active">

                    </div>

                    <!-- Single item -->
                    <div class="carousel-item">

                    </div>

                    <!-- Single item -->
                    <div class="carousel-item">

                    </div>
                </div>
                <!-- Inner -->

                <!-- Controls -->
                <a class="carousel-control-prev" href="#introCarousel" role="button" data-mdb-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="carousel-control-next" href="#introCarousel" role="button" data-mdb-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>
            <!-- Carousel wrapper -->



            <div class="card-group" style="margin-top:50px;">
                <div class="card" style="border-style: none;">
                    <img style="height:55px; width:64px; margin: auto;" src="data:image/png;base64,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">
                    <div class="card-body">
                        <h5 class="card-title" style="text-align:center">GIAO HÀNG TOÀN QUỐC</h5>
                        <p class="card-text" style="text-align:center">Vận chuyển khắp Việt Nam</p>
                    </div>
                </div>
                <div class="card" style="border-style: none;">
                    <img class="card-img-top" style="height:55px; width:64px; margin: auto;" src="https://weupgroup.vn/wp-content/uploads/2022/07/ship-cod-la-gi-1.jpg" alt="Card image cap">
                    <div class="card-body">
                        <h5 class="card-title" style="text-align:center">THANH TOÁN KHI NHẬN HÀNG</h5>
                        <p class="card-text" style="text-align:center">Nhận hàng tại nhà rồi thanh toán</p>
                    </div>
                </div>
                <div class="card" style="border-style: none;">
                    <img class="card-img-top" style="height:55px; width:64px; margin: auto;" src="https://suativiled.com.vn/wp-content/uploads/2019/03/icon-bao-hanh.png" alt="Card image cap">
                    <div class="card-body">
                        <h5 class="card-title" style="text-align:center">BẢO HÀNH DÀI HẠN</h5>
                        <p class="card-text" style="text-align:center">Bảo hàng lên đến 60 ngày</p>
                    </div>
                </div>
                <div class="card" style="border-style: none;">
                    <img class="card-img-top" style="height:55px; width:64px; margin: auto;" src="https://chobcs.vn/wp-content/uploads/2020/09/Chinh-sach-doi-tra.jpg" alt="Card image cap">
                    <div class="card-body">
                        <h5 class="card-title" style="text-align:center">ĐỔI HÀNG DỄ DÀNG</h5>
                        <p class="card-text" style="text-align:center">Đổi hàng thoải mái trong 30 ngày</p>
                    </div>
                </div>
            </div>


            <div class="container">

                <div class="row" style="margin-top:25px">            
                    <h1 style="text-align:center; width:100%" id="moiNhat">SẢN PHẨM MỚI NHẤT</h1>
                    <div class="col-sm-12">
                        <div id="contentMoiNhat" class="row">
                        <c:forEach items="${list8Last}" var="o">
                            <div class=" col-12 col-md-6 col-lg-3">
                                <div class="card">
                                    <div class="view zoom z-depth-2 rounded">
                                        <img class="img-fluid w-100" src="${o.image}" alt="Card image cap">

                                    </div>
                                    <div class="card-body">
                                        <h4 class="card-title show_txt"><a href="detail?pid=${o.id}" title="View Product">${o.name}</a></h4>
                                        <p class="card-text show_txt">${o.title}</p>
                                        <div class="row">
                                            <div class="col">
                                                <p class="btn btn-success btn-block">${o.price} $</p>
                                            </div> 
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>

            <div class="row" style="margin-top:25px">            
                <h1 style="text-align:center; width:100%" id="guitar">ĐÀN GUITAR MỚI NHẤT</h1>
                <div class="col-sm-12">
                    <div id="contentGuitar" class="row">
                        <c:forEach items="${list4GuitarLast}" var="o">
                            <div class="productGuitar col-12 col-md-6 col-lg-3">
                                <div class="card">
                                    <div class="view zoom z-depth-2 rounded">
                                        <img class="img-fluid w-100" src="${o.image}" alt="Card image cap">
                                    </div>
                                    <div class="card-body">
                                        <h4 class="card-title show_txt"><a href="detail?pid=${o.id}" title="View Product">${o.name}</a></h4>
                                        <p class="card-text show_txt">${o.title}</p>
                                        <div class="row">
                                            <div class="col">
                                                <p class="btn btn-success btn-block">${o.price} $</p>
                                            </div>

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>


            <div class="row" style="margin-top:25px">            
                <h1 style="text-align:center; width:100%" id="drum">TRỐNG ĐIỆN TỬ MỚI NHẤT</h1>
                <div class="col-sm-12">
                    <div id="contentDrum" class="row">
                        <c:forEach items="${list4DrumLast}" var="o">
                            <div class="productDrum col-12 col-md-6 col-lg-3">
                                <div class="card">
                                    <div class="view zoom z-depth-2 rounded">
                                        <img class="img-fluid w-100" src="${o.image}" alt="Card image cap">
                                    </div>
                                    <div class="card-body">
                                        <h4 class="card-title show_txt"><a href="detail?pid=${o.id}" title="View Product">${o.name}</a></h4>
                                        <p class="card-text show_txt">${o.title}</p>
                                        <div class="row">
                                            <div class="col">
                                                <p class="btn btn-success btn-block">${o.price} $</p>
                                            </div>

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>


            <div class="row" style="margin-top:50px">            
                <div class="col-sm-12">
                    <div id="content" class="row">
                        <div class=" col-12 col-md-12 col-lg-6">
                            <div class="card-body">
                                <h4 class="card-title show_txt" style="text-align:center; font-size:18pt; color:#b57b00;">Về chúng tôi</h4>
                                <h2 class="card-title show_txt" style="text-align:center; font-size:24pt;">SGU Music</h2>
                                <p style="text-align:center;">SGU Music là trang web chuyên cung cấp nhạc cụ và dịch vụ âm nhạc tại Việt Nam. Chúng tôi tự hào cung cấp một loạt các nhạc cụ chất lượng và đa dạng, đồng thời hỗ trợ người yêu âm nhạc bằng cách cung cấp thông tin sản phẩm chi tiết và dịch vụ tư vấn chuyên nghiệp. Với SGU Music, chúng tôi muốn giúp bạn tạo ra âm nhạc đẹp và đánh thức tài năng âm nhạc của mọi người.</p>                  
                            </div>  
                        </div>
                        <div class=" col-12 col-md-12 col-lg-6">
                            <img class="card-img-top" src="https://saigonmusical.com.vn/wp-content/uploads/2018/12/MG_2412.jpg" alt="Card image cap">        
                        </div>
                    </div>
                </div>
            </div>

        </div>

        <jsp:include page="Footer.jsp"></jsp:include>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script>

        function loadMore() {
            var amount = document.getElementsByClassName("product").length;
            $.ajax({
                url: "/QuanLyNhacCu/load",
                type: "get", //send it through get method
                data: {
                    exits: amount
                },
                success: function (data) {
                    var row = document.getElementById("content");
                    row.innerHTML += data;
                },
                error: function (xhr) {
                    //Do Something to handle error
                }
            });
        }

        function searchByName(param) {
            var txtSearch = param.value;
            $.ajax({
                url: "/QuanLyNhacCu/searchAjax",
                type: "get", //send it through get method
                data: {
                    txt: txtSearch
                },
                success: function (data) {
                    var row = document.getElementById("content");
                    row.innerHTML = data;
                },
                error: function (xhr) {
                    //Do Something to handle error
                }
            });
        }
        function load(cateid) {
            $.ajax({
                url: "/QuanLyNhacCu/category",
                type: "get", //send it through get method
                data: {
                    cid: cateid
                },
                success: function (responseData) {
                    document.getElementById("content").innerHTML = responseData;
                }
            });
        }
        function loadAmountCart() {
            $.ajax({
                url: "/QuanLyNhacCu/loadAllAmountCart",
                type: "get", //send it through get method
                data: {

                },
                success: function (responseData) {
                    document.getElementById("amountCart").innerHTML = responseData;
                }
            });
        }
        </script>  

        <!-- MDB -->
        <script type="text/javascript" src="js/mdb.min.js"></script>
        <!-- Custom scripts -->
        <script type="text/javascript" src="js/script.js"></script>

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
    </body>
</html>

