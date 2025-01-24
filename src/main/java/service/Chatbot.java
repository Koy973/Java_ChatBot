package service;

import model.Reservation;
import service.Menu;
import service.ReservationManager;

public class Chatbot {
    private final ReservationManager reservationManager;
    private final Menu menu;

    public Chatbot() {
        this.reservationManager = new ReservationManager();
        this.menu = new Menu();
    }

    public String processInput(String input) {
        input = input.toLowerCase();

        if (input.contains("réserver une table")) {
            return "Combien de personnes serez-vous ?";
        } else if (input.matches(".*\\d+ personnes.*")) {
            int peopleCount = Integer.parseInt(input.replaceAll("[^0-9]", ""));
            reservationManager.setPeopleCount(peopleCount);
            return "À quelle heure souhaitez-vous réserver ?";
        } else if (input.matches(".*\\d{1,2}h.*")) {
            reservationManager.setTime(input);

            // Créer et sauvegarder la réservation
            Reservation reservation = new Reservation(reservationManager.getPeopleCount(), input);
            reservationManager.addReservation(reservation);

            return "Votre réservation est confirmée ! Souhaitez-vous consulter notre menu ?";
        } else if (input.contains("menu")) {
            return menu.displayMenu();
        }

        return "Je n'ai pas compris votre demande.";
    }

}
