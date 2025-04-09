package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.Element;

import javax.swing.*;
import java.awt.*;

public class VuePuit extends JPanel {

    public static final int TAILLE_PAR_DEFAUT = 20;

    private final Puits puit;
    private final int taille;

    public VuePuit(Puits puit) {
        this(puit, TAILLE_PAR_DEFAUT);
    }

    public VuePuit(Puits puit, int taille) {
        this.puit = puit;
        this.taille = taille;
        setPreferredSize(new Dimension(puit.getLargeur() * taille, puit.getProfondeur() * taille));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        dessinerGrille(g);
        dessinerPiece(g, puit.getPieceActuelle());
    }

    private void dessinerGrille(Graphics g) {
        g.setColor(Color.LIGHT_GRAY);
        for (int i = 0; i <= puit.getLargeur(); i++) {
            g.drawLine(i * taille, 0, i * taille, puit.getProfondeur() * taille);
        }
        for (int j = 0; j <= puit.getProfondeur(); j++) {
            g.drawLine(0, j * taille, puit.getLargeur() * taille, j * taille);
        }
    }

    private void dessinerPiece(Graphics g, fr.eseo.e3.poo.projet.blox.modele.pieces.Piece piece) {
        if (piece == null) return;

        for (Element element : piece.getElements()) {
            int x = element.getCoordonnees().getAbscisse() * taille;
            int y = element.getCoordonnees().getOrdonnee() * taille;
            g.setColor(element.getCouleur().getAwtColor());
            g.fill3DRect(x, y, taille, taille, true);
        }
    }

    public int getTaille() {
        return taille;
    }

    public Puits getPuit() {
        return puit;
    }
}
