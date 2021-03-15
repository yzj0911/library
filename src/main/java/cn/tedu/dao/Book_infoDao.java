package cn.tedu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import cn.tedu.entity.Book_info;
import cn.tedu.utils.DBUtils;
public class Book_infoDao {
	public List<Book_info> findAll(){
		List<Book_info>list=new ArrayList<Book_info>();

		try (Connection conn = DBUtils.getConn();) {
			Statement stat = conn.createStatement();
			String sql="select * from book_info";
			ResultSet rs = stat.executeQuery(sql);
			while(rs.next()) {
				int id = rs.getInt("id");
				int cover = rs.getInt("cover");
				String name = rs.getString("name");
				String author = rs.getString("author");
				String publisher = rs.getString("publisher");
				String classify = rs.getString("classify");
				int total = rs.getInt("total");
				int lend = rs.getInt("lend");
				int left = rs.getInt("left");
				int times = rs.getInt("times");
				String number = rs.getString("number");
				Book_info b=new Book_info(id,cover,name,author,publisher,classify,total,lend,left,times,number);
				list.add(b);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public List<Book_info> searchAll(String searchName) {
		List<Book_info>list=new ArrayList<Book_info>();

		try (Connection conn = DBUtils.getConn();) {
			String sql="select * from book_info where author = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, searchName);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				int cover = rs.getInt("cover");
				String name = rs.getString("name");
				String author = rs.getString("author");
				String publisher = rs.getString("publisher");
				String classify = rs.getString("classify");
				int total = rs.getInt("total");
				int lend = rs.getInt("lend");
				int left = rs.getInt("left");
				int times = rs.getInt("times");
				String number = rs.getString("number");
				Book_info b=new Book_info(id,cover,name,author,publisher,classify,total,lend,left,times,number);
				list.add(b);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
