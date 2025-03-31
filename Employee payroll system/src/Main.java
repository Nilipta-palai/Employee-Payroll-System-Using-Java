import java.util.ArrayList;

abstract  class Employee{
    private String name;
    private int id;

    public Employee(String name,int id){
        this.name=name;
        this.id=id;
    }
    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }

    //abstract method
    public abstract  double calculateSalary();

    @Override 
    public String toString(){
      return "Employee [name="+name+",id="+id+",salary="+calculateSalary()+"]";
    }

}

class FullTimeEmployee extends Employee{
    private double MonthlySalary;

    public FullTimeEmployee(String name,int id,double MonthlySalary){
        super(name,id);
        this.MonthlySalary=MonthlySalary;
    }

    @Override

    public double calculateSalary(){
        return MonthlySalary;
    }
}

class PartTimeEmployee extends Employee{
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String name,int id,int hoursWorked,double hourlyRate){
        super(name,id);
        this.hoursWorked=hoursWorked;
        this.hourlyRate=hourlyRate;
    }

    @Override

    public  double calculateSalary(){
        return hoursWorked*hourlyRate;
    }
}

class PayrollSystem{
    private ArrayList<Employee> employeelist;

    public PayrollSystem(){
        employeelist=new ArrayList<>();
    }

    public void addEmployee(Employee employee){
        employeelist.add(employee);
    }

    public void removeEmployee(int id){
        Employee employeeToRemove=null;

        for(Employee employee :employeelist){
             if(employee.getId()==id){
                employeeToRemove=employee;
                break;
             }
        }
        if(employeeToRemove!=null){
            employeelist.remove(employeeToRemove);
        }
    }
    public void displayEmployees(){
        for(Employee employee: employeelist){
            System.out.println(employee);
        }
    }
}

public class Main{
    public static void main(String[] args) {
        PayrollSystem payrollSystem = new PayrollSystem();
        FullTimeEmployee emp1 = new FullTimeEmployee("nilu",1,70000);
        PartTimeEmployee emp2 = new PartTimeEmployee("jas",2,30,100);
        payrollSystem.addEmployee(emp1);
        payrollSystem.addEmployee(emp2);
        System.out.println("Initial employee Details : ");
        payrollSystem.displayEmployees();
        System.out.println("Remove Employees : ");
        payrollSystem.removeEmployee(2);
        System.out.println("Remaining Employess");
        payrollSystem.displayEmployees();
    }
}