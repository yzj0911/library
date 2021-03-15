package cn.tedu.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.context.Context;

import cn.tedu.dao.Three_AllDao;
import cn.tedu.dao.Three_BookDao;
import cn.tedu.dao.Three_ReaderDao;
import cn.tedu.entity.Three_All;
import cn.tedu.entity.Three_Book;
import cn.tedu.entity.Three_Reader;
import cn.tedu.utils.ThyUtils;

/**
 * Servlet implementation class Three_FindReaderServelt
 */
public class Three_FindReaderServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reader=request.getParameter("reader");
		String finder=request.getParameter("finder");
		Context context=new Context();
		//根据读者的id信息 获得读者的所有信息  
		Three_ReaderDao dao=new Three_ReaderDao();
		Three_Reader r=dao.findById(reader,finder);



		//更具读者 的id  获得最近借的一本书（书本信息）
		Three_BookDao dao1=new Three_BookDao();
		Three_Book b=dao1.findById(finder);
		//如何没有借书，则返回0


		//读者的所有借的书本信息和
		Three_AllDao dao2=new Three_AllDao();
		List<Three_All> all=dao2.findAll(finder);


		context.setVariable("b",b);
		context.setVariable("r", r);
		context.setVariable("all", all);
		ThyUtils.write("../First-three", response, context);
	}


}
