package csrf;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sqlinjection.ConnectionManager;

@WebServlet("/book/add/complete")
public class BookAddCompleteServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// パラメーター取得
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		Connection conn = ConnectionManager.getConnection();
		try {
			// DBに登録
			String sql = "INSERT INTO books VALUES(?, ?, ?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, UUID.randomUUID().toString());
			stmt.setString(2, title);
			stmt.setString(3, author);
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new ServletException("DB error", e);
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new ServletException("DB error", e);
			}
		}
		request.setAttribute("title", title);
		request.getRequestDispatcher("/WEB-INF/book/book_add_complete.jsp").forward(request, response);
	}
}