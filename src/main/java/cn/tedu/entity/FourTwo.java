package cn.tedu.entity;

import java.sql.Date;

public class FourTwo {
private int	id;
private String bookname;
private Date borrow_time;
private Date return_time;
private int overdue_time;
private int	overdue_money;
@Override
public String toString() {
	return "Fourtwo [id=" + id + ", bookname=" + bookname + ", borrow_time=" + borrow_time + ", return_time="
			+ return_time + ", overdue_time=" + overdue_time + ", overdue_money=" + overdue_money + "]";
}
public FourTwo(int id, String bookname, Date borrow_time, Date return_time, int overdue_time, int overdue_money) {
	this.id = id;
	this.bookname = bookname;
	this.borrow_time = borrow_time;
	this.return_time = return_time;
	this.overdue_time = overdue_time;
	this.overdue_money = overdue_money;
}
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
public int getOverdue_time() {
	return overdue_time;
}
public void setOverdue_time(int overdue_time) {
	this.overdue_time = overdue_time;
}
public int getOverdue_money() {
	return overdue_money;
}
public void setOverdue_money(int overdue_money) {
	this.overdue_money = overdue_money;
}

}