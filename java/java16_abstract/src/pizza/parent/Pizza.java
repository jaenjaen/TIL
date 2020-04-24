package pizza.parent;
/*
 * 추상클래스 용도
 * 1. 여러종류의 피자를 만들때, 피자로서의 공통적인 부분(필드, 메소드)은 부모가 가진 성질을 그대로 물려주고
 * 2. 반면 서로다른 피자가 만들어지는 결정적 부분은 추상메소드로 자식에게 물려주어
 * 	  자식이 본인에 맞도록 직접 구현하도록 함
 */
public abstract class Pizza {
	
	protected int price;
	protected String storeName;
	
	
	public Pizza(int price, String storeName) {
		super();
		this.price = price;
		this.storeName = storeName;
	}

	public Pizza() {}
	
	
	public void makePizza() {
		dough();
		topping();
		bake();
		cut();
		box();
		
	}
	
	public void dough(){
		System.out.println("피자반죽과 함께 도우를 빚다.");
	}
	
	public void box(){
		System.out.println("boxing...");
	}
	
	public void bake(){
		System.out.println("피자를 180도에서 10분간 구워냅니다.");
	}
	
	public void cut(){
		System.out.println("피자를 8등분으로 자릅니다.");
	}
	
	public abstract void topping();

	@Override
	public String toString() {
		return storeName+" "+price+"원";
	}


}
