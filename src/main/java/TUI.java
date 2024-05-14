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

        return opcion;
    }

    public int medidaTablero (){

        int medida = 3;
        int opcion;

        System.out.println("Quieres cambiar la medida del tablero?");
        System.out.println("1. Si");
            System.out.println("2. No");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Introduce tu nueva medida, del 3 al 10");
                    medida = sc.nextInt();
                    break;
            }
        return medida;
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