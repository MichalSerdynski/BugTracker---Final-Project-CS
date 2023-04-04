public class Main // defines a new Main class.
{
    public static void main(String[] args) // defines the main method of the Main class, as the entry point for the Java application. The main method takes an array of String arguments (args) as input.
    {
        IDandPasswords idandPasswords = new IDandPasswords(); // creates a new IDandPasswords object, as a custom class that stores login credentials in a HashMap.
        LoginPage loginPage = new LoginPage(idandPasswords.getLoginInfo()); // creates a new LoginPage object, passing the login credentials stored in the IDandPasswords object to the constructor.
    }
}
