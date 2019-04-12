package doServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import operator.CartOperator;
import operator.UserOperator;
import shiti.Cart;
import shiti.User;

/**
 * Servlet implementation class Delete_cart
 */
@WebServlet("/Delete_cart")
public class Delete_cart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete_cart() {
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
		int cart_id=Integer.parseInt(request.getParameter("cart_id"));
		CartOperator co=new CartOperator();
		UserOperator uo=new UserOperator();
		Cart cart=co.getCartById(cart_id);
		User user=uo.getUserById(cart.getUser().getId());
		user.getCarts().remove(cart);
		cart.setUser(null);
		cart.setGood(null);
		co.deleteCart(cart);
		RequestDispatcher dis=request.getRequestDispatcher("Show_cart");
		dis.forward(request, response);
	}

}
