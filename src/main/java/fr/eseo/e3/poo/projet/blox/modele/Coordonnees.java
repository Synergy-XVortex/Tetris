package fr.eseo.e3.poo.projet.blox.modele;

import java.util.Objects;

public class Coordonnees {
    // Attributs de la classe
    private int abscisse;
    private int ordonnee;

    // Constructeur
    public Coordonnees(int abscisse, int ordonnee) {
        this.abscisse = abscisse;
        this.ordonnee = ordonnee;
    }

    // Accesseurs (getters)
    public int getAbscisse() {
        return abscisse;
    }

    public int getOrdonnee() {
        return ordonnee;
    }

    // Mutateurs (setters)
    public void setAbscisse(int abscisse) {
        this.abscisse = abscisse;
    }

    public void setOrdonnee(int ordonnee) {
        this.ordonnee = ordonnee;
    }

    // Redéfinition de la méthode toString()
    @Override
    public String toString() {
        return "(" + abscisse + ", " + ordonnee + ")";
    }

    // Redéfinition de la méthode equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Coordonnees that = (Coordonnees) obj;
        return abscisse == that.abscisse && ordonnee == that.ordonnee;
    }

    // Redéfinition de la méthode hashCode
    @Override
    public int hashCode() {
        return Objects.hash(abscisse, ordonnee);
    }
}
