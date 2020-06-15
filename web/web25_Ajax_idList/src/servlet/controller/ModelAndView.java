package servlet.controller;

/*
 * 결과페이지 이름과 이동방식 
 * 이동방식(Forward || Redirect)에 대한정보를 담고있는객체
 * Model And View (라이브러리 이름)
 */
public class ModelAndView {
	private String path;
	private boolean isRedirect;
	
	public ModelAndView () {}
	
	public ModelAndView(String path, boolean isRedirect) {
		this.path = path;
		this.isRedirect = isRedirect;
	}
	
	public ModelAndView(String path) {this.path = path;}
	public String getPath() {return path;}
	public void setPath(String path) {this.path = path;}
	public boolean isRedirect() {return isRedirect;}
	public void setRedirect(boolean isRedirect) {this.isRedirect = isRedirect;}
	
	
}
