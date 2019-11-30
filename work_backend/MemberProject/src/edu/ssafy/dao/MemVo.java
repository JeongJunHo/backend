package edu.ssafy.dao;

public class MemVo {
	private String id;
	private String pw;
	private String name;
	private String tel;
	private String gender;
	
	public MemVo() {
		super();
	}
	
	public MemVo(String id, String pw, String name, String tel, String gender) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.tel = tel;
		this.gender = gender;
	}
	
	@Override
	public String toString() {
		return "MemVo [id=" + id + ", pw=" + pw + ", name=" + name + ", tel=" + tel + ", gender=" + gender + "]";
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
}
