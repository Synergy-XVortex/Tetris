package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.pieces.*;
import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Element;

import javax.swing.*;
import java.awt.*;

// Composant Swing personnalisé permettant l'affichage graphique d'une pièce
public class VuePiece extends JComponent {

    // Constante définissant la taille par défaut d'une case (en pixels)
    public static final int TAILLE_CASE_PAR_DEFAUT = 20;

    // La pièce à afficher
    private final Piece piece;
    // La taille des cases en pixels
    private int taille;

    // Constructeur utilisant la taille par défaut
    public VuePiece(Piece piece) {
        this(piece, TAILLE_CASE_PAR_DEFAUT);
    }

    // Constructeur avec taille de case personnalisée
    public VuePiece(Piece piece, int taille) {
        this.piece = piece;
        this.taille = taille;
        // Définit la taille préférée du composant (suffisante pour 4x4 cases)
        this.setPreferredSize(new Dimension(4 * taille, 4 * taille));
    }

    // Getter pour la taille des cases
    public int getTaille() {
        return taille;
    }

    // Setter pour la taille des cases, puis demande de redessiner le composant
    public void setTaille(int taille) {
        this.taille = taille;
        this.repaint(); // Redessine le composant avec la nouvelle taille
    }

    // Getter pour la pièce affichée
    public Piece getPiece() {
        return piece;
    }

    // Redéfinition de la méthode de dessin du composant
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Appelle la méthode paintComponent de la superclasse

        // Parcourt les éléments de la pièce pour les dessiner
        for (Element element : piece.getElements()) {
            Coordonnees coords = element.getCoordonnees();
            int x = coords.getAbscisse() * taille; // Position X en pixels
            int y = coords.getOrdonnee() * taille; // Position Y en pixels

            // Définit la couleur à utiliser pour dessiner l'élément
            g.setColor(element.getCouleur().getAwtColor());
            // Dessine un rectangle 3D représentant l'élément
            g.fill3DRect(x, y, taille, taille, true);
        }
    }
}
