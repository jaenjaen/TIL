package pizza.test;

import java.util.Vector;

import javax.swing.plaf.synth.SynthSeparatorUI;

import pizza.child.BulgogiPizza;
import pizza.child.PineapplePizza;
import pizza.child.PotatoPizza;
import pizza.parent.Pizza;
import pizza.service.PizzaService;

public class PizzaServiceTest {

	public static void main(String[] args) {
		PizzaService service =  new PizzaService();
		Vector<Pizza> v = new Vector<>(); // vector는 size따로 기입 안해도 됨 기본적으로 10칸 짜리 만들어짐
		
		v.add(new PotatoPizza(12000, "Pizza School"));
		v.add(new BulgogiPizza(22000, "Pizza hut"));
		v.add(new PineapplePizza(27000, "Domino Pizza"));
		v.add(new BulgogiPizza(25000, "Mister Pizza"));
		
		System.out.println("number of pizza in vector: "+v.size()); // 저장된 데이타갯수
		System.out.println("a Capacity of Vector: "+v.capacity()); // 벡터의 용량
		System.out.println("Pizza Information:" +v); // 객체정보
		
		service.allMakePizza(v);

	}

}
