package fr.eseo.e3.poo.projet.blox.modele;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ElementTest {
    private Element element1;
    private Element element2;

    @BeforeEach
    public void setUp() {
        element1 = new Element(12, 7, Couleur.VIOLET);
        element2 = new Element(new Coordonnees(5, 3), Couleur.BLEU);
    }

    @Test
    public void testConstructeurAvecCoordonnees() {
        Element element = new Element(new Coordonnees(4, 2));
        assertEquals(4, element.getCoordonnees().getAbscisse());
        assertEquals(2, element.getCoordonnees().getOrdonnee());
        assertNotNull(element.getCouleur()); // Vérifie que la couleur n'est pas null
    }

    @Test
    public void testConstructeurAvecCoordonneesEtCouleur() {
        assertEquals(12, element1.getCoordonnees().getAbscisse());
        assertEquals(7, element1.getCoordonnees().getOrdonnee());
        assertEquals(Couleur.VIOLET, element1.getCouleur());
    }

    @Test
    public void testGettersEtSetters() {
        element1.setCoordonnees(new Coordonnees(8, 6));
        element1.setCouleur(Couleur.ROUGE);
        assertEquals(8, element1.getCoordonnees().getAbscisse());
        assertEquals(6, element1.getCoordonnees().getOrdonnee());
        assertEquals(Couleur.ROUGE, element1.getCouleur());
    }

    @Test
    public void testToString() {
        assertEquals("(12,7)-VIOLET", element1.toString());
        assertEquals("(5,3)-BLEU", element2.toString());
    }

    @Test
    public void testEquals() {
        Element sameAsElement1 = new Element(12, 7, Couleur.VIOLET);
        Element differentElement = new Element(10, 5, Couleur.ROUGE);
        
        assertEquals(element1, sameAsElement1);
        assertNotEquals(element1, differentElement);
    }

    @Test
    public void testHashCode() {
        Element sameAsElement1 = new Element(12, 7, Couleur.VIOLET);
        assertEquals(element1.hashCode(), sameAsElement1.hashCode());
    }
}
