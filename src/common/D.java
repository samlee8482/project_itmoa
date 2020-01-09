package common;

public interface D {
	
	public static final String DRIVER = "org.mariadb.jdbc.Driver";
	public static final String URL = "jdbc:mariadb://localhost:3306/itmoa";
	public static final String USERID = "myuser";
	public static final String USERPW = "1234";

//  ####################################   1. 회원 계정 관련 SQL문     ####################################
  
//  =============== 사용자용 ==============
	
	// 로그인  
	public static final String SQL_SELECT_LOGIN =
			"SELECT mb_uid, mb_id,  mb_pw, mb_level, mb_img FROM mb WHERE mb_id = ? AND mb_pw = ?";

	// 로그인 확인
//	public static final String SQL_SELECT_LOGINOK =
//			"SELECT mb_uid, mb_id, mb_pw FROM mb WHERE ID = ?";
	
	
	
	// 회원가입
	public static final String SQL_INSERT_JOIN =
			"INSERT INTO mb(mb_name, mb_id, mb_pw, mb_email, mb_zip, mb_add1, mb_add2) VALUES(?, ?, ?, ?, ?, ?, ?)";

	// 아이디찾기
	public static final String SQL_SELET_FIND_ACCOUNT_ID =
			"SELECT mb_name, mb_email FROM mb WHERE mb_name = ? AND mb_email = ?";

	// 비밀번호 찾기
	public static final String SQL_SELECT_FIND_ACCOUNT_PWD =
			"SELECT mb_id, mb_name, mb_email FROM mb WHERE mb_id = ? AND mb_name = ? AND mb_email = ?";

	
	
	// 마이페이지에 회원정보+찜목록 불러오기 
	public static final String SQL_SELECT_MYPAGE =
		"SELECT m.*, z.zzim_uid, i.ins_name,  c.cur_name"
		+ " FROM zzim z, cur c, class cl, ins i, mb m"
		+ " WHERE z.mb_uid = ?"
		+ " AND z.class_uid = cl.class_uid" 
		+ " AND cl.cur_uid = c.cur_uid"
		+ " AND cl.ins_uid = i.ins_uid";
	

	// 마이페이지에서 찜 삭제하기
	public static final String SQL_DELETE_ZZIM = 
		"DELETE FROM zzim where zzim_uid = ?";
	
	// 마이페이지에서 회원정보 수정
	public static final String SQL_UPDATE_MYPAGE=
		"UPDATE mb"
		+ " SET mb_pw = ?, mb_email = ?,  mb_zip = ? , mb_add1 = ?, mb_add2 = ?"
		+ " WHERE mb_uid = ?";
		
	// 프로필 이미지 수정
	public static final String SQL_UPDATE_MYPAGE_IMG =
		"UPDATE mb"
		+ " SET mb_img = ?"
		+ " WHERE mb_uid = ?";
	
	// 프로필 이미지 삭제(기본 이미지로 변경)
		public static final String SQL_DELETE_MYPAGE_IMG =
			"UPDATE mb"
			+ " SET mb_img = ?"
			+ " WHERE mb_uid = ?";
	
	

//  =============== 관리자용 ==============
	
	// 회원 검색 조건) 조건 없을 때      
	public static final String SQL_SELECT_USER =                  
		"SELECT *"
		+ " FROM mb";
	public static final String SQL_SELECT_USER_WHERE_LEVEL =    
		" WHERE mb_level IN(?, ?, ?)";
	// 회원 검색 조건) 회원번호
	public static final String SQL_SELECT_USER_WHERE_UID =
		" AND mb_uid = ?";	

	// 회원 검색 조건) 회원번호(수정)
	public static final String SQL_SELECT_USER_WHERE_UID2 =
			" WHERE mb_uid = ?";	
	
	// 회원 검색 조건) 회원ID
	public static final String SQL_SELECT_USER_WHERE_ID =
		" AND mb_id = ?";

	// 회원 검색 조건) 회원이름
	public static final String SQL_SELECT_USER_WHERE_NAME =
		" AND mb_name LIKE ?";

	// 회원 검색 조건) 회원이메일
	public static final String SQL_SELECT_USER_WHERE_EMAIL =
		" AND mb_email LIKE ?";

	// 회원 검색 결과 정렬
	public static final String SQL_USER_ORDER_BY =
		" ORDER BY mb_regdate DESC";

