package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.Puits;

import javax.swing.*;
import java.awt.*;

/**
 * Classe VuePuit : Affiche graphiquement le puits du jeu.
 */
public class VuePuit extends JPanel {

    public static final int TAILLE_PAR_DEFAUT = 20; // Taille des cases en pixels

    private final Puits puit;
    private final int taille;

    /**
     * Constructeur avec un puits et une taille de case personnalisée.
     */
    public VuePuit(Puits puit, int taille) {
        this.puit = puit;
        this.taille = taille;
        this.setPreferredSize(new Dimension(puit.getLargeur() * taille, puit.getProfondeur() * taille));
    }

    /**
     * Constructeur par défaut avec la taille prédéfinie.
     */
    public VuePuit(Puits puit) {
        this(puit, TAILLE_PAR_DEFAUT);
    }

    /**
     * Dessine le puits.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        dessinerGrille(g);
    }

    /**
     * Dessine la grille du puits.
     */
    private void dessinerGrille(Graphics g) {
        g.setColor(Color.LIGHT_GRAY);
        for (int i = 0; i <= puit.getLargeur(); i++) {
            g.drawLine(i * taille, 0, i * taille, puit.getProfondeur() * taille);
        }
        for (int j = 0; j <= puit.getProfondeur(); j++) {
            g.drawLine(0, j * taille, puit.getLargeur() * taille, j * taille);
        }
    }
}
