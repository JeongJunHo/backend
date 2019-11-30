package safefood.service;

import java.util.ArrayList;
import java.util.HashMap;

import safefood.dao.IMemberDAO;
import safefood.dao.MemVo;
import safefood.dao.MemberDAODBImpl;

public class MemberServiceImpl implements IMemberService {
	IMemberDAO man = new MemberDAODBImpl();

	public MemberServiceImpl() {
	};

	@Override
	public boolean login(String id, String pwd) {
		return man.isLogin(id, pwd);
	}

	@Override
	public boolean deleteMem(String id) {
		boolean res = man.memDelete(id);
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
	public boolean updateMem(String id, String pw, String name, String addr, String tel, String allergy) {
		// TODO Auto-generated method stub
		boolean res = man.memUpdate(id, pw, name, addr, tel, allergy);
		return res;
	}

	@Override
	public boolean registerMem(String id, String pw, String name, String addr, String tel, String allergy) {
		// TODO Auto-generated method stub
		boolean res = man.memInsert(id, pw, name, addr, tel, allergy);
		return res;
	}

	@Override
	public MemVo findId(String name, String tel) {
		return man.findId(name, tel);
	}

	@Override
	public boolean updatePw(String id, String pw) {
		// TODO Auto-generated method stub
		return man.pwUpdate(id, pw);
	}

	@Override
	public HashMap<String, Integer> allergyMaterialRank() {
		ArrayList<MemVo> list = man.memList();
		String[] str = new String[list.size()];
		HashMap<String, Integer> map = new HashMap<String, Integer>();

		for (int i = 0; i < list.size(); i++) {
			String allergy = list.get(i).getAllergy();
			str = allergy.split(",");
			for (int j = 0; j < str.length; j++) {
				if (map.get(str[j]) == null) {
					map.put(str[j], 1);
				} else {
					map.put(str[j], map.get(str[j]) + 1);
				}
			}
		}
		return map;
	}

}
