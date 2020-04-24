package chatting.step3.client;

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
			pw = new PrintWriter(s.getOutputStream(),true); //auto flush
			
			ClientThread ct = new ClientThread(s);
			ct.start();//서버가 보낸 것 읽기
			
			while(true) {
				String line = br.readLine();
				pw.println(line); // 서버로 보내기
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

//서버가 던지는 데이터를 받는 thread를 만들어야함
class ClientThread extends Thread{
	Socket s;
	BufferedReader br2;
	String str;
	
	ClientThread(Socket s){
		this.s = s;
	}
	
	public void run() {
		try {
			br2 = new BufferedReader(new InputStreamReader(s.getInputStream()));
			while(true) {
				str = br2.readLine();
				System.out.println("서버메세지: "+str);
			}
			
		}catch(Exception e) {
			
		}
	}
}
