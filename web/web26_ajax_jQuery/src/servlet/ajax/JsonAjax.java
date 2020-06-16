package servlet.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import domain.Food;

@WebServlet("/JsonAjax")
public class JsonAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		//JSONObject 객체 생성(json.jar필요)
		JSONObject json = new JSONObject();
		/*json.put("name", "Jason");
		json.put("age", "26");
		json.put("addr", "NY");*/
		
		Food food = new Food();
		food.setMaker("banana");
		food.setPrice(3000);
		json.put("banana", food);
		out.print(json);
	}

}
