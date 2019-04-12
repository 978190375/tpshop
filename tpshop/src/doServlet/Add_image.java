package doServlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import shiti.Good;
import shiti.Image;
import operator.GoodOperator;
import operator.ImageOperator;

/**
 * Servlet implementation class Add_image
 */
@WebServlet("/Add_image")
public class Add_image extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add_image() {
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
		ImageOperator io = new ImageOperator();
		Image image = new Image();
		GoodOperator go=new GoodOperator();

		Good good=go.getGood(good_id);
		String uploadFileName = "";// 上传文件名
		PrintWriter out = response.getWriter();

		// 请求信息中的内容是否是multipart类型
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (!isMultipart) {
			out.print("error！表单必须包含enctype=multipart/form-data ");
			return;
		} else {
			// 上传文件的存储路径（服务器文件系统上的绝对文件路径）
			String uploadFilePath = getServletContext().getRealPath("/") + "save";
			// String uploadFilePath ="E:\\workspace\\upimg\\WebContent\\save";

			// 创建临时文件目录路径
			File tempPatchFile = new File("d:\\temp\\buffer\\");
			if (!tempPatchFile.exists())// 判断文件或目录是否存在
				tempPatchFile.mkdirs(); // 不存在则创建
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(4096);
			factory.setRepository(tempPatchFile);
			Date date = new Date();

			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setSizeMax(1024 * 1024 * 10);

			try {
				List<FileItem> items = upload.parseRequest(request);
				Iterator<FileItem> iter = items.iterator();
				while (iter.hasNext()) {
					FileItem item = (FileItem) iter.next();
					if (!item.isFormField()) {
						String fileName = date.getTime() + new File(item.getName()).getName();
						String filePath = uploadFilePath + File.separator + fileName;
						File saveFile = new File(filePath);

						image.setImage_path(filePath);
						io.saveImage(image);

						item.write(saveFile);
						good.setImage_path(filePath);
						go.update(good);
						out.print("上传成功！");
					} else
					{
						out.println("error");
					}
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}

