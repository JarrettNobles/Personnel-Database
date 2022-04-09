import java.io.*;
import java.util.*;

public class Personnel implements Serializable
{
    public static void main(String [] args)
    {
        //array list to store employees
        ArrayList <Employee> employee = new ArrayList<Employee>();
        clearScreen();
        //call the main menu
        menu(employee);
    }

    //menu class function prints menu with this specific format
    public static void printMenu()
    {
        //for (int i = 0; i < 40; i++)
        //{
            System.out.println("----------------------------------------");
	    System.out.println("|" + "\t" + "\t"+"\t"+"\t"+ "\t"+"|");
            System.out.println("| Commands:" + "\t" + "n - New Employee" + "\t" + "|");
            System.out.println("|" +"\t" + "\t" + "c - Compute Paychecks"+ "\t" + "|");
            System.out.println("|" +  "\t" + "\t" + "r - Raise Waiges" + "\t" + "|");
            System.out.println("|" + "\t" + "\t" + "p - Print Records" + "\t" + "|");
            System.out.println("|" + "\t" + "\t" + "d - Download Data"+ "\t" + "|");
            System.out.println("|" + "\t" + "\t" + "u - Upload Data" + "\t" +"\t" + "|");
            System.out.println("|" + "\t" + "\t" + "q - Quit" + "\t" +  "\t" + "|");
	    System.out.println("----------------------------------------");
            //for (int j = 0; j < 40; j++)
            //{

            //}
            System.out.println();
            System.out.println("Enter Command:");


        //}
    }

    //this is how the menu works
    public static void menu(ArrayList <Employee> employee)
    {
        //print the menu
        printMenu();

        //scanner for user input
        Scanner in = new Scanner(System.in);
        char option = 'a';
        boolean run = true;

        //while loop that runs while the user keeps going through the program
        while(run)
        {
            //takes in the user character
            option = in.next().charAt(0);

            //switch case run
            switch(option)
            {
                //if user selects n
                case 'n':
                case 'N':
                    addEmployee(employee);
                    printMenu();
                break;

                //if user selects c
                case 'c':
                case 'C':
                    computePaycheck(employee);
                    printMenu();
                break;

                //if user selects r
                case 'r':
                case 'R': 
                    raiseWages(employee);
                    printMenu();
                break;

                //if user selects p
                case 'p':
                case 'P':
                    printEmployees(employee);
                    printMenu();
                break;

                //if user selects d
                case 'd':
                case 'D':
                    download(employee);
                    printMenu();
                break;

                //if user selects u
                case 'u':
                case 'U':
                    upload(employee);
                    printMenu();
                break;

                //if user selects q
                case 'q':
                case 'Q':
                    run = false;
                break;

                //default message if anything other than the selected options is selected
                default: System.out.println("Sorry that command was not recognized, please try again");
                         System.out.println("Please enter an option:");
                break;
                
                
            }
        }

    }

    //employee search function
    public static int employeeLocation(ArrayList <Employee> employee)
    {
        int element = 0;
        String name = "";
        System.out.println("Enter employee name");
        Scanner in = new Scanner(System.in);
        in.nextLine();
        int first = 0;
        int last = employee.size() - 1;
	    int middle;
	    boolean found = false;


	    do
	    {
		    middle = (first + last) / 2;

		    if((employee.get(middle)).getName().compareTo(name) == 0)
		    {
			    found = true;
		    }
		
		    else if(employee.get(middle).getName().compareTo(name) > 0)
		    {
			    last = middle - 1;
		    }
		
		    else
		    {
			    first = middle + 1;
		    }
	    }

	    while((!found) && (first <= last));
	    {
		    element = middle;
	    }
	
	    return (found ? element : -1);
    }

    //sort method for sorting employees
    public static void sortEmployees(ArrayList <Employee> employee)
    {
        int minIndex, index, j;
        Employee temp;

        for(index = 0; index < employee.size() - 1; index++)
        {
            minIndex = index;

            for(j = minIndex + 1; j< employee.size(); j ++)
            {
                if(employee.get(j).getName().compareTo(employee.get(minIndex).getName()) < 0)
                {
                    minIndex = j;
                }

            }

            if(minIndex != index)
            {
                temp = employee.get(index);
                employee.set(index,employee.get(minIndex));
                employee.set(minIndex, temp);
            }
        }
    }

    //upload method uploads data from the array list to an external file
    private static void upload(ArrayList <Employee> employee)
    {
        String fileName = "employee.dat";

        //try statement for uploading
        try 
        {
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(employee);
            out.close();
        }
        
        //catch the IOException if it fails
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }

       
    }
	
    //download method
    private static void download(ArrayList <Employee> employee)
    {
        String fileName = "employee.dat";
        employee.clear();
        ArrayList <Employee> temp = new ArrayList <Employee>();
        //try catch statement for downloading
        try
        {
            FileInputStream fileIn = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            temp = (ArrayList<Employee>) in.readObject();
            in.close();
        }

        //catch IOException
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }

        //catch class not found exception
        catch (ClassNotFoundException e)
        {
            System.out.println(e.getMessage());
        }

        for(int i = 0; i < temp.size(); i++)
        {
            employee.add(temp.get(i));
        }
        
    }

    //clear screen method
    private static void clearScreen()
    {
        //clears the screen
        System.out.println("\u001b[H\u001b[2J");
    }

    //print employees will print each employee name and their hourly or salarly wage
    private static void printEmployees(ArrayList <Employee> employee)
    {
        for (int i = 0; i < employee.size(); i++)
        {
            System.out.println(employee.get(i));
        }
    }

    //add employees to the array list
    private static void addEmployee(ArrayList<Employee> employee)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the new employees name:");
        String name = in.nextLine();
        System.out.print("Enter (h) for hourly or (s) for salary:");
        char choice = in.next().charAt(0);
        switch(choice)
        {
            //if user selects h or H for hourly wage
            case 'h':
            case 'H':
                System.out.print("Enter the hourly wage: ");
                double wage = in.nextDouble();
                employee.add(new HourlyEmployee(name, wage));
            break;

            //if user selects s or S for salary wage
            case 's':
            case 'S':
                System.out.print("Enter the annual salary amount: ");
                double salary = in.nextDouble();
                employee.add(new SalaryEmployee(name, salary));
            break;

            //default option if user selects anything other than H or S
            default: System.out.println("Input not accepted, please enter the correct option");
            break;
        }
    }

    //raise wages will take user input and apply it to employees in array list
    private static void raiseWages(ArrayList<Employee> employee)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the wage percentage increase: ");
        double increase = in.nextDouble();
        System.out.println("\n" + "New Pay Amount");
        for(int i = 0; i < employee.size(); i++)
        {
            employee.get(i).increaseWage(increase);
        }
        printEmployees(employee);
    }
    
    //compute pay check takes input as the amout of hours and computes it into paycheck
    private static void computePaycheck(ArrayList<Employee> employee)
    {
        Scanner in = new Scanner(System.in);
        for(int i = 0; i < employee.size(); i++)
        {
            System.out.print("Enter the number of hours worked by " + employee.get(i).getName()+ ": ");
            Double hours = in.nextDouble();
            System.out.println("Check Amount: $" + employee.get(i).computePay(hours));
        }
    }
}
