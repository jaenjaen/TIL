package exception.compile.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CompileTest5 {

	public static void main(String[] args) throws FileNotFoundException,IOException {
		String path = "C:\\lje\\poem.txt";
		FileReader fr =null;
		
		System.out.println("1.파일리더 클래스 생성");
		try{
			fr = new FileReader(path); // 수도꼭지 오픈
			System.out.println("2.파일 내용을 읽어들임");
			fr.read();
		}
		finally { // 꼭 해주는 이유는 예외처리하고 finally가 없으면 도달안함 에외처리해도 도달해야하기 때문에 꼭 꼭 처리해야함
			fr.close();
		}
	}

}
