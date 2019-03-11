import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ColourClick implements ActionListener {

    JFrame frame = new JFrame();

    public static void main (String[] args) {
        ColourClick gui = new ColourClick();
        gui.go();
    }

    public void go () {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton button = new JButton("Click me");
        button.addActionListener(this);

        MyDrawPanel panel = new MyDrawPanel();

        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.getContentPane().add(BorderLayout.SOUTH, button);

        frame.setSize(300,300);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        frame.repaint();
    }
}
