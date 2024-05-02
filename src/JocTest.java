import org.junit.jupiter.api.Assertions;
class JocTest {
    @org.junit.jupiter.api.Test
    void novaPartida() {
        Joc joc = new Joc();
        joc.novaPartida();
        Assertions.assertEquals(1,joc.getTorn());
    }

    @org.junit.jupiter.api.Test
    void jugar() {
        Joc joc = new Joc();
        // Caso de prueba 1: Jugada válida en una celda vacía
        joc.jugar(0, 0);
        char[][] expectedTaulell1 = {
                {'X', '-', '-'},
                {'-', '-', '-'},
                {'-', '-', '-'}
        };

        Assertions.assertEquals(0, joc.getTorn());
    }
}