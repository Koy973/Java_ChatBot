package data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JSONManager {
    private final Gson gson;

    public JSONManager() {
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    // Sauvegarder un objet dans un fichier JSON
    public <T> void saveToFile(String filename, T data) {
        try (FileWriter writer = new FileWriter(filename)) {
            gson.toJson(data, writer);
        } catch (IOException e) {
            System.err.println("Erreur lors de la sauvegarde dans " + filename + " : " + e.getMessage());
        }
    }

    // Charger un objet depuis un fichier JSON
    public <T> T loadFromFile(String filename, Class<T> clazz) {
        File file = new File(filename);
        if (!file.exists()) {
            System.out.println("Fichier " + filename + " introuvable. Création d'un nouveau fichier.");
            saveToFile(filename, "[]"); // Crée un fichier JSON vide
            return null;
        }

        try (FileReader reader = new FileReader(file)) {
            return gson.fromJson(reader, clazz);
        } catch (IOException e) {
            System.err.println("Erreur lors du chargement depuis " + filename + " : " + e.getMessage());
        }
        return null;
    }
}
