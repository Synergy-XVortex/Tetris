package fr.eseo.e3.poo.projet.blox.modele;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import fr.eseo.e3.poo.projet.blox.modele.pieces.*;

class PuitsTest {

    private Puits puits;

    @BeforeEach
    void setUp() {
        puits = new Puits(); // Puits avec dimensions par défaut
    }

    @Test
    void testConstructeurParDefaut() {
        assertEquals(Puits.LARGEUR_PAR_DEFAUT, puits.getLargeur(), "Largeur incorrecte");
        assertEquals(Puits.PROFONDEUR_PAR_DEFAUT, puits.getProfondeur(), "Profondeur incorrecte");
        assertNull(puits.getPieceActuelle(), "La pièce actuelle doit être null au départ");
        assertNull(puits.getPieceSuivante(), "La pièce suivante doit être null au départ");
    }

    @Test
    void testConstructeurAvecParametres() {
        Puits puitsPerso = new Puits(8, 18);
        assertEquals(8, puitsPerso.getLargeur(), "Largeur incorrecte");
        assertEquals(18, puitsPerso.getProfondeur(), "Profondeur incorrecte");
    }

    @Test
    void testConstructeurExceptionLargeur() {
        assertThrows(IllegalArgumentException.class, () -> new Puits(4, 20),
                "Une largeur < 5 doit lever une exception");
        assertThrows(IllegalArgumentException.class, () -> new Puits(16, 20),
                "Une largeur > 15 doit lever une exception");
    }

    @Test
    void testConstructeurExceptionProfondeur() {
        assertThrows(IllegalArgumentException.class, () -> new Puits(10, 14),
                "Une profondeur < 15 doit lever une exception");
        assertThrows(IllegalArgumentException.class, () -> new Puits(10, 26),
                "Une profondeur > 25 doit lever une exception");
    }

    @Test
    void testSetPieceSuivante() {
        Piece piece = new OTetromino(new Coordonnees(5, 5));
        puits.setPieceSuivante(piece);
        assertEquals(piece, puits.getPieceSuivante(), "La pièce suivante n'est pas correcte");
    }

    @Test
    void testSetPieceSuivanteEtSuivante() {
        Piece piece1 = new LTetromino(new Coordonnees(3, 3));
        Piece piece2 = new ITetromino(new Coordonnees(4, 4));

        puits.setPieceSuivante(piece1);
        assertEquals(piece1, puits.getPieceSuivante(), "La première pièce suivante est incorrecte");

        puits.setPieceSuivanteEtSuivante(piece2);
        assertEquals(piece1, puits.getPieceActuelle(), "La pièce actuelle est incorrecte après transition");
        assertEquals(piece2, puits.getPieceSuivante(), "La nouvelle pièce suivante est incorrecte");
    }

    @Test
    void testToString() {
        String expected = "Puits : Dimension 10 x 20";
        assertEquals(expected, puits.toString(), "Le toString() ne retourne pas la bonne chaîne");
    }
}
