package fit.iuh;

// Interface cho chiến lược tính lương
interface SalaryStrategy {
    double calculateSalary(double baseSalary);
}

// Các chiến lược tính lương theo chức vụ
class ManagerStrategy implements SalaryStrategy { // Trưởng phòng (TP)
    public double calculateSalary(double baseSalary) {
        return baseSalary + 500; // Phụ cấp TP
    }
}

class ViceManagerStrategy implements SalaryStrategy { // Phó trưởng phòng (PHT)
    public double calculateSalary(double baseSalary) {
        return baseSalary + 400; // Phụ cấp PHT
    }
}

class TeamLeaderStrategy implements SalaryStrategy { // Trưởng nhóm (TT)
    public double calculateSalary(double baseSalary) {
        return baseSalary + 300; // Phụ cấp TT
    }
}

class EmployeeStrategy implements SalaryStrategy { // Nhân viên bình thường
    public double calculateSalary(double baseSalary) {
        return baseSalary; // Không có phụ cấp
    }
}

// Context chứa chiến lược tính lương
class Employee {
    private String name;
    private double baseSalary;
    private SalaryStrategy salaryStrategy;

    public Employee(String name, double baseSalary, SalaryStrategy salaryStrategy) {
        this.name = name;
        this.baseSalary = baseSalary;
        this.salaryStrategy = salaryStrategy;
    }

    public void setSalaryStrategy(SalaryStrategy salaryStrategy) {
        this.salaryStrategy = salaryStrategy;
    }

    public void printSalary() {
        System.out.println(name + " có lương: " + salaryStrategy.calculateSalary(baseSalary));
    }
}

// Chạy chương trình
public class Main {
    public static void main(String[] args) {
        Employee nv1 = new Employee("Nguyen Van A", 5000, new EmployeeStrategy());
        nv1.printSalary();

        nv1.setSalaryStrategy(new ManagerStrategy()); // Chuyển sang Trưởng phòng (TP)
        nv1.printSalary();

        Employee nv2 = new Employee("Tran Thi B", 5000, new ViceManagerStrategy()); // Phó trưởng phòng (PHT)
        nv2.printSalary();
    }
}
