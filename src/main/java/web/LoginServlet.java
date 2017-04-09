package web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import repositiories.DummyUserRepository;
import repositiories.UserRepository;
import domain.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserRepository userRepository;
	
	public void init(ServletConfig config) throws ServletException{
		this.userRepository = new DummyUserRepository();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		response.sendRedirect("/");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User foundUser = userRepository.getUserByUsername(username);
		if(foundUser == null || !foundUser.getPassword().equals(password)){
			response.sendRedirect("/");
			return;
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("user", foundUser);
		response.sendRedirect("profile.jsp");
	}
	
}