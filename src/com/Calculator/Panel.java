package com.Calculator;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Panel extends JPanel implements ActionListener{

    private Font font = new Font("", Font.BOLD, 20);
    private Font font2 = new Font("", Font.BOLD, 14);
    private JButton[] button = new JButton[18];
    private JTextField text;
    private JTextField textHide;

    Panel() {

        setLayout(null);

        for (int i = 0; i < 9; i++) {
            int y = 0;
            int x = i;
            if (i > 2) y = 1;
            if (i > 5) y = 2;
            if (y >= 1) x = i - 3;
            if (y >= 2) x = i - 6;
            button[i+1] = new JButton(i + 1 + "");
            button[i+1].setBounds(x * 60 + 10, 190 - y * 60 ,50,50);
            button[i+1].setFont(font);
            add(button[i+1]);
        }

        text = new JTextField();

        textHide = new JTextField("");
        textHide.setEditable(false);
        textHide.setBounds(10,10,230,50);
        add(textHide);

        button[0] = new JButton("0");
        button[0].setBounds(70,250,50,50);
        button[0].setFont(font);
        add(button[0]);


        button[10] = new JButton("+");
        button[10].setBounds(190,70,50,50);
        button[10].setFont(font);
        add(button[10]);

        button[11] = new JButton("-");
        button[11].setBounds(190,130,50,50);
        button[11].setFont(font);
        add(button[11]);

        button[12] = new JButton("*");
        button[12].setBounds(190,190,50,50);
        button[12].setFont(font);
        add(button[12]);

        button[13] = new JButton("/");
        button[13].setBounds(190,250,50,50);
        button[13].setFont(font);
        add(button[13]);

        button[14] = new JButton(".");
        button[14].setBounds(10,250,50,50);
        button[14].setFont(font);
        add(button[14]);

        button[15] = new JButton("=");
        button[15].setBounds(130,250,50,50);
        button[15].setFont(font);
        add(button[15]);

        button[16] = new JButton("C");
        button[16].setBounds(10, 310,110,25);
        button[16].setFont(font);
        add(button[16]);

        button[17] = new JButton("<");
        button[17].setBounds(130, 310,110,25);
        button[17].setFont(font);
        add(button[17]);

        for (int i = 0; i < 18; i++) button[i].addActionListener(this);
    }

    private static double a;
    private static double result;
    private static int operator=0;

    @Override
    public void actionPerformed(ActionEvent e) {
        textHide.setFont(font);

        if (operator == 0) {
            if (e.getSource() == button[10]) textHide.setText(textHide.getText().concat("+"));
            if (e.getSource() == button[11]) textHide.setText(textHide.getText().concat("-"));
            if (e.getSource() == button[12]) textHide.setText(textHide.getText().concat("*"));
            if (e.getSource() == button[13]) textHide.setText(textHide.getText().concat(":"));
        }
        if (e.getSource() == button[14]) textHide.setText(textHide.getText().concat("."));
        if (e.getSource() == button[14]) text.setText(text.getText().concat("."));

        for (int i = 0; i < 10; i++) {
            if (e.getSource() == button[i]) text.setText(text.getText().concat(i + ""));
        }

        for (int i = 0; i < 10; i++) {
            if (e.getSource() == button[i]) textHide.setText(textHide.getText().concat(i + ""));
        }

        if (operator == 0) {
            if (e.getSource() == button[10]) {
                a = Double.parseDouble(text.getText());
                operator = 1;
                text.setText("");
            }

            if (e.getSource() == button[11]) {
                a = Double.parseDouble(text.getText());
                operator = 2;
                text.setText("");
            }

            if (e.getSource() == button[12]) {
                a = Double.parseDouble(text.getText());
                operator = 3;
                text.setText("");
            }

            if (e.getSource() == button[13]) {
                a = Double.parseDouble(text.getText());
                operator = 4;
                text.setText("");
            }
        }

        if (e.getSource() == button[15]) {
            double b = Double.parseDouble(text.getText());
            switch (operator) {
                case 1 : result=a+ b;
                    operator = 0;
                    break;

                case 2 : result=a- b;
                    operator = 0;
                    break;

                case 3 : result=a* b;
                    operator = 0;
                    break;

                case 4 : result=a/ b;
                    operator = 0;
                    break;
            }

            textHide.setText(result + "");

            if (result == (int)result) {
                int result2;
                result2 = (int) result;
                textHide.setText(result2 + "");
            }

            a = Double.parseDouble(textHide.getText());
            text.setText("" + a);

            if (b == 0 && operator == 4) {
                textHide.setText("Дибил на ноль делить нельзя!");
                textHide.setFont(font2);
            }
        }

        if (e.getSource() == button[16]) textHide.setText("");
        if (e.getSource() == button[16]) text.setText("");

        if(e.getSource()== button[17]) {
            String s=textHide.getText();
            String z=text.getText();
            textHide.setText("");
            text.setText("");
            for(int i=0;i<s.length()-1;i++) textHide.setText(textHide.getText()+s.charAt(i));
            for(int i=0;i<z.length()-1;i++) text.setText(text.getText()+z.charAt(i));
        }
    }
}
