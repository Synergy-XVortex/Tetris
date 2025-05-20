package fr.eseo.e3.poo.projet.blox.controleur;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.OTetromino;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

import javax.swing.*;

public class PieceDeplacementTest {

    public static void main(String[] args) {
        // Crée un puits
        Puits puits = new Puits(10, 20);

        // Ajoute une pièce
        puits.setPieceSuivante(new OTetromino(new Coordonnees(4, 5), Couleur.ROUGE));
        puits.setPieceSuivante(new OTetromino(new Coordonnees(4, 5), Couleur.BLEU));

        // Crée la vue du puits
        VuePuits vuePuits = new VuePuits(puits);

        // Crée un seul contrôleur
        PieceDeplacement controleur = new PieceDeplacement(vuePuits);

        // Enregistre le contrôleur pour tous les événements souris
        vuePuits.addMouseMotionListener(controleur);
        vuePuits.addMouseListener(controleur);
        vuePuits.addMouseWheelListener(controleur);

        // Crée une fenêtre
        JFrame frame = new JFrame("Test Déplacement Souris + Molette");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(vuePuits);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Rafraîchissement initial
        vuePuits.repaint();
    }
}
