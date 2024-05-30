package org.example.gofDesign.observer_pattern;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SwingObserverExample {
    public static void main(String[] args) {
        SwingObserverExample example = new SwingObserverExample();
        example.go();
    }

    private void go() {
        JFrame frame = new JFrame();

        JButton button = new JButton("do it? or not?");

        button.addActionListener(event -> System.out.println("don't do it"));
        button.addActionListener(event -> System.out.println("do it!"));

        frame.getContentPane().add(button);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}