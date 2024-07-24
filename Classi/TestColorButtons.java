package packageTicTacToe;

import javax.swing.*;
import java.awt.*;

public class TestColorButtons {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Test Color Buttons");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setLayout(new GridLayout(1, 2));

        JButton buttonX = new JButton("X");
        buttonX.setFont(new Font("Arial", Font.PLAIN, 60));
        buttonX.setForeground(Color.BLUE); // Colore di X
        buttonX.setBackground(Color.WHITE);

        JButton buttonO = new JButton("O");
        buttonO.setFont(new Font("Arial", Font.PLAIN, 60));
        buttonO.setForeground(Color.RED); // Colore di O
        buttonO.setBackground(Color.WHITE);

        frame.add(buttonX);
        frame.add(buttonO);

        frame.setVisible(true);
    }
}