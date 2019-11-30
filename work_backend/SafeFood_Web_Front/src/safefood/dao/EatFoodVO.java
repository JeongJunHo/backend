package safefood.dao;

import java.util.Date;

public class EatFoodVO {
	private int num;
	private String id;
	private int code;
	private int cnt;
	private Date eatdate;
	
	/* view */
	private String foodName;
	
	public EatFoodVO(int num, String id, int code, int cnt, Date eatdate) {
		super();
		this.num = num;
		this.id = id;
		this.code = code;
		this.cnt = cnt;
		this.eatdate = eatdate;
	}
	
	public EatFoodVO(int num, String id, int code, int cnt, Date eatdate, String foodName) {
		super();
		this.num = num;
		this.id = id;
		this.code = code;
		this.cnt = cnt;
		this.eatdate = eatdate;
		this.foodName = foodName;
	}

	public EatFoodVO() {
		// TODO Auto-generated constructor stub
	}
	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public Date getEatdate() {
		return eatdate;
	}
	public void setEatdate(Date eatdate) {
		this.eatdate = eatdate;
	}
	@Override
	public String toString() {
		return "EatFoodVO [num=" + num + ", id=" + id + ", code=" + code + ", cnt=" + cnt + ", eatdate=" + eatdate
				+ "]";
	}
}
