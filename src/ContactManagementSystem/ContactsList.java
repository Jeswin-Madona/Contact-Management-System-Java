package ContactManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class ContactsList {

    private JPanel table;
    private Database database;

    public ContactsList(Database database) {

        this.database = database;

        JFrame frame =
                new JFrame("Contact Management System");

        frame.setLayout(new BorderLayout());
        frame.setSize(1200, 700);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        frame.getContentPane()
                .setBackground(Color.WHITE);

        // ================= TOP PANEL =================

        JPanel top =
                new JPanel(new BorderLayout());

        top.setBorder(
                BorderFactory.createEmptyBorder(
                        50, 50, 50, 50
                )
        );

        top.setBackground(Color.WHITE);

        JLabel title = new JLabel(
                "Welcome to Contacts Management System"
        );

        title.setFont(
                new Font(
                        "Calibri",
                        Font.BOLD,
                        35
                )
        );

        title.setHorizontalAlignment(
                JLabel.CENTER
        );

        top.add(title, BorderLayout.CENTER);

        JButton newContact =
                new JButton("New Contact");

        newContact.setFont(
                new Font(
                        "Tahoma",
                        Font.BOLD,
                        18
                )
        );

        newContact.setBackground(
                new Color(88, 179, 88)
        );

        newContact.setForeground(
                Color.WHITE
        );

        newContact.setCursor(
                new Cursor(Cursor.HAND_CURSOR)
        );

        newContact.setFocusPainted(false);

        newContact.addActionListener(e -> {

            try {

                new OpenContact(
                        new Contact(),
                        "new",
                        database,
                        ContactsList.this
                );

            } catch (Exception e1) {

                JOptionPane.showMessageDialog(
                        null,
                        e1.toString()
                );
            }
        });

        top.add(
                newContact,
                BorderLayout.EAST
        );

        frame.add(
                top,
                BorderLayout.NORTH
        );

        // ================= TABLE PANEL =================

        table = new JPanel();

        table.setLayout(
                new BoxLayout(
                        table,
                        BoxLayout.Y_AXIS
                )
        );

        table.setBackground(
                Color.WHITE
        );

        try {

            refresh(
                    database.getContacts()
            );

        } catch (SQLException e1) {

            JOptionPane.showMessageDialog(
                    null,
                    e1.toString()
            );
        }

        JScrollPane scrollPane =
                new JScrollPane(table);

        scrollPane.setBorder(
                BorderFactory.createEmptyBorder(
                        0,
                        50,
                        50,
                        50
                )
        );

        scrollPane.getViewport()
                .setBackground(Color.WHITE);

        frame.add(
                scrollPane,
                BorderLayout.CENTER
        );

        frame.setVisible(true);
    }

    public void refresh(
            ArrayList<Contact> contacts
    ) {

        table.removeAll();

        table.revalidate();
        table.repaint();

        for (int i = 0;
             i < contacts.size();
             i++) {

            Contact c = contacts.get(i);

            JPanel panel =
                    new JPanel(
                            new FlowLayout(
                                    FlowLayout.LEFT,
                                    25,
                                    10
                            )
                    );

            // Alternate Row Colors

            if (i % 2 == 0) {

                panel.setBackground(
                        Color.decode("#e5e5e5")
                );

            } else {

                panel.setBackground(
                        Color.WHITE
                );
            }

            panel.setMaximumSize(
                    new Dimension(
                            Integer.MAX_VALUE,
                            70
                    )
            );

            panel.setPreferredSize(
                    new Dimension(
                            1000,
                            70
                    )
            );

            // Labels

            panel.add(
                    GUI.label(
                            c.getFirstName()
                                    + " "
                                    + c.getLastName()
                    )
            );

            panel.add(
                    GUI.label(
                            c.getPhoneNumber()
                    )
            );

            panel.add(
                    GUI.label(
                            c.getEmail()
                    )
            );

            // View Button

            JButton view =
                    GUI.button(
                            "View",
                            new Color(
                                    88,
                                    179,
                                    99
                            )
                    );

            view.addActionListener(e -> {

                try {

                    new OpenContact(
                            c,
                            "view",
                            database,
                            ContactsList.this
                    );

                } catch (Exception e1) {

                    JOptionPane.showMessageDialog(
                            null,
                            e1.toString()
                    );
                }
            });

            // Edit Button

            JButton edit =
                    GUI.button(
                            "Edit",
                            new Color(
                                    63,
                                    134,
                                    196
                            )
                    );

            edit.addActionListener(e -> {

                try {

                    new OpenContact(
                            c,
                            "edit",
                            database,
                            ContactsList.this
                    );

                } catch (Exception e1) {

                    JOptionPane.showMessageDialog(
                            null,
                            e1.toString()
                    );
                }
            });

            // Delete Button

            JButton delete =
                    GUI.button(
                            "Delete",
                            new Color(
                                    208,
                                    11,
                                    3
                            )
                    );

            delete.addActionListener(e -> {

                try {

                    database.deleteContact(c);

                    refresh(
                            database.getContacts()
                    );

                } catch (SQLException e1) {

                    JOptionPane.showMessageDialog(
                            null,
                            e1.toString()
                    );
                }
            });

            panel.add(view);
            panel.add(edit);
            panel.add(delete);

            table.add(panel);
        }

        table.revalidate();
        table.repaint();
    }
}