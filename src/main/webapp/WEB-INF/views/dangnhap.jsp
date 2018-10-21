<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<title>Insert title here</title>
<jsp:include page="header.jsp"></jsp:include>
</head>
<body id="body-login">
	<div id="body-flex-login">
		<div id="container-login">
			<div id="container-login-left">
				<div id="heder-left" class="heder-login">
					<span id="text-logo">Welcome</span><br/>
					<span id="hint-text-logo">Hãy tạo nên phong cách của bạn cùng YaleShop</span>
				</div>
				<div id="header-botton-left">
					<p><span>Luôn cập nhật xu hướng thời gian mới nhất</span></p>
					<p><span>giảm 50% tất cả các mặt hàng giành cho khách víp</span></p>
					<p><span>Tận tình để tạo nên phong cách của bạn</span></p>
				</div>
				
			</div>
			<div id="container-login-right">
			
				<c:set var="active1" value=""/>
				<c:set var="active2" value="active"/>
				<c:set var="display1" value=""/>
				<c:set var="display2" value="display: none"/>
				
			
				<c:choose>
					<c:when test="${kiemtradangnhapemail != null || kiemtradangnhapmatkhau != null}">
 						<c:set var="active1" value="active"/>
						<c:set var="active2" value=""/> 
						<c:set var="display1" value="display: none"/>
						<c:set var="display2" value=""/>
					</c:when>
				</c:choose>
	
				
				<div id="header-top-right" class="heder-login">
					<span class="${active2}" id="dangnhap">Đăng nhập</span><span> / </span><span class="${active1}"  id="dangky">Đăng ký</span>
				</div>
				<div id="container-center-login-right">
					
					<div id="container-login-center-login-right" style="${display1}">
						<!-- <form action="" method="post"> -->
						<span style="color: red;"><c:out value="${dangkythanhcong}"></c:out></span>
						<input id = "email" class="material-textinput" type="text" name="email" placeholder="Email"/><br/>
						<input id ="matkhau" class="material-textinput" type="password" name="matkhau" placeholder="Mật khẩu"/><br/>
						<input id ="btnDangnhap" class="material-primary-button" type="submit" value="ĐĂNG NHẬP"/>
					</div>
					<div id="container-singup-login-center-login-right" style="${display2}">
						<form action="" method="post"> 
							<input id = "tendangnhapdangky" class="material-textinput" type="text" name="emaildangky" placeholder="Email"/><br/>
							<span style="color: red;"><c:out value="${kiemtradangnhapemail}"></c:out></span>
							<input id ="matkhaudangky" class="material-textinput" type="password" name="matkhaudangky" placeholder="Mật khẩu"/><br/>
							<input id ="nhaplaimatkhau" class="material-textinput" type="password" name="nhaplaimatkhau" placeholder="Nhập lại Mật khẩu"/><br/>
							<span style="color: red;"><c:out value="${kiemtradangnhapmatkhau}"></c:out></span>
							<input id ="btnDangky" class="material-primary-button" type="submit" value="ĐĂNG KÝ"/>
						</form>
					</div>
				</div>
				<div id="container-social-login">
					<img alt="icon-oval" src='<c:url value = "/resources/image/google-logo.png"/>' style="width: 50px;height: 50px;"/>
					<img alt="icon-ova" src='<c:url value = "/resources/image/facebook-logo.png"/>' style="width: 50px;height: 50px;"/>
				</div>
				<div id="ketqua"></div>
				
			</div>
		</div>
	</div>
	
</body>
<jsp:include page="footer.jsp"></jsp:include>
</html>