import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("First name: ");
        String firstName = sc.nextLine();

        System.out.print("Last name: ");
        String lastName = sc.nextLine();

        LocalDate birthday = null;
        while (birthday == null) {
            System.out.print("Birthday (yyyy/mm/dd): ");
            String birthdayStr = sc.nextLine();
            try {
                birthday = LocalDate.parse(birthdayStr, DateTimeFormatter.ofPattern("yyyy/MM/dd"));
            } catch (DateTimeParseException e) {
                System.out.println("Invalid birthday format. Please enter yyyy/mm/dd");
            }
        }

        System.out.print("Course: ");
        String course = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        Records form = new Records(firstName, lastName, birthday, course, email);
        if (form.isValidForm()) {
            String studentNumber = form.getStudentNumber();
            System.out.println("Registration successful!. Student number: " + studentNumber);
        } else {
            System.out.println("Registration failed. Invalid input.");
        }
    }
}
