package cn.tedu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.tedu.entity.person;
import cn.tedu.utils.DBUtils;


public class PersonDao {

	public List<person> findall() {
		ArrayList<person>persons=new ArrayList<>();
		//获取连接
		try (Connection conn = DBUtils.getConn()) {
			Statement stat=conn.createStatement();
			ResultSet rs=stat.executeQuery("select * from personerp");
			while(rs.next()) {
				int id=rs.getInt("id");
				String name=rs.getString("name");
				String gender=rs.getString("gender");
				String date=rs.getString("date");
				persons.add(new person(id, name, gender, date));
			}
			System.out.println(persons);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return persons;
	}

	public void addperson(person person) {
		//获取连接
		try (Connection conn = DBUtils.getConn()){
			String sql="insert into personerp values(null,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,person.getName());
			ps.setString(2,person.getGender());
			ps.setString(3,person.getDate());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
