package Controller;

import View.Form;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileController {

    public FileController(Form form) {
        form.selectFile(e -> {
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

            form.showOutput(fileContent);
        });

        form.selectData(e -> {
            //limit File Opener only text files
            FileNameExtensionFilter fileFilter = new FileNameExtensionFilter("JSON Files", "json", "json");
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileFilter(fileFilter);
            // select Data file to open
            fileChooser.showOpenDialog(null);

            File file = fileChooser.getSelectedFile();

            JSONParser parser = new JSONParser();
            try {
               form.json = (JSONObject) parser.parse(new FileReader(file));

            } catch (IOException | ParseException ex) {
                ex.printStackTrace();
            }

        });
    }
}
