package Elevate_Labs_Internship.Task3;

import java.util.Scanner;

public class Main {
	
	public static void main(String...x)
	{
		Library lr = new Library();
		Scanner sc = new Scanner(System.in);
		int choice;
		
		do
		{
			System.out.println("\n===== Library Menu =====");
			System.out.println("1. Add Books");
			System.out.println("2. Add User");
            System.out.println("3. Show Books");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");
            choice = sc.nextInt();
            
            int bid,uid;
            String bname,uname;
            switch(choice)
            {
            case 1 : 
            	System.out.println("Enter Book ID : ");
            	bid = sc.nextInt();
            	sc.nextLine();
            	System.out.println("Enter Book Name : ");
            	bname = sc.nextLine();
            	System.out.println("Enter Author Name : ");
            	String bauth = sc.nextLine();
            	
            	lr.addBook(new Book(bid,bname,bauth));
            	System.out.println("\nBook Added Successfully...");
            	break;
            	
            case 2 : 
            	System.out.println("Enter User ID : ");
            	uid = sc.nextInt();
            	sc.nextLine();
            	System.out.println("Enter User Name : ");
            	uname = sc.nextLine();
            	
            	lr.addUser(new User(uid,uname));
            	System.out.println("\nUser Added Successfully...");
            	break;
            	
            case 3:
            	lr.showBooks();
            	break;
            	
            case 4: 
            	System.out.println("Enter Book ID : ");
            	bid = sc.nextInt();
            	sc.nextLine();
            	System.out.println("Enter User ID : ");
            	uid = sc.nextInt();
            	
            	lr.issueBook(bid, uid);
            	break;
            	
            case 5:
            	System.out.println("Enter Book ID : ");
            	bid = sc.nextInt();
            	sc.nextLine();
            	System.out.println("Enter User ID : ");
            	uid = sc.nextInt();
            	
            	lr.returnBook(bid, uid);
            	break;
            	
            case 6:
            	System.out.println("\nThank You....");
            	break;
            	
            default:
            	System.out.println("Invalid Choice , Try again...");
            }
			
		}while(choice!=6);
	}

}
