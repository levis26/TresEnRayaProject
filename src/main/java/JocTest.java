import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class JocTest {

    /*
    Esto nos esta comprobando que tenemos un tablero totalmente limpio (con los - en
    cada sitio) en el metodo novaPartida, tambien estamos instanciando al get del taulell
    */
    @ParameterizedTest

    @CsvSource({"0,0", "0,1", "0,2", "1,0", "1,1","1,2", "2,0", "2,1", "2,2"})
    void novaPartida_OK(int fila, int columna) {
        Joc joc = new Joc();
        joc.novaPartida();
        char[][] taulell = joc.getTaulell();

        // Verificar que todas las casillas están vacías
        Assertions.assertEquals('-', taulell[fila][columna]);
    }

    /*

     */
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
    /* esto hay que pasarlo a otra clase, ya que esta es solor para test */
    private String getTableroRepresentation(char[][] taulell) {


        String representation = "";
        for (int i = 0; i < taulell.length; i++) {
            for (int j = 0; j < taulell[i].length; j++) {
                representation += taulell[i][j] + " ";

            }
            representation.append("\n");
        }
        return representation.toString();
    }



    /*
    Esto lo que nos esta haciendo es primero recorrer todas las posiciones del tablero
    y después nos esta colocando una "O" (que es nuestro primer jugador)
     */
    @ParameterizedTest
    @CsvSource({"0,0", "0,1", "0,2","1,0", "1,1","1,2","2,0", "2,1", "2,2"})
    void jugar_OK(int fila, int columna) {
        Joc joc = new Joc();
        joc.novaPartida();
        joc.jugar(fila, columna);

        // Verificar que el jugador ha colocado su ficha en la posición correcta
        char[][] taulell = joc.getTaulell();
        Assertions.assertEquals('O', taulell[fila][columna]);
    }

    /*
    Esto lo que nos esta haciendo es mirar cada una de las posiciones, instanciar el metodo
    novaPartida y el metodo jugar. Después creamos un boolean que sea false, recorremos la
    matriz y si la posición en la que estamos es igual a "0" hacemos que el oFound (que es nuestro
    boolean) sea true, y se rompa el bucle y llame a nuestro boolean para que se rompa el bucle
    y el Assertions lo que nos hace es que si es True, salga un mensaje diciendo que al menos
    tendria que haber una casilla con una 'O'
    */

    @ParameterizedTest

    @CsvSource({"0,0", "0,1", "0,2", "1,0", "1,1","1,2", "2,0", "2,1", "2,2"})
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

    /*
    Esto lo que nos va a hacer es buscar en el taulell de la posición [i][j] si hay un '-',
    en caso de que sea verdadero, se va a escribir una 'X' y se va a cortar el bucle, en caso
    contrario, vamos a volverlo a ejecutar, si no encuentra ningún '-', va a dar el boolean
    false y se va a cortar el primer bucle
    */
    @ParameterizedTest
    @CsvSource({"0,0", "0,1", "0,2", "1,0", "1,1","1,2", "2,0", "2,1", "2,2"})
    void jugar_jugador2(int fila, int columna){
        Joc joc = new Joc();
        joc.novaPartida();
        joc.jugar(fila, columna);

        char[][] taulell = joc.getTaulell();
        boolean posicionlibre = false;
        for (int i = 0; i < taulell.length; i++) {
            for (int j = 0; j < taulell[i].length; j++) {
                if (taulell[i][j] == '-'){
                    System.out.println('X');
                    posicionlibre = true;
                    break;
                }

            }
            if (posicionlibre) {
                break;
            }
        }

        Assertions.assertTrue(posicionlibre, "Se ha colocado 'X'");
    }
}
