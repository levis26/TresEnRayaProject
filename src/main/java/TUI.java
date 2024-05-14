import java.util.Scanner;

public class TUI {
    Scanner sc = new Scanner(System.in);
    public int mostrarMenu() {
        int opcion;
        do {
            System.out.println("\nMenú:");
            System.out.println("1. Nova partida");
            System.out.println("2. Carregar partida");
            System.out.println("3. Configuració");
            System.out.println("4. Sortir");
            System.out.print("Selecciona una opció: ");
            opcion = sc.nextInt();
        }
        while (opcion != 4);
        return opcion;
    }

    public void mostrarTaulell(char[][] taulell, int torn) {
    }

    public int[] recollirJugada() {
        int[] jugada = new int[2];
        return jugada;
    }

    public void fiDePartida(int guanyador) {
    }
}