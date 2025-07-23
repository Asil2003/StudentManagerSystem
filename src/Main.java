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
                    scanner.nextLine();

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

                    boolean foundToUpdate = false;
                    for (Student student : students) {
                        if (student.getId() == updateId) {
                            System.out.print("Enter new grade: ");
                            double newGrade = scanner.nextDouble();
                            scanner.nextLine();
                            student.setGrade(newGrade);
                            System.out.println("Grade updated successfully!");
                            foundToUpdate = true;
                            break;
                        }
                    }

                    if (!foundToUpdate) {
                        System.out.println("Student with ID " + updateId + " not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter student ID to delete: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine();

                    boolean removed = students.removeIf(student -> student.getId() == deleteId);

                    if (removed) {
                        System.out.println("Student deleted successfully!");
                    } else {
                        System.out.println("Student with ID " + deleteId + " not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter student ID to search: ");
                    int searchId = scanner.nextInt();
                    scanner.nextLine();

                    boolean foundById = false;
                    for (Student student : students) {
                        if (student.getId() == searchId) {
                            System.out.println("Student found:");
                            student.displayInfo();
                            foundById = true;
                            break;
                        }
                    }

                    if (!foundById) {
                        System.out.println("Student with ID " + searchId + " not found.");
                    }
                    break;

                case 6:
                    System.out.print("Enter student name to search: ");
                    String searchName = scanner.nextLine().toLowerCase();

                    boolean foundByName = false;
                    for (Student student : students) {
                        if (student.getName().toLowerCase().contains(searchName)) {
                            if (!foundByName) {
                                System.out.println("Matching Students:");
                            }
                            student.displayInfo();
                            foundByName = true;
                        }
                    }

                    if (!foundByName) {
                        System.out.println("No students found with the name: " + searchName);
                    }
                    break;

                case 7:
                    if (students.isEmpty()) {
                        System.out.println("No students to calculate average grade.");
                    } else {
                        double sum = 0;
                        for (Student student : students) {
                            sum += student.getGrade();
                        }
                        double avg = sum / students.size();
                        System.out.printf("Average Grade: %.2f%n", avg);
                    }
                    break;

                case 8:
                    if (students.isEmpty()) {
                        System.out.println("No students available to evaluate highest grade.");
                    } else {
                        double highest = students.get(0).getGrade();
                        for (Student student : students) {
                            if (student.getGrade() > highest) {
                                highest = student.getGrade();
                            }
                        }

                        System.out.printf("Highest Grade: %.2f%n", highest);
                        System.out.println("Student(s) with Highest Grade:");
                        for (Student student : students) {
                            if (student.getGrade() == highest) {
                                student.displayInfo();
                            }
                        }
                    }
                    break;

                case 9:
                    if (students.isEmpty()) {
                        System.out.println("No students available to evaluate lowest grade.");
                    } else {
                        double lowest = students.get(0).getGrade();
                        for (Student student : students) {
                            if (student.getGrade() < lowest) {
                                lowest = student.getGrade();
                            }
                        }

                        System.out.printf("Lowest Grade: %.2f%n", lowest);
                        System.out.println("Student(s) with Lowest Grade:");
                        for (Student student : students) {
                            if (student.getGrade() == lowest) {
                                student.displayInfo();
                            }
                        }
                    }
                    break;

                case 10:
                    System.out.println("Total Students: " + students.size());
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
