package views;/*
 Created by Павел on 03.10.2016.
*/

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

  }
}
