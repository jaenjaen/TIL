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
public class MapTest {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		
		map.put("강호동", 70);
		map.put("이수근", 70);
		map.put("피오", 10);
		map.put("규현", 95);
		
		System.out.println(map);
		
		//1. 키만 받아옴 KeySet()
		Set<String> s = map.keySet();
		Iterator<String> it =s.iterator();
		
		//2. 키에 해당되는 Value를 찾아 출력
		while(it.hasNext()){
			String name = it.next();
			System.out.println(name+"*****"+map.get(name));
		}
		
		
		//3. map
		Collection<Integer> c = map.values();
		System.out.println(c);
		
		int total = 0;
		Iterator<Integer> ci =c.iterator();
		
		while(ci.hasNext()) total +=ci.next();
		
		System.out.println("총점: "+total);
		
		//4.평균
		System.out.println("평균: "+total/c.size());
		System.out.println("최고점수: "+ Collections.max(c));
		System.out.println("최저점수: "+ Collections.min(c));
	}

}
