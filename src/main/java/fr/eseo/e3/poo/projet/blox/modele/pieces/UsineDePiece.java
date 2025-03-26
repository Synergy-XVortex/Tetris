package fr.eseo.e3.poo.projet.blox.modele.pieces;

import java.util.Random;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.ITetromino;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.OTetromino;

public class UsineDePiece {

    public enum TypePiece {
        O, I, T, L, J, S, Z
    }

    private static final Random RANDOM = new Random();

    public static Piece genererPiece() {
        TypePiece[] types = TypePiece.values();
        int index = RANDOM.nextInt(types.length);
    
        System.out.println("Index généré : " + index + ", Type choisi : " + types[index]); // Log pour debug
    
        return genererPiece(types[index]);
    }
    

    public static Piece genererPiece(TypePiece type) {
        Coordonnees position = new Coordonnees(5, 0);
        Couleur couleur = Couleur.values()[RANDOM.nextInt(Couleur.values().length)];

        switch (type) {
            case O:
                return new OTetromino(position, couleur);
            case I:
                return new ITetromino(position, couleur);
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
                throw new IllegalArgumentException("Type de pièce inconnu");
        }
    }
}
