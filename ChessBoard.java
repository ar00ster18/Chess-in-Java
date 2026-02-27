public class ChessBoard {
    private final ChessPiece[][] board;

    public ChessBoard() {
        board = new ChessPiece[8][8];
    }

    public ChessPiece getPiece(int x, int y) {
        if (isValidPosition(x, y)) {
            return board[y][x];
        }
        return null;
    }

    public void setPiece(int x, int y, ChessPiece piece) {
        if (isValidPosition(x, y)) {
            board[y][x] = piece;
        }
    }

    public boolean isValidPosition(int x, int y) {
        return x >= 0 && x < 8 && y >= 0 && y < 8;
    }
}
