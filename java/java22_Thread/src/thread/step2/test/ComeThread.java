package thread.step2.test;

public class ComeThread implements Runnable{
	
	/*public ComeThread(String name) {
		super(name);
	}*/
	
	//쓰레드가 작동하는 부분
	public void run() {
		int i =0;
		while(true) {
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				
			}
			String tname = Thread.currentThread().getName();
			System.out.println("Current Thread::"+tname+" "+i);
			i++;
			if(i == 20) break;
		}
	}
	
	
}
