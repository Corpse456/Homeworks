package com.itStep.home34.notebook.graph.listeners;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ButtonListener extends MouseAdapter {

    private JButton button;

    public ButtonListener(JButton button) {
        this.button = button;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        button.setFocusPainted(true);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        button.setFocusPainted(false);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        button.setForeground(Color.BLUE);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        button.setForeground(Color.BLACK);
    }
}
