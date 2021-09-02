// ELEMENT OF THE PAYROLL_SYSTEM PROGRAM
package payroll_system;

// NECESSARY IMPORTS TO EXECUTE PROGRAM (HANDLING EXCEPTIONS & TO INPUT DATA FROM THE USER)
import java.util.InputMismatchException;
import java.util.Scanner;

// SALARIED CLASS, CHILD CLASS FROM PARENT EMPLOYEE CLASS (INHERITANCE)
public class Salaried extends Employee
{
    // CREATING A SCANNER OBJECT TO FUTURE INPUTS FROM THE USER
    static Scanner input = new Scanner(System.in);
    
    // VARIABLE TO STORE ANNUAL SALARY OF SALARIED EMPLOYEE & IF TI IS A PART TIME OR NOT
    private float annual_sal;
    private String type;
    
    // VARIABLES HANDLING LOOPS & EXCEPTIONS
    private boolean setLoop = true;
    private String exceptionMsg = "";
    
    // CHANGE COLOR OF TEXT INTO RED & GREEN
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    // RESET COLOR
    private static final String RESET = "\u001B[0m";
    
    // CONSTRUCTOR
    public Salaried()
    {
        
    }
    
    // METHOD TO SET DETAILS OF EMPLOYEE WHEN MOST OF THE PARAMETERS ARE GIVEN IN PROPER FORMAT
    public void setEmployee(int employee_ID,String employee_title,String f_Name,String l_Name,String NI,String DoB,Job_title job_title,Department job_Dep)
    {
        // SETTING DETAILS
        super.setEmployee(employee_ID, employee_title, f_Name, l_Name, NI, DoB, job_title, job_Dep);
    }
    
    // CHECKING IF EMPLOYEE ID IS IN USE
    public boolean checkEmployee_ID(int e_id)
    {
        // LOOP TO CHECK ALL EXISTING EMPLOYEES
        for(int i = 0; i<Payroll.employee.size();i++)
        {
            // CHECKING EXISTING ID'S WITH THE INSERTED ONE
            if(e_id == Payroll.employee.get(i).getID())
            {
                // IF FOUND ANY DISPLAY AN ERROR & PROMPT USE TO INSERT ANOTHER EMPLOYEE ID, SET METHOD VALUE INTO TRUE
                System.out.println( "\n" + RED + "Error: An employee with this ID already exists, please choose different ID.\n" + RESET);
                System.out.println("Enter Employee ID again:");
                return true;

            } 
            
        }
        // IF THE INSERTED ID IS UNIQUE SET METHOD VALUE INTO FALSE AS WELL AS LOOP VARIABLE
        return setLoop = false;
    }
    
