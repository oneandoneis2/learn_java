import javax.swing.*;
import java.awt.event.*;

public class SimpleGUI2 {

    MyDrawPanel panel;

    public static void main (String[] args) {
        SimpleGUI2 gui = new SimpleGUI2();
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
