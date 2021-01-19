function ogrencino(){
	
	var param = { 
			
	}
	
	var ser_data = JSON.stringify(param);
	$.ajax({
		type:"GET",
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

