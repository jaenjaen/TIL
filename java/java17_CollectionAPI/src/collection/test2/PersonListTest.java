package collection.test2;

import java.util.ArrayList;

public class PersonListTest {

	public static void main(String[] args) {
		//List안에 여러명의 Person을 저장 
		ArrayList<Person> list = new ArrayList<>();
		
		list.add(new Person("이순신", "여의도", 27));
		list.add(new Person("강감찬", "순천", 45));
		list.add(new Person("을지문덕", "구미", 67));
		list.add(new Person("이순신1", "여의도", 37));
		list.add(new Person("강감찬1", "순천1", 42));
		list.add(new Person("을지문덕1", "여의도", 97));
		
		System.out.println(list);
		
		//두번째 장군을 찾아서 정보를 출력
		System.out.println(list.get(1));
		
		//장군들의 숫자출력
		System.out.println(list.size());
		
		//리스트에 저장된 장군들의 평균연령 구하기
		int tot = 0;
		for(Person p : list) {
			tot += p.getAge();
		}
		System.out.println(tot/list.size());
		
		//저장된 장군들의 이름만 출력
		for(Person p : list) System.out.print(p.getName()+"\t");
		
		System.out.println();
		for(Person p: list) {
			if(p.getAddr().contains("여의도")) System.out.print(p.getName()+" ");
		}
	}

}
