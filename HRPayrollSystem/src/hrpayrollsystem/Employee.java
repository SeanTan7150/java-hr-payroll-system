package hrpayrollsystem;

public class Employee {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String icNumber;
    private String email;
    private double allowance;
    private double netSalary;
    private double grossSalary;
    private double basicSalary;
    private double incomeTax;
    
    public Employee(String username, String password, String firstName, String lastName, String icNumber, String email) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.icNumber = icNumber;
        this.email = email;
        allowance = -1;
        netSalary = -1;
        grossSalary = -1;
        basicSalary = -1;
        incomeTax = -1;
    }

    public Employee(String username, String password, String firstName, String lastName, String icNumber, String email, double allowance, double netSalary, double grossSalary, double basicSalary, double incomeTax) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.icNumber = icNumber;
        this.email = email;
        this.allowance = allowance;
        this.netSalary = netSalary;
        this.grossSalary = grossSalary;
        this.basicSalary = basicSalary;
        this.incomeTax = incomeTax;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
}
