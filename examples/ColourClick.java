import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ColourClick {

    JFrame frame = new JFrame();
    JLabel label;

    public static void main (String[] args) {
        ColourClick gui = new ColourClick();
        gui.go();
    }

    public void go () {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton labelButton = new JButton("Change label");
        labelButton.addActionListener(new LabelListener());

        JButton colorButton = new JButton("Change colour");
        colorButton.addActionListener(new ColorListener());

        label = new JLabel("I'm a label!");
        MyDrawPanel panel = new MyDrawPanel();

        frame.getContentPane().add(BorderLayout.EAST, labelButton);
        frame.getContentPane().add(BorderLayout.WEST, label);
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.getContentPane().add(BorderLayout.SOUTH, colorButton);

        frame.setSize(300,300);
        frame.setVisible(true);
    }

    class LabelListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            label.setText("Oooo!");
        }
    }

    class ColorListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            frame.repaint();
        }
    }
}
