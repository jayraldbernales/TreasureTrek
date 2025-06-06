package main;


import java.awt.Font;
import java.awt.GraphicsEnvironment;
import javax.swing.JFrame;


/**
 *
 * @author jayrald
 */

public class Main {
  
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Treasure Trek");
        String[] fontNames = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
	for(String fontName:fontNames)
			System.out.println();
        
        GamePanel gamePanel = new GamePanel();
        gamePanel.setFont(new Font("MV Boli", Font.BOLD, 24));
        window.add(gamePanel);
        window.pack();
        
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        
        gamePanel.setUpGame();
        gamePanel.startGameThread();
    
    }
    
}