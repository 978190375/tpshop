package doServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import operator.OrderOperator;
import operator.Order_goodOperator;
import shiti.Order;
import shiti.Order_good;

/**
 * Servlet implementation class Show_user_order
 */
@WebServlet("/Show_user_order")
public class Show_user_order extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Show_user_order() {
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
		int order_id=Integer.parseInt(request.getParameter("order_id"));
		OrderOperator oo=new OrderOperator();
		Order_goodOperator ogo=new Order_goodOperator();
		Order order=oo.getOrderById(order_id);
		List order_goods=ogo.getOrder_goodByOrderId(order_id);
		request.setAttribute("order", order);
		request.setAttribute("order_goods", order_goods);
		RequestDispatcher dis=request.getRequestDispatcher("user/show_order.jsp");
		dis.forward(request, response);
	}

}
