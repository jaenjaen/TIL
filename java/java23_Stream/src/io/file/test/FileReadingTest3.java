package io.file.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/*
 * Source == 파일
 * Sink == 파일
 * 
 * 파일에 있는 내용을 읽어서
 * 또다른 파일로 출력
 * 
 * 
 */
public class FileReadingTest3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader( new FileReader("src\\hope.txt"));
		PrintWriter pw = new PrintWriter(new FileWriter("src\\data\\result.txt",true),true); // 경로에 있는건 만들어줘야함
		
		String line;
		try {
			line = "";
			while((line = br.readLine())!=null) {
				pw.println(line);
			}
			//bw.flush();
		}finally {
			br.close();
			//flush안해도 됨 닫기전에 저장소를 다 내보내기 때문
			//문자 출력일 때만 stream이 데이터를 읽어들이는 족족 출력하지 않고, 저장소에 데이터를 일정량을 모아뒀다가 출력함
		}
	}
}
