package condition.test;

public class ConditionTest5 {

	public static void main(String[] args) {
		int dice = (int) (Math.random()*6)+1;
		String msg = "";
		
		switch(dice) {
		case 1: msg = "Dice 1"; break;
		case 2: msg = "Dice 2"; break;
		case 3: msg = "Dice 3"; break;
		case 4: msg = "Dice 4"; break;
		case 5: msg = "Dice 5"; break;
		case 6: msg = "Dice 6"; break;
		default: msg = "주사위에 없는 수";
		}
		System.out.println(msg);
	}

}
