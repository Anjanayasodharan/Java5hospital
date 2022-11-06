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
