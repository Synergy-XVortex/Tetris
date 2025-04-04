package fr.eseo.e3.poo.projet.blox.modele;

import static org.junit.jupiter.api.Assertions.*;
import java.awt.Color;
import org.junit.jupiter.api.Test;

public class CouleurTest {

    @Test
    public void testCouleursCorrespondent() {
        // Vérifie que chaque couleur de l'énumération a une valeur correcte
        assertEquals(new Color(0, 0, 255), Couleur.BLEU.getAwtColor(), "BLEU incorrect");
        assertEquals(new Color(255, 0, 0), Couleur.ROUGE.getAwtColor(), "ROUGE incorrect");
        assertEquals(new Color(255, 255, 0), Couleur.JAUNE.getAwtColor(), "JAUNE incorrect");
        assertEquals(new Color(0, 255, 0), Couleur.VERT.getAwtColor(), "VERT incorrect");
        assertEquals(new Color(255, 200, 0), Couleur.ORANGE.getAwtColor(), "ORANGE incorrect");
        assertEquals(new Color(0, 255, 255), Couleur.CYAN.getAwtColor(), "CYAN incorrect");
        assertEquals(new Color(128, 0, 128), Couleur.VIOLET.getAwtColor(), "VIOLET incorrect");
    }

    @Test
    public void testToutesLesCouleursSontDifferentes() {
        // Vérifie que toutes les couleurs sont uniques
        Couleur[] couleurs = Couleur.values();
        for (int i = 0; i < couleurs.length; i++) {
            for (int j = i + 1; j < couleurs.length; j++) {
                assertNotEquals(couleurs[i].getAwtColor(), couleurs[j].getAwtColor(),
                        "Les couleurs " + couleurs[i] + " et " + couleurs[j] + " sont identiques !");
            }
        }
    }
}
