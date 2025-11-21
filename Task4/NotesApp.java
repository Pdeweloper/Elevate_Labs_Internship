package Elevate_Labs_Internship.Task4;

import java.io.*;
import java.util.Scanner;

public class NotesApp {
	
	 
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String...x)
	{
		int choice;
		
		do
		{
			System.out.println("\n===== Notes App Menu =====");
			System.out.println("1. Add Notes");
			System.out.println("2. Read Notes");
            System.out.println("3. Exit");
            System.out.println("Enter Your Choice : ");
            choice = sc.nextInt();
            sc.nextLine();
            
            switch(choice)
            {
            case 1:
            	writeNote();
            	break;
            	
            case 2:
            	readNote();
            	break;
            	
            case 3:
            	System.out.println("Thank You...");
            	break;
            	
            default:
            	System.out.println("Invalid Choice , Try Again..");
            }
            		
		}while(choice!=3);
	}
	
	public static void writeNote()
	{		
		try
		{
			File f = new File("D://A.notesProgarm/note.txt");
            FileWriter fw = new FileWriter(f, true);
            BufferedWriter bw = new BufferedWriter(fw);

            // Use ONLY Scanner for reading input
            System.out.println("Enter Heading of Note : ");
            String heading = sc.nextLine();

            System.out.println("Enter Notes : ");
            String notes = sc.nextLine();

            String s = heading + "\n" + notes + "\n\n";

            bw.write(s);
            bw.close();

            System.out.println("Note Saved Successfully!");
		}
		catch(Exception e)
		{
//			System.out.println("Error in Writing!");
			System.out.println("Error reading notes: "+e.getMessage().toString());
		}
	}
	
	public static void readNote()
	{
		try {
            File f = new File("D://A.notesProgarm/note.txt");

            if (!f.exists()) {
                System.out.println("No notes found!");
                return;
            }
            
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line;

            System.out.println("\n======== Saved Notes ========");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();

        } catch (Exception e) {
            System.out.println("Error reading notes: " + e.getMessage().toString());
        }
	}
	
}

