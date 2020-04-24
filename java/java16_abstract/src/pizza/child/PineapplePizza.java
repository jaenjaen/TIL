package pizza.child;

import pizza.parent.Pizza;

public class PineapplePizza extends Pizza{

	public PineapplePizza(int Price, String storeName) {
		this.price = price;
		this.storeName = storeName;
	}
	
	@Override
	public void topping() {
		System.out.println("파인애플 토핑 피자");
		
	}
}
