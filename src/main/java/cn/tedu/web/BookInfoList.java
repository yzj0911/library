package cn.tedu.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.context.Context;

import cn.tedu.dao.Book_infoDao;
import cn.tedu.dao.Book_titleDao;
import cn.tedu.entity.Book_info;
import cn.tedu.entity.Book_title;
import cn.tedu.utils.ThyUtils;

/**
 * Servlet implementation class BookInfoList
 */
public class BookInfoList extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Book_infoDao dao=new Book_infoDao();
		List<Book_info> book = dao.findAll();
		Book_titleDao daot = new Book_titleDao();
		List<Book_title> title = daot.findAll();
		Context context=new Context();
		context.setVariable("title", title);
		context.setVariable("book", book);
		ThyUtils.write("book-info", response, context);
	}

}
