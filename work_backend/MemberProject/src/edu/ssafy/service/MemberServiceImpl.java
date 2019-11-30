package edu.ssafy.service;

import java.util.ArrayList;

import edu.ssafy.dao.IMemberDAO;
import edu.ssafy.dao.MemVo;
import edu.ssafy.dao.MemberDAODBImpl;

public class MemberServiceImpl implements IMemberService {
	IMemberDAO man = new MemberDAODBImpl();

	public MemberServiceImpl() {
	}
	@Override
	public boolean login(String id, String pw) {
		return man.isLogin(id, pw);
	}
	@Override
	public boolean deleteMem(String id) {
		boolean res = man.memDelete(id);

		return res;
	}
	@Override
	public boolean updateMem(String id, String pw, String name, String tel, String gender) {
		boolean res = man.memUpdate(id, pw, name, tel, gender);

		return res;
	}
	@Override
	public MemVo infoMem(String id) {
		MemVo mem = man.memInfo(id);

		return mem;
	}
	@Override
	public ArrayList<MemVo> listMem() {
		ArrayList<MemVo> list = man.memList();

		return list;
	}
	@Override
	public boolean registerMem(String id, String pw, String name, String tel, String gender) {
		boolean res = man.memInsert(id, pw, name, tel, gender);

		return res;
	}
}
