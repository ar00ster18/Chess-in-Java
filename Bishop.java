/**
 * Represents a bishop. Moves any number of squares diagonally,
 * and cannot jump over pieces.
 */
public class Bishop implements ChessPiece {
    private final String color;

    /** @param color "white" or "black". */
    public Bishop(String color) {
        this.color = color;
    }

    @Override
    public String getColor() { return color; }

    @Override
    public String getType() { return "Bishop"; }

    @Override
    public boolean canMoveToPosition(ChessBoard board, int startX, int startY, int endX, int endY) {
        if (Math.abs(endX - startX) != Math.abs(endY - startY)) return false;

        ChessPiece destination = board.getPiece(endX, endY);
        if (destination != null && destination.getColor().equals(color)) return false;

        int stepX = (endX > startX) ? 1 : -1;
        int stepY = (endY > startY) ? 1 : -1;
        int x = startX + stepX;
        int y = startY + stepY;
        while (x != endX) {
            if (board.getPiece(x, y) != null) return false;
            x += stepX;
            y += stepY;
        }

        return true;
    }
}
