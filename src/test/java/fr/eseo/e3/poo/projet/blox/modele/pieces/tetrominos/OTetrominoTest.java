package fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OTetrominoTest {
    private OTetromino oTetromino;

    @BeforeEach
    void setUp() {
        oTetromino = new OTetromino(0, 0);
    }

    @Test
    void testInitialisation() {
        Element[] elements = oTetromino.getElements();
        assertNotNull(elements, "Les éléments ne doivent pas être null.");
        assertEquals(4, elements.length, "OTetromino doit contenir 4 éléments.");
        
        assertEquals(0, elements[0].getX());
        assertEquals(0, elements[0].getY());
        assertEquals(1, elements[1].getX());
        assertEquals(0, elements[1].getY());
        assertEquals(0, elements[2].getX());
        assertEquals(1, elements[2].getY());
        assertEquals(1, elements[3].getX());
        assertEquals(1, elements[3].getY());
    }
}
