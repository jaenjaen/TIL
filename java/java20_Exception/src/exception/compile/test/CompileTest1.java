package exception.compile.test;

import java.io.FileNotFoundException;
import java.io.FileReader;

class FileReading{
	public void readFile(String fileName) {
		try {
			FileReader fileReader = new FileReader(fileName); //compiler가 체크해서 오류났음 안잡으면 코드 못돌림
			System.out.println("File Reader Creating...");
		}
		catch(FileNotFoundException e) { // file이 없을때나 path 잘못 넣었을 때
			e.printStackTrace();
		}
	}
}

public class CompileTest1 {
	public static void main(String[] args) {
		FileReading fr = new FileReading();
		String path = "C:\\lje\\poem.txt";
		
		fr.readFile(path);
		System.out.println("readFile Calling...");
		

	}

}
