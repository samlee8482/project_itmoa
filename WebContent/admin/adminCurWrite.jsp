<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="ko">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>ITMOA ADMIN - CurWrite</title>

<!-- Custom fonts for this template-->
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="css/sb-admin-2.min.css" rel="stylesheet">
<script src="ckeditor/ckeditor.js"></script>
<style>
input[type="text"] {
		border: 0.5px solid #cccccc;
		background: #hhhhhh;
}
</style>
</head>

<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">
	
		<!-- Side Menu -->
		<jsp:include page="sideMenu.jsp"/>

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">

				<!-- Topbar -->
				<nav
					class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

					<!-- Sidebar Toggle (Topbar) -->
					<button id="sidebarToggleTop"
						class="btn btn-link d-md-none rounded-circle mr-3">
						<i class="fa fa-bars"></i>
					</button>

					<!-- Topbar Search -->
					<div class="h4 m-0 ml-2 font-weight-bold text-primary">과정 관리</div>

					<!-- Topbar Navbar -->
					<ul class="navbar-nav ml-auto">

						<!-- Nav Item - User Information -->
						<li class="nav-item dropdown no-arrow"><a
							class="nav-link dropdown-toggle" href="#" id="userDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> <span
								class="mr-2 d-none d-lg-inline text-gray-600 small">관리자1</span>
								<img class="img-profile rounded-circle"
								src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSZ1TLNa9cA0CONWCEvzv4l5vSHyLy4GadK0gKlS_PINAzaQjUT&s">
						</a> <!-- Dropdown - User Information -->
							<div
								class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
								aria-labelledby="userDropdown">
								<a class="dropdown-item" href="#" data-toggle="modal"
									data-target="#logoutModal"> <i
									class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
									Logout
								</a>
							</div></li>

					</ul>

				</nav>
				<!-- End of Topbar -->

				<!-- Begin Page Content -->
				<div class="container-fluid">

					<!-- Content Row -->
					<div class="row">

						<div class="col-xl-12 col-lg-7">

							<!-- Area Chart -->
							<div class="card shadow mb-4">
								<div class="card-header py-3">
									<h6 class="m-0 font-weight-bold text-primary">과정 추가</h6>
								</div>
								<div class="card-body">
									<form action="/Project_itmoa/admin/adminCurOk.do" method="post" enctype=”multipart/form-data”>
										<h6 class="m-0 font-weight-bold text-primary p-2">과정명</h6>
										<select name="cur_name" style="width: 100%" class="p-2">
											<option value="웹앱">웹/앱</option>
											<option value="네트워크">네트워크</option>
											<option value="보안">보안</option>
											<option value="AI">AI</option>
											<option value="디자인">디자인</option>
											<option value="영상">영상</option>
											<option value="빅데이터">빅데이터</option>
											<option value="게임">게임</option>
										</select>
										<h6 class="m-0 font-weight-bold text-primary p-2">총 시간</h6>
										<input type="text" name="cur_hours" placeholder="총 시간을 입력하세요" class="p-2 mb-3 col-xl-12">
										<h6 class="m-0 font-weight-bold text-primary p-2">총 개월</h6>
										<input type="text" name="cur_months" placeholder="총 개월을 입력하세요" class="p-2 mb-3 col-xl-12">
										<h6 class="m-0 font-weight-bold text-primary p-2">month1</h6>
										<textarea name="cur_month1"></textarea>
										<h6 class="m-0 font-weight-bold text-primary p-2">month2</h6>
										<textarea name="cur_month2"></textarea>
										<h6 class="m-0 font-weight-bold text-primary p-2">month3</h6>
										<textarea name="cur_month3"></textarea>
										<h6 class="m-0 font-weight-bold text-primary p-2">month4</h6>
										<textarea name="cur_month4"></textarea>
										<h6 class="m-0 font-weight-bold text-primary p-2">month5</h6>
										<textarea name="cur_month5"></textarea>
										<h6 class="m-0 font-weight-bold text-primary p-2">month6</h6>
										<textarea name="cur_month6"></textarea>
										<input type="hidden" name="ifNew" value="true" />
										<input type="hidden" name="ins_uid" value="${param.ins_uid }" />
										<button type="submit" on class="p-2 mt-3 col-xl-12 bg-primary text-white border-0 rounded">추가 완료</button>
									</form>
								</div>
							</div>

						</div>

					</div>

				</div>
				<!-- /.container-fluid -->

			</div>
			<!-- End of Main Content -->

			<!-- Footer -->
			<footer class="sticky-footer bg-white">
				<div class="container my-auto">
					<div class="copyright text-center my-auto">
						<span>Copyright &copy; Your Website 2019</span>
					</div>
				</div>
			</footer>
			<!-- End of Footer -->

		</div>
		<!-- End of Content Wrapper -->

	</div>
	<!-- End of Page Wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>

	<!-- Logout Modal-->
	<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="modal-body">정말 로그아웃 하시겠습니까?</div>
				<div class="modal-footer">
					<button class="btn btn-secondary" type="button"
						data-dismiss="modal">Cancel</button>
					<a class="btn btn-primary" href="../user/logoutOk.do">Logout</a>
				</div>
			</div>
		</div>
	</div>

	<!-- Bootstrap core JavaScript-->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="js/sb-admin-2.min.js"></script>

	<!-- Page level plugins -->
	<script src="vendor/chart.js/Chart.min.js"></script>

	<!-- Page level custom scripts -->
	<script src="js/demo/chart-area-demo.js"></script>
	<script src="js/demo/chart-pie-demo.js"></script>
	<script src="js/demo/chart-bar-demo.js"></script>

	<script>
		$("textarea").css({
			"width": "100%",
			"height": "80px",
			"resize": "none",
			"padding": "5px"
		});
	</script>

</body>

</html>