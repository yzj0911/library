package cn.tedu.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.context.Context;

import cn.tedu.utils.ThyUtils;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usrname=request.getParameter("usrname");
		String password=request.getParameter("password");
		if("root".equals(usrname)) {
			if("123456".equals(password)) {
				ThyUtils.write("First", response, new Context());
			return ;
			}
		}
		ThyUtils.write("login", response, new Context());
		
	}


}
