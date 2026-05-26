package ContactManagementSystem;

import java.sql.*;
import java.util.ArrayList;

public class Database {

    private String url = "jdbc:mysql://127.0.0.1:3308/contacts%20management%20system";
    private String user = "root";
    private String pass = "";

    private Connection connection;
    private Statement statement;

    public Database() throws SQLException {

        connection = DriverManager.getConnection(url, user, pass);

        statement = connection.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY
        );
    }

    public ArrayList<Contact> getContacts() throws SQLException {

        ArrayList<Contact> contacts = new ArrayList<>();

        String select = "SELECT * FROM contacts";

        ResultSet rs = statement.executeQuery(select);

        while (rs.next()) {

            Contact c = new Contact();

            c.setID(rs.getInt("ID"));
            c.setFirstName(rs.getString("First Name"));
            c.setLastName(rs.getString("Last Name"));
            c.setPhoneNumber(rs.getString("Phone Number"));
            c.setEmail(rs.getString("Email"));

            contacts.add(c);
        }

        return contacts;
    }

    public void insertContact(Contact c) throws SQLException {

        String insert =
                "INSERT INTO contacts (`ID`, `First Name`, `Last Name`, `Phone Number`, `Email`) VALUES ('"
                        + c.getID() + "','"
                        + c.getFirstName() + "','"
                        + c.getLastName() + "','"
                        + c.getPhoneNumber() + "','"
                        + c.getEmail() + "')";

        statement.execute(insert);
    }

    public void updateContact(Contact c) throws SQLException {

        String update =
                "UPDATE contacts SET " +
                        "`First Name`='" + c.getFirstName() + "'," +
                        "`Last Name`='" + c.getLastName() + "'," +
                        "`Phone Number`='" + c.getPhoneNumber() + "'," +
                        "`Email`='" + c.getEmail() + "' " +
                        "WHERE ID=" + c.getID();

        statement.execute(update);
    }

    public void deleteContact(Contact c) throws SQLException {

        String delete =
                "DELETE FROM contacts WHERE ID=" + c.getID();

        statement.execute(delete);
    }

    public int getNextID() throws SQLException {

        int id = 1;

        ArrayList<Contact> contacts = getContacts();

        if (contacts.size() != 0) {

            Contact last = contacts.get(contacts.size() - 1);

            id = last.getID() + 1;
        }

        return id;
    }
}