package cn.tedu.entity;

public class Book_info {
	private int id;
	private int cover;
	private String name;
	private String author;
	private String publisher;
	private String classify;
	private int total;
	private int lend;
	private int left;
	private int times;
	private String number;
	public int getTimes() {
		return times;
	}
	public void setTimes(int times) {
		this.times = times;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCover() {
		return cover;
	}
	public void setCover(int cover) {
		this.cover = cover;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getClassify() {
		return classify;
	}
	public void setClassify(String classify) {
		this.classify = classify;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getLend() {
		return lend;
	}
	public void setLend(int lend) {
		this.lend = lend;
	}
	public int getLeft() {
		return left;
	}
	public void setLeft(int left) {
		this.left = left;
	}
	
	@Override
	public String toString() {
		return "Book_info [id=" + id + ", cover=" + cover + ", name=" + name + ", author=" + author + ", publish="
				+ publisher + ", classify=" + classify + ", total=" + total + ", lend=" + lend + ", left=" + left
				+ ", times=" + times + ", number=" + number + "]";
	}
	public Book_info(int id, int cover, String name, String author, String publisher, String classify, int total,
			int lend, int left, int times, String number) {
		super();
		this.id = id;
		this.cover = cover;
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.classify = classify;
		this.total = total;
		this.lend = lend;
		this.left = left;
		this.times = times;
		this.number = number;
	}
	
		
}
