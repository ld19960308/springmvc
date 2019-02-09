package annotation.interceptor;

public class Book {
	private String name;
	private String author;
	private double money;
	public Book(){}
	public Book(String name,String author,double money){
		this.name=name;
		this.author=author;
		this.money=money;
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
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}

}
