<%-- 
    Document   : UserOrder
    Created on : Nov 9, 2023, 10:42:10 AM
    Author     : lunhu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <link rel="icon" href="http://ttcntt.sgu.edu.vn/wp-content/uploads/2018/11/SGU-LOGO.png">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Đơn Hàng</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    </head>

    <body onload="loadTotalMoney()" style="position: relative">
        
        <jsp:include page="Menu.jsp"></jsp:include>
        
        
        <div class="orderDetail" style="height: 100%; width: 100%; position: fixed; top: 4%; display: none; justify-content: center; z-index: 3; ">
            
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
        <div class="shopping-cart" style="margin-top:100px">
                <div class="px-4 px-lg-0">

                    <div class="pb-5">
                        <div class="container">
                            <div class="row">
                                <div class="col-lg-12 p-5 bg-white rounded shadow-sm mb-5">

                                    <!-- Shopping cart table -->
                                    <div class="table-responsive">
                                        <table class="table">
                                            <thead>
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
                                        <tr>
                                            <th scope="col" class="border-0 bg-light">
                                                <div class="p-2 px-3 text-uppercase">Ngày Đặt Hàng</div>
                                            </th>
                                            <th scope="col" class="border-0 bg-light">
                                                <div class="p-2 px-3 text-uppercase">Mã Đơn Hàng</div>
                                            </th>
                                            <th scope="col" class="border-0 bg-light">
                                                <div class="py-2 text-uppercase">Số Điện Thoại</div>
                                            </th>
                                            <th scope="col" class="border-0 bg-light">
                                                <div class="py-2 text-uppercase">Địa Chỉ Giao Hàng</div>
                                            </th>
                                            <th scope="col" class="border-0 bg-light">
                                                <div class="py-2 text-uppercase">Tồng Tiền</div>
                                            </th>
                                            <th scope="col" class="border-0 bg-light">
                                                <div class="py-2 text-uppercase">Tình Trạng</div>
                                            </th>                                            
                                            <th scope="col" class="border-0 bg-light">
                                                <div class="py-2 text-uppercase">Xem Chi Tiết Đơn Hàng</div>
                                            </th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${listOrders}" var="o">
                                                <tr>
                                                    <td class="align-middle"><strong>${o.ngayXuat}</strong></td>
                                                    <td class="align-middle"><strong>${o.id}</strong></td>
                                                    <td class="align-middle"><strong>${o.phoneNumber}</strong></td>
                                                    <td class="align-middle"><strong>${o.diachi}</strong></td>
                                                    <td class="align-middle"><strong>${o.tongGia}</strong></td>
                                                            <td class="align-middle"><strong>
                                                                <c:if test="${o.tinhTrang == 1}">
                                                                    Đã xử lý
                                                                </c:if>    
                                                                <c:if test="${o.tinhTrang != 1}">
                                                                    Chờ xử lý
                                                                </c:if>
                                                        </strong></td>
                                                        <td class="align-middle"><strong><input id="btn_OpenDetail_id=${o.id}" class="btnOpenDetail" type="button" value="Xem Chi Tiết"></strong></td>
                                                </tr> 
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                                <!-- End -->
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
        
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
        
        <script>
        <c:url var="ServletUrl" value="/UserOrder" />
            $(".btnOpenDetail").click(function(){                
               $(".orderDetail").css({display:'flex'});
                var cardId = $(this).attr("id");
                var orderId = cardId.split('=')[1]; 
                var dataString = "orderId="+orderId+"";
                $.ajax({
                    url: '${ServletUrl}',
                    type: 'GET',
                    data: dataString,
                    success: function(result) {
                        $(".card").html(result);
                    },
                    error: function (error) {
                        console.log(error)
                    }
		})
         
         
                 
                
            });
            
            $("#closeDetail").click(function(){
                 $(".orderDetail").css({display:'none'});
            });
        </script>
    </body>
</html>
</html>
