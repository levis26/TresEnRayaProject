public class Main {

    public static void main(String[] args) {
        Joc joc = new Joc();
        TUI tui = new TUI();

        int opcion = tui.mostrarMenu();

        switch (opcion) {
            case 1:
                joc.novaPartida();
                break;
            case 2:
                System.out.println("Benvingut a la teva partida anterior.");
                break;
            case 3:
                tui.medidaTablero();
                break;
            case 4:
                System.out.println("Adéu!!");
                break;
            default:
                System.out.println("Opció invàlida");
        }
        while (opcion != 4);


        tui.medidaTablero();



        joc.novaPartida();
    }
}