package fr.eseo.e3.poo.projet.blox.modele;

import java.awt.Color;

/**
 * Enumération des couleurs possibles pour les pièces du jeu.
 * Chaque valeur est associée à une couleur AWT pour l'affichage graphique.
 */
public enum Couleur {
    ROUGE(Color.RED),
    VERT(Color.GREEN),
    BLEU(Color.BLUE),
    CYAN(Color.CYAN),
    JAUNE(Color.YELLOW),
    ORANGE(Color.ORANGE);

    // Attribut de type Color de la bibliothèque AWT
    private final Color couleurAWT;

    /**
     * Constructeur associant chaque constante de l'énum à une couleur AWT.
     * @param couleurAWT la couleur Java (AWT) associée
     */
    Couleur(Color couleurAWT) {
        this.couleurAWT = couleurAWT;
    }

    /**
     * Accesseur permettant de récupérer la couleur AWT pour affichage.
     * Cette méthode est utilisée dans les classes VuePiece et VuePuits.
     * @return la couleur AWT correspondant à cette énumération
     */
    public Color getCouleurPourAffichage() {
        return this.couleurAWT;
    }
}
