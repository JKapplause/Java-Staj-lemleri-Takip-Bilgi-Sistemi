function degerlendirmeekle(){
	var param = { 
			id:Number($("#ogrenci_no").val()),
	}
	var ser_data = JSON.stringify(param);
	$.ajax({
		type:"POST",
		contentType: 'application/json; charset=UTF-8',
		url:'contrologrenci',
		data: ser_data,
		success:function(data) {
			if(data == "ERROR"){
				alert("Boyle bir ogrenci bulunmamakta.")
			}else if(data == "OK"){
				alert("Sirket Kaydedildi");
				ikinciFonksiyon();
			}
		},error:function(data) {
			alert(data);
		}
	});
	
}

function ikinciFonksiyon(){
	
	var param = { 
			ogrenci_id:Number($("#ogrenci_no").val()),
			staj_puanı:$("#staj_puanı").val(),
			ise_devam:$("#ise_devam").val(),
			staj_yorumu:$("#staj_yorumu").val(),		
	}
	
	var ser_data = JSON.stringify(param);
	$.ajax({
		type:"POST",
		contentType: 'application/json; charset=UTF-8',
		url:'degerlendirmeekle',
		data: ser_data,
		success:function(data) {
			alert(data);
		},error:function(data) {
			alert(data);
		}
	});
	
}