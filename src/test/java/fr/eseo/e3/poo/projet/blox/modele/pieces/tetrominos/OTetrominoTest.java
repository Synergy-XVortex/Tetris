package fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos;

import static org.junit.jupiter.api.Assertions.*;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;
import org.junit.jupiter.api.Test;

public class OTetrominoTest {

    @Test
    public void testCreationOTetromino() {
        Coordonnees coordRef = new Coordonnees(6, 5);
        OTetromino oTetromino = new OTetromino(coordRef, Couleur.CYAN);
        Element[] elements = oTetromino.getElements();

        assertEquals(4, elements.length, "Un OTetromino doit contenir 4 éléments.");
        assertEquals(new Element(6, 5, Couleur.CYAN), elements[0], "Mauvaise position pour l'élément 1.");
        assertEquals(new Element(7, 5, Couleur.CYAN), elements[1], "Mauvaise position pour l'élément 2.");
        assertEquals(new Element(6, 6, Couleur.CYAN), elements[2], "Mauvaise position pour l'élément 3.");
        assertEquals(new Element(7, 6, Couleur.CYAN), elements[3], "Mauvaise position pour l'élément 4.");
    }

    @Test
    public void testToString() {
        OTetromino oTetromino = new OTetromino(new Coordonnees(6, 5), Couleur.CYAN);
        String expected = "OTetromino :\n" +
                "(6, 5) - CYAN\n" +
                "(7, 5) - CYAN\n" +
                "(6, 6) - CYAN\n" +
                "(7, 6) - CYAN";
        assertEquals(expected, oTetromino.toString(), "La sortie toString() ne correspond pas au format attendu.");
    }

    @Test
    public void testDeplacementValide() {
        OTetromino piece = new OTetromino(new Coordonnees(3, 4), Couleur.JAUNE);
        piece.deplacerDe(1, 0); // droite
        assertEquals(4, piece.getElements()[0].getCoordonnees().getAbscisse());
    }

    @Test
    public void testDeplacementBas() {
        OTetromino piece = new OTetromino(new Coordonnees(2, 2), Couleur.BLEU);
        piece.deplacerDe(0, 1); // descendre
        assertEquals(3, piece.getElements()[0].getCoordonnees().getOrdonnee());
    }

    @Test
    public void testDeplacementInvalide() {
        OTetromino piece = new OTetromino(new Coordonnees(3, 4), Couleur.VERT);
        assertThrows(IllegalArgumentException.class, () -> piece.deplacerDe(0, -1));
        assertThrows(IllegalArgumentException.class, () -> piece.deplacerDe(2, 0));
    }

    @Test
    public void testRotationIgnorée() {
        OTetromino piece = new OTetromino(new Coordonnees(2, 3), Couleur.JAUNE);

        // Sauvegarde la position initiale
        Coordonnees[] coordsAvant = new Coordonnees[4];
        for (int i = 0; i < 4; i++) {
            coordsAvant[i] = piece.getElements()[i].getCoordonnees();
        }

        piece.tourner(true);  // sens horaire
        for (int i = 0; i < 4; i++) {
            assertEquals(coordsAvant[i], piece.getElements()[i].getCoordonnees(),
                    "La pièce O ne devrait pas changer de position en tournant");
        }

        piece.tourner(false); // sens anti-horaire
        for (int i = 0; i < 4; i++) {
            assertEquals(coordsAvant[i], piece.getElements()[i].getCoordonnees(),
                    "La pièce O ne devrait pas changer de position en tournant");
        }
    }
}
