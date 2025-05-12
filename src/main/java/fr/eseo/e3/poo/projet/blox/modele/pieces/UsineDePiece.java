package fr.eseo.e3.poo.projet.blox.modele.pieces;

import java.util.Random;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.ITetromino;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.OTetromino;

// Classe utilitaire pour générer des pièces de type Tetromino
public class UsineDePiece {

    // Enumération représentant les différents types de pièces possibles
    public enum TypePiece {
        O, I, T, L, J, S, Z
    }

    // Générateur de nombres aléatoires utilisé pour choisir un type et une couleur
    private static final Random RANDOM = new Random();

    // Méthode statique pour générer aléatoirement une pièce
    public static Piece genererPiece() {
        TypePiece[] types = TypePiece.values(); // Récupère tous les types possibles
        int index = RANDOM.nextInt(types.length); // Tire un index aléatoire

        // Affiche l'index et le type sélectionné pour le débogage
        System.out.println("Index généré : " + index + ", Type choisi : " + types[index]);

        return genererPiece(types[index]); // Génère la pièce correspondante
    }

    // Méthode statique pour générer une pièce d'un type donné
    public static Piece genererPiece(TypePiece type) {
        // Position initiale de la pièce (au centre en haut du puits)
        Coordonnees position = new Coordonnees(5, 0);
        // Choix aléatoire d'une couleur parmi l'énumération Couleur
        Couleur couleur = Couleur.values()[RANDOM.nextInt(Couleur.values().length)];

        // Crée et retourne une instance de la pièce en fonction du type
        switch (type) {
            case O:
                return new OTetromino(position, couleur);
            case I:
                return new ITetromino(position, couleur);
            // Les autres types sont commentés pour le moment (non implémentés)
            //case T:
            //    return new TTetromino(position, couleur);
            //case L:
            //    return new LTetromino(position, couleur);
            //case J:
            //    return new JTetromino(position, couleur);
            //case S:
            //    return new STetromino(position, couleur);
            //case Z:
            //    return new ZTetromino(position, couleur);
            default:
                // Erreur si le type n'est pas reconnu (devrait être impossible ici)
                throw new IllegalArgumentException("Type de pièce inconnu");
        }
    }
}
