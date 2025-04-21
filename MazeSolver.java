import java.util.ArrayList;
import java.util.Objects;

public class MazeSolver {
    private String[][] maze;
    ArrayList<String> coordinates;
    private int currentX;
    private int currentY;
    private boolean finished = false;
    private int numRows;
    ArrayList<Integer> yCoordinates;
    private int numColumns;
    private int finalX;

    public MazeSolver(String[][] maze){
        this.maze = maze;
        coordinates = new ArrayList<>();
        currentX = 0;
        currentY = 0;

        yCoordinates = new ArrayList<>();
        yCoordinates.add(0);
        finalX = 0;

        for (String[] row : maze){
            numRows++;

        }
        for (String item : maze[0]){
            numColumns++;
        }

    }

    public void printMaze(){
        int rowNumber = 0;
        int columnNumber = 0;
        for (String[] row : maze){
            for (String item : row){
                if (rowNumber == currentX && columnNumber == currentY){
                    System.out.print("X");
                }
                else{
                    System.out.print(item);
                }
                columnNumber++;
            }
            System.out.println();
            rowNumber++;
            columnNumber = 0;
        }
        System.out.println();
    }

    public void addPoint(){
        String toAdd = "(" + Integer.toString(currentX) + ", " + currentY + ")";
        coordinates.add(toAdd);
        yCoordinates.add(currentY);
    }

    public void move(){
        findEnd();



        printMaze();
        System.out.println("CURRENT Y: " + currentY);
        System.out.println("NUM ROWS: "+ numRows);
        if (currentX == numRows - 1 && currentY == finalX) {
            finished = true;
        }
        else {

             if (currentY < numColumns - 1 && Objects.equals(maze[currentX][currentY + 1], ".")) {
                maze[currentX][currentY] = "#";
                currentY++;
                addPoint();
            }
             else if (currentX < numRows - 1 && Objects.equals(maze[currentX + 1][currentY], ".")) {
                maze[currentX][currentY] = "#";
                currentX++;
                addPoint();
            }
             else if (currentX != 0 && Objects.equals(maze[currentX - 1][currentY], ".")) {
                maze[currentX][currentY] = "#";
                currentX--;
                addPoint();
            }
             else if (currentY != 0 && Objects.equals(maze[currentX][currentY - 1], ".")) {
                maze[currentX][currentY] = "#";
                currentY--;
                addPoint();
            }
        }


        System.out.println("CURRENT Y: " + currentY);
        System.out.println("MAZE.LENGTH - 1: " + (maze.length - 1));
    }

    public void findEnd(){
        int row = maze.length - 1;
        for (int i = 0; i < maze[row].length; i++){
            if (Objects.equals(maze[row][i], ".")){
                finalX = i;
            }
        }
    }

    public void play(){
        while (!finished){
            move();
        }
        System.out.println(coordinates);
    }




}
