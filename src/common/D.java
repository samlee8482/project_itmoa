package common;

public interface D {
	
	public static final String DRIVER = "org.mariadb.jdbc.Driver";
	public static final String URL = "jdbc:mariadb://localhost:3306/itmoa";
	public static final String USERID = "myuser";
	public static final String USERPW = "1234";
	
	// ----------- 사용자 -------------
	// 로그인
	public static final String SQL_SELECT_LOGIN =
			"SELECT mb_uid, mb_id,  mb_pw, mb_level "
			+ "FROM mb"
			+ "WHERE id = ? AND pw = ?";
	
	// 회원가입
	public static final String SQL_SELECT_JOIN =
			"INSERT INTO mb"
			+ "(mb_name, mb_id, mb_pw, mb_email, mb_zip, mb_add1, mb_add2)"
			+ "VALUES(?, ?, ?, ?, ?, ?, ?)";

	// 아이디찾기
	public static final String SQL_SELET_FIND_ACCOUNT_ID =
			"SELECT mb_name, mb_email"
			+ "FROM mb"
			+ "WHERE mb_name = ? AND mb_email = ?";

	// 비밀번호 찾기
	public static final String SQL_SELECT_FIND_ACCOUNT_PWD =
			"SELECT mb_id, mb_name, mb_email"
			+ "FROM mb"
			+ "WHERE mb_id = ? AND mb_name = ? AND mb_email = ?";

	// 마이페이지에 회원정보+찜목록 불러오기 
	public static final String SQL_SELECT_ZZIM =
		"select m.*, z.zzim_uid '회원번호', i.ins_name '학원명',  c.cur_name '과정명'"
		+ "from zzim z, cur c, class cl, ins i, mb m"
		+ "where z.mb_uid = ?"
		+ "and z.class_uid = cl.class_uid" 
		+ "and cl.cur_uid = c.cur_uid"
		+ "and cl.ins_uid = i.ins_uid";

	// 마이페이지에서 회원정보 수정
	public static final String SQL_UPDATE_MYPAGE=
		"UPDATE mb"
		+ "SET mb_pw = ?, mb_email = ?,  mb_zip = ? , mb_add1 = ?, mb_add2 = ?"
		+ "WHERE mb_uid = ?";
		
	// 프로필 이미지처리 ??
	public static final String SQL_UPDATE_MYPAGE_IMG =
		"UPDATE mb"
		+ "SET mb_img = ?"
		+ "WHERE mb_uid = ?";
		
	// ----------- 관리자  -------------
	// 회원 검색 조건) 조건 없을 때 
	public static final String SQL_SELECT_USER =
		"SELECT *"
		+ "FROM mb"
		+ "WHERE mb_level IN(?, ?, ?)";

	// 회원 검색 조건) 회원번호
	public static final String SQL_SELECT_USER_BY_UID =
		"AND mb_uid = ?";	
	
	// 회원 검색 조건) 회원ID
	public static final String SQL_SELECT_USER_BY_ID =
		"AND mb_id LIKE (%?%)";

	// 회원 검색 조건) 회원이름
	public static final String SQL_SELECT_USER_BY_NAME =
		"AND mb_name LIKE (%?%)";

	// 회원 검색 조건) 회원이메일
	public static final String SQL_SELECT_USER_BY_EMAIL =
		"AND mb_email LIKE (%?%)";

	// 회원 검색 결과 정렬
	public static final String SQL_ORDER_BY_MB_REGDATE =
		"ORDER BY mb_regdate DESC";

   // 회원 정보 수정 
	public static final String SQL_UPDATE_USER =
		"UPDATE mb"
		+ "SET SET mb_level = ?, mb_email = ?,  mb_zip = ? , mb_add1 = ?, mb_add2 = ?"
		+ "WHERE mb_uid = ?";
	
