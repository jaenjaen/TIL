package pizza.child;

import pizza.parent.Pizza;

public class PotatoPizza extends Pizza{

	public PotatoPizza(int Price, String storeName) {
		this.price = price;
		this.storeName = storeName;
	}
	
	@Override
	public void topping() {
		System.out.println("포테이토 토핑 피자");
		
	}
}
