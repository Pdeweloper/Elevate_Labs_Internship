package Elevate_Labs_Internship.Task3;

public class Book {
	
	private int bid;
	private String bname;
	private String bauthor;
	private boolean isissued;
	
	public Book(int id , String name , String author)
	{
		this.bid = id;
		this.bname = name;
		this.bauthor = author;
		this.isissued = false;
	}
	
	//Following are getters
	public int getBid() {
		return bid;
	}
	public String getBname() {
		return bname;
	}
	public String getBauthor() {
		return bauthor;
	}
	public boolean isIssued()
	{
		return isissued;
	}
	
	//Following are functions.
	public void issueBook()
	{
		isissued = true;
	}
	public void returnBook()
	{
		isissued = false;
	}
	

}
