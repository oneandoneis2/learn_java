import javax.sound.midi.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;

public class MiniMusicPlayer1 {
    static JFrame f = new JFrame("My first music video");
    static MyDrawPanel m1;

    public static void main (String[] args) {
        MiniMusicPlayer1 mini = new MiniMusicPlayer1();
        mini.go();
    }

    public void setUpGui() {
        m1 = new MyDrawPanel();
        f.setContentPane(m1);
        f.setBounds(30,30,300,300);
        f.setVisible(true);
    }

    public void go() {
        setUpGui();

        try {

            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();

            int[] eventsIWant = {127};  // Listen for ControllerEvents, code 127
            sequencer.addControllerEventListener(m1, eventsIWant);

            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();

            int r = 0;
            for (int i = 0; i < 60; i += 4) {
                r = (int) ((Math.random() * 50) + 1);
                track.add( makeEvent(176,1,127,100,i) ); // Add a ControllerEvent per note
                track.add( makeEvent(144,1,r,100,i) );
                track.add( makeEvent(128,1,r,100,i+2) );
            }

            sequencer.setSequence(seq);
            sequencer.setTempoInBPM(120);
            sequencer.start();
        }
        catch (Exception ex) { ex.printStackTrace(); }
    }

    public static MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
        MidiEvent event = null;
        try {
            ShortMessage a = new ShortMessage();
            a.setMessage(comd, chan, one, two);
            event = new MidiEvent(a, tick);
        }
        catch (Exception e) {}
        return event;
    }

}
