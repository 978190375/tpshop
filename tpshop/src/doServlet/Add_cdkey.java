package doServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import operator.CdkeyOperator;
import operator.GoodOperator;
import shiti.Cdkey;
import shiti.Good;

/**
 * Servlet implementation class Add_cdkey
 */
@WebServlet("/Add_cdkey")
public class Add_cdkey extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add_cdkey() {
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
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		int good_id=Integer.parseInt(request.getParameter("good_id"));
		String cdkeys=request.getParameter("cdkeys");

		String [] cdkey=cdkeys.split("\r\n");	 //输入多行数据，根据换行符\r\n来分割为数组

		CdkeyOperator co=new CdkeyOperator();
		GoodOperator go=new GoodOperator();
		Good good=go.getGood(good_id);

		Cdkey[] cs=new Cdkey[cdkey.length];//创建需要保存的cdkey对象数组
		
		for(int i=0;i<cdkey.length;i++) {
			cs[i]=new Cdkey();
			cs[i].setCdkey(cdkey[i]);
			cs[i].setState(0);
			cs[i].setGood(good);
			cs[i].setOrder_good(null);
			good.getCdkeys().add(cs[i]);
		}
		co.saveCdkeys(cs); //保存该数组
		RequestDispatcher dis=request.getRequestDispatcher("back-stage/cdkey-manage/add_cdkey.jsp");
		dis.forward(request, response);
		
	}

}
