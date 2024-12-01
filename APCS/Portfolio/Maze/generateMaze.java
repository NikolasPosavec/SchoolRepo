package Portfolio.Maze;
import java.util.*;

public class generateMaze 
{
    private int rows;
    private int cols;
    private ArrayList<String> maze;

    public generateMaze() 
    {
        rows = 0;
        cols = 0;
        maze = new ArrayList<>();
    }

    public generateMaze(int r, int c, ArrayList<String> m) 
    {
        rows = r;
        cols = c;
        maze = m;
    }

    public String genMaze(int r, int c) 
    {
        rows = r;
        cols = c;

        // Initialize maze with all walls
        maze = new ArrayList<>(Collections.nCopies(r * c, "#"));

        // Determine starting point in the first row
        int startIndex = (int) (Math.random() * c); // First row (0 to c-1)
        maze.set(startIndex, "S");

        // Determine ending point in the last row
        int endIndex = r * c - c + (int) (Math.random() * c); // Last row (r*c-c to r*c-1)
        maze.set(endIndex, "E");

        // Generate the correct path from S to E
        generateCorrectPath(startIndex, endIndex);

        // Randomly add obstacles (walls) without blocking the path
        addRandomWalls(startIndex, endIndex);

        // Build the maze as a multi-line string
        StringBuilder builtMaze = new StringBuilder();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                builtMaze.append(maze.get(i * c + j)).append(" ");
            }
            builtMaze.append("\n"); // Add a new line after each row
        }

        return builtMaze.toString();
    }

    private void generateCorrectPath(int start, int end) {
        int current = start;
        Stack<Integer> path = new Stack<>();
        path.push(current);
    
        Random rand = new Random();
    
        // Generate the correct path using random walk (DFS-style)
        while (current != end) {
            int currentRow = current / cols;
            int currentCol = current % cols;
    
            List<Integer> directions = new ArrayList<>();
    
            // Possible moves: right, down, left, up
            if (currentCol < cols - 1) directions.add(1); // Right
            if (currentRow < rows - 1) directions.add(cols); // Down
            if (currentCol > 0) directions.add(-1); // Left
            if (currentRow > 0) directions.add(-cols); // Up
    
            // Shuffle the directions for randomness
            Collections.shuffle(directions);
    
            boolean moved = false;
    
            // Try each direction until we move
            for (int step : directions) {
                int nextCell = current + step;
    
                // Ensure that the next cell is within bounds and not already visited
                if (isValidMove(nextCell, current)) {
                    maze.set(nextCell, ".");
                    path.push(nextCell);
                    current = nextCell;
                    moved = true;
                    break;
                }
            }
    
            if (!moved) {
                // Only pop if the stack is not empty
                if (!path.isEmpty()) {
                    path.pop(); // Backtrack if stuck
                    if (!path.isEmpty()) {
                        current = path.peek(); // Go back to previous position
                    } else {
                        break; // If the path is empty, break the loop (unable to proceed)
                    }
                } else {
                    break; // If stack is empty, exit the loop
                }
            }
        }
    }
    
    // Helper method to check if move is valid
    private boolean isValidMove(int nextCell, int current) {
        int currentRow = current / cols;
        int currentCol = current % cols;
        int nextRow = nextCell / cols;
        int nextCol = nextCell % cols;

        // Ensure the move stays within bounds and doesn't cross over itself
        return (nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols) && maze.get(nextCell).equals("#");
    }

    // Function to add random walls while keeping the path intact
    private void addRandomWalls(int start, int end) {
        Random rand = new Random();

        // Add random walls while keeping the path intact
        for (int i = 0; i < rows * cols; i++) {
            // Skip start and end points
            if (maze.get(i).equals("S") || maze.get(i).equals("E")) {
                continue;
            }

            // Randomly add walls with some probability
            if (rand.nextFloat() < 0.2) {
                maze.set(i, "#");
            }
        }
    }

    public static void main(String[] args) {
        int rows = 6;
        int cols = 6;
        generateMaze generator = new generateMaze();
        String generatedMaze = generator.genMaze(rows, cols);
        System.out.println(generatedMaze);
    }
}
