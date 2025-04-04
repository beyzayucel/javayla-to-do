import java.util.ResourceBundle;
import java.util.Scanner;


public class TaskProcess {
    Scanner scanner = new Scanner(System.in);
    Task task = new Task();
    getResourceBundle getResourceBundlee = new getResourceBundle();


    public void addTask(String language, int employeeId) {
        ResourceBundle resourceBundle = getResourceBundlee.getResourceBundle(language);
        System.out.print(resourceBundle.getString("gorevAdi"));
        String nameTask = scanner.nextLine();
        System.out.print(resourceBundle.getString("tamamlanmaDurumu"));
        String completionStatus = scanner.nextLine();
        System.out.print(resourceBundle.getString("onemi"));
        String importanceTask = scanner.nextLine();

        task.addTask(language, employeeId, nameTask, completionStatus, importanceTask);
    }

    public void deleteTask(String language, int employeeId) {
        ResourceBundle resourceBundle = getResourceBundlee.getResourceBundle(language);
        System.out.println(resourceBundle.getString("silinecekGorevin"));
        System.out.print(resourceBundle.getString("id"));
        int taskId = scanner.nextInt();
        scanner.nextLine();

        task.deleteTask(language, taskId, employeeId);
    }

    public void updateTask(String language, int employeeId) {
        ResourceBundle resourceBundle = getResourceBundlee.getResourceBundle(language);
        System.out.println(resourceBundle.getString("guncellenecekGorevin"));
        System.out.print(resourceBundle.getString("id"));
        int taskId = scanner.nextInt();
        scanner.nextLine();
        System.out.print(resourceBundle.getString("yeniAdi"));
        String nameTask = scanner.nextLine();
        System.out.print(resourceBundle.getString("yeniTamamlanmaDurumu"));
        String completionStatus = scanner.nextLine();
        System.out.print(resourceBundle.getString("yeniGorevinOnemi"));
        String importentTask = scanner.nextLine();

        task.updateTask(language, taskId, nameTask, completionStatus, importentTask, employeeId);
    }

    public void taskToList(String language, int employeeId) {
        task.taskToList(language, employeeId);
    }
}

