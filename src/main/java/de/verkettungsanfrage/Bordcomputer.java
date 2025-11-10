package de.verkettungsanfrage;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Bordcomputer extends Application {
    private Auto auto;
    private Label lblModell, lblMotor, lblGeschwindigkeit, lblTankstand, lblMaxGeschwindigkeit;

    @Override
    public void start(Stage primaryStage) {
        // Auto-Objekt erstellen
        auto = new Auto("VW Golf", 20.0, 200);

        // UI-Elemente initialisieren
        lblModell = new Label("Modell: " + auto.getModell());
        lblMotor = new Label("Motor: Aus");
        lblGeschwindigkeit = new Label("Geschwindigkeit: 0 km/h");
        lblTankstand = new Label("Tankstand: 20.0 Liter");
        lblMaxGeschwindigkeit = new Label("Max. Geschwindigkeit: 200 km/h");

        // Buttons erstellen
        Button btnMotorStart = new Button("Motor starten");
        btnMotorStart.setOnAction(e -> {
            auto.starteMotor();
            updateUI();
        });

        Button btnFahren = new Button("Fahren");
        btnFahren.setOnAction(e -> {
            auto.fahreLos();
            updateUI();
        });

        Button btnBeschleunigen = new Button("Beschleunigen (+30 km/h)");
        btnBeschleunigen.setOnAction(e -> {
            auto.beschleunige(30);
            updateUI();
        });

        Button btnBremsen = new Button("Bremsen (-20 km/h)");
        btnBremsen.setOnAction(e -> {
            auto.bremsen(20);
            updateUI();
        });

        Button btnHupen = new Button("Hupen");
        btnHupen.setOnAction(e -> {
            auto.hupe();
        });

        Button btnTanken = new Button("Tanken (+10 Liter)");
        btnTanken.setOnAction(e -> {
            auto.tanken(10.0);
            updateUI();
        });

        // Layout erstellen
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        grid.add(lblModell, 0, 0);
        grid.add(lblMotor, 0, 1);
        grid.add(lblGeschwindigkeit, 0, 2);
        grid.add(lblTankstand, 0, 3);
        grid.add(lblMaxGeschwindigkeit, 0, 4);

        VBox buttons = new VBox(10, btnMotorStart, btnFahren, btnBeschleunigen, btnBremsen, btnHupen, btnTanken);
        grid.add(buttons, 1, 0, 1, 5);

        // Szene erstellen und anzeigen
        Scene scene = new Scene(grid, 400, 300);
        primaryStage.setTitle("Bordcomputer - " + auto.getModell());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // UI aktualisieren
    private void updateUI() {
        lblModell.setText("Modell: " + auto.getModell());
        lblMotor.setText("Motor: " + (auto.isMotorLaeuft() ? "An" : "Aus"));
        lblGeschwindigkeit.setText("Geschwindigkeit: " + auto.getGeschwindigkeit() + " km/h");
        lblTankstand.setText("Tankstand: " + auto.getTankstand() + " Liter");
    }

    // Getter für Auto-Attribute (müssen in der Auto-Klasse hinzugefügt werden)
    public static void main(String[] args) {
        launch(args);
    }
}
