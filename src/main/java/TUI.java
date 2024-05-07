import java.util.Scanner;

public class TUI {
    Scanner sc = new Scanner(System.in);
    public int mostrarMenu() {

        Joc joc = new Joc();
        int opcion;

        do {
            System.out.println("\nMenú:");
            System.out.println("1. Nova partida");
            System.out.println("2. Carregar partida");
            System.out.println("3. Configuració");
            System.out.println("4. Sortir");
            System.out.print("Selecciona una opció: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    joc.novaPartida();
                    break;
                case 2:
                    System.out.println("Benvingut a la teva partida anterior.");
                    break;
                case 3:
                    System.out.println("Aqui pots fer la configuració del joc.");
                    break;
                case 4:
                    System.out.println("Adéu!!");
                    break;
                default:
                    System.out.println("Opció invàlica");
            }
        }
        while (opcion != 4);
        return 0;
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