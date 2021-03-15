package cn.tedu.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.dao.PersonDao;
import cn.tedu.entity.person;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String gender=request.getParameter("gender");
		String date=request.getParameter("date");
		person person=new person(0, name, gender, date);
		PersonDao dao=new PersonDao();
		dao.addperson(person);
		response.sendRedirect(request.getContextPath()+"/Servlet");
	}
}
