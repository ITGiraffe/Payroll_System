// ELEMENT OF THE PAYROLL_SYSTEM PROGRAM
package payroll_system;

// NECESSARY IMPORTS TO EXECUTE PROGRAM (TO RUN ARRAYLISTS & EXCEPTIONS & TO INPUT DATA FROM THE USER)
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

// PAYROLL CLASS 
public class Payroll 
{
    // ARRAYLIST TO STORE EMPLOYEES AND THEIR DETAILS AS OBJECTS FROM EMPLOYEE CLASS
    public static ArrayList<Employee> employee = new ArrayList<Employee>();
    
    // CREATING AN OBJECT FROM MENU CLASS
    static Menu m = new Menu();
    
    // CREATING A SCANNER OBJECT TO FUTURE INPUTS FROM THE USER
    static Scanner payrolinput = new Scanner(System.in);
    
    // CHANGE COLOR OF TEXT INTO RED & GREEN
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    // RESET COLOR
    private static final String RESET = "\u001B[0m";
    
    // MAIN METHOD OF THE PROGRAM
    public static void main(String[] args) 
    {
        // START PROGRAM
        
        // ADD ALL NECESSARY EMPLOYEES INTO ARRAYLIST
        addEmployees();

        // PRINTING MAIN MENU FROM MENU CLASS
        
        // LOOP IN CASE OF ERROR APPEARANCE
        while(true)
        {
            // CALL MAINMENU METHOD FROM MENU CLASS & SAVE THE OUTPUT INTO OPT VARIABLE (1 - MAINMENU)
            int opt = m.mainMenu(1);
            
            // CHECKING WHICH OPTION WAS CHOSEN
            switch(opt)
            {
                // OPTION FOR REGISTERING EMPLOYEES
                case 1: 
                    
                    // METHOD TO REGISTER AN EMPLOYEE
                    registerSubMenu();
                    break;

                    // VIEW EMPLOYEE
                case 2: 
                    // METHOD TO REGISTER AN EMPLOYEE
                    viewEmployee();
                    break;

                    // REMOVE EMPLOYEE
                case 3: 
                    
                    // METHOD TO REMOVE AN EMPLOYEE
                    removeEmployee();
                    break;

                    // GENETARE PAYSLIPS
                case 4: 
                    
                    // METHOD TO GENERATE PAYSLIPS FOR EMPLOYEES
                    generatePaslip();
                    break;

                    // EXIT
                case 5: 

                    System.out.println("\nProgram ended.\n");
                    System.exit(0);
                    break;
            }
        }
    }
    
