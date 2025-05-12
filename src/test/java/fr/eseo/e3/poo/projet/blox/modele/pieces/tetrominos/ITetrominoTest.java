package fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos;

import static org.junit.jupiter.api.Assertions.*;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;
import org.junit.jupiter.api.Test;

public class ITetrominoTest {

    @Test
    public void testCreationITetromino() {
        Coordonnees coordRef = new Coordonnees(7, 8);
        ITetromino iTetromino = new ITetromino(coordRef, Couleur.ROUGE);
        Element[] elements = iTetromino.getElements();

        assertEquals(4, elements.length, "Un ITetromino doit contenir 4 éléments.");
        assertEquals(new Element(7, 8, Couleur.ROUGE), elements[0], "Mauvaise position pour l'élément 1.");
        assertEquals(new Element(7, 9, Couleur.ROUGE), elements[1], "Mauvaise position pour l'élément 2.");
        assertEquals(new Element(7, 7, Couleur.ROUGE), elements[2], "Mauvaise position pour l'élément 3.");
        assertEquals(new Element(7, 6, Couleur.ROUGE), elements[3], "Mauvaise position pour l'élément 4.");
    }

    @Test
    public void testToString() {
        ITetromino iTetromino = new ITetromino(new Coordonnees(7, 8), Couleur.ROUGE);
        String expected = "ITetromino :\n" +
                "(7, 8) - ROUGE\n" +
                "(7, 9) - ROUGE\n" +
                "(7, 7) - ROUGE\n" +
                "(7, 6) - ROUGE";
        assertEquals(expected, iTetromino.toString(), "La sortie toString() ne correspond pas au format attendu.");
    }

    @Test
    public void testDeplacementGauche() {
        ITetromino piece = new ITetromino(new Coordonnees(5, 5), Couleur.CYAN);
        piece.deplacerDe(-1, 0);
        assertEquals(4, piece.getElements()[0].getCoordonnees().getAbscisse());
    }

    @Test
    public void testDeplacementVersLeBas() {
        ITetromino piece = new ITetromino(new Coordonnees(5, 5), Couleur.CYAN);
        piece.deplacerDe(0, 1);
        assertEquals(6, piece.getElements()[0].getCoordonnees().getOrdonnee());
    }

    @Test
    public void testDeplacementInvalide() {
        ITetromino piece = new ITetromino(new Coordonnees(5, 5), Couleur.CYAN);
        assertThrows(IllegalArgumentException.class, () -> piece.deplacerDe(0, -1));
        assertThrows(IllegalArgumentException.class, () -> piece.deplacerDe(2, 0));
    }

    @Test
    public void testRotationHoraire() {
        ITetromino piece = new ITetromino(new Coordonnees(5, 5), Couleur.CYAN);
        piece.tourner(true); // sens horaire

        Element[] elements = piece.getElements();
        assertEquals(new Coordonnees(5, 5), elements[0].getCoordonnees());
        assertEquals(new Coordonnees(6, 5), elements[1].getCoordonnees());
        assertEquals(new Coordonnees(4, 5), elements[2].getCoordonnees());
        assertEquals(new Coordonnees(3, 5), elements[3].getCoordonnees());
    }

    @Test
    public void testRotationAntiHoraire() {
        ITetromino piece = new ITetromino(new Coordonnees(5, 5), Couleur.CYAN);
        piece.tourner(false); // sens anti-horaire

        Element[] elements = piece.getElements();
        assertEquals(new Coordonnees(5, 5), elements[0].getCoordonnees());
        assertEquals(new Coordonnees(4, 5), elements[1].getCoordonnees());
        assertEquals(new Coordonnees(6, 5), elements[2].getCoordonnees());
        assertEquals(new Coordonnees(7, 5), elements[3].getCoordonnees());
    }
}
