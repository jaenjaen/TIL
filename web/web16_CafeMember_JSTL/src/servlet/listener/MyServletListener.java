package servlet.listener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.swing.plaf.synth.SynthSeparatorUI;

public class MyServletListener implements ServletContextListener{
	private ServletContext context;
	
	/*dd 읽고 ServletContext생성 그 다음 ServletContextEvent가 발생하면 listener감지-> 감지하지마자 호출
	가장 최초에 발생하는 메소드
	그렇기 때문에 컨테이너 차원의 초기화 로직은 여기서 작성*/
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("contextDestroyed");
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("ContextInitialization");
		
		//1.serverlet Context받아옴
		context = sce.getServletContext();
		
		//2. dd파일에 설정된 정보를 읽어온다.
		String filePath = context.getInitParameter("vipFile");
		System.out.println("filePath: "+filePath);
		
		//3.filePath에 들어있는 파일의 내용을 읽어온다 .. getResourceAsStream()
		InputStream is = null;
		BufferedReader br = null;
		
		try {
			System.out.println("getResourceAsStream() calling***");
			is = context.getResourceAsStream(filePath);
			br = new BufferedReader(new InputStreamReader(is));
			
			String line = null;
			System.out.println("파일의 내용을 읽어 들입니다.");
			while((line = br.readLine())!=null) System.out.println(line);
			
		}catch(IOException e){
			System.out.println("파일의 내용을 읽어오지 못했습니다.");
		}
	}
	
}
