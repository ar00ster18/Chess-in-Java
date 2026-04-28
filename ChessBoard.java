public class ChessBoard {
    private final ChessPiece[][] board;
    private int enPassantX = -1;
    private int enPassantY = -1;

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

    public int getEnPassantX() { return enPassantX; }
    public int getEnPassantY() { return enPassantY; }

    public void setEnPassantTarget(int x, int y) {
        enPassantX = x;
        enPassantY = y;
    }

    public void clearEnPassantTarget() {
        enPassantX = -1;
        enPassantY = -1;
    }
}
