package com.Calculator;

import javax.swing.*;

public class Main {

    public Main () {
        JFrame window = new JFrame("Калькулятор");
        window.setSize(255,373);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.add(new Panel());
        window.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
}