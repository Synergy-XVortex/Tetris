package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class VuePuits extends JPanel implements PropertyChangeListener {

    public static final int TAILLE_PAR_DEFAUT = 20;

    private Puits puits;
    private int taille;
    private VuePiece vuePiece;

    /* ------------- Constructeurs ------------- */

    public VuePuits(Puits puits) {
        this(puits, TAILLE_PAR_DEFAUT);
    }

    public VuePuits(Puits puits, int taille) {
        this.puits = puits;
        this.taille = taille;

        // Enregistre VuePuits comme observateur du Puits
        this.puits.addPropertyChangeListener(this);

        // Définit la taille du composant Swing en fonction du puits
        setPreferredSize(new Dimension(
                puits.getLargeur() * taille,
                puits.getProfondeur() * taille));

        // Initialise la VuePiece si déjà une pièce actuelle
        if (puits.getPieceActuelle() != null) {
            this.vuePiece = new VuePiece(puits.getPieceActuelle(), taille);
        }
    }

    /* ------------- Affichage graphique ------------- */

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        dessinerGrille(g);
        dessinerPieceActuelle(g);
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

    private void dessinerPieceActuelle(Graphics g) {
        if (vuePiece != null) {
            vuePiece.paintComponent(g); // Dessine les blocs de la pièce à la bonne position
        }
    }

    /* ------------- Réception des notifications ------------- */

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (Puits.MODIFICATION_PIECE_ACTUELLE.equals(evt.getPropertyName())) {
            Piece nouvellePiece = (Piece) evt.getNewValue();
            this.vuePiece = new VuePiece(nouvellePiece, taille);
            repaint();
        }
    }

    /* ------------- Accesseurs / Modificateurs ------------- */

    public int getTaille() {
        return taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
        repaint();
    }

    public Puits getPuits() {
        return puits;
    }

    public VuePiece getVuePiece() {
        return vuePiece;
    }

    public void setPuits(Puits nouveau) {
        if (this.puits != null) {
            this.puits.removePropertyChangeListener(this);
        }
        this.puits = nouveau;
        if (nouveau != null) {
            nouveau.addPropertyChangeListener(this);
            if (nouveau.getPieceActuelle() != null) {
                this.vuePiece = new VuePiece(nouveau.getPieceActuelle(), taille);
            }
            repaint();
        }
    }
}
