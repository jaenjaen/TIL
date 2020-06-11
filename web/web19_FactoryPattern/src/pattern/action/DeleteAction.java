package pattern.action;

/*
 * AddAction = component
 * component? "인터페이스 기반"으로 작성되어서 재사용성이 강한 자바클래스
 *
 */

public class DeleteAction implements Action{

	@Override
	public String execute() {
		/*
		 * 1. 폼값 받아서
		 * 2. DAO 리턴
		 * 3. 비즈니스 로직 호출
		 * 4. 바인딩
		 * 5. 네비게이션
		 * 6. path리턴
		 */
		return delete();
	}

	private String delete() {
		//위의 로직이 수행되었다고 가정
		return "Delete OK!";
	}

}
