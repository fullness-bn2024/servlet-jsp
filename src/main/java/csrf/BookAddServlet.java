package csrf;

import java.io.IOException;
import java.util.UUID;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/book/add")
public class BookAddServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// JSPにフォワード
		request.getRequestDispatcher("/WEB-INF/book/book_add_input.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// パラメーターの取得
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		// リクエストスコープに保存
		request.setAttribute("title", title);
		request.setAttribute("author", author);
		// JSPにフォワード
		request.getRequestDispatcher("/WEB-INF/book/book_add_confirm.jsp").forward(request, response);
	}
}