import javax.swing.*; // Swing library providing a set of GUI components for Java.
import java.awt.*; // AWT library providing building blocks for creating GUI.
import java.awt.event.ActionEvent; // imports classes needed for handling user actions in the GUI.
import java.awt.event.ActionListener; // imports classes needed for handling user actions in the GUI.
import java.util.HashMap; // imports HashMap class to store login credentials for the users.
public class LoginPage implements ActionListener // defines LoginPage class, which implements the ActionListener interface.
{
    JFrame frame = new JFrame(); // creates a new instance of a JFrame object as the main container for the GUI components.
    JButton loginButton = new JButton("LOG IN"); // creates a new instance of a JButton object for GUI.
    JButton cancelButton = new JButton("CANCEL");
    JTextField userIDField = new JTextField(); // creates a new instance of a JField object for text for GUI.
    JPasswordField userPasswordField = new JPasswordField();
    JLabel userIDLabel = new JLabel("USER ID:"); // creates a new instance of a JLabel object.
    JLabel userPasswordLabel = new JLabel("PASSWORD:");
    JLabel titleLabel = new JLabel("Log In");
    JLabel messageLabel = new JLabel();
    HashMap<String,String> logininfo = new HashMap<String,String>(); // creates a new HashMap object to store the login credentials.
    LoginPage(HashMap<String,String> loginInfoOriginal) // defines a constructor LoginPage class that initializes the logininfo HashMap with the string values passed as a parameter.
    {
        logininfo = loginInfoOriginal;

        titleLabel.setBounds(45, 15, 100, 50); // method to set size and position of the label components.
        titleLabel.setFont(new Font(null, Font.BOLD,20)); // method to set the font for label components.
        userIDLabel.setBounds(45,100,75,25);
        userPasswordLabel.setBounds(45,160,75,25);

        messageLabel.setBounds(45,205,250,35);
        messageLabel.setFont(new Font(null,Font.ITALIC,9));

        userIDField.setBounds(45,125,200,25);
        userPasswordField.setBounds(45,185,200,25);

        loginButton.setBounds(45,275,100,25);
        loginButton.addActionListener(this);

        cancelButton.setBounds(145,275,100,25);
        cancelButton.addActionListener(this);

        frame.add(titleLabel); // method to add the GUI components to the JFrame container.
        frame.add(userIDLabel);
        frame.add(userPasswordLabel);
        frame.add(messageLabel);
        frame.add(userIDField);
        frame.add(userPasswordField);
        frame.add(loginButton);
        frame.add(cancelButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // method to set the default close operation for the JFrame to exit the program when the user closes the window.
        frame.setSize(305,500); // method to set the size of the JFrame container.
        frame.setLayout(null); // method to set the layout of the JFrame container to null, which means that the components are positioned manually.
        frame.setVisible(true); // method to make the JFrame container visible on the screen.
    }

    @Override
    public void actionPerformed(ActionEvent e) // method to handle the user actions when they click the login button or cancel button.
    {
        if(e.getSource() == cancelButton) // cancel button action to clear the text fields and message label.
        {
            userIDField.setText(""); // method to set text fields and labels to empty when cancel button is clicked.
            userPasswordField.setText("");
            messageLabel.setText("");
        }

        if(e.getSource() == loginButton) // login button action to retrieve the user input from the text fields and checks if it matches the login credentials stored in the HashMap.
        {
            String userID = userIDField.getText(); // method is called on the userIDField object to get the text that was typed into the field, assign it to the userID variable, and declare as a String object.
            String password = String.valueOf(userPasswordField.getPassword()); // method is called on the userPasswordField object to get the characters that was typed into the field, returns an array of char objects, which the valueOf() method convert into a String object. This String object is then assigned to the password variable, and declared as a String object.

            if(logininfo.containsKey(userID)) // checks if the logininfo HashMap contains the userID entered by the user. If matched, the code proceeds to the next if statement. If not, the code skips to the else block.
            {
                if(logininfo.get(userID).equals(password)) // checks if the password stored in the logininfo HashMap for the given userID matches the password entered by the user.
                {
                    frame.dispose(); // if matched, disposes of the frame (the login window).
                    WelcomePage welcomePage = new WelcomePage(userID); // creates a new WelcomePage object, passing the userID as a parameter.
                }
                else // block is executed if the userID entered by the user is not present in the logininfo HashMap.
                {
                    messageLabel.setForeground(Color.red); // sets the message on the messageLabel to indicate that the user entered an incorrect user ID or password.
                    messageLabel.setText("Incorrect User ID or password. Please try again.");
                }
            }
            else
            {
                messageLabel.setForeground(Color.red);
                messageLabel.setText("Incorrect User ID or password. Please try again.");
            }
        }
    }
}

