import java.util.List;

/**
 * Manages the overall state of a chess game: the board, whose turn it is, and move history.
 */
public class ChessGame {
    private final ChessBoard chessBoard;
    private boolean whiteToMove;
    private List<ChessMove> moveHistory;

    /** Creates a new game with all pieces in their starting positions. White moves first. */
    public ChessGame() {
        chessBoard = new ChessBoard();
        initializePieces();
        whiteToMove = true;
        moveHistory = new java.util.ArrayList<>();
    }

    private void initializePieces() {
        for (int i = 0; i < 8; i++) {
            chessBoard.setPiece(i, 6, new Pawn("white"));
            chessBoard.setPiece(i, 1, new Pawn("black"));
        }
        chessBoard.setPiece(0, 7, new Rook("white"));
        chessBoard.setPiece(7, 7, new Rook("white"));
        chessBoard.setPiece(0, 0, new Rook("black"));
        chessBoard.setPiece(7, 0, new Rook("black"));
        chessBoard.setPiece(2, 7, new Bishop("white"));
        chessBoard.setPiece(5, 7, new Bishop("white"));
        chessBoard.setPiece(2, 0, new Bishop("black"));
        chessBoard.setPiece(5, 0, new Bishop("black"));
    }

    /**
     * Attempts to move a piece from (startX, startY) to (endX, endY).
     * Handles en passant detection and updates the en passant target for the next move.
     *
     * @return true if the move was legal and applied, false otherwise.
     */
    public boolean movePiece(int startX, int startY, int endX, int endY) {
        ChessPiece piece = chessBoard.getPiece(startX, startY);
        if (piece == null || !piece.canMoveToPosition(chessBoard, startX, startY, endX, endY)) {
            return false;
        }

        boolean isEnPassant = piece.getType().equals("Pawn")
                && Math.abs(startX - endX) == 1
                && chessBoard.getPiece(endX, endY) == null;

        chessBoard.setPiece(endX, endY, piece);
        chessBoard.setPiece(startX, startY, null);

        if (isEnPassant) {
            // The captured pawn sits on the same column as the destination but the same row as the origin.
            chessBoard.setPiece(endX, startY, null);
        }

        if (piece.getType().equals("Pawn") && Math.abs(startY - endY) == 2) {
            chessBoard.setEnPassantTarget(endX, (startY + endY) / 2);
        } else {
            chessBoard.clearEnPassantTarget();
        }

        return true;
    }
}
