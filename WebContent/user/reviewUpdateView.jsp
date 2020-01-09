<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<script src="ckeditor/ckeditor.js"></script>
<script src="js/jquery.js"></script>
<link rel="shortcut icon" href="images/ico/favicon.ico">
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="images/ico/apple-touch-icon-144x144.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="images/ico/apple-touch-icon-114x114.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="images/ico/images/ico/apple-touch-icon-72x72.png">
<link rel="apple-touch-icon-precomposed"
	href="images/ico/apple-touch-icon-57x57.png">

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
<!--/head-->
<body>

	<!-- TopMenu -->
	<jsp:include page="topMenu.jsp" />


	<section id="single-page-slider" class="no-margin">
		<div class="carousel slide" data-ride="carousel">
			<div class="carousel-inner">
				<div class="item active">
					<div class="container">
						<div class="row">
							<div class="col-md-12">
								<div class="center gap fade-down section-heading">
									<h2 class="main-title">학원 후기</h2>
									<hr>
									<p>리뷰 리뷰 리뷰 리뷰 리뷰 리뷰 리뷰 리뷰</p>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!--/.item-->
			</div>
			<!--/.carousel-inner-->
		</div>
		<!--/.carousel-->
	</section>
	<!--/#main-slider-->

	<div id="content-wrapper">
		<section id="blog" class="white">
			<div class="container">
				<div class="gap"></div>
				<div class="row">
					<div class="col-sm-12">
						<div class="blog">
							<div class="blog-item">
								<div class="blog-content">
									<form method="get" action="/Project_itmoa/user/reviewUpdate.do">
										<h3 class="main-title">
											<input name="review_brd_title"
												value="${reviewUpdateView[0].review_brd_title }" />
										</h3>
										<div class="entry-meta">
											<span><i class="fa fa-user"></i> <a href="#">
													${reviewUpdateView[0].review_brd_viewcnt }</a></span>
										</div>
										<div style="padding: 30px 5px">
											<textarea name="review_brd_content" id="editor1">${reviewUpdateView[0].review_brd_content }</textarea>
											<script>
												CKEDITOR.replace('editor1', {
													allowedContent: true,
													height: '700px',
												});
											</script>
										</div>
										<input type="hidden" name="news_brd_uid"
											value="${adminNewsView[0].news_brd_uid }" /> <input
											type="hidden" name="ifNew" value="false" />
										<button type="submit"
											class="p-2 mt-3 col-xl-12 bg-primary text-white border-0 rounded">수정
											완료</button>
									</form>
								</div>
							</div>
						</div>
					</div>
					<!--/.col-md-8-->
				</div>
				<!--/.row-->
			</div>
		</section>
		<!--/#blog-->
	</div>

	<div id="footer-wrapper">
		<footer id="footer" class="">
			<div class="container">
				<div class="row">
					<div class="col-sm-8">
						&copy; 2019 Your Site Name. All Rights Reserved. <a
							href="https://templatemag.com/bootstrap-templates/">Bootstrap
							templates</a> by TemplateMag.
					</div>
					<div class="col-sm-4">
						<ul class="pull-right">
							<li><a id="gototop" class="gototop" href="#"><i
									class="fa fa-chevron-up"></i></a></li>
							<!--#gototop-->
						</ul>
					</div>
				</div>
			</div>
		</footer>
		<!--/#footer-->
	</div>

	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.prettyPhoto.js"></script>
	<script src="js/plugins.js"></script>
	<script src="js/init.js"></script>
</body>
</html>