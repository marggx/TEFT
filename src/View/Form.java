package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;

public class Form extends JPanel {

    private JTextArea textField;

    private JButton inputButton;
    private JButton viewButton;

    public Form() {

        JLabel textLabel = new JLabel("Text:");
        JLabel lastnameLabel = new JLabel("Data:");
        JSeparator separator = new JSeparator(SwingConstants.VERTICAL);

        textField = new JTextArea(20, 20);

        inputButton = new JButton("Select File");
        inputButton.setPreferredSize(new Dimension(278, 40));
        viewButton = new JButton("View All Users");
        viewButton.setPreferredSize(new Dimension(278, 40));

        Insets inset = new Insets(10, 10, 10, 10);

        // uses Grid Bag Layout
        setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = inset;
        gridBagConstraints.fill = GridBagConstraints.NONE;

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.CENTER;

        add(textLabel, gridBagConstraints);

        gridBagConstraints.gridy = 1;

        add(inputButton, gridBagConstraints);

        gridBagConstraints.gridy = 2;

        add(textField, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;

        add(separator, gridBagConstraints);

        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;

        add(lastnameLabel, gridBagConstraints);

        gridBagConstraints.gridy = 1;

        add(viewButton, gridBagConstraints);
    }

    // getters
    public String getFirstname() {
        return textField.getText();
    }

    public void submitUsers(ActionListener actionListener) {
        inputButton.addActionListener(actionListener);
    }

    public void viewUsers(ActionListener actionListener) {
        viewButton.addActionListener(actionListener);
    }

    // reset fields
    public void reset(boolean bln) {
        if (bln) {
            textField.setText("");
        }
    }
}