	// 학원 검색 조건) 전체
		public static final String SQL_SELECT_CLASS = "
	select i.ins_img, cl.class_zzimcnt, i.ins_name "학원명", c.cur_name "과정명"
	from class cl, cur c, ins i
	where cl.cur_uid = c.cur_uid
	and cl.ins_uid = i.ins_uid

	// 학원 검색 조건 ) 지역조건
	public static final String SQL_SELECT_CLASS_BY_INS_LOCATION = 
	"and i.ins_location like ('%?%'); 
	 
		// 학원 검색 조건 ) 지점조건
	           public static final String SQL_SELECT_CLASS_BY_INS_BRANCH = 
	"and i.ins_branch like ('%?%')”;

		// 학원 검색 조건 ) 과정명조건
	public static final String SQL_SELECT_CLASS_BY_CUR_NAME = 
	"and c.cur_name like ('%?%')”;

	// 학원 검색 결과 정렬
	public static final String SQL_ORDER_BY_CLASS_UID = 
	"order by cl.class_zzimcnt DESC”;

	// 사용가능한 조합 
	// 1. 학원 검색 기본 화면 
	  	SQL_SELECT_CLASS +SQL_ORDER_BY_CLASS_UID;
	    
		// 2. 학원 검색 ) 지역 전체 + 지점 조건 + 과정명 조건 
	  	SQL_SELECT_CLASS + SQL_SELECT_CLASS_BY_INS_BRANCH+     SQL_SELECT_CLASS_BY_CUR_NAME +SQL_ORDER_BY_CLASS_UID;



		// 학원 상세 페이지
		public static final String SQL_SELECT_INS_BY_UID = "
		SELECT c.*,  i.ins_name 
	FROM class cl,  ins i, cur c
	WHERE class_uid = 2
	      and cl.cur_uid = c.cur_uid
	      and cl.ins_uid = i.ins_uid";

	// 찜 추가
	public static final String SQL_INSERT_ZZIM = “
		INSERT INTO zzim (mb_uid, cur_uid) 
	VALUES (?, ?)“;

		

	// ----------- 관리자  -------------
	// 학원목록
	public static final String SQL_SELECT_INS =
		"SELECT *"
		+ "FROM ins";
	
	public static final String SQL_INS_WHERE_UID =
		"WHERE ins_uid = ?"

	public static final String SQL_INS_WHERE_NAME =
		"WHERE ins_name LIKE ('%?%')";
	
	public static final String SQL_INS_WHERE_CUR_NAME =
			"WHERE ins_uid = ?"
		
	public static final String SQL_SELECT_INS_ORDER_BY_UID =
			"ORDER BY ins_uid";
	
	// 학원등록
	public static final String SQL_INSERT_INS =
		"INSERT INTO ins"
		+ "(ins_name, ins_tel, ins_zip, ins_add1, ins_add2, ins_location, ins_branch)"
		+ "VALUES( ?, ?, ?, ?, ?, ?)";
	
	// 학원수정
	public static final String SQL_UPDATE_INS=
		"UPDATE ins"
		+ "SET ins_name= ?, ins_tel= ?,  ins_zip = ?, ins_add1 = ?, ins_add2 = ?, ins_location = ?, ins_branch = ?"
		+ "WHERE mb_uid = ?";
	// 학원삭제
	public static final String SQL_DELETE_INS =
		"DELETE  FROM ins"
		+ "WHERE ins_uid = ?”;

	// 클래스 목록
	public static final String SQL_SELECT_CLASS =
		"SELECT c.cur_name '과정명', c.cur_hours '시수'"
		+ "	from class cl, ins i, cur c"
		+ "where cl.ins_uid = ?"
		+ "and cl.cur_uid = c.cur_uid"
		+ "and cl.ins_uid = i.ins_uid”;

	// 클래스 추가
	public static final String SQL_INSERT_CLASS = “
INSERT INTO class(ins_uid, cur_uid) 
VALUES (?, ?)“;
	
	// 클래스 삭제
	public static final String SQL_DELETE_CLASS = “
DELETE FROM class 
WHERE class_uid = ?”;

	
}
