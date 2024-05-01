import java.util.Scanner;

public class Main {
    private static TUI tui = new TUI();
    private static Joc joc = new Joc();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean sortir = false;
        while (!sortir) {
            int opcio = tui.mostrarMenu();
            switch (opcio) {
                case 1:
                    novaPartida();
                    break;
                case 2:
                    carregarPartida();
                    break;
                case 3:
                    configuracio();
                    break;
                case 4:
                    sortir = true;
                    break;
                default:
                    System.out.println("Opció invàlida.");
            }
        }
    }

    private static void novaPartida() {
        joc.novaPartida();
        boolean partidaAcabada = false;
        while (!partidaAcabada) {
            tui.mostrarTaulell(joc.getTaulell(), joc.getTorn());
            short[] jugada = tui.recollirJugada();
            joc.jugar(jugada[0], String.valueOf(jugada[1]));
            if (joc.jugadaGuanyadora(jugada[0], jugada[1])) {
                tui.mostrarTaulell(joc.getTaulell(), joc.getTorn());
                short guanyador = (joc.getTorn() % 2 == 0) ? (short) 1 : (short) 0;
                tui.fiDePartida(guanyador);
                partidaAcabada = true;
            } else if (joc.getTorn() == 9) {
                tui.mostrarTaulell(joc.getTaulell(), joc.getTorn());
                tui.fiDePartida((short) -1);
                partidaAcabada = true;
            }
        }
    }

    private static void carregarPartida() {
        // Implementar la lógica para cargar una partida guardada
    }

    private static void configuracio() {
        // Implementar la lógica para mostrar el menú de configuración
    }
}
