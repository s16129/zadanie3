/**
 * 
 */
package web.filters;

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

@WebFilter("/register")
public class CompleteRegisterFilter implements Filter {

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		//Kompletny zestaw parametrow
		if(httpRequest.getParameter("username") == null
				|| httpRequest.getParameter("username") == ""
				|| httpRequest.getParameter("password") == null
				|| httpRequest.getParameter("password") == ""
				|| httpRequest.getParameter("confirm_password") == null
				|| httpRequest.getParameter("confirm_password") == ""
				|| httpRequest.getParameter("email") == null
				|| httpRequest.getParameter("email") == ""){
			httpResponse.sendRedirect("/register.jsp");
			return;
		}
		
		//Potwierdzenie hasla
		if(!httpRequest.getParameter("password").equals(httpRequest.getParameter("confirm_password"))){
			httpResponse.getWriter().print("Typed passwords did not match");
			return;
		}
		
		chain.doFilter(request, response);

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		

	}

}
