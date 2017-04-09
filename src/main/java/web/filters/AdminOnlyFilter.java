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
import javax.servlet.http.HttpSession;

import domain.User;
import domain.UserRank;

@WebFilter({"/users.jsp"})
public class AdminOnlyFilter implements Filter {

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		HttpSession session = httpRequest.getSession();
		if(session.getAttribute("user") == null){
			httpResponse.sendRedirect("/");
			return;
		}
		
		User user = (User) session.getAttribute("user");
		if(user.getRank() != UserRank.ADMIN){
			httpResponse.sendRedirect("/profile.jsp");
			return;
		}
		
		chain.doFilter(request, response);

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		

	}

}
