package doServlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import operator.CdkeyOperator;
import shiti.Cdkey;

/**
 * Servlet implementation class Show_cdkey
 */
@WebServlet("/Show_cdkey")
public class Show_cdkey extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Show_cdkey() {
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
		int cdkey_page=Integer.parseInt(request.getParameter("cdkey_page"));
		int size=10;
		int first=(cdkey_page-1)*10;
		int cdkey_count=0; //查询到的cdkey总数量
		int cdkey_pageCount=0;
		CdkeyOperator co=new CdkeyOperator();
		List cdkeyList=co.findCdkey(first, size, good_id); //保存查询到的cdkey
		request.setAttribute("cdkeyList", cdkeyList);
		
		cdkey_count= co.getCdkeyCount(good_id);
			
		request.setAttribute("good_id", good_id);
		request.setAttribute("cdkey_page", cdkey_page);
		if(cdkey_count%size==0) //计算页面总数
			cdkey_pageCount=cdkey_count/size;
		else
			cdkey_pageCount=cdkey_count/size+1;
		request.setAttribute("cdkey_pageCount", cdkey_pageCount);
		

		RequestDispatcher dis=request.getRequestDispatcher("back-stage/cdkey-manage/show_cdkey.jsp");
		dis.forward(request, response);
	}

}
