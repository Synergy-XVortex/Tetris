package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.OTetromino;

import javax.swing.*;
import java.awt.*;

/**
 * Classe de test pour l'affichage d'une VuePiece seule dans une fenêtre.
 */
public class VuePieceTest {

    public static void main(String[] args) {
        // Crée une pièce de type OTetromino centrée en (4, 5)
        OTetromino piece = new OTetromino(new Coordonnees(4, 5), Couleur.ORANGE);

        // Crée une VuePiece avec taille de bloc personnalisée
        VuePiece vuePiece = new VuePiece(piece, 30);

        // Crée une fenêtre pour afficher la pièce
        JFrame fenetre = new JFrame("Test VuePiece");
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setSize(400, 400);
        fenetre.setLocationRelativeTo(null);

        // Ajoute un panneau personnalisé qui appelle VuePiece.paintComponent()
        JPanel panneau = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                vuePiece.paintComponent(g);
            }
        };

        fenetre.setContentPane(panneau);
        fenetre.setVisible(true);
    }
}
