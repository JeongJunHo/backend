package safefood.service;

import java.util.ArrayList;
import java.util.HashMap;

import safefood.dao.MemVo;

public interface IMemberService {
	public boolean login(String id, String pw);

	public boolean deleteMem(String id);

	public boolean updateMem(String id, String pw, String name, String addr, String tel, String allergy);

	public MemVo infoMem(String id);

	public ArrayList<MemVo> listMem();

	public boolean registerMem(String id, String pw, String name, String addr, String tel, String allergy);
	
	public MemVo findId(String name, String tel);
	
	public boolean updatePw(String id, String pw);

	HashMap<String, Integer> allergyMaterialRank();
}
