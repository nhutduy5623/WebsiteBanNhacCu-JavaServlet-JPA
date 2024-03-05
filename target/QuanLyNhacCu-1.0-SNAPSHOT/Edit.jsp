<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Edit</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="css/manager.css" rel="stylesheet" type="text/css"/>
        <style>
            img{
                width: 200px;
                height: 120px;
            }
        </style>
    <body>

        <div class="container">
            <div class="table-wrapper">
                <div class="table-title">
                    <div class="row">
                        <div class="col-sm-6">
                            <h2>Edit <b>Product</b></h2>
                        </div>
                        <div class="col-sm-6">
                        </div>
                    </div>
                </div>
            </div>
            <div id="editEmployeeModal">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form id="formEditProduct" action="edit" method="post">
                            <div class="modal-header">						
                                <h4 class="modal-title">Edit Product</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            </div>
                            <div class="modal-body">					
                                <div class="form-group">
                                    <!--                          <label>ID</label> -->
                                    <input value="${detail.id}" name="id" type="hidden" class="form-control" readonly required>
                                </div> 
                                <div class="form-group">
                                    <label>Name</label>
                                    <input value="${detail.name}" name="name" type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Image</label>
                                    <input id="img" name="image" type="file" class="form-control" >
                                    <input id="Nameimg" name="Nameimg" value="" type="hidden">

                                </div>
                                <div class="form-group">
                                    <label>Image 2</label>
                                    <input id="img2" name="image2" type="file" class="form-control" >
                                    <input id="Nameimg2" name="Nameimg2" value="" type="hidden">
                                </div>
                                <div class="form-group">
                                    <label>Image 3</label>
                                    <input id="img3" name="image3" type="file" class="form-control" >
                                    <input id="Nameimg3" name="Nameimg3" value="" type="hidden">
                                </div>
                                <div class="form-group">
                                    <label>Image 4</label>
                                    <input id="img4" name="image4" type="file" class="form-control" >
                                    <input id="Nameimg4" name="Nameimg4" value="" type="hidden">
                                </div>
                                <div class="form-group">
                                    <label>Price</label>
                                    <input value="${detail.price}" name="price" type="text" class="form-control" >
                                </div>
                                <div class="form-group">
                                    <label>Title</label>
                                    <textarea name="title" class="form-control" required>${detail.title}</textarea>
                                </div>
                                <div class="form-group">
                                    <label>Model</label>
                                    <textarea name="model" class="form-control" required>${detail.model}</textarea>
                                </div>
                                <div class="form-group">
                                    <label>Color</label>
                                    <textarea name="color" class="form-control" required>${detail.color}</textarea>
                                </div>
                                <div class="form-group">
                                    <label>Delivery</label>
                                    <textarea name="delivery" class="form-control" required>${detail.delivery}</textarea>
                                </div>
                                <div class="form-group">
                                    <label>Description</label>
                                    <textarea name="description" class="form-control" >${detail.description}</textarea>
                                </div>
                                <div class="form-group">
                                    <label>Category</label>
                                    <select name="category" class="form-select" aria-label="Default select example">
                                        <c:forEach items="${listCC}" var="o">
                                            <option value="${o.cid}">${o.cname}</option>
                                        </c:forEach>
                                    </select>
                                </div>

                            </div>
                            <div class="modal-footer">
                                <input type="submit" class="btn btn-success" value="Edit">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <script>
            <c:url var="UrlUploadImg" value="/UploadFile" />
            <c:url var="urlSaveProduct" value="/add" />
            $("#submitFormProduct").click(function () {
                alert("");
                var formData = new FormData();
                formData.append('fileQuantity', 4);
                formData.append('file1', $("#img")[0].files[0]);
                formData.append('file2', $("#img2")[0].files[0]);
                formData.append('file3', $("#img3")[0].files[0]);
                formData.append('file4', $("#img4")[0].files[0]);
                $.ajax({
                    url: '${UrlUploadImg}',
                    type: 'POST',
                    contentType: false,
                    processData: false,
                    data: formData,
                    success: function (result) {
                        var img = $("#img")[0].files[0].name;
                        var img2 = $("#img2")[0].files[0].name;
                        var img3 = $("#img3")[0].files[0].name;
                        var img4 = $("#img4")[0].files[0].name;
                        $("#Nameimg").val(img);
                        $("#Nameimg2").val(img2);
                        $("#Nameimg3").val(img3);
                        $("#Nameimg4").val(img4);
                        $("#formEditProduct").submit();
                    },
                    error: function (error) {
                        alert("Upload file fail: " + error);
                    }
                });

            });


        </script>


        <script src="js/manager.js" type="text/javascript"></script>
    </body>
</html>