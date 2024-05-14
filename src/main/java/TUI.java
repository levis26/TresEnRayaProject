import java.util.Scanner;

public class TUI {
    Scanner sc = new Scanner(System.in);
    public int mostrarMenu() {

        Joc joc = new Joc();

        int opcion;

            System.out.println("Menú:");
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
        while (opcion != 4);
        return 0;
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

    public void mostrarTaulell(char[][] taulell, int torn) {
    }

    public int[] recollirJugada() {
        int[] jugada = new int[2];
        return jugada;
    }

    public void fiDePartida(int guanyador) {
    }
}