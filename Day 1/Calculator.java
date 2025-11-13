import java.util.Scanner;

class Calculator
{
	Scanner s = new Scanner(System.in);
	
	public double getnum(String message)
	{
		System.out.print(message);
		return s.nextDouble();
	}
	
	public double add()
	{		
		double a = getnum("Enter First Number : ");
		double b = getnum("Enter Second Number : ");
		
		return a+b;
	}
	
	public double subtract()
	{
		double a = getnum("Enter First Number : ");
		double b = getnum("Enter Second Number : ");
		
		return a-b;
	}
	
	public double multiply()
	{
		double a = getnum("Enter First Number : ");
		double b = getnum("Enter Second Number : ");
		
		return a*b;
	}
	
	public double divide()
	{
		double a = getnum("Enter First/Numerator Number : ");
		double b = getnum("Enter Second/Denomenator Number : ");
		
		if(b==0)
		{
			System.out.println("Second number should not be 0(zero)");
			return 0;
		}
		return a/b;
	}
	
	public static void main(String...x)
	{
		Scanner s = new Scanner(System.in);
		Calculator c = new Calculator();
	    System.out.println("\n===== SIMPLE CALCULATOR =====");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.println("5. Exit");
        System.out.print("=============================\n");
		
        int choice = 0;

	   do
	   {
		  System.out.print("\nEnter your choice : ");
	      choice = s.nextInt();
		
		  switch(choice)
		  {
			case 1: 
			      System.out.println("Addition is : "+c.add()); 
				  break;
			case 2: 
			      System.out.println("Subtraction is : "+c.subtract());
				  break;
			case 3:
          		  System.out.println("Multiplication is : "+c.multiply()); 
				  break;
			case 4: 
			      System.out.println("Division is : "+c.divide()); 
				  break;
			default:
			if(choice==5)
			{
				System.out.println("Thank You...");
			}
			else
			{
			    System.out.println("Enter Valid Choice...\n");
			}
			break;
		  }
	   }while(choice!=5);
	}
	
	
}