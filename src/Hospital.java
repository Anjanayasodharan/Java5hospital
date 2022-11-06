import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
            System.out.println("6 .Exit");

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
                    break;
                case 3:
                    System.out.println("Search the data ");
                    break;
                case 4:
                    System.out.println("Update the data ");
                    break;
                case 5:
                    System.out.println("Delete the data");
                    break;
                case 6:
                    System.exit(0);
            }
        }
    }
}
