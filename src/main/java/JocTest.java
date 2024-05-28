import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class JocTest {

    /*
    Esto nos esta comprobando que tenemos un tablero totalmente limpio (con los - en
    cada sitio) en el metodo novaPartida, tambien estamos instanciando al get del taulell
    */
    @ParameterizedTest

    @CsvSource({"0,0", "0,1", "0,2", "1,0", "1,1","1,2", "2,0", "2,1", "2,2"})
    void novaPartida_OK(int fila, int columna) {
        Joc joc = new Joc();
        joc.novaPartida(3);
        char[][] taulell = joc.getTaulell();

        // Verificar que todas las casillas están vacías
        assertEquals('-', taulell[fila][columna]);
    }

    /*

     */
    @ParameterizedTest
    @CsvSource({"0,0", "0,1", "0,2", "1,0", "1,1", "1,2", "2,0", "2,1", "2,2"})
    void novaPartida_representacion(int fila, int columna) {
        Joc joc = new Joc();
        joc.novaPartida(3);

        // Verificar que la representación del tablero sea correcta
        String expectedRepresentation = "---\n---\n---";
        String actualRepresentation = Arrays.deepToString(joc.getTaulell()).replace("], ", "\n").
                                      replace("[[", "").replace("[", "").
                                      replace("]", "").replace(",", "").replace(" ", "");

        assertEquals(expectedRepresentation, actualRepresentation);
    }

    /*
    Esto lo que nos esta haciendo es primero recorrer todas las posiciones del tablero
    y después nos esta colocando una "O" (que es nuestro primer jugador)
     */
    @ParameterizedTest
    @CsvSource({"0,0", "0,1", "0,2","1,0", "1,1","1,2","2,0", "2,1", "2,2"})
    void jugar_OK(int fila, int columna) {
        Joc joc = new Joc();
        joc.novaPartida(3);
        joc.jugar(fila, columna);

        // Verificar que el jugador ha colocado su ficha en la posición correcta
        char[][] taulell = joc.getTaulell();
        assertEquals('X', taulell[fila][columna]);
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
    @CsvSource({"0,0", "0,1", "0,2", "1,0", "1,1", "1,2", "2,0", "2,1", "2,2"})
    void jugar_representacion_jugador1(int fila, int columna) {
        Joc joc = new Joc();
        joc.novaPartida(3);
        joc.jugar(fila, columna);

        // Verificar que la casilla seleccionada se ha rellenado con 'O'
        char[][] taulell = joc.getTaulell();
        boolean oFounded = taulell[fila][columna] == 'X';

        Assertions.assertTrue(oFounded, "Se esperaba que la casilla seleccionada estuviera rellenada con 'O'");
    }


    /*
    Esto lo que nos va a hacer es buscar en el taulell de la posición [i][j] si hay un '-',
    en caso de que sea verdadero, se va a escribir una 'X' y se va a cortar el bucle, en caso
    contrario, vamos a volverlo a ejecutar, si no encuentra ningún '-', va a dar el boolean
    false y se va a cortar el primer bucle
    */
    @ParameterizedTest
    @CsvSource({"0,0", "0,1", "0,2", "1,0", "1,1","1,2", "2,0", "2,1", "2,2"})
    void jugar_jugador2(int fila, int columna) {
        Joc joc = new Joc();
        joc.novaPartida(3);
        joc.jugar(fila, columna);

        char[][] taulell = joc.getTaulell();
        boolean posicionlibre = false;
        for (int i = 0; i < taulell.length; i++) {
            for (int j = 0; j < taulell[i].length; j++) {
                if (taulell[i][j] == '-') {
                    System.out.println('X');
                    if (posicionlibre = true);
                    break;
                }

            }
            if (posicionlibre) {
                break;
            }
        }

        Assertions.assertTrue(posicionlibre, "Se ha colocado 'X'");
    }

    @org.junit.jupiter.api.Test
    void jugador1Gana_en_DiagonalPrincipal() {
        // Crear una instancia del juego
        Joc joc = new Joc();
        // Lanzamos un nuevo tablero
        joc.novaPartida(3);

        // Realizar las jugadas necesarias para que el jugador 1 gane rellenando la diagonal principal
        joc.jugar(0, 0); // Jugador 1
        joc.jugar(0, 1); // Jugador 2
        joc.jugar(1, 1); // Jugador 1
        joc.jugar(1, 2); // Jugador 2
        joc.jugar(2, 2); // Jugador 1

        // Verificar que la jugada ganadora se detecta correctamente
        boolean resultado = joc.jugadaGuanyadora(0, 0);
        Assertions.assertTrue(resultado, "La jugada ganadora en la diagonal principal no se detectó correctamente.");
    }

    @ParameterizedTest
    @CsvSource({"0,0", "1,1", "2,2"})
    void jugadaGuanyadora_Jugador1Gana_diagonal(int fila, int columna) {
        Joc joc = new Joc();
        joc.novaPartida(3);

        // Realizar las jugadas necesarias para que el jugador 1 gane
        joc.jugar(0, 0); // Jugador 1
        joc.jugar(0, 1); // Jugador 2
        joc.jugar(1, 1); // Jugador 1
        joc.jugar(1, 2); // Jugador 2
        joc.jugar(2, 2); // Jugador 1

        // Verificar si la jugada actual hace que el jugador 1 gane
        Assertions.assertTrue(joc.jugadaGuanyadora(fila, columna), "El jugador 1 no ganó la partida en la diagonal principal.");
    }

    @org.junit.jupiter.api.Test
    void jugador1Gana_en_Fila0() {
        // Crear una instancia del juego
        Joc joc = new Joc();
        // Lanzar un nuevo tablero
        joc.novaPartida(3);

        // Realizar las jugadas necesarias para que el jugador 1 gane rellenando una fila
        joc.jugar(0, 0); // Jugador 1
        joc.jugar(1, 0); // Jugador 2
        joc.jugar(0, 1); // Jugador 1
        joc.jugar(1, 1); // Jugador 2
        joc.jugar(0, 2); // Jugador 1

        // Verificar que la jugada ganadora se detecta correctamente
        Assertions.assertTrue(joc.jugadaGuanyadora(0, 0));
    }

    @ParameterizedTest
    @CsvSource({"0,0", "0,1", "0,2"}) // Fila 0
    void jugadaGuanyadora_Jugador1Gana_Fila0(int fila, int columna) {
        Joc joc = new Joc();
        joc.novaPartida(3);
        char[][] taulell = joc.getTaulell();

        // Realizar las jugadas necesarias para que el jugador 1 gane rellenando una fila
        joc.jugar(0, 0); // Actualiza el tablero con la jugada del jugador 1
        joc.jugar(1, 0); // Actualiza el tablero con la jugada del jugador 2
        joc.jugar(0, 1); // Actualiza el tablero con la jugada del jugador 1
        joc.jugar(1, 1); // Actualiza el tablero con la jugada del jugador 2
        joc.jugar(0, 2); // Actualiza el tablero con la jugada del jugador 1

        // Verificar si la jugada actual hace que el jugador 1 gane
        Assertions.assertTrue(joc.jugadaGuanyadora(0, columna));
    }

    @org.junit.jupiter.api.Test
    void jugador1Gana_en_Columna1() {
        Joc joc = new Joc();
        joc.novaPartida(3);

        // Llenar la columna 1 con 'O'
        joc.jugar( 0, 1); //Jugador 1
        joc.jugar( 0, 0); //Jugador 2
        joc.jugar( 1, 1); //Jugador 1
        joc.jugar( 2, 2); //Jugador 2
        joc.jugar( 2, 1); //Jugador 1

        Assertions.assertTrue(joc.jugadaGuanyadora( 0, 1), "La jugada ganadora en la columna 1 no se detectó correctamente.");
    }

    @ParameterizedTest
    @CsvSource({"0", "1", "2"}) // Filas
    void jugadaGuanyadora_Jugador1Gana_Columna1(short fila) {
        Joc joc = new Joc();
        joc.novaPartida(3);

        // Llenar la columna 1 con 'O'
        joc.jugar( 0, 1); //Jugador 1
        joc.jugar( 0, 0); //Jugador 2
        joc.jugar( 1, 1); //Jugador 1
        joc.jugar( 2, 2); //Jugador 2
        joc.jugar( 2, 1); //Jugador 1

        Assertions.assertTrue(joc.jugadaGuanyadora(fila, 1), "La jugada ganadora en la columna 1 no se detectó correctamente.");
    }

    @org.junit.jupiter.api.Test
    void jugador1Gana_en_DiagonalSecundaria() {
        Joc joc = new Joc();
        joc.novaPartida(3);

        // Llenar la vertical secundaria con 'O' (jugador 1)
        joc.jugar(0, 2); //Jugador 1
        joc.jugar(0, 0); //Jugador 2
        joc.jugar(1, 1); //Jugador 1
        joc.jugar(2, 2); //Jugador 2
        joc.jugar(2, 0); //Jugador 1

        Assertions.assertTrue(joc.jugadaGuanyadora(1, 1), "La jugada ganadora en la vertical secundaria no se detectó correctamente.");
    }

    @ParameterizedTest
    @CsvSource({"0,2", "1,1", "2,0"})
    void jugadaGuanyadora_Jugador1Gana_DiagonalSecundaria(int fila, int columna) {
        Joc joc = new Joc();
        joc.novaPartida(3);

        // Llenar la vertical secundaria con 'O' (jugador 1)
        joc.jugar(0, 2); //Jugador 1
        joc.jugar(0, 0); //Jugador 2
        joc.jugar(1, 1); //Jugador 1
        joc.jugar(2, 2); //Jugador 2
        joc.jugar(2, 0); //Jugador 1

        Assertions.assertTrue(joc.jugadaGuanyadora(fila, columna));
    }


    @ParameterizedTest
    @CsvSource({"0,0", "0,1", "0,2", "1,0", "1,1", "1,2", "2,0", "2,1", "2,2"})
    void jugadaGuanyadora_unaOcupada(int fila, int columna){
        Joc joc = new Joc();
        joc.novaPartida(3);
        joc.jugar(fila, columna);

        char[][] taulell = joc.getTaulell();
        boolean posicionLibre = false;

        for (int i = 0; i < taulell.length; i++) {
            for (int j = 0; j < taulell[i].length; j++) {
                if (taulell[i][j] == 'X') {
                    if (posicionLibre == false);
                    break;
                }
                if (!posicionLibre);
                System.out.println(taulell[i][j]);
                break;
            }
        }
        Assertions.assertFalse(posicionLibre, "Hola");
    }

    @ParameterizedTest
    @CsvSource({"0,0", "0,1", "0,2", "1,0", "1,1", "1,2", "2,0", "2,1", "2,2"})
    void colocarFitxaPosicioLliure (int fila, int columna){

    }
    @org.junit.jupiter.api.Test
    void testGuardarConfiguracio() {
        Joc joc = new Joc();
        joc.guardarConfiguracio(5);
        assertEquals(5, joc.getMidaTaulell());
    }

    @org.junit.jupiter.api.Test
    void testCarregarConfiguracio() {
        Joc joc = new Joc();
        joc.carregarConfiguracio();
        assertEquals(3, joc.getMidaTaulell());
    }

    @org.junit.jupiter.api.Test
    void testGuardarCarregarPartida() {
        Joc joc = new Joc();
        joc.novaPartida(3);
        joc.jugar(0, 0);
        joc.jugar(1, 1);
        joc.guardarPartida();
        joc.carregarPartida("partida_guardada.txt");
        assertEquals('X', joc.getTaulell()[0][0]);
        assertEquals('O', joc.getTaulell()[1][1]);
    }


    @org.junit.jupiter.api.Test
    void testLlistarPartidesGuardades() {
        Joc joc = new Joc();
        // Asegúrate de que llistarPartidesGuardades devuelva algo distinto de null
        Assertions.assertNotNull(joc.llistarPartidesGuardades(), "La lista de partidas guardadas no debería ser nula");
    }

}