import java.util.Random;
import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private int defaultPasswordLength = 8;
    private String department;
    private String companySuffix = ".somecompany.com";
    private String email;
    private int mailboxCapacity = 500;
    private String alternateEmail;

    // Constructor to receive the first name and last name
    public Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("EMAIL Created: " + this.firstName + " " + this.lastName);

        // call a method asking for the department
        this.department = setDepartment();
        System.out.println("department: " + this.department);

        // call a method return a random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is " + this.password);

        // combine elements to generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@"
                + department + companySuffix;
        System.out.println("Your email is: " + email);

    }

    // ask for the department
    private String setDepartment(){
        System.out.println("Enter the department\n1 for Sales\n2 for Development\n3 for Account\n0 for none\n" +
                "Enter department code: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        switch (depChoice) {
            case 1:
                return "sales";
            case 2:
                return "development";
            case 3:
                return "account";
            default:
                return " ";
        }
    }

    // generate a random password
    private String randomPassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^&*";
        char[] password = new char[length];
        for(int i = 0; i < length; i++){
            int rand = (int)(Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    // set the mailbox capacity
    public void setMailboxCapacity(int mailboxCapacity){
        this.mailboxCapacity = mailboxCapacity;
    }

    // set the alternate email
    public void setAlternateEmail(String alternateEmail){
        this.alternateEmail = alternateEmail;
    }

    // change the password
    public void changePassword(String newPassword){
        this.password = newPassword;
    }

    public int getMailboxCapacity(){ return mailboxCapacity; }
    public String getEmail(){ return email; }
    public String getPassword(){ return password; }

    public void showInfo(){
        System.out.println("---------------------------" +
                "\nDisplay name: " + firstName + " " + lastName +
                "\nCompany Email: " + email +
                "\nMailbox Capacity: " + mailboxCapacity + "mb");
    }
}
