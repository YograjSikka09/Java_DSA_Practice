package BasicQuestions;

class Employee {
    int id;
    String name;
    double basicSalary;

    Employee(int i, String n, double s) {
        id = i;
        name = n;
        basicSalary = s;
    }

    double calculateHRA() {
        return basicSalary * 0.20;
    }

    double calculateDA() {
        return basicSalary * 0.10;
    }

    double calculateGrossSalary() {
        return basicSalary + calculateHRA() + calculateDA();
    }
}

public class StudentPerson {
    public static void main(String[] args) {

        Employee e = new Employee(4908, "Yogeraj", 20000);

        System.out.println("HRA = " + e.calculateHRA());
        System.out.println("DA = " + e.calculateDA());
        System.out.println("Gross Salary = " + e.calculateGrossSalary());
    }
}
