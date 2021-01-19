$(document).ready(function() {
	
	getStaj();

});

function getStaj() {
	$("#staj_birimi").attr("disabled", true);
	$("#staj_baslama").attr("disabled", true);
	$("#staj_bitis").attr("disabled", true);
	
	
	
	$("#updateBtn").html("Guncelle Staj");
	
	
	
	$.ajax({
		type:"GET",
		url:'getStaj/'+$("#id").val(),
		contentType: 'text/plain',
		success:function(data){
			var date = new Date(data.staj_baslama);
			 
		    var day = ("0" + date.getDate()).slice(-2);
		    var month = ("0" + (date.getMonth() + 1)).slice(-2);

		    var staj_baslama = date.getFullYear()+"-"+(month)+"-"+(day) ;
		    
		    var date2 = new Date(data.staj_bitis);
			 
		    var day2 = ("0" + date2.getDate()).slice(-2);
		    var month2 = ("0" + (date2.getMonth() + 1)).slice(-2);

		    var staj_bitis = date2.getFullYear()+"-"+(month2)+"-"+(day2) ;
		
			$("#staj_birimi").val(data.staj_birimi);
			$("#staj_baslama").val(staj_baslama);
			$("#staj_bitis").val(staj_bitis);
		
		},error:function(data){
			alert(data);
		}
	});
}

var updatem = false;
function update() {
	if(!updatem) {
	$("#staj_birimi").attr("disabled", false);
	$("#staj_baslama").attr("disabled", false);
	$("#staj_bitis").attr("disabled", false);
	
	
	$("#updateBtn").html("Kaydet");
	updatem = true;
	
	}else {
		stajGuncelle();
		updatem = false;
	}
}

function stajGuncelle(){
	
	var param = { 
			id:$("#id").val(),
			staj_birimi:$("#staj_birimi").val(),
			staj_baslama:$("#staj_baslama").val(),
			staj_bitis:$("#staj_bitis").val(),
		
			
	}
	
	var ser_data = JSON.stringify(param);
	$.ajax({
		type:"PUT",
		contentType: 'application/json; charset=UTF-8',
		url:'./../stajGuncelle',
		data: ser_data,
		success:function(data) {
			alert(data);
			getStaj();
		},error:function(data) {
			alert(data);
		}
	});
}

function deleteStaj(){	
	var param = { 
			id:$("#id").val(),
			
	}
	
	var ser_data = JSON.stringify(param);
	$.ajax({
		type:"DELETE",
		contentType: 'application/json; charset=UTF-8',
		url:'./../deleteStaj',
		data: ser_data,
		success:function(data) {
			alert(data);
			window.history.back();
		},error:function(data) {
			alert(data);
		}
	});
}