    // ADD ALL NECESSARY EMPLOYEES INTO ARRAYLIST
    public static void addEmployees()
    {
        // ADD FIRST SALARIED EMPLOYEE FOR PROGRAM TESTING & DEMONTRATION
        
        // CREATING SALARIED CLASS OBJECT TO ADD SALARIED EMPLOYEES 
        Salaried sal0 = new Salaried();
        // SET DETAILS OF EMPLOYEE
        sal0.setEmployee(1, "Miss", "Emilia", "Clarke", "SP345675A", "23/10/1986", Job_title.MANAGER, Department.FINANCE);
        // SET ANNUAL SALARY OF EMPLOYEE
        sal0.setAnnualSalary((float)70000.00);
        // SET TYPE OF EMPLOYEE
        sal0.settype("full time");
        //ADD SALARIED EMPLOYEE
        employee.add(sal0);
        
        // ADD SECOND SALARIED EMPLOYEE FOR PROGRAM TESTING & DEMONTRATION
        
        // CREATING SALARIED CLASS OBJECT TO ADD SALARIED EMPLOYEES 
        Salaried sal1 = new Salaried();
        // SET DETAILS OF EMPLOYEE
        sal1.setEmployee(2, "Mr", "Kit", "Harington", "SP345675A", "26/12/1986", Job_title.OFFICE_WORKER, Department.FINANCE);
        // SET ANNUAL SALARY OF EMPLOYEE
        sal1.setAnnualSalary((float)35000.00);
        // SET TYPE OF EMPLOYEE
        sal1.settype("full time");
        //ADD SALARIED EMPLOYEE
        employee.add(sal1);
        
        // ADD FIRST HOURLY EMPLOYEE FOR PROGRAM TESTING & DEMONTRATION
        
        // CREATING HOURLY CLASS OBJECT TO ADD HOURLY EMPLOYEES 
        Hourly hour0 = new Hourly();
        // SET DETAILS OF EMPLOYEE
        hour0.setHourly(3, "Miss", "Sophie", "Turner", "FF647356A", "22/02/1996", Job_title.SUPERVISOR, Department.FINANCE);
        // SET EMPLOYEE WORKING HOURS (WEEKLY)
        hour0.setHourlyHours((short)160);
        // SET EMPLOYEE HOUR RATE
        hour0.setHourlyRate((float)20.25);
        //ADD HOURLY EMPLOYEE
        employee.add(hour0);
        
        // ADD SECOND HOURLY EMPLOYEE FOR PROGRAM TESTING & DEMONTRATION
        
        // CREATING HOURLY CLASS OBJECT TO ADD HOURLY EMPLOYEES 
        Hourly hour1 = new Hourly();
        // SET DETAILS OF EMPLOYEE
        hour1.setHourly(4, "Miss", "Maisie", "Williams", "FF646735A", "15/04/1997", Job_title.PROGRAMMER_ANALYST, Department.IT_SERVICES);
        // SET EMPLOYEE WORKING HOURS (WEEKLY)
        hour1.setHourlyHours((short) 145);
        // SET EMPLOYEE HOUR RATE
        hour1.setHourlyRate((float)22.75);
        //ADD HOURLY EMPLOYEE
        employee.add(hour1);
        
        // ADD FIRST COMMISSION EMPLOYEE FOR PROGRAM TESTING & DEMONTRATION
        
        // CREATING COMMISSION CLASS OBJECT TO ADD COMMISION EMPLOYEES 
        Commission com0 = new Commission();
        // SET DETAILS OF EMPLOYEE
        com0.setCommission(5, "Mr", "Peter", "Dinklage", "DD453373B", "11/06/1969", Job_title.DIRECTOR, Department.HUMAN_RESOURCE);
        // SET COMMISION RATE FOR COMMISION EMPLOYEE AS INTEGER FROM 1-100 (PERCENTAGE)
        com0.setCommissionRate((byte)7);
        // SET COMMISION TOTAL SUM FOR SALES
        com0.setCommissionTotal((float)15000.00);
        // SET COMMISION ANNUAL BASE SALARY
        com0.setCommissionContract((float)110000.00);
        //ADD COMMISSION EMPLOYEE
        employee.add(com0);
        
        // ADD SECOND COMMISSION EMPLOYEE FOR PROGRAM TESTING & DEMONTRATION
        
        // CREATING COMMISSION CLASS OBJECT TO ADD COMMISION EMPLOYEES 
        Commission com1 = new Commission();
        // SET DETAILS OF EMPLOYEE
        com1.setCommission(6, "Mrs", "Lena", "Headey", "DD451173B", "03/10/1973", Job_title.SOFTWARE_DEVELOPER, Department.IT_SERVICES);
        // SET COMMISION RATE FOR COMMISION EMPLOYEE AS NUMBER FROM 1-100 (PERCENTAGE)
        com1.setCommissionRate((byte)4);
        // SET COMMISION TOTAL SUM FOR SALES
        com1.setCommissionTotal((float)30000.00);
        // SET COMMISION ANNUAL CONTRACT SALARY
        com1.setCommissionContract((float)60000.00);
        //ADD COMMISSION EMPLOYEE
        employee.add(com1);
        
    }
    
