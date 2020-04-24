package thread.step3.test;

import java.awt.Toolkit;

/*
 * 해당코드에서는 별도의 쓰레드를 작성하지 않고 실행
 * 경고음 발생 동시에 경고음을 콘솔로 프린팅 ( 병렬작업으로 처리하고 싶은 것)
 * 두가지일을 메인 아래에서 처리할 것
 */
public class BeepPrintTest1 {

	public static void main(String[] args) {
		Toolkit tool = Toolkit.getDefaultToolkit();
		
		//경고음 5번 울리는 작업
		 for(int i=0; i<5;i++){
			 tool.beep();
			 System.out.println("띵~");
			 try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		 }
		 
		 for(int i=0; i<5;i++){
			 System.out.println("띠링");
			 try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		 }
		

	}

}
