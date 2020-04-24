package test;

public class FighterTest {

	public static void main(String[] args) {

		Fighter f = new Fighter();
		if(f instanceof Unit) {
			System.out.println("f는 Unit의 자손입니다.");
		}
		if(f instanceof Movable) {
			System.out.println("f는 Movable의 자손입니다.");
		}
		if(f instanceof Fightalbe) {
			System.out.println("f는 Fightalbe의 자손입니다.");
		}
		
	}

}

class Unit{
	int curHP; // 유닛체력
	int x; // x좌표
	int y; // y좌표
	
}

interface Movable{ void move(int x, int y);}

interface Attackable{
	void attack(Unit u);
}

//기능 강화
interface Fightalbe extends Movable,Attackable {}

class Fighter extends Unit implements Fightalbe{

	@Override
	public void move(int x, int y) {
		
	}

	@Override
	public void attack(Unit u) {
		
	}
	
}