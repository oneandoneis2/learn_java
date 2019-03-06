import javax.swing.*;
import java.awt.event.*;

public class SimpleGUI1 {

    MyDrawPanel panel;

    public static void main (String[] args) {
        SimpleGUI1 gui = new SimpleGUI1();
        gui.go();
    }

    public void go () {
        // Create frame for widgets
        JFrame frame = new JFrame();

        // Create panel widget
        panel = new MyDrawPanel();

        // Make app terminate on close of frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Put panel into app
        frame.getContentPane().add(panel);

        frame.setSize(300,300);

        frame.setVisible(true);
    }
}
