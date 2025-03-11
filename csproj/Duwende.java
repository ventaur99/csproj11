/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csproj;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Duwende extends JFrame {
    public Duwende() {
        setTitle("LEVEL 1: Tiyanak");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(new TiyanakPanel());
        setVisible(true);
    }

    public static void main(String[] args) {
        new Duwende();
    }
}

class TiyanakPanel extends JPanel {
    private Image caveImage, userImage, elfImage, de4Image, de5Image;
    private JButton menuButton, ngameButton, quitButton, leftButton, rightButton;

    public TiyanakPanel() {
        setLayout(null);
        setOpaque(false);

        // Load images properly
        caveImage = new ImageIcon(getClass().getResource("/images/cave.png")).getImage();
        userImage = new ImageIcon(getClass().getResource("/images/user.png")).getImage();
        elfImage = new ImageIcon(getClass().getResource("/images/elf.png")).getImage();
        de4Image = new ImageIcon(getClass().getResource("/images/DE4.png")).getImage();
        de5Image = new ImageIcon(getClass().getResource("/images/DE5.png")).getImage();

        // Create buttons with proper image loading
        menuButton = createImageButton("/images/menu.png", "Back to Menu");
        ngameButton = createImageButton("/images/ngame.png", "Start New Game");
        quitButton = createImageButton("/images/quit.png", "Quit Game");
        leftButton = createImageButton("/images/left.png", "PREVIOUS"); 
        rightButton = createImageButton("/images/right.png", "NEXT LEVEL");

        // Set bounds
        menuButton.setBounds(50, 210, 710, 500);
        ngameButton.setBounds(98, 210, 710, 500);
        quitButton.setBounds(500, 214, 710, 500);
        leftButton.setBounds(40, 210, 710, 500);
        rightButton.setBounds(300, 210, 710, 500);

        // Button actions
        quitButton.addActionListener(e -> System.exit(0));
        ngameButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "Starting a new game..."));
        menuButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "Back to Menu"));
        leftButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "Go Back"));
        rightButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "Next Level"));

        // Add buttons to panel
        add(menuButton);
        add(ngameButton);
        add(quitButton);
        add(leftButton);
        add(rightButton);
    }

    private JButton createImageButton(String imagePath, String tooltip) {
        ImageIcon icon = new ImageIcon(getClass().getResource(imagePath)); 
        JButton button = new JButton(icon);
        button.setToolTipText(tooltip);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        return button;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw images with proper dimensions
        g.drawImage(caveImage, 0, 0, getWidth(), getHeight(), this);
        g.drawImage(userImage, 20, 100, 690, 500, this);
        g.drawImage(elfImage, 270, 100, 690, 500, this);
        g.drawImage(de4Image, 40, 100, 620, 600, this);
        g.drawImage(de5Image, 330, 80, 620, 600, this);
    }
}


  