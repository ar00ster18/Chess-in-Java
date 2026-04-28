/**
 * Represents a chess piece. Each piece type implements its own movement rules.
 */
public interface ChessPiece {
    /** Returns the color of the piece: "white" or "black". */
    String getColor();

    /** Returns the type of the piece (e.g. "Pawn", "Rook"). */
    String getType();

    /**
     * Returns true if this piece can legally move from (startX, startY) to (endX, endY).
     * Does not account for leaving the king in check.
     */
    boolean canMoveToPosition(ChessBoard chessBoard, int startX, int startY, int endX, int endY);
}
