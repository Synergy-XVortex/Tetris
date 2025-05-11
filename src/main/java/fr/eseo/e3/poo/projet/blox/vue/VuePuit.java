package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.Element;

import javax.swing.*;
import java.awt.*;

// Classe responsable de l'affichage graphique du puits et de la pièce en cours
public class VuePuit extends JPanel {

    // Taille par défaut d'une case (en pixels)
    public static final int TAILLE_PAR_DEFAUT = 20;

    // Référence vers le modèle du puits
    private final Puits puit;
    // Taille des cases pour l'affichage
    private final int taille;

    // Constructeur utilisant la taille par défaut
    public VuePuit(Puits puit) {
        this(puit, TAILLE_PAR_DEFAUT);
    }

    // Constructeur avec taille de case personnalisée
    public VuePuit(Puits puit, int taille) {
        this.puit = puit;
        this.taille = taille;
        // Définit la taille préférée du panneau en fonction du puits et de la taille des cases
        setPreferredSize(new Dimension(puit.getLargeur() * taille, puit.getProfondeur() * taille));
    }

    // Redéfinition de la méthode paintComponent pour dessiner le composant
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        dessinerGrille(g); // Dessine la grille du puits
        dessinerPiece(g, puit.getPieceActuelle()); // Dessine la pièce actuelle
    }

    // Méthode privée pour dessiner la grille du puits
    private void dessinerGrille(Graphics g) {
        g.setColor(Color.LIGHT_GRAY); // Couleur de la grille
        // Lignes verticales
        for (int i = 0; i <= puit.getLargeur(); i++) {
            g.drawLine(i * taille, 0, i * taille, puit.getProfondeur() * taille);
        }
        // Lignes horizontales
        for (int j = 0; j <= puit.getProfondeur(); j++) {
            g.drawLine(0, j * taille, puit.getLargeur() * taille, j * taille);
        }
    }

    // Méthode privée pour dessiner une pièce donnée dans le puits
    private void dessinerPiece(Graphics g, fr.eseo.e3.poo.projet.blox.modele.pieces.Piece piece) {
        if (piece == null) return; // Si aucune pièce, ne rien dessiner

        for (Element element : piece.getElements()) {
            // Coordonnées converties en pixels
            int x = element.getCoordonnees().getAbscisse() * taille;
            int y = element.getCoordonnees().getOrdonnee() * taille;
            // Définition de la couleur de l'élément
            g.setColor(element.getCouleur().getAwtColor());
            // Dessin d'un rectangle 3D
            g.fill3DRect(x, y, taille, taille, true);
        }
    }

    // Getter pour la taille des cases
    public int getTaille() {
        return taille;
    }

    // Getter pour le puits associé
    public Puits getPuit() {
        return puit;
    }
}
