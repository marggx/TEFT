package Controller;

import Model.Database;
import Model.User;
import View.Form;
import View.InputDetails;

import javax.swing.*;
import java.io.File;

public class UserController {
    // database file
    private String databaseFile = "src\\data\\database.txt";
    private Database database;
    private Form form;
    private InputDetails inputDetails;

    public UserController(Form form, InputDetails inputDetails) {
        this.database = new Database();
        this.form = form;
        this.inputDetails = inputDetails;

        // submit user
        this.form.submitUsers(e -> {
            String firstname = this.form.getFirstname().trim();

            // simple validations
            if (firstname.isEmpty()) {
                JOptionPane.showMessageDialog(this.form, "First Name Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            this.database.saveUser(new File(databaseFile));
            this.form.reset(true);
        });

        // load users
        this.form.viewUsers(e -> {
            this.inputDetails.getUsers(this.database.loadUsers(new File(databaseFile)));
        });
    }
}
