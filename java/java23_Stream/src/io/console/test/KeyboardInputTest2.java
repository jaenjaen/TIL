package io.console.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 키보드로 데이터를 읽어서
 * 콘솔로 출력 하는 로직
 */

public class KeyboardInputTest2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("키보드로 데이터를 입력하세요: ");
		String line = " ";
		try{
				while((line=br.readLine())!= null) {
					if(line.equals("고마해라")) {
						System.out.println("입력금지 종료합니다.");
						break;
						}
					else System.out.println("Reading Data: "+line);
				}
		}finally {
			br.close();
		}
	}

}
