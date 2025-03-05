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
        assertEquals(new Element(6, 4, Couleur.CYAN), elements[2], "Mauvaise position pour l'élément 3.");
        assertEquals(new Element(7, 4, Couleur.CYAN), elements[3], "Mauvaise position pour l'élément 4.");
    }

    @Test
    public void testToString() {
        OTetromino oTetromino = new OTetromino(new Coordonnees(6, 5), Couleur.CYAN);
        String expected = "OTetromino :\n" +
                "(6, 5) - CYAN\n" +
                "(7, 5) - CYAN\n" +
                "(6, 4) - CYAN\n" +
                "(7, 4) - CYAN";
        assertEquals(expected, oTetromino.toString(), "La sortie toString() ne correspond pas au format attendu.");
    }
}
