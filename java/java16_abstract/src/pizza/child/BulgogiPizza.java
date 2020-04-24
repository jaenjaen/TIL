package pizza.child;

import pizza.parent.Pizza;

public class BulgogiPizza extends Pizza{

	public BulgogiPizza(int Price, String storeName) {
		this.price = price;
		this.storeName = storeName;
	}
	
	@Override
	public void topping() {
		System.out.println("불고기 토핑 피자");
		
	}
}
