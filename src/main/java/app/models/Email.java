package app.models;

import app.enums.Department;

import java.util.Scanner;

import static app.utils.Utilities.generateRandomPassword;

public class Email {

    private static final int PASSWORD_LENGTH = 9;
    private static final String COMPANY_SUFFIX = "company.com";

    private final String firstName;
    private final String lastName;
    private Department department;
    private String password;
    private int mailboxCapacity;
    private String alternateEmail;

    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        System.out.println("Email Created: " + firstName + " " + lastName);

        requestDepartment();
        System.out.println("Department: " + this.department);

        setPassword(generateRandomPassword(PASSWORD_LENGTH));
        System.out.println("Your password is: " + this.password);

        setMailboxCapacity(500);
        System.out.println("Your email is: " + getEmail());
    }

    public String showInfo() {
        return String.format(
                        "\nDisplay Name: %s %s" +
                        "\nCompany Email: %s" +
                        "\nAlternate Email: %s" +
                        "\nMailbox Capacity: %d MB",
                firstName,
                lastName,
                getEmail(),
                alternateEmail,
                mailboxCapacity
        );
    }

    public String getEmail() {
        return String.format(
                "%s.%s@%s%s",
                firstName.toLowerCase(),
                lastName.toLowerCase(),
                department != null
                        ? department.toString().toLowerCase() + "."
                        : "",
                COMPANY_SUFFIX
        );
    }

    public String getName() {
        return firstName + lastName;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public boolean changeMailboxCapacity(String email, String password, int mailboxCapacity) {
        if (!authenticate(email, password)) {
            return false;
        }

        this.mailboxCapacity = mailboxCapacity;
        return true;
    }

    public boolean changeAlternateEmail(String email, String password, String alternateEmail) {
        if (!authenticate(email, password)) {
            return false;
        }

        this.alternateEmail = alternateEmail;
        return true;
    }

    public boolean authenticate(String email, String password) {
        return getEmail().compareToIgnoreCase(email) == 0
                && this.password.compareTo(password) == 0;
    }

    private void requestDepartment() {
        System.out.println(
                "Department Codes" +
                        "\n1 for Sales" +
                        "\n2 for Development" +
                        "\n3 for Accounting" +
                        "\n0 for None" +
                        "\nEnter the department code:"
        );

        Scanner in = new Scanner(System.in);
        Department department;
        switch (in.nextInt()) {
            case 1:
                department = Department.SALES;
                break;
            case 2:
                department = Department.DEVELOPMENT;
                break;
            case 3:
                department = Department.ACCOUNTING;
                break;
            default:
                department = null;
        }
        setDepartment(department);
    }

    private void setDepartment(Department department) {
        this.department = department;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    private void setMailboxCapacity(int mailboxCapacity) {
        this.mailboxCapacity = mailboxCapacity;
    }

    private void setAlternateEmail(String alternateEmail) {
        this.alternateEmail = alternateEmail;
    }
}
