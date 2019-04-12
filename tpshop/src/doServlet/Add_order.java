package doServlet;

import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import operator.CartOperator;
import operator.CdkeyOperator;
import operator.OrderOperator;
import operator.Order_goodOperator;
import operator.UserOperator;
import shiti.Cart;
import shiti.Cdkey;
import shiti.Good;
import shiti.Order;
import shiti.Order_good;
import shiti.User;
import util.CreateOrderNumber;
import util.GetDate;

/**
 * Servlet implementation class Add_order
 */
@WebServlet("/Add_order")
public class Add_order extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add_order() {
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
		GetDate g=new GetDate();
		UserOperator uo=new UserOperator();  //用户操作类
		CdkeyOperator co=new CdkeyOperator();  //获取激活码
		CartOperator cop=new CartOperator();  //删除购物车
		Order_goodOperator ogo=new Order_goodOperator();
		OrderOperator oo=new OrderOperator();
		int user_id=(int) session.getAttribute("user_id");
		User user=uo.initUser(user_id);
		String orderNumber=CreateOrderNumber.CreateOrderNumber(user_id);
		Order order=new Order();
		order.setOrderNumber(orderNumber);
		order.setUser(user);
		order.setTime(g.getDate());
		
		List carts=(List) session.getAttribute("carts");
		Iterator it=carts.iterator();
		while(it.hasNext()) {
			Cart cart=(Cart)it.next();
			Good good=cart.getGood();
			
			Order_good order_good=new Order_good();
			order_good.setGood(good);
			order_good.setOrder(order);
			
			for(int i=0;i<cart.getGood_count();i++) {
				/*获取一条Cdkey，并将其状态修改为1 已使用*/
				Cdkey cdkey=co.getOneCdkeyByGoodId(good.getId());
				cdkey.setState(1);
				cdkey.setUsed_time(new Date());
				/*生成订单商品对象 并建立与商品的单向关联，建立与订单和cdkey的双向关联*/
				order_good.getCdkeys().add(cdkey);
				
				/*cdkey和order与order_good的关联*/
				cdkey.setOrder_good(order_good); 
				order.getOrder_goods().add(order_good);
				co.update(cdkey);				
			}
			cart.setUser(null);
			cart.setGood(null);
			cop.deleteCart(cart);
		}
		
		user.getOrders().add(order);
		uo.updateUser(user);
		List order_goods=ogo.getOrder_goodByOrderId(order.getId());
		request.setAttribute("order", order);
		request.setAttribute("order_goods",order_goods);
		RequestDispatcher dis=request.getRequestDispatcher("checkout_success.jsp");
		dis.forward(request, response);
	}

}

