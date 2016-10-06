package views;

import controllers.DrawPanelController;

import javax.swing.*;
import java.awt.*;

public class Dashboard extends JFrame {
  public Dashboard(String title) throws HeadlessException {
    super(title);
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    this.setVisible(true);
    this.setSize(1000,500);
    this.setLocationRelativeTo(null);
    //this.setExtendedState(JFrame.MAXIMIZED_BOTH);

    JButton btnRepaint = new JButton("Перерисовать");
    btnRepaint.setSize(100,200);
    this.getContentPane().add(BorderLayout.EAST,btnRepaint);

    DrawPanel dp = new DrawPanel();
    this.getContentPane().add(BorderLayout.CENTER,dp);
    DrawPanelController dpc = new DrawPanelController(dp,10);



    btnRepaint.addActionListener(dpc);


  }
}