    // SET DETAILS OF EMPLOYEE FROM THE USER INPUTS
    public void setEmployee()
    {
        // VARIABLES TO OPERATE CHOSEN OPTIONS IN SWITCH CASE METHODS TO COVER INPUTS FROM ENUM CLASSES
        int dep, job;
        
        // PROMPT THE USER TO INSERT EMPLOYEE ID & REPEAT ENTERING EMPLOYEE ID IF ERROR OCCUR
        System.out.println("Enter Employee ID:"); 
        while(setLoop)
        {
            // TRY-CATCH BLOCK TO VALIDATE EXCEPTIONS
            try
            {
                // LOOP TO CHECK IF INSERTED EMPLOYEE ID IS IN USE ALREADY
                do
                {
                    // SAVE INPUT INTO A VARIABLE & CLEAR THE BUFFER
                    employee_ID = input.nextInt(); input.nextLine();

                // CHECKING IF EMPLOYEE ID IS IN USE, REPEAT IF METHOD RETURN TRUE (IF DUPLICATED)
                }while(checkEmployee_ID(employee_ID));
                
                // IF INSERTED ID NUMBER IS NEGATIVE OR 0 
                if(employee_ID < 1)
                {
                    System.out.println("\n"+ RED + "Employee ID cannot be 0 or negative!\n" + RESET);
                    System.out.println("Enter Employee ID again:");
                    setLoop = true;
                }
                
            // CATCH EXCEPTIONS
            } catch(InputMismatchException e)
            {
                // CLEAN THE BUFFER 
                input.nextLine();
                // DISPLAY EXCEPTION MESSAGE
                System.out.println("\n"+ RED + "This is not a number!\n" + RESET);
                System.out.println("Enter Employee ID again:");

            }
        }

        // PREPARE FOR NEXT LOOP
        setLoop = true;

        // PROMPT USER TO INSERT EMPLOYEE TITLE & SAVE IT IN VARIABLE
        System.out.println("Enter Employee title:");
        employee_title = input.nextLine();

        // PROMPT USER TO INSERT EMPLOYEE FIRST NAME & SAVE IT (ONLY FIRST WORD, TILL SPACE) IN VARIABLE
        System.out.println("Enter Employee first name:");
        f_Name = input.next();

        // PROMPT USER TO INSERT EMPLOYEE LAST NAME & SAVE IT (ONLY FIRST WORD, TILL SPACE) IN VARIABLE
        System.out.println("Enter Employee last name:");
        l_Name = input.next(); input.nextLine();
        
        // REPEAT ENTERING EMPLOYEE NATIONAL INSURANCE NUMBER IF ERROR OCCUR
        while(setLoop)
        {
            // TRY TO CATCH AN EXCEPTION
            try
            {

                // PROMPT USER TO INSERT EMPLOYEE NATIONAL INSURANCE & SAVE IT IN VARIABLE
                System.out.println("Enter Employee NI:\n NI is combine from two first letters "
                                 + "followed by 6 digits and one letter in the end.");
                NI = input.nextLine();

                // VALIDATION, CHECK IT CONTAINS 9 CHARACTERS
                if(NI.length() == 9)
                {
                    // CHECKING FORMAT OF NATIONAL INSURANCE (FIRST TWO ARE LETTERS, THAN NEXT 6 ARE NUMBERS, 
                    // FINALLY LAST ONE IS A LETTER) & IF THERE IS A FORMAT ERROR THROW AN EXCEPTION
                    for(int i = 0; i<NI.length(); i++)
                    {
                        int character =NI.charAt(i);
                        
                        // CHECK FIRST TWO CHARACTERS
                        if( i < 2 && (character <= 64 || (character > 90 && character < 97) || character > 122))
                        {
                            throw new Exception();
                            
                        // CHECK MIDDLE 6 NUMBERS 
                        } else if(( i > 1 && i < 8) && (character < 48 || character > 57))
                        {
                            throw new Exception();
                            
                        // CHECK LAST CHARACTER
                        } else if( i == 8 && (character <= 64 || (character > 90 && character < 97) || character > 122))
                        {
                            throw new Exception();
                            
                        }
                    }
                    // FINISH THE LOOP WHEN FORMAT IS CORRECT
                    setLoop = false;   
                } else
                {
                    throw new Exception();
                }
            } catch(Exception e)
            {
                // PRINT EXCEPTION MESSAGE IF OCCUR
                System.out.println("\n"+ RED + "Wrong format!\n" + RESET); 
                
            }
        }
        
        // PREPARE FOR NEXT LOOP
        setLoop = true;
        
        // PROMPT USER TO ENTER DATE OF BIRTH OF EMPLOYEE
        System.out.println("Enter Employee date of birth:");
        DoB = input.nextLine();
        
        // PROMPT USER TO ENTER TYPE OF EMPLOYEE
        System.out.println("Enter is employee a part-time or full-time:");
        type = input.nextLine();

        // PROMPT USER TO CHOSE EMPLOYEE TITLE
        System.out.println("Choose employee job title:\n 1)OFFICE_WORKER\n 2)OFFICER\n 3)SUPERVISOR\n"
                         + " 4)TEAM_LEADER\n 5)MANAGER\n 6)CEO\n 7)DIRECTOR\n 8)SOFTWARE_ENGINNER\n 9)SOFTWARE_DEVELOPER\n" +
                           " 10)JUNIOR_SOFTWARE_DEVELOPER\n 11)JUNIOR_SOFTWARE_ENGINNER\n 12)CODER\n 13)PROGRAMMER_ANALYST");

        // REPRINT APRIOPIATE MESSAGES IF AN EXCEPTION OCCUR
        while(setLoop)
        {
            try
            {
                // CHECK IF EXCEPTION APPEAR, IF YES, THAN PRINT EXCEPTION MESSAGE AND PROMPT USER AGAIN
                 if (exceptionMsg.length() > 2)
                 {
                     System.out.println("\n 1)OFFICE_WORKER\n 2)OFFICER\n 3)SUPERVISOR\n"
                         + " 4)TEAM_LEADER\n 5)MANAGER\n 6)CEO\n 7)DIRECTOR\n 8)SOFTWARE_ENGINNER\n 9)SOFTWARE_DEVELOPER\n" +
                           " 10)JUNIOR_SOFTWARE_DEVELOPER\n 11)JUNIOR_SOFTWARE_ENGINNER\n 12)CODER\n 13)PROGRAMMER_ANALYST");
                     
                     System.out.println( "\n" + RED + exceptionMsg + RESET );
                     
                     // CLEAN EXCEPTION MESSAGE
                     exceptionMsg = "";
                     System.out.println("Choose employee job title again:");
                 }
                 
                // SAVE CHOSEN OPTION
                job = input.nextInt();
                input.nextLine();
                
                // CHOOSE SETJOB() METHOND WITH JOB PARAMETER TO ASSIGN CHOSEN OPTION
                job_title = setjob(job);
                
                // CHECK IF THERE ARE NO EXCEPTIONS, IF NO, THAN FINISH REPRINTING
                if (exceptionMsg.length() == 0)
                {
                    setLoop = false;
                }
                
            } catch(InputMismatchException e)
            {
                // IF EXCEPTIONS OCCUR SET AN EXCEPTION MESSAGE
                input.nextLine();
                exceptionMsg = "Please enter a number option!\n";
            }
        }
        
        // PREPARE FOR NEXT LOOP
        setLoop = true;
        
        // PROMPT USER TO ENTER EMPLOYEE ANNUAL SALARY & REPRINT IF AN EXCEPION OCCUR
        System.out.println("Enter employee annual salary (in pounds): ");
        while(setLoop)
        {
            try
            {
                // SAVE INSERTET VALUE FROM USER AND FINISH REPEATING IF NO EXCEPTIONS
                float number = input.nextFloat(); input.nextLine();
                // ROUNDING DOWN IF MORE THAN 2 DECIMAL PLACES
                int increase = (int)(number*100);
                annual_sal = (float) increase/100;
                
                setLoop = false;
                
            } catch (InputMismatchException e)
            {
                // IF EXCEPTIONS OCCUR DISPLAY AN EXCEPTION MESSAGE AND PROMPT USER AGAIN
                input.nextLine();
                System.out.println( "\n" + RED + "Please enter a number\n" + RESET);
                System.out.println("Enter employee annual salary (in pounds) again: ");
            }
        }
                
        // PREPARE FOR NEXT LOOP
        setLoop = true;

        // PROMPT USER TO CHOSE EMPLOYEE DEPARTMENT & REPRINT IF AN EXCEPION OCCUR
        System.out.println("Enter Employee department:\n 1) PRODUCTION\n 2) MARKETING\n 3) FINANCE\n"
                         + " 4) HUMAN RESOURCE\n 5)IT SERVICES\n");
        while(setLoop)
        {
            try
            {
                if(exceptionMsg.length() > 2)
                {
                    // CHECK IF EXCEPTION APPEAR, IF YES, THAN PRINT EXCEPTION MESSAGE AND PROMPT USER AGAIN
                    System.out.println("\n 1) PRODUCTION\n 2) MARKETING\n 3) FINANCE\n"
                                     + " 4) HUMAN RESOURCE\n 5)IT SERVICES\n");
                    
                    System.out.println( "\n" +  RED + exceptionMsg + RESET );
                    
                    // CLEAN EXCEPTION MESSAGE
                    exceptionMsg = "";
                    System.out.println("Choose employee department again:");
                }
                
                // SAVE CHOSEN OPTION
                dep = input.nextInt();
                input.nextLine();
                
                // CHOOSE SETDEPARTMENT() METHOND WITH DEP PARAMETER TO ASSIGN CHOSEN OPTION
                job_Dep = setDepartment(dep);
                
                // CHECK IF THERE ARE NO EXCEPTIONS, IF NO, THAN FINISH REPRINTING
                if (exceptionMsg.length() == 0)
                {
                    setLoop = false;
                }
                                
            } catch (InputMismatchException e)
            {
                // IF EXCEPTIONS OCCUR SET AN EXCEPTION MESSAGE
                input.nextLine();
                exceptionMsg = "Please enter a number option!\n";
            }
        }
                
        // SET BACK THE VALUE
        setLoop = true;
        
        
    }
    
