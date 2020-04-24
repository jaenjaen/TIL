package thread.step2.test;

public class GoComeThreadTest {

	public static void main(String[] args) {
		
		GoThread go2 = new GoThread();
		ComeThread come2 = new ComeThread();
		
		Thread tgo = new Thread(go2, "GoThread");
		Thread tcome = new Thread(come2,"ComeThread");
		
		tgo.start();
		tcome.start();
	}

}
