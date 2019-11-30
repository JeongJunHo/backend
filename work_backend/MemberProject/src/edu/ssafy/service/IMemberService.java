package edu.ssafy.service;

import java.util.ArrayList;

import edu.ssafy.dao.MemVo;

public interface IMemberService {
	public boolean login(String id, String pw);

	public boolean deleteMem(String id);

	public boolean updateMem(String id, String pw, String name, String tel, String gender);

	public MemVo infoMem(String id);

	public ArrayList<MemVo> listMem();

	public boolean registerMem(String id, String pw, String name, String tel, String gender);
}
