package xss;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/get-session")
public class SaveSessionIdServlet extends HttpServlet {
	/*
	 * セッションIDを受け取る
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sid = request.getParameter("sid");
		System.out.println(sid);
		PrintWriter out = response.getWriter();
		out.println("get session!!" + sid);
	}
}