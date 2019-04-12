package doServlet;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import operator.CartOperator;
import operator.GoodOperator;
import operator.UserOperator;
import shiti.Cart;
import shiti.Good;
import shiti.User;

/**
 * Servlet implementation class Add_cart
 */
@WebServlet("/Add_cart")
public class Add_cart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add_cart() {
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
		HttpSession session=request.getSession();
		int user_id	= (int) session.getAttribute("user_id");
		int good_id = Integer.parseInt(request.getParameter("good_id"));
		CartOperator co=new CartOperator();
		Cart cart=co.getCartByUserAndGood(user_id,good_id);
		if(cart!=null){
			cart.setGood_count(cart.getGood_count()+1);
			co.updateCart(cart);
		}
		else {
			cart=new Cart();
			UserOperator uo=new UserOperator();
			GoodOperator go=new GoodOperator();
			User user=uo.getUserById(user_id);
			Good good=go.getGood(good_id);
			cart.setGood(good);
			cart.setUser(user);
			cart.setGood_count(1);
			user.getCarts().add(cart);
			co.saveCart(cart);
			
		}
		RequestDispatcher dis=request.getRequestDispatcher("Show_cart");
		dis.forward(request, response);
	}

}
