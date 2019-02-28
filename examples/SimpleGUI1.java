import javax.swing.*;
import java.awt.event.*;

public class SimpleGUI1 implements ActionListener {

    JButton button;

    public static void main (String[] args) {
        SimpleGUI1 gui = new SimpleGUI1();
        gui.go();
    }

    public void go () {
        // Create frame for widgets
        JFrame frame = new JFrame();

        // Create button widget
        button = new JButton("Click me");

        // Add a listener to the button
        button.addActionListener(this);

        // Make app terminate on close of frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Put button into app
        frame.getContentPane().add(button);

        frame.setSize(300,300);

        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        button.setText("I've been clicked!");
    }
}