    // VIEW EMPLOYEE BY ID
    public static void printEmployee(String type, int payslip)
    {
        // VARIABLES NEEDED TO OPERATE SEARCH
        int emp_id;
        boolean found = false;
        boolean flag = true;

        try
        {
            switch(type)
            {
                case "ID":

                    // PROMPT USER TO ENTER EMPLOYEE ID
                    System.out.println("\nPlease enter the employee ID to view: ");

                    while(flag)
                    {
                        // SAVING USER OPTION
                        emp_id = payrolinput.nextInt(); payrolinput.nextLine();

                        // EMPLOYEE SEARCH
                        for(int i = 0; i<employee.size(); i++)
                        {
                            if(emp_id == employee.get(i).getID())
                            {
                                // IF FOUND - SAVING EMPLOYEE CLASS
                                String registerAs = employee.get(i).getClass().getName();
                                found = true;  

                                // PRINTING EMPLOYEE CONTRACT TYPE
                                switch(registerAs)
                                {
                                    case "payroll_system.Salaried":

                                        System.out.println("\n" + GREEN + "Employee is registered as salaried employee" + RESET);
                                        break;

                                    case "payroll_system.Hourly":

                                        System.out.println("\n" + GREEN + "Employee is registered as hourly employee" + RESET);
                                        break;

                                    case "payroll_system.Commission":

                                        System.out.println("\n" + GREEN + "Employee is registered as commission employee" + RESET);
                                        break;
                                }

                                // PRINTING DETAILS
                                employee.get(i).printEmployee(); 
                                
                                if(payslip == 1)
                                {
                                    // PRINTING EMPLOYEE PAYSLIP
                                    switch(registerAs)
                                    {
                                        case "payroll_system.Salaried":

                                            System.out.println("\nPayslip:");
                                            employee.get(i).generatePayslip();
                                            break;

                                        case "payroll_system.Hourly":

                                            System.out.println("\nPayslip:");
                                            employee.get(i).generatePayslip();
                                            break;

                                        case "payroll_system.Commission":

                                            System.out.println("\nPayslip:");
                                            employee.get(i).generatePayslip();
                                            break;
                                    }
                                }
                                
                                break;
                            }
                        }
                        
                        // NEEDED ACTIONS IF EMPLOYEE WAS FOUND OR NOT
                        if (found)
                        {
                             flag = false;

                        } else
                        {
                           System.out.println("\n"+ RED + "No employee found!\n" + RESET);
                            System.out.println("Please try again:");
                         }
                    }

                    break;

                case "SALARIED":

                    // DISPLAY SALARIED EMPLOYEE
                    dislayEmployee("payroll_system.Salaried", payslip);
                    break;

                case "HOURLY":

                    // DISPLAY HOURLY EMPLOYEE
                    dislayEmployee("payroll_system.Hourly", payslip);
                    break;

                case "COMMISSION":

                    // DISPLAY COMMISSION EMPLOYEE
                    dislayEmployee("payroll_system.Commission", payslip);
                    break;
            }

        // CATCH EXCEPTIONS
        } catch(InputMismatchException e)
        {
            // CLEAN THE BUFFER 
            payrolinput.nextLine();
            // DISPLAY EXCEPTION MESSAGE
            System.out.println("\n"+ RED + "This is not a number!\n" + RESET);
            System.out.println("Enter Employee ID again:");

        }
    }
    
