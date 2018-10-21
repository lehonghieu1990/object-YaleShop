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
	<div id = "header" class="container-fluid ">
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
		        <li><a href="#" ><img src='<c:url value ="/resources/image/shoppingcart-icon.png"/>'/><div id="circle-giohang-div" class="circle-giohang"><span id="circle-giohang-span">${soluongAll}</span></div></a></li>
		      	
		      </ul>
		    </div><!-- /.navbar-collapse -->
		  </div><!-- /.container-fluid -->
		</nav>
		
		<div class="event-header container wow bounceInRight">
			<span>Ngày 20/3/2018 - 18/10/2018</span><br/>
			<span style="font-size: 50px;">MUA 1 TẶNG 1</span><br/>
			<button>XEM NGAY</button>
		</div>
	</div >
	
	<div id = "info" class = "container-fluid">
		<div class="row">
			<div class="col-md-4 wow fadeInLeft" data-wow-duration="1s">
				<img class = "icon" src='<c:url value ="/resources/image/chatluong-icon.png"/>'/><br/>
				<span style="font-size: 32px; font-weight: 600">CHẤT LƯỢNG</span><br/>
				<span>Chúng tôi cam kết sẽ mang đến cho bạn chất lượng sản phẩm tốt nhất</span>
			</div>
			<div class="col-md-4 wow fadeInDown" data-wow-duration="1s" data-wow-delay = "1s">
				<img class = "icon" src='<c:url value ="/resources/image/tietkiem-icon.png"/>'/><br/>
				<span style="font-size: 32px; font-weight: 600">TIẾT KIỆM CHI PHÍ</span><br/>
				<span>Chúng tôi cam kết giá rẻ nhất Việt Nam giúp các bạn tiết kiệm hơn 20% trên từng sản phẩm</span>
			</div>
			<div class="col-md-4 wow fadeInRight" data-wow-duration="1s" data-wow-delay = "1s">
				<img class = "icon" src='<c:url value ="/resources/image/giaohang-icon.png"/>'/><br/>
				<span style="font-size: 32px; font-weight: 600">GIAO HÀNG</span><br/>
				<span>Chúng tôi cam kết giao hàng tận nơi trong ngày. Đê mang sản phẩm đến cho khách hàng nhanh nhất </span>
			</div>
		</div>
	</div>
		
	<div id = "title-sanpham" class="container">
		<span>SẢN PHẨM HOT</span>
		<div class="row" style="margin-top: 42px;">
			<c:forEach var="sanpham" items="${listSanpham}">
				<div class="col-md-3 col-sm-6">
					 <a href="chitiet/${sanpham.getId()}"> 
						<div class="sanpham">
							<img style="width: 183px; height: 275px;" src='<c:url value ="/resources/image/sanpham/${sanpham.getHinhsanpham()}"/>'/><br/>
							<span>${sanpham.getId()}</span><br/>
							<span>${sanpham.getTensanpham()}</span><br/>
							<span class="gia">${sanpham.getGiatien()}</span>
						</div>
					 </a> 
					
				</div>
			</c:forEach>
		</div>
	</div>
<div class="container">
    <div class="row">
        <div class="col-lg-6 offset-lg-3 py-5 border d-flex" id = "phantrangTrangchu">
            <ul class="pagination mx-auto">
            	<c:set var="page" value="1"/>
            	<c:set var="pageView" value="${pageView}"/>
            	<c:set var="pagePrevious" value="${pageView - 1}"/>
            	<c:set var="pageNext" value="${pageView + 1}"/>
            	 <c:choose>
            	 	 <c:when test="${pageView <= 1}">
            			<c:set var="pagePrevious" value="1"/>
            			<c:set var="pageNext" value="${pageView + 1}"/>
            		 </c:when>
            		 <c:when test="${pageView >= pageAll}">
            			<c:set var="pagePrevious" value="${pageView - 1}"/>
            			<c:set var="pageNext" value="${pageAll}"/>
            		 </c:when>
            		  
            		<%-- <c:when test="${pageView > 1 || pageView < pageAll}">
            			<c:set var="pagePrevious" value="${pageView - 1}"/>
            			<c:set var="pageNext" value="${pageView + 1}"/>
            		</c:when> --%>
            		<%-- <c:when test="${pageView < pageAll}">
            			<c:set var="pagePrevious" value="${pageView}"/>
            			<c:set var="pageNext" value="${pageView + 1}"/>
            		</c:when> --%>
            	</c:choose>
            	
                <li class="page-item ">
                    <a class="page-link" href="pageIndex?page=${pagePrevious}" aria-label="Previous">
                        <span aria-hidden="true">«</span>
                    </a>
                </li>

                <c:forEach begin="${page}" end="${pageAll}">
                	   	<li id = "pagetion" class="page-item"><a class="page-link" href="pageIndex?page=${page}">${page}</a></li>
                	<c:set var="page" value="${page + 1}"/>
                </c:forEach>
                <li class="page-item">
                    <a class="page-link" href="pageIndex?page=${pageNext}" aria-label="Next">
                        <span aria-hidden="true">»</span>
                     </a>
                </li>
            </ul>
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