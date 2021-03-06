package views;

import javax.swing.*;
import java.awt.*;


// Created by twice on 04.10.16.

public class DrawPanel extends JPanel {
  private int dx=0,dy=0;
  Image image;
  Color first,second;
  Graphics2D graphics2D;
  GradientPaint gd;

  public DrawPanel() {
    image = new ImageIcon("src/res/r.jpg").getImage();
    first = new Color(255,0,0);
    second = new Color(0,255,0);
  }

  public void reloadColors(){
    System.out.println("кликается");
    first = new Color(newRandom255(),newRandom255(),newRandom255());
    second = new Color(newRandom255(),newRandom255(),newRandom255());
  }

  @Override
  protected void paintComponent(Graphics g) {

    g.setColor(Color.WHITE);
    g.fillRect(0,0,this.getWidth(),this.getHeight());
    graphics2D= (Graphics2D) g;
    g.drawImage(image,0,0,this);
    gd = new GradientPaint(dx,dy,first,dx+300,dy+300,second);
    graphics2D.setPaint(gd);
    graphics2D.fillOval(dx,dy,300,300);
  }

  public void setX(int dx) {
    this.dx = dx;
  }

  public void setY(int dy) {
    this.dy = dy;
  }

    private int newRandom255(){
    return (int) (Math.random()*255);
  }
}
