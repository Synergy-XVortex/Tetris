package fr.eseo.e3.poo.projet.blox.modele;

import static org.junit.Assert.*;
import org.junit.Test;

public class CoordonneesTest {

    @Test
    public void testConstructeur() {
        Coordonnees coord = new Coordonnees(5, 10);
        assertEquals("L'abscisse doit être 5", 5, coord.getAbscisse());
        assertEquals("L'ordonnée doit être 10", 10, coord.getOrdonnee());
    }

    @Test
    public void testSetters() {
        Coordonnees coord = new Coordonnees(0, 0);
        coord.setAbscisse(7);
        coord.setOrdonnee(14);
        assertEquals("L'abscisse doit être 7", 7, coord.getAbscisse());
        assertEquals("L'ordonnée doit être 14", 14, coord.getOrdonnee());
    }

    @Test
    public void testToString() {
        Coordonnees coord = new Coordonnees(3, 8);
        assertEquals("La méthode toString() doit retourner (3, 8)", "(3, 8)", coord.toString());
    }

    @Test
    public void testEquals() {
        Coordonnees coord1 = new Coordonnees(2, 6);
        Coordonnees coord2 = new Coordonnees(2, 6);
        Coordonnees coord3 = new Coordonnees(3, 6);
        
        assertTrue("Deux objets avec les mêmes coordonnées doivent être égaux", coord1.equals(coord2));
        assertFalse("Deux objets avec des coordonnées différentes ne doivent pas être égaux", coord1.equals(coord3));
    }

    @Test
    public void testHashCode() {
        Coordonnees coord1 = new Coordonnees(4, 9);
        Coordonnees coord2 = new Coordonnees(4, 9);
        assertEquals("Deux objets égaux doivent avoir le même hashCode", coord1.hashCode(), coord2.hashCode());
    }
}
