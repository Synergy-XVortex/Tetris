package fr.eseo.e3.poo.projet.blox.modele;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.Random;

public class TasTest {

    @Test
    public void testConstructeurVide() {
        Puits puits = new Puits(10, 20);
        Tas tas = new Tas(puits);
        assertNotNull(tas.getElements());
        assertEquals(0, tas.getElements().size());
        assertSame(puits, tas.getPuits());
    }

    @Test
    public void testConstructeurAvecElementsEtLignes() {
        Puits puits = new Puits(10, 20);
        Tas tas = new Tas(puits, 10, 2);
        assertEquals(10, tas.getElements().size());
    }

    @Test
    public void testElementExiste() {
        Puits puits = new Puits(10, 20);
        Tas tas = new Tas(puits);
        tas.getElements().add(new Element(2, 19, Couleur.ROUGE));
        tas.getElements().add(new Element(5, 18, Couleur.VERT));

        assertTrue(tas.elementExists(2, 19));
        assertTrue(tas.elementExists(5, 18));
        assertFalse(tas.elementExists(3, 17));
    }

    @Test
    public void testConstructeurAvecRandomDeterministe() {
        Puits puits = new Puits(10, 20);
        Random rand = new Random(42); // seed connu
        Tas tas = new Tas(puits, 5, 1, rand);

        assertEquals(5, tas.getElements().size());
    }

    @Test
    public void testConstructeurAvecElementsSeulement() {
        Puits puits = new Puits(10, 20);
        Tas tas = new Tas(puits, 25); // largeur = 10, donc 25 // 10 + 1 = 3 lignes
        assertEquals(25, tas.getElements().size());
    }

    @Test
    public void testExceptionLignesTropGrandes() {
        Puits puits = new Puits(10, 5); // profondeur faible
        assertThrows(IllegalArgumentException.class, () -> new Tas(puits, 10, 6));
    }

    @Test
    public void testExceptionTropDElements() {
        Puits puits = new Puits(10, 20);
        assertThrows(IllegalArgumentException.class, () -> new Tas(puits, 21, 2)); // max = 20
    }
}
