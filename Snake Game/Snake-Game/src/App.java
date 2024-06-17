import javax.swing.*;
import java.awt.*;

public class App {
    public static void main(String[] args) {
        int boardWidth = 600;
        int boardHeight = 600;

        JFrame frame = new JFrame("Snake Game");
        frame.setSize(boardWidth, boardHeight + 100); 
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SnakeGame snakeGame = new SnakeGame(boardWidth, boardHeight);
        frame.add(snakeGame, BorderLayout.CENTER);

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        JSlider speedSlider = new JSlider(50, 200, 100);
        speedSlider.setMajorTickSpacing(50);
        speedSlider.setPaintTicks(true);
        speedSlider.setPaintLabels(true);
        speedSlider.addChangeListener(e -> snakeGame.setGameSpeed(speedSlider.getValue()));
        controlPanel.add(new JLabel("Speed:"));
        controlPanel.add(speedSlider);

        JButton restartButton = new JButton("Restart");
        restartButton.addActionListener(e -> snakeGame.restartGame());
        controlPanel.add(restartButton);

        frame.add(controlPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
        snakeGame.requestFocus();
    }
}
