package thread.step3.test;

import java.awt.Toolkit;
/*
 * BeepPrintTest1 실행클래스 - > 하나의 프로세스
 * 이 안에는 메인쓰레드 하나 밖에 없었다. - > 병렬작업 X
 * BeepPrintTest2
 * 이 안에 메인쓰레드와 동시에 작업쓰레드 하나를 더 추가 
 * 1) 메인쓰레드 beep 5번 울림
 * 2) 작업쓰레드 - beepThread -> '띵'을 5번 출력
 */

class BeepThread extends Thread{
	
	public void run() {
		for(int i=0; i<5;i++){
			 System.out.println("띵");
			 try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		 }
	}
}

public class BeepPrintTest2 {

	public static void main(String[] args) {
		Toolkit tool = Toolkit.getDefaultToolkit();
		BeepThread bp = new BeepThread();
		bp.start(); // 여기서부터 병렬적으로 프로그래밍이 돌아감
		
		//경고음 5번 울리는 작업
		 for(int i=0; i<5;i++){
			 tool.beep();
			 try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		 }
	}

}
