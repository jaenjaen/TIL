 package chatting.step2.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 클라이언트가 보낸 메세지를 받아서
 * 자신의 콘솔창에받은 메세지를 출력
 * 
 * 서버측 로직 
 * 1. Seversocket(int port) - port 60000
 * 2. Return Socket by Accept() when Client accept server
 * 3. Return Stream from socket
 */
public class ChattServer {
	ServerSocket server;
	Socket s;
	BufferedReader br;
	PrintWriter pw;
	
	//통신관련 로직
	public void go() {
		try {
			server = new ServerSocket(60000);
			System.out.println("Sever Ready!");
			
			s = server.accept();
			System.out.println(s.getInetAddress()+"님이 접속하셨습니다.");
			System.out.println("Client Socket Return~");
			
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			pw = new PrintWriter(s.getOutputStream(), true);
			
			String line = null;
			while((line = br.readLine()) != null) {
				pw.println(line);
			}
			br.close();
		}catch(Exception e) {
			System.out.println("연결이 끊어졌습니다.");
		}
	}
	
	public static void main(String[] args)  {
		ChattServer cs = new ChattServer();
		
		cs.go();
		
	}

}
