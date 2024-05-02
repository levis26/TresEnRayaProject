import java.util.Scanner;

public class TUI {
    private Scanner sc;

    public int mostrarMenu() {
        System.out.println("1. Nova partida");
        System.out.println("2. Carregar partida");
        System.out.println("3. Configuració");
        System.out.println("4. Sortir");
        return sc.nextInt();
    }

    public void mostrarTaulell(char[][] taulell, int torn) {
        System.out.println();
    }

    public int recollirJugada() {

        return 0;
    }

    public void fiDePartida(int guanyador) {

    }
}