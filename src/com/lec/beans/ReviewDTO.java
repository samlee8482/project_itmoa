package com.lec.beans;

public class ReviewDTO {
	//매개변수
	private int mb_uid;
	private String mb_id;
	private int review_brd_uid;
	private String review_brd_title;
	private String review_brd_content;
	private String review_brd_regdate;
	private int rep_uid;
	private String rep_content;
	private String rep_regdate;

	// 생성자
	public ReviewDTO() {
		super();
	}

	// 매개변수 생성자
	public ReviewDTO(int mb_uid, String mb_id, int review_brd_uid, String review_brd_title, String review_brd_content,
			String review_brd_regdate, int rep_uid, String rep_content, String rep_regdate) {
		super();
		this.mb_uid = mb_uid;
		this.mb_id = mb_id;
		this.review_brd_uid = review_brd_uid;
		this.review_brd_title = review_brd_title;
		this.review_brd_content = review_brd_content;
		this.review_brd_regdate = review_brd_regdate;
		this.rep_uid = rep_uid;
		this.rep_content = rep_content;
		this.rep_regdate = rep_regdate;
	}

	// 게터세터
	public int getMb_uid() {
		return mb_uid;
	}

	public void setMb_uid(int mb_uid) {
		this.mb_uid = mb_uid;
	}

	public String getMb_id() {
		return mb_id;
	}

	public void setMb_id(String mb_id) {
		this.mb_id = mb_id;
	}

	public int getReview_brd_uid() {
		return review_brd_uid;
	}

	public void setReview_brd_uid(int review_brd_uid) {
		this.review_brd_uid = review_brd_uid;
	}

	public String getReview_brd_title() {
		return review_brd_title;
	}

	public void setReview_brd_title(String review_brd_title) {
		this.review_brd_title = review_brd_title;
	}

	public String getReview_brd_content() {
		return review_brd_content;
	}

	public void setReview_brd_content(String review_brd_content) {
		this.review_brd_content = review_brd_content;
	}

	public String getReview_brd_regdate() {
		return review_brd_regdate;
	}

	public void setReview_brd_regdate(String review_brd_regdate) {
		this.review_brd_regdate = review_brd_regdate;
	}

	public int getRep_uid() {
		return rep_uid;
	}

	public void setRep_uid(int rep_uid) {
		this.rep_uid = rep_uid;
	}

	public String getRep_content() {
		return rep_content;
	}

	public void setRep_content(String rep_content) {
		this.rep_content = rep_content;
	}

	public String getRep_regdate() {
		return rep_regdate;
	}

	public void setRep_regdate(String rep_regdate) {
		this.rep_regdate = rep_regdate;
	}
	
	

}
