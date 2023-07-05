package com.g2.t5;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.g2.Model.Game;
import com.g2.Model.Player;

import com.g2.Interfaces.t8;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@Controller
public class GuiController {

    Player p1 = Player.getInstance();
    Game g = new Game();

    String valueclass = "NULL";
    String valuerobot = "NULL";
    private Integer myClass = null;
    private Integer myRobot = null;
    private Map<Integer, String> hashMap = new HashMap<>();
    private Map<Integer, String> hashMap2 = new HashMap<>();
    private final FileController fileController;

    public GuiController(FileController fileController) {
        this.fileController = fileController;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login"; // Nome del template Thymeleaf per la pagina1.html
    }

    @GetMapping("/main")
    public String GUIController(Model model) {

        fileController.listFilesInFolder("classpath:FolderTree/AUTName/AUTSourceCode");
        int size = fileController.getClassSize();

        for (int i = 0; i < size; i++) {
            String valore = fileController.getClass(i);
            hashMap.put(i, valore);
        }

        model.addAttribute("hashMap", hashMap);

        hashMap2 = com.g2.Interfaces.t8.RobotList();

        model.addAttribute("hashMap2", hashMap2);
        return "main";
    }

    @PostMapping("/sendVariable")
    public ResponseEntity<String> receiveVariableClasse(@RequestParam("myVariable") Integer myClassa,
            @RequestParam("myVariable2") Integer myRobota) {
        // Fai qualcosa con la variabile ricevuta
        System.out.println("Variabile ricevuta: " + myClassa);
        System.out.println("Variabile ricevuta: " + myRobota);
        myClass = myClassa;
        myRobot = myRobota;
        // Restituisci una risposta al client (se necessario)
        return ResponseEntity.ok("Dati ricevuti con successo");
    }

    @GetMapping("/report")
    public String reportPage(Model model) {

        valueclass = hashMap.get(myClass);
        valuerobot = hashMap2.get(myRobot);

        System.out.println("IL VALORE DEL ROBOT " + valuerobot + " " + myRobot);
        System.out.println("Il VALORE DELLA CLASSE " + valueclass + " " + myClass);
        model.addAttribute("classe", valueclass);
        model.addAttribute("robot", valuerobot);
        return "report";
    }

    @GetMapping("/editor")
    public String editorPage() {
        return "editor";
    }

    @PostMapping("/login-variabiles")
    public ResponseEntity<String> receiveLoginData(@RequestParam("var1") String username,
            @RequestParam("var2") String password) {

        System.out.println("username : " + username);
        System.out.println("password : " + password);

        p1.setUsername(username);
        p1.setPassword(password);

        // Salva i valori in una variabile o esegui altre operazioni necessarie

        return ResponseEntity.ok("Dati ricevuti con successo");

    }

    @PostMapping("/save-data")
    public ResponseEntity<String> saveGame() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime oraCorrente = LocalTime.now();
        String oraFormattata = oraCorrente.format(formatter);

        GameDataWriter gameDataWriter = new GameDataWriter();
        g.setGameId(gameDataWriter.getGameId());
        g.setUsername(p1.getUsername());
        g.setPlayerClass(valueclass);
        g.setRobot(valuerobot);
        g.setData_creazione(LocalDate.now());
        g.setOra_creazione(oraFormattata);

        System.out.println(g.getUsername() + " " + g.getGameId());

        gameDataWriter.saveGame(g);

        return ResponseEntity.ok("Oggetto creato con successo");

    }

    @PostMapping("/download")
    public ResponseEntity<Resource> downloadFile(@RequestParam("elementId") Integer elementId) {
        // Effettua la logica necessaria per ottenere il nome del file
        // a partire dall'elementId ricevuto, ad esempio, recuperandolo dal database
        System.out.println("elementId : " + elementId);
        String filename = hashMap.get(elementId);
        System.out.println("filename : " + filename);
        String basePath = "t5/src/main/resources/FolderTree/AUTName/AUTSourceCode/";
        String filePath = basePath + filename + ".java";
        System.out.println("filePath : " + filePath);
        Resource fileResource = new FileSystemResource(filePath);

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename + ".java");
        headers.add(HttpHeaders.CONTENT_TYPE, "application/octet-stream");

        return ResponseEntity.ok()
                .headers(headers)
                .body(fileResource);
    }

    @GetMapping("/change_password")
    public String showChangePasswordPage() {
        return "change_password";
    }
}

