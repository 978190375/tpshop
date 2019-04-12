package doServlet;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import operator.GoodOperator;
import operator.StringToDate;
import shiti.Good;

/**
 * Servlet implementation class Update_goods
 */
@WebServlet("/Update_goods")
public class Update_goods extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update_goods() {
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
		int good_id=Integer.parseInt(request.getParameter("good_id"));
		GoodOperator go=new GoodOperator();
		Good good=go.getGood(good_id);
		

		try {
			String name = request.getParameter("game_name");
			good.setName(name); // 游戏名称
			String[] tip = request.getParameterValues("game_tips");
			
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
			
			go.update(good);


			RequestDispatcher dis=request.getRequestDispatcher("back-stage/product-manage/update_good.jsp");
			dis.forward(request, response);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
