/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csproj;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainmenu extends JFrame {
    public mainmenu() {
        setTitle("Main Menu");
        setSize(800, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        GamePanel panel = new GamePanel(this);
        add(panel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new mainmenu();
    }
}

class GamePanel extends JPanel {
    private Image backgroundImage, treeImage, graveImage;
    private JButton startButton, settingsButton;
    private JFrame parentFrame;

    public GamePanel(JFrame parentFrame) {
        this.parentFrame = parentFrame;
        setLayout(null);

        backgroundImage = new ImageIcon(getClass().getResource("/images/Background.png")).getImage();
        treeImage = new ImageIcon(getClass().getResource("/images/E1.png")).getImage();
        graveImage = new ImageIcon(getClass().getResource("/images/E2.png")).getImage();

        startButton = new JButton("START");
        settingsButton = new JButton("SETTINGS");

        setupButton(startButton, 520, 150);
        setupButton(settingsButton, 520, 220);

        add(startButton);
        add(settingsButton);

        // **FIX: Start button now properly opens Gameplay**
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Game Started!");
                parentFrame.dispose();  
                new Gameplay(); 
            }
        });

        settingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Settings Opened!");
            }
        });
    }

    private void setupButton(JButton button, int x, int y) {
        button.setBounds(x, y, 140, 50);
        button.setBackground(new Color(0, 0, 0, 150));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Pixel", Font.BOLD, 20));
        button.setFocusPainted(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        g.drawImage(treeImage, 30, 40, 480, 450, this);

        int graveX = 420;
        int graveY = 90;
        int graveWidth = 300;
        int graveHeight = 300;
        g.drawImage(graveImage, graveX, graveY, graveWidth, graveHeight, this);

        startButton.setBounds(graveX + 140, graveY + 65, 100, 35);
        settingsButton.setBounds(graveX + 138, graveY + 135, 100, 50);
    }
}
