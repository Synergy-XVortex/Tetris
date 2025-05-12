package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.ITetromino;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.OTetromino;

import javax.swing.*;

public class VuePuitsAffichageTest {

    public static void main(String[] args) {
        // 1. Création du modèle (Puits)
        Puits puits = new Puits();

        // 2. Création de la vue (VuePuit)
        VuePuits vuePuit = new VuePuits(puits, 30);

        // 3. Création de la fenêtre Swing
        JFrame fenetre = new JFrame("VuePuitsAffichageTest");
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setContentPane(vuePuit);
        fenetre.pack();
        fenetre.setLocationRelativeTo(null);
        fenetre.setVisible(true);

        // 4. ⚠️ Aucun appel à setVuePiece() ici !

        // 5. Ajout des pièces : déclenchera automatiquement l'affichage via PropertyChange
        puits.setPieceSuivante(new OTetromino(new Coordonnees(4, 0), Couleur.JAUNE));
        puits.setPieceSuivante(new ITetromino(new Coordonnees(5, 0), Couleur.CYAN));
    }
}
