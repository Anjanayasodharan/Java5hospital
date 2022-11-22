import java.sql.*;
import java.util.Scanner;
public class Hospital {
    public static void main(String[] args) {
        Scanner hos = new Scanner(System.in);
        int choice;
        while(true){
            System.out.println("Enter the options below");
            System.out.println("1 .Insert");
            System.out.println("2 .View");
            System.out.println("3 .Search");
            System.out.println("4 .Update");
            System.out.println("5 .Delete");
            System.out.println("6 .Count of doctors");
            System.out.println("7 .Name of doctor affcted by fever");

            System.out.println("8 .Exit");

            choice = hos.nextInt();

            switch (choice){
                case 1:
                    System.out.println("Insert the data ");
                    System.out.println("Enter the patient Id");
                    int patientid = hos.nextInt();
                    System.out.println("Enter the patient name");
                    String name = hos.next();
                    System.out.println("Address");
                    String address = hos.next();
                    System.out.println("pincode");
                    int pincode = hos.nextInt();
                    System.out.println("Phone Number");
                    String phno = hos.next();
                    System.out.println("Symptoms");
                    String symptoms = hos.next();
                    System.out.println("Doctor name");
                    String docname = hos.next();

                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitaldb","root","");
                        String sql = "INSERT INTO `patients`(`patientid`, `name`, `address`, `pincode`, `phno`, `symptoms`, `docname`) VALUES (?,?,?,?,?,?,?)";
                        PreparedStatement stmt = con.prepareStatement(sql);
                        stmt.setInt(1,patientid);
                        stmt.setString(2,name);
                        stmt.setString(3,address);
                        stmt.setInt(4,pincode);
                        stmt.setString(5,phno);
                        stmt.setString(6,symptoms);
                        stmt.setString(7,docname);
                        stmt.executeUpdate();
                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 2:
                    System.out.println("View the data ");
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitaldb", "root", "");
                        String sql = "SELECT `patientid`, `name`, `address`, `pincode`, `phno`, `symptoms`, `docname` FROM `patients` ";
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery(sql);
                        while (rs.next()) {
                            String getId = rs.getString("patientid");
                            String getName = rs.getString("name");
                            String getAddr = rs.getString("address");
                            String getPin = rs.getString("pincode");
                            String getPhone = rs.getString("phno");
                            String getSymp = rs.getString("symptoms");
                            String getDoc = rs.getString("docname");
                            System.out.println("Patient id=" + getId);
                            System.out.println("Patient name=" + getName);
                            System.out.println("Patient Address=" + getAddr);
                            System.out.println("Patient pincode=" + getPin);
                            System.out.println("Patient phone=" + getPhone);
                            System.out.println("Patient Symptoms=" + getSymp);
                            System.out.println("Patient docname=" + getDoc + '\n');
                        }
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;

                case 3:
                    System.out.println("Search the data ");
                    patientid = hos.nextInt();
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitaldb", "root", "");
                        String sql = "SELECT `patientid`, `name`, `address`, `pincode`, `phno`, `symptoms`, `docname` FROM `patients` WHERE `patientid`=" + String.valueOf(patientid);
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery(sql);
                        while (rs.next()) {
                            String getId = rs.getString("patientid");
                            String getName = rs.getString("name");
                            String getAddr = rs.getString("address");
                            String getPin = rs.getString("pincode");
                            String getPhone = rs.getString("phno");
                            String getSymp = rs.getString("symptoms");
                            String getDoc = rs.getString("docname");
                            System.out.println("Patient id=" + getId);
                            System.out.println("Patient name=" + getName);
                            System.out.println("Patient Address=" + getAddr);
                            System.out.println("Patient pincode=" + getPin);
                            System.out.println("Patient phone=" + getPhone);
                            System.out.println("Patient Symptoms=" + getSymp);
                            System.out.println("Patient docname=" + getDoc + '\n');
                        }
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;

                case 4:
                    System.out.println("Enter the patient Id");
                    patientid = hos.nextInt();
                    System.out.println("Enter the patient name");
                    name = hos.next();
                    System.out.println("Address");
                    address = hos.next();
                    System.out.println("pincode");
                    pincode = hos.nextInt();
                    System.out.println("Phone Number");
                    phno = hos.next();
                    System.out.println("Symptoms");
                    symptoms = hos.next();
                    System.out.println("Doctor name");
                    docname = hos.next();

                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitaldb", "root", "");
                        String sql = "UPDATE `patients` SET `patientid`='" + patientid + "',`name`='" + name + "',`address`='" + address + "',`pincode`='" + pincode + "',`phno`='" + phno + "',`symptoms`='" + symptoms + "',`docname`='" + docname + "' WHERE `patientid`=" +patientid;
                        Statement stmt = con.createStatement();
                        stmt.executeUpdate(sql);
                        System.out.println("Updated successfully");
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;

                case 5:
                    System.out.println("Delete the data");
                    System.out.println("Enter the patient Id");
                    patientid = hos.nextInt();
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitaldb", "root", "");
                        String sql = "DELETE FROM `patients` WHERE `patientid`=" + patientid;
                        Statement stmt = con.createStatement();
                        stmt.executeUpdate(sql);
                        System.out.println("Deleted successfully");
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;

                case 6:
                    System.out.println("Number of doctors");
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitaldb", "root", "");
                        String sql = "SELECT COUNT(*) AS number,`docname` FROM `patients` GROUP BY `docname`";
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery(sql);
                        while (rs.next()) {
                            String getCount = rs.getString("number");
                            String getDoc = rs.getString("docname");
                            System.out.println("Number of patients consult to this doctor is +" + getCount);
                            System.out.println("Name of doctor =" + getDoc + '\n');
                        }
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;
                case 7:

                    System.out.println("Name of doctor who consult fever");
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitaldb", "root", "");
                        String sql = "SELECT COUNT(*) AS number,`docname` FROM `patients` WHERE `symptoms`='fever' GROUP BY `docname`";
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery(sql);
                        while (rs.next()) {
                            String getCount = rs.getString("number");
                            String getDoc = rs.getString("docname");
                            System.out.println("Number of patients consult to this doctor for fever +" + getCount);
                            System.out.println("Name of doctor =" + getDoc + '\n');
                        }
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;

                case 8:
                    System.exit(0);
            }
        }
    }
}
