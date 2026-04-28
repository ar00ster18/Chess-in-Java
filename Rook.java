/**
 * Represents a rook. Moves any number of squares horizontally or vertically,
 * and cannot jump over pieces.
 */
public class Rook implements ChessPiece {
    private final String color;

    /** @param color "white" or "black". */
    public Rook(String color) {
        this.color = color;
    }

    @Override
    public String getColor() { return color; }

    @Override
    public String getType() { return "Rook"; }

    @Override
    public boolean canMoveToPosition(ChessBoard board, int startX, int startY, int endX, int endY) {
        if (startX != endX && startY != endY) return false;

        ChessPiece destination = board.getPiece(endX, endY);
        if (destination != null && destination.getColor().equals(color)) return false;

        if (startX == endX) {
            int step = (endY > startY) ? 1 : -1;
            for (int y = startY + step; y != endY; y += step) {
                if (board.getPiece(startX, y) != null) return false;
            }
        } else {
            int step = (endX > startX) ? 1 : -1;
            for (int x = startX + step; x != endX; x += step) {
                if (board.getPiece(x, startY) != null) return false;
            }
        }

        return true;
    }
}
