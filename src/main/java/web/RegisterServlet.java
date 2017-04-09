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
import domain.UserRank;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
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
		User newUser = this.buildUser(request);
		User foundUser = userRepository.getUserByUsername(newUser.getUsername());
		
		if(foundUser != null){
			response.getWriter().print("User with same username already exists!");
			return;
		}
		
		userRepository.add(newUser);
		
		//Od razu logujemy do systemu
		HttpSession session = request.getSession();
		session.setAttribute("user", newUser);
		response.sendRedirect("profile.jsp");
	}
	
	protected User buildUser(HttpServletRequest request){
		User user = new User();
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		user.setEmail(request.getParameter("email"));
		user.setRank(UserRank.USER);
		return user;
	}
	
}