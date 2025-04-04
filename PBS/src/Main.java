import java.util.ResourceBundle;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("tr/en/de");
        System.out.print("Dil seçiniz/Choose language/Sprache auswählen: ");
        Scanner scanner = new Scanner(System.in);
        String language = scanner.nextLine();
        getResourceBundle getResourceBundlee = new getResourceBundle();
        ResourceBundle resourceBundle = getResourceBundlee.getResourceBundle(language);

        while (true) {
            firstScreen(resourceBundle);
            String processNumber = scanner.nextLine();
            Process process = new Process();
            if (processNumber.equals("1")) {
                process.addEmployee(language, resourceBundle, scanner);
                System.out.println(resourceBundle.getString("basariylaGiris1"));
            } else if (processNumber.equals("2")) {
                islemler(language, scanner, resourceBundle);
            } else if (processNumber.equals("q")) {
                break;
            } else {
                System.out.println(resourceBundle.getString("hataliKarakter"));
            }
        }
    }

    private static boolean isValidUser(String language, EmployeeProcess employeeProcess, String email, String password) {
        String validEmail = employeeProcess.isValidEmail(language, password);
        String validPassword = employeeProcess.isValidPassword(email);
        if (validEmail == null || validPassword == null) {
            return false;
        }
        return validEmail.equals(email) && validPassword.equals(password);
    }

    public static void islemler(String language, Scanner scanner, ResourceBundle resourceBundle) {
        int denemeHakki = 3;
        EmployeeProcess employeeProcess = new EmployeeProcess();
        while (denemeHakki > 0) {
            System.out.print(resourceBundle.getString("email"));
            String email = scanner.nextLine();
            System.out.print(resourceBundle.getString("sifre"));
            String password2 = scanner.nextLine();
            String hashedSifre2 = PasswordHasher.hashPassword(password2);

            if (isValidUser(language, employeeProcess, email, hashedSifre2)) {
                int employeeId = employeeProcess.employeeIdEmail(email);
                withTaskProcess(resourceBundle, scanner, language, employeeId);
            } else {
                denemeHakki--;
                System.out.println(resourceBundle.getString("kalanDenemeHakki") + denemeHakki);
                if (denemeHakki == 0) {
                    break;
                }
            }
        }
    }

    public static void firstScreen(ResourceBundle resourceBundle) {
        System.out.println(resourceBundle.getString("deneme"));
        System.out.println(resourceBundle.getString("islemler"));
        System.out.print(resourceBundle.getString("islemAlma"));
    }

    public static void withTaskProcess(ResourceBundle resourceBundle, Scanner scanner, String language, int employeeId) {
        System.out.println(resourceBundle.getString("basariylaGiris2"));
        boolean try1 = true;
        TaskProcess taskProcess = new TaskProcess();
        while (try1) {
            System.out.println("-----------------------------------------------------------------------------------------------");
            System.out.println(resourceBundle.getString("gorevNumaralama"));
            System.out.println("--------------------------------");
            System.out.print(resourceBundle.getString("islemNumarasi"));
            String processNum = scanner.nextLine();

            if (processNum.equals("1")) {
                taskProcess.taskToList(language, employeeId);
            } else if (processNum.equals("2")) {
                taskProcess.addTask(language, employeeId);
            } else if (processNum.equals("3")) {
                taskProcess.deleteTask(language, employeeId);
            } else if (processNum.equals("4")) {
                taskProcess.updateTask(language, employeeId);
            } else if (processNum.equals("q")) {
                try1 = false;
            } else {
                System.out.println(resourceBundle.getString("hataliIslem"));
            }
        }
    }
}










