function stajekle(){
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
				alert("Staj Kaydedildi");
				ikinciFonksiyon();
			}
		},error:function(data) {
			alert("hata cikti");
		}
	});
	
}


function ikinciFonksiyon(){
	
	var param = { 
			ogrenci_id:Number($("#ogrenci_no").val()),
			staj_birimi:$("#staj_birimi").val(),
			staj_baslama:$("#staj_baslama").val(),
			staj_bitis:$("#staj_bitis").val(),		
	}
	
	var ser_data = JSON.stringify(param);
	$.ajax({
		type:"POST",
		contentType: 'application/json; charset=UTF-8',
		url:'stajekle',
		data: ser_data,
		success:function(data) {
			alert(data);
		},error:function(data) {
			alert(data);
		}
	});
	
}