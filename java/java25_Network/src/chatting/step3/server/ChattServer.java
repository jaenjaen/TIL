 package chatting.step3.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

//process
public class ChattServer {
	ServerSocket server;
	Socket s;
	ArrayList<chattThread> list;

	public ChattServer() {
		list = new ArrayList<>();
	}
	//통신관련 로직
	public void go() {
		
		try {
			server = new ServerSocket(60000);
			System.out.println("Server is ready");
			
			while(true) {
				s = server.accept();
				chattThread ct = new chattThread(s,this);//process공유
				list.add(ct);
				ct.start(); // run으로 이동
			}
		}catch(Exception e) {
		}
	}
	
	public void broadcast(String msg) {
		for(chattThread t: list) {
			t.sendMsg(msg);
		}
	}
	
	public static void main(String[] args)  {
		ChattServer cs = new ChattServer();
		cs.go();
		
	}

}

class chattThread extends Thread{
	Socket s;
	BufferedReader br;
	PrintWriter pw;
	ChattServer chattServer;
	
	chattThread(Socket s, ChattServer chattServer) {
		 this.s = s;
		 this.chattServer = chattServer;
		 System.out.println(s.getInetAddress()+"님이 접속하셨습니다.");
		 chattServer.broadcast(s.getInetAddress()+"님이 접속하셨습니다.");
	}
	
	public void sendMsg(String msg) {
		pw.println(msg);
	} // 상대편 클라이언트에게 전송

	public void run() {
		try {
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			pw = new PrintWriter(s.getOutputStream(),true);
			
			while(true) {
				String line = br.readLine();
				chattServer.broadcast(line);
			}
			
		}catch(IOException e){
			//연결이 끊켜서 이동
			System.out.println(s.getInetAddress()+"님의 접속을 끊으셨습니다.");
			chattServer.broadcast(s.getInetAddress()+"님이 채팅방을 나가셨습니다.");
			chattServer.list.remove(this);
		}
		
	}
	
}