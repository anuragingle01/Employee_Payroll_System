import java.util.*;

abstract class Employee
{
    private String name;
    private int id;

    public Employee(String name, int id){
        this.name = name;
        this.id = id;
    }
    public String getname(){
        return name;
    }
    public int getid(){
        return id;
    }

    public abstract double calculateSalary();

    @Override
    public String toString(){
        return "Employee [name= " + name +", id= "+ id +", salary= "+ calculateSalary() +"]";
    }
}
class FullTimeEmployee extends Employee
{
    private double monthlySalary;

    public FullTimeEmployee(String name, int id, double monthlySalary){
        super(name, id);
        this.monthlySalary = monthlySalary;
    }
    @Override
    public double calculateSalary(){
        return monthlySalary;
    }
}
class PartTimeEmployee extends Employee
{
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String name, int id, int hoursWorked, double hourlyRate)
    {
        super(name, id);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;

    }

    @Override
    public double calculateSalary(){
        return hoursWorked* hourlyRate;
    }
}

class PayRollSystem
{
    private ArrayList<Employee> employeeList;

    public PayRollSystem(){
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }
    public void removeEmployee(int id){
        Employee employeeToRemove = null;
        for(Employee employee : employeeList){
            if(employee.getid() == id){
                employeeToRemove = employee;
                break;
            }
        }
        if(employeeToRemove != null){
            employeeList.remove(employeeToRemove);
        }
    }

    public void displayEmployee(){
        for(Employee employee : employeeList){
            System.out.println(employee.toString());
        }
    }
}
public class Main{
    public static void main(String[] args) {
        PayRollSystem payrollSys = new PayRollSystem();
        FullTimeEmployee emp1 = new FullTimeEmployee("Anurag", 1, 45000.59);
        PartTimeEmployee emp2 = new PartTimeEmployee("Vaibhav", 2, 8*25, 200);
        payrollSys.addEmployee(emp1);
        payrollSys.addEmployee(emp2);
        System.out.println("Initail Employee Details!!!");
        payrollSys.displayEmployee();
        System.out.println("Remaining Employee Details!!!");
        payrollSys.removeEmployee(2);
        payrollSys.displayEmployee();

    }
}