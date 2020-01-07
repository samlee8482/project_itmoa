<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>About Us | Impact By Distinctive Themes</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/pe-icons.css" rel="stylesheet">
    <link href="css/prettyPhoto.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
    <script src="js/jquery.js"></script>
    <link rel="shortcut icon" href="images/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144x144.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114x114.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/images/ico/apple-touch-icon-72x72.png">
    <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57x57.png">
    
    
	<script type="text/javascript">
	    jQuery(document).ready(function($){
	    'use strict';
	        jQuery('body').backstretch([
	            "http://placehold.it/800x600",
	            "http://placehold.it/800x600",
	            "http://placehold.it/800x600"
	        ], {duration: 5000, fade: 500});
	
	        $("#mapwrapper").gMap({ controls: false,
	            scrollwheel: false,
	            markers: [{
	                latitude:40.7566,
	                longitude: -73.9863,
	            icon: { image: "images/marker.png",
	                iconsize: [44,44],
	                iconanchor: [12,46],
	                infowindowanchor: [12, 0] } }],
	            icon: {
	                image: "images/marker.png",
	                iconsize: [26, 46],
	                iconanchor: [12, 46],
	                infowindowanchor: [12, 0] },
	            latitude:40.7566,
	            longitude: -73.9863,
	            zoom: 14 });
	        
	    });
	</script>
</head>
<body>



	<!-- TopMenu -->
	<jsp:include page="topMenu.jsp"/>

	<!-- Header Section -->
	 <section id="single-page-slider" class="no-margin">
	        <div class="carousel slide" data-ride="carousel">
	            <div class="carousel-inner">
	                <div class="item active">
	                    <div class="container">
	                        <div class="row">
	                            <div class="col-md-12">
	                                <div class="center gap fade-down section-heading">
	                                    <h2 class="main-title">학원 검색</h2>
	                                    <hr>
	                                    <p>틀만 잡아 놨다네</p>
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	                </div><!--/.item-->
	            </div><!--/.carousel-inner-->
	        </div><!--/.carousel-->
	    </section><!--/#main-slider-->
	    
	    
	    
	    
	    
	    
	<!-- 본문 영역 -->
    <div id="content-wrapper">
        <section id="blog" class="white">
            <div class="container">
            <div class="gap"></div>
                <div class="row">
                
                
                    <aside class="col-sm-4 col-sm-push-8">
                        <div class="widget search">
                           
                           <!-- 본문 상단 영역 -->
                           
                        </div><!--/.search-->
                    </aside>
                    
                   
                    <div class="col-sm-8 col-sm-pull-4">
                        <div class="blog">
                        	
                        	<!-- 본문 메인 영역 -->
                        	
                        	
	                    </div><!--/.blog-item-->
	       
                    </div><!--/.col-md-8-->
                </div><!--/.row-->
            </div>
        </section><!--/#blog-->
    </div>
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.prettyPhoto.js"></script>
    <script src="js/plugins.js"></script>
    <script src="js/init.js"></script>
</body>
</html>