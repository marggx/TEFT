package View;

import Controller.FileController;
import Controller.TextController;
import org.w3c.dom.Text;

import javax.swing.*;
import java.awt.*;
import com.formdev.flatlaf.*;

public class MainFrame extends JFrame {


    public MainFrame() {
        super("TEFT");
        FlatDarculaLaf.install();
        // Card layout for switching vie
        CardLayout cardLayout = new CardLayout();
        Form form = new Form();
        // sets our layout as a card layout
        setLayout(cardLayout);

        // initialize file controller
        new FileController(form);
        new TextController(form);

        // adds view to card layout with unique constraints
        add(form, "form");

        // icon for our application
        ImageIcon imageIcon = new ImageIcon("src/assets/appicon.png");
        setIconImage(imageIcon.getImage());
        // frame width & height
        int FRAME_WIDTH = 800;
        int FRAME_HEIGHT = 900;
        // size of our application frame
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setMinimumSize(new Dimension(700, 700));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
