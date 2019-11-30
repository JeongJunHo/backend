package edu.ssafy.dao;

import java.util.ArrayList;

public class MemberDAOListImpl implements IMemberDAO {
	private static ArrayList<MemVo> list = new ArrayList<MemVo>();
	private MemberDAOListImpl() {}
	private static MemberDAOListImpl man = new MemberDAOListImpl();
	public static MemberDAOListImpl getInstance() {
		return man;
	}
	
	public boolean memInsert(String id, String pw, String name, String tel, String gender) {
		boolean res = false;
		try {
			list.add(new MemVo(id, pw, name, tel, gender));
			res = true;
		}catch (Exception e) {
			res = false;
		}
		
		return res;
	}
	
	public ArrayList<MemVo> memList(){
		return list;
	}
	
	public MemVo memInfo(String id) {
		for (MemVo memVo : list) {
			if(memVo.getId().equals(id)) {
				return memVo;
			}
		}
		return null;
	}
	
	public boolean memUpdate(String id, String pw, String name, String tel, String gender) {
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getId().equals(id)) {
				list.set(i, new MemVo(id,pw,name,tel,gender));
				return true;
			}
		}
		return false;
	}
	
	public boolean memDelete(String id) {
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getId().equals(id)) {
				list.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public boolean isLogin(String id, String pwd) {
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getId().equals(id) && list.get(i).getPw().equals(pwd)) {
				return true;
			}
		}
		return false;
	}
}
