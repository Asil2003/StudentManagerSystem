import java.util.ArrayList;
import java.util.Scanner;

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
            scanner.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter student ID: ");
                    int id = scanner.nextInt();

                    System.out.print("Enter student grade: ");
                    double grade = scanner.nextDouble();
                    scanner.nextLine(); // clear newline

                    Student newStudent = new Student(name, id, grade);
                    students.add(newStudent);

                    System.out.println("Student added successfully!");
                    break;

                case 2:
                    if (students.isEmpty()) {
                        System.out.println("No students to display.");
                    } else {
                        System.out.println("\n--- Student List ---");
                        for (Student student : students) {
                            student.displayInfo();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter student ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();

                    boolean found = false;
                    for (Student student : students) {
                        if (student.getId() == updateId) {
                            System.out.print("Enter new grade: ");
                            double newGrade = scanner.nextDouble();
                            scanner.nextLine();
                            student.setGrade(newGrade);
                            System.out.println("Grade updated successfully!");
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Student with ID " + updateId + " not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter student ID to delete: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine();

                    boolean deleted = false;
                    for (int i = 0; i < students.size(); i++) {
                        if (students.get(i).getId() == deleteId) {
                            students.remove(i);
                            System.out.println("Student deleted successfully!");
                            deleted = true;
                            break;
                        }
                    }

                    if (!deleted) {
                        System.out.println("Student with ID " + deleteId + " not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter student ID to search: ");
                    int searchId = scanner.nextInt();
                    scanner.nextLine();

                    boolean foundId = false;
                    for (Student student : students) {
                        if (student.getId() == searchId) {
                            System.out.println("Student found:");
                            student.displayInfo();
                            foundId = true;
                            break;
                        }
                    }

                    if (!foundId) {
                        System.out.println("Student with ID " + searchId + " not found.");
                    }
                    break;

                case 6:
                    System.out.print("Enter student name to search: ");
                    String searchName = scanner.nextLine().toLowerCase();

                    boolean foundName = false;
                    for (Student student : students) {
                        if (student.getName().toLowerCase().contains(searchName)) {
                            if (!foundName) {
                                System.out.println("Matching student(s):");
                            }
                            student.displayInfo();
                            foundName = true;
                        }
                    }

                    if (!foundName) {
                        System.out.println("No students found with name containing \"" + searchName + "\".");
                    }
                    break;

                case 7:
                    if (students.isEmpty()) {
                        System.out.println("No students available to calculate average.");
                    } else {
                        double total = 0;
                        for (Student student : students) {
                            total += student.getGrade();
                        }
                        double average = total / students.size();
                        System.out.printf("Average Grade: %.2f%n", average);
                    }
                    break;

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
