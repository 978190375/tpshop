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
 * Servlet implementation class update_user
 */
@WebServlet("/update_user")
public class Update_user extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update_user() {
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
		HttpSession session=request.getSession();
		int user_id=(int)session.getAttribute("user_id");
		String oldPassword=request.getParameter("oldPassWord");
		String newPassword=request.getParameter("newPassWord");
		UserOperator uo=new UserOperator();
		User user=uo.getUserById(user_id);
		System.out.println(user.getPassword());
		if(user.getPassword().equals(oldPassword)) {
			System.out.println(123);
			user.setPassword(newPassword);
		}
		uo.updateUser(user);
		RequestDispatcher dis=request.getRequestDispatcher("Select_user_info");
		dis.forward(request, response);
		
	}

}
