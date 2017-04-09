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

@WebServlet("/premiumUpdate")
public class PremiumUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserRepository userRepository;
	
	public void init(ServletConfig config) throws ServletException{
		this.userRepository = new DummyUserRepository();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
String username = request.getParameter("username");
		
		User foundUser = userRepository.getUserByUsername(username);
		if(foundUser == null || foundUser.getRank() == UserRank.ADMIN){
			response.getWriter().print("Bad username");
			return;
		}
		
		if(foundUser.getRank() == UserRank.USER){
			foundUser.setRank(UserRank.PREMIUM);
		}
		else{
			foundUser.setRank(UserRank.USER);
		}
		
		response.sendRedirect("users.jsp");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("/");
	}
	
}