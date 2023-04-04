import javax.swing.*;
import java.awt.*;

public class WelcomePage // defines the WelcomePage class.
{
    JFrame frame = new JFrame(); // creates a new instance of a JFrame object.
    JLabel WelcomeLabel = new JLabel(); // creates a new instance of a JLabel object.

    WelcomePage(String userID) // defines a constructor for the WelcomePace class that takes a string parameter called "userID".
    {

        WelcomeLabel.setBounds(15,0,200,350); // method to set size and position of the welcome label components.
        WelcomeLabel.setFont(new Font(null, Font.BOLD, 15)); // method to set font for the welcome label components.
        WelcomeLabel.setText("Hi there, " + userID + " !"); // // method to set text of the welcome label components.

        frame.add(WelcomeLabel); // method to add the WelcomeLabel to the JFrame container.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // method to set the default close operation for the JFrame to exit the program when the user closes the window.
        frame.setSize(420,420); // method to set the size of the JFrame container.
        frame.setLayout(null); // method to set the layout of the JFrame container to null, which means that the components are positioned manually.
        frame.setVisible(true); // method to make the JFrame container visible on the screen.
    }
}
