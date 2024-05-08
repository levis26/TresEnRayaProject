import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class JocTest {

    @ParameterizedTest
    @CsvSource({"0,0", "0,1", "0,2", "1,0", "1,1", "1,2", "2,0", "2,1", "2,2"})
    void novaPartida_OK(int fila, int columna) {
        Joc joc = new Joc();
        joc.novaPartida();
        char[][] taulell = joc.getTaulell();

        // Verificar que todas las casillas están vacías
        Assertions.assertEquals('-', taulell[fila][columna]);
    }

    @ParameterizedTest
    @CsvSource({"0,0", "1,1", "2,2", "1,0", "1,1", "1,2", "2,0", "2,1", "2,2"})
    void novaPartida_rep(int fila, int columna) {
        Joc joc = new Joc();
        joc.novaPartida();
        char[][] taulell = joc.getTaulell();

        // Verificar que la representación del tablero sea correcta
        String expectedOutput = "- - - \n- - - \n- - - \n";
        Assertions.assertEquals(expectedOutput, getTableroRepresentation(taulell));
    }

    // Método para obtener la representación del tablero
    private String getTableroRepresentation(char[][] taulell) {
        StringBuilder representation = new StringBuilder();
        for (char[] fila : taulell) {
            for (char celda : fila) {
                representation.append(celda).append(" ");
            }
            representation.append("\n");
        }
        return representation.toString();
    }

    @ParameterizedTest
    @CsvSource({"0,0", "0,1", "0,2", "1,0", "1,1", "1,2", "2,0", "2,1", "2,2"})
    void jugar_OK(int fila, int columna) {
        Joc joc = new Joc();
        joc.novaPartida();
        joc.jugar(fila, columna);

        // Verificar que el jugador ha colocado su ficha en la posición correcta
        char[][] taulell = joc.getTaulell();
        Assertions.assertEquals('O', taulell[fila][columna]);
    }

    @ParameterizedTest
    @CsvSource({"0,0", "0,1", "0,2", "1,0", "1,1", "1,2", "2,0", "2,1", "2,2"})
    void jugar_rep(int fila, int columna) {
        Joc joc = new Joc();
        joc.novaPartida();
        joc.jugar(fila, columna);

        // Verificar que al menos una casilla se ha rellenado con 'O'
        char[][] taulell = joc.getTaulell();
        boolean oFound = false;
        for (char[] filaTablero : taulell) {
            for (char celda : filaTablero) {
                if (celda == 'O') {
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

    @ParameterizedTest
    @CsvSource({"0,0", "0,1", "0,2", "1,0", "1,1", "1,2", "2,0", "2,1", "2,2"})
    void jugadaGuanyadora_noGanadora(int fila, int columna) {
        Joc joc = new Joc();
        joc.novaPartida();

        // Verificar que no hay jugada ganadora en un tablero vacío
        Assertions.assertFalse(joc.jugadaGuanyadora(fila, columna));
    }


    @ParameterizedTest
    @CsvSource({ "0,1", "0,2", "1,0", "1,1", "1,2", "2,0", "2,1", "2,2"})
    void jugadaGuanyadora_noGanadora_unaCasilla(int fila, int columna) {
        Joc joc = new Joc();
        joc.novaPartida();
        joc.jugar(0, 0);

        // Verificar que no hay jugada ganadora en un tablero con una sola casilla ocupada
        Assertions.assertFalse(joc.jugadaGuanyadora(fila, columna));
    }


}
