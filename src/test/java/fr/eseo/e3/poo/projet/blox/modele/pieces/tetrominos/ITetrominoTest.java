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
}
