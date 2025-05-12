package fr.eseo.e3.poo.projet.blox.controleur;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class PieceDeplacement implements MouseMotionListener {

    private VuePuits vuePuits;
    private int lastColumn = -1;

    public PieceDeplacement(VuePuits vuePuits) {
        this.vuePuits = vuePuits;
    }

    @Override
    public void mouseMoved(MouseEvent event) {
        Puits puits = vuePuits.getPuits();
        Piece piece = puits.getPieceActuelle();

        if (piece != null) {
            int column = event.getX() / vuePuits.getTaille();

            if (column != lastColumn) {
                int delta = column - lastColumn;
                try {
                    // déplace la pièce de +1 (droite) ou -1 (gauche)
                    piece.deplacerDe(delta, 0);
                    vuePuits.repaint();
                } catch (IllegalArgumentException e) {
                    // déplacement invalide ignoré
                }
                lastColumn = column;
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent event) {
        // non utilisé pour l’instant
    }

    public void setVuePuits(VuePuits vuePuits) {
        this.vuePuits = vuePuits;
    }
}
