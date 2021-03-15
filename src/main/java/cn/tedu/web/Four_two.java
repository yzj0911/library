package cn.tedu.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.context.Context;

import cn.tedu.dao.FourtwoDao;
import cn.tedu.entity.FourTwo;
import cn.tedu.utils.ThyUtils;
public class Four_two extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String bookname =request.getParameter("bookname");
		String borrow_time=request.getParameter("borrow_time");
		String return_time=request.getParameter("return_time");
		String overdue_time=request.getParameter("overdue_time");
		String overdue_money=request.getParameter("overdue_money");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date dd1 =sdf.parse(borrow_time);
			Date dd2 = sdf.parse(return_time);
			java.sql.Date d1 = new java.sql.Date(dd1.getTime());
			java.sql.Date d2 = new java.sql.Date(dd2.getTime());
			FourTwo f = new FourTwo(Integer.parseInt(id),bookname,d1,d2,Integer.parseInt(overdue_time),Integer.parseInt(overdue_money));
			FourtwoDao dao =new FourtwoDao();
			List<FourTwo> lists = dao.find(f);
			//获取总页数
			List<Integer> lens = new ArrayList<Integer>();
			int len=0;
			int size=lists.size();
			while(size>=0) {
				size-=3;
				len++;
				lens.add(len);
			}
			Context context = new Context();
			context.setVariable("f", f);
			context.setVariable("lists", lists);
			context.setVariable("lens", lens);
			ThyUtils.write("First-four(two)",response,context);
		} catch (Exception e) {	
			e.printStackTrace();
		}
	
	}


}
