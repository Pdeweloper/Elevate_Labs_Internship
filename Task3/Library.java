package Elevate_Labs_Internship.Task3;

import java.util.ArrayList;

public class Library {
	
	private ArrayList<Book> books = new ArrayList<Book>();
	private ArrayList<User> users = new ArrayList<User>();
	
	//Constructor.
	public Library()
	{
		books = new ArrayList<Book>();
		users = new ArrayList<User>();
	}
	
	//Functions of add Book and Users.
	public void addBook(Book b)
	{
		books.add(b);
	}
	public void addUser(User u)
	{
		users.add(u);
	}
	
	//Functions of Find Book and Users.
	public Book findbook(int bid)
	{
		for(Book b:books)
		{
			if(b.getBid()==bid) return b;
		}
		return null;
	}	
	public User finduser(int uid)
	{
		for(User u:users)
		{
			if(u.getUid()==uid) return u;
		}
		return null;
	}
	
	//this function is used to issue given book to desired user.
	public void issueBook(int bid , int uid)
	{
		Book b = findbook(bid); 
		User u = finduser(uid);
		
		if(b==null)
		{
			System.out.println("Book not found!.");
			return;
		}
		if(u==null)
		{
			System.out.println("User not found!.");
			return;
		}
		
		if(b.isIssued())
		{
			System.out.println("Book is already issued.");
			return;
		}
		
		b.issueBook();
		u.borrowBook(b);
		System.out.println("Book is issued to "+u.getUname());
	}
	
	//this function is used to return given book from desired user.
	public void returnBook(int bid , int uid)
	{
		Book b = findbook(bid); 
		User u = finduser(uid);
		
		if(b==null)
		{
			System.out.println("Book not found!.");
			return;
		}
		if(u==null)
		{
			System.out.println("User not found!.");
			return;
		}
		
		if(!b.isIssued())
		{
			System.out.println("Book is not issued.");
			return;
		}
		
		b.returnBook();
		u.returnBook(b);
		System.out.println("Book Returned Successfully.");
	}
	
	public void showBooks()
	{
		for(Book b:books)
		{
			 System.out.println(b.getBid() + " - " + b.getBname() + " (Issued: " + b.isIssued() + ")");
		}
	}

}
