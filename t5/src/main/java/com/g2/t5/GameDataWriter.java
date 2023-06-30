package com.g2.t5;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import com.g2.Model.Game;

public class GameDataWriter {

    private static String CSV_FILE_PATH = "t5/src/main/resources/FolderTree/AUTName/StudentLogin/GameId/GameData.csv";
    //private static final String[] CSV_HEADER = { "GameId", "Username", "PlayerClass", "Robot" };

    public void saveGame(Game game) {
        try {
            // Crea il file CSV se non esiste
            File file = new File(CSV_FILE_PATH);
            CSV_FILE_PATH = file.getAbsolutePath();

            // Crea il Writer per il file CSV
            Writer writer = new FileWriter(CSV_FILE_PATH, true);

            // Crea il CSVPrinter con il Writer e il formato CSV
            CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT);

            // Scrivi i dati dell'oggetto Game come tupla CSV nel file
            csvPrinter.printRecord(game.getGameId(), game.getUsername(), game.getPlayerClass(), game.getRobot());

            // Chiudi il CSVPrinter e il Writer
            csvPrinter.flush();
            csvPrinter.close();
            writer.close();

            System.out.println("L'oggetto Game è stato salvato correttamente nel file CSV.");
        } catch (IOException e) {
            System.err.println("Errore durante la scrittura del file CSV: " + e.getMessage());
        }
    }
}