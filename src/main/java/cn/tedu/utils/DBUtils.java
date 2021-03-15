package cn.tedu.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

public class DBUtils {
	private static BasicDataSource bds;
	static {
		Properties pp=new Properties();
		InputStream is=DBUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
		try {
			pp.load(is);
			String driver=pp.getProperty("driver");
			String url=pp.getProperty("url");
			String user=pp.getProperty("username");
			String password=pp.getProperty("password");
			bds=new BasicDataSource();
			bds.setDriverClassName(driver);
			bds.setUrl(url);
			bds.setUsername(user);
			bds.setPassword(password);
			bds.setMaxActive(100);
			bds.setInitialSize(50);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(bds);
	}
	public static Connection getConn() throws Exception{
		Connection conn=bds.getConnection();
		return conn;
	}
	public static DataSource getDataSource(){
		return bds;
	}


}
