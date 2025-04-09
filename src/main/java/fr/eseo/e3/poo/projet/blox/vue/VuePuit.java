package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.Puits;

import javax.swing.*;
import java.awt.*;

/**
 * Classe VuePuit : Affiche graphiquement le puits du jeu.
 */
public class VuePuit extends JPanel {

    public static final int TAILLE_PAR_DEFAUT = 20; // Taille des cases en pixels

    private final Puits puits;
    private final int taille;
    private VuePiece vuePiece; // Association avec VuePiece

    /**
     * Constructeur avec un puits et une taille de case personnalisée.
     */
    public VuePuit(Puits puits, int taille) {
        this.puits = puits;
        this.taille = taille;
        this.vuePiece = null; // Aucune VuePiece associée au départ
        this.setPreferredSize(new Dimension(puits.getLargeur() * taille, puits.getProfondeur() * taille));
        this.setBackground(Color.WHITE); // Fond blanc
    }

    /**
     * Constructeur par défaut avec la taille prédéfinie.
     */
    public VuePuit(Puits puits) {
        this(puits, TAILLE_PAR_DEFAUT);
    }

    // Accesseur pour vuePiece
    public VuePiece getVuePiece() {
        return this.vuePiece;
    }

    // Mutateur pour vuePiece
    public void setVuePiece(VuePiece vuePiece) {
        this.vuePiece = vuePiece;
        this.repaint(); // Repeindre à chaque changement
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

        // Dessine la VuePiece si elle est présente
        if (this.vuePiece != null) {
            Graphics2D g2d = (Graphics2D) g.create();
            vuePiece.paintComponent(g2d); // Appel de l'affichage de la pièce
            g2d.dispose();
        }
    }

    private void dessinerGrille(Graphics g) {
        g.setColor(Color.LIGHT_GRAY);
        for (int i = 0; i <= puits.getLargeur(); i++) {
            g.drawLine(i * taille, 0, i * taille, puits.getProfondeur() * taille);
        }
        for (int j = 0; j <= puits.getProfondeur(); j++) {
            g.drawLine(0, j * taille, puits.getLargeur() * taille, j * taille);
        }
    }

    private void dessinerFond(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
    }

    private void dessinerBordures(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
    }
}
