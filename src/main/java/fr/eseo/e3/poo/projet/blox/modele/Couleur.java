package fr.eseo.e3.poo.projet.blox.modele;

import java.awt.Color;

public enum Couleur {
    BLEU(Color.BLUE),
    ROUGE(Color.RED),
    JAUNE(Color.YELLOW),
    VERT(Color.GREEN),
    ORANGE(Color.ORANGE),
    CYAN(Color.CYAN),
    VIOLET(new Color(128, 0, 128)); // Violet n'existe pas en Color par défaut

    private final Color awtColor;

    Couleur(Color awtColor) {
        this.awtColor = awtColor;
    }

    public Color getAwtColor() {
        return awtColor;
    }
}
