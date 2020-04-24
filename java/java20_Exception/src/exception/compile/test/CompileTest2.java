package exception.compile.test;

import java.io.FileNotFoundException;
import java.io.FileReader;

class FileReading2{
	public void readFile(String fileName) throws FileNotFoundException{
			FileReader fileReader = new FileReader(fileName); //compiler가 체크해서 오류났음 안잡으면 코드 못돌림
			System.out.println("File Reader Creating...");
	}
}

public class CompileTest2 {
	public static void main(String[] args) {
		FileReading2 fr = new FileReading2();
		String path = "C:\\lje\\poem.txt";
		
		try {
			fr.readFile(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("readFile Calling...");
		

	}

}
