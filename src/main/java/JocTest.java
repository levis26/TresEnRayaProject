// Clase JocTest
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class JocTest {

    @ParameterizedTest
    @CsvSource({"0,0", "0,1", "0,2", "1,0", "1,1","1,2", "2,0", "2,1", "2,2"})
    void novaPartida_OK(int fila, int columna) {
        Joc joc = new Joc();
        joc.novaPartida();
        char[][] taulell = joc.getTaulell();

        // Realizar la prueba sobre el tablero
        Assertions.assertEquals('-', taulell[fila][columna]);
    }

    @ParameterizedTest
    @CsvSource({"0,0", "0,1", "0,2", "1,0", "1,1", "1,2", "2,0", "2,1", "2,2"})
    void novaPartida_rep(int fila, int columna) {
        Joc joc = new Joc();
        joc.novaPartida();
        char[][] taulell = joc.getTaulell();

        // Verificar que la representación del tablero sea correcta
        String tablero = "- - - \n- - - \n- - - \n";
        Assertions.assertEquals(tablero, getTableroRepresentation(taulell));
    }

    // Método para obtener la representación del tablero
    private String getTableroRepresentation(char[][] taulell) {
        String representation = "";
        for (int i = 0; i < taulell.length; i++) {
            for (int j = 0; j < taulell[i].length; j++) {
                representation += taulell[i][j] + " ";
            }
            representation += "\n";
        }
        return representation;
    }

    @ParameterizedTest
    @CsvSource({"0,0", "1,1", "2,2","1,0", "1,1","1,2","2,0", "2,1", "2,2"})
    void jugar_OK(int fila, int columna) {
        Joc joc = new Joc();
        joc.novaPartida();
        joc.jugar(fila, columna);

        // Verificar que el jugador ha colocado su ficha en la posición correcta
        char[][] taulell = joc.getTaulell();
        Assertions.assertEquals('O', taulell[fila][columna]);

    }

    @ParameterizedTest
    @CsvSource({"0,0", "1,1", "2,2", "1,0", "1,1","1,2", "2,0", "2,1", "2,2"})
    void jugar_rep(int fila, int columna) {
        Joc joc = new Joc();
        joc.novaPartida();
        joc.jugar(fila, columna);

        // Verificar que al menos una casilla se ha rellenado con 'O'
        char[][] taulell = joc.getTaulell();
        boolean oFound = false;
        for (int i = 0; i < taulell.length; i++) {
            for (int j = 0; j < taulell[i].length; j++) {
                if (taulell[i][j] == 'O') {
                    oFound = true;
                    break;
                }
            }
            if (oFound) {
                break;
            }
        }
        Assertions.assertTrue(oFound, "Se esperaba que al menos una casilla estuviera rellenada con 'O'");
    }

}
