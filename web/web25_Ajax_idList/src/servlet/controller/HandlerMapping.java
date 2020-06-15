package servlet.controller;

public class HandlerMapping {
	private static HandlerMapping handler = new HandlerMapping();
	private HandlerMapping() {}
	public static HandlerMapping getInstance() {
		return handler;
	}
	
	public Controller createController(String command) {
		Controller controller = null;
		
		if(command.equals("idList.do")) {
			controller = new IdListController();
			System.out.println("IdListController 생성됨");	
		}else if(command.equals("idCheck.do")) {
			controller = new IdCheckController();
			System.out.println("IdCheckController 생성됨");
		}
		else {
			controller = new FindController();
			System.out.println("FindController 생성됨");
		}
		return controller;
	}

}
