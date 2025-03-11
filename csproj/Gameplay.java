/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csproj;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gameplay extends JFrame {
    public Gameplay() {
        setTitle("MGA DYOS AT DIYOSA");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        add(new GameplayPanel()); 

        setVisible(true);
    }

    public static void main(String[] args) {
        new Gameplay();
    }
}

class GameplayPanel extends JPanel {
    private Image backgroundImage;
    private JButton redButton, yellowButton, orangeButton, greenButton, blueButton, pinkButton, leftButton, rightButton;

    public GameplayPanel() {
        setLayout(null);

        backgroundImage = new ImageIcon(getClass().getResource("/images/brick.png")).getImage();

        redButton = createButton("/images/red.png", 30, 120, "Binabati Kita! Ito ang iyong napili!");
        yellowButton = createButton("/images/yellow.png", 240, 120, "Binabati Kita! Ito ang iyong napili!");
        orangeButton = createButton("/images/orange.png", 450, 120, "Binabati Kita! Ito ang iyong napili!");
        greenButton = createButton("/images/green.png", 200, 180, "Binabati Kita! Ito ang iyong napili!");
        blueButton = createButton("/images/blue.png", 270, 180, "Binabati Kita! Ito ang iyong napili!");
        pinkButton = createButton("/images/pink.png", 240, 350, "Binabati Kita! Ito ang iyong napili!");
        leftButton = createButton("/images/left.png", 30, 370, "Go back to Menu");
        rightButton = createButton("/images/right.png", 460, 370, "Proceed..");

        add(redButton);
        add(yellowButton);
        add(orangeButton);
        add(greenButton);
        add(blueButton);
        add(pinkButton);
        add(leftButton);
        add(rightButton);
    }

    private JButton createButton(String imagePath, int x, int y, String message) {
        ImageIcon icon = new ImageIcon(getClass().getResource(imagePath));
        if (icon.getImage() == null) {
            System.out.println("Error: Could not load image at " + imagePath);
            return new JButton("Error");
        }

        Image scaledImage = icon.getImage().getScaledInstance(500, 300, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        JButton button = new JButton(scaledIcon);
        button.setBounds(x, y, 500, 300);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        if (message.equals("Proceed..")) { 
        button.addActionListener(e -> {
            new Duwende(); 
            SwingUtilities.getWindowAncestor(button).dispose(); 
        });
    } else if (message.equals("Go back to Menu")) { 
        button.addActionListener(e -> {
            new mainmenu(); 
            SwingUtilities.getWindowAncestor(button).dispose();
        });
    } else {
        button.addActionListener(new ButtonClickListener(message));
    }

    return button;
}
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
}

class ButtonClickListener implements ActionListener {
    private String message;

    public ButtonClickListener(String message) {
        this.message = "<html><body style='text-align:center; font-size:14px;'>" +
                       "<b><font color='light blue'>" + message + "</font></b></body></html>";;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, message, "Message", JOptionPane.INFORMATION_MESSAGE);
    }
}
