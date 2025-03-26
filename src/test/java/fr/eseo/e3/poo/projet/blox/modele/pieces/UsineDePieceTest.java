package fr.eseo.e3.poo.projet.blox.modele.pieces;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.ITetromino;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.OTetromino;

class UsineDePieceTest {

    @RepeatedTest(10)
    void testGenererPieceAleatoire() {
        Piece piece = UsineDePiece.genererPiece();
        assertNotNull(piece, "La pièce générée ne doit pas être null");
    }

    @Test
    void testGenererPieceSpecifique() {
        Piece pieceO = UsineDePiece.genererPiece(UsineDePiece.TypePiece.O);
        assertTrue(pieceO instanceof OTetromino, "La pièce générée doit être un OTetromino");

        Piece pieceI = UsineDePiece.genererPiece(UsineDePiece.TypePiece.I);
        assertTrue(pieceI instanceof ITetromino, "La pièce générée doit être un ITetromino");
    }
}
