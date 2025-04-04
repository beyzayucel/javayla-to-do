import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Task implements IAllTaskProcess {
    Connection con = DatabaseConnection.dbConnection();
    getResourceBundle getResourceBundlee=new getResourceBundle();

    public void addTask(String language, int employeeId, String taskName, String completionStatus, String importanceTask) {
        ResourceBundle resourceBundle = getResourceBundlee.getResourceBundle(language);
        String sql = "insert into taskInfo(employeeInfo_Id, taskName, completionStatus, importanceTask) values(?,?,?,?)";
        try {
            PreparedStatement prepared = con.prepareStatement(sql);
            prepared.setInt(1, employeeId);
            prepared.setString(2, taskName);
            prepared.setString(3, completionStatus);
            prepared.setString(4, importanceTask);
            int a = prepared.executeUpdate();
            if (a > 0) {
                System.out.println(resourceBundle.getString("gorevBasariylaEklendi"));
            } else {
                System.out.println(resourceBundle.getString("gorevEklenemedi"));
            }
        } catch (SQLException e) {
            System.out.println("Hata");
        }
    }

    public void deleteTask(String language, int taskId, int employeeId) {
        ResourceBundle resourceBundle = getResourceBundlee.getResourceBundle(language);
        String sql = "delete from taskInfo where taskId = ? and employeeInfo_Id = ?";
        try {
            PreparedStatement prepared = con.prepareStatement(sql);
            prepared.setInt(1, taskId);
            prepared.setInt(2, employeeId);
            int a = prepared.executeUpdate();
            if (a > 0) {
                System.out.println(resourceBundle.getString("gorevBasariylaSilindi"));
            } else {
                System.out.println(resourceBundle.getString("gorevSilinemedi"));
            }
        } catch (SQLException e) {
            System.out.println("Hata");
        }
    }

    public void taskToList(String language, int employeeId) {
        ResourceBundle resourceBundle = getResourceBundlee.getResourceBundle(language);
        String sql = "select t.taskId, t.taskName, t.completionStatus, t.importanceTask, e.name, e.department from taskInfo t inner join employeeInfo e on t.employeeInfo_Id = e.Id where t.employeeInfo_Id = ?";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, employeeId);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("------------------------");
            System.out.println(resourceBundle.getString("gorevAdii"));
            System.out.println("------------------------");
            while (resultSet.next()) {
                int taskId = resultSet.getInt("taskId");
                String taskName = resultSet.getString("taskName");
                String completionStatus = resultSet.getString("completionStatus");
                String importanceTask = resultSet.getString("importanceTask");
                String name = resultSet.getString("name");
                String department = resultSet.getString("department");
                System.out.printf("%d\t\t%s\t\t%s\t\t%s\t\t%s\t\t%s\t%n", taskId, taskName, completionStatus, importanceTask, name, department);
            }
        } catch (SQLException e) {
            System.out.println("hata");
        }
    }


    public void updateTask(String language, int taskId, String newName, String newCompletedStatus, String newImportTask, int employeeId) {
        ResourceBundle resourceBundle = getResourceBundlee.getResourceBundle(language);
        String sqlKod = "update taskInfo set taskName=?, completionStatus=?, importanceTask=? where taskId=? and employeeInfo_Id=?";
        try {
            PreparedStatement prepared = con.prepareStatement(sqlKod);
            prepared.setString(1, newName);
            prepared.setString(2, newCompletedStatus);
            prepared.setString(3, newImportTask);
            prepared.setInt(4, taskId);
            prepared.setInt(5, employeeId);
            int a = prepared.executeUpdate();
            if (a > 0) {
                System.out.println(resourceBundle.getString("gorevBasariyaGuncellendi"));
            } else {
                System.out.println(resourceBundle.getString("gorevGuncellenemedi"));
            }
        } catch (SQLException e) {
            System.out.println("Hata");
        }
    }

}

