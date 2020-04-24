package thread.step5;
/*
 * 메가박스에서 좌석을 예매하는 일을 전담하는 쓰레드
 * reserve()라는 기능을 하나 작성 해 예매로직을 작성
 */
public class MegaBoxUser implements Runnable{
	private boolean seat = false; // 좌석 예매시 true;
	
	@Override
	public void run() {
		//예매하는 기능
		try{
			reserve();
		}catch(InterruptedException e){
			
		}
		
	}
	
	public synchronized void reserve() throws InterruptedException {
		String tName = Thread.currentThread().getName();
		System.out.println(tName+"님, 예매하러 오셨습니다.!");
		
		if(!seat) {
			Thread.sleep(2000);
			System.out.println(tName+"님, 예매 성공!");
			seat = true;
		} else {
			System.out.println(tName+"님, 이미 판매된 자리입니다.");
		}
		
	}
}
