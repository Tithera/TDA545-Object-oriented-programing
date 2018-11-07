package assignments.basics;

import javax.swing.*;
import java.awt.*;

import static java.awt.Color.*;

/**
 * Exercising some graphics primitives from Java 2D
 *
 * Tip: Use some loops in the paint method.
 */
public class ModernArt extends JPanel {

    public static void main(String[] args) {
        new ModernArt().program();
    }

    void program() {
        // All we need to do is call this.
        initGraphics();
    }

    // This is our standard method to paint in graphical programs
    // This method is automagically called by Java. We don't need to call it
    public void paint(Graphics g) {
        // Do some default painting (this statement always first)
        super.paint(g);

        // g2 is your painting toolbox (this statement always second )
        Graphics2D g2 = (Graphics2D) g;

        // Use graphic primitives from toolbox to draw, you try ....!

        //Body
        g2.setColor(MAGENTA);
        g2.drawLine(200, 150, 200, 250);

        //Arms
        g2.setColor(GREEN);
        g2.drawLine(200, 190, 160, 150);
        g2.drawLine(200, 190, 240, 150);

        //Legs
        g2.setColor(RED);
        g2.drawLine(200, 250, 160, 300);
        g2.drawLine(200, 250, 240, 300);

        //Head
        g2.setColor(BLACK);
        g2.drawOval(170, 90, 60, 60);

        //Eyes
        g2.setColor(BLUE);
        g2.drawOval(180, 110, 10, 10);
        g2.drawOval(210, 110, 10, 10);

        //Mouth
        g2.setColor(RED);
        g2.drawLine(185, 130, 200, 140);
        g2.drawLine(200, 140, 215, 130);

        //Hello
        //H
        g2.setColor(BLUE);
        g2.drawLine(20, 20, 20, 80);
        g2.drawLine(50, 20, 50, 80);
        g2.drawLine(20, 50, 50, 50);

        //E
        g2.drawLine(70, 20, 70, 80);
        g2.drawLine(70, 20, 100, 20);
        g2.drawLine(70, 50, 100, 50);
        g2.drawLine(70, 80, 100, 80);

        //L
        g2.drawLine(120, 20, 120, 80);
        g2.drawLine(120, 80, 150, 80);

        //L
        g2.drawLine(170, 20, 170, 80);
        g2.drawLine(170, 80, 200, 80);

        //O
        g2.drawOval(220, 20, 40,60);

        //!
        g2.drawLine(280, 20, 280, 60);
        g2.drawLine(280, 70, 280, 80);

    }

    // ------- Nothing to below ------------------------------------

    // This is our standard method to start up the graphics
    void initGraphics() {
        int width = 400;
        int height = 400;
        setPreferredSize(new Dimension(width, height));
        JFrame window = new JFrame();
        window.setTitle("Modern art");
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.add(this);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
