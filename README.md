# Chess-in-Java

An object-oriented chess engine built from scratch in Java.

## Architecture

- **`ChessPiece`** — interface implemented by each piece class
- **`ChessBoard`** — 8x8 grid with bounds checking and en passant state
- **`ChessGame`** — orchestrates moves and game state
- **`ChessMove`** — represents a move in algebraic notation

## Current Features

- Pawn movement: one square forward, two squares from starting position, diagonal capture, en passant

## Planned Features

- Remaining pieces (Rook, Knight, Bishop, Queen, King)
- Turn enforcement
- Check and checkmate detection
- Castling
- Pawn promotion

## How to Run

```bash
javac *.java
java ChessGame
```
