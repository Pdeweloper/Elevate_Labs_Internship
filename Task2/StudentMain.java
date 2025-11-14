package Elevate_Labs_Internship.Task2;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentMain {
	
	private static ArrayList<Student> starr = new ArrayList<Student>();
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		int choice;
		
		do
		{
			System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            
            switch(choice)
            {
            case 1: addStudent(); break;
            case 2: viewStudents(); break;
            case 3: updateStudent(); break;
            case 4: deleteStudent(); break;
            case 5: System.out.println("Thank you..."); break;
            default:
            	System.out.println("Invalid Choice , Choose correct option..");
            }
			
		}while(choice!=5);
		
	}
	
	private static void addStudent()
	{
		System.out.print("Enter Roll No. : ");
		int id = sc.nextInt();
		sc.nextLine(); 
		
		System.out.println("Enter Student Name : ");
		String sname = sc.nextLine();
		
		System.out.println("Enter CGPA : ");
		float cgpa = sc.nextFloat();
		
		starr.add(new Student(id,sname,cgpa));
		System.out.println("New Student Added...");
	}
	
	private static void viewStudents()
	{
		if(starr.isEmpty())
		{
			System.out.println("No Student Records are Available...");
			return;
		}
		
		System.out.println("\nStudent Records");
		for(Student s:starr)
		{
			System.out.println(s.getrno());
			System.out.println(s.getsname());
			System.out.println(s.getcgpa());
			
			System.out.println("\n");
		}
	}
	
	private static void updateStudent() 
	{
		System.out.println("Enter Student Roll No. : ");
		int id = sc.nextInt();
		sc.nextLine();
		
		for(Student s:starr)
		{
			if(s.getrno() == id)
			{
				int op;
				do
				{
				System.out.println("Student Existed. What you want to Change :-");
				System.out.println("1. Change Name");
				System.out.println("2. Change Cgpa");
				System.out.println("3. Change Both");
				System.out.println("4. Completed");
				
				System.out.print("Enter Choice :");
				op = sc.nextInt();
				sc.nextLine();
				
				String name;
				float cgpa;
				switch(op)
				{
				case 1: 
					System.out.println("Enter New Name : ");
					name = sc.nextLine();
					
					s.setsname(name);
					System.out.println("Name Updated...");
					break;
					
				case 2:
					System.out.println("Enter New CGPA : ");
					cgpa = sc.nextFloat();
					
					s.setcgpa(cgpa);
					System.out.println("CGPA Updated...");
					break;
					
				case 3:
					System.out.println("Enter New Name : ");
					name = sc.nextLine();
					System.out.println("Enter New CGPA : ");
					cgpa = sc.nextFloat();
					
					s.setsname(name);
					s.setcgpa(cgpa);
					System.out.println("Student Details Updated...");
					break;
					
				default:
					System.out.println("Invalid Choice , Try Again...");
				}
				}while(op!=4);
				return;
			}
		}
		
		System.out.println("Student not found!");
	}
	
	private static void deleteStudent()
	{
		System.out.println("Enter Student Roll No. : ");
		int id = sc.nextInt();
		
		for(Student s:starr)
		{
			if(s.getrno() == id)
			{
				starr.remove(s);
				System.out.println("Student deleted successfully!");
	            return;
			}
		}
		
		System.out.println("Student not found!");
	}

}
