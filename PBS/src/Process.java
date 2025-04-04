import java.util.ResourceBundle;
import java.util.Scanner;

public class Process {
    EmployeeProcess employeeProcess = new EmployeeProcess();
    public void addEmployee(String language,ResourceBundle resourceBundle,Scanner scanner) {
        System.out.println(resourceBundle.getString("eklenecekPersonelin"));
        System.out.print(resourceBundle.getString("isim"));
        String name = scanner.nextLine();
        System.out.print(resourceBundle.getString("sifre"));
        String sifre = scanner.nextLine();
        System.out.print(resourceBundle.getString("departman"));
        String department = scanner.nextLine();
        System.out.print(resourceBundle.getString("deneyim"));
        String experience = scanner.nextLine();
        System.out.print(resourceBundle.getString("email"));
        String email = scanner.nextLine();
        System.out.print(resourceBundle.getString("goreveBaslamaTarihi"));
        String startToWork = scanner.nextLine();

        employeeProcess.addEmployee(language,name,sifre, department, experience,email,startToWork);
    }
}