import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

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
                    System.out.println("Benvingut al meu joc.");
                    break;
                case 2:
                    System.out.println("Benvingut a la teva partida anterior.");
                case 3:
                    System.out.println("Aqui pots fer la configuració del joc.");
                case 4:
                    System.out.println("Adéu!!");
                    break;
                default:
                    System.out.println("Opció invàlica");
            }
        }

        while (opcion != 4);
    }
    public static void TUI(){

    }
}