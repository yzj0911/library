package cn.tedu.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.tedu.entity.Book_info;
import cn.tedu.entity.Book_title;
import cn.tedu.utils.DBUtils;
public class Book_titleDao {
	public List<Book_title> findAll(){
	List<Book_title>list=new ArrayList<Book_title>();
	
	try (Connection conn = DBUtils.getConn();) {
		Statement stat = conn.createStatement();
		String sql="select * from book_title";
		ResultSet rs = stat.executeQuery(sql);
		while(rs.next()) {
			String key = rs.getString("key");
			String value = rs.getString("value");
			Book_title b=new Book_title(key,value);
			list.add(b);
		}
		return list;
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return null;
	}
}
