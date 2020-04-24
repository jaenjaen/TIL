package chatting.step2.client;
/*
 * 키보드로 입력받은 데이터를 읽어서
 * 서버로 출력한다.
 * 다시 서버가 보낸 메세지를 받아서
 * 클라이언트 자신의 콘솔에 출력
 * 
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
	BufferedReader br,br1;
	PrintWriter pw;
	
	
	public void go() {
		try {
			s = new Socket("192.168.0.33",60000);
			System.out.println("Client Socket Creating!");
			
			br = new BufferedReader(new InputStreamReader(System.in));
			br1 = new BufferedReader(new InputStreamReader(s.getInputStream()));
			
			pw = new PrintWriter(s.getOutputStream(),true); //auto flush
			System.out.println("Client Stream 생성");
			
			while(true) {
				String line = br.readLine();
				pw.println(line);
				
				/////////////////서버가 보내는거 읽기
				String servermsg = br1.readLine();
				System.out.println("서버가 보낸 메세지: "+ servermsg);
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
