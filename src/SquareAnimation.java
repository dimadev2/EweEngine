import Engine.Geometry.Shapes.Rectangle;

import java.awt.*;
import javax.swing.*;

public class SquareAnimation extends JPanel implements Runnable {
    private int x = 0, y = 180; // начальные координаты квадрата
    private int dx = 5, dy = 0; // шаг перемещения по x и y
    private final int WIDTH = 550; // ширина канвы
    private final int HEIGHT = 550; // высота канвы
    public Thread thread;
    private JFrame frame;
    Rectangle R1;
    Rectangle R2;

    public SquareAnimation(Rectangle r1, Rectangle r2) {
        R1 = r1;
        R2 = r2;

        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        frame = new JFrame("Squares");
        frame.add(this);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setDoubleBuffered(true);

        thread = new Thread(this, "Graphics");
        thread.start();
    }

    public void run() {
        while (true) {
            if (x > (WIDTH - 20) || x < 0) { // если квадрат достиг границы, меняем направление движения по x
                dx = -dx;
            }
            x += dx * 30/1000; // перемещаем квадрат
            repaint(); // перерисовываем канву
            try {
                Thread.sleep(30); // задержка для создания эффекта анимации
            } catch (InterruptedException ex) {
            }
        }
    }

    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        g.setColor(Color.RED); // задаем цвет квадрата
        g.fillRect((int) R1.Pos.X, (int) R1.Pos.Y, (int) R1.Width, (int) R1.Height); // рисуем квадрат

        g.setColor(Color.BLUE); // задаем цвет квадрата
        g.fillRect((int) R2.Pos.X, (int) R2.Pos.Y, (int) R2.Width, (int) R2.Height); // рисуем квадрат
    }
}