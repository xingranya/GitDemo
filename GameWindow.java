import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    private GameCanvas canvas;

    public GameWindow() {
        setTitle("坦克大战");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        canvas = new GameCanvas();
        add(canvas);

        setVisible(true);
        new Thread(canvas).start();
    }

    public static void main(String[] args) {
        new GameWindow();
    }
}