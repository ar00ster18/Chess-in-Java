/**
 * Represents a single chess move in algebraic notation.
 * rank = row (1–8), file = column (a–h).
 */
public class ChessMove {
    private final ChessPiece piece;
    private final char rank;
    private final char file;

    /** @param piece the piece that moved, @param rank destination row (1–8), @param file destination column (a–h). */
    public ChessMove(ChessPiece piece, char rank, char file) {
        this.piece = piece;
        this.rank = rank;
        this.file = file;
    }
}
