package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Form extends JPanel {
    public JButton selectFileButton;
    private JTextArea textField;
    private JButton selectDataButton;

    public Form() {

        JLabel textLabel = new JLabel("Text:");
        JLabel dataLabel = new JLabel("Data: "); //TODO CHANGE NAME
        JSeparator separator = new JSeparator(SwingConstants.VERTICAL);
        textField = new JTextArea(20, 20);
        selectFileButton = new JButton("Select File");
        selectFileButton.setPreferredSize(new Dimension(278, 40));
        selectDataButton = new JButton("Select Data File");
        selectDataButton.setPreferredSize(new Dimension(278, 40));

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

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        add(selectFileButton, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        add(textField, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        add(separator, gridBagConstraints);

        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        add(dataLabel, gridBagConstraints);

        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        add(selectDataButton, gridBagConstraints);
    }

    public void selectFile(ActionListener actionListener) {
        selectFileButton.addActionListener(actionListener);
    }

    public void selectData(ActionListener actionListener) {
        selectDataButton.addActionListener(actionListener);
    }
}
