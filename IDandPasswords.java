import java.util.HashMap;

public class IDandPasswords // defines a custom class called IDandPasswords, which has a constructor that initializes a HashMap object called logininfo with login credentials.
{
    HashMap<String,String> logininfo = new HashMap<String,String>(); // creates a new HashMap object called logininfo with keys and values of type String.
    IDandPasswords() // the IDandPasswords constructor initializes the HashMap with some default login credentials.
    {
        logininfo.put("Hai@pace", "Hai123"); // adds a new entry to the logininfo HashMap with a key for username and a value for password.
        logininfo.put("Krits@pace", "Krits123");
        logininfo.put("Michael@pace", "Michael123");
        logininfo.put("Zaid@pace", "Zaid123");
        logininfo.put("Amir@pace", "Amir123");
    }

    protected HashMap getLoginInfo() // defines a new method called getLoginInfo() that returns the logininfo HashMap.
    {
        return logininfo; // returns the logininfo HashMap when the getLoginInfo() method is called.
    }
}