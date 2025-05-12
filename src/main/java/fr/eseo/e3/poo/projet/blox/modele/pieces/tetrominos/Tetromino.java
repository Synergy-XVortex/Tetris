package fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

// Classe abstraite représentant un Tetromino
public abstract class Tetromino implements Piece {

    // Tableau d'éléments de la pièce
    protected Element[] elements = new Element[4];

    // Couleur de la pièce
    protected Couleur couleur;

    // Constructeur
    public Tetromino(Coordonnees coordonnees, Couleur couleur) {
        this.couleur = couleur;
        setElements(coordonnees, couleur);
    }

    // Méthode abstraite à implémenter dans chaque forme concrète
    protected abstract void setElements(Coordonnees coordonnees, Couleur couleur);

    // Retourne les 4 éléments constituant la pièce
    @Override
    public Element[] getElements() {
        return elements;
    }

    // Déplace la pièce à une nouvelle position
    @Override
    public void setPosition(int abscisse, int ordonnee) {
        int dx = abscisse - elements[0].getCoordonnees().getAbscisse();
        int dy = ordonnee - elements[0].getCoordonnees().getOrdonnee();

        for (Element element : elements) {
            element.setCoordonnees(new Coordonnees(
                element.getCoordonnees().getAbscisse() + dx,
                element.getCoordonnees().getOrdonnee() + dy
            ));
        }
    }

    // Déplace la pièce dans une direction valide
    @Override
    public void deplacerDe(int deltaX, int deltaY) {
        if (!((deltaX == 0 && deltaY == 1) ||     // vers le bas
              (deltaX == -1 && deltaY == 0) ||    // gauche
              (deltaX == 1 && deltaY == 0))) {    // droite
            throw new IllegalArgumentException("Déplacement invalide : seul bas, gauche ou droite autorisés.");
        }

        for (Element element : elements) {
            element.deplacerDe(deltaX, deltaY);
        }
    }

    // Fait tourner la pièce autour de son élément de référence
    @Override
    public void tourner(boolean sensHoraire) {
        Coordonnees ref = elements[0].getCoordonnees(); // Élément de référence
        int refX = ref.getAbscisse();
        int refY = ref.getOrdonnee();

        for (int i = 1; i < elements.length; i++) {
            Element e = elements[i];
            int x = e.getCoordonnees().getAbscisse() - refX;
            int y = e.getCoordonnees().getOrdonnee() - refY;

            int xPrime, yPrime;
            if (sensHoraire) {
                xPrime =  y;
                yPrime = -x;
            } else {
                xPrime = -y;
                yPrime =  x;
            }

            e.setCoordonnees(refX + xPrime, refY + yPrime);
        }
    }

    // Représentation textuelle de la pièce
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(this.getClass().getSimpleName() + " :\n");
        for (Element element : elements) {
            sb.append(element).append("\n");
        }
        return sb.toString().trim();
    }
}
