package fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

// Classe abstraite représentant un Tetromino (une pièce du jeu Tetris)
// Implémente l'interface Piece pour assurer le comportement de toutes les pièces
public abstract class Tetromino implements Piece {

    // Tableau d'éléments (les "briques" du tetromino)
    protected Element[] elements = new Element[4];

    // Constructeur qui initialise la position et la couleur des éléments du tetromino
    public Tetromino(Coordonnees coordonnees, Couleur couleur) {
        setElements(coordonnees, couleur); // Appelle la méthode abstraite pour définir les éléments du tetromino
    }

    // Méthode abstraite pour définir les éléments (briques) de la pièce
    // Chaque sous-classe (par exemple, OTetromino, ITetromino) doit définir la façon dont les éléments sont placés
    protected abstract void setElements(Coordonnees coordonnees, Couleur couleur);

    // Implémentation de la méthode getElements() de l'interface Piece
    // Retourne les éléments (briques) du tetromino
    @Override
    public Element[] getElements() {
        return elements;
    }

    // Implémentation de la méthode setPosition() de l'interface Piece
    // Déplace le tetromino à la nouvelle position spécifiée par abscisse et ordonnée
    @Override
    public void setPosition(int abscisse, int ordonnee) {
        // Calcul des différences de position (dx, dy) entre la position actuelle et la nouvelle position
        int dx = abscisse - elements[0].getCoordonnees().getAbscisse();
        int dy = ordonnee - elements[0].getCoordonnees().getOrdonnee();

        // Déplace chaque élément du tetromino
        for (Element element : elements) {
            element.setCoordonnees(new Coordonnees(
                element.getCoordonnees().getAbscisse() + dx, // Mise à jour de la position X
                element.getCoordonnees().getOrdonnee() + dy  // Mise à jour de la position Y
            ));
        }
    }

    // Redéfinition de la méthode toString() pour afficher la représentation textuelle du tetromino
    // Affiche le nom de la classe du tetromino suivi des coordonnées de chaque élément
    @Override
    public String toString() {
        // StringBuilder utilisé pour concaténer les informations de manière plus efficace
        StringBuilder sb = new StringBuilder(this.getClass().getSimpleName() + " :\n");
        // Ajoute la représentation de chaque élément du tetromino
        for (Element element : elements) {
            sb.append(element.toString()).append("\n");
        }
        return sb.toString().trim(); // Retire le dernier saut de ligne
    }

    @Override
    public void deplacerDe(int deltaX, int deltaY) {
    // On n'autorise QUE les déplacements gauche/droite/bas de 1 case
    if (!((deltaX == 0 && deltaY == 1) || // bas
          (deltaX == -1 && deltaY == 0) || // gauche
          (deltaX == 1 && deltaY == 0))) { // droite
        throw new IllegalArgumentException("Déplacement invalide : seul bas, gauche ou droite sont autorisés.");
    }

    for (Element element : elements) {
        element.deplacerDe(deltaX, deltaY);
    }
    }
}
