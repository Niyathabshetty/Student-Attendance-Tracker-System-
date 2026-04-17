import java.util.*;

class Student {
    String name;
    int totalClasses = 0;
    int attended = 0;

    Student(String name) {
        this.name = name;
    }

    void markAttendance(boolean isPresent) {
        totalClasses++;
        if (isPresent) {
            attended++;
        }
    }

    double getPercentage() {
        if (totalClasses == 0) return 0;
        return (attended * 100.0) / totalClasses;
    }
}

public class AttendanceSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        //add student details
        System.out.print("Enter number of students:");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter name of student " + (i + 1) + ": ");
            String name = sc.nextLine();
            students.add(new Student(name));
        }

        //marking attendance
        System.out.print("\n Enter number of classes conducted: ");
        int classes = sc.nextInt();

        for (int i = 0; i < classes; i++) {
            System.out.println("\nClass " + (i + 1));

            for (Student s : students) {
                System.out.print("Is " + s.name + " present? (y/n): ");
                String input = sc.next();
                s.markAttendance(input.equalsIgnoreCase("y"));
            }
        }

        
        System.out.println("\n--- Attendance Report ---");

        for (Student s : students) {
            double percent = s.getPercentage();

            System.out.println("Name: " + s.name);
            System.out.println("Attendance: " + percent + "%");

            if (percent < 75) {
                System.out.println("Below 75%");
            }
            System.out.println();
        }
    }
}