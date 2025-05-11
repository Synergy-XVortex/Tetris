package fr.eseo.e3.poo.projet.blox.modele.pieces;

import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;

// Interface représentant une pièce dans le jeu
public interface Piece {

    // Retourne un tableau contenant les éléments (blocs) qui composent la pièce
    Element[] getElements();

    // Fait pivoter la pièce dans le sens horaire (true) ou antihoraire (false)
    void tourner(boolean sensHoraire);

    // Retourne la couleur associée à la pièce
    Couleur getCouleur();

    // Déplace la pièce à une nouvelle position en définissant les coordonnées du premier élément
    void setPosition(int abscisse, int ordonnee);
}
