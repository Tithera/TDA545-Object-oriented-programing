package exercises;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.util.Arrays;
import java.util.Random;
import static java.lang.Math.*;
import static java.lang.System.*;

/*
 * Program for Conway's game of life.  See https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life eller https://bitstorm.org/gameoflife/
 *
 * This is a graphical program using JavaFX to draw on the screen. There is quite a bit of "drawing"
 * code to make this happen (far below). You don't need to implement (or understand) any of it.
 * NOTE: To run tests must uncomment in init() method, see comment
 *
    This is s graphical program, all graphics implemented using JavaFX, you don't need to do any graphics coding.

    a) Implement the init() method. The method should create and initialize the world with Cells
       (a square matrix with Cells). See code.

    b) Now implement the updateWorld() method. The method should calculate the next state for all
       Cells in the world (using the rules).
       Method called automatically by a timer, don't need to call it. Rendering will be done automatically
 *
 * See:
 * - UseEnum
 * - Matrices
 */

public class Ex4GameOfLife extends Application {

    // Enum type for state of Cells
    enum Cell {
        DEAD, ALIVE;
    }

    final Random rand = new Random();

    // This is the *only* accepted modifiable instance variable in program
    Cell[][] world;

    // Implement this method (using functional decomp.) Every involved method should
    // be tested, see below, method test(). This method is automatically called by a
    // JavaFX timer (don't need to call). Now implement the updateWorld() method. The
    // method should calculate the next state for all Cells in the world (using the rules).
    void updateWorld() {

        //Calculate state and set state on the cells
        setState(world);

        // TODO update the "world"
    }

    // -------- Write methods below this --------------


    @Override
    public void init() {
        // test();        // <--------------- Uncomment to test!
        int nLocations = 900;
        double distribution = 0.4;   // % of locations holding a Cell

        //Skapa en array med antal platser som ska finnas
        Cell[] arrWithCell = new Cell[nLocations];

        //Fyll arrayen med cells som är dead or alive, alive ska vara 40% av totalmängden
        fillArray(arrWithCell, distribution, nLocations);

        //Shuffla runt cellsen så att det blir random på vilken plats de är på
        shuffle(arrWithCell);

        //Omvandla arrayen till en matrix
        world = toMatrix(arrWithCell);

        // TODO get distribution, shuffle and convert to matrix (use above)
    }


    private Cell[] fillArray ( Cell[]arrWithCell, double distrbution, int nLocations ) {
        double calcDistru;
        int count = nLocations;

        calcDistru = distrbution * nLocations;
        calcDistru = round(calcDistru);

        while ( count > 0 ) {
            if ( calcDistru > 0 ) {
                arrWithCell[count-1] = Cell.ALIVE;
                calcDistru--;
            } else {
                arrWithCell[count-1] = Cell.DEAD;
            }
            count--;
        }
        return arrWithCell;
    }


    private void shuffle ( Cell[]arrWithCell ) {
        Cell temp;
        int randPlace;
        int randPlace2;
        int arrLength = arrWithCell.length;

        for ( int i = 0; i < arrWithCell.length; i++ ) {

            randPlace = rand.nextInt(arrLength) + 1;
            randPlace2 = rand.nextInt(arrLength) + 1;

            temp = arrWithCell[randPlace-1];
            arrWithCell[randPlace-1] = arrWithCell[randPlace2-1];
            arrWithCell[randPlace2-1] = temp;
        }
    }


    private Cell[][] toMatrix ( Cell[] arrWithCell ) {

        double lenghtArray = arrWithCell.length / sqrt(arrWithCell.length);
        int count = 0;

        Cell[][] matrixWithCell = new Cell[ (int) lenghtArray][ (int) lenghtArray];

        for ( int row = 0; row < matrixWithCell.length; row++ ) {
            for ( int col = 0; col < matrixWithCell[row].length; col++ ) {

                matrixWithCell[row][col] = arrWithCell[count];
                count++;
            }
        }
        return matrixWithCell;
    }


