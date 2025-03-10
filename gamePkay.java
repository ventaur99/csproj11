/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csproj;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gamePkay extends JFrame {
    public gamePkay() {
        setTitle("MGA DIYOS AT DIYOSA");
        setSize(1100, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        add(new GamePanel()); 

        setVisible(true);
    }

    public static void main(String[] args) {
        new gamePkay();
    }
}

class GamePanel extends JPanel {
    private Image brickImage;
    private JButton redButton, yellowButton, orangeButton, greenButton, blueButton, pinkButton;

    public GamePanel() {
        setLayout(null);

        
        brickImage = new ImageIcon(getClass().getResource("/images/brick.png")).getImage();

        
        redButton = createButton("/images/red.png", 250, 150);
        yellowButton = createButton("/images/yellow.png", 450, 150);
        orangeButton = createButton("/images/orange.png", 650, 150);
        greenButton = createButton("/images/green.png", 300, 350);
        blueButton = createButton("/images/blue.png", 600, 350);
        pinkButton = createButton("/images/pink.png", 450, 500);

        
        add(redButton);
        add(yellowButton);
        add(orangeButton);
        add(greenButton);
        add(blueButton);
        add(pinkButton);
    }

    private JButton createButton(String imagePath, int x, int y) {
        ImageIcon icon = new ImageIcon(getClass().getResource(imagePath)); 
        JButton button = new JButton(icon);
        button.setBounds(x, y, icon.getIconWidth(), icon.getIconHeight());
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.addActionListener(new ButtonClickListener());
        return button;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(brickImage, 0, 0, getWidth(), getHeight(), this);
    }
}


class ButtonClickListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        JOptionPane.showMessageDialog(null, "You selected: " + source.getIcon().toString());
    }
}