    // METHOD TO DISPLAY EMPLOYEE
    public static void dislayEmployee(String employeeType, int payslip)
    {
        // VARIABLE TO SET IF EMPLOYEE FOUND
        boolean found = false;
        
        // TO OPERATE LOOP & options
        boolean setLoop = true;
        int opt;
        int numberOfOptions = 0;
        int position = 0;
        int onlyOneEmployeeType = 0;
        
        // LOOP FOR PRINTING FIRST EMPLOYEE OF SPECIFIC TYPE
        for(int i = 0; i < employee.size(); i++)
        {
        
            // CHECK IF EMPLOYEE IS EXACT TYPE
            if(employee.get(i).getClass().getName().equals(employeeType))
            {
                // SAVING EMPLOYEE INDEX IN AN ARRAYLIST
                position = i;
                
                // PRINT EMPLOYEE DETAILS & OPTIONS
                System.out.println("Position: " + (position +1 ));
                employee.get(i).printEmployee(); 
                
                // TO SET NUMBER OF OPTIONS
                if(payslip == 1)
                {
                    // WITH PAYSLIP
                    System.out.println("\n\n 1) Previous\n 2) Next\n 3) Back\n 4) Generate payslip\n");
                    
                } else
                {             
                    // WITHOUT PAYSLIPS
                    System.out.println("\n\n 1) Previous\n 2) Next\n 3) Back\n");
                }
                    found = true;
                    break;
            }
        }
        
        if(!found)
        {
            // MESSAGE IF NO EMPLOYEES
            System.out.println("\n"+ RED + "There is no employees of this type.\n" + RESET);
        } else
        {
            // PROMT USER TO CONTINUE
            System.out.println("Please choose option:");
            
            while(setLoop)
            {
                try
                {
                    // SAVE OPTION
                    opt = payrolinput.nextInt(); payrolinput.nextLine();
                    
                    // TO SET NUMBER OF OPTIONS
                    if(payslip == 1)
                    {
                        // WITH PAYSLIP
                        numberOfOptions = 5;

                    } else
                    { 
                        // WITHOUT PAYSLIPS
                        numberOfOptions = 4;
                    }
                    
                    // CHECK IF OPTION WAS CHOSEN CORRECTLY
                    if(opt > 0 && opt < numberOfOptions)
                        
                    {
                        
                        // CHECKING WHICH OPTION WAS CHOSEN
                        switch(opt)
                        {
                            // PRINT PREVIOUS EMPLOYEE
                            case 1: 

                                // IF THERE IS NO PREVIOUS EMPLOYEE THAN SHOW LAST EMPLOYEE
                                if(position == 0)
                                {
                                    // onlyOneEmployeeType IS SET TO 1 WHEN ONLY ONE EMPLOYEE IS REGISTER AT ANY TYPE
                                    // THAN THERE IS NO ANOTHER EMPLOYEE TO SEARCH
                                    if(onlyOneEmployeeType == 0)
                                    {
                                        position = employee.size();
                                        onlyOneEmployeeType = onlyOneEmployeeType + 1;
                                    } else
                                    {
                                         throw new Exception();
                                    }
                                }

                                // NEXT
                                position =  position - 1;
                                
                                //  CHEKING IF PREVIOUS EMPLOYEE IS EXACT TYPE
                                boolean check = true;
                                while(check)
                                {
                                    if(employee.get(position).getClass().getName().equals(employeeType))
                                    {
                                        // PRINT DETAILS OF AN EMPLOYEE
                                        System.out.println("Position: " + (position +1 ));
                                        employee.get(position).printEmployee();
                                        
                                        // TO GENERATE PAYSLIP
                                        if(payslip == 1)
                                        {
                                            // PRINT OPTIONS
                                            System.out.println("\n\n 1) Previous\n 2) Next\n 3) Back\n 4) Generate payslip\n");
                                            
                                        } else
                                        {           
                                            // CONTINUE CHECKING  EMPLOYEES
                                            System.out.println("\n\n 1) Previous\n 2) Next\n 3) Back\n");
                                        }
                                        
                                        System.out.println("Please choose option:");
                                        check = false;

                                        // IF TEHRE IS MORE THAN 1 EMPLOYEE OF THE TYPE THAN SET THIS TO 0
                                        onlyOneEmployeeType = 0;
                                        
                                    } else
                                    {
                                        // IF THERE IS NO PREVIOUS EMPLOYEE THAN SHOW LAST EMPLOYEE
                                        if(position == 0)
                                        {
                                            // onlyOneEmployeeType IS SET TO 1 WHEN ONLY ONE EMPLOYEE IS REGISTER AT ANY TYPE
                                            // THAN THERE IS NO ANOTHER EMPLOYEE TO SEARCH
                                            if(onlyOneEmployeeType == 0)
                                            {
                                                position = employee.size();
                                                onlyOneEmployeeType = onlyOneEmployeeType + 1;
                                            } else
                                            {
                                                 throw new Exception();
                                            }
                                        }
                                        
                                        // NEXT
                                        position =  position - 1;
                                    }
                                }
                                
                                break;

                            // PRINT NEXT EMPLOYEE
                            case 2:

                                // IF THERE IS NO NEXT EMPLOYEE THAN SHOW FIRST EMPLOYEE
                                if(position == employee.size() - 1)
                                {
                                    // onlyOneEmployeeType IS SET TO 1 WHEN ONLY ONE EMPLOYEE IS REGISTER AT ANY TYPE
                                    // THAN THERE IS NO ANOTHER EMPLOYEE TO SEARCH
                                    if(onlyOneEmployeeType == 0)
                                    {
                                        position = -1;
                                        onlyOneEmployeeType = onlyOneEmployeeType + 1;
                                    } else
                                    {
                                         throw new Exception();
                                    }
                                }

                                // NEXT
                                position =  position + 1;
                                
                                //  CHEKING IF PREVIOUS EMPLOYEE IS EXACT TYPE
                                check = true;
                                while(check)
                                {
                                    // CHECK ID EMPLOYEE EXISTS
                                    if(employee.get(position).getClass().getName().equals(employeeType))
                                    {
                                        // PRINT DETAILS OF AN EMPLOYEE
                                        System.out.println("Position: " + (position + 1 ));
                                        employee.get(position).printEmployee();
                                        
                                        // TO GENERATE PAYSLIP
                                        if(payslip == 1)
                                        {
                                            // PRINT OPTIONS
                                            System.out.println("\n\n 1) Previous\n 2) Next\n 3) Back\n 4) Generate payslip\n");
                                            
                                        } else
                                        {   
                                            // PROMPT USER TO CHOOSE THE OPTION
                                            System.out.println("\n\n 1) Previous\n 2) Next\n 3) Back\n");
                                        }
                                            System.out.println("Please choose option:");
                                            check = false;
                                            // IF TEHRE IS MORE THAN 1 EMPLOYEE OF THE TYPE THAN SET THIS TO 0
                                            onlyOneEmployeeType = 0;
                                        
                                    } else
                                    {
                                        // IF THERE IS NO PREVIOUS EMPLOYEE THAN SHOW LAST EMPLOYEE
                                        if(position == employee.size() - 1)
                                        {
                                            // onlyOneEmployeeType IS SET TO 1 WHEN ONLY ONE EMPLOYEE IS REGISTER AT ANY TYPE
                                            // THAN THERE IS NO ANOTHER EMPLOYEE TO SEARCH
                                            if(onlyOneEmployeeType == 0)
                                            {
                                                position = -1;
                                                onlyOneEmployeeType = onlyOneEmployeeType + 1;
                                            } else
                                            {
                                                 throw new Exception();
                                            }
                                        }
                                        
                                        // NEXT
                                        position =  position + 1;
                                    }
                                }
                                
                                break;

                            // BACK
                            case 3:

                                setLoop = false;
                                break;
                                
                            // PRINT PAYSLIP
                            case 4:
                                
                                // METHOD TO PIRNT PAYSLIP
                                employee.get(position).generatePayslip();
                                setLoop = false;
                                break;
                        }
                        
                    } else
                    {
                        throw new Exception();
                    }
                    
                } catch(InputMismatchException e)
                {
                    // CLEAN THE BUFFER 
                    payrolinput.nextLine();

                    // DISPLAY EXCEPTION MESSAGE
                    System.out.println("\n"+ RED + "This is not a number!\n" + RESET);
                    System.out.println("Enter option again:");
                    
                } catch(Exception e)
                {
                    // DISPLAY EXCEPTION MESSAGE
                    System.out.println("\n"+ RED + "This option not exists!\n" + RESET);
                    System.out.println("Enter option again:");
                }
            }
        }
        
        
    }
    // METHOD TO REGISTER AN EMPLOYEE
    public static void registerSubMenu()
    {
        // VARIABLE TO SET REPRINTING REGISTERSUBMENU 
        boolean setMenu = true;
        
        // REPRINTING REGISTERSUBMENU
        while(setMenu)
        {
                // CALL MAINMENU METHOD FROM MENU CLASS & SAVE THE OUTPUT INTO OPT VARIABLE (2 - REGISTER MENU)
            int opt = m.mainMenu(2);

            // CHECKING WHICH OPTION WAS CHOSEN
            switch(opt)
            {
                // SALARIED EMPLOYEE REGISTER
                case 1: 
                        // CREATING SALARIED CLASS OBJECT
                        Salaried sal = new Salaried();
                        // SET DETAILS OF EMPLOYEE FROM THE USER INPUTS
                        sal.setEmployee();
                        //ADD SALARIED EMPLOYEE
                        employee.add(sal);
                        System.out.println("\n" + GREEN + "Employee succesfully registered. "+ RESET);
                    break;

                // HOURLY EMPLOYEE REGISTER
                case 2:
                    // CREATING HOURLY CLASS OBJECT
                    Hourly hour = new Hourly();
                    // SET DETAILS OF EMPLOYEE FROM THE USER INPUTS
                    hour.setHourly();
                    //ADD HOURLY EMPLOYEE
                    employee.add(hour);
                    System.out.println("\n" + GREEN + "Employee succesfully registered. "+ RESET);
                    break;

                // COMMISSION EMPLOYEE REGISTER
                case 3: 
                    // CREATING COMMISSION CLASS OBJECT
                    Commission com = new Commission();
                    // SET DETAILS OF EMPLOYEE FROM THE USER INPUTS
                    com.setCommission();
                    //ADD COMMISSION EMPLOYEE
                    employee.add(com);
                    System.out.println("\n" + GREEN + "Employee succesfully registered. "+ RESET);
                    break;

                    // BACK
                case 4:  
                    // CANCEL REPRINTING REGISTER MENU
                    setMenu = false;
                    break;

                    // EXIT
                case 5:
                    System.out.println("\nProgram ended.\n");
                    System.exit(0);
                    break;     
            }
        }
    }
    
