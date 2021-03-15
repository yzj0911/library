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
/*
 * 实现查到读者和书本确定的 那一个信息 并将所有信息改写
 */
public class Three_FindBookServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//查找类型
		String book=request.getParameter("book");
		System.out.println(book);
		//查找信息
		String booker=request.getParameter("find");
		System.out.println(booker);
		//读者id信息
		String id=request.getParameter("id");
		
		Context context=new Context();
		//根据读者的id信息 获得读者的所有信息  
		Three_ReaderDao dao=new Three_ReaderDao();
		Three_Reader r=dao.findById("readercarid",id);

		//更具读者 的id  获得最近借的一本书（书本信息）
		Three_BookDao dao1=new Three_BookDao();
		Three_Book b=dao1.findByOne(book,booker,id);

		//读者的所有借的书本信息和
		Three_AllDao dao2=new Three_AllDao();
		List<Three_All> all=dao2.findByOne(book,booker,id);

		context.setVariable("b",b);
		context.setVariable("r", r);
		context.setVariable("all", all);
		ThyUtils.write("../First-three", response, context);
		
		
	}
}
