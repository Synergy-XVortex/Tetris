package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.PieceT;

import javax.swing.*;

public class TestVuePuit {

    public static void main(String[] args) {
        // Crée un puits avec largeur = 10, profondeur = 20
        Puits puits = new Puits(10, 20);

        // Crée une pièce de type T
        Piece piece = new PieceT(puits);

        // Crée la VuePiece associée
        VuePiece vuePiece = new VuePiece(piece);

        // Crée la VuePuit et associe la VuePiece
        VuePuit vuePuit = new VuePuit(puits);
        vuePuit.setVuePiece(vuePiece);

        // Crée une fenêtre pour afficher le tout
        JFrame frame = new JFrame("Test VuePuit");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(vuePuit);
        frame.pack();
        frame.setLocationRelativeTo(null); // Centre la fenêtre
        frame.setVisible(true);
    }
}
