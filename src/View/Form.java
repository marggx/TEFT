package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Form extends JPanel {
    public JButton selectFileButton;
    private JTextArea textField;
    private JButton selectDataButton;
    private JButton processDatabutton;
    private JButton saveDataButton;

    public Form() {

        com.formdev.flatlaf.FlatDarculaLaf.install();

        JLabel textLabel = new JLabel("Text:");
        JLabel dataLabel = new JLabel("Data: ");
        JSeparator separatorMid = new JSeparator(SwingConstants.VERTICAL);
        separatorMid.setPreferredSize(new Dimension(20, 0));
        JSeparator separatorHorizontal = new JSeparator(SwingConstants.HORIZONTAL);
        separatorHorizontal.setPreferredSize(new Dimension(278, 30));
        textField = new JTextArea(30, 30);
        selectFileButton = new JButton("Select File");
        selectFileButton.setPreferredSize(new Dimension(278, 40));
        selectFileButton.setToolTipText("Select a File to see the text");
        selectDataButton = new JButton("Select Data File");
        selectDataButton.setPreferredSize(new Dimension(278, 40));
        selectDataButton.setToolTipText("Select a Data file");
        processDatabutton = new JButton("Process");
        processDatabutton.setPreferredSize(new Dimension(278, 40));
        processDatabutton.setToolTipText("Process the file");
        saveDataButton = new JButton("Save");
        saveDataButton.setPreferredSize(new Dimension(270, 40));

        Insets inset = new Insets(5, 5, 5, 5);

        // uses Grid Bag Layout
        setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = inset;


        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 1;
        gridBagConstraints.gridwidth = 1;
        add(textLabel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 1;
        gridBagConstraints.gridwidth = 1;
        add(selectFileButton, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = GridBagConstraints.REMAINDER;
        //gridBagConstraints.gridwidth = 1;
        add(textField, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.fill = GridBagConstraints.VERTICAL;
        add(separatorMid, gridBagConstraints);

        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 1;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.fill = GridBagConstraints.NONE;
        add(dataLabel, gridBagConstraints);

        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 1;
        gridBagConstraints.gridwidth = 1;
        add(selectDataButton, gridBagConstraints);

        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 1;
        gridBagConstraints.gridwidth = 1;
        add(separatorHorizontal, gridBagConstraints);

        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridheight = 1;
        gridBagConstraints.gridwidth = 1;

        add(processDatabutton, gridBagConstraints);

        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = GridBagConstraints.NORTH;
        gridBagConstraints.insets = new Insets(40, 0, 250, 0);
        gridBagConstraints.gridheight = GridBagConstraints.REMAINDER;
        gridBagConstraints.gridwidth = 1;
        add(saveDataButton, gridBagConstraints);
    }

    public void selectFile(ActionListener actionListener) {
        selectFileButton.addActionListener(actionListener);
    }

    public void selectData(ActionListener actionListener) {
        selectDataButton.addActionListener(actionListener);
    }

    public void showOutput(String output) {
        textField.setText(output);
    }
}
