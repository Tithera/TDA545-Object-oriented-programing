package samples;

import javax.swing.*;
import java.awt.*;

import static java.awt.Color.*;

import java.util.Random;

import static java.lang.System.*;
import static java.lang.System.*;

/*
 *   Using a Timer to get an event based application
 */
public class TimerEvents extends JPanel {

    public static void main(String[] args) {
        new TimerEvents().program();
    }

    final int width = 400;  // Size of window
    final int height = 400;
    final int delay = 2000;     // Milli sec before starting

    final Random rand = new Random();

    void program() {
        // Possibly initialize some pats of program
        initGraphics();
        initEvents();
    }

    int x;
    int y;
    // Called evey time Timer fires
    void update() {
        x = rand.nextInt(300);
        y = rand.nextInt(300);
    }

    // Must have public before
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(RED);
        g2.fillOval(x, y, 50, 50);

        Toolkit.getDefaultToolkit().sync();  // Technical stuff don't bother
    }

    void initGraphics() {
        setPreferredSize(new Dimension(width, height));
        JFrame window = new JFrame();
        window.setTitle("Animation");
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.add(this);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    void initEvents() {
        // Create a timer. Will call update() and repaint() (repaint calls paint in background)
        Timer timer = new Timer(delay, e -> {
            update();
            repaint();
        });
        timer.start();
    }
}




