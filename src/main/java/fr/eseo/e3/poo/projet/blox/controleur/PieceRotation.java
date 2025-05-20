package fr.eseo.e3.poo.projet.blox.controleur;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

import javax.swing.SwingUtilities;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PieceRotation extends MouseAdapter {

    private final VuePuits vuePuits;

    public PieceRotation(VuePuits vuePuits) {
        this.vuePuits = vuePuits;
    }

    @Override
    public void mouseClicked(MouseEvent event) {
        Puits puits = vuePuits.getPuits();
        Piece piece = puits.getPieceActuelle();

        if (piece != null) {
            try {
                if (SwingUtilities.isLeftMouseButton(event)) {
                    piece.tourner(false); // anti-horaire
                } else if (SwingUtilities.isRightMouseButton(event)) {
                    piece.tourner(true); // horaire
                }
                vuePuits.repaint(); // Met à jour l'affichage
            } catch (IllegalArgumentException e) {
                // Si la rotation est invalide, on l'ignore
            }
        }
    }
}
