import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner objScan = new Scanner(System.in);
        
        System.out.println("===Library System===");
        System.out.println("1.) Login as Student");
        System.out.println("2.) Login as Admin");
        System.out.println("3.) Exit");

        System.out.println("Choose your option (1-3)");
        int menu = objScan.nextInt();

        switch(menu) {
            case 1:
            System.out.println("Enter NIM:");
            String nim = objScan.next();
            int length = nim.length();
            if (length == 15) {
                System.out.println("Login successful as student.");
            } else {
                System.out.println("Invalid NIM. Please enter a valid NIM with exactly 15 digits.");
            }
            break;
        case 2:
            objScan.nextLine();
            System.out.println("Enter your username (admin):");
            String adminUser = objScan.nextLine();
            System.out.println("Enter your password (admin)");
            String adminPw = objScan.nextLine();

            if ("admin".equals(adminUser))
            {
                if ("admin".equals(adminPw))
                {
                    System.out.println("Successfully logged in as Admin."); 
                }
            } else
            {
                System.out.println("Admin user not found.");
            }
            break;
        default:
            System.out.println("Input invalid. Please put a valid input.");
            break;
        }

        objScan.close();
    }

    public static int length(String input) {
        return input.length();
    }
}