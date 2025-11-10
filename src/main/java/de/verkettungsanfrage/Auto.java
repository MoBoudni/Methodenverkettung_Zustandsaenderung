package de.verkettungsanfrage;

public class Auto {
    private String modell;
    private boolean motorLaeuft;
    private int geschwindigkeit;
    private double tankstand;
    private int maxGeschwindigkeit;

    public Auto(String modell, double tankstand, int maxGeschwindigkeit) {
        this.modell = modell;
        this.motorLaeuft = false;
        this.geschwindigkeit = 0;
        this.tankstand = tankstand;
        this.maxGeschwindigkeit = maxGeschwindigkeit;
    }

    public Auto starteMotor() {
        if (tankstand > 0) {
            this.motorLaeuft = true;
            System.out.println("Motor wurde gestartet.");
        } else {
            System.out.println("Tank ist leer! Bitte tanken.");
        }
        return this;
    }

    public Auto fahreLos() {
        if (motorLaeuft && tankstand > 0) {
            this.geschwindigkeit = 10;
            System.out.println("Das Auto fährt los.");
        } else {
            System.out.println("Motor ist nicht gestartet oder Tank ist leer!");
        }
        return this;
    }

    public Auto beschleunige(int geschwindigkeit) {
        if (motorLaeuft && tankstand > 0) {
            this.geschwindigkeit += geschwindigkeit;
            if (this.geschwindigkeit > maxGeschwindigkeit) {
                this.geschwindigkeit = maxGeschwindigkeit;
                System.out.println("Maximale Geschwindigkeit erreicht: " + maxGeschwindigkeit + " km/h.");
            } else {
                System.out.println("Das Auto beschleunigt auf " + this.geschwindigkeit + " km/h.");
            }
        } else {
            System.out.println("Motor ist nicht gestartet oder Tank ist leer!");
        }
        return this;
    }

    public String getModell() {
        return modell;
    }

    public boolean isMotorLaeuft() {
        return motorLaeuft;
    }

    public int getGeschwindigkeit() {
        return geschwindigkeit;
    }

    public double getTankstand() {
        return tankstand;
    }

    public int getMaxGeschwindigkeit() {
        return maxGeschwindigkeit;
    }

    public Auto bremsen(int verringerung) {
        this.geschwindigkeit -= verringerung;
        if (this.geschwindigkeit < 0) {
            this.geschwindigkeit = 0;
        }
        System.out.println("Das Auto bremst auf " + this.geschwindigkeit + " km/h.");
        return this;
    }

    public Auto tanken(double menge) {
        this.tankstand += menge;
        System.out.println("Getankt: " + menge + " Liter. Aktueller Tankstand: " + this.tankstand + " Liter.");
        return this;
    }

    public Auto hupe() {
        System.out.println("Tuut! Tuut!");
        return this;
    }

    public boolean istTankLeer() {
        return this.tankstand < 1;
    }

    public void zeigeZustand() {
        System.out.println("Modell: " + modell);
        System.out.println("Motor läuft: " + motorLaeuft);
        System.out.println("Geschwindigkeit: " + geschwindigkeit + " km/h");
        System.out.println("Tankstand: " + tankstand + " Liter");
        System.out.println("Maximale Geschwindigkeit: " + maxGeschwindigkeit + " km/h");
    }

}
