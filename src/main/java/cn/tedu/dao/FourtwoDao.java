package cn.tedu.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.tedu.entity.FourTwo;
import cn.tedu.utils.DBUtils;

public class FourtwoDao {

	public List<FourTwo> find(FourTwo f) {
		ArrayList<FourTwo> list = new ArrayList<FourTwo>();
		//获取链接
		try (Connection conn = DBUtils.getConn();) {
			String sql = "select id,bookname,borrow_time,return_time,overdue_time,overdue_money "
					+"from overdue_statistics "
					+ "where id=? or bookname=? or (TO_DAYS(borrow_time)>TO_DAYS(?) and TO_DAYS(return_time)<TO_DAYS(?)) or overdue_time=? or overdue_money=?";
			PreparedStatement ps =conn.prepareStatement(sql);
			ps.setInt(1,f.getId());
			ps.setString(2, f.getBookname());
			ps.setDate(3, f.getBorrow_time());
			ps.setDate(4, f.getReturn_time());
			ps.setInt(5, f.getOverdue_time());
			ps.setInt(6, f.getOverdue_money());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				String bookname = rs.getString(2);
				Date borrow_time = rs.getDate(3);
				Date return_time = rs.getDate(4);
				int Overdue_time = rs.getInt(5);
				int Overdue_money = rs.getInt(6);
				System.out.println("id"+id);
				FourTwo fo = new FourTwo(id,bookname,borrow_time,return_time,Overdue_time,Overdue_money);
				list.add(fo);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;

		
		
	}

}
