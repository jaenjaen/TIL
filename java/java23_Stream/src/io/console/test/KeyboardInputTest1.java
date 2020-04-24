package io.console.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 키보드로 데이터를 읽어들여서
 * 콘솔로 출력하는 로직을 작성
 * Source -> 키보드
 * Sink ->  콘솔
 * 
 * 1.stream생성 : 입력스트림만 필요 (출력스트림 안 필요)
 * InputStreamReader, BufferedReader -> 문자읽어 들일 때 씀 래핑하는 이유는 한줄로 모아 읽을라고
 * 2.데이터 입력
 * readLint()
 * 3. 콘솔출력
 * System.out.printlne()
 */
public class KeyboardInputTest1 {

	public static void main(String[] args) {
		
		//1.생성
		System.out.println("Stream 생성******");
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);
		
		//2.읽어들임
		try {
			System.out.println("Read Line으로 읽음******");
			String line = br.readLine();
			while(line!=null) {
			System.out.println("Reading data: "+line);
			line = br.readLine();
			
			if(line.equals("0")) break;
			}
		} catch (IOException e) {
		}
		finally{
			try {
				br.close();
			} catch (IOException e) {
			}
		}
	}

}
