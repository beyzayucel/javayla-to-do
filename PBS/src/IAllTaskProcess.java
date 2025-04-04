public interface IAllTaskProcess {

    void addTask(String language, int employeeId, String taskName, String completionStatus, String importanceTask);
    void deleteTask(String language, int taskId, int employeeId);
    void taskToList(String language,int employeeId);
    void updateTask(String language, int taskId, String newName, String newCompletedStatus, String newImportTask, int employeeId);
    //void oneEmployeeList(String language,String name);

    }
