package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DaoFactory;
import model.Utente;

/**
 * Servlet Filter implementation class UtenteFilter
 */
@WebFilter("/UtenteFilter")
public class UtenteFilter implements Filter {
	@SuppressWarnings("unused")
	private FilterConfig filterConfig;

	public UtenteFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		Utente utente = (Utente) request.getSession().getAttribute("utente");
		if (utente != null) {
			chain.doFilter(request, response);
		} else {
			response.sendRedirect(request.getContextPath() + "/login");
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		this.filterConfig = fConfig;
	}

}
