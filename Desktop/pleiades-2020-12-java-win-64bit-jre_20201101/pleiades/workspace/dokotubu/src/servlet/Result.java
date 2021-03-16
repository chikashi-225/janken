package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.RegistAccountLogic;
import model.User;

/**
 * Servlet implementation class Result
 */
@WebServlet("/Result")
public class Result extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//リクエストパラメータを取得
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		int pass1 = Integer.parseInt(pass);

		//Userインスタンスを生成
		User user = new User(name, pass1);

		//RegistAccountLogicを呼び出す
		RegistAccountLogic ral = new RegistAccountLogic();

		//アカウント登録処理
		boolean gouhi = ral.execute(user);
		if(gouhi == true) {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", user);
		}else {
			request.setAttribute("errorMasege2", "同じパスワードが存在するか、数字以外の記号が使われています");
		}

		//アカウント登録画面へフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/registResult");
		dispatcher.forward(request, response);
	}

}
