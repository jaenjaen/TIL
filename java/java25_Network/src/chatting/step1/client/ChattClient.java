package chatting.step1.client;
/*
 * 키보드로 입력받은 데이터를 읽어서
 * 서버로 출력한다.
 * 입력 2 자체적으로
 * 출력 2 소켓
 * 
 * client측 로직
 * 1. 소켓생성
 * 2. 스트림
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChattClient {
	Socket s;
	BufferedReader br;
	PrintWriter pw;
	
	
	public void go() {
		try {
			s = new Socket("127.0.0.1",60000);
			System.out.println("Client Socket Creating!");
			
			br = new BufferedReader(new InputStreamReader(System.in));
			pw = new PrintWriter(s.getOutputStream(),true); //auto flush
			System.out.println("Client Stream 생성");
			
			String line = "";
			while((line = br.readLine())!=null) {
				pw.println(line);
			}
			
		}catch(Exception e) {
			System.out.println("서버와의 연결을 실패했습니다.");
		}
		
	}
	public static void main(String[] args) {

		ChattClient cc = new ChattClient();
		cc.go();
	}

}
