package collection.test1;

import java.util.HashSet;
import java.util.Set;

/*
 * Set 
 * Unique 중복 X 순서 X
 */
public class SetTest {

	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		
		set.add("강호동");
		set.add("이수근");
		set.add("규현");
		set.add("은지원");
		set.add("피오");
		set.add("이수근");
		
		System.out.println(set);
		System.out.println(set.size());
		
		boolean b = set.contains("김혜수");
		
		System.out.println(b);
		
		set.remove("규현");
		System.out.println(set);
		
		set.clear();
		System.out.println("비었는가? "+set.isEmpty());
	}

}
