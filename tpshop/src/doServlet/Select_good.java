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

import operator.GoodOperator;

/**
 * Servlet implementation class Select_good
 */
@WebServlet("/Select_good")
public class Select_good extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Select_good() {
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
		int size=10;
		int page=Integer.parseInt(request.getParameter("good_page"));
		int first=(page-1)*10;
		int good_count=0;
		int pageCount=0;
		GoodOperator go=new GoodOperator();
		List goods=go.findGood(first, size);
		if(goods!=null)
			request.setAttribute("goods", goods);
		HttpSession session=request.getSession();
		good_count=go.getGoodCount();
		request.setAttribute("good_page", page);
		if(good_count%size==0) //计算页面总数
			pageCount=good_count/size;
		else
			pageCount=good_count/size+1;
		request.setAttribute("pageCount", pageCount);
		
		RequestDispatcher dis=request.getRequestDispatcher("back-stage/product-manage/select_goods.jsp");
		dis.forward(request, response);
	}

}
