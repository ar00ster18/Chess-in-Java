/**
 * Represents a pawn. Pawns move forward one square, two squares from their starting row,
 * capture diagonally, and support en passant.
 * White moves toward decreasing y (up the board); black moves toward increasing y (down the board).
 */
public class Pawn implements ChessPiece {
    private final String color;

    /** @param color "white" or "black". */
    public Pawn(String color) {
        this.color = color;
    }

    @Override
    public String getColor() {
        if (!color.equals("white") && !color.equals("black")) {
            throw new IllegalArgumentException("Invalid color for Pawn: " + color);
        }
        return color;
    }

    @Override
    public String getType() { return "Pawn"; }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int startX, int startY, int endX, int endY) {
        if (color.equals("white")) {
            if (startX == endX && startY - 1 == endY && chessBoard.getPiece(endX, endY) == null)
                return true;
            if (startX == endX && startY == 6 && endY == 4 && chessBoard.getPiece(endX, 5) == null && chessBoard.getPiece(endX, 4) == null)
                return true;
            if (Math.abs(startX - endX) == 1 && startY - 1 == endY) {
                ChessPiece target = chessBoard.getPiece(endX, endY);
                if (target != null && !target.getColor().equals(color)) return true;
                if (endX == chessBoard.getEnPassantX() && endY == chessBoard.getEnPassantY()) return true;
            }
        } else {
            if (startX == endX && startY + 1 == endY && chessBoard.getPiece(endX, endY) == null)
                return true;
            if (startX == endX && startY == 1 && endY == 3 && chessBoard.getPiece(endX, 2) == null && chessBoard.getPiece(endX, 3) == null)
                return true;
            if (Math.abs(startX - endX) == 1 && startY + 1 == endY) {
                ChessPiece target = chessBoard.getPiece(endX, endY);
                if (target != null && !target.getColor().equals(color)) return true;
                if (endX == chessBoard.getEnPassantX() && endY == chessBoard.getEnPassantY()) return true;
            }
        }
        return false;
    }
}
