package service;

import model.Reservation;
import data.JSONManager;

import java.util.ArrayList;
import java.util.List;

public class ReservationManager {
    private int peopleCount;  // Nombre de personnes
    private String time;      // Heure de réservation
    private final List<Reservation> reservations; // Liste des réservations
    private final JSONManager jsonManager; // Gestionnaire JSON
    private final String reservationFile = "reservations.json"; // Fichier JSON pour les réservations

    public ReservationManager() {
        this.reservations = new ArrayList<>();
        this.jsonManager = new JSONManager();

        // Charger les réservations depuis le fichier JSON (si elles existent)
        List<Reservation> loadedReservations = jsonManager.loadFromFile(reservationFile, List.class);
        if (loadedReservations != null) {
            reservations.addAll(loadedReservations);
        }
    }

    // Setter pour le nombre de personnes
    public void setPeopleCount(int peopleCount) {
        this.peopleCount = peopleCount;
    }

    // Getter pour le nombre de personnes
    public int getPeopleCount() {
        return this.peopleCount;
    }

    // Setter pour l'heure de réservation
    public void setTime(String time) {
        this.time = time;
    }

    // Getter pour l'heure de réservation
    public String getTime() {
        return this.time;
    }

    // Ajouter une réservation et sauvegarder dans le fichier JSON
    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
        saveReservations(); // Sauvegarder dans le fichier JSON
    }

    // Sauvegarder les réservations dans le fichier JSON
    public void saveReservations() {
        jsonManager.saveToFile(reservationFile, reservations);
    }

    // Récupérer la liste des réservations
    public List<Reservation> getReservations() {
        return this.reservations;
    }
}
