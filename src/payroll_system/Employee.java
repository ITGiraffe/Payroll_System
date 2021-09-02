// ELEMENT OF THE PAYROLL_SYSTEM PROGRAM
package payroll_system;

// ABSTRACT CLASS EMPLOYEE, PARENT OF SALARIED, HOURLY & COMMISSION CLASS
public abstract class Employee 
{
    // VARIABLES TO SET DETAILS OF THE EMPLOYEES (PROTECTED ACCESS, AVAIBLE ONLY FOR CHILD CLASSES)
    
    // EMPLOYEE ID NUMBER (UNIQUE)
    protected int employee_ID;
    // EMPLOYEE TITLE, FIRST NAME (f_Name), LAST NAME (l_Name), NATIONAL INSURANCE NUMBER (NI), DATE OF BIRTH (DoB) 
    protected String employee_title,f_Name,l_Name,NI,DoB;
    // SPECIFIC JOB TITLE (ONE OF 13, SPECIFIED IN Job_title ENUM CLASS)
    protected Job_title job_title;
    // SPECIFIC JOB DEPARTMENT (ONE OF 5, SPECIFIED IN Department ENUM CLASS)
    protected Department job_Dep;
    
    // CONSTRUCTOR
    public Employee()
    {

    }
    
    // GETTERS AND SETTERS METHODS FOR ALL EMPLOYEE DETAILS:
    
    // METHOD TO RETRIEVE EMPLOYEE ID NUMBER OF EMPLOYEE QS INTEGER
    public int getID()
    {
        return employee_ID;
    }
    
    // METHOD TO RETRIEVE EMPLOYEE TITLE OF EMPLOYEE AS STRING
    public String getTitle()
    {
        return employee_title;
    }
    
    // METHOD TO RETRIEVE FIRST NAME OF EMPLOYEE AS STRING
    public String getF_Name()
    {
        return f_Name;
    }
    
    // METHOD TO RETRIEVE LAST NAME OF EMPLOYEE AS STRING
    public String getL_Name()
    {
        return l_Name;
    }
    
    // METHOD TO RETRIEVE NATIONAL INSURANCE NUMBER OF EMPLOYEE AS STRING
    public String getNI()
    {
        return NI;
    }
    
    // METHOD TO RETRIEVE DATE OF BIRTH OF EMPLOYEE AS STRING
    public String getDoB()
    {
        return DoB;
    }
        
    // METHOD TO RETRIEVE JOB TITLE OF EMPLOYEE AS ONE OF THE OPTION FROM ENUM Job_title CLASS
    public Job_title getJob_Title()
    {
        return job_title;
    }
        
    // METHOD TO RETRIEVE JOB DEPARTMENT OF EMPLOYEE AS ONE OF THE OPTION FROM ENUM Department CLASS
    public Department getJob_Dep()
    {
        return job_Dep;
    }
    
    // METHOD TO SET DETAILS OF EMPLOYEE WHEN MOST OF THE PARAMETERS ARE GIVEN IN PROPER FORMAT (SETTER)
    public void setEmployee(int employee_ID,String employee_title,String f_Name,String l_Name,String NI,String DoB,Job_title job_title,Department job_Dep)
    {
        this.employee_ID = employee_ID;
        this.employee_title = employee_title;
        this.f_Name = f_Name;
        this.l_Name = l_Name;
        this.NI = NI;
        this.DoB = DoB;
        this.job_title = job_title;
        this.job_Dep = job_Dep;
        
    }
    
    // FORCING CHILDS TO MAKE A SPECIFIC METHODS: printEployee() & generatePayslip()
    public abstract void printEmployee();
    public abstract void generatePayslip();
    
}
