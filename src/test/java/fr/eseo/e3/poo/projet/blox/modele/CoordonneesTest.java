package fr.eseo.e3.poo.projet.blox.modele;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CoordonneesTest {

    @Test
    public void testConstructeur() {
        Coordonnees coord = new Coordonnees(5, 10);
        assertEquals(5, coord.getAbscisse(), "L'abscisse devrait être 5");
        assertEquals(10, coord.getOrdonnee(), "L'ordonnée devrait être 10");
    }

    @Test
    public void testSetters() {
        Coordonnees coord = new Coordonnees(0, 0);
        coord.setAbscisse(3);
        coord.setOrdonnee(7);
        assertEquals(3, coord.getAbscisse(), "L'abscisse devrait être 3");
        assertEquals(7, coord.getOrdonnee(), "L'ordonnée devrait être 7");
    }

    @Test
    public void testToString() {
        Coordonnees coord = new Coordonnees(2, 8);
        assertEquals("(2, 8)", coord.toString(), "La représentation en chaîne est incorrecte");
    }

    @Test
    public void testEquals() {
        Coordonnees coord1 = new Coordonnees(4, 6);
        Coordonnees coord2 = new Coordonnees(4, 6);
        Coordonnees coord3 = new Coordonnees(1, 9);

        assertEquals(coord1, coord2, "Les coordonnées doivent être égales");
        assertNotEquals(coord1, coord3, "Les coordonnées ne doivent pas être égales");
    }

    @Test
    public void testHashCode() {
        Coordonnees coord1 = new Coordonnees(4, 6);
        Coordonnees coord2 = new Coordonnees(4, 6);
        assertEquals(coord1.hashCode(), coord2.hashCode(), "Les hashCodes doivent être égaux");
    }
}
