package hrpayrollsystem;

import java.io.Serializable;
import java.util.ArrayList;

public class Employee implements Serializable {
    private static final long serialVersionUID = 20120731125400L;
    
    private final String username;
    private String password;
    private String firstName;
    private String lastName;
    private String icNumber;
    private String employeeId;
    private String jobPosition;
    private String email;
    private int age;
    private double allowance;
    private double netSalary;
    private double grossSalary;
    private double basicSalary;
    private double incomeTax;
    private ArrayList<Deduction> deductionList;
    
    public Employee(String username, String password, String firstName, String lastName, String icNumber, String employeeId, String email, int age) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.icNumber = icNumber;
        this.employeeId = employeeId;
        this.email = email;
        this.age = age;
        allowance = -1;
        netSalary = -1;
        grossSalary = -1;
        basicSalary = -1;
        incomeTax = -1;
        deductionList = new ArrayList<>();
    }

    public Employee(String username, String password, String firstName, String lastName, String icNumber, String employeeId,
            String jobPosition, String email, int age, double allowance, double netSalary, double grossSalary, double basicSalary, double incomeTax, ArrayList<Deduction> deductionList) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.icNumber = icNumber;
        this.employeeId = employeeId;
        this.jobPosition = jobPosition;
        this.email = email;
        this.age = age;
        this.allowance = allowance;
        this.netSalary = netSalary;
        this.grossSalary = grossSalary;
        this.basicSalary = basicSalary;
        this.incomeTax = incomeTax;
        this.deductionList = deductionList;
    }
    
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIcNumber() {
        return icNumber;
    }

    public void setIcNumber(String icNumber) {
        this.icNumber = icNumber;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }

    public double getAllowance() {
        return allowance;
    }

    public void setAllowance(double allowance) {
        this.allowance = allowance;
    }

    public double getNetSalary() {
        return netSalary;
    }

    public void setNetSalary(double netSalary) {
        this.netSalary = netSalary;
    }

    public double getGrossSalary() {
        return grossSalary;
    }

    public void setGrossSalary(double grossSalary) {
        this.grossSalary = grossSalary;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public double getIncomeTax() {
        return incomeTax;
    }

    public void setIncomeTax(double incomeTax) {
        this.incomeTax = incomeTax;
    }
  
    public void setDeductionList(ArrayList<Deduction> deductionList) {
        this.deductionList = deductionList;
    }
    
    public double getDeduction(int month) {
        for(Deduction deduction : deductionList) {
            if (deduction.getMonth() == month) {
                return deduction.getDeductionValue();
            }
        }
        return 0;
    }
}