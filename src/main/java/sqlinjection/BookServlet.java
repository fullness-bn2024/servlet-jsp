package sqlinjection;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/book")
public class BookServlet extends HttpServlet {
  /*
   * 書籍一覧画面を表示する
   */
  protected void doGet(
    HttpServletRequest request, 
    HttpServletResponse response
  ) throws ServletException, IOException {
    String author = request.getParameter("author");
    List<Book> books = new ArrayList<>();
    String sql;
    if (author != null && !author.isEmpty()) {
      sql = "SELECT * FROM books WHERE author ='" + author + "' ORDER BY id";
    } else {
      sql = "SELECT * FROM books ORDER BY id";
    }
    Connection conn = ConnectionManager.getConnection();
    try {
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {
        books.add(new Book(
          rs.getString("id"),
          rs.getString("title"),
          rs.getString("author")));
      }
    } catch (SQLException e) {
      throw new ServletException("DB error", e);
    } finally {
      try {
        conn.close();
      } catch (SQLException e) {
        throw new ServletException("DB error", e);
      }
    }
    request.setAttribute("books", books);
    request
      .getRequestDispatcher("/WEB-INF/book/book.jsp")
      .forward(request, response);
  }
}