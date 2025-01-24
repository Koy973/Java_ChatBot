package service;

import java.util.HashMap;
import java.util.Map;

public class Menu {
    private final Map<String, Double> items;

    public Menu() {
        items = new HashMap<>();
        items.put("Pizza Margherita", 12.50);
        items.put("Pasta Carbonara", 15.00);
        items.put("Cocktail maison", 8.50);
    }

    public String displayMenu() {
        StringBuilder menuString = new StringBuilder("Voici notre menu :\n");
        for (Map.Entry<String, Double> entry : items.entrySet()) {
            menuString.append(entry.getKey()).append(" - ").append(entry.getValue()).append("€\n");
        }
        return menuString.toString();
    }
}
