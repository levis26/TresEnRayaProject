import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class JocTest {

    @ParameterizedTest
    @CsvSource({"0,0", "1,1", "2,2"})
    void novaPartida(int fila, int columna) {
        Joc joc = new Joc();
        char[][] taulell = joc.getTaulell();

        // Realizar la prueba sobre el tablero
        Assertions.assertEquals('-', taulell[fila][columna]);

    }

    @ParameterizedTest
    @CsvSource({"0,0", "1,1", "2,2"})
    void jugar_OK(int fila, int columna) {
        Joc joc = new Joc();
        joc.jugar(fila, columna);
        char[][] taulell = joc.getTaulell();
        Assertions.assertEquals('O', taulell[fila][columna]);
    }
}