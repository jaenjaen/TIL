package servlet.controller;

public class HandlerMapping {
	private static HandlerMapping handler = new HandlerMapping();
	private HandlerMapping() {}
	public static HandlerMapping getInstance() {
		return handler;
	}
	
	public Controller createController(String command) {
		Controller controller = null;
		
		if(command.equals("find.do")) {
			controller = new FindController();
			System.out.println("findController 생성됨");
		}
		else if(command.equals("logout.do")) {
			controller = new LogoutController();
			System.out.println("LogoutController 생성됨");	
		}
		else if(command.equals("login.do")) {
			controller = new LoginController();
			System.out.println("LoginController 생성됨");	
		}
		else if(command.equals("memberlist.do")) {
			controller = new MemberListController();
			System.out.println("MemberListController 생성됨");	
		}
		else if(command.equals("update.do")) {
			controller = new UpdateController();
			System.out.println("UpdateController 생성됨");	
			
		}
		else if(command.equals("idcheck.do")) {
			controller = new IdCheckController();
			System.out.println("IdCheckController 생성됨");	
			
		}
		else{ //(command.equals("register.do"))
			controller = new RegisterController();
			System.out.println("RegisterController 생성됨");	
		}
		return controller;
	}

}
