import org.junit.jupiter.api.Assertions;
class JocTest {
    @org.junit.jupiter.api.Test
    void novaPartida() {
        Joc joc = new Joc();
        joc.novaPartida();
        Assertions.assertEquals(1,joc.getTorn());
    }

    @org.junit.jupiter.api.Test
    void jugar() {
    }
}