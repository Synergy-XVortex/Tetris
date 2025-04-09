package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.OTetromino;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.ITetromino;

import javax.swing.*;
import java.awt.*;

public class VuePuitAvecDeuxPiecesTest {

    public static void main(String[] args) {
        // Création du puits
        Puits puits = new Puits();

        // Création de deux pièces différentes
        OTetromino pieceActuelle = new OTetromino(new Coordonnees(4, 2), Couleur.ORANGE);
        ITetromino pieceSuivante = new ITetromino(new Coordonnees(1, 3), Couleur.CYAN); // Coordonnées quelconques

        // Ajout des pièces dans le puits
        puits.setPieceSuivante(pieceActuelle);
        puits.setPieceSuivanteEtSuivante(pieceSuivante);

        // Création de la vue du puits
        VuePuit vuePuit = new VuePuit(puits, 30); // 30 px par case

        // Création de la vue de la pièce suivante (affichée à part)
        VuePiece vueSuivante = new VuePiece(pieceSuivante, 30);
        vueSuivante.setBorder(BorderFactory.createTitledBorder("Prochaine pièce"));

        // Organisation dans un panneau principal
        JPanel panneauPrincipal = new JPanel(new BorderLayout());
        panneauPrincipal.add(vuePuit, BorderLayout.CENTER);
        panneauPrincipal.add(vueSuivante, BorderLayout.EAST);

        // Création de la fenêtre
        JFrame fenetre = new JFrame("Test VuePuit avec deux pièces");
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setContentPane(panneauPrincipal);
        fenetre.pack();
        fenetre.setLocationRelativeTo(null);
        fenetre.setVisible(true);
    }
}
