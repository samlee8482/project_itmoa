package com.lec.beans;

public class InsDTO {
	//매개변수
	private int ins_uid;
	private String ins_name;
	private int ins_zip;
	private String ins_add1;
	private String ins_add2;
	private String ins_tel;
	private String ins_img;
	
	// 생성자
	public InsDTO() {
		super();
	}
	
	// 매개변수 생성자
	public InsDTO(int ins_uid, String ins_name, int ins_zip, String ins_add1, String ins_add2, String ins_tel,
			String ins_img) {
		super();
		this.ins_uid = ins_uid;
		this.ins_name = ins_name;
		this.ins_zip = ins_zip;
		this.ins_add1 = ins_add1;
		this.ins_add2 = ins_add2;
		this.ins_tel = ins_tel;
		this.ins_img = ins_img;
	}
	
	// 게터세터
	public int getIns_uid() {
		return ins_uid;
	}
	public void setIns_uid(int ins_uid) {
		this.ins_uid = ins_uid;
	}
	public String getIns_name() {
		return ins_name;
	}
	public void setIns_name(String ins_name) {
		this.ins_name = ins_name;
	}
	public int getIns_zip() {
		return ins_zip;
	}
	public void setIns_zip(int ins_zip) {
		this.ins_zip = ins_zip;
	}
	public String getIns_add1() {
		return ins_add1;
	}
	public void setIns_add1(String ins_add1) {
		this.ins_add1 = ins_add1;
	}
	public String getIns_add2() {
		return ins_add2;
	}
	public void setIns_add2(String ins_add2) {
		this.ins_add2 = ins_add2;
	}
	public String getIns_tel() {
		return ins_tel;
	}
	public void setIns_tel(String ins_tel) {
		this.ins_tel = ins_tel;
	}
	public String getIns_img() {
		return ins_img;
	}
	public void setIns_img(String ins_img) {
		this.ins_img = ins_img;
	}
	
	

}
