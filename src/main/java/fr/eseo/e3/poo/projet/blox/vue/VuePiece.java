package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

import java.awt.*;

public class VuePiece {

    private final Piece piece;
    private final int taille;

    // Constructeur
    public VuePiece(Piece piece, int taille) {
        this.piece = piece;
        this.taille = taille;
    }

    // Méthode appelée par VuePuits pour afficher la pièce
    public void paintComponent(Graphics g) {
        if (piece == null) return;

        for (Element element : piece.getElements()) {
            // Vérifier que l'élément a bien une couleur
            if (element.getCouleur() != null) {
                // Couleur de l’élément
                g.setColor(element.getCouleur().getCouleurPourAffichage());
            } else {
                g.setColor(Color.BLACK); // Couleur par défaut si la couleur est nulle
            }
            
            // Coordonnées du bloc
            int x = element.getCoordonnees().getAbscisse() * taille;
            int y = element.getCoordonnees().getOrdonnee() * taille;

            // Dessine le bloc 3D
            g.fill3DRect(x, y, taille, taille, true);
        }
    }

    // Accesseurs si nécessaire
    public Piece getPiece() {
        return piece;
    }

    public int getTaille() {
        return taille;
    }
}
