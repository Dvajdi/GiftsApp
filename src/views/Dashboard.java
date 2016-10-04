package views;

import controllers.PaintClick;

import javax.swing.*;
import java.awt.*;

public class Dashboard extends JFrame {
  public Dashboard(String title) throws HeadlessException {
    super(title);
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    this.setVisible(true);
    this.setSize(300,300);
    this.setLocationRelativeTo(null);
    this.setExtendedState(JFrame.MAXIMIZED_BOTH);

    DrawPanel dp = new DrawPanel();
    this.getContentPane().add(BorderLayout.CENTER,dp);

    JButton btnRepaint = new JButton("Перерисовать");
    btnRepaint.addActionListener(new PaintClick(dp));
    this.getContentPane().add(BorderLayout.SOUTH,btnRepaint);

  }
}
