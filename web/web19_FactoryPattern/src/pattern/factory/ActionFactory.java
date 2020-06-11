package pattern.factory;

import pattern.action.Action;
import pattern.action.AddAction;
import pattern.action.DeleteAction;
import pattern.action.UpdateAction;

/*
 * Action들을 만들어 내는 공장
 * Dispatcher에서 보내주는 command값에 따라 생성하는 Action이 달라진다.
 * 여러개의 Action들을 만들어 내지만 Factory는 단 하면 충분하기 때문에
 * Singleton Pattern으로 작성되어야 한다.
 */

public class ActionFactory {
	private static ActionFactory factory =new ActionFactory();
	private ActionFactory() {
		System.out.println("Factory is ready");
	}
	public static ActionFactory getInstance() {
		return factory;
	}
	
	//action을 생성하는 기능
	public Action createAction(String command) {
		Action action = null;
		
		if(command.equals("INSERT")) action = new AddAction();
		else if(command.equals("DELETE")) action = new DeleteAction();
		else action = new UpdateAction();
		
		return action;
	}
}
