import java.sql.*;
import java.util.ResourceBundle;

public class EmployeeProcess implements IAllEmployeeProcess {

    Connection con = DatabaseConnection.dbConnection();
    getResourceBundle getResourceBundlee=new getResourceBundle();

    public void addEmployee(String language,String name,String sifre, String department, String experience,String email, String startToWork) {
        ResourceBundle resourceBundle = getResourceBundlee.getResourceBundle(language);

        String hashedSifre = PasswordHasher.hashPassword(sifre);
        String sql = "insert into employeeInfo(name,sifre, department, experience,email,startToWork ) values(?,?,?,?,?,?)";

        try {
            PreparedStatement prepared = con.prepareStatement(sql);
            prepared.setString(1, name);
            prepared.setString(2, hashedSifre);
            prepared.setString(3, department);
            prepared.setString(4, experience);
            prepared.setString(5, email);
            prepared.setString(6, startToWork);
            int a = prepared.executeUpdate();
            if (a > 0) {
                System.out.println(resourceBundle.getString("kullaniciBasariylaEklendi"));
            } else {
                System.out.println(resourceBundle.getString("kullaniciEklenemedi"));
            }

        } catch (SQLException e) {
            System.out.println("Hata");
        }

    }

    public String isValidPassword(String email) {

        String sql = "select sifre from employeeInfo where email=?";
        try {
            PreparedStatement prepared = con.prepareStatement(sql);
            prepared.setString(1, email);
            ResultSet resultSet = prepared.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString("sifre");
            }
            else{
                System.out.println();
            }
        } catch (SQLException e) {
            System.out.println("Hata"+e.getMessage());
            e.printStackTrace();

        }

        return null;
    }
    public String isValidEmail(String language,String password) {
        ResourceBundle resourceBundle = getResourceBundlee.getResourceBundle(language);

        String sql = "select email from employeeInfo where sifre=?";
        try {
            PreparedStatement prepared = con.prepareStatement(sql);
            prepared.setString(1, password);
            ResultSet resultSet = prepared.executeQuery();

            if (resultSet.next()) {
                return resultSet.getString("email");
            }
            else{
                System.out.println(resourceBundle.getString("epostaBulunmadi"));
            }
        } catch (SQLException e) {
            System.out.println("Hata");
        }
        return null;
    }



        public int employeeIdEmail(String email) {
            int employeeId = 0;
            String sql = "select Id from employeeInfo where email = ?";
            try {
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, email);
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    employeeId = rs.getInt("Id");
                }
            } catch (SQLException e) {
                System.out.println("Hata");
            }
            return employeeId;
        }





}