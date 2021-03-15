package cn.tedu.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.dao.Three_AllDao;

/**
 * Servlet implementation class ReturnBookServlet
 */
public class ReturnBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String readerid=request.getParameter("readerid");
		String bookid=request.getParameter("bookid");
		Three_AllDao dao=new Three_AllDao();
		dao.delete(readerid,bookid);
		response.sendRedirect(request.getContextPath()+"/Three_FindReaderServelt?reader=1&finder="+readerid);
	}

}