    // METHOD TO REGISTER AN EMPLOYEE
    public static void viewEmployee()
    {
        // VARIABLE TO SET REPRINTING VIEWEMPLOYEE
        boolean setMenu = true;
        
        // REPRINTING VIEWEMPLOYEE
        while(setMenu)
        {
            // CALL MAINMENU METHOD FROM MENU CLASS & SAVE THE OUTPUT INTO OPT VARIABLE (3 - VIEW MENU)
            int opt = m.mainMenu(3);

            // CHECKING WHICH OPTION WAS CHOSEN
            switch(opt)
            {
                // VIEW SALARIED EMPLOYEE 
                case 1: 
                    // PRINTING EMPLOYEES WITHOUT PAYSLIP OPTION (0)
                    printEmployee("SALARIED", 0);
                    break;

                // VIEW HOURLY EMPLOYEE
                case 2:
                    // PRINTING EMPLOYEES WITHOUT PAYSLIP OPTION (0)
                    printEmployee("HOURLY", 0);
                    break;

                // VIEW COMMISSION EMPLOYEE 
                case 3: 
                    // PRINTING EMPLOYEES WITHOUT PAYSLIP OPTION (0)
                    printEmployee("COMMISSION", 0);
                    break;

                // VIEW BY ID
                case 4:  
                    // VIEW BY OD METHOD WITHOUT PAYSLIP OPTION (0)
                    printEmployee("ID", 0);
                    break;

                // BACK
                case 5:
                    // CANCEL REPRINTING VIEW MENU
                    setMenu = false;
                    break;     
            }
        }
        
    }
    
