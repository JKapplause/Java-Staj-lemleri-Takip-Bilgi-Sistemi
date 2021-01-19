$(document).ready(function() {
	
	getOgrenci();

});

function getOgrenci() {
	$("#ogrenci_no").attr("disabled", true);
	$("#ogrenci_adi").attr("disabled", true);
	$("#ogrenci_soyadi").attr("disabled", true);
	$("#ogrenci_email").attr("disabled", true);
	$("#ogrenci_telefon").attr("disabled", true);
	$("#ogrenci_date").attr("disabled", true);
	$("#ogrenci_memleket").attr("disabled", true);
	$("#ogrenci_fakulte").attr("disabled", true);
	$("#ogrenci_bolum").attr("disabled", true);
	$("#ogrenci_cinsiyet").attr("disabled", true);
	$("#ogrenci_content").attr("disabled", true);
	
	$("#updateBtn").html("Guncelle");
	
	
	
	$.ajax({
		type:"GET",
		url:'getOgrenci/'+$("#id").val(),
		contentType: 'text/plain',
		success:function(data){
			var date = new Date(data.dogum_tarihi);
			 
		    var day = ("0" + date.getDate()).slice(-2);
		    var month = ("0" + (date.getMonth() + 1)).slice(-2);

		    var dogum_tarihi = date.getFullYear()+"-"+(month)+"-"+(day) ;
			$("#ogrenci_no").val(data.ogrenci_no);
			$("#ogrenci_adi").val(data.adi);
			$("#ogrenci_soyadi").val(data.soyadi);
			$("#ogrenci_email").val(data.email);
			$("#ogrenci_telefon").val(data.telefon);
			$("#ogrenci_date").val(dogum_tarihi);
			$("#ogrenci_memleket").val(data.memleket);
			$("#ogrenci_fakulte").val(data.fakulte);
			$("#ogrenci_bolum").val(data.bolum);
			$("#ogrenci_cinsiyet").val(data.cinsiyet);
			$("#ogrenci_content").html(data.content);
		},error:function(data){
			alert(data);
		}
	});
}

var updatem = false;
function update() {
	if(!updatem) {
	$("#ogrenci_no").attr("disabled", false);
	$("#ogrenci_adi").attr("disabled", false);
	$("#ogrenci_soyadi").attr("disabled", false);
	$("#ogrenci_email").attr("disabled", false);
	$("#ogrenci_telefon").attr("disabled", false);
	$("#ogrenci_date").attr("disabled", false);
	$("#ogrenci_memleket").attr("disabled", false);
	$("#ogrenci_fakulte").attr("disabled", false);
	$("#ogrenci_bolum").attr("disabled", false);
	$("#ogrenci_cinsiyet").attr("disabled", false);
	$("#ogrenci_content").attr("disabled", false);
	
	$("#updateBtn").html("Kaydet");
	updatem = true;
	
	}else {
		ogrenciGuncelle();
		updatem = false;
	}
}

function ogrenciGuncelle(){
	
	var param = { 
			id:$("#id").val(),
			ogrenci_no:Number($("#ogrenci_no").val()),
			adi:$("#ogrenci_adi").val(),
			soyadi:$("#ogrenci_soyadi").val(),
			email:$("#ogrenci_email").val(),
			telefon:$("#ogrenci_telefon").val(),
			dogum_tarihi:$("#ogrenci_date").val(),
			memleket:$("#ogrenci_memleket").val(),
			fakulte:$("#ogrenci_fakulte").val(),
			bolum:$("#ogrenci_bolum").val(),
			cinsiyet:$("#ogrenci_cinsiyet").val(),
			content:$("#ogrenci_content").val()
	}
	
	var ser_data = JSON.stringify(param);
	$.ajax({
		type:"PUT",
		contentType: 'application/json; charset=UTF-8',
		url:'./../ogrenciGuncelle',
		data: ser_data,
		success:function(data) {
			alert(data);
			getOgrenci();
		},error:function(data) {
			alert(data);
		}
	});
}

function deleteOgrenci(){	
	var param = { 
			id:$("#id").val(),
			
	}
	
	var ser_data = JSON.stringify(param);
	$.ajax({
		type:"DELETE",
		contentType: 'application/json; charset=UTF-8',
		url:'./../deleteOgrenci',
		data: ser_data,
		success:function(data) {
			alert(data);
			window.history.back();
		},error:function(data) {
			alert(data);
		}
	});
}















