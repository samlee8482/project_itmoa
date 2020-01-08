<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
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
</head><!--/head-->
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
                                    <h2 class="main-title">IT News</h2>
                                    <hr>
                                    <p>글 글 글 글 글 글 글 글 글</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div><!--/.item-->
            </div><!--/.carousel-inner-->
        </div><!--/.carousel-->
    </section><!--/#main-slider-->

    <div id="content-wrapper">
        <section id="blog" class="white">
            <div class="container">
            <div class="gap"></div>
                <div class="row">
                    <aside class="col-sm-4 col-sm-push-8">
                        <div class="widget search">
                            <form role="frm" method="get" action="/Project_itmoa/user/newsList.do">
                                <div class="input-group">
	                               	<div style="width: 100%">
	                               		<select name="option_news">
		                               		<option value="1">뉴스 제목</option>
		                               		<option value="2">뉴스 내용</option>
	                               		</select>	                                	
	                               	</div>
	                            </div>
                                <div class="input-group">
                                	 <input type="text" name="keyword" class="form-control" autocomplete="off" value="${param.keyword }" placeholder="Search">
                                    <span class="input-group-btn">
                                        <button class="btn btn-primary btn-outlined" type="submit" onclick="chkSubmit()"><i class="fa fa-search"></i></button>
                                    </span>
                                </div>
                            </form>
                        </div><!--/.search-->
                     

                    </aside>
                    <div class="col-sm-8 col-sm-pull-4">
                        <div class="blog">
                        	<c:forEach var="dto" items="${newsList }">
	                            <div class="blog-item">
	                                <div class="blog-featured-image">
	                                    <img class="img-responsive img-blog" src="http://www.itworld.co.kr/${dto.news_brd_img }" alt="" />
	                                    <div class="overlay">
	                                        <a class="preview btn btn-outlined btn-primary" href="/Project_itmoa/user/newsView.do?news_brd_uid=${dto.news_brd_uid }" rel="prettyPhoto"><i class="fa fa-link"></i></a>
	                                    </div>
	                                </div>
	                                <div class="blog-content">
	                                <a href="/Project_itmoa/user/newsView.do?news_brd_uid=${dto.news_brd_uid }"><h3 class="main-title">${dto.news_brd_title }</h3></a>
	                                    <div class="entry-meta">
	                                        <span><i class="fa fa-user"></i> <a href="#"> ${dto.news_brd_viewcnt }</a></span>
	                                    </div>
	                                    
	                                    <p>${dto.news_brd_content }</p>
	                                    <div class="read-more-wrapper">
	                                        <a class="btn btn-outlined btn-primary" href="/Project_itmoa/user/newsView.do?news_brd_uid=${dto.news_brd_uid }">Read More</a>
	                                    </div>
	                                </div>
	                            </div><!--/.blog-item-->
	                    	</c:forEach>
                        </div>
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
    