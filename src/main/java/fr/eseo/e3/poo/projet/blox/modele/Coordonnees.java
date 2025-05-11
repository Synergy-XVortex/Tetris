package fr.eseo.e3.poo.projet.blox.modele;

import java.util.Objects;

// Classe représentant des coordonnées en deux dimensions (x, y)
public class Coordonnees {
    
    // Champs privés représentant les composantes x (abscisse) et y (ordonnée)
    private int abscisse;
    private int ordonnee;

    // Constructeur initialisant les coordonnées avec une abscisse et une ordonnée données
    public Coordonnees(int abscisse, int ordonnee) {
        this.abscisse = abscisse;
        this.ordonnee = ordonnee;
    }

    // Accesseur pour l'abscisse
    public int getAbscisse() {
        return abscisse;
    }

    // Mutateur pour l'abscisse
    public void setAbscisse(int abscisse) {
        this.abscisse = abscisse;
    }

    // Accesseur pour l'ordonnée
    public int getOrdonnee() {
        return ordonnee;
    }

    // Mutateur pour l'ordonnée
    public void setOrdonnee(int ordonnee) {
        this.ordonnee = ordonnee;
    }

    // Redéfinition de toString pour représenter les coordonnées sous forme "(x, y)"
    @Override
    public String toString() {
        return "(" + abscisse + ", " + ordonnee + ")";
    }

    // Redéfinition de equals pour comparer deux objets Coordonnees
    @Override
    public boolean equals(Object obj) {
        // Vérifie si l'objet est identique à l'instance courante
        if (this == obj) return true;
        // Vérifie si l'objet est null ou d'une autre classe
        if (obj == null || getClass() != obj.getClass()) return false;
        // Cast de l'objet et comparaison des champs
        Coordonnees that = (Coordonnees) obj;
        return abscisse == that.abscisse && ordonnee == that.ordonnee;
    }

    // Redéfinition de hashCode pour assurer la cohérence avec equals
    @Override
    public int hashCode() {
        return Objects.hash(abscisse, ordonnee);
    }
}
