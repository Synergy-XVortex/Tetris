package fr.eseo.e3.poo.projet.blox.modele;

import fr.eseo.e3.poo.projet.blox.modele.pieces.*;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PuitsTest {

    @Test
    public void testConstructeurParDefaut() {
        Puits puits = new Puits();
        assertEquals(10, puits.getLargeur());
        assertEquals(20, puits.getProfondeur());
    }

    @Test
    public void testConstructeurParametreValide() {
        Puits puits = new Puits(8, 18);
        assertEquals(8, puits.getLargeur());
        assertEquals(18, puits.getProfondeur());
    }

    @Test
    public void testConstructeurParametreInvalide() {
        assertThrows(IllegalArgumentException.class, () -> new Puits(4, 18));
        assertThrows(IllegalArgumentException.class, () -> new Puits(8, 30));
    }

    @Test
    public void testSetPieceSuivante() {
        Puits puits = new Puits();
        Piece p1 = new OTetromino(new Coordonnees(4, 0), Couleur.ROUGE);
        Piece p2 = new ITetromino(new Coordonnees(5, 0), Couleur.VERT);

        puits.setPieceSuivante(p1);
        assertNull(puits.getPieceActuelle());
        assertEquals(p1, puits.getPieceSuivante());

        puits.setPieceSuivante(p2);
        assertEquals(p1, puits.getPieceActuelle());
        assertEquals(p2, puits.getPieceSuivante());
    }

    @Test
    public void testToString() {
        Puits puits = new Puits();
        String expectedStart = "Puits : Dimension 10 x 20";
        assertTrue(puits.toString().startsWith(expectedStart));
    }
}
