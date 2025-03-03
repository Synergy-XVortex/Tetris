package fr.eseo.e3.poo.projet.blox.modele;

public class Element {
    private Coordonnees coordonnees;
    private Couleur couleur;

    // Constructeurs
    public Element(Coordonnees coordonnees) {
        this(coordonnees, Couleur.values()[0]); // Utilisation de la première couleur par défaut
    }

    public Element(int abscisse, int ordonnee) {
        this(new Coordonnees(abscisse, ordonnee), Couleur.values()[0]);
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

    // Méthode toString()
    @Override
    public String toString() {
        return "(" + coordonnees.getAbscisse() + "," + coordonnees.getOrdonnee() + ")-" + couleur;
    }

    // Redéfinition de equals et hashCode
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Element element = (Element) obj;
        return coordonnees.equals(element.coordonnees) && couleur == element.couleur;
    }

    @Override
    public int hashCode() {
        return coordonnees.hashCode() * 31 + couleur.hashCode();
    }
}
