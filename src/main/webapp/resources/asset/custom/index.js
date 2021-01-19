$(document).ready(function() {
	
	getEkle();
	
	setInterval(function() { getEkle(); }, 3000);
		
	

});

function getEkle() {
	$.ajax({
		type:"GET",
		url:'getEkle',
		success:function(data){
			var list = ""; 
			$(data).each(function(i,val){
				var date = new Date(val.dogum_tarihi);
				list = list
				+'<article class="col-lg-3 col-md-3 col-sm-3 col-xs-6 col-xxs-12">'
				+`<h2>`+val.id+`<a href="detay/${val.id}"  style="color:#999999"><i class="icon-edit"></i></a></h2>` 
				+`<h2 class="fh5co-article-title">`+val.ogrenci_no+`</h2>`
				+'<h3 style="color:#999999">'+val.adi+'</h3>'
				+'<h3 style="color:#999999">'+val.soyadi+'</h3>'
				+'<h3 style="color:#999999">'+val.email+'</h3>'
				+'<h3 style="color:#999999">'+val.telefon+'</h3>'
				+'<h3 style="color:#999999">'+date.getDate() + "." + (date.getMonth()+1) + "." + date.getFullYear()+'</h3>'
				+'<h3 style="color:#999999">'+val.memleket+'</h3>'
				+'<h3 style="color:#999999">'+val.fakulte+'</h3>'
				+'<h3 style="color:#999999">'+val.bolum+'</h3>'
				+'<h3 style="color:#999999">'+val.cinsiyet+'</h3>'
				+'<h3 style="color:#999999">'+val.content+'</h3>'
				+'</article>'
				
			});
			$("#list").html(list);
		
		},error:function(data){
			alert(data);
		}
	});
}


// Sirket Bilgileri Goruntuleme


$(document).ready(function() {
	
	getEkle2();
	
	setTimeout(function() { getEkle2(); }, 3000);

});

function getEkle2() {
	$.ajax({
		type:"GET",
		url:'getEkle2',
		success:function(data){
			var list2 = ""; 
			$(data).each(function(i,val){
				
				list2 = list2
				+'<article class="col-lg-3 col-md-3 col-sm-3 col-xs-6 col-xxs-12">'
				+`<h2>`+val.id+`<a href="detay1/${val.id}"  style="color:#999999"><i class="icon-edit"></i></a></h2>` 
				+`<h2 class="fh5co-article-title">`+val.sirket_adi+`</h2>`
				+'<h3 style="color:#999999">'+val.adres+'</h3>'
				+'<h3 style="color:#999999">'+val.sehir+'</h3>'
				+'<h3 style="color:#999999">'+val.website+'</h3>'
				
				+'</article>'
				
			});
			$("#list2").html(list2);
		
		},error:function(data){
			alert(data);
		}
	});
}



// Staj Bilgileri Goruntuleme


$(document).ready(function() {
	
	getEkle3();
	
	setInterval(function() { getEkle3(); }, 3000);

});

function getEkle3() {
	$.ajax({
		type:"GET",
		url:'getEkle3',
		success:function(data){
			var list3 = ""; 
			$(data).each(function(i,val){
				var date = new Date(val.staj_baslama);
				var date2 = new Date(val.staj_bitis);
				list3 = list3
				
				+'<article class="col-lg-3 col-md-3 col-sm-3 col-xs-6 col-xxs-12">'
				+`<h2>`+val.id+`<a href="detay2/${val.id}"  style="color:#999999"><i class="icon-edit"></i></a></h2>` 
				+`<h2 class="fh5co-article-title">`+val.staj_birimi+`</h2>`
				+'<h3 style="color:#999999">'+date.getDate() + "." + (date.getMonth()+1) + "." + date.getFullYear()+'</h3>'
				+'<h3 style="color:#999999">'+date2.getDate() + "." + (date2.getMonth()+1) + "." + date2.getFullYear()+'</h3>'
				+'</article>'
				
			});
			$("#list3").html(list3);
		
		},error:function(data){
			alert(data);
		}
	});
}




// Staj Degerlendirm Goruntuleme

$(document).ready(function() {
	
	getEkle4();
	
	setInterval(function() { getEkle4(); }, 3000);

});

function getEkle4() {
	$.ajax({
		type:"GET",
		url:'getEkle4',
		success:function(data){
			var list4 = ""; 
			$(data).each(function(i,val){
				
				list4 = list4
				
				+'<article class="col-lg-3 col-md-3 col-sm-3 col-xs-6 col-xxs-12">'
				+`<h2>`+val.id+`<a href="detay3/${val.id}"  style="color:#999999"><i class="icon-edit"></i></a></h2>` 
				+'<h2 class="fh5co-article-title">'+val.staj_puanı+'</h2>'
				+'<h2 class="fh5co-article-title">'+val.ise_devam+'</h2>'
				+'<h2 class="fh5co-article-title">'+val.staj_yorumu+'</h2>'
				
				+'</article>'
				
			});
			$("#list4").html(list4);
		
		},error:function(data){
			alert(data);
		}
	});
}
