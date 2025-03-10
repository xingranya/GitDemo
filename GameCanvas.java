import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameCanvas extends JPanel implements Runnable {
    private PlayerTank playerTank;
    private boolean isRunning = true;

    public GameCanvas() {
        setBackground(Color.BLACK);
        setDoubleBuffered(true);
        playerTank = new PlayerTank(400, 500);
        addKeyListener(new TankKeyListener());
        setFocusable(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        playerTank.draw(g);
    }

    @Override
    public void run() {
        while (isRunning) {
            updateGame();
            repaint();
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void updateGame() {
        playerTank.update();
    }

    class TankKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            playerTank.keyPressed(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            playerTank.keyReleased(e);
        }
    }
}