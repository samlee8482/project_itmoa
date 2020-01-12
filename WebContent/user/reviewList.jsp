<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<script src="https://kit.fontawesome.com/bb29575d31.js"></script>
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
<c:choose>
	<c:when test="${not empty sessionScope.loginUid }">
	<!-- 로그인 탑메뉴 -->
	<jsp:include page="loginTopMenu.jsp" />
	</c:when>
	<c:otherwise>
	<!-- 비회원 탑메뉴 -->
	<jsp:include page="topMenu.jsp" />
	</c:otherwise>
</c:choose> 
 
	<!-- Header Section -->
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
                            <form role="frm" method="get" action="/Project_itmoa/user/reviewList.do" onSubmit="chkSubmit()">
                                <div class="input-group">
	                               	<div style="width: 100%">
	                               		<select name="option_review">
		                               		<option value="1">회원 ID</option>
		                               		<option value="2">리뷰 제목</option>
		                               		<option value="3">리뷰 내용</option>
	                               		</select>	                                	
	                               	</div>
	                            </div>
                                <div class="input-group">
                                	<input type="text" name="keyword" class="form-control" autocomplete="off" value="${param.keyword }" placeholder="Search">
                                    <span class="input-group-btn">
                                        <button class="btn btn-primary btn-outlined" type="submit"><i class="fa fa-search"></i></button>
                                    </span>
                                </div>
                            </form>
                        </div><!--/.search-->
                     

                    </aside>
                    <div class="col-sm-8 col-sm-pull-4">
                        <div class="blog">
                        	<div class="table-responsive">
                        		<c:choose>
									<c:when test="${sessionScope.loginUid >= 2 }">
                    				<button type="button" onclick="location.href = '/Project_itmoa/user/reviewWrite.do'" style="float: right">리뷰 작성</button>
                    				</c:when>
                    			</c:choose>
								<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
									<thead>
										<tr>
											<th width="5%">No</th>
											<th width="12%">리뷰 번호</th>
											<th width="18%">작성자 아이디</th>
											<th width="20%">학원명</th>
											<th width="25%">리뷰제목</th>
											<th width="25%">리뷰작성일</th>
										</tr>
									</thead>
		                        	<c:forEach var="dto" items="${reviewList }" varStatus="status">
										<tbody>
											<tr style="background-color: #fff" onclick="location.href='/Project_itmoa/user/reviewView.do?review_brd_uid=${dto.review_brd_uid }'">
												<td>${status.index + 1 }</td>
												<td>${dto.review_brd_uid }</td>
												<td>${dto.mb_id }</td>
												<td>${dto.ins_name }</td>
												<td>${dto.review_brd_title }</td>
												<td>${dto.review_brd_regdate }</td>
											</tr>
										</tbody>
									</c:forEach>
								</table>
							</div>
							<%--페이징 --%>
							<div class="col-sm-12 col-sm-pull-1">							
								<jsp:include page="reviewListPagination.jsp">
									<jsp:param value="${writePages }" name="writePages"/>
									<jsp:param value="${totalPage }" name="totalPage"/>
									<jsp:param value="${page }" name="curPage"/>
								</jsp:include>
							</div>
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
    
    <script>
		$(document).ready(function() {
			$('tbody tr').hover(function() {
				$(this).css({
					"cursor": "pointer",
					"background-color": "#F2F2F2"
				})
			}, function() {
				$(this).css({
					"cursor": "default",
					"background-color": "#fff"
				})
			})
		})
		
		function chkSubmit() {
			var option_news_3 = $(":text[name='keyword']").val().length;
			if(option_news_3 > 0) {
				return true;
			}
			alert("검색어를 입력하세요");
			return false;
		}
	</script>
	
</body>
</html>