    // METHOD TO REMOVE AN EMPLOYEE
    public static void removeEmployee()
    {
        // VARIABLE TO SET REPRINTING REMOVEEMPLOYEE 
        boolean setMenu = true;
        
        // REPRINTING REGISTERSUBMENU
        while(setMenu)
        {
            // CALL MAINMENU METHOD FROM MENU CLASS & SAVE THE OUTPUT INTO OPT VARIABLE (4 - REMOVE MENU)
            int opt = m.mainMenu(4);
            
            // CHECKING WHICH OPTION WAS CHOSEN
            switch(opt)
            {
                // FREMOVE EMPLOYEE BY ID
                case 1: 
                    // REMOVE EMPLOYEE BY ID
                    removeByID();
                    break;

                // CHOOSE EMPLOYEE & REMOVE
                case 2:

                    // REMOVE EMPLOYEE WHEN CHOSING
                    chooseRemove();
                    break;

                // BACK
                case 3:
                    // CANCEL REPRINTING VIEW MENU
                    setMenu = false;
                    break;     
            }
        }  
    }
    
    // FREMOVE EMPLOYEE BY ID
    public static void removeByID()
    {
        // VARIABLE TO SET REPRINTING IF UNEXPECTED OCCUR 
        boolean setLoop = true;
        boolean found = false;
        
        System.out.println("\n Please enter employee ID to remove employee:");
        
        while(setLoop)
        {
            try
            {
                // SAVING USER INPUT
                int emp_id = payrolinput.nextInt(); payrolinput.nextLine();
                
                for (int i = 0; i < employee.size(); i++)
                {
                    // FIND EMPLOYEE
                    if(emp_id == employee.get(i).getID())
                    {
                        // SET FOUND VARIABLE IF EMPLOYEE WAS FOUND
                        found = true;
                        
                        // PRINTING DETAILS OF THE EMPLOYEE
                        employee.get(i).printEmployee();
                        
                        //  VARIABLE FOR LAST QUESTION LOOP
                        boolean setFinalLoop = true;
                        
                        // LAST QUESTION LOOP
                        while(setFinalLoop)
                        {
                            System.out.println("\nDo you really want to delete this employee? (y/n)");
                        
                            String delete = payrolinput.nextLine();

                            switch(delete)
                            {
                                case "y":

                                    // REMOVE EMPLOYEE
                                    employee.remove(i);
                                    setFinalLoop = false;
                                    System.out.println("\n" + GREEN +  "Employee succesfully removed." + RESET + "\n");
                                     break;

                                case "n":
                                    
                                    // IF NOT THAN STOP REMOVING
                                    setFinalLoop = false;
                                    break;
                            }
                        }
                    }
                }
                
                // IF EMPLOYEE NOT FOUND OR DELETED ALREADY
                if(!found)
                {
                    System.out.println("\n"+ RED + "Employee not exist!\n" + RESET);
                    System.out.println("Enter Employee ID again:");
                } else
                {
                    // IF FOUND AND DELETED THAN STOP REMOVING
                    setLoop = false;
                }

                        
            } catch(InputMismatchException e)
            {
                // CLEAN THE BUFFER 
                payrolinput.nextLine();
                
                // DISPLAY EXCEPTION MESSAGE
                System.out.println("\n"+ RED + "This is not a number!\n" + RESET);
                System.out.println("Enter Employee ID again:");
            }
        }
    }
    
    
    // REMOVE EMPLOYEE WHEN CHOSING
    public static void chooseRemove()
    {
        // NECCESSARY VARIABLES TO OPERATE
        int employeeNumber = 0;
        int opt;
        boolean setLoop = true;
        
        // INFO FOR USER
        System.out.println("\nActually registered employees: " + employee.size());
        
        // SELECTING WHICH EMPLOYEE SHOULD BE PRINTED ON THE SCREEN
        System.out.println("\nPlease choose which employee should be printed (select a number):");
        
        while(setLoop)
        { 
            try
            {
                // SAVING NUMBER AND JUSTIFY INTO ARRAYLIST (-1) IF ENTERED NUMBER IS NOT 0
                employeeNumber = payrolinput.nextInt(); payrolinput.nextLine();
                
                if(employeeNumber == 0)
                {
                    throw new InputMismatchException();
                }   
                    
                employeeNumber--;
                
                // PRINTING DETAILS OF THE EMPLOYEE
                employee.get(employeeNumber).printEmployee();
                
                // FINISH LOOP
                setLoop = false;
                
            // WHEN THERE IS NO NUMBERS INSERTED
            }catch(InputMismatchException e)
            {
                // CLEAN THE BUFFER 
                payrolinput.nextLine();
                
                // DISPLAY EXCEPTION MESSAGE
                System.out.println("\n"+ RED + "This is not a number!\n" + RESET);
                System.out.println("Please choose which employee should be printed again (select a number):\n");
               
                // EXCEPTION WHEN INSERTED NUMBER IS BIGGER THAN ARRAYLIST
            } catch (IndexOutOfBoundsException e)
            {
                System.out.println("\n" + RED + "We do not have than many employees!\n" + RESET);
                System.out.println("Please choose which employee should be printed again (select a number):\n");
            }
        }
        
        // SET LOOP VARIABLE
        setLoop = true;
        
        while(setLoop)
        { 
            try
            {
                // DISPLAY OPTION
                System.out.println("\n1) Previous\n2) Next\n3) Remove\n4) Back\n\nPlease choose an option:\n");

                // PROMPT USER TO CHOOSE AN OPTION
                opt = payrolinput.nextInt(); payrolinput.nextLine();

                // CHECKING WHICH OPTION WAS CHOSEN
                switch(opt)
                {
                    // PRINT PREVIOUS EMPLOYEE
                    case 1: 

                        if(employeeNumber == 0)
                        {
                            employeeNumber = employee.size();
                        }
                        
                        employeeNumber =  employeeNumber - 1;
                        System.out.println("Position: " + (employeeNumber +1 ));
                        employee.get(employeeNumber).printEmployee();
                        break;

                    // PRIONT NEXT EMPLOYEE
                    case 2:

                        if(employeeNumber == employee.size() - 1)
                        {
                            employeeNumber = -1;
                        }
                        employeeNumber = employeeNumber + 1;
                        System.out.println("Position: " + (employeeNumber + 1));
                        employee.get(employeeNumber).printEmployee();
                        break;

                    // REMOVE EMPLOYEE
                    case 3:

                        //  VARIABLE FOR LAST QUESTION LOOP
                        boolean setFinalLoop = true;
                        
                        // LAST QUESTION LOOP
                        while(setFinalLoop)
                        {
                            System.out.println("\nDo you really want to delete this employee? (y/n)");
                        
                            String delete = payrolinput.nextLine();

                            switch(delete)
                            {
                                case "y":

                                    // REMOVE EMPLOYEE
                                    employee.remove(employeeNumber);
                                    setFinalLoop = false;
                                    System.out.println("\n Employee succesfully removed.\n");
                                     break;

                                case "n":
                                    
                                    // IF NOT THAN STOP REMOVING
                                    setFinalLoop = false;
                                    break;
                            }
                        }
                        setLoop = false;
                        break;   

                    // BACK
                    case 4:

                        setLoop = false;
                        break;

                    default:

                        System.out.println("\n" + RED + "Wrong option selected!\n" + RESET);
                        System.out.println("Please choose an option again:\n");
                        break;

                }
                
                // WHEN THERE IS NO NUMBERS INSERTED
            }catch(InputMismatchException e)
            {
                // CLEAN THE BUFFER 
                payrolinput.nextLine();
                
                // DISPLAY EXCEPTION MESSAGE
                System.out.println("\n"+ RED + "This is not a number!\n" + RESET);
                System.out.println("Please choose an option again:\n");
               
                // EXCEPTION WHEN INSERTED NUMBER IS BIGGER THAN ARRAYLIST
            }
        }
    }
    
