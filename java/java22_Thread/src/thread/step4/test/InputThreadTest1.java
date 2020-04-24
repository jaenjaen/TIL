package thread.step4.test;

import javax.swing.JOptionPane;

/*
 * MainThread만 진행되기 때문에 병렬 안됨
 * 로또번호를 입력받는 작업과 카운팅 작업이 병렬적으로 진행되어야함
 */
public class InputThreadTest1 {

	public static void main(String[] args) {
		//1. 데이터 입력
		String input = JOptionPane.showInputDialog("최종 로또 번호를 입력하세요");
		System.out.println("입력하신 숫자는 "+input+"입니다.");

		//2.일종의 카운팅 작업
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
