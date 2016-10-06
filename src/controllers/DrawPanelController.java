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

    new AnimationThread(dx,dy);

  }

  @Override
  public void actionPerformed(ActionEvent e) {

    drawPanel.reloadColors();
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
      int i=0;
      int d =500;
      int arrow=1;
      try{
      while(true) {
        if(i<d){d=500; i++;}else{d=0;if(i>d){i--;}else{d=500;arrow=(int)(Math.random()*4);}}
        if(arrow%4==0){
          x=i;
          y=-i;
        }else{
          if(arrow%3==0){
            x=-i;
            y=i;
          }else{
            if(arrow%2==0){
              x=-i;
              y=-i;
            }else{
              x=i;
              y=i;
            }
          }

        }


        setXandY(x,y);
        Thread.sleep(15);
        drawPanel.repaint();

      }
      }catch(InterruptedException e){}
    }
  }
}
