package doServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.io.File;
import java.util.Arrays;
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

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import operator.GoodOperator;
import operator.StringToDate;
import shiti.Good;
import shiti.Image;
import operator.ImageOperator;

/**
 * Servlet implementation class Add_goods
 */
@WebServlet("/Add_goods")
public class Add_goods extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Add_goods() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 声明变量
		 * 中文处理
		 * */
		Good good = new Good();
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
			
		
		try {
			String name = request.getParameter("game_name");
			good.setName(name); // 游戏名称
			
			String[] tip = request.getParameterValues("game_tips");
			if (tip == null)
				System.out.print("tip null");
			String tips = "";
			for (int i = 0; i < tip.length; i++) {
				tips += tip[i] + ",";
			}
			tips = tips.substring(0, tips.length() - 1);
			good.setTips(tips); // 游戏类型

			int platform = Integer.parseInt(request.getParameter("platform"));
			good.setPlatform(platform); // 游戏平台

			int region = Integer.parseInt(request.getParameter("region"));
			good.setRegion(region); // 游戏地区

			String[] lan = request.getParameterValues("language");
			String language = "";
			for (int i = 0; i < lan.length; i++) {
				language += lan[i] + ",";
			}
			language = language.substring(0, language.length() - 1);
			good.setLanguage(language); // 游戏语言
			
			String product_time = request.getParameter("product-time-year") + "-"
					+ request.getParameter("product-time-month") + "-" + request.getParameter("product-time-day");
			good.setProduct_time(StringToDate.StringToDate(product_time));  //游戏上市时间
			
			int edition = Integer.parseInt(request.getParameter("edition"));
			good.setEdition(edition); //游戏版本
			
			double game_price = Double.parseDouble(request.getParameter("game_price"));
			good.setGood_price(game_price); //商品价格
			
			double price = Double.parseDouble(request.getParameter("price"));
			good.setPrice(price);  //游戏现价
			
			int count = Integer.parseInt(request.getParameter("count"));
			good.setCount(count);//商品数量
			
			int ucount = Integer.parseInt(request.getParameter("ucount"));
			good.setCount(ucount);//商品销量
			
			String discription = request.getParameter("discription");
			good.setDiscription(discription);  //商品描述
			
			GoodOperator go=new GoodOperator();
			go.saveGood(good);
			request.setAttribute("good",good);
			RequestDispatcher dis=request.getRequestDispatcher("back-stage/product-manage/add_image.jsp");
			
			dis.forward(request, response);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
