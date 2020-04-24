package thread.step1.test;

public class GoComeThreadTest {

	public static void main(String[] args) {
	
		//thread 생성
		GoThread go = new GoThread("GoThread");
		ComeThread come = new ComeThread("ComeThread");
		
		//start호출
		//시간이 걸리지만 run이 cpu점유를 보장 받음.
		go.start(); // Runnable -> run(); -> run(){}
		come.start(); // Runnable -> run(); -> run(){}
	}

}
