import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;

public class SubmitTicket {
    static Map<Integer, String> tickets = new HashMap<>(); // dictionary to store tickets
    static int ticketId = 1; // starting ticket ID

    public static void main(String[] args) {
        JFrame frame = new JFrame("Bug Ticket System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Enter ticket details:");
        JTextArea textArea = new JTextArea();
        textArea.setPreferredSize(new Dimension(300, 200));
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submitTicket(textArea.getText());
                textArea.setText("");
            }
        }); // add action listener to submit button

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(label, BorderLayout.NORTH);
        panel.add(textArea, BorderLayout.CENTER);
        panel.add(submitButton, BorderLayout.SOUTH);

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void submitTicket(String details) {
        tickets.put(ticketId, details); // add ticket to dictionary
        int submittedTicketId = ticketId; // save ticket ID for display in pop-up
        System.out.println("Ticket submitted with ID " + ticketId);
        ticketId++; // increment ticket ID for next ticket

        // display pop-up with success message and ticket ID
        String message = "Ticket submitted with ID " + submittedTicketId;
        JOptionPane.showMessageDialog(null, message, "Success", JOptionPane.INFORMATION_MESSAGE);
    }

}
