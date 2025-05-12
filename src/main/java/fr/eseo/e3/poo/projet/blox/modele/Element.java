package fr.eseo.e3.poo.projet.blox.modele;

import java.util.Objects;

public class Element {
    
    private Coordonnees coordonnees;
    private Couleur couleur;

    // Constructeurs
    public Element(Coordonnees coordonnees) {
        this(coordonnees, Couleur.values()[0]); // Première couleur de l'énumération
    }

    public Element(int abscisse, int ordonnee) {
        this(new Coordonnees(abscisse, ordonnee));
    }

    public Element(Coordonnees coordonnees, Couleur couleur) {
        this.coordonnees = coordonnees;
        this.couleur = couleur;
    }

    public Element(int abscisse, int ordonnee, Couleur couleur) {
        this(new Coordonnees(abscisse, ordonnee), couleur);
    }

    // Getters et Setters
    public Coordonnees getCoordonnees() {
        return coordonnees;
    }

    public void setCoordonnees(Coordonnees coordonnees) {
        this.coordonnees = coordonnees;
    }

    public Couleur getCouleur() {
        return couleur;
    }

    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }

    // Redéfinition de toString()
    @Override
    public String toString() {
        return coordonnees.toString() + " - " + couleur;
    }

    // Redéfinition de equals() et hashCode()
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Element element = (Element) obj;
        return Objects.equals(coordonnees, element.coordonnees) && couleur == element.couleur;
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordonnees, couleur);
    }

    public void setCoordonnees(int abscisse, int ordonnee) {
        this.coordonnees = new Coordonnees(abscisse, ordonnee);
    }

    public void deplacerDe(int deltaX, int deltaY) {
        int nouveauX = this.coordonnees.getAbscisse() + deltaX;
        int nouveauY = this.coordonnees.getOrdonnee() + deltaY;
        this.coordonnees = new Coordonnees(nouveauX, nouveauY);
    }    
}
