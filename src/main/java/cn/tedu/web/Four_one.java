package cn.tedu.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.context.Context;
import cn.tedu.dao.FouroneDao;
import cn.tedu.entity.FourOne;
import cn.tedu.utils.ThyUtils;

public class Four_one extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String bookname =request.getParameter("bookname");
		String borrow_time=request.getParameter("borrow_time");
		String return_time=request.getParameter("return_time");
		String status=request.getParameter("status");
		//时间格式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			//时间格式的转换
			Date dd1 =sdf.parse(borrow_time);
			Date dd2 = sdf.parse(return_time);
			java.sql.Date d1 = new java.sql.Date(dd1.getTime());
			java.sql.Date d2 = new java.sql.Date(dd2.getTime());
			FourOne f = new FourOne(Integer.parseInt(id),bookname,d1,d2,Integer.parseInt(status));
			FouroneDao dao =new FouroneDao();
			List<FourOne> lists = dao.find(f);
			//获取总页数
			List lens = new ArrayList();
			int len=0;
			int size=lists.size();
			while(size>=0) {
				size-=3;
				len++;
				lens.add(len);
			}
			Context context = new Context();
			//将获取的request再重新输出
			context.setVariable("f", f);
			context.setVariable("lists", lists);
			context.setVariable("lens", lens);
			ThyUtils.write("First-four(one)",response,context);
		} catch (Exception e) {	
			e.printStackTrace();
		}
	}
}