    // SET ANNUAL SALARY OF EMPLOYEE
    public void setAnnualSalary(float annual_sal)
    {
        this.annual_sal = annual_sal;
    }
    
    // SET TYPE OF EMPLOYEE
    public void settype(String type)
    {
        this.type = type;
    }
    
    // CHOOSE SETJOB() METHOND WITH JOB PARAMETER TO ASSIGN CHOSEN OPTION
    public Job_title setjob(int _job)
    {
        // SELECTING JOB TITLE THROUGH THE VALUE FROM THE USER (PARAMETER JOB)
        switch(_job)
        {
            case 1:
                job_title = Job_title.OFFICE_WORKER;
                break;
            case 2:
                job_title = Job_title.OFFICER;
                break;
            case 3:
                job_title = Job_title.SUPERVISOR;
                break;
            case 4:
                job_title = Job_title.TEAM_LEADER;
                break;
            case 5:
                job_title = Job_title.MANAGER;
                break;
            case 6:
                job_title = Job_title.CEO;
                break;
            case 7:
                job_title = Job_title.DIRECTOR;
                break;
            case 8:
                job_title = Job_title.SOFTWARE_ENGINNER;
                break;
            case 9:
                job_title = Job_title.SOFTWARE_DEVELOPER;
                break;
            case 10:
                job_title = Job_title.JUNIOR_SOFTWARE_DEVELOPER;
                break;
            case 11:
                job_title = Job_title.JUNIOR_SOFTWARE_ENGINNER;
                break;
            case 12:
                job_title = Job_title.CODER;
                break;
            case 13:
                job_title = Job_title.PROGRAMMER_ANALYST;
                break;
            // IF CHOSEN OPTION IS NOT APPROPIATE THAN SET EXCEPTION MESSAGE
            default:
                exceptionMsg = "Wrong option selected!\n";
                break;
        }

        return job_title;
    }
    
