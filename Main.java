import java.util.ArrayList;
import java.util.Arrays;

public class Main { 

    public static final int HEIGHT = 16;
    public static final int WIDTH = 16;
    public static final int TETRONIMOS = (HEIGHT * WIDTH) / 4;  

    public static void main(String[] args) {
        int[][] originalBoard = new int[HEIGHT][WIDTH];

        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                originalBoard[y][x] = 0;
            }
        }

        int[][] solution = searchLayer(originalBoard, 1);

        printBoard(solution);
    } 

    private static int[][] searchLayer(int board[][], int number) {
        if (number - 1 == TETRONIMOS) {
            if (containsRectangle(board)) {
                return null;
            }else {
                return board;
            }
        }


        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                // Skip if it's full
                if (board[y][x] != 0) {
                    continue;
                }

                // Check all tetronimos
                for (int rotation = 0; rotation < 4; rotation++){
                    for (int startSquare = 0; startSquare < 4; startSquare++) {
                        if (tetronimoIsPlaceable(board, x, y, false, rotation, startSquare)) {
                            int[][] newBoard = placeTetronimo(board, number, x, y, false, rotation, startSquare);
                            int[][] result = searchLayer(newBoard, number + 1);
                            if (result != null) {
                                return result;
                            }
                        }

                        if (tetronimoIsPlaceable(board, x, y, true, rotation, startSquare)) {
                            int[][] newBoard = placeTetronimo(board, number, x, y, true, rotation, startSquare);
                            int[][] result = searchLayer(newBoard, number + 1);
                            if (result != null) {
                                return result;
                            }
                        }
                    }
                }

                return null;
            }
        }

        return null;
    }

    private static boolean tetronimoIsPlaceable(int[][] board, int x, int y, boolean L, int rotation, int startSquare) {
        int[][] squares = Tetronimo.possiblePlacements[L?1:0][rotation][startSquare];

        
        for (int i = 0; i < 3; i++) {
            // Check if the tetronimo goes off the board
            int newX = x + squares[i][0];
            if (newX < 0) return false;
            if (newX >= WIDTH) return false;

            int newY = y + squares[i][1];
            if (newY < 0) return false;
            if (newY >= HEIGHT) return false;

            // Check if the tetronimo overlaps with another
            if (board[newY][newX] != 0) return false;
        }

        return true;
    }

    /**
     * Places a tetronimo of numbers on the given 2d array
     * @param board the array of numbers to place the tetronimo on
     * @param number the id of the tetronimo (should be unique)
     * @param x the x coordinate of the tetronimo's origin
     * @param y the y coordinate of the tetronimo's origin
     * @param L whether the tetronimo is an L (true) or J (false) tetronimo
     * @param rotation the rotation of the tetronimo. 0 = right, 1 = up, 2 = left, 3 = down 
     * @param startSquare the index of the square that should be at the origin, starting from 0 at the 2 long leg
     */
    private static int[][] placeTetronimo(int[][] board, int number, int x, int y, boolean L, int rotation, int startSquare) {
        // Lookup the relative coordinates of that tetronimo
        int[][] squares = Tetronimo.possiblePlacements[L?1:0][rotation][startSquare];
        
        // Create a new board to place the tetronimo on
        int[][] newBoard = deepCopy(board);

        // Assing the squares of the tetronimo to it's ID
        newBoard[y][x] = number;
        for (int i = 0; i < 3; i++) {
            newBoard[y + squares[i][1]][x + squares[i][0]] = number;
        }
        return newBoard;
    }

    private static boolean containsRectangle(int [][] board) {

        for (int y1 = 0; y1 < HEIGHT; y1++) {
            for (int x1 = 0; x1 < WIDTH; x1++) {
                if (y1 == 0 && x1 == 0) continue;
                for (int y2 = y1 + 1; y2 < HEIGHT; y2++) {
                    for (int x2 = x1 + 1; x2 < WIDTH; x2++) {
                        int area = ((y2-y1+1)*(x2-x1+1));
                        if (area%8!=0) continue;
                        if (countUniques(board, x1, y1, x2, y2) == area / 4) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    private static int countUniques(int[][] board, int x1, int y1, int x2, int y2) {
        ArrayList<Integer> nums = new ArrayList<Integer>(){};

        for (int y = y1; y <= y2; y++) {
            for (int x = x1; x <= x2; x++) {
                if (!nums.contains(board[y][x])) {
                    nums.add(board[y][x]);
                }
            }
        }

        return nums.size();
    }

    private static void printBoard(int[][] board) {
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                if (board[y][x] < 10) {
                    System.out.print(board[y][x] + " ");
                }else {
                    System.out.print((char)(board[y][x] + 55) + " ");
                }

            }
            System.out.println();
        }
    }

    public static int[][] deepCopy(int[][] original) { 
        final int[][] result = new int[HEIGHT][];
        for (int i = 0; i < original.length; i++) {
            result[i] = Arrays.copyOf(original[i], WIDTH);
        }
        return result;
    }
}
