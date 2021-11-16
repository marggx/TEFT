package Controller;

import View.Form;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class UserController {
    private Form form;

    public UserController(Form form) {
        this.form = form;
        this.form.selectFile(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.showOpenDialog(null); // select file to open
            FileNameExtensionFilter fileFilter = new FileNameExtensionFilter("Text Files", "txt", "text");
            fileChooser.setFileFilter(fileFilter);
        });

        this.form.selectData(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.showOpenDialog(null); // select Data file to open
            FileNameExtensionFilter fileFilter = new FileNameExtensionFilter("Text Files", "txt", "text");
            fileChooser.setFileFilter(fileFilter);
        });
    }
}
