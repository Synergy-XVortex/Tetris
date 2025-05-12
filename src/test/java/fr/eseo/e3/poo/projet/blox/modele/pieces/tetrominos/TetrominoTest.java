package fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;

public class TetrominoTest {

    @Test
    public void testDeplacementValide() {
        Tetromino piece = new OTetromino(new Coordonnees(4, 0), Couleur.JAUNE);
        piece.deplacerDe(0, 1); // descend
        for (Element e : piece.getElements()) {
            assertTrue(e.getCoordonnees().getOrdonnee() >= 1);
        }
    }

    @Test
    public void testDeplacementInvalide() {
        Tetromino piece = new OTetromino(new Coordonnees(4, 0), Couleur.JAUNE);
        assertThrows(IllegalArgumentException.class, () -> piece.deplacerDe(0, -1)); // vers le haut
        assertThrows(IllegalArgumentException.class, () -> piece.deplacerDe(2, 0));  // trop loin
    }
}