    // METHOD TO GENERATE PAYSLIPS FOR EMPLOYEES
    public static void generatePaslip()
    {
        // VARIABLE TO SET REPRINTING MENU
        boolean setMenu = true;
        
        // REPRINTING 
        while(setMenu)
        {
            // CALL MAINMENU METHOD FROM MENU CLASS & SAVE THE OUTPUT INTO OPT VARIABLE (5 - PAYSLIP MENU)
            int opt = m.mainMenu(5);

            // CHECKING WHICH OPTION WAS CHOSEN
            switch(opt)
            {
                // VIEW SALARIED EMPLOYEE 
                case 1: 
                    // PRINTING EMPLOYEES WITH PAYSLIP OPTION (1)
                    printEmployee("SALARIED", 1);
                    break;

                // VIEW HOURLY EMPLOYEE
                case 2:
                    // PRINTING EMPLOYEES WITH PAYSLIP OPTION (1)
                    printEmployee("HOURLY", 1);
                    break;

                // VIEW COMMISSION EMPLOYEE 
                case 3: 
                    // PRINTING EMPLOYEES WITH PAYSLIP OPTION (1)
                    printEmployee("COMMISSION", 1);
                    break;

                // VIEW BY ID
                case 4:  
                    // VIEW BY OD METHOD WITH PAYSLIP OPTION (1)
                    printEmployee("ID", 1);
                    break;

                // BACK
                case 5:
                    // CANCEL REPRINTING VIEW MENU
                    setMenu = false;
                    break;     
            }
        }
    }
}
