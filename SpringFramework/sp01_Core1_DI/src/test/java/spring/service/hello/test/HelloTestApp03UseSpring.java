package spring.service.hello.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory; //defrecated == 곧 없어진단 소리 == 원시적임
import org.springframework.core.io.FileSystemResource;

import spring.service.greet.Greet;

public class HelloTestApp03UseSpring {
/*
 * 파일 loading시,
 * ClassPathSystem - src를 이미 먹고 들어감
 * FilePthSystem - src부터 다시 인식시켜야함
 */
	public static void main(String[] args) {
		
		//1.BeanFactory 생성 -> 주문서는 공장에서 미리 받아 읽어 놔야함
		// == 공장 생성 시, 주문서 함께 인자 값으로 넣어줌.
		// 주문서 == bean Configuration File (빈 설정 문서)
		//BeanFactory는 Container
		System.out.println("Bean Factory 생성");
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("./src/main/resources/config/greet.xml"));
		//java.lang.NoClassDefFoundError: org/apache/commons/logging/LogFactory - lib 안넣어서 에러 == lib 사이의 dependency 발생
		
		//2. getBean()으로 Bean을 받아와서 method호출
		System.out.println("getBean 호출");
		/*
		 * Greet g1 = (Greet) factory.getBean("greet1"); //여기서 bean이 생성된다.
		 * g1.printMessage();
		 */	
		
		/*
		 * Greet g2 = (Greet) factory.getBean("greet2"); g2.printMessage();
		 */
		
		/*
		 * Greet g3 = (Greet) factory.getBean("greet3"); g3.printMessage();
		 */
		
		Greet g4 = (Greet) factory.getBean("greet4");
		g4.printMessage();
	}

}
