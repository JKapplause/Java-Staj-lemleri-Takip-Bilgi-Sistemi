function ogrenciekle(){
	
	var param = { 
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
		type:"POST",
		contentType: 'application/json; charset=UTF-8',
		url:'ogrenciekle',
		data: ser_data,
		success:function(data) {
			alert(data);
		},error:function(data) {
			alert(data);
		}
	});
	
}

