package cn.tedu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.tedu.entity.Three_Book;
import cn.tedu.utils.DBUtils;

public class Three_BookDao {

	public Three_Book findById(String finder) {
		//获得数据库的连接
		try (Connection conn = DBUtils.getConn();) {
			String sql="select b.bookid,b.bookcar,b.bookname,b.bookposition from reader a, book b, borrow c where a.readercarid=c.readercarid and b.bookid=c.bookid and a.readercarid=? order by c.borrow_date limit 0,1";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(finder));
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				int bookid=rs.getInt("bookid");
				int bookcar=rs.getInt("bookcar");
				String bookname=rs.getString("bookname");
				String bookposition=rs.getString("bookposition");
				Three_Book b=new Three_Book(bookid, bookcar, bookname, bookposition);
				System.out.println(b);
				return b;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	public Three_Book findByOne(String book, String booker, String id) {
		String sql="select b.bookid,b.bookcar,b.bookname,b.bookposition from reader a, book b, borrow c where a.readercarid=c.readercarid and b.bookid=c.bookid  and b.bookcar=?";
		//获得数据库的连接
		try (Connection conn = DBUtils.getConn();) {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(booker));
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				int bookid=rs.getInt("bookid");
				System.out.println(bookid);
				int bookcar=rs.getInt("bookcar");
				String bookname=rs.getString("bookname");
				String bookposition=rs.getString("bookposition");
				Three_Book b=new Three_Book(bookid, bookcar, bookname, bookposition);
				return b;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
