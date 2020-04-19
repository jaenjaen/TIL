package collection.test2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class CustomerMapTest {

	public static void main(String[] args) {
		HashMap<String, Customer> map = new HashMap<>();

		map.put("111", new Customer("kim", "김제동", 40));
		map.put("222", new Customer("seung", "성유리", 37));
		map.put("333", new Customer("lee", "이경규", 55));
		
		//1.222에 해당하는 사람 출력
		Set<String> key = map.keySet();
		Iterator<String> it = key.iterator();
		
		while(it.hasNext()) {
			if(it.next().equals("222")) System.out.println(map.get(it.next()));
		}
		
		//2.아이디가 kim인 사람을 찾아서 그 사람의 이름을 출력
		while(it.hasNext()) {
			String keyNumber = it.next();
			if(map.get(keyNumber).getId().equals("kim")) System.out.println(map.get(keyNumber));
		}
		
		//3.map에 저장된 모든 key값을 출력
		System.out.println(map.keySet());
		//4.모든 사람의 나이 총합과 평균연령을 출력
		
		int tot = 0;
		
		for(String s : map.keySet()) {
			tot += map.get(s).getAge();
		}

		System.out.println("합계 연령 : "+tot);
		System.out.println("평균 연령: "+tot/map.size());
	}

}
