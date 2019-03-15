import javax.sound.midi.*;

public class MiniMusicPlayer1 implements ControllerEventListener {
    public static void main (String[] args) {
        MiniMusicPlayer1 mini = new MiniMusicPlayer1();
        mini.go();
    }

    public void go() {
        try {

            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();

            int[] eventsIWant = {127};  // Listen for ControllerEvents, code 127
            sequencer.addControllerEventListener(this, eventsIWant);

            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();

            for (int i = 5; i < 61; i += 4) {
                track.add( makeEvent(176,1,127,100,i) ); // Add a ControllerEvent per note
                track.add( makeEvent(144,1,i,100,i) );
                track.add( makeEvent(128,1,i,100,i+2) );
            }

            sequencer.setSequence(seq);
            sequencer.setTempoInBPM(220);
            sequencer.start();
        }
        catch (Exception ex) { ex.printStackTrace(); }
    }

    public void controlChange(ShortMessage event) {
        System.out.println("la");
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
