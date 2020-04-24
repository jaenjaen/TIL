package exception.compile.test;

import java.io.FileNotFoundException;
import java.io.FileReader;

class FileReading3{
	public void readFile(String fileName) throws FileNotFoundException {
			FileReader fileReader = new FileReader(fileName); //compiler가 체크해서 오류났음 안잡으면 코드 못돌림
			System.out.println("File Reader Creating...");
	}
}

public class CompileTest3 {
	public static void main(String[] args) throws FileNotFoundException{
		FileReading3 fr = new FileReading3();
		String path = "C:\\lje\\poem.txt";
		
		fr.readFile(path);
		System.out.println("readFile Calling...");
		

	}

}
