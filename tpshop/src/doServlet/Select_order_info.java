package doServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import operator.CdkeyOperator;
import operator.OrderOperator;

/**
 * Servlet implementation class order_info
 */
@WebServlet("/Select_order_info")
public class Select_order_info extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Select_order_info() {
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

		OrderOperator oo=new OrderOperator();
		int order_page=Integer.parseInt(request.getParameter("order_page"));
		int size=10;
		int first=(order_page-1)*10;
		int order_count=0; //查询到的order总数量
		int order_pageCount=0;
		List orders=oo.getOrdersByUserId(first, size, user_id); //保存查询到的order
		request.setAttribute("orders", orders);
		order_count=oo.getOrderCount(user_id);
		
		request.setAttribute("order_page", order_page);
		if(order_count%size==0) //计算页面总数
			order_pageCount=order_count/size;
		else
			order_pageCount=order_count/size+1;
		request.setAttribute("order_pageCount", order_pageCount);
		

		RequestDispatcher dis=request.getRequestDispatcher("user/order_info.jsp");
		dis.forward(request, response);
	}

}
