package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.LoginCheckLogic;
import model.User;
import model.UserCheck;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		int pass1 = Integer.parseInt(pass);

		//Userインスタンス（ユーザー情報）の生成
		User user = new User(name, pass1);

		//ログイン処理
		LoginCheckLogic lcl = new LoginCheckLogic();
		UserCheck uc = lcl.execute();

		//ログイン処理
		if(user.getName() == uc.getName() && user.getPass() == uc.getPass()) {
			//ユーザー情報をセッションスコープに保存
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", user);
		}else {
			request.setAttribute("errorMesage1", "アカウントが存在しないか、ID・パスワードが違います");
		}

		//ログイン画面にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/loginResult.jsp");
		dispatcher.forward(request, response);
	}

}
