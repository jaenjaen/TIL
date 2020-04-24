package io.file.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * Source == 파일
 * Sink == 콘솔
 * 
 * 파일에 있는 내용을 읽어서
 * 콘솔로 출력하는 로직 작성
 * 
 * 
 */
public class FileReadingTest1 {

	public static void main(String[] args) throws IOException {
		File file = new File("src\\hope.txt");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		
		String line;
		try {
			line = "";
			while((line = br.readLine())!=null) {
				System.out.println("Reading Data: " + line);
			}
		}finally {
			br.close();
		}
	}
}
