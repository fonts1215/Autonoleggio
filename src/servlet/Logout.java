package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Cookie;

/**
 * Servlet implementation class Logout
 */
@WebServlet("/Logout")
public class Logout extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("LOGOUTSERVLET");
		HttpSession session = request.getSession();
		Cookie[] cookies = request.getCookies();
		for (Cookie c : cookies) {
			Cookie cookie = new Cookie("email", -1 + "");
			Cookie cookie2 = new Cookie("password", -1 + "");
			cookie.setMaxAge(3600);
			cookie2.setMaxAge(3600);
			response.addCookie(cookie);
			response.addCookie(cookie2);
		}
		session.invalidate();
		new Login().doGet(request, response);
	}
}
