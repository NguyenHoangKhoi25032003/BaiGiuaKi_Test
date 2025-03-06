package fit.iuh;
// Interface trạng thái tính lương
interface SalaryState {
    double calculateSalary(double baseSalary);
}

// Trạng thái cho từng chức vụ
class ManagerSalary implements SalaryState { // Trưởng phòng (TP)
    public double calculateSalary(double baseSalary) {
        return baseSalary + 500; // Phụ cấp TP là 500
    }
}

class ViceManagerSalary implements SalaryState { // Phó trưởng phòng (PHT)
    public double calculateSalary(double baseSalary) {
        return baseSalary + 400; // Phụ cấp PHT là 400
    }
}

class TeamLeaderSalary implements SalaryState { // Trưởng nhóm (TT)
    public double calculateSalary(double baseSalary) {
        return baseSalary + 300; // Phụ cấp TT là 300
    }
}

class EmployeeSalary implements SalaryState { // Nhân viên bình thường
    public double calculateSalary(double baseSalary) {
        return baseSalary; // Không có phụ cấp
    }
}

// Context chứa thông tin nhân viên
class Employee {
    private String name;
    private double baseSalary;
    private SalaryState salaryState;

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
        this.salaryState = new EmployeeSalary(); // Mặc định là nhân viên bình thường
    }

    public void setSalaryState(SalaryState salaryState) {
        this.salaryState = salaryState;
    }

    public void printSalary() {
        System.out.println(name + " có lương: " + salaryState.calculateSalary(baseSalary));
    }
}

// Chạy chương trình
public class Main {
    public static void main(String[] args) {
        Employee nv1 = new Employee("Nguyen Van A", 5000);
        nv1.printSalary();

        nv1.setSalaryState(new ManagerSalary()); // Chuyển sang Trưởng phòng (TP)
        nv1.printSalary();

        Employee nv2 = new Employee("Tran Thi B", 5000);
        nv2.setSalaryState(new ViceManagerSalary()); // Chuyển sang Phó trưởng phòng (PHT)
        nv2.printSalary();
    }
}

