package client;

import pattern.action.Action;
import pattern.factory.ActionFactory;

/*
 *  Factory Method Pattern 
 *  추상화 된 클래스(Action)의 객체(구상객체, 실체Class)를 생성하고 반환받는 방법
 * 
 *  구상객체를 실질적으로 생성하는 곳은 싱글톤 패턴으로 작성된 Factory에서 진행됨
 *  이때 인자값으로 넘겨져 오는 Command값에 따라서 서로 각각 다른 구상객체가 만들어진다.
 *  하지만, 정작 사용자(ServerSide에서의 Client;DispatcherServlet)에게는
 *  구상객체명이 hiding되어져서 넘겨진다.
 *  ->  추상화된 클래스 (Action)으로 넘겨진다는 이야기임.
 *  
 *  결국 클라이언트는 factory로부터 구상객체를 만들도록 요청하는 것임
 *  Factory는 요청에 해당하는 제품을 만들고, 인터페이스로 전달한다
 *  
 *  인터페이스의 메소드를 호출하면
 *  실질적으로 생성된 구상객체가 드디어 핵심적인 일 (비즈니스 로직호출)을 진행
 *  최종적으로 뷰 화면의 경로를 리턴받음.
 *  
 *  그리고 마무리로 Forward / sendRedirect로 응답함
 * 
 */
public class DispatcherMainTest {

	public static void main(String[] args) {
		String command= "INSERT";
		
		ActionFactory actionfactory = ActionFactory.getInstance();
		Action action = actionfactory.createAction(command);
		
		System.out.println(action.execute());
	}

}