    private void setState ( Cell[][]world ) {   //TODO Nåntinga kan vara fel här
        int count = 0;

        for (int row = 0; row < world.length; row++) {
            for (int col = 0; col < world[row].length; col++) {
                if ( world[row][col] == Cell.ALIVE ) {
                    count++;
                }
            }
        }
        out.println(count);


        for (int row = 0; row < world.length; row++) {
            for (int col = 0; col < world[row].length; col++) {

                if ( world[row][col] == Cell.ALIVE ) {      //Ifall en cell är alive går in här

                    if ( checkNeigbours(row, col) <= 1  ) { //Ifall de har mindre eller lika med 1 grannar som är alive
                        //Each cell with one or no neighbors dies, as if by solitude.
                        world[row][col] = Cell.DEAD;

                    } else if ( checkNeigbours(row, col) >= 4 ) {   //Ifall de har mer eller lika med 4 grannar som är alive
                        //Each cell with four or more neighbors dies, as if by overpopulation.
                        world[row][col] = Cell.DEAD;
                    }

                } else if ( world[row][col] == Cell.DEAD ) {    //Ifall en cell är dead går in här

                    if ( checkNeigbours(row, col) == 3 ) {      //Ifall den har lika med 3 grannar om är alive
                        //Each cell with three neighbors becomes populated
                        world[row][col] = Cell.ALIVE;
                    }
                }
            }
        }
    }


    private int checkNeigbours ( int row, int col ) {   //TODO Nåntinga kan vara fel här
        int countAliveNeigbours = 0;

        int[][] positions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

        for (int j = 0; j < positions.length; j++) {
            int newCol = col + positions[j][0];
            int newRow = row + positions[j][1];

            if (isValidPosition(col, newCol, newRow)) {

                if ( world[newRow][newCol] == Cell.ALIVE ) {
                    countAliveNeigbours++;
                }
            }
        }
        return countAliveNeigbours;
    }


    //Checks if the position exists
    private boolean isValidPosition(int col, int newCol, int newRow) {
        return newCol >= 0 && newCol < world.length && newRow >= 0 && newRow < world[col].length;
    }


    // -------- Below is JavaFX stuff, nothing to do --------------

    // --------- Rendering ----------------------
    // GraphicsContext object supplied by JavaFX
    void renderWorld(GraphicsContext g) {
        g.clearRect(0, 0, width, height);
        int size = world.length;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                int x = 10 * col + 50;
                int y = 10 * row + 50;
                renderCell(g, x, y, world[row][col]);
            }
        }
    }

    void renderCell(GraphicsContext g, int x, int y, Cell cell) {
        if (cell == Cell.ALIVE) {
            g.setFill(Color.RED);
        } else {
            g.setFill(Color.WHITE);
        }
        g.fillOval(x, y, 10, 10);
    }

    final int width = 400;   // Size of window
    final int height = 400;
    long previousTime = nanoTime();   // Get time right now
    final long INTERVAL = 70000;

    // Must have public before more later.
    @Override
    public void start(Stage primaryStage) throws Exception {
        // JavaFX stuff
        Group root = new Group();
        Canvas canvas = new Canvas(width, height);
        root.getChildren().addAll(canvas);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // Create a timer
        AnimationTimer timer = new AnimationTimer() {
            // This method called by FX at a certain rate, parameter is the current time
            public void handle(long currentNanoTime) {
                long elapsedNanos = currentNanoTime - previousTime;
                if (elapsedNanos > INTERVAL) {
                    updateWorld();
                    renderWorld(gc);
                    previousTime = currentNanoTime;
                }
            }
        };
        // Create a scene and connect to the stage
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Game of Life");
        primaryStage.show();
        timer.start();  // Start simulation
    }

    public static void main(String[] args) {
        launch(args);   // Launch JavaFX
    }
}