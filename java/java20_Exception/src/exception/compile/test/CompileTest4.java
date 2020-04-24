package exception.compile.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CompileTest4 {

	public static void main(String[] args) {
		String path = "C:\\lje\\poem.txt";
		FileReader fr =null;
		
		System.out.println("1.파일리더 클래스 생성");
		try{
			fr = new FileReader(path); // 수도꼭지 오픈
			System.out.println("2.파일 내용을 읽어들임");
			fr.read();
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		finally {
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		
		
		
	}

}
