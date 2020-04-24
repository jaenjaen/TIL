package thread.step4.test;

import javax.swing.JOptionPane;
/*
 * step2
 * 카운팅 작업은 카운팅 작업대로
 * 팝업창 입력은 팝업창 대로
 * 
 * 메인스레드와
 * 작업스레드 -- 카운팅처리 
 */
class CountingThread implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i= 10; i>0;i--) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(i);
		}
	}
	
}
public class InputThreadTest2 {

	public static void main(String[] args) {
		CountingThread ct = new CountingThread();
		Thread tct = new Thread(ct,"CountingThread");
		
		
		//1. 데이터 입력
		String input = JOptionPane.showInputDialog("최종 로또 번호를 입력하세요");
		System.out.println("입력하신 숫자는 "+input+"입니다.");
		
		tct.start();
	}

}
