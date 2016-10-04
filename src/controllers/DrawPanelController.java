package controllers;
// Created by twice on 04.10.16.

import views.DrawPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrawPanelController implements ActionListener {
  DrawPanel drawPanel;
  int id;
  int dx,dy;

  public DrawPanelController(DrawPanel drawPanel, int id) {
    this.id = id;
    this.drawPanel = drawPanel;

    AnimationThread at = new AnimationThread(dx,dy);
    at.run();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if(id == 10){
      System.out.println("привет");
    }
    drawPanel.repaint();
  }

  void setXandY(int x,int y){
    drawPanel.setX(x);
    drawPanel.setY(y);
  }

  class AnimationThread implements Runnable{
    int x, y;

    public AnimationThread(int x,int y) {
      this.x=x;
      this.y=y;
      Thread t= new Thread(this,"анимация");
      t.start();
    }

    @Override
    public void run() {
      for (int i = 0; i <100 ; i++) {
        x+=1;
        y+=1;
        setXandY(x,y);
        drawPanel.repaint();
        try{
        Thread.sleep(50);}catch(InterruptedException e){}
      }
    }
  }
}
