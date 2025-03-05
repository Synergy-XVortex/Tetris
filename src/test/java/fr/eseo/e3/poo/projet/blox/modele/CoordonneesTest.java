package fr.eseo.e3.poo.projet.blox.modele;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CoordonneesTest {

    @Test
    public void testConstructeur() {
        Coordonnees coord = new Coordonnees(5, 10);
        assertEquals(5, coord.getAbscisse(), "L'abscisse doit être 5");
        assertEquals(10, coord.getOrdonnee(), "L'ordonnée doit être 10");
    }

    @Test
    public void testSetters() {
        Coordonnees coord = new Coordonnees(0, 0);
        coord.setAbscisse(7);
        coord.setOrdonnee(14);
        assertEquals(7, coord.getAbscisse(), "L'abscisse doit être 7");
        assertEquals(14, coord.getOrdonnee(), "L'ordonnée doit être 14");
    }

    @Test
    public void testToString() {
        Coordonnees coord = new Coordonnees(3, 8);
        assertEquals("(3, 8)", coord.toString(), "La méthode toString() doit retourner (3, 8)");
    }

    @Test
    public void testEquals() {
        Coordonnees coord1 = new Coordonnees(2, 6);
        Coordonnees coord2 = new Coordonnees(2, 6);
        Coordonnees coord3 = new Coordonnees(3, 6);
        
        assertTrue(coord1.equals(coord2), "Deux objets avec les mêmes coordonnées doivent être égaux");
        assertFalse(coord1.equals(coord3), "Deux objets avec des coordonnées différentes ne doivent pas être égaux");
    }

    @Test
    public void testHashCode() {
        Coordonnees coord1 = new Coordonnees(4, 9);
        Coordonnees coord2 = new Coordonnees(4, 9);
        assertEquals(coord1.hashCode(), coord2.hashCode(), "Deux objets égaux doivent avoir le même hashCode");
    }
}
