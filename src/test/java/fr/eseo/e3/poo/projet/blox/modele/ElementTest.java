package fr.eseo.e3.poo.projet.blox.modele;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ElementTest {

    @Test
    public void testConstructeurAvecCoordonnees() {
        Coordonnees coord = new Coordonnees(3, 4);
        Element elem = new Element(coord);
        assertEquals(coord, elem.getCoordonnees(), "Les coordonnées doivent être (3,4)");
        assertEquals(Couleur.values()[0], elem.getCouleur(), "La couleur par défaut doit être la première de l'énumération");
    }

    @Test
    public void testConstructeurAvecValeurs() {
        Element elem = new Element(1, 2, Couleur.ROUGE);
        assertEquals(1, elem.getCoordonnees().getAbscisse(), "L'abscisse doit être 1");
        assertEquals(2, elem.getCoordonnees().getOrdonnee(), "L'ordonnée doit être 2");
        assertEquals(Couleur.ROUGE, elem.getCouleur(), "La couleur doit être ROUGE");
    }

    @Test
    public void testSetters() {
        Element elem = new Element(0, 0);
        elem.setCoordonnees(new Coordonnees(5, 6));
        elem.setCouleur(Couleur.BLEU);
        assertEquals("(5, 6)", elem.getCoordonnees().toString(), "Les coordonnées doivent être (5,6)");
        assertEquals(Couleur.BLEU, elem.getCouleur(), "La couleur doit être BLEU");
    }

    @Test
    public void testToString() {
        Element elem = new Element(7, 8, Couleur.VERT);
        assertEquals("(7, 8) - VERT", elem.toString(), "La représentation en chaîne est incorrecte");
    }

    @Test
    public void testEquals() {
        Element elem1 = new Element(2, 3, Couleur.CYAN);
        Element elem2 = new Element(2, 3, Couleur.CYAN);
        Element elem3 = new Element(1, 5, Couleur.ROUGE);

        assertEquals(elem1, elem2, "Les éléments doivent être égaux");
        assertNotEquals(elem1, elem3, "Les éléments ne doivent pas être égaux");
    }

    @Test
    public void testHashCode() {
        Element elem1 = new Element(2, 3, Couleur.CYAN);
        Element elem2 = new Element(2, 3, Couleur.CYAN);
        assertEquals(elem1.hashCode(), elem2.hashCode(), "Les hashCodes doivent être égaux");
    }

    @Test
    public void testDeplacementValide() {
        Element e = new Element(new Coordonnees(4, 5), Couleur.ROUGE);
        e.deplacerDe(1, 1);
        assertEquals(5, e.getCoordonnees().getAbscisse());
        assertEquals(6, e.getCoordonnees().getOrdonnee());
    }

    @Test
    public void testDeplacementNegatif() {
        Element e = new Element(new Coordonnees(4, 5), Couleur.BLEU);
        e.deplacerDe(-2, -3);
        assertEquals(2, e.getCoordonnees().getAbscisse());
        assertEquals(2, e.getCoordonnees().getOrdonnee());
    }
}
