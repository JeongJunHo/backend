package safefood.dao;

public class RankVO {
	private String sname;
	private int count;

	public RankVO() {
		// TODO Auto-generated constructor stub
	}

	public RankVO(String sname, int count) {
		this.sname = sname;
		this.count = count;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "RankVO [sname=" + sname + ", count=" + count + "]";
	}

}
