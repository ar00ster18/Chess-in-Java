public class Pawn implements ChessPiece {
    private final String color;

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
    public String getType() {
        return "Pawn";
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int startX, int startY, int endX, int endY) {
        // Basic movement logic for a pawn
        if (color.equals("white")) {
            // White pawns move up the board (decreasing y)
            if (startX == endX && startY - 1 == endY && chessBoard.getPiece(endX, endY) == null) {
                return true; // Move forward one square
            }
            if (startX == endX && startY == 6 && endY == 4 && chessBoard.getPiece(endX, 5) == null && chessBoard.getPiece(endX, 4) == null) {
                return true; // Move forward two squares from starting position
            }
            if (Math.abs(startX - endX) == 1 && startY - 1 == endY && chessBoard.getPiece(endX, endY) != null && !chessBoard.getPiece(endX, endY).getColor().equals(color)) {
                return true; // Capture diagonally
            }    
        } else {
            // Black pawns move down the board (increasing y)
            if (startX == endX && startY + 1 == endY && chessBoard.getPiece(endX, endY) == null) {
                return true; // Move forward one square
            }
            if (startX == endX && startY == 1 && endY == 3 && chessBoard.getPiece(endX, 2) == null && chessBoard.getPiece(endX, 3) == null) {
                return true; // Move forward two squares from starting position
            }
            if (Math.abs(startX - endX) == 1 && startY + 1 == endY && chessBoard.getPiece(endX, endY) != null && !chessBoard.getPiece(endX, endY).getColor().equals(color)) {
                return true; // Capture diagonally
            }
        }
        return false; // Invalid move
    
}
