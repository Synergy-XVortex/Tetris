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

        // Crée une pièce OTetromino et la positionne
        OTetromino piece = new OTetromino(new Coordonnees(4, 5), Couleur.ROUGE);
        puits.setPieceSuivante(piece); // met en file d’attente
        puits.setPieceSuivante(new OTetromino(new Coordonnees(4, 5), Couleur.BLEU)); // déclenche le passage dans pieceActuelle

        // Crée une VuePuits pour afficher le puits
        VuePuits vuePuits = new VuePuits(puits);

        // 🔧 Ajoute le contrôleur de déplacement de la pièce à la souris
        vuePuits.addMouseMotionListener(new PieceDeplacement(vuePuits));

        // Crée une fenêtre JFrame
        JFrame frame = new JFrame("Test Déplacement Horizontal de la Souris");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(vuePuits);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        // Déclenche la mise à jour de la vue pour s'assurer que l'affichage est correct
        vuePuits.repaint(); // Ajoutez cette ligne pour forcer un rafraîchissement de l'affichage
    }
}

