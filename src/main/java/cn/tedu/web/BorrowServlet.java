package cn.tedu.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.dao.Three_AllDao;

/**
 * 借书系统  时间为当前系统时间，归还时间为7天后
 */
public class BorrowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("123");
		String readerid=request.getParameter("readerid");
		String bookid=request.getParameter("bookid");
		Three_AllDao dao=new Three_AllDao();
		dao.insert(readerid,bookid);
		response.sendRedirect(request.getContextPath()+"/Three_FindReaderServelt?reader=1&finder="+readerid);
	}
}
