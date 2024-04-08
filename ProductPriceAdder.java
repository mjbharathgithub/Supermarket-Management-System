package myPackage;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductPriceAdder {

    private JFrame frame;
    private DefaultTableModel tableModel;
    private JTable table;
    private JTextField searchField;
    private JComboBox<String> autoCompleteComboBox;

    private List<String> productNames = Arrays.asList(
            "Fresh Apples", "Bread Loaf", "Milk (1 Gallon)", "Eggs (Dozen)", "Ground Beef (1 lb)",
            "Potato Chips", "Orange Juice (64 oz)", "Pasta (16 oz)", "Cereal (12 oz)", "Chicken Breasts (1 lb)",
            "Rice (5 kg)", "Tomatoes (1 kg)", "Onions (1 kg)", "Carrots (1 kg)", "Apples (1 kg)", "Bananas (1 dozen)",
            "Spinach (500g)", "Cheese (200g)", "Yogurt (500g)", "Chocolate Bar"
    );

    private List<Double> productPrices = Arrays.asList(
            180.00, 145.00, 255.00, 135.00, 295.00, 220.00, 285.00, 115.00, 255.00, 365.00,
            350.00, 40.00, 35.00, 50.00, 100.00, 45.00, 25.00, 85.00, 60.00, 30.00
    );

    private int productCount = 1;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ProductPriceAdder window = new ProductPriceAdder();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public ProductPriceAdder() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 650, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        autoCompleteComboBox = new JComboBox<String>(productNames.toArray(new String[0]));
        autoCompleteComboBox.setBounds(20, 20, 200, 25);
        frame.getContentPane().add(autoCompleteComboBox);

        JButton addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addProduct();
            }
        });
        addButton.setBounds(230, 20, 80, 25);
        frame.getContentPane().add(addButton);

        JButton totalButton = new JButton("Total");
        totalButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculateTotal();
            }
        });
        totalButton.setBounds(320, 20, 80, 25);
        frame.getContentPane().add(totalButton);

        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearSearchField();
            }
        });
        nextButton.setBounds(410, 20, 80, 25);
        frame.getContentPane().add(nextButton);

        searchField = new JTextField();
        searchField.setBounds(20, 55, 200, 25);
        frame.getContentPane().add(searchField);

        tableModel = new DefaultTableModel(new Object[][]{}, new String[]{"S.NO", "Product Name", "Price (INR)"});
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 90, 600, 200);
        frame.getContentPane().add(scrollPane);
    }

    private void addProduct() {
        String selectedProduct = autoCompleteComboBox.getSelectedItem().toString();
        double selectedPrice = getProductPrice(selectedProduct);
        tableModel.addRow(new Object[]{productCount++, selectedProduct, selectedPrice});
        clearSearchField();
    }

    private void calculateTotal() {
        double total = 0;
        for (int row = 0; row < tableModel.getRowCount(); row++) {
            total += (double) tableModel.getValueAt(row, 2);
        }
        JOptionPane.showMessageDialog(frame, "Total Price: " + total + " INR");
    }

    private double getProductPrice(String productName) {
        int index = productNames.indexOf(productName);
        if (index != -1 && index < productPrices.size()) {
            return productPrices.get(index);
        }
        return 0.0;
    }

    private void clearSearchField() {
        autoCompleteComboBox.setSelectedItem(null);
    }
}