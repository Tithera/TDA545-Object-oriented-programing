package assignments.product;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Random;

import static java.lang.Math.round;
import static java.lang.Math.sqrt;
import static java.lang.System.out;


// Extends JPanel because we will will draw graphics
public class Simulation extends JPanel {

    private Timer timer;

    public static void main(String[] args) {

        new Simulation().program();

    }


    // Enumeration (reference) type for the Actors
    enum Actor {
        BLUE, NONE, RED
    }


    // Enumeration (reference) type for the state of an Actor
    enum State {
        UNSATISFIED,
        NA,        // Not applicable (NA), used for NONEs
        SATISFIED
    }


    // Below are the only accepted instance variables
    final Random rand = new Random();


    // %-distribution of RED, BLUE and NONE
    // Result (terminating?) is very depending on % empty and threshold, experiment!
    final double[] distribution = {0.25, 0.25, 0.50};


    // % of surrounding neighbours that are like me
    final double threshold = 0.5; // 0.5 easier for testing;


    Actor[] worldArray = new Actor[100];
    Actor[][] worldMatrix;


    boolean toggle = true;      // Used in updateWorld
    State[][] state;            // Matrix for the state of all Actors


    void program() {

        //Sending the array to initData to generate actors in the array
        worldArray = initData(distribution, worldArray.length);

        //Sending the array to shuffle to actors in the array
        shuffle(worldArray);

        //Sending the array to toMatrix to make it a matrix
        worldMatrix = toMatrix(worldArray);
        state = new State[worldMatrix.length][worldMatrix.length];

        // Testing with *** threshold = 0.5; ***
        plot(worldMatrix);

        // Initialize the world here
        initGraphics();
        initEvents();
    }


    // Method called by timer
    void updateWorld() {

        if (toggle) {
            calculateState();
        } else {
            moveActors();
        }
        toggle = !toggle;
    }


    // Generate Actors for the world, nElements should be a square
    Actor[] initData(double[] distribution, int nElements) {

        double redDot = distribution[0];
        double blueDot = distribution[1];

        double redLeft = nElements * redDot;
        double blueLeft = nElements * blueDot;

        Actor[] arrWithActors = new Actor[nElements];

        for (int i = 0; i < nElements; i++) {

            if (redLeft > 0) {
                arrWithActors[i] = Actor.RED;
                redLeft--;
            } else if (blueLeft > 0) {
                arrWithActors[i] = Actor.BLUE;
                blueLeft--;
            } else {
                arrWithActors[i] = Actor.NONE;
            }
        }
        return arrWithActors;
    }


    // ------------- Write your method below this ---------------


    //Checks if the Actors are satisfied or not
    private void calculateState() {

        double percentAroundMyself;
        double countPlacesAround;
        double countSameAsMyself;

        for (int col = 0; col < worldMatrix.length; col++) {

            for (int row = 0; row < worldMatrix[col].length; row++) {

                Actor currentActor = worldMatrix[col][row];
                countPlacesAround = 0;
                countSameAsMyself = 0;

                if (currentActor != Actor.NONE) {
                    int[][] positions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

                    for (int j = 0; j < positions.length; j++) {
                        int newCol = col + positions[j][0];
                        int newRow = row + positions[j][1];

                        if (isValidPosition(col, newCol, newRow) && !hasSameType(Actor.NONE, newCol, newRow)) {
                            countPlacesAround++;

                            if (hasSameType(currentActor, newCol, newRow)) {
                                countSameAsMyself++;
                            }
                        }
                    }
                    percentAroundMyself = countSameAsMyself / countPlacesAround;

                    if (percentAroundMyself >= threshold) {
                        state[col][row] = State.SATISFIED;
                    } else {
                        state[col][row] = State.UNSATISFIED;
                    }
                } else {
                    state[col][row] = State.NA;
                }
            }
        }
    }


    //Checks if it is tha same type
    private boolean hasSameType(Actor currentActor, int newCol, int newRow) {

        return worldMatrix[newCol][newRow].equals(currentActor);
    }


    //Checks if the position exists
    private boolean isValidPosition(int col, int newCol, int newRow) {

        return newCol >= 0 && newCol < worldMatrix.length && newRow >= 0 && newRow < worldMatrix[col].length;
    }


    //Move the unsatisfied Actors
    private void moveActors() {
        int redDot = 0;
        int blueDot = 0;
        int randomActor;

        for (int col = 0; col < worldMatrix.length; col++) {

            for (int row = 0; row < worldMatrix[col].length; row++) {

                if (state[col][row].equals(State.UNSATISFIED)) {

                    if (hasSameType(Actor.RED, col, row)) {
                        redDot++;

                    } else if (hasSameType(Actor.BLUE, col, row)) {
                        blueDot++;
                    }
                    worldMatrix[col][row] = Actor.NONE;
                    state[col][row] = State.NA;
                }
            }
        }

        if (redDot == 0 && blueDot == 0 ) {
            timer.stop();
            out.println("Done!");
            return;
        }

        while (redDot != 0 || blueDot != 0) {
            int col = rand.nextInt(worldMatrix.length);
            int row = rand.nextInt(worldMatrix.length);

            if (hasSameType(Actor.NONE, col, row)) {
                randomActor = rand.nextInt(2);

                if (randomActor == 0 && redDot > 0) {
                    worldMatrix[col][row] = Actor.RED;
                    redDot--;

                } else if (randomActor == 1 && blueDot > 0) {
                    worldMatrix[col][row] = Actor.BLUE;
                    blueDot--;

                } else {
                    worldMatrix[col][row] = Actor.NONE;
                }
            }
        }
    }


    // --------------- NOTHING to do below this -----------------
    // ------------------- Utility methods ----------------------

    Actor[][] toMatrix(Actor[] arr) {
        int size = (int) round(sqrt(arr.length));

        Actor[][] matrix = new Actor[size][size];

        for (int i = 0; i < arr.length; i++) {
            matrix[i / size][i % size] = arr[i];
        }

        return matrix;
    }


    // Random shuffling of any reference type array
    <T> void shuffle(T[] arr) {

        for (int i = arr.length - 1; i > 0; i--) {

            int j = rand.nextInt(i);
            T k = arr[i];
            arr[i] = arr[j];
            arr[j] = k;

        }

    }

    // ------ For Testing -----------------
    <T> void plot(T[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            out.println(Arrays.toString(matrix[row]));
        }
    }

    // ------- Graphics and Events -------------

    final int width = 400;
    final int height = 400;
    final int delay = 200;

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;

        int size = worldMatrix.length;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                int x = 10 * col + 50;
                int y = 10 * row + 50;

                if (worldMatrix[row][col] == Actor.RED) {
                    g2.setColor(Color.RED);
                } else if (worldMatrix[row][col] == Actor.BLUE) {
                    g2.setColor(Color.BLUE);
                } else {
                    g2.setColor(Color.WHITE);
                }
                g2.fillOval(x, y, 10, 10);
                /* If not satisfied put a mark on
                if (...) {
                    g2.setColor(Color.WHITE);
                    g2.fillOval(x, y, 4, 4);
                }*/
            }
        }
        Toolkit.getDefaultToolkit().sync();
    }

    void initGraphics() {
        setPreferredSize(new Dimension(width, height));
        JFrame window = new JFrame();
        window.setTitle("Simulation");
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.add(this);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    void initEvents() {
        timer = new Timer(delay, e -> {
            updateWorld();
            repaint();

        });
        timer.start();
    }
}
