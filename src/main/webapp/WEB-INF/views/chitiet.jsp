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
		      <a class="navbar-brand" href="#"><img src='<c:url value ="/resource/image/logo-minishop.jpg"/>'/></a>
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
	<div class="row" style="margin-top: 16px">
		<div class="col-sm-2 col-md-2">
			<h3>Danh mục</h3>
			<ul class="myMenu">
				<c:forEach var="danhmucsanpham" items="${listDanhmucsanpham}">
					<li><a href="#">${danhmucsanpham.getTendanhmuc()}</a></li>
				</c:forEach>
			</ul>
		</div>
		
		<div class="col-sm-8 col-md-8">
			<div class="row">
				<div class="col-sm-4 col-md-4">
				 	<img style="height: 300px" src='<c:url value ="/resources/image/sanpham/${sanpham.getHinhsanpham()}"/>'/>
				</div>
				<div class="col-sm-8 col-md-8">
					<h3 id = "tensanpham"  data-masanpham="${sanpham.getId()}">${sanpham.getTensanpham()}</h3>
					<h4 id="giatien" data-giatien="${sanpham.getGiatien()}" style="color: red">${sanpham.getGiatien()} VND</h4>
						<table class="table">
						<c:set var="count" value="0"></c:set>
							<thead>
								<tr style="text-align: center; font-weight: 700; color: blue">
									<td><h5 style="text-align: color: blue">#</h5></td>
									<td><h5>Tên màu</h5></td>
									<td><h5>Tên size</h5></td>
									<td><h5>Số lượng</h5></td>
									<td><h5>Action</h5></td>
								</tr>
							</thead>
							<tbody style="text-align: center;">
								<c:forEach var="chitietsanpham" items="${sanpham.getChitietsanpham()}">
									<c:set var="count" value="${count + 1}"></c:set>
									<tr>
										<td>${count}</td>
										<td class="mau" data-mamau="${chitietsanpham.getMausanpham().getId()}">${chitietsanpham.getMausanpham().getTenmau()}</td>
										<td class="size" data-masize="${chitietsanpham.getSizesanpham().getId()}">${chitietsanpham.getSizesanpham().getTenkichthuoc()}</td>
										<td class="soluong" >${chitietsanpham.getSoluong()}</td>
										<td><button class="btn btn-success btn-giohang">giỏ hàng</button></td>
									</tr>
								</c:forEach>
								
							</tbody>
						</table>
				</div>
			</div>
			
		</div>
		<div class="col-sm-2 col-md-2">
			<span>
			</span>
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