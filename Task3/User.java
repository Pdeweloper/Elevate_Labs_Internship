package Elevate_Labs_Internship.Task3;

import java.util.ArrayList;

public class User {
	
	private int uid;
	private String uname;
	private ArrayList<Book> borrowbook = new ArrayList<Book>();
	
	public User(int id , String name)
	{
		this.uid = id;
		this.uname = name;
		borrowbook = new ArrayList<Book>();
	}

	//Following are getters.
	public int getUid() {
		return uid;
	}

	public String getUname() {
		return uname;
	}

	public ArrayList<Book> getBorrowbook() {
		return borrowbook;
	}
	
	//following are functions.
	public void borrowBook(Book b)
	{
		borrowbook.add(b);
	}
	public void returnBook(Book b)
	{
		borrowbook.remove(b);
	}
	

}
