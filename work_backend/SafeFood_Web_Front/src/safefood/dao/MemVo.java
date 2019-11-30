package safefood.dao;

public class MemVo {
	private String id;
	private String pw;
	private String name;
	private String addr;
	private String tel;
	private String allergy;

	public MemVo() {
		// TODO Auto-generated constructor stub
	}
	public MemVo(String id) {
		this.id = id;
	}
	public MemVo(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}

	public MemVo(String id, String pw, String name, String addr, String tel, String allergy) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.addr = addr;
		this.tel = tel;
		this.allergy = allergy;
	}

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return "MemVo [id=" + id + ", pw=" + pw + ", name=" + name + ", addr=" + addr + ", tel=" + tel + ", allergy="
				+ allergy + "]";
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

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAllergy() {
		return allergy;
	}

	public void setAllergy(String allergy) {
		this.allergy = allergy;
	}

}
