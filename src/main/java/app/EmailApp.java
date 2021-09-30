package app;

import app.models.Email;

import java.util.Scanner;

public class EmailApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Email object
        Email email = new Email("John", "Doe");

        // Authenticate
        System.out.println("Please verify your credentials: ");
        String emailAddress = scanner.nextLine();
        String password = scanner.nextLine();

        if (!email.authenticate(emailAddress, password)) {
            System.out.println("Incorrect credentials");
            return;
        }

        // Set alternate email
        System.out.println("Enter alternate email: ");
        email.changeAlternateEmail(emailAddress, password, scanner.nextLine());
        System.out.println("Alternate email changed successfully");

        // Show info
        System.out.println(email.showInfo());

    }
}
