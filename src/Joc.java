import jdk.jshell.spi.ExecutionControl;

public class Joc {

    private char[][] taulell;
    private int torn;

    public Joc() {
        novaPartida();
    }

    public char[][] getTaulell() {
        return taulell;
    }

    public int getTorn() {
        return torn;
    }

    public void novaPartida() {
        taulell = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                taulell[i][j] = '-';
            }
        }
        torn = 0;
    }

    public void jugar(int fila, int columna) {
        if (taulell[fila][columna] == '-') {
            taulell[fila][columna] = (torn % 2 == 0) ? 'X' : 'O';
            torn++;
        }
    }

    public boolean jugadaGuanyadora(int fila, int columna) {

        throw new UnsupportedOperationException();
    }
}

