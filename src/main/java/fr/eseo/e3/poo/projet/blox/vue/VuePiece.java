package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.pieces.*;
import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Element;

import javax.swing.*;
import java.awt.*;

public class VuePiece extends JComponent {

    // Constante : taille des cases (en pixels)
    public static final int TAILLE_CASE_PAR_DEFAUT = 20;

    private final Piece piece;
    private int taille;

    // Constructeur
    public VuePiece(Piece piece) {
        this(piece, TAILLE_CASE_PAR_DEFAUT);
    }

    public VuePiece(Piece piece, int taille) {
        this.piece = piece;
        this.taille = taille;
        this.setPreferredSize(new Dimension(4 * taille, 4 * taille));
    }

    // Getter/Setter pour taille
    public int getTaille() {
        return taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
        this.repaint();
    }

    public Piece getPiece() {
        return piece;
    }

    // Méthode d'affichage
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Element element : piece.getElements()) {
            Coordonnees coords = element.getCoordonnees();
            int x = coords.getAbscisse() * taille;
            int y = coords.getOrdonnee() * taille;

            g.setColor(element.getCouleur().getAwtColor());
            g.fill3DRect(x, y, taille, taille, true);
        }
    }
}
