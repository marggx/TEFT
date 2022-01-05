package Controller;

import View.Form;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
            File file = fileChooser.getSelectedFile();
            String fileContent = "";
            Scanner scan = null;
            try {
                scan = new Scanner(file);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
            while (scan.hasNextLine()) {
                fileContent = fileContent.concat(scan.nextLine() + "\n");
            }

            this.form.showOutput(fileContent);
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
