package controllers;
// Created by twice on 04.10.16.

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaintClick implements ActionListener {
  JPanel jp;

  public PaintClick(JPanel jp) {
    this.jp = jp;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    jp.repaint();
  }
}
