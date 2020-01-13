<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="com.lec.beans.*" %>
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
                    <div class="col-sm-12">
                        <div class="blog">
                            <div class="blog-item">
                                <div class="blog-content">
                                    <h3 class="main-title">
                                    	${reviewView[0].review_brd_title }
	                                    <c:if test="${sessionScope.loginUid == reviewView[0].mb_uid }">
                                           	<button type="button" onclick="location.href='/Project_itmoa/user/reviewUpdateView.do?review_brd_uid=${reviewView[0].review_brd_uid }'">
	                                    		후기 수정
	                                    	</button>
	                                    </c:if>
										<c:if test="${sessionScope.loginLevel == 3 || sessionScope.loginUid == reviewView[0].mb_uid }">
											<button type="button" onclick="location.href='/Project_itmoa/user/reviewDeleteOk.do?review_brd_uid=${reviewView[0].review_brd_uid }'">
	                                    		후기 삭제
	                                    	</button>
										</c:if>
                                    </h3>
                                    <div class="entry-meta">
                                        <span><i class="fa fa-user"></i> <a href="#"> ${reviewView[0].review_brd_viewcnt }</a></span>
                                    </div>
                                    <div style="padding: 30px 5px">
                                    	${reviewView[0].review_brd_content }
                                    </div>
									<hr/>
                                    <c:choose>
			    						<c:when test="${not empty sessionScope.loginUid }">
	                                    <div class="author well">
	                                        <div class="media">
	                                            <div class="pull-left">
	                                                <img class="avatar img-thumbnail author-box-image" src="http://placehold.it/400x400" alt=""> <!-- ${sessionScope.loginImg } -->
	                                            </div>
				                    				<div class="media-body">
		                                                <div class="media-heading">
		                                                    <strong>${sessionScope.loginId }</strong>
		                                                </div>
		                                                <form method="post" action="/Project_itmoa/user/repUpdateOk.do" onSubmit="chkSubmit()">
		                                                	<input type="hidden" name="ifNew" value="true" />
		                                                	<input type="hidden" name="mb_uid" value="${sessionScope.loginUid }" />
		                                                	<input type="hidden" name="review_brd_uid" value="${reviewView[0].review_brd_uid }" />
			                                                <textarea style="width: 100%; resize: none;" name="rep_content"></textarea>
			                                                <button type="submit" style="float: right">댓글 작성</button>
		                                                </form>
		                                            </div>
		                                        </div>
		                                    </div><!--/.author-->
									    </c:when>
									</c:choose>
                                    <div id="comments">
                                        <div id="comments-list">
                                            <c:choose>
	                                           	<c:when test="${rep == 1 }">
                                     				<h3>${fn:length(repView) } Comments</h3>
				                        			<c:forEach var="repList" items="${repView }" varStatus="status">
			                                            <div class="media">
			                                                <div class="pull-left">
			                                                    <img class="avatar img-thumbnail comment-avatar" src="http://placehold.it/400x400" alt="">
			                                                </div>
			                                                <div class="media-body">
			                                                    <div class="well">
			                                                    	<form method="post" action="/Project_itmoa/user/repUpdateOk.do" onSubmit="chkSubmit()" style="text-align: left">
					                                                	<input type="hidden" name="ifNew" value="false" />
					                                                	<input type="hidden" name="mb_uid" value="${sessionScope.loginId }" />
					                                                	<input type="hidden" name="review_brd_uid" value="${reviewView[0].review_brd_uid }" />
					                                                	<input type="hidden" name="rep_uid" value="${repList.rep_uid }" />
				                                                    	<div class="media-heading">
				                                                        	<span>
				                                                        		<strong>${repList.mb_id }</strong>&nbsp; <small>${repList.rep_regdate }</small>
				                                                        	</span>
				                                                        	<c:choose>
																			    <c:when test="${sessionScope.loginUid == repList.mb_uid || sessionScope.loginLevel == 3 }">
				                                                            		<button type="button" class="repUpdateButton" onclick="repUpdate(${status.index } )">댓글 수정</button>
				                                                            		<button type="button" onclick="location.href='/Project_itmoa/user/repDeleteOk.do?rep_uid=${repList.rep_uid }&review_brd_uid=${reviewView[0].review_brd_uid }'">댓글 삭제</button>
																			    </c:when>
																			</c:choose>
				                                                        </div>
				                                                        <span class="rep_content">
					                                                        <p>${repList.rep_content }</p>			                                                        
				                                                        </span>
			                                                        	<c:choose>
																	    	<c:when test="${not empty sessionScope.loginUid }">
						                                                        <span class="repUpdate">
						                                                        	<button type="submit" style="display: none;">수정 완료</button>
						                                                        </span>
						                                                	</c:when>
				                                                		</c:choose>
				                                                	</form>
			                                                    </div>
			                                                </div>
			                                            </div><!--/.media-->
			                                    	</c:forEach>
			                                    </c:when>
			                            	</c:choose>
                                        </div><!--/#comments-list-->
                                        <button type="button" onclick="location.href='/Project_itmoa/user/reviewList.do'">
											목록으로
                                        </button>
                                        <div class="gap"></div>
                                	</div>
                                </div>
                            </div>
                        </div>
                    </div><!--/.col-md-8-->
                </div><!--/.row-->
            </div>
        </section><!--/#blog-->
    </div>

    <div id="footer-wrapper">
        <section id="bottom" class="">
            <div class="container">
                <div class="row">
                    <div class="col-md-3 col-sm-6 about-us-widget">
                        <h4>Global Coverage</h4>
                        <p>Was drawing natural fat respect husband. An as noisy an offer drawn blush place. These tried for way joy wrote witty. In mr began music weeks after at begin.</p>
                    </div><!--/.col-md-3-->

                    <div class="col-md-3 col-sm-6">
                        <h4>Company</h4>
                        <div>
                            <ul class="arrow">
                                <li><a href="#">Company Overview</a></li>
                                <li><a href="#">Meet The Team</a></li>
                                <li><a href="#">Our Awesome Partners</a></li>
                                <li><a href="#">Our Services</a></li>
                            </ul>
                        </div>
                    </div><!--/.col-md-3-->

                    <div class="col-md-3 col-sm-6">
                        <h4>Latest Articles</h4>
                        <div>
                            <div class="media">
                                <div class="pull-left">
                                    <img class="widget-img" src="http://placehold.it/800x600" alt="">
                                </div>
                                <div class="media-body">
                                    <span class="media-heading"><a href="#">Blog Post A</a></span>
                                    <small class="muted">Posted 14 April 2014</small>
                                </div>
                            </div>
                            <div class="media">
                                <div class="pull-left">
                                    <img class="widget-img" src="http://placehold.it/800x600" alt="">
                                </div>
                                <div class="media-body">
                                    <span class="media-heading"><a href="#">Blog Post B</a></span>
                                    <small class="muted">Posted 14 April 2014</small>
                                </div>
                            </div>
                        </div>
                    </div><!--/.col-md-3-->

                    <div class="col-md-3 col-sm-6">
                        <h4>Come See Us</h4>
                        <address>
                            <strong>Ace Towers</strong><br>
                            New York Ave,<br>
                            New York, 215648<br>
                            <abbr title="Phone"><i class="fa fa-phone"></i></abbr> 546 840654 05
                        </address>
                    </div> <!--/.col-md-3-->
                </div>
            </div>
        </section><!--/#bottom-->

        <footer id="footer" class="">
            <div class="container">
                <div class="row">
                    <div class="col-sm-8">
                        &copy; 2019 Your Site Name. All Rights Reserved. <a href="https://templatemag.com/bootstrap-templates/">Bootstrap templates</a> by TemplateMag.
                    </div>
                    <div class="col-sm-4">
                        <ul class="pull-right">
                            <li><a id="gototop" class="gototop" href="#"><i class="fa fa-chevron-up"></i></a></li><!--#gototop-->
                        </ul>
                    </div>
                </div>
            </div>
        </footer><!--/#footer-->
    </div>

    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.prettyPhoto.js"></script>
    <script src="js/plugins.js"></script>
    <script src="js/init.js"></script>
    
    <script>
    	function repUpdate(i) {
    		var rep_content = $(".well > form > span > p").eq(i).text();
    		$(".repUpdateButton").css("display", "none");
    		$(".well > form > span[class='rep_content']").eq(i).html("<textarea name='rep_content' style='resize: none;'>" + rep_content + "</textarea>");
    		$(".well > form > .repUpdate > button").eq(i).css("display", "block");
    	}
    	
    	function chkSubmit() {
    		var keyword = $("textarea[name='rep_content']").val().length;
			if(keyword > 0) {
				return true;
			}
			
			alert("댓글을 입력하세요");
			return false;
    	}
    </script>
    
</body>
</html>