import java.util.Scanner;

public class ChessGameConsole {
    private static char[][] board = {
            {'R', 'N', 'B', 'Q', 'K', 'B', 'N', 'R'},
            {'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P'},
            {'.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.'},
            {'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'},
            {'r', 'n', 'b', 'q', 'k', 'b', 'n', 'r'}
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printBoard();
            System.out.print("Enter move (e.g., e2 e4 or 'exit' to quit): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Game Over!");
                break;
            }

            if (isValidMove(input)) {
                makeMove(input);
            } else {
                System.out.println("Invalid move! Try again.");
            }
        }

        scanner.close();
    }

    // Print the chessboard
    private static void printBoard() {
        System.out.println("\n  a b c d e f g h");
        System.out.println("  ----------------");
        for (int i = 0; i < 8; i++) {
            System.out.print((8 - i) + "|");
            for (int j = 0; j < 8; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("|" + (8 - i));
        }
        System.out.println("  ----------------");
        System.out.println("  a b c d e f g h");
    }

    // Validate move format (like e2 e4)
    private static boolean isValidMove(String input) {
        if (input.length() != 5) return false;
        if (input.charAt(2) != ' ') return false;

        char col1 = input.charAt(0), col2 = input.charAt(3);
        char row1 = input.charAt(1), row2 = input.charAt(4);

        return col1 >= 'a' && col1 <= 'h' && col2 >= 'a' && col2 <= 'h' &&
               row1 >= '1' && row1 <= '8' && row2 >= '1' && row2 <= '8';
    }

    // Move a piece on the board
    private static void makeMove(String input) {
        int row1 = 8 - (input.charAt(1) - '0'); 
        int col1 = input.charAt(0) - 'a';       
        int row2 = 8 - (input.charAt(4) - '0'); 
        int col2 = input.charAt(3) - 'a';       

        if (board[row1][col1] == '.') {
            System.out.println("No piece at the starting position!");
            return;
        }

        // Move the piece
        board[row2][col2] = board[row1][col1];
        board[row1][col1] = '.';
    }
}