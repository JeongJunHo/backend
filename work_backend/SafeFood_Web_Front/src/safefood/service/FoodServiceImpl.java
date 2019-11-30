package safefood.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import safefood.dao.FoodDAO;
import safefood.dao.FoodDAOImpl;
import safefood.dao.FoodVO;
import safefood.dao.IMemberDAO;
import safefood.dao.MemVo;
import safefood.dao.MemberDAODBImpl;
import safefood.dao.RankDAO;
import safefood.dao.RankDAOImpl;
import safefood.dao.RankVO;
import safefood.util.FoodSaxParser;

public class FoodServiceImpl implements FoodService {
	FoodDAO foodDAOImpl = new FoodDAOImpl();
	IMemberDAO memberDAOImpl = new MemberDAODBImpl();
	RankDAO rankDAOImpl = new RankDAOImpl();
	@Override
	public void loadData(String realPath) {
		FoodSaxParser fp = new FoodSaxParser(realPath);
		List<FoodVO> list = fp.getFoods();
		for (FoodVO food : list) {
			foodDAOImpl.insertFood(food);
		}
	}

	@Override
	public int foodCount() {
		// TODO Auto-generated method stub
		return foodDAOImpl.foodCount();
	}

	@Override
	public List<FoodVO> searchAll(String searchType, String searchText) {
		// TODO Auto-generated method stub
		return foodDAOImpl.searchAll(searchType, searchText);
	}

	@Override
	public FoodVO search(int code, String id) {
		FoodVO foodVO = foodDAOImpl.search(code);
		foodVO.setHit(foodVO.getHit()+1);
		foodDAOImpl.updateHit(code, foodVO.getHit());
		
		//로그인 아이디가 있다면
		if(id != null) {
			MemVo memberVO = memberDAOImpl.memInfo(id);
			String[] split = memberVO.getAllergy().split(",");
			for (String str : split) {
				if(foodVO.getMaterial().contains(str)) {
					foodVO.setAllergyWarning(true);
					break;
				}
			}
		}
		
		return foodVO;
	}

	@Override
	public List<FoodVO> searchBest() {
		return foodDAOImpl.searchBest();
	}

	@Override
	public List<FoodVO> searchBestIndex() {
		return foodDAOImpl.searchBestIndex();
	}

	@Override
	public List<List<FoodVO>> combinationSearch(int maxCalory, String id) {
		List<List<FoodVO>> combSearchList = new ArrayList<List<FoodVO>>();
		
		if(maxCalory > 0) {
			MemVo memberVO = memberDAOImpl.memInfo(id);
			List<FoodVO> foodList = foodDAOImpl.searchAll(null, null);
			//사용자의 알러지 제품이 있다면
			if(memberVO.getAllergy() != null) {
				String[] allergys = memberVO.getAllergy().split(",");
				for (Iterator iterator = foodList.iterator(); iterator.hasNext();) {
					FoodVO foodVO = (FoodVO) iterator.next();
					for (String material : allergys) {
						//알러지 제품을 포함하고 있다면 삭제
						if(foodVO.getMaterial().contains(material)) {
							iterator.remove();
							break;
						}
					}
				}
			}
			
			comb(maxCalory, combSearchList, foodList, new boolean[foodList.size()], 0, 0.0);
		}
		
		return combSearchList;
	}
	
	private void comb(int maxCalory, List<List<FoodVO>> combSearchList, List<FoodVO> foodList, boolean[] visited, int idx, double sum) {
		if(sum > maxCalory) {
			return;
		}
		
		if(idx == foodList.size()) {
			if(sum >= maxCalory*0.95) {
				List<FoodVO> tmp = new ArrayList<FoodVO>();
				for (int i = 0; i < visited.length; i++) {
					if(visited[i]) {
						tmp.add(foodList.get(i));
					}
				}
				
				combSearchList.add(tmp);
			}
			return;
		}
		
		visited[idx] = true;
		comb(maxCalory, combSearchList, foodList, visited, idx+1, sum + foodList.get(idx).getCalory());
		visited[idx] = false;
		comb(maxCalory, combSearchList, foodList, visited, idx+1, sum);
	}

	@Override
	public HashMap<String, Integer> materialAccumulator() {
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		List<FoodVO> foodList = foodDAOImpl.searchAll(null, null);
		for (FoodVO foodVO : foodList) {
			String material = foodVO.getMaterial(); 
			material = material.replace(" ", "");
			material = material.replace("[", "");
			material = material.replace("]", "");
			material = material.replace("{", "");
			material = material.replace("}", "");
			material = material.replace("(", "");
			material = material.replace(")", "");
			
			String[] split = material.split(",");
			
			for (String str : split) {
				if(map.get(str) != null) {
					map.put(str, map.get(str) + 1);
				}else {
					map.put(str, 1);
				}
			}
		}
		
		return map;
	}

	@Override
	public HashMap<String, List<FoodVO>> allergyFood(String id) {
		HashMap<String,List<FoodVO>> map = new HashMap<String,List<FoodVO>>();
		
		MemVo memberVO = memberDAOImpl.memInfo(id);
		List<FoodVO> foodList = foodDAOImpl.searchAll(null, null);
		//사용자의 알러지 제품이 있다면
		if(memberVO.getAllergy() != null) {
			String[] allergys = memberVO.getAllergy().split(",");
			
			for (String material : allergys) {
				if(map.get(material) == null) {
					map.put(material, new ArrayList<FoodVO>());
				}
				
				List<FoodVO> tmpList = map.get(material);
				
				for (FoodVO foodVO : foodList) {
					if(foodVO.getMaterial().contains(material)) {
						tmpList.add(foodVO);
					}
				}
				
				map.put(material, tmpList);
			}
		}
		
		return map;
	}

	@Override
	public void searchCnt(String sname) {
		// TODO Auto-generated method stub
		rankDAOImpl.searchCnt(sname);
	}

	@Override
	public ArrayList<RankVO> searchRank() {
		// TODO Auto-generated method stub
		ArrayList<RankVO> list = rankDAOImpl.searchRank();
		return list;
	}
}
