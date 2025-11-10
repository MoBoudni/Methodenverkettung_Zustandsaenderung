package de.verkettungsanfrage;

public class Main {
    public static void main(String[] args) {
        Auto meinAuto = new Auto("VW Golf", 5.0, 200);

        // Methodenverkettung mit neuen Funktionen
        meinAuto.tanken(20.0)
                .starteMotor()
                .fahreLos()
                .beschleunige(50)
                .bremsen(20)
                .hupe()
                .zeigeZustand();
    }
}
