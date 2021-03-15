package cn.tedu.entity;

import java.sql.Date;
import java.text.SimpleDateFormat;


public class FourOne {
	private int	id;
	private String bookname;
	private Date borrow_time;
	private Date return_time;
	private int status;
	
//	private String borrowTime;//创建开始时间字符串
//	private String returnTime;//创建结束时间字符串
//	public String getBorrowTime() {
//		SimpleDateFormat format = new SimpleDateFormat("yyyy-M-dd HH:mm:ss");
//	
//		return format.format(this.borrow_time);
//	}
//	public void setBorrowTime(String createdTime) {
//		this.borrowTime = borrowTime;
//	}
//	public String getReturnTime() {
//		SimpleDateFormat format = new SimpleDateFormat("yyyy-M-dd HH:mm:ss");
//		return format.format(this.return_time);
//	}
//	public void setReturnTime(String createdTime) {
//		this.returnTime = returnTime;
//	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public Date getBorrow_time() {
		return borrow_time;
	}
	public void setBorrow_time(Date borrow_time) {
		this.borrow_time = borrow_time;
	}
	public Date getReturn_time() {
		return return_time;
	}
	public void setReturn_time(Date return_time) {
		this.return_time = return_time;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public FourOne(int id, String bookname, Date borrow_time, Date return_time, int status) {
		this.id = id;
		this.bookname = bookname;
		this.borrow_time = borrow_time;
		this.return_time = return_time;
		this.status = status;
	}
	@Override
	public String toString() {
		return "FuorOne [id=" + id + ", bookname=" + bookname + ", borrow_time=" + borrow_time + ", return_time="
				+ return_time + ", status=" + status + "]";
	}

	
	
	
}
