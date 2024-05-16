package myPackage;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Vector;

public class Sample {
    private JFrame frame;
    private JPanel cardPanel;
    private CardLayout cardLayout;
    private JTextField userIdField;
    private JPasswordField passwordField;
    private static final String ADMIN_PASSWORD = "12345";
    private static final String ADMIN_USER_ID = "admin@shoppingCart";
    private static final String[] USER_IDS = {"bharath@shoppingCart", "abishek@shoppingCart"};
    private static final String[] USER_PASSWORDS = {"bharath", "abishek"};

    private DefaultTableModel tableModel;
    private JTable table;
    private JTextField searchField;
    private JButton searchButton;
    private JButton addStockButton;
    private JButton deleteStockButton;
    private JLabel statusLabel;
    private static final String DATA_FILE = "product_data.txt"; // File to store product data

    public Sample() {
        frame = new JFrame("E-Commerce App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        createLoginPanel();
        createAdminPanel();
        createUserPanel("Bharath"); // Specify the user name here
        createUserPanel("Abishek"); // Specify the user name here

        frame.getContentPane().add(cardPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private void createLoginPanel() {
        // Existing login panel code remains the same
        // ...private JFrame frame;

        private JPanel cardPanel;

        private CardLayout cardLayout;

        private JTextField userIdField;

        private JPasswordField passwordField;



        private static final String ADMIN_PASSWORD = "12345";

        private static final String ADMIN_USER_ID = "admin@shoppingCart";

        private static final String[] USER_IDS = { "bharath@shoppingCart", "abishek@shoppingCart" };

        private static final String[] USER_PASSWORDS = { "bharath", "abishek" };



        public LoginPage() {

            frame = new JFrame("Login Example");

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            frame.setSize(400, 300);



            cardLayout = new CardLayout();

            cardPanel = new JPanel(cardLayout);



            createLoginPanel();

            createAdminPanel();

            createUserPanel("Bharath"); // Specify the user name here

            createUserPanel("Abishek"); // Specify the user name here



            frame.getContentPane().add(cardPanel, BorderLayout.CENTER);



            frame.setVisible(true);

        }



        private void createLoginPanel() {

            JPanel loginPanel = new JPanel(new GridBagLayout());

            GridBagConstraints gbc = new GridBagConstraints();

            gbc.fill = GridBagConstraints.HORIZONTAL;

            gbc.insets = new Insets(5, 5, 5, 5);



            gbc.gridx = 0;

            gbc.gridy = 0;

            loginPanel.add(new JLabel("User Type:"), gbc);



            gbc.gridx = 1;

            gbc.gridy = 0;

            JComboBox<String> userTypeComboBox = new JComboBox<>(new String[] { "Select User Type", "Admin", "User" });

            loginPanel.add(userTypeComboBox, gbc);



            gbc.gridx = 0;

            gbc.gridy = 1;

            loginPanel.add(new JLabel("User ID:"), gbc);



            gbc.gridx = 1;

            gbc.gridy = 1;

            userIdField = new JTextField(15);

            loginPanel.add(userIdField, gbc);



            gbc.gridx = 0;

            gbc.gridy = 2;

            loginPanel.add(new JLabel("Password:"), gbc);



            gbc.gridx = 1;

            gbc.gridy = 2;

            passwordField = new JPasswordField(15);

            loginPanel.add(passwordField, gbc);



            gbc.gridx = 1;

            gbc.gridy = 3;

            JButton loginButton = new JButton("Login");

            loginButton.addActionListener(new ActionListener() {

                @Override

                public void actionPerformed(ActionEvent e) {

                    String userType = userTypeComboBox.getSelectedItem().toString();

                    if ("Admin".equals(userType)) {

                        String userId = userIdField.getText();

                        String password = new String(passwordField.getPassword());

                        if (ADMIN_USER_ID.equals(userId) && ADMIN_PASSWORD.equals(password)) {

                            cardLayout.show(cardPanel, "Admin");

                        } else {

                            JOptionPane.showMessageDialog(frame, "Invalid User ID or Password", "Error", JOptionPane.ERROR_MESSAGE);

                        }

                    } else if ("User".equals(userType)) {

                        String userId = userIdField.getText();

                        String password = new String(passwordField.getPassword());

                        boolean validUser = false;

                        for (int i = 0; i < USER_IDS.length; i++) {

                            if (USER_IDS[i].equals(userId) && USER_PASSWORDS[i].equals(password)) {

                                validUser = true;

                                if (userId.equals("bharath@shoppingCart")) {

                                    cardLayout.show(cardPanel, "UserBharath");

                                } else if (userId.equals("abishek@shoppingCart")) {

                                    cardLayout.show(cardPanel, "UserAbishek");

                                }

                                break;

                            }

                        }

                        if (!validUser) {

                            JOptionPane.showMessageDialog(frame, "Invalid User ID or Password", "Error", JOptionPane.ERROR_MESSAGE);

                        }

                    }

                }

            });

            loginPanel.add(loginButton, gbc);



            cardPanel.add(loginPanel, "Login");

        }



        private void createAdminPanel() {

            JPanel adminPanel = new JPanel(new BorderLayout());

            adminPanel.add(new JLabel("Welcome, Admin!"), BorderLayout.NORTH);



            JButton backButton = new JButton("Back");

            backButton.addActionListener(new ActionListener() {

                @Override

                public void actionPerformed(ActionEvent e) {

                    cardLayout.show(cardPanel, "Login");

                }

            });

            adminPanel.add(backButton, BorderLayout.SOUTH);



            cardPanel.add(adminPanel, "Admin");

        }



        private void createUserPanel(String userName) {

            JPanel userPanel = new JPanel(new BorderLayout());

            userPanel.add(new JLabel("Welcome, " + userName + "!"), BorderLayout.NORTH);



            JButton backButton = new JButton("Back");

            backButton.addActionListener(new ActionListener() {

                @Override

                public void actionPerformed(ActionEvent e) {

                    cardLayout.show(cardPanel, "Login");

                }

            });

            userPanel.add(backButton, BorderLayout.SOUTH);



            cardPanel.add(userPanel, "User" + userName);

        }



        public static void main(String[] args) {

            SwingUtilities.invokeLater(new Runnable() {

                public void run() {

                    new LoginPage();

                }

            });

        }

        cardPanel.add(loginPanel, "Login");
    }

    private void createAdminPanel() {
        JPanel adminPanel = new JPanel(new BorderLayout());
        adminPanel.add(new JLabel("Welcome, Admin! This is the Admin Page"), BorderLayout.NORTH);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Login");
            }
        });
        adminPanel.add(backButton, BorderLayout.SOUTH);

        // Add AdminPage components to the adminPanel
        initializeAdminPageComponents(adminPanel);

        cardPanel.add(adminPanel, "Admin");
    }

    private void createUserPanel(String userName) {
        JPanel userPanel = new JPanel(new BorderLayout());
        userPanel.add(new JLabel("Welcome, " + userName + "! This is the User Page"), BorderLayout.NORTH);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Login");
            }
        });
        userPanel.add(backButton, BorderLayout.SOUTH);

        cardPanel.add(userPanel, "User" + userName);
    }

    // Initialize AdminPage components
    private void initializeAdminPageComponents(JPanel adminPanel) {
        // Existing AdminPage code remains the same
        // ...

        // Add AdminPage components to adminPanel
        adminPanel.add(searchField, BorderLayout.NORTH);
        adminPanel.add(scrollPane, BorderLayout.CENTER);
        adminPanel.add(topPanel, BorderLayout.SOUTH);
        adminPanel.add(statusLabel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ECommerceApp();
            }
        });
    }
}
