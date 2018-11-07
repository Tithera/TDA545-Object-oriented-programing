package exercises;

import java.awt.*;
import java.util.Arrays;
import java.util.Random;
import javax.swing.*;

import static java.lang.Math.*;
import static java.lang.System.*;

/**
 * Conway's game of life is a cellular automaton devised by the
 * mathematician John Conway.
 */
public class GameOfLife extends JPanel {

    public static void main(String[] args) {
        new GameOfLife().program();
    }

    // Enum (reference) type for state of Cells
    enum Cell {
        DEAD, ALIVE;
    }

    final Random rand = new Random();
    // Hard coded for testing (later you generate world)
    Cell[][] world = {
            {Cell.ALIVE, Cell.ALIVE, Cell.DEAD},
            {Cell.ALIVE, Cell.DEAD, Cell.DEAD},
            {Cell.DEAD, Cell.DEAD, Cell.ALIVE},

    };

    void program() {
        //plot(world);

        Cell[] data = initData(900, 0.4);
        shuffle(data);
        world = toMatrix(data);

        initGraphics();
        initEvents();
    }

    Cell[] initData(int nCells, double percentAlive) {
        Cell[] cells = new Cell[nCells];
        int nAlive = (int) round(percentAlive * nCells);
        int i = 0;
        while (nAlive > 0) {
            cells[i] = Cell.ALIVE;
            nAlive--;
            i++;
        }
        while (i < nCells) {
            cells[i] = Cell.DEAD;
            i++;
        }
        return cells;
    }

    void updateWorld() {

        int size = world.length;
        // Make a copy because neighbours impact
        Cell[][] tmp = new Cell[size][size];

        // Update on the copy
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                int nAlive = getLivingNeighbours(row, col);
                if (nAlive > 3) {
                    tmp[row][col] = Cell.DEAD;
                } else if (nAlive == 3) {
                    tmp[row][col] = Cell.ALIVE;
                } else if (nAlive < 2) {
                    tmp[row][col] = Cell.DEAD;
                } else {
                    tmp[row][col] = world[row][col];  // No change
                }
            }
        }
        // Copy back
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                world[row][col] = tmp[row][col];
            }
        }
    }

    int getLivingNeighbours(int row, int col) {
        int count = 0;
        // Examine positions surrounding row and col
        for (int r = row - 1; r <= row + 1; r++) {
            for (int c = col - 1; c <= col + 1; c++) {
                // Not count actual row and col && must be inside world
                if (!(row == r && col == c) && isValidLocation(r, c)) {
                    if (world[r][c] == Cell.ALIVE) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    boolean isValidLocation(int row, int col) {
        return row >= 0 && col >= 0 && row < world.length && col < world.length;
    }

    // ---- Utilities
    Cell[][] toMatrix(Cell[] arr) {
        int size = (int) round(sqrt(arr.length));
        Cell[][] matrix = new Cell[size][size];
        for (int i = 0; i < arr.length; i++) {
            matrix[i / size][i % size] = arr[i];
        }
        return matrix;
    }

    // Random shuffling of any reference type array
    <T> void shuffle(T[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            int j = rand.nextInt(i);
            T c = arr[i];
            arr[i] = arr[j];
            arr[j] = c;
        }
    }

    // -------- For testing ----------------
    <T> void plot(T[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            out.println(Arrays.toString(matrix[row]));
        }
    }

    // -------- Below is just initialization and graphics --------------
    final int width = 400;
    final int height = 400;
    final int delay = 1000;

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;

        int size = world.length;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                int x = 10 * col + 50;
                int y = 10 * row + 50;
                drawCell(g2, x, y, world[row][col]);
            }
        }
        Toolkit.getDefaultToolkit().sync(); // Possibly Linux specific
    }

    void drawCell(Graphics2D g2, int x, int y, Cell cell) {
        if (cell == Cell.ALIVE) {
            g2.setColor(Color.RED);
        } else {
            g2.setColor(Color.WHITE);
        }
        g2.fillOval(x, y, 10, 10);
    }

    void initGraphics() {
        setPreferredSize(new Dimension(width, height));
        JFrame window = new JFrame();
        window.setTitle("Game of Life");
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.add(this);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    void initEvents() {
        Timer timer = new Timer(delay,
                e -> {
                    updateWorld();
                    repaint();
                }); // Add this as action listener
        timer.setInitialDelay(delay);
        timer.start();
    }

}