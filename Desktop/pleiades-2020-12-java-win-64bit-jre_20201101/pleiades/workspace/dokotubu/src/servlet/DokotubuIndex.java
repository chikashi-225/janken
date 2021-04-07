package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.SiteEV;
import model.SiteEVLogic;

/**
 * Servlet implementation class DokotubuIndex
 */
@WebServlet("/DokotubuIndex")
public class DokotubuIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext application = this.getServletContext();
		SiteEV siteEV = (SiteEV) application.getAttribute("siteEV");

		//�T�C�g�]���̏������i���񃊃N�G�X�g�����s�j
		if(siteEV == null) {
			siteEV = new SiteEV();
		}

		//���N�G�X�g�p�����[�^�̎擾
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");

		//�T�C�g�̕]�������i���񃊃N�G�X�g���͎��s���Ȃ��j
		SiteEVLogic siteEVLogic = new SiteEVLogic();
		if(action != null && action.equals("like")) {
			siteEVLogic.like(siteEV);
		} else if(action != null && action.equals("dislike")) {
			siteEVLogic.dislike(siteEV);
		}

		//�A�v���P�[�V�����X�R�[�v�ɃT�C�g�]����ۑ�
		application.setAttribute("siteEV", siteEV);



		//�t�H���[�h
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
		dispatcher.forward(request, response);
	}

}
