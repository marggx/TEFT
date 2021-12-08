package Controller;

import View.Form;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileController {
    private Form form;

    public FileController(Form form) {
        this.form = form;
        this.form.selectFile(e -> {
            //limit File Opener only text files
            FileNameExtensionFilter fileFilter = new FileNameExtensionFilter("Text Files", "txt", "text");
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileFilter(fileFilter);
            // select file to open
            fileChooser.showOpenDialog(null);
        });

        this.form.selectData(e -> {
            //limit File Opener only text files
            FileNameExtensionFilter fileFilter = new FileNameExtensionFilter("Text Files", "txt", "text");
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileFilter(fileFilter);
            // select Data file to open
            fileChooser.showOpenDialog(null);
        });
    }
}
