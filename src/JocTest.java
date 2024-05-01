import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
class JocTest {

    private Joc joc;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        joc = new Joc();
    }

    @org.junit.jupiter.api.Test
    void jugar() {
        // Caso de prueba 1: Jugada válida en una celda vacía
        joc.jugar(0, "0");
        char[][] expectedTaulell1 = {
                {'X', '-', '-'},
                {'-', '-', '-'},
                {'-', '-', '-'}
        };
        assertArrayEquals(expectedTaulell1, joc.getTaulell());
        assertEquals(1, joc.getTorn());

        // Caso de prueba 2: Jugada inválida en una celda ocupada
        joc.jugar(0, "0");
        char[][] expectedTaulell2 = {
                {'X', '-', '-'},
                {'-', '-', '-'},
                {'-', '-', '-'}
        };
        assertArrayEquals(expectedTaulell2, joc.getTaulell());
        assertEquals(1, joc.getTorn());

        // Caso de prueba 3: Jugada válida en otra celda vacía
        joc.jugar(1, "1");
        char[][] expectedTaulell3 = {
                {'X', '-', '-'},
                {'-', 'O', '-'},
                {'-', '-', '-'}
        };
        assertArrayEquals(expectedTaulell3, joc.getTaulell());
        assertEquals(2, joc.getTorn());
    }
}
