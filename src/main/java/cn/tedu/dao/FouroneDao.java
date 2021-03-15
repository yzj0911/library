package cn.tedu.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.tedu.entity.FourOne;
import cn.tedu.utils.DBUtils;

public class FouroneDao {
	public List<FourOne> find(FourOne f){
		ArrayList<FourOne> list = new ArrayList<FourOne>();
		//获取链接
		try (Connection conn = DBUtils.getConn();) {
			String sql = "select id,bookname,borrow_time,return_time,status "
					+" from borrow_statistics "
					+ "where id=? or bookname=? or (TO_DAYS(borrow_time)>TO_DAYS(?) and TO_DAYS(return_time)<TO_DAYS(?)) or status=? ";
			PreparedStatement ps =conn.prepareStatement(sql);
			ps.setInt(1,f.getId());
			ps.setString(2, f.getBookname());
			ps.setDate(3, f.getBorrow_time());
			ps.setDate(4, f.getReturn_time());
			ps.setInt(5, f.getStatus());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				String bookname = rs.getString(2);
				Date borrow_time = rs.getDate(3);
				Date return_time = rs.getDate(4);
				int status = rs.getInt(5);
				FourOne fo = new FourOne(id,bookname,borrow_time,return_time,status);
				list.add(fo);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;

	}

}
