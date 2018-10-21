<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<title>Insert title here</title>
<jsp:include page="header.jsp"></jsp:include>
</head>
<body>
	<div style="background: black"  class="container-fluid ">
		<nav class="navbar navbar-default none-nav">
		  <div class="container-fluid">
		    <!-- Brand and toggle get grouped for better mobile display -->
		    <div class="navbar-header">
		      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
		        <span class="sr-only">Toggle navigation</span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		      </button>
		      <a class="navbar-brand" href="#"><img src='<c:url value ="/resources/image/logo-minishop.jpg"/>'/></a>
		    </div>
		
		    <!-- Collect the nav links, forms, and other content for toggling -->
		    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		      <ul class="nav navbar-nav navbar-center">
		        <li class="active"><a href="#">TRANG CHỦ</a></li>
		        <li class="dropdown open_horse">
		          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
		          <ul class="dropdown-menu">
		            <li><a href="#">Something else here</a></li>
		            <li role="separator" class="divider"></li>
		            <li><a href="#">Separated link</a></li>
		            <li role="separator" class="divider"></li>
		            <li><a href="#">One more separated link</a></li>
		            <li role="separator" class="divider"></li>
		            <li><a href="#">One more separated link</a></li>
		          </ul>
		        </li>
		        <li><a href="#">DỊCH VỤ</a></li>
		        <li><a href="#">LIÊN HỆ</a></li>
		        
		        
		      </ul>
		      <ul class="nav navbar-nav navbar-right">
		      	<c:set var="AcountHeader" value=""/>
		      	<c:choose>
		      		<c:when test="${email != null}">
		      			<c:set var="AcountHeader" value="${email}"/>
		      		</c:when>
		      	</c:choose>
		        <li><a href=""><c:out value="${AcountHeader}"></c:out></a></li>
		        <li><a href="dangnhap/">ĐĂNG NHẬP</a></li>
		        <li><a href="dangnhap/">ĐĂNG XUẤT</a></li>
		        <li id ="li-giohangsanpham"><a href="#" ><img src='<c:url value ="/resources/image/shoppingcart-icon.png"/>'/>
		        
		        <div id="circle-giohang-div" class="circle-giohang"><span id="circle-giohang-span">${soluongAll}</span></div>
		        
		        </a></li>
		      </ul>
		    </div><!-- /.navbar-collapse -->
		  </div><!-- /.container-fluid -->
		</nav>
	</div >
	
<div class="container">
	<div class="row">
		<div style="padding-top: 20px" class="col-md-6 col-sm-12" >
		<h3>Danh sách sản phẩm trong giỏ hàng</h3>
		<table class="table" border="1">
			<thead>
					<tr>
						<td>Tên sản phẩm</td>
						<td>Màu sản phẩm</td>
						<td>Size sản phẩm</td>
						<td>Số lượng</td>
						<td>Giá tiền</td>
						<td>Xóa</td>
					</tr>
			</thead>
				<tbody>
					<c:forEach var="value" items="${giohang}">
						<tr>
							<td class="tensanpham" >${value.getTensanpham()}</td>
							<td class="mau" data-mamau = "${value.getMamau()}">${value.getTenmau()}</td>
							<td class="size" data-masize = "${value.getMasize()}">${value.getTensize()}</td>
							<td class="soluong"><input class="soluong-giohang" min="1" type="number" value="${value.getSoluong()}"/></td>
							<td class="giatien" value-giatien="${value.getGiatien()}">${value.getGiatien()}</td>
							<td class="btn btn-danger">Xóa</td>
						</tr>				
					</c:forEach>
				</tbody>
			</table>
			<h4>Tổng tiền : <span id="tongtiengiohangChange" class="tongtiengiohang" style="color: red">1,500,000 VNĐ</span></h4>
		</div>
		<div class="col-md-6 col-sm-12" style="border-left: 1px solid green">
			<h3>Thông tin người mua</h3>
			 <div class="form-group">
			 <form action="">
				  <label for="tennguoi">Tên người mua/nhận</label>
				  <input type="text" class="form-control" id="tenguoimua" placeholder="Tên người mua"><br/>
				  
				  <label for="dienthoailienlac">Điện thoại liên lạc</label> 
				  <input type="text" class="form-control" id="tenguoimua" placeholder="TĐiện thoại liên lạc">
				  
		 		  <div class="radio">
				 	 <label><input type="radio" name="rdhinhthuc" checked>Giao hàng tận nơi</label>
				  </div>
				  <div class="radio">
					  <label><input type="radio" name="rdhinhthuc">Nhận hàng tại cửa hàng</label>
				  </div>
				  
				  <label for="diachi">Địa chỉ nhận hàng</label>
				  <input type="text" class="form-control" id="diachi" placeholder="Tên người mua"><br/>
				  
				  <label for="ghichu">Ghi chú:</label>
				  <textarea class="form-control" rows="5" id="ghichu"></textarea><br/>
				  
				  <button type="submit" class="btn btn-primary">Đặt hàng</button>
			  </form>
			</div>
		</div>
	</div>
</div>
	
	<div id = "footer" class="container-fluid">
		<div class="row">
			<div class="col-sm-4 col-md-4">
				<p><span class="title-footer">THÔNG TIN SHOP</span></p>
				<span>Yale là một thương hiệu thời trang đầy uy tín, luôn đảm bảo chất lượng sản phẩm tốt nhất cho khách hàng</span>
			</div>
			<div class="col-sm-4 col-md-4">
				<p><span class="title-footer">LIÊN HỆ</span></p>
				<span >11/389 ,đường Cổ Nhuế , phường Cổ Nhuế 1, quận Từ Liêm, TP. Hà Nội</span><br/>
				<span>Lê Hồng Hiếu</span><br/>
				<span>0167-401-330</span>
			</div>
			<div class="col-sm-4 col-md-4">
				<p><span class="title-footer">GÓP Ý</span></p>
				<form action="" method="post">
					<input class="footer-textinput" type="text" placeholder="Email" name="name">
					<textarea class="footer-textinput"	 rows="4" cols="50" placeholder="Nội dung" name="age"></textarea>
					<button class="button-footer">ĐỒNG Ý</button>
				</form>
				
			</div>
		</div>
	</div>
</body>
<jsp:include page="footer.jsp"></jsp:include>
</html>