package cn.tedu.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.context.Context;

import cn.tedu.utils.ThyUtils;

/**
 * Servlet implementation class SelectSerlvet
 */
@WebServlet("/SelectSerlvet")
public class SelectSerlvet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ThyUtils.write("../readupdate", response,new Context());
	}
}
