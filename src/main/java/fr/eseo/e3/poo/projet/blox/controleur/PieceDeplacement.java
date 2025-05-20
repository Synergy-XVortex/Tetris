package fr.eseo.e3.poo.projet.blox.controleur;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class PieceDeplacement extends MouseAdapter {

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
                    piece.deplacerDe(delta, 0); // gauche/droite
                    vuePuits.repaint();
                } catch (IllegalArgumentException e) {
                    // déplacement invalide : on ignore
                }
                lastColumn = column;
            }
        }
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent event) {
        Puits puits = vuePuits.getPuits();
        Piece piece = puits.getPieceActuelle();

        if (piece != null && event.getWheelRotation() > 0) {
            try {
                piece.deplacerDe(0, 1); // vers le bas
                vuePuits.repaint();
            } catch (IllegalArgumentException e) {
                // collision ou hors limites, ignoré
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent event) {
        lastColumn = -1; // Réinitialise pour éviter un déplacement involontaire
    }

    public void setVuePuits(VuePuits vuePuits) {
        this.vuePuits = vuePuits;
    }
}
