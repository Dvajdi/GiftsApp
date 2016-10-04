package views;

import javax.swing.*;
import java.awt.*;


// Created by twice on 04.10.16.

public class DrawPanel extends JPanel {
  @Override
  protected void paintComponent(Graphics g) {
    Image image = new ImageIcon("src/res/icon.png").getImage();
    g.drawImage(image,0,0,this);

    g.setColor(Color.ORANGE);
    g.fillRect(70,70,100,100);
    Graphics2D graphics2D = (Graphics2D)g;
    graphics2D.draw3DRect(150,150,100,100,true);

    Color first = new Color(newRandom255(),newRandom255(),newRandom255());
    Color second = new Color(newRandom255(),newRandom255(),newRandom255());
    GradientPaint gd = new GradientPaint(300,300,first,600,600,second);
    graphics2D.setPaint(gd);
    graphics2D.fillOval(300,300,300,300);
  }

  int newRandom255(){
    return (int) (Math.random()*255);
  }
}
