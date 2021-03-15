package cn.tedu.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.context.Context;

import cn.tedu.dao.PersonDao;
import cn.tedu.entity.person;
import cn.tedu.utils.ThyUtils;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PersonDao dao=new PersonDao();
		List<person>persons=dao.findall();
		Context context=new Context();
		context.setVariable("persons",persons);
		ThyUtils.write("readupdate", response, context);
	}
}
