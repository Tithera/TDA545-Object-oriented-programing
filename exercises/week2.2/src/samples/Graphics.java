package samples;

import javax.swing.*;
import java.awt.*;

import static java.awt.Color.*;

/**
 * Draw some graphs x^2 and x^3
 */
public class Graphics extends JPanel {

    public static void main(String[] args) {
        new Graphics().program();
    }

    final int width = 400;
    final int height = 400;

    void program() {
        initGraphics();
    }


    public void paint(java.awt.Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;

        // Coordinate axis
        g2.setColor(DARK_GRAY);
        g2.drawLine(0, height / 2, width, height / 2);
        g2.drawLine(width / 2, 0, width / 2, height);


        // Loop logical universe [-8, 8)
        for (double i = -8; i < 8; i = i + 0.01) {
            g2.setColor(RED);
            drawPoint(g2, i, i * i);
            g2.setColor(BLUE);
            drawPoint(g2, i, i * i * i);
        }
    }

    // Adjust to screen universe
    void drawPoint(Graphics2D g2, double x, double y) {
        // Scale, move to center and explicit type cast
        int x1 = (int) (100.0 * x + width / 2);
        int y1 = (int) (100.0 * y + height / 2);
        // Reverse y
        g2.drawLine(x1, height - y1, x1, height - y1);
    }


    void initGraphics() {
        setPreferredSize(new Dimension(width, height));
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.add(this);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }


}
