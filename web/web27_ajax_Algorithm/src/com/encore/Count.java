package com.encore;

import java.util.HashMap;


public class Count {

	public String execute(String book) {
		String word = "";
		String[] tmp = null;
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		int max = 0;
		
		//소문자화
		book = book.toLowerCase().replace(".", "").replace("?", "").replace("-", "");
		
		//공백으로 잘라서 어레이 넣기
		tmp = book.split(" ");
		
		//for돌면서
		for(int i=0; i<tmp.length;i++) {
			//key-value넣고 찾으면 value++
			if(map.containsKey(tmp[i])) {
				map.put(tmp[i], map.get(tmp[i]) + 1);
			}else { map.put(tmp[i], 1);}
		}
		
		//value젤 높은 key값 리턴
		for(String key: map.keySet()) {
			if(map.get(key)>max) {
				max = map.get(key);
				word = key;
			}
			//만약 같은 수라면
			//아스키코드 비교해서 제일 작은 값 
			if(map.get(key) == max && !word.equals("")) {
				if(word.charAt(0) > key.charAt(0)) {
					word = key;
					max = map.get(key);
				}
			}
		}
		
		return word;
	}

	public static void main(String[] args) {
		String book1 ="Can Danny and his father outsmart the villainous Mr. Hazell? Danny has a life any boy would love - his home is a gypsy caravan, he's the youngest master car mechanic around, and his best friend is his dad, who never runs out of wonderful stories to tell. But one night Danny discovers a shocking secret that his father has kept hidden for years. "; 
		String book2 ="Soon Danny finds himself the mastermind behind the most incredible plot ever attempted against nasty Victor Hazell, a wealthy landowner with a bad attitude. Can they pull it off? If so, Danny will truly be the champion of the world.";
		String book3 ="I like cat. I like cat. I like cat. ";
		Count c = new Count();
		System.out.println(c.execute(book1));
		System.out.println(c.execute(book2));
		System.out.println(c.execute(book3));

	}

}
