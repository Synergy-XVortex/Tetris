package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.*;

import javax.swing.*;

public class VuePieceTest {

    public static void main(String[] args) {
        // Crée une fenêtre
        JFrame fenetre = new JFrame("Test VuePiece");
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crée une pièce OTetromino avec une couleur
        OTetromino oTetromino = new OTetromino(new Coordonnees(1, 1), Couleur.ROUGE);

        // Crée la vue associée à la pièce
        VuePiece vuePiece = new VuePiece(oTetromino, 30); // taille des cases : 30 px

        // Ajoute la vue dans la fenêtre
        fenetre.add(vuePiece);
        fenetre.pack();       // ajuste la taille
        fenetre.setLocationRelativeTo(null); // centre la fenêtre
        fenetre.setVisible(true); // affiche la fenêtre
    }
}
