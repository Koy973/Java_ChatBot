package model;

public class Reservation {
    private int peopleCount;  // Nombre de personnes
    private String time;      // Heure de réservation

    public Reservation(int peopleCount, String time) {
        this.peopleCount = peopleCount;
        this.time = time;
    }

    public int getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(int peopleCount) {
        this.peopleCount = peopleCount;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
