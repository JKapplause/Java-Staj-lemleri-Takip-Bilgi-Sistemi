<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<style>
    
    .body {
        background-color: white;
        font-family: serif;
    }
    div.w3-col {
        margin: calc;
    }
    div.w3-row {
        width: 500px;
        margin: auto;
      
    }
    

   
    
    textarea {
  width: 100%;
  height: 150px;
  padding: 12px 20px;
  box-sizing: border-box;
  border: 2px solid #ccc;
  border-radius: 4px;
  background-color: #f8f8f8;
  font-size: 16px;
  resize: none;
}

.w3-container {
    margin: auto;

    
}



.h1 {
    text-align:center;
    font-family: 'Brush Script MT', cursive;
}
.w3-button {
    border-radius: 20px;
}



</style>


<!DOCTYPE html>

	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>BLOG</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="açıklama" />
	<meta name="keywords" content="arama kelimeleri" />
	<meta name="author" content="İsmail Ekin" />


	<!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
	<link rel="shortcut icon" href="./../favicon.ico">
	<!-- Google Fonts -->
	<link href='http://fonts.googleapis.com/css?family=Playfair+Display:400,700,400italic|Roboto:400,300,700' rel='stylesheet' type='text/css'>
	<!-- Animate -->
	<link rel="stylesheet" href="./../asset/css/animate.css">
	<!-- Icomoon -->
	<link rel="stylesheet" href="./../asset/css/icomoon.css">
	<!-- Bootstrap  -->
	<link rel="stylesheet" href="./../asset/css/bootstrap.css">

	<link rel="stylesheet" href="./../asset/css/style.css">


	<!-- Modernizr JS -->
	<script src="./../asset/js/modernizr-2.6.2.min.js"></script>

	</head>
	<body>
	<input type="text" hidden style="display:none" value = "${id}" id="id" />
	
	
	
	<div id="fh5co-offcanvas">
		<a href="#" class="fh5co-close-offcanvas js-fh5co-close-offcanvas"><span><i class="icon-cross3"></i> <span>Kapat</span></span></a>
		<div class="fh5co-bio">
			<figure>
				<img src="./../asset/images/person1.jpg" alt="Free HTML5 Bootstrap Template" class="img-responsive">
			</figure>
			<h3 class="heading">Hakkımda</h3>
			<h2>İsmail Ekin</h2>
			<p>Bilgisayar Mühendisiyim. Web ve Mobil uygulama geliştirmekteyim.</p>
			<ul class="fh5co-social">
				<li><a href="#"><i class="icon-twitter"></i></a></li>
				<li><a href="#"><i class="icon-facebook"></i></a></li>
				<li><a href="#"><i class="icon-instagram"></i></a></li>
			</ul>
		</div>

	</div>

	
	
	
	<header id="fh5co-header">
		
		<div class="container-fluid">

			<div class="row">
				<a href="#" class="js-fh5co-nav-toggle fh5co-nav-toggle"><i></i></a>
			
				<div class="col-lg-12 col-md-12 text-center">
					<h1 id="fh5co-logo"></h1>
				</div>

			</div>
		
		</div>

	</header>
	<!-- END #fh5co-header -->
	<div class="container-fluid">
		<div class="row fh5co-post-entry single-entry">
			<article class="col-lg-8 col-lg-offset-2 col-md-8 col-md-offset-2 col-sm-8 col-sm-offset-2 col-xs-12 col-xs-offset-0">
				
				<span class="fh5co-meta animate-box"></span>
				<h2 class="fh5co-article-title animate-box"></h2>
				<span class="fh5co-meta fh5co-date animate-box"></span>
				
				<div class="col-lg-12 col-lg-offset-0 col-md-12 col-md-offset-0 col-sm-12 col-sm-offset-0 col-xs-12 col-xs-offset-0 text-left content-article">
				
			<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <body class="body">	
				<div class="w3-row w3-section">
  <div class="w3-col" style="width:50px"><i class="w3-xxlarge fa fa-address-book"></i></div>
    <div class="w3-rest">
      <input class="w3-input w3-border" name="first" type="text" placeholder="Staj Birimi" disabled="disabled" id="staj_birimi">
    </div>
</div>

<div class="w3-row w3-section">
  <div class="w3-col" style="width:50px"><i class="w3-xxlarge fa fa-user"></i></div>
    <div class="w3-rest">
      <input class="w3-input w3-border" name="email" type="date" placeholder="Staj Baslama Tarihi" disabled="disabled" id="staj_baslama">
    </div>
</div>

<div class="w3-row w3-section">
  <div class="w3-col" style="width:50px"><i class="w3-xxlarge fa fa-user"></i></div>
    <div class="w3-rest">
      <input class="w3-input w3-border" name="phone" type="date" placeholder="Staj Bitis Tarihi" disabled="disabled" id="staj_bitis">
    </div>
</div>



<div class="w3-row w3-section">
<div class="w3-rest">
<button class="w3-button w3-block w3-section w3-green w3-ripple w3-padding"  id="updateBtn"onclick="update()">Guncelle Staj</button>
<button class="w3-button w3-block w3-section w3-red w3-ripple w3-padding" onclick="deleteStaj()">Sil Staj</button>
</div>

					</div>

				</div>
			</article>
		</div>
	</div>

	
	

	<footer id="fh5co-footer">
		<p><small>&copy; 2021.</small></p>
	</footer>
	
	<!-- jQuery -->
	<script src="./../asset/js/jquery.min.js"></script>
	<!-- jQuery Easing -->
	<script src="./../asset/js/jquery.easing.1.3.js"></script>
	<!-- Bootstrap -->
	<script src="./../asset/js/bootstrap.min.js"></script>
	<!-- Waypoints -->
	<script src="./../asset/js/jquery.waypoints.min.js"></script>
	<!-- Main JS -->
	<script src="./../asset/js/main.js"></script>
	
	<script src="./../asset/custom/Stajdetail.js"></script>
	
	

	</body>
</html>

