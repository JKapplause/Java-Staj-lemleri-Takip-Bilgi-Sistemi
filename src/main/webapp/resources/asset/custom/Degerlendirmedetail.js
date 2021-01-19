$(document).ready(function() {
	
	getDegerlendirme();

});

function getDegerlendirme() {
	$("#staj_puanı").attr("disabled", true);
	$("#ise_devam").attr("disabled", true);
	$("#staj_yorumu").attr("disabled", true);
	

	
	
	$("#updateBtn").html("Guncelle Degerlendirme");
	
	
	
	$.ajax({
		type:"GET",
		url:'getDegerlendirme/'+$("#id").val(),
		contentType: 'text/plain',
		success:function(data){
		
		
			$("#staj_puanı").val(data.staj_puanı);
			$("#ise_devam").val(data.ise_devam);
			$("#staj_yorumu").val(data.staj_yorumu);
		
			
		},error:function(data){
			alert(data);
		}
	});
}

var updatem = false;
function update() {
	if(!updatem) {
	$("#staj_puanı").attr("disabled", false);
	$("#ise_devam").attr("disabled", false);
	$("#staj_yorumu").attr("disabled", false);
	
	
	$("#updateBtn").html("Kaydet");
	updatem = true;
	
	}else {
		degerlendirmeGuncelle();
		updatem = false;
	}
}

function degerlendirmeGuncelle(){
	
	var param = { 
			id:$("#id").val(),
			staj_puanı:$("#staj_puanı").val(),
			ise_devam:$("#ise_devam").val(),
			staj_yorumu:$("#staj_yorumu").val(),
			
			
	}
	
	var ser_data = JSON.stringify(param);
	$.ajax({
		type:"PUT",
		contentType: 'application/json; charset=UTF-8',
		url:'./../degerlendirmeGuncelle',
		data: ser_data,
		success:function(data) {
			alert(data);
			getDegerlendirme();
		},error:function(data) {
			alert(data);
		}
	});
}

function deleteDegerlendirme(){	
	var param = { 
			id:$("#id").val(),
			
	}
	
	var ser_data = JSON.stringify(param);
	$.ajax({
		type:"DELETE",
		contentType: 'application/json; charset=UTF-8',
		url:'./../deleteDegerlendirme',
		data: ser_data,
		success:function(data) {
			alert(data);
			window.history.back();
		},error:function(data) {
			alert(data);
		}
	});
}