   // 회원 정보 수정 
	public static final String SQL_UPDATE_USER =
		"UPDATE mb"
		+ " SET mb_level = ?, mb_email = ?,  mb_zip = ? , mb_add1 = ?, mb_add2 = ?, mb_img = ?"
		+ " WHERE mb_uid = ?";
	
	// 회원 정보 삭제
	public static final String SQL_DELETE_USER_BY_UID = "DELETE FROM mb WHERE mb_uid = ?";
	
	
	
	
	
	
	
	
//  ####################################   2. 학원 + 과정 관련 SQL문     ####################################
	
//  =============== 사용자용 ==============	
	
	// 학원 검색 조건) 전체
		public static final String SQL_SELECT_CLASS = 
	"SELECT i.ins_img, cl.class_zzimcnt, i.ins_name, c.cur_name"
	+ " FROM class cl, cur c, ins i "
	+ " WHERE cl.cur_uid = c.cur_uid "
	+ " AND cl.ins_uid = i.ins_uid";

	// 학원 검색 조건 ) 지역조건
	public static final String SQL_SELECT_CLASS_WHERE_INS_LOCATION = 
	 " AND i.ins_location = ?"; 
	 
	// 학원 검색 조건 ) 지점조건
	public static final String SQL_SELECT_CLASS_WHERE_INS_BRANCH = 
	 " AND i.ins_branch = ?";

	// 학원 검색 조건 ) 지점 전체 검색
	public static final String SQL_SELECT_BRANCH = 
		"SELECT DISTINCT ins_branch"
		+ " FROM ins";
	
	public static final String SQL_SELECT_BRANCH_WHERE_LOCATION = 
		" WHERE ins_location = ?"; 
	
	// 학원 검색 조건 ) 과정명조건
	public static final String SQL_SELECT_CLASS_WHERE_CUR_NAME = 
	" AND c.cur_name = ?";

	// 정렬
	public static final String SQL_ORDER_CLASS_UID = 
	" ORDER BY cl.class_zzimcnt DESC";

	
	// 사용자 레벨업
	public static final String SQL_UPDATE_MB_LEVEL = 
		"UPDATE mb"
		+ " SET mb_level = 2"
		+ " WHERE mb_uid = ?";
	
	
	/* 사용가능한 조건 조합 예시 
	  	SQL_SELECT_CLASS + SQL_ORDER_BY_CLASS_UID;
	    
		// 2. 학원 검색 ) 지역 전체 + 지점 조건 + 과정명 조건 
	  	SQL_SELECT_CLASS + SQL_SELECT_CLASS_BY_INS_BRANCH + SQL_SELECT_CLASS_BY_CUR_NAME +SQL_ORDER_BY_CLASS_UID;

	 */
	
	
	public static final String SQL_SELECT_LOCATION =
			"SELECT DISTINCT ins_branch FROM ins WHERE ins_location = ? ORDER BY ins_name";

	
	// 학원 상세 페이지
	public static final String SQL_SELECT_INS_BY_UID = 
				"SELECT c.*,  i.ins_name, i.ins_img, i.ins_x, ins_y"
				+ " FROM class cl,  ins i, cur c"
				+ " WHERE class_uid = ?"
				+ " AND cl.cur_uid = c.cur_uid"
				+ " AND cl.ins_uid = i.ins_uid";

	// 찜 추가
	public static final String SQL_INSERT_ZZIM = "INSERT INTO zzim (mb_uid, class_uid) VALUES (?, ?)";

		
	

	//  ================ 관리자용 ===============
	
	// 학원 검색 조건) 전체
	public static final String SQL_SELECT_INS =
		"SELECT * FROM ins";
	
	// 학원 검색 조건) 학원 UID
	public static final String SQL_INS_WHERE_UID =
		" WHERE ins_uid = ?";
	
	// 학원 검색 조건) 학원명
	public static final String SQL_INS_WHERE_NAME =
		" WHERE ins_name LIKE ('%?%')";
	
	// 학원 검색 조건) 과정명
	public static final String SQL_INS_WHERE_CUR_NAME =
		" WHERE ins_uid = ?";
    // 정렬
	public static final String SQL_SELECT_INS_ORDER_BY_UID =
		" ORDER BY ins_uid";
	
	// 학원등록
	public static final String SQL_INSERT_INS =
		"INSERT INTO ins(ins_name, ins_tel, ins_zip, ins_add1, ins_add2, ins_location, ins_branch, ins_img, ins_x, ins_y)"
		+ " VALUES( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	// 수정 할 학원 불러오기
	public static final String SQL_SELECT_INS_BY_UID_FOR_UPDATE =
		"SELECT * FROM ins WHERE ins_uid = ?";
	
