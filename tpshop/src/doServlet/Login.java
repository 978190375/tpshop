package doServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import operator.UserOperator;
import shiti.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		UserOperator uo=new UserOperator();
		RequestDispatcher dis;
		if(uo.Login(email, password)) {
			HttpSession session = request.getSession();
			session.setAttribute("user_id", uo.id);
			session.setAttribute("carts", uo.getUserById(uo.id).getCarts());
			User user=uo.getUserById(uo.id);
			
			if(user.getVip()==9)
				dis=request.getRequestDispatcher("back-stage/index.jsp");
			else
				dis=request.getRequestDispatcher("index.jsp");
		}
		else {
			dis=request.getRequestDispatcher("login.jsp");
		}
		dis.forward(request, response);
	}

}
