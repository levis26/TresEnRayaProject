public class Joc {

    private char taulell;
    private short torn;

    public char getTaulell() {
        return taulell;
    }

    public short getTorn() {
        return torn;
    }
    public static char[][] novaPartida() {
        //empezamos a rellenar el tablero

        /* int mida = 3;
        char[][] tresenlinea = new char[mida][mida];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tresenlinea[i][j] = '_';
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(tresenlinea[i][j] + " ");
            }
            System.out.println(" ");
        }

        return tresenlinea;
    }
     */

        return novaPartida();
    }

    public static char jugar(short fila, short columna) {
        return 0;
    }

    public static boolean jugadaGuanyadora(short fila, short columna) {
        return false;
    }
}
