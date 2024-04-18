import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main juego = new Main();
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
                    juego = new Main();
                    break;
                case 2:
                    //
                case 3:
                    //
                case 4:
                    System.out.println("Adéu!!");
                    break;
                default:
                    System.out.println("Opció invàlica");
            }
        }

        while (opcion != 4);
    }
}