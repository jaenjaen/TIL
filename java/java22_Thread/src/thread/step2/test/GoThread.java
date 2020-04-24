package thread.step2.test;

/*
 * 쓰레드 만드는 방법
 * 1. extends Thread
 * 2. implements Runnable
 */
public class GoThread implements Runnable{
	
	/*
	public GoThread(String name) {
		super(name);
	}*/
	
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
