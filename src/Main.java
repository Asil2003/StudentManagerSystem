import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        boolean exit = false;

        while (!exit) {
            System.out.println("\n----- Student Manager Menu -----");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student Grade");
            System.out.println("4. Delete Student");
            System.out.println("5. Search Student by ID");
            System.out.println("6. Search Student by Name");
            System.out.println("7. Calculate Average Grade");
            System.out.println("8. Show Highest Grade");
            System.out.println("9. Show Lowest Grade");
            System.out.println("10. Count Total Students");
            System.out.println("11. Sort Students by Grade");
            System.out.println("12. Sort Students by Name");
            System.out.println("13. Clear All Students");
            System.out.println("14. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 14:
                    exit = true;
                    System.out.println("Exiting the system.");
                    break;
                default:
                    System.out.println("Option not implemented yet.");
            }
        }

        scanner.close();
    }
}
