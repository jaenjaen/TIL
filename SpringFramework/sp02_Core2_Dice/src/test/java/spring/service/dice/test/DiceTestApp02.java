package spring.service.dice.test;

import spring.service.dice.impl.DiceAimpl;
import spring.service.dice.impl.DiceBimpl;
import spring.service.dice.impl.DiceCimpl;
//spring 안쓰고 interface만으로 재사용성 높임 
import spring.service.dice.play.Player02;

public class DiceTestApp02 {
	///Main Method
	public static void main(String[] args){
		
		Player02 player01 = new Player02(new DiceAimpl());
		player01.playDice(3);
		System.out.println("=======================");
		System.out.println("선택된 주사위 수의 통합은 : "+player01.getTotalValue());
		System.out.println("=======================");
		
		Player02 player02= new Player02(new DiceBimpl());
		player02.playDice(3);
		System.out.println("=======================");
		System.out.println("선택된 주사위 수의 통합은 : "+player01.getTotalValue());
		System.out.println("=======================");
		
		Player02 player03 = new Player02(new DiceCimpl());
		player03.playDice(3);
		System.out.println("=======================");
		System.out.println("선택된 주사위 수의 통합은 : "+player01.getTotalValue());
		System.out.println("=======================");
		
	}
}//end of class

