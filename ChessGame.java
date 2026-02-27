
import java.util.List;

public class ChessGame {
    private final ChessBoard chessBoard;
    private boolean whiteToMove;
    private List<ChessMove> moveHistory;

    public ChessGame() {
        chessBoard = new ChessBoard();
        initializePieces();
        whiteToMove = true;
        moveHistory = new java.util.ArrayList<>();
    }

    private void initializePieces() {
        // Initialize pieces for both players (white and black)
        // For example, placing pawns
        for (int i = 0; i < 8; i++) {
            chessBoard.setPiece(i, 1, new Pawn("white"));
            chessBoard.setPiece(i, 6, new Pawn("black"));
        }
        // Initialize other pieces (rooks, knights, bishops, queen, king) similarly
    }

    public boolean movePiece(int startX, int startY, int endX, int endY) {
        ChessPiece piece = chessBoard.getPiece(startX, startY);
        if (piece != null && piece.canMoveToPosition(chessBoard, startX, startY, endX, endY)) {
            chessBoard.setPiece(endX, endY, piece);
            chessBoard.setPiece(startX, startY, null);
            return true;
        }
        return false;
    }
}
