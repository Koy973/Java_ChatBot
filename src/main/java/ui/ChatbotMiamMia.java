package ui;

import service.Chatbot;
import java.util.Scanner;

public class ChatbotMiamMia {
    public static void main(String[] args) {
        Chatbot chatbot = new Chatbot(); // Appelle la logique métier
        Scanner scanner = new Scanner(System.in);

        System.out.println("Chatbot MiamMia : Bonjour ! Comment puis-je vous aider ?");

        while (true) {
            String input = scanner.nextLine();
            String response = chatbot.processInput(input); // Envoie la commande utilisateur
            System.out.println("Chatbot MiamMia : " + response);

            if (response.equals("Merci d'avoir utilisé notre service. À bientôt !")) {
                break;
            }
        }

        scanner.close();
    }
}
