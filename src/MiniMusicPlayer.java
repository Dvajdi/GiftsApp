// Created by twice on 05.10.16.

import views.MusicDrawPanel;

import javax.sound.midi.*;
import javax.swing.*;

public class MiniMusicPlayer{
  static JFrame f = new JFrame("КЛИП");
  static MusicDrawPanel md;

  public static void main(String[] args) {
    (new MiniMusicPlayer()).go();
  }

  public void setUpGui(){
    md=new MusicDrawPanel();
    f.setContentPane(md);
    f.setBounds(30,30,300,300);
    f.setVisible(true);
  }

  public void go(){
    setUpGui();

    try {
      Sequencer sequencer = MidiSystem.getSequencer();
      sequencer.open();
      sequencer.addControllerEventListener(md,new int []{127});

      Sequence seq = new Sequence(Sequence.PPQ, 4);
      Track track = seq.createTrack();

      int r=0;
      for (int i = 5; i < 60; i+=4) {
        r=(int)((Math.random()*50)+1);
        track.add(makeEvent(144, 1, r, 100, i));
        track.add(makeEvent(176, 1, 127, 0, i));
        track.add(makeEvent(128, 1, r, 100, i + 2));
      }

      sequencer.setSequence(seq);
      sequencer.start();
      sequencer.setTempoInBPM(220);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  public static MidiEvent makeEvent(int comd,int chan,int one,int two,int tick){
    MidiEvent event = null;
    try{
      ShortMessage a = new ShortMessage();
      a.setMessage(comd,chan,one,two);
      event = new MidiEvent(a, tick);
    }catch(Exception e){}
    return event;
  }


}
