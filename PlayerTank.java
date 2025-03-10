import java.awt.*;
import java.awt.event.KeyEvent;

public class PlayerTank {
    private int x, y;
    private int speed = 3;
    private boolean movingUp, movingDown, movingLeft, movingRight;
    private int direction = KeyEvent.VK_DOWN;
    
    public PlayerTank(int startX, int startY) {
        this.x = startX;
        this.y = startY;
    }

    public void draw(Graphics g) {
        g.setColor(Color.GREEN);
        // 绘制坦克主体
        g.fillRect(x - 15, y - 15, 30, 30);
        // 绘制炮管
        switch(direction) {
            case KeyEvent.VK_UP:
                g.drawLine(x, y, x, y - 25);
                break;
            case KeyEvent.VK_DOWN:
                g.drawLine(x, y, x, y + 25);
                break;
            case KeyEvent.VK_LEFT:
                g.drawLine(x, y, x - 25, y);
                break;
            case KeyEvent.VK_RIGHT:
                g.drawLine(x, y, x + 25, y);
                break;
        }
    }

    public void update() {
        if(movingUp) {
            y = Math.max(30, y - speed);
            direction = KeyEvent.VK_UP;
        }
        if(movingDown) {
            y = Math.min(570, y + speed);
            direction = KeyEvent.VK_DOWN;
        }
        if(movingLeft) {
            x = Math.max(30, x - speed);
            direction = KeyEvent.VK_LEFT;
        }
        if(movingRight) {
            x = Math.min(770, x + speed);
            direction = KeyEvent.VK_RIGHT;
        }
    }

    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_UP: movingUp = true; break;
            case KeyEvent.VK_DOWN: movingDown = true; break;
            case KeyEvent.VK_LEFT: movingLeft = true; break;
            case KeyEvent.VK_RIGHT: movingRight = true; break;
        }
    }

    public void keyReleased(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_UP: movingUp = false; break;
            case KeyEvent.VK_DOWN: movingDown = false; break;
            case KeyEvent.VK_LEFT: movingLeft = false; break;
            case KeyEvent.VK_RIGHT: movingRight = false; break;
        }
    }
}