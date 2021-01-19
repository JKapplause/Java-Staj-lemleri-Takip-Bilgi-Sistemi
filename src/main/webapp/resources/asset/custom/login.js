function loginBtn2(){
	
	var param = { 
			ogrenci_no:Number($("#username2").val()),
			sifre:$("#pass2").val()
		
	}
	alert(param.ogrenci_no + " " + param.sifre());
	var ser_data = JSON.stringify(param);
	$.ajax({
		type:"POST",
		contentType: 'application/json; charset=UTF-8',
		url:'ogrenciKontrol',
		data: ser_data,
		success:function(data) {
			 if(data == 'OK'){
				$(location).attr('href', 'index')
			}else if(data == 'ERROR') {
				alert("Kullanici Adi ve Sifrenizi Kontrol Ediniz!.");
			}
			
		},error:function(data) {
			alert(data);
		}
	});
}

function loginBtn(){
	var param = { 
			username:$("#username").val(),
			password:$("#pass").val()
		
	}
	
	var ser_data = JSON.stringify(param);
	$.ajax({
		type:"POST",
		contentType: 'application/json; charset=UTF-8',
		url:'controlUser',
		data: ser_data,
		success:function(data) {
			 if(data == 'OK'){
				$(location).attr('href', 'index')
			}else if(data == 'ERROR') {
				alert("Kullanici Adi ve Sifrenizi Kontrol Ediniz!.");
			}
			
		},error:function(data) {
			alert(data);
		}
	});
	
}
