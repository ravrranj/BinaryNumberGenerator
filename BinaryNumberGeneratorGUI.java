import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class BinaryNumberGeneratorGUI extends JFrame {

    private JTextField inpuTextField;
    private JTextArea outputArea;
    private JButton generateButton, clearButton;

    public BinaryNumberGeneratorGUI() {
        setTitle("BinaryGen - Binary Number Generator");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Set modern light background color
        getContentPane().setBackground(new Color(240, 248, 255)); // AliceBlue

        // Icon (optional - place "icon.png" in project root)
        try {
            setIconImage(new ImageIcon("binary-file-icon").getImage());
        } catch (Exception e) {
            System.out.println("Icon not found. Skipping...");
        }

        // Fonts
        Font textFont = new Font("Segoe UI", Font.PLAIN, 16);
        Font buttonFont = new Font("Segoe UI", Font.BOLD, 14);
        Font outputFont = new Font("Consolas", Font.PLAIN, 14);

        // Components
        JLabel label = new JLabel("Enter N:");
        label.setFont(textFont);

        inpuTextField = new JTextField(10);
        inpuTextField.setFont(textFont);

        generateButton = new JButton("Generate");
        generateButton.setFont(buttonFont);
        generateButton.setBackground(new Color(70, 130, 180)); // SteelBlue
        generateButton.setForeground(Color.WHITE);

        clearButton = new JButton("Clear");
        clearButton.setFont(buttonFont);
        clearButton.setBackground(new Color(255, 215, 0)); // Gold
        clearButton.setForeground(Color.BLACK);

        outputArea = new JTextArea(10, 30);
        outputArea.setFont(outputFont);
        outputArea.setEditable(false);
        outputArea.setBackground(Color.WHITE);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        // Layout
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(label, gbc);

        gbc.gridx = 1;
        add(inpuTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(generateButton, gbc);

        gbc.gridx = 1;
        add(clearButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        add(scrollPane, gbc);

        // Button Actions
        generateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generateBinaryNumbers();
            }
        });

        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                inpuTextField.setText("");
                outputArea.setText("");
            }
        });

        setVisible(true);
    }

    private void generateBinaryNumbers() {
        outputArea.setText("");
        try {
            int N = Integer.parseInt(inpuTextField.getText().trim());
            if (N <= 0) {
                outputArea.setText("Please enter a positive number.");
                return;
            }

            Queue<String> queue = new LinkedList<>();
            queue.add("1");

            for (int i = 1; i <= N; i++) {
                String current = queue.poll();
                outputArea.append(current + "\n");
                queue.add(current + "0");
                queue.add(current + "1");
            }
        } catch (NumberFormatException ex) {
            outputArea.setText("Please enter a valid number.");
        }
    }

    public static void main(String[] args) {
        new BinaryNumberGeneratorGUI();
    }
}
