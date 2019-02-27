import javax.swing.*;

public class SimpleGUI1 {
    public static void main (String[] args) {
        // Create frame for widgets
        JFrame frame = new JFrame();

        // Create button widget
        JButton button = new JButton("Click me");

        // Make app terminate on close of frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Put button into app
        frame.getContentPane().add(button);

        frame.setSize(300,300);

        frame.setVisible(true);
    }
}
