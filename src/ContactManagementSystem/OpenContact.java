package ContactManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class OpenContact {

    public OpenContact(Contact c,
                       String oper,
                       Database database,
                       ContactsList contacts) {

        JFrame frame =
                new JFrame("Contacts Management System");

        frame.setLayout(new BorderLayout());
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(Color.WHITE);

        JPanel table =
                new JPanel(new GridLayout(6, 2, 15, 15));

        table.setBackground(Color.WHITE);

        table.setBorder(
                BorderFactory.createEmptyBorder(
                        20, 20, 20, 20
                )
        );

        table.add(GUI.label("ID"));

        JLabel id =
                GUI.label(String.valueOf(c.getID()));

        table.add(id);

        table.add(GUI.label("First Name"));

        JTextField firstName =
                GUI.textField(c.getFirstName());

        table.add(firstName);

        table.add(GUI.label("Last Name"));

        JTextField lastName =
                GUI.textField(c.getLastName());

        table.add(lastName);

        table.add(GUI.label("Phone Number"));

        JTextField phoneNumber =
                GUI.textField(c.getPhoneNumber());

        table.add(phoneNumber);

        table.add(GUI.label("Email"));

        JTextField email =
                GUI.textField(c.getEmail());

        table.add(email);

        JButton cancel =
                GUI.button("Cancel",
                        new Color(208, 11, 3));

        cancel.addActionListener(e -> frame.dispose());

        table.add(cancel);

        JButton save =
                GUI.button("Save",
                        new Color(88, 179, 88));

        table.add(save);

        frame.add(table, BorderLayout.CENTER);

        if (oper.equals("new")) {

            try {
                id.setText(
                        String.valueOf(
                                database.getNextID()
                        )
                );
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(
                        null,
                        e.toString()
                );
            }

            save.addActionListener(e -> {

                c.setID(Integer.parseInt(id.getText()));
                c.setFirstName(firstName.getText());
                c.setLastName(lastName.getText());
                c.setPhoneNumber(phoneNumber.getText());
                c.setEmail(email.getText());

                try {

                    database.insertContact(c);

                    frame.dispose();

                    contacts.refresh(
                            database.getContacts()
                    );

                } catch (SQLException e1) {

                    JOptionPane.showMessageDialog(
                            null,
                            e1.toString()
                    );
                }
            });

        } else if (oper.equals("edit")) {

            save.addActionListener(e -> {

                c.setID(Integer.parseInt(id.getText()));
                c.setFirstName(firstName.getText());
                c.setLastName(lastName.getText());
                c.setPhoneNumber(phoneNumber.getText());
                c.setEmail(email.getText());

                try {

                    database.updateContact(c);

                    frame.dispose();

                    contacts.refresh(
                            database.getContacts()
                    );

                } catch (SQLException e1) {

                    JOptionPane.showMessageDialog(
                            null,
                            e1.toString()
                    );
                }
            });

        } else if (oper.equals("view")) {

            save.setVisible(false);
        }

        frame.setVisible(true);
    }
}