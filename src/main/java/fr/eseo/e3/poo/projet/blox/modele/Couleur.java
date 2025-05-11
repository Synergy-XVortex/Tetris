package fr.eseo.e3.poo.projet.blox.modele;

import java.awt.Color;

// Énumération représentant différentes couleurs utilisées dans le projet
public enum Couleur {
    // Définition des constantes de l'énumération avec leurs couleurs correspondantes en AWT
    BLEU(Color.BLUE),
    ROUGE(Color.RED),
    JAUNE(Color.YELLOW),
    VERT(Color.GREEN),
    ORANGE(Color.ORANGE),
    CYAN(Color.CYAN),
    VIOLET(new Color(128, 0, 128)); // VIOLET n'existe pas dans java.awt.Color, donc on le crée manuellement

    // Champ privé associant chaque énumération à une couleur AWT
    private final Color awtColor;

    // Constructeur privé pour l'énumération
    Couleur(Color awtColor) {
        this.awtColor = awtColor;
    }

    // Méthode d'accès pour obtenir la couleur AWT associée à l'énumération
    public Color getAwtColor() {
        return awtColor;
    }
}