	// 학원수정
	public static final String SQL_UPDATE_INS=
		"UPDATE ins"
		+ " SET ins_name= ?, ins_tel= ?,  ins_zip = ?, ins_add1 = ?, ins_add2 = ?, ins_location = ?, ins_branch = ?, ins_img = ?, ins_x = ?, ins_y = ?"
		+ " WHERE ins_uid = ?";
	
	// 학원 이미지 삭제(기본 이미지로 변경)
	public static final String SQL_DELETE_INS_IMG=
			"UPDATE ins"
			+ " SET ins_img = ?"
			+ " WHERE ins_uid = ?";
	
	// 학원삭제
	public static final String SQL_DELETE_INS =
		"DELETE FROM ins WHERE ins_uid = ?";
	
	

	// 과정  목록
	public static final String SQL_SELECT_CLASS_BY_INS_UID =
		"SELECT c.cur_name, c.cur_hours"
		+ " FROM class cl, ins i, cur c"
		+ " WHERE cl.ins_uid = ?"
		+ " AND cl.cur_uid = c.cur_uid"
		+ " AND cl.ins_uid = i.ins_uid";

	// 과정 추가
	public static final String SQL_INSERT_CLASS = 
			"INSERT INTO class(ins_uid, cur_uid) VALUES (?, ?)";
	
	// 과정 삭제
	public static final String SQL_DELETE_CLASS = "DELETE FROM class WHERE class_uid = ?";


	// 과정 내 수업 추가
	public static final String SQL_INSERT_CUR = 
	"INSERT INTO cur"
	+ "(cur_name, cur_hours, cur_months, cur_month1, cur_month2, cur_month3, cur_month4, cur_month5, cur_month6)"
	+ " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	
	
	// 과정 내 수업 수정
	public static final String SQL_UPDATE_CUR = 
	"UPDATE cur"
	+ " SET cur_hours = ?, cur_months = ?,  cur_month1 = ?, cur_month2 = ?, cur_month3 = ?, cur_month4 = ?, cur_month5 = ?, cur_month6 = ?"
	+ " WHERE cur_uid = ?";
		
	
	
	
	
	
	
//  ####################################   3. 리뷰 관련 SQL문     ####################################
	
//  =============== 사용자  ==============	
	
	// 리뷰 목록
	public static final String SQL_SELECT_REVIEW =  
		"SELECT r.review_brd_uid, m.mb_id, i.ins_name, r.review_brd_title, r.review_brd_regdate, r.review_brd_viewcnt"
		+ " FROM review_brd r, mb m, class cl, ins i"
		+ " WHERE m.mb_uid = r.mb_uid"
		+ " AND cl.class_uid = r.class_uid"
		+ " AND cl.ins_uid = i.ins_uid";
	
	
	// 리뷰 검색 조건) 회원ID
	public static final String SQL_SELECT_REVIEW_BRD_WHERE_USER_ID =  
		" AND m.mb_id LIKE ?";
	
	// 리뷰 검색 조건) 리뷰제목
	public static final String SQL_SELECT_REVIEW_BRD_WHERE_REVIEW_TITLE = 
	  	" AND r.review_title LIKE ?";
	
	// 리뷰 검색 조건) 리뷰내용
	 public static final String SQL_SELECT_REVIEW_BRD_WHERE_REVIEW_CONTENT = 
		" AND r.review_content LIKE ?";
	
	// 리뷰 목록 정렬
	public static final String SQL_ORDER_REVIEW =  
		" ORDER BY review_brd_uid DESC";
		

	// 리뷰 내용
	public static final String SQL_SELECT_REVIEW_CONTENT =  
		"SELECT i.ins_name, r.* , m.mb_id"
		+ " FROM review_brd r, mb m, class cl, ins i"
		+ " WHERE r.review_brd_uid = ?"
		+ " AND m.mb_uid = r.mb_uid"
		+ " AND cl.class_uid = r.class_uid"
		+ " AND cl.ins_uid = i.ins_uid";	
	
	// 댓글 작성
	public static final String SQL_INSERT_REVIEW = 
		"INSERT INTO review_brd (mb_uid, class_uid, review_brd_title, review_brd_content)"
		+ " VALUES (?, ?, ?, ?)";
	
