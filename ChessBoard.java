/**
 * Represents the 8x8 chess board.
 * Coordinates: x is the column (0=a, 7=h), y is the row (0=top/black's back rank, 7=bottom/white's back rank).
 * Also tracks the en passant target square set by the most recent pawn double push.
 */
public class ChessBoard {
    private final ChessPiece[][] board;
    private int enPassantX = -1;
    private int enPassantY = -1;

    public ChessBoard() {
        board = new ChessPiece[8][8];
    }

    /** Returns the piece at (x, y), or null if the square is empty or out of bounds. */
    public ChessPiece getPiece(int x, int y) {
        if (isValidPosition(x, y)) {
            return board[y][x];
        }
        return null;
    }

    /** Places a piece at (x, y). Silently ignores out-of-bounds coordinates. */
    public void setPiece(int x, int y, ChessPiece piece) {
        if (isValidPosition(x, y)) {
            board[y][x] = piece;
        }
    }

    /** Returns true if (x, y) is within the board. */
    public boolean isValidPosition(int x, int y) {
        return x >= 0 && x < 8 && y >= 0 && y < 8;
    }

    public int getEnPassantX() { return enPassantX; }
    public int getEnPassantY() { return enPassantY; }

    /** Sets the en passant target square after a pawn double push. */
    public void setEnPassantTarget(int x, int y) {
        enPassantX = x;
        enPassantY = y;
    }

    /** Clears the en passant target. Called after any non-double-push move. */
    public void clearEnPassantTarget() {
        enPassantX = -1;
        enPassantY = -1;
    }
}