    // CHOOSE SETDEPARTMENT() METHOND WITH SET PARAMETER TO ASSIGN CHOSEN OPTION
    public Department setDepartment(int set)
    {
        // SELECTING JOB DEPARTMENT THROUGH THE VALUE FROM THE USER (PARAMETER SET)
        switch(set)
        {
            case 1:
                job_Dep = Department.PRODUCTION;
                break;
            case 2:
                job_Dep = Department.MARKETING;
                break;
            case 3:
                job_Dep = Department.FINANCE;
                break;
            case 4:
                job_Dep = Department.HUMAN_RESOURCE;
                break;
            case 5:
                job_Dep = Department.IT_SERVICES;
                break;
            // IF CHOSEN OPTION IS NOT APPROPIATE THAN SET EXCEPTION MESSAGE
            default:
                exceptionMsg = "Wrong option selected!\n";
                break;
        }

        return job_Dep;
    }

    // METHOD TO PRINT EMPLOYEES DETAILS    
    public void printEmployee()
    {
        System.out.println(GREEN + "Employee ID: " + employee_ID + RESET);
        System.out.println(GREEN + "Employee Title: " + employee_title + RESET);
        System.out.println(GREEN + "Employee First Name: " + f_Name + RESET);
        System.out.println(GREEN + "Employee Last Name: " + l_Name + RESET);
        System.out.println(GREEN + "Employee National Insurance: " + NI + RESET);
        System.out.println(GREEN + "Employee date of birth: " + DoB + RESET);
        System.out.println(GREEN + "Employee Department: " + job_Dep + RESET);
        System.out.println(GREEN + "Employee working as: " + type + RESET);
        System.out.println(GREEN + "Employee job Title: " + job_title + RESET);
        System.out.println(GREEN + "Employee Annual Salary: £" + annual_sal + RESET);
        
    }
    
