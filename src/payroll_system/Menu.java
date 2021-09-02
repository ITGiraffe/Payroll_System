// ELEMENT OF THE PAYROLL_SYSTEM PROGRAM
package payroll_system;

// NECESSARY IMPORTS TO EXECUTE PROGRAM (INPUT DATA FROM USER)
import java.util.Scanner;

// CLASS SPECIALIZED TO PRINT MENU'S
public class Menu  
{
    // DECLARING AN OBJECT FOR INPUTS
    static Scanner input = new Scanner(System.in);
    
    // CHANGE COLOR OF TEXT INTO RED
    private static final String RED = "\u001B[31m";
    // RESET COLOR
    private static final String RESET = "\u001B[0m";
    
    // CONSTRUCTOR
    public Menu()
    {
        
    }
    
    // METHOD TO PRINT MAIN MENU & CHOOSE OPTION
    public int mainMenu(int check)
    {
         // DECLARE AND SET OPTION VARIABLE
        int option = 0;
        // DECLARE & SET BOOLEAN VARIABLE INTO TRUE TO MAINTAIN DISPLAYING MENU AND REPRINTING IF AN ERROR OCCUR
        boolean flag = true;
        // LOOP FOR REPRINTING MENU IF NECESSARY
        while (flag)
        {
            // CHECK WHICH MENU SHOULD BE DISPLAYED
            switch(check)
            {
                case 1:
                    // DISPLAY MAIN MANU
                    System.out.println("\n***************************");
                    System.out.println("**    Payroll System    **");
                    System.out.println("***************************");
                    System.out.println("** 1) Register Employees **");
                    System.out.println("** 2) View Emplyees      **");
                    System.out.println("** 3) Remove Employees   **");
                    System.out.println("** 4) Generate Payslips  **");
                    System.out.println("** 5) Exit               **");
                    System.out.println("****************************\n");
                    
                    // METHOD TO DISPLAY ERRORS/EXCEPTION IF OCCUR WITH PARAMETER OPTION AND SERVICE (5 OPTIONS)
                    option = menuService(option, 5);
                    flag = false;
                    break;
                
                case 2:
                    // DISPLAY REGISTER MENU
                    System.out.println("\n****************************");
                    System.out.println("**    Register Employees  **");
                    System.out.println("****************************");
                    System.out.println(" 1)  Salaried Employees ");
                    System.out.println(" 2)  Hourly Employees ");
                    System.out.println(" 3)  Commisioned Employees ");
                    System.out.println(" 4)  Back ");
                    System.out.println(" 5)  Exit");
                    System.out.println("****************************\n");
                    
                    // METHOD TO DISPLAY ERRORS/EXCEPTION IF OCCUR WITH PARAMETER OPTION AND SERVICE (5 OPTIONS)
                    option = menuService(option, 5);
                    flag = false;
                    break;
                    
                case 3:
                    // DISPLAY VIEW MENU
                    System.out.println("\n****************************");
                    System.out.println("**    View Employees      **");
                    System.out.println("****************************");
                    System.out.println(" 1)  View Salaried Employees ");
                    System.out.println(" 2)  View Hourly Employees ");
                    System.out.println(" 3)  View Commisioned Employees ");
                    System.out.println(" 4)  View by employee ID ");
                    System.out.println(" 5)  Back");
                    System.out.println("****************************\n");
                    
                    // METHOD TO DISPLAY ERRORS/EXCEPTION IF OCCUR WITH PARAMETER OPTION AND SERVICE (5 OPTIONS)
                    option = menuService(option, 5);
                    flag = false;
                    break;
                    
                case 4:
                    // DISPLAY REMOVE MENU
                    System.out.println("\n****************************");
                    System.out.println("**    Remove Employees    **");
                    System.out.println("****************************");
                    System.out.println(" 1) Remove employee by ID      ");
                    System.out.println(" 2) Choose employee to remove  ");
                    System.out.println(" 3) Back                       ");
                    System.out.println("****************************\n");
                    
                    // METHOD TO DISPLAY ERRORS/EXCEPTION IF OCCUR WITH PARAMETER OPTION AND SERVICE (3 OPTIONS)
                    option = menuService(option, 3);
                    flag = false;
                    break;
                    
                case 5:
                    // DISPLAY PAYSLIP MENU
                    System.out.println("\n****************************");
                    System.out.println("**    Generate Payslips   **");
                    System.out.println("****************************");
                    System.out.println(" 1)  Salaried Employees ");
                    System.out.println(" 2)  Hourly Employees ");
                    System.out.println(" 3)  Commisioned Employees ");
                    System.out.println(" 4)  By employee ID ");
                    System.out.println(" 5)  Back");
                    System.out.println("****************************\n");
                    
                    // METHOD TO DISPLAY ERRORS/EXCEPTION IF OCCUR, WITH PARAMETER OPTION AND SERVICE (5 OPTIONS)
                    option = menuService(option, 5);
                    flag = false;
                    break;
            }
        }
        
        // RETURN THE CHOSEN OPTION TO MAIN PROGRAM
        return option; 
    }
    
    public int menuService(int option, int service)
    {
        // PROMPT THE USER TO CHOOSE OPTION
            System.out.print("   Please enter an option: ");
            
            // TRY-CATCH BLOCK TO VALIDATE EXCEPTIONS
            try
            {
                // SAVE CHOSEN OPTION INTO VARIABLE
                option = input.nextInt();
                
                optionService(option, service);

            } catch (Exception e) // CATCHING EXCEPTIONS
            {
                // PRINTING ERROR MESSAGE WHEN CHOSEN OPTION IS NOT A NUMBER
                System.out.println("\n" +RED + "You must insert a number!\n" + RESET);

            }
                
            // CLEARING THE BUFFOR FOR FUTURE INPUTS
            input.nextLine();
            return option;
    }
    
    // METHOD TO DISPLAY ERRORS/EXCEPTION IF OCCUR WITH PARAMETER OPTION AND SERVICE (5 or 3 OPTIONS TO CHOOSE)
    public void optionService(int option,int service)
    {
        // CHECK HOW MANY OPTIONS
        if (service == 5)
        {
            // CHECK IF CHOSEN OPTION IS INCORRECT
            if(option < 1 || option > 5)
            {
                System.out.println("\n" + RED + "Wrong option selected!\n" + RESET); 
            } 
            // CHECK HOW MANY OPTIONS
        } else if (service == 3)
        {
            // CHECK IF CHOSEN OPTION IS INCORRECT
            if(option < 1 || option > 3)
            {
                System.out.println("\n" + RED + "Wrong option selected!\n" + RESET); 
            }
        }
    }
}
