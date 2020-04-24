package thread.step4.test;

import javax.swing.JOptionPane;
/*
 * 카운팅은 countThread
 * 숫자입력 -  InputThread
 * 두 Thread간 Communication는 프로세스의 자원으로 해야함
 */
class CountThread extends Thread{
	private InputThreadTest3 process;
	
	CountThread(InputThreadTest3 process){
		this.process = process;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i= 10; i>0;i--) {
			
			if(process.inputCheck) break;
			
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}//for
		
		if(!InputThreadTest3.inputCheck) {
			System.out.println("값 입력 시간 초과");
			System.exit(0);
		}
	}
	
}

class InputThread extends Thread{

private InputThreadTest3 process;
	
	InputThread(InputThreadTest3 process){
		this.process = process;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		String input = JOptionPane.showInputDialog("최종 로또 번호를 입력하세요");
		System.out.println("입력하신 숫자는 "+input+"입니다.");
		process.inputCheck = true;
	}
	
}

public class InputThreadTest3 {
	static boolean inputCheck = false;
	
	public static void main(String[] args) {
		InputThreadTest3 process = new InputThreadTest3();
		
		CountThread ct = new CountThread(process);
		InputThread it = new InputThread(process);
		
		it.start();
		ct.start();
		//process상의 자원으로 통제
		
		
	}

}
