package edu.ssafy.dao;

import java.util.ArrayList;

public interface IMemberDAO {
	public boolean memInsert(String id, String pw, String name, String tel, String gender);
	
	public ArrayList<MemVo> memList();
	
	public MemVo memInfo(String id);
	
	public boolean memUpdate(String id, String pw, String name, String tel, String gender);
	
	public boolean memDelete(String id);
	
	public boolean isLogin(String id, String pwd);
}
