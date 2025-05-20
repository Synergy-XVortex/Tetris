package fr.eseo.e3.poo.projet.blox.modele;

public class BloxException extends Exception {

    // Types d'exception
    public static final int BLOX_COLLISION = 1;
    public static final int BLOX_SORTIE_PUITS = 2;

    // Attribut : code de l'erreur
    private final int type;

    // Constructeur
    public BloxException(String message, int type) {
        super(message);
        this.type = type;
    }

    // Getter pour le type de l'exception
    public int getType() {
        return this.type;
    }
}
