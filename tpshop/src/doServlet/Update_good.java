package doServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import operator.GoodOperator;
import shiti.Good;

/**
 * Servlet implementation class Update_good
 */
@WebServlet("/Update_good")
public class Update_good extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update_good() {
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
		int good_id=Integer.parseInt(request.getParameter("good_id"));
		GoodOperator go=new GoodOperator();
		Good good=go.getGood(good_id);
		request.setAttribute("good", good);
		RequestDispatcher dis=request.getRequestDispatcher("back-stage/product-manage/update_good.jsp");
		dis.forward(request, response);
	}

}
