package collection.test1;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
 * Map은 Key와 Value를 쌍으로 저장한다.
 */
public class MapTest2 {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		
		map.put("강호동", 70);
		map.put("이수근", 70);
		map.put("피오", 10);
		map.put("규현", 95);
		
		System.out.println(map);
		
		//1. 키만 받아옴 KeySet()
		Set<String> s = map.keySet();
		
		for(String name : s) {
			System.out.println(name+"의 성적: "+map.get(name));
		}
		
	}

}
