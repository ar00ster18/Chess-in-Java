public interface ChessPiece {
    String getColor();
    String getType();
    boolean canMoveToPosition(ChessBoard chessBoard, int startX, int startY, int endX, int endY);
}
