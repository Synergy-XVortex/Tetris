package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class VuePuit extends JPanel implements PropertyChangeListener {

    public static final int TAILLE_PAR_DEFAUT = 20;

    private Puits puits;
    private int   taille;
    /* ✨ Vue de la pièce actuelle */
    private VuePiece vuePiece;

    /* ---------------- constructeurs ---------------- */
    public VuePuit(Puits puits) {
        this(puits, TAILLE_PAR_DEFAUT);
    }
    public VuePuit(Puits puits, int taille) {
        this.puits  = puits;
        this.taille = taille;
        setPreferredSize(new Dimension(
                puits.getLargeur() * taille,
                puits.getProfondeur() * taille));
        /* s’enregistre pour écouter le modèle */
        puits.addPropertyChangeListener(this);
        /* crée la première VuePiece si une pièce est déjà fixée */
        if (puits.getPieceActuelle() != null)
            setVuePiece(new VuePiece(puits.getPieceActuelle(), taille));
    }

    /* --------------- paintComponent ---------------- */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        dessinerGrille(g);
        dessinerPieceActuelle(g);
    }

    private void dessinerGrille(Graphics g) {
        g.setColor(Color.LIGHT_GRAY);
        for (int i = 0; i <= puits.getLargeur(); i++)
            g.drawLine(i * taille, 0,
                       i * taille, puits.getProfondeur() * taille);
        for (int j = 0; j <= puits.getProfondeur(); j++)
            g.drawLine(0, j * taille,
                       puits.getLargeur() * taille, j * taille);
    }

    private void dessinerPieceActuelle(Graphics g) {
        if (vuePiece == null) return;
        /* délègue simplement le dessin à VuePiece */
        vuePiece.paintComponent(g);
    }

    /* ------------- PropertyChangeListener ---------- */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (Puits.MODIFICATION_PIECE_ACTUELLE.equals(evt.getPropertyName())) {
            Piece nouvelle = (Piece) evt.getNewValue();
            setVuePiece(new VuePiece(nouvelle, taille));
            repaint();
        }
    }

    /* ------------ getters / setters utiles --------- */
    public int  getTaille()      { return taille; }
    public Puits getPuit()       { return puits; }
    public VuePiece getVuePiece(){ return vuePiece; }

    public void setTaille(int taille) {
        this.taille = taille;
        repaint();
    }

    public void setPuits(Puits nouveau) {
        if (this.puits != null)
            this.puits.removePropertyChangeListener(this);
        this.puits = nouveau;
        if (nouveau != null) {
            nouveau.addPropertyChangeListener(this);
            /* recalcule la VuePiece selon la nouvelle pièce actuelle */
            if (nouveau.getPieceActuelle() != null)
                setVuePiece(new VuePiece(nouveau.getPieceActuelle(), taille));
            repaint();
        }
    }

    /* ✨ désormais PRIVÉ : on ne modifie la vue que via propertyChange */
    private void setVuePiece(VuePiece vuePiece) {
        this.vuePiece = vuePiece;
    }
}