	// 리뷰 수정
	public static final String SQL_UPDATE_REVIEW_BY_UID = 
		"UPDATE review_brd"
		+ " SET review_brd_title = ?, review_brd_content = ? "
		+ " WHERE review_brd_uid = ?";
		
	// 조회수 처리는?
	public static final String SQL_UPDATE_REVIEW_INC_VIEWCNT = 
		"UPDATE review_brd "
		+ " SET review_brd_viewcnt = review_brd_viewcnt + 1 "
		+ " WHERE review_brd_uid = ?";	
	
	
	public static final String SQL_DELETE_REVIEW_BY_UID =
		"DELETE FROM review_brd WHERE review_brd_uid = ?";		
	
	
	// 리뷰uid에 해당하는 댓글 리스트 불러오기
	public static final String SQL_SELECT_REP_BY_UID =  
			"SELECT m.mb_id, re.*"
			+ " FROM review_brd r, mb m, rep re"
			+ " WHERE r.review_brd_uid = ?"
			+ " AND re.review_brd_uid = r.review_brd_uid"
			+ " AND re.mb_uid = m.mb_uid"
			+ " ORDER BY re.rep_regdate DESC";
	
	
	// 댓글의 URD는 로그인된 회원과 동일한 UID/ID를 가질때?
	// 댓글 작성
	public static final String SQL_INSERT_REP = 
		"INSERT INTO rep(mb_uid, review_brd_uid, rep_content) VALUES (?, ?, ?)";

	// 댓글 수정
	public static final String SQL_UPDATE_REP_BY_UID = 
		"UPDATE rep SET rep_content=? WHERE rep_uid = ?";
	
	
	// 댓글 삭제
	public static final String SQL_DELETE_REP_BY_UID = 
		"DELETE FROM rep WHERE rep_uid= ?";
		
    
		
	
	
	
	
	
	
//  ####################################   4. IT News 관련 SQL문     ####################################
	
//  =============== 사용자용  ==============			

	// 뉴스 리스트, 등록된 시간 순서로 조회

	public static final String SQL_SELECT_NEWS_BRD = 
		"SELECT * FROM news_brd";
	
	// 뉴스 조회
	public static final String SQL_SELECT_NEWS_BRD_CONTENT =
		"SELECT * FROM news_brd"
		+ " WHERE news_brd_uid = ?"; 
	
	// 뉴스 검색 조건) 뉴스UID
		public static final String SQL_SELECT_NEWS_BRD_WHERE_UID = 
			" WHERE news_brd_uid = ?";

		// 뉴스 검색 조건) 뉴스 제목
		public static final String SQL_SELECT_NEWS_BRD_WHERE_TITLE = 
			" WHERE news_brd_title LIKE ?";

		// 뉴스 검색 조건) 뉴스 내용
		public static final String SQL_SELECT_NEWS_BRD_WHERE_CONTENT = 
			" WHERE news_brd_content LIKE ?";
		
		// 뉴스 검색 결과 정렬
		public static final String SQL_ORDER_BY_NEWS_BRD_UID_DESC = 
				" ORDER BY news_brd_uid DESC";
		
		public static final String SQL_ORDER_BY_NEWS_BRD_UID_ASC = 
				" ORDER BY news_brd_uid ASC";
		
		public static final String SQL_ORDER_BY_NEWS_BRD_VIEWCNT_DESC = 
				" ORDER BY news_brd_viewcnt ASC";
		
		public static final String SQL_COUNT_NEWS_BRD =
				"SELECT COUNT(*) FROM news_brd";
		
	// 조회수 처리는?
	public static final String SQL_UPDATE_NEWS_BRD_INC_VIEWCNT = 
		"UPDATE news_brd "
		+ " SET news_brd_viewcnt = news_brd_viewcnt + 1 "
		+ " WHERE news_brd_uid = ?";	
	
	
//  =============== 관리자용  ==============	

	public static final String SQL_INSERT_NEWS_BRD = 
		"INSERT INTO news_brd "
		+ " (news_brd_title, news_brd_img, news_brd_content)"
		+ " VALUES(?,?,?)";
	
	public static final String SQL_UPDATE_NEWS_BRD_BY_UID = 
		"UPDATE news_brd"
		+ " SET news_brd_title = ?, news_brd_content = ?, news_brd_img = ?"
		+ " WHERE news_brd_uid = ?";
		
	public static final String SQL_DELETE_NEWS_BRD_BY_UID = 
		"DELETE "
		+ " FROM news_brd "
		+ " WHERE news_brd_uid = ?";			
	
}