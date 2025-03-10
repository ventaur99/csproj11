/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csproj;

import javax.swing.*;
import java.awt.*;

public class gamePkay extends JFrame {
    public gamePkay() {
        setTitle("GODS/GODESSES");
        setSize(800, 490);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        add(new GameScreen());

        setVisible(true);
    }

    public static void main(String[] args) {
        new gamePkay();
    }
}

// Panel to draw the background
class GameScreen extends JPanel {
    private Image backgroundImage;

    public GameScreen() {
        backgroundImage = new ImageIcon(getClass().getResource("/images/brick.png")).getImage();
        System.out.println(getClass().getResource("/csproj/images/brick.png"));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // **FIX: Makes sure panel repaints properly**
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
}
