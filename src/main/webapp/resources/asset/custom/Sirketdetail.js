$(document).ready(function() {
	
	getSirket();

});

function getSirket() {
	$("#sirket_adi").attr("disabled", true);
	$("#adres").attr("disabled", true);
	$("#sehir").attr("disabled", true);
	$("#webiste").attr("disabled", true);

	
	
	$("#updateBtn").html("Guncelle Sirket");
	
	
	
	$.ajax({
		type:"GET",
		url:'getSirket/'+$("#id").val(),
		contentType: 'text/plain',
		success:function(data){
		
		
			$("#sirket_adi").val(data.sirket_adi);
			$("#adres").val(data.adres);
			$("#sehir").val(data.sehir);
			$("#website").val(data.website);
			
		},error:function(data){
			alert(data);
		}
	});
}

var updatem = false;
function update() {
	if(!updatem) {
	$("#sirket_adi").attr("disabled", false);
	$("#adres").attr("disabled", false);
	$("#sehir").attr("disabled", false);
	$("#website").attr("disabled", false);
	
	
	$("#updateBtn").html("Kaydet");
	updatem = true;
	
	}else {
		sirketGuncelle();
		updatem = false;
	}
}

function sirketGuncelle(){
	
	var param = { 
			id:$("#id").val(),
			sirket_adi:$("#sirket_adi").val(),
			adres:$("#adres").val(),
			sehir:$("#sehir").val(),
			website:$("#website").val(),
			
	}
	
	var ser_data = JSON.stringify(param);
	$.ajax({
		type:"PUT",
		contentType: 'application/json; charset=UTF-8',
		url:'./../sirketGuncelle',
		data: ser_data,
		success:function(data) {
			alert(data);
			getSirket();
		},error:function(data) {
			alert(data);
		}
	});
}

function deleteSirket(){	
	var param = { 
			id:$("#id").val(),
			
	}
	
	var ser_data = JSON.stringify(param);
	$.ajax({
		type:"DELETE",
		contentType: 'application/json; charset=UTF-8',
		url:'./../deleteSirket',
		data: ser_data,
		success:function(data) {
			alert(data);
			window.history.back();
		},error:function(data) {
			alert(data);
		}
	});
}