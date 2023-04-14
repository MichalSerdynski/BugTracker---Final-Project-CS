import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class LoginSystem {
    private FileWriter fileWriter;
    private HashMap<String, String> tickets;

    public LoginSystem() {
        try {
            fileWriter = new FileWriter("tickets.txt", true);
        } catch (IOException e) {
            System.out.println("Error creating file");
            e.printStackTrace();
        }
        tickets = new HashMap<String, String>();
    }

    public void saveTicket(String username, String message) {
        tickets.put(username, message);
        try {
            fileWriter.write("New ticket created by " + username + ": " + message + "\n");
            System.out.println("Ticket saved to file");
        } catch (IOException e) {
            System.out.println("Error writing to file");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LoginSystem loginSystem = new LoginSystem();

        System.out.print("Enter username: ");
        String username = input.nextLine();
        System.out.print("Enter password: ");
        String password = input.nextLine();

        if (username.equals("admin") && password.equals("password")) {
            System.out.println("Login successful");

            System.out.print("Enter ticket message: ");
            String message = input.nextLine();

            // Save the ticket to the file and the HashMap
            loginSystem.saveTicket(username, message);
        } else {
            System.out.println("Invalid username or password");
        }

        try {
            loginSystem.fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
