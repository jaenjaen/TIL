package io.object.test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/*
 * 직렬화 코드...
 * serialization : 쉽게 생각해서 data unpack
 * 
 * 1. ObjectOutputStream
 * 2. writeObject(Object) -> person 객체가 직렬화 되어 sink로 날라간다는 뜻
 */
public class PesronObjectOutputTest {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		String fileName = "src\\person.obj";
		ObjectOutputStream oos = new ObjectOutputStream((new FileOutputStream(fileName)));
		
		Person p = new Person("김연아",28,"kim99");
		
		//sink로
		oos.writeObject(p);
		
		//자원반납
		oos.close();
		System.out.println("perosn.obj파일에 연아의 정보를 저장했습니다.");
		System.out.println("정보를 확인하려면 역직렬화해서 확인하길바랍니다.");
	
	}

}
