$(document).ready(function(){
	$("#btnDangnhap").click(function(){
		var email = $("#email").val();
		var matkhau = $("#matkhau").val();
		$.ajax({
			url:"/YaleShop/api/kiemtradangnhap",
			type:"POST",
			data:{
				email: email,
				matkhau: matkhau
			},
			success: function(value){
				if(value == "true"){
					duongdanhientai = window.location.href;
					duongdan = duongdanhientai.replace("dangnhap/","");
					window.location = duongdan;
				}else{
					$("#ketqua").append("dang nhap that bai");
				}
			}
		})
	});
	
	$("#dangnhap").click(function(){
		$(this).addClass("active");
		$("#dangky").removeClass("active");
		$("#container-login-center-login-right").show();
		$("#container-singup-login-center-login-right").hide();
	});
	
	$("#dangky").click(function(){
		$(this).addClass("active");
		$("#dangnhap").removeClass("active");
		$("#container-login-center-login-right").hide();
		$("#container-singup-login-center-login-right").show();
	});
	
	$(".btn-giohang").click(function(){
		var masanpham = $("#tensanpham").attr("data-masanpham");
		var tensanpham = $("#tensanpham").text();
		var mamau = $(this).closest("tr").find(".mau").attr("data-mamau");
		var tenmau = $(this).closest("tr").find(".mau").text();
		var masize = $(this).closest("tr").find(".size").attr("data-masize");
		var tensize = $(this).closest("tr").find(".size").text();
		var soluong = $(this).closest("tr").find(".soluong").text();
		var giatien = $("#giatien").attr("data-giatien");
		$.ajax({
			url:"/YaleShop/api/themgiohang",
			type:"POST",
			data:{
				masanpham : masanpham,
				tensanpham : tensanpham,
				mamau : mamau,
				tenmau : tenmau,
				masize : masize,
				tensize : tensize,
				soluong : soluong,
				giatien : giatien,
			},
			success: function(value){
				/*$("#circle-giohang-div").show();
				$("#circle-giohang-span").text(value);*/
				/*$("#circle-giohang-span").html("<span>" + value + "</span>");*/
				
				
			}
		}).done(function(){
			$.ajax({
				url:"/YaleShop/api/laysoluongsanpham",
				type:"GET",
				success: function(value){
					$("#circle-giohang-span").html("<span>" + value + "</span>");
					
				}
			});
		})
	});
	var tongtiengiohang = 0;
	$(".giatien").each(function(){
		var soluong = $(this).closest("tr").find(".soluong-giohang").val();
		var giatien = $(this).attr("value-giatien");
		var tongtien = soluong * parseInt(giatien);
		var format = tongtien.toFixed(3).replace(/(\d)(?=(\d{3})+\.)/g, "$1.").toString();
		$(this).html(format);
				
		tongtiengiohang = tongtiengiohang + tongtien;
		var formattonggiohang = tongtiengiohang.toFixed(3).replace(/(\d)(?=(\d{3})+\.)/g, "$1.").toString();
		$(".tongtiengiohang").html(formattonggiohang + " VND");
		
	})	
	$(".soluong-giohang").change(function(){
		var soluong = $(this).val();
		var giatien = $(this).closest("tr").find(".giatien").attr("value-giatien");
		var tongtien = soluong * parseInt(giatien);
		var format = tongtien.toFixed(3).replace(/(\d)(?=(\d{3})+\.)/g, "$1.").toString();
		$(this).closest("tr").find(".giatien").html(format);
		
		var tongtiengiohang = 0;
		$(".giatien").each(function(){
			var soluong = $(this).closest("tr").find(".soluong-giohang").val();
			var giatien = $(this).attr("value-giatien");
			var tongtien = soluong * parseInt(giatien);
			var format = tongtien.toFixed(3).replace(/(\d)(?=(\d{3})+\.)/g, "$1.").toString();
			$(this).html(format);
			tongtiengiohang = tongtiengiohang + tongtien;
			var formattonggiohang = tongtiengiohang.toFixed(3).replace(/(\d)(?=(\d{3})+\.)/g, "$1.").toString();
			$(".tongtiengiohang").html(formattonggiohang + " VND");
			
		})
	});
	

	
})