    // PRINTING PAYSLIP OF SALARIED TYPE EMPLOYEE
    public void generatePayslip()
    {
        double taxamount, netSalary, grossInMonth;
        
        // DISPLAY DETAILS
        System.out.println("\n" + GREEN + "Employee ID: "+employee_ID + RESET);
        System.out.println(GREEN + "Employee Title: "+employee_title + RESET);
        System.out.println(GREEN + "Employee First Name: "+f_Name + RESET);
        System.out.println(GREEN + "Employee Last Name: "+l_Name + RESET);
        System.out.println(GREEN + "Employee National Insurance: "+NI + RESET);
        System.out.println(GREEN + "Employee date of birth: "+DoB + RESET);
        System.out.println(GREEN + "Employee Department: "+job_Dep + RESET);
        System.out.println(GREEN + "Employee working as: " + type + RESET + RESET);
        System.out.println(GREEN + "Employee job Title: "+job_title + RESET + "\n");
        
        // CALCULATE TAX
        if(annual_sal < 12500)
        {
            taxamount = 0;
            grossInMonth = (annual_sal/12);
            netSalary = grossInMonth - taxamount;
            
        }else if(annual_sal < 50000)
        {
            taxamount = (((annual_sal - 12500)/12) *20) / 100;
            grossInMonth = (annual_sal/12);
            netSalary = grossInMonth - taxamount;
            
        }else if (annual_sal < 150000)
        {
            taxamount = (((37500/12) *20) / 100) + ((((annual_sal - 50000)/12) * 40) / 100);
            grossInMonth = (annual_sal/12);
            netSalary = grossInMonth - taxamount;
            
        }else
        {
            taxamount = (((37500/12) *20) / 100) + ((((annual_sal - 150000)/12)* 45) / 100) + (((100000/12) * 40) / 100);
            grossInMonth = (annual_sal/12);
            netSalary = grossInMonth - taxamount;
            
        }
        
        // ROUNDING DOWN TAX AMOUNT IF MORE THAN 2 DECIMAL PLACES
        int increase = (int)(taxamount*100);
        taxamount = (double) increase/100;
        
        // ROUNDING DOWN NET SALARY IF MORE THAN 2 DECIMAL PLACES
        increase = (int)(netSalary*100);
        netSalary = (double) increase/100;
        
        // ROUNDING DOWN GROSS MONTHLY SALARY IF MORE THAN 2 DECIMAL PLACES
        increase = (int)(grossInMonth*100);
        grossInMonth = (double) increase/100;
        
        // DISPLAY PAYMENTS & DEDUCTIONS
        System.out.println(GREEN + "Employee gross Salary in last month: £"+grossInMonth + RESET);
        System.out.println(GREEN + "Tax deduction in last month: £"+taxamount + RESET);
        System.out.println(GREEN + "Employee net Salary in last month: £"+netSalary + RESET + "\n");
    }
}
