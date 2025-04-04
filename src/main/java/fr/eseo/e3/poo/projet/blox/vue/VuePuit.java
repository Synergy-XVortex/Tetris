package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.Puits;

import javax.swing.*;
import java.awt.*;

/**
 * Classe VuePuits : Affiche graphiquement le puits du jeu.
 */
public class VuePuits extends JPanel {

    public static final int TAILLE_PAR_DEFAUT = 20; // Taille des cases en pixels

    private final Puits puits;
    private final int taille;

    /**
     * Constructeur avec un puits et une taille de case personnalisée.
     */
    public VuePuits(Puits puits, int taille) {
        this.puits = puits;
        this.taille = taille;
        this.setPreferredSize(new Dimension(puits.getLargeur() * taille, puits.getProfondeur() * taille));
        this.setBackground(Color.WHITE); // Ajout d'un fond blanc
    }

    /**
     * Constructeur par défaut avec la taille prédéfinie.
     */
    public VuePuits(Puits puits) {
        this(puits, TAILLE_PAR_DEFAUT);
    }

    /**
     * Dessine le puits.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        dessinerFond(g);
        dessinerGrille(g);
        dessinerBordures(g);
    }

    /**
     * Dessine la grille du puits.
     */
    private void dessinerGrille(Graphics g) {
        g.setColor(Color.LIGHT_GRAY);
        for (int i = 0; i <= puits.getLargeur(); i++) {
            g.drawLine(i * taille, 0, i * taille, puits.getProfondeur() * taille);
        }
        for (int j = 0; j <= puits.getProfondeur(); j++) {
            g.drawLine(0, j * taille, puits.getLargeur() * taille, j * taille);
        }
    }

    /**
     * Dessine le fond du puits.
     */
    private void dessinerFond(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
    }

    /**
     * Dessine les bordures du puits.
     */
    private void dessinerBordures(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
    }
}
