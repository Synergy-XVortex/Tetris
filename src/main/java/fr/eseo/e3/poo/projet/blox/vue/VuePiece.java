package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;
import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Element;

import javax.swing.*;
import java.awt.*;

public class VuePiece extends JComponent {

    public static final int TAILLE_CASE_PAR_DEFAUT = 20;

    private final Piece piece;
    private int taille;

    public VuePiece(Piece piece) {
        this(piece, TAILLE_CASE_PAR_DEFAUT);
    }

    public VuePiece(Piece piece, int taille) {
        this.piece = piece;
        this.taille = taille;
        this.setPreferredSize(new Dimension(4 * taille, 4 * taille));
    }

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

    /**
     * Méthode personnalisée pour dessiner la pièce à partir d'un Graphics externe (ex: VuePuits).
     */
    public void afficherPiece(Graphics g) {
        for (Element element : piece.getElements()) {
            Coordonnees coords = element.getCoordonnees();
            int x = coords.getAbscisse() * taille;
            int y = coords.getOrdonnee() * taille;

            g.setColor(element.getCouleur().getAwtColor()); // Doit exister dans Couleur
            g.fill3DRect(x, y, taille, taille, true);

            g.setColor(Color.BLACK); // contour pour lisibilité
            g.drawRect(x, y, taille, taille);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        afficherPiece(g); // Pour affichage si ajouté à un conteneur
    }
}
