package xss;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/keijiban")
public class KeijibanServlet extends HttpServlet {
	private List<String> messages = new ArrayList<>();
	/**
	 * メッセージ一覧画面を表示する
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 request.setAttribute("messages", messages);
		 request.getRequestDispatcher("/WEB-INF/xss/keijiban.jsp").forward(request, response);
	}

	/*
	 * メッセージを登録する
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// パラメーター取得
		String message = request.getParameter("message");
		// ArrayListに追加
		messages.add(message);
		// リダイレクト
		response.sendRedirect("./keijiban");
	}
}