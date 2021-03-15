package cn.tedu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.tedu.entity.Three_All;
import cn.tedu.utils.DBUtils;

public class Three_AllDao {

	public List<Three_All> findAll(String finder) {
		List<Three_All> list=new ArrayList<>();
		//获得数据库的连接
		try (Connection conn = DBUtils.getConn();) {
			String sql="select * from reader a, book b, borrow c where a.readercarid=c.readercarid and b.bookid=c.bookid and a.readercarid=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(finder));
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				long borrow_date=rs.getLong("borrow_date");
				long return_date=rs.getLong("return_date");
				String bookname=rs.getString("bookname");
				String bookposition=rs.getString("bookposition");
				String bookcar=rs.getString("bookcar");
				String readername=rs.getString("readername");
				int readercarid=rs.getInt("readercarid");
				Long readerphoto=rs.getLong("readerphoto");
				String readertype=rs.getString("readertype");
				Three_All a=new Three_All(borrow_date, return_date, bookname, bookposition, bookcar, readername, readercarid, readerphoto, readertype);
				list.add(a);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Three_All> findByOne(String book, String booker, String id) {
		List<Three_All> list=new ArrayList<>();
		//获得数据库的连接
		try (Connection conn = DBUtils.getConn();) {
			String sql="select * from reader a, book b, borrow c where a.readercarid=c.readercarid and b.bookid=c.bookid and a.readercarid=? and b.bookcar=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(id));
			ps.setInt(2, Integer.parseInt(booker));
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				long borrow_date=rs.getLong("borrow_date");
				long return_date=rs.getLong("return_date");
				String bookname=rs.getString("bookname");
				String bookposition=rs.getString("bookposition");
				String bookcar=rs.getString("bookcar");
				String readername=rs.getString("readername");
				int readercarid=rs.getInt("readercarid");
				Long readerphoto=rs.getLong("readerphoto");
				String readertype=rs.getString("readertype");
				Three_All a=new Three_All(borrow_date, return_date, bookname, bookposition, bookcar, readername, readercarid, readerphoto, readertype);
				list.add(a);
			}
			return list;		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void insert(String readerid, String bookid) {
		//当前系统时间
		Date date=new Date();
		long a=date.getTime();
		//设置过期时间
		long b=a+7*24*60*60*1000;
		//获得数据库的连接
		try (Connection conn = DBUtils.getConn();) {
			String sql="insert into borrow value(?,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(readerid));
			ps.setInt(2, Integer.parseInt(bookid));
			ps.setLong(3, a);
			ps.setLong(4, b);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void delete(String readerid, String bookid) {
		//获得数据库的连接
		try (Connection conn = DBUtils.getConn();) {
			String sql="delete  from borrow where readercarid=? and bookid=? ";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(readerid));
			ps.setInt(2, Integer.parseInt(bookid));
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void renrwbook(String readerid, String bookid) {
		//续借时间 3天
		long b=3*24*60*60*1000;
		//获得数据库的连接
		try (Connection conn = DBUtils.getConn();) {
			String sql="update   borrow  set  return_date=return_date+?   where readercarid=? and bookid=? ";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setLong(1, b);
			ps.setInt(2, Integer.parseInt(readerid));
			ps.setInt(3, Integer.parseInt(bookid));
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
