package fr.eseo.e3.poo.projet.blox.modele;

import java.util.Objects;

// Classe représentant un élément avec des coordonnées et une couleur
public class Element {
    
    // Coordonnées de l'élément
    private Coordonnees coordonnees;
    // Couleur associée à l'élément
    private Couleur couleur;

    // Constructeur avec uniquement des coordonnées, couleur par défaut (première de l'énumération)
    public Element(Coordonnees coordonnees) {
        this(coordonnees, Couleur.values()[0]); // Première couleur de l'énumération
    }

    // Constructeur avec des valeurs entières pour les coordonnées
    public Element(int abscisse, int ordonnee) {
        this(new Coordonnees(abscisse, ordonnee));
    }

    // Constructeur avec coordonnées et couleur
    public Element(Coordonnees coordonnees, Couleur couleur) {
        this.coordonnees = coordonnees;
        this.couleur = couleur;
    }

    // Constructeur avec coordonnées entières et couleur
    public Element(int abscisse, int ordonnee, Couleur couleur) {
        this(new Coordonnees(abscisse, ordonnee), couleur);
    }

    // Getter pour les coordonnées
    public Coordonnees getCoordonnees() {
        return coordonnees;
    }

    // Setter pour les coordonnées
    public void setCoordonnees(Coordonnees coordonnees) {
        this.coordonnees = coordonnees;
    }

    // Getter pour la couleur
    public Couleur getCouleur() {
        return couleur;
    }

    // Setter pour la couleur
    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }

    // Redéfinition de toString() pour afficher les coordonnées suivies de la couleur
    @Override
    public String toString() {
        return coordonnees.toString() + " - " + couleur;
    }

    // Redéfinition de equals() pour comparer deux éléments
    @Override
    public boolean equals(Object obj) {
        // Vérifie si l'objet est le même
        if (this == obj) return true;
        // Vérifie si l'objet est null ou d'une autre classe
        if (obj == null || getClass() != obj.getClass()) return false;
        // Cast et comparaison des attributs
        Element element = (Element) obj;
        return Objects.equals(coordonnees, element.coordonnees) && couleur == element.couleur;
    }

    // Redéfinition de hashCode() pour assurer la cohérence avec equals()
    @Override
    public int hashCode() {
        return Objects.hash(coordonnees, couleur);
    }

    // Setter alternatif pour les coordonnées via deux entiers
    public void setCoordonnees(int abscisse, int ordonnee) {
        this.coordonnees = new Coordonnees(abscisse, ordonnee);
    }
}
