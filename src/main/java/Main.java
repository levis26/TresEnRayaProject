public class Main {

    public static void main(String[] args) {
        Joc joc = new Joc();
        TUI tui = new TUI();

        tui.mostrarMenu();

        tui.medidaTablero();
        joc.novaPartida();
    }
}