package cn.tedu.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Three_All {
	private long borrow_date ;
	private long return_date;
	private String bookname;
	private String bookposition;
	private String bookcar ;
	private String readername ;
	private int readercarid ;
	private long readerphoto;
	private String readertype;

	private String r_date;
	private String b_date;

	public String getB_date() {
		SimpleDateFormat sdf=new SimpleDateFormat("yy-MM-dd HH:mm");
		Date d=new Date(this.borrow_date);
		return sdf.format(d);
	}

	public String getR_date() throws ParseException {
		SimpleDateFormat sdf=new SimpleDateFormat("yy-MM-dd HH:mm");
		Date d=new Date(this.return_date);
		return sdf.format(d);
	}

	public long getBorrow_date() {
		return borrow_date;
	}

	public void setBorrow_date(long borrow_date) {
		this.borrow_date = borrow_date;
	}

	public long getReturn_date() {
		return return_date;
	}

	public void setReturn_date(long return_date) {
		this.return_date = return_date;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getBookposition() {
		return bookposition;
	}

	public void setBookposition(String bookposition) {
		this.bookposition = bookposition;
	}

	public String getBookcar() {
		return bookcar;
	}

	public void setBookcar(String bookcar) {
		this.bookcar = bookcar;
	}

	public String getReadername() {
		return readername;
	}

	public void setReadername(String readername) {
		this.readername = readername;
	}

	public int getReadercarid() {
		return readercarid;
	}

	public void setReadercarid(int readercarid) {
		this.readercarid = readercarid;
	}

	public long getReaderphoto() {
		return readerphoto;
	}

	public void setReaderphoto(long readerphoto) {
		this.readerphoto = readerphoto;
	}

	public String getReadertype() {
		return readertype;
	}

	public void setReadertype(String readertype) {
		this.readertype = readertype;
	}

	public void setR_date(String r_date) {
		this.r_date = r_date;
	}

	@Override
	public String toString() {
		return "Three_All [borrow_date=" + borrow_date + ", return_date=" + return_date + ", bookname=" + bookname
				+ ", bookposition=" + bookposition + ", bookcar=" + bookcar + ", readername=" + readername
				+ ", readercarid=" + readercarid + ", readerphoto=" + readerphoto + ", readertype=" + readertype
				+ ", r_date=" + r_date + "]";
	}

	public Three_All(long borrow_date, long return_date, String bookname, String bookposition, String bookcar,
			String readername, int readercarid, long readerphoto, String readertype) {
		this.borrow_date = borrow_date;
		this.return_date = return_date;
		this.bookname = bookname;
		this.bookposition = bookposition;
		this.bookcar = bookcar;
		this.readername = readername;
		this.readercarid = readercarid;
		this.readerphoto = readerphoto;
		this.readertype = readertype;
	}
	
}
