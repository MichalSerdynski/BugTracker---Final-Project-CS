import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SubmitTicket {
    static Map<Integer, Ticket> tickets = new HashMap<>();
    static int ticketId = 1;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Bug Ticket System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel titleLabel = new JLabel("Title:");
        final JTextField titleField = new JTextField();
        titleField.setPreferredSize(new Dimension(300, 20));

        JLabel detailsLabel = new JLabel("Details:");
        final JTextArea detailsArea = new JTextArea();
        detailsArea.setPreferredSize(new Dimension(300, 200));

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Ticket ticket = new Ticket(titleField.getText(), detailsArea.getText());
                SubmitTicket.submitTicket(ticket);
                titleField.setText("");
                detailsArea.setText("");
            }
        });

        JButton checkStatusButton = new JButton("Check Ticket Status");
        checkStatusButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String ticketIdStr = JOptionPane.showInputDialog(null, "Enter ticket ID:");
                if (ticketIdStr == null || ticketIdStr.trim().isEmpty()) {
                    return;
                }
                int ticketId = Integer.parseInt(ticketIdStr.trim());
                SubmitTicket.checkTicketStatus(ticketId);
            }
        });

        JPanel panel = new JPanel(new BorderLayout());
        JPanel fieldsPanel = new JPanel(new BorderLayout());
        JPanel buttonPanel = new JPanel(new BorderLayout());

        fieldsPanel.add(titleLabel, BorderLayout.NORTH);
        fieldsPanel.add(titleField, BorderLayout.CENTER);

        panel.add(fieldsPanel, BorderLayout.NORTH);
        panel.add(detailsLabel, BorderLayout.WEST);
        panel.add(detailsArea, BorderLayout.CENTER);
        buttonPanel.add(submitButton, BorderLayout.WEST);
        buttonPanel.add(checkStatusButton, BorderLayout.EAST);

        panel.add(buttonPanel, BorderLayout.SOUTH);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void submitTicket(Ticket ticket) {
        tickets.put(ticketId, ticket);
        int submittedTicketId = ticketId;
        System.out.println("Ticket submitted with ID " + ticketId);
        ++ticketId;
        String message = "Ticket submitted with ID " + submittedTicketId;
        JOptionPane.showMessageDialog(null, message, "Success", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void checkTicketStatus(int ticketId) {
        Ticket ticket = tickets.get(ticketId);
        if (ticket == null) {
            JOptionPane.showMessageDialog(null, "Ticket with ID " + ticketId + " not found", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Ticket with ID " + ticketId + ":\nTitle: " + ticket.getTitle() + "\nDetails: " + ticket.getDetails(), "Ticket Status", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}

class Ticket {
    private String title;
    private String details;

    public Ticket(String title, String details) {
        this.title = title;
        this.details = details;
    }

    public String getTitle() {
    }}
