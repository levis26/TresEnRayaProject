import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class JocTest {

    @ParameterizedTest
    @CsvSource({"0, 0, -, -, -, -, -, -, -, -, -, -, -, -, -, -",
            "1, 1, -, -, -, -, -, -, -, X, -, -, -, -, -, -",
            "2, 2, -, -, -, -, -, -, -, X, -, -, -, O, -, -"})
    void novaPartida(int fila, int columna, char esperado00, char esperado11, char esperado22,
                     char esperado01, char esperado10, char esperado20,
                     char esperado02, char esperado12, char esperado21,
                     char esperado03, char esperado13, char esperado23,
                     char esperado04, char esperado14, char esperado24) {
        Joc joc = new Joc();
        char[][] taulell = joc.getTaulell();

        // Realizar la prueba sobre el tablero
        Assertions.assertEquals(esperado00, taulell[0][0]);
        Assertions.assertEquals(esperado11, taulell[1][1]);
        Assertions.assertEquals(esperado22, taulell[2][2]);
        Assertions.assertEquals(esperado01, taulell[0][1]);
        Assertions.assertEquals(esperado10, taulell[1][0]);
        Assertions.assertEquals(esperado20, taulell[2][0]);
        Assertions.assertEquals(esperado02, taulell[0][2]);
        Assertions.assertEquals(esperado12, taulell[1][2]);
        Assertions.assertEquals(esperado21, taulell[2][1]);
        Assertions.assertEquals(esperado03, taulell[0][3]);
        Assertions.assertEquals(esperado13, taulell[1][3]);
        Assertions.assertEquals(esperado23, taulell[2][3]);
        Assertions.assertEquals(esperado04, taulell[0][4]);
        Assertions.assertEquals(esperado14, taulell[1][4]);
        Assertions.assertEquals(esperado24, taulell[2][4]);
    }

    @ParameterizedTest
    @CsvSource({"0,0", "1,1", "2,2"})
    void jugar_OK(int fila, int columna) {
        Joc joc = new Joc();
        joc.jugar(fila, columna);
        char[][] taulell = joc.getTaulell();
        Assertions.assertNotEquals('-', taulell[fila][columna]);
    }
}
