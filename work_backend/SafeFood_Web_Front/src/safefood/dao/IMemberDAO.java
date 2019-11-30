package safefood.dao;

import java.util.ArrayList;

public interface IMemberDAO {
	
	public boolean memInsert(String id, String pw, String name,String addr, String tel, String allergy);
	
	public ArrayList<MemVo> memList();

	public MemVo memInfo(String id);

	public boolean memUpdate(String id, String pw, String name,String addr, String tel, String allergy);

	public boolean memDelete(String id);

	public boolean isLogin(String id, String pwd);
	
	public MemVo findId(String name, String tel);

	public boolean pwUpdate(String id, String pw);
}
