package views;

import controllers.DrawPanelController;

import javax.swing.*;
import java.awt.*;

public class Dashboard extends JFrame {
  public Dashboard(String title) throws HeadlessException {
    super(title);
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    this.setVisible(true);
    this.setSize(500,500);
    this.setLocationRelativeTo(null);
    //this.setExtendedState(JFrame.MAXIMIZED_BOTH);

    DrawPanel dp = new DrawPanel();
    JButton btnRepaint = new JButton("Перерисовать");

    BorderLayout bl = new BorderLayout();

    bl.addLayoutComponent(BorderLayout.CENTER,dp);
    bl.addLayoutComponent(BorderLayout.WEST,btnRepaint);

    this.getContentPane().setLayout(bl);



    this.getContentPane().add(BorderLayout.EAST,btnRepaint);

    btnRepaint.addActionListener(new DrawPanelController(dp,10));


  